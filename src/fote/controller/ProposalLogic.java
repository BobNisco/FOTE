package fote.controller;

import fote.FOTE;
import fote.entry.Comment;
import fote.entry.Entry;
import fote.entry.Proposal;
import fote.entry.Vote;
import fote.model.CommentModel;
import fote.model.UserModel;
import fote.model.VoteModel;
import fote.util.MongoHelper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Jason
 */
public class ProposalLogic {

    /**
     *
     * @param expiration the expiration date of the proposal
     * @param subject the subject of the proposal
     * @param description the description of the proposal
     * @param priority the priority of the proposal
     * @param options the voting options for the proposal
     * @return whether or not the proposal was successfully created or not
     */
    public static boolean createProposal(Date expiration, String subject, String description, String priority, ArrayList<String> options) {
        Integer priorityNum = Proposal.getPriorityLevel(priority);
        ArrayList<Integer> votes = new ArrayList<Integer>();
        ArrayList<Integer> comments = new ArrayList<Integer>();
        ArrayList<String> attachments = new ArrayList<String>();
        int userID = FOTE.getUser().getId();
        Proposal proposal = new Proposal(expiration, subject, description, priorityNum, new Integer(userID), options, votes, comments, attachments);
        if (isValidProposal(proposal)) {
            if (MongoHelper.save(proposal, "proposals")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    /**
     *
     * @param p The proposal we wish to update
     * @return whether or not updating the proposal was successful
     */
    public static boolean updateProposal(Proposal p) {
        if (MongoHelper.query("{id:" + p.getId() + "}", Proposal.class, "proposals").iterator().hasNext()) {
            if (MongoHelper.save(p, "proposals")) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param p The proposal we wish to see if is valid
     * @return whether the proposal is valid
     */
    public static boolean isValidProposal(Proposal p) {
        if (p.getSubject().isEmpty()) {
            return false;
        }
        if (p.getDescription().isEmpty()) {
            return false;
        }
        if (!UserModel.isValidUser(p.getAuthor())) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param p The proposal we wish to see if is expired
     * @return whether the proposal is expired or not
     */
    public static boolean isExpired(Proposal p) {
        Date now = new Date();
        return p.getExpirationDate().before(now);
    }

    /**
     * *
     *
     * @param p The proposal we wish to get comments from
     * @return an arraylist of comments that belongs to the proposal
     */
    public static ArrayList<Comment> getComments(Proposal p) {
        ArrayList<Comment> comments = new ArrayList<Comment>();
        CommentModel commentModel = new CommentModel();
        Iterable<Entry> commentsQuery = commentModel.query("{id:{$in:#}}", p.getComments());

        for (Entry entry : commentsQuery) {
            Comment comment = (Comment) entry;
            comments.add(comment);
        }
        return comments;
    }

    /**
     *
     * @param proposal The proposal we wish to get add comments to
     * @param commentText The comment text
     * @return whether or not adding the comment was successful
     */
    public static boolean addComment(Proposal proposal, String commentText) {
        if (commentText.trim().length() > 0) {
            Comment comment = new Comment(commentText, FOTE.getUser().getId());
            MongoHelper.save(comment, "comments");
            comment = (Comment) MongoHelper.fetch(comment, "comments");
            proposal.getComments().add(comment.getId());
            return MongoHelper.save(proposal, "proposals");
        } else {
            return false;
        }
    }

    /**
     *
     * @param proposal The proposal we wish to vote on
     * @param optionId The option selected for the vote
     * @return whether or not the vote was successful
     */
    public static boolean vote(Proposal proposal, int optionId) {
        Vote vote = new Vote(FOTE.getUser().getId(), optionId, proposal.getId());
        VoteModel voteModel = new VoteModel();

        // Try to find a vote already made by this user for this proposal
        Iterable<Entry> voteQuery = voteModel.query("{userID: " + vote.getUserID()
                + ",proposalID: " + vote.getProposalID() + "}");
        // If a vote is found remove it from the DB and the object
        if (voteQuery.iterator().hasNext()) {
            Vote deleteVote = (Vote) voteQuery.iterator().next();
            //deleteVote = (Vote) voteModel.get(deleteVote);
            MongoHelper.delete(deleteVote, "votes");
            System.out.println("PREVIOUS VOTE DELETED!");
            for (Integer i : proposal.getVotes()) {
                Vote v = (Vote) voteModel.get(i);
                if (v != null) {
                    System.out.println(v);
                    if (v.getProposalID() == deleteVote.getProposalID()
                            && v.getUserID() == deleteVote.getUserID()) {
                        deleteVote = v;
                    }
                }
            }
            proposal.getVotes().remove(deleteVote);
        }
        // Otherwise we just add the vote to the DB and object
        if (MongoHelper.save(vote, "votes")) {
            vote = (Vote) MongoHelper.fetch(vote, "votes");
            proposal.getVotes().add(vote.getId());
            if (MongoHelper.save(proposal, "proposals")) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param proposal The proposal we wish generate the winning vote from
     * @return The string option of the winning vote
     */
    public static String getWinningVote(Proposal proposal) {
        // Create an index of options -> numVotes
        Map<Integer, Integer> voteCount = new HashMap<Integer, Integer>();
        System.out.println(proposal);
        VoteModel voteModel = new VoteModel();
        for (Integer i : proposal.getVotes()) {
            Vote vote = (Vote) voteModel.get(i);
            System.out.println(vote.toString());
            if (voteCount.containsKey(vote.getOptionID())) {
                Integer num = voteCount.get(vote.getOptionID());
                voteCount.put(vote.getOptionID(), new Integer(++num));
            } else {
                voteCount.put(vote.getOptionID(), new Integer(1));
            }
        }
        if (!voteCount.isEmpty()) {
            System.out.println("Vote count is empty");
            Integer max = new Integer(voteCount.get(voteCount.keySet().iterator().next()));

            // Loop through the index and find which key has the highest value
            for (Integer option : voteCount.keySet()) {
                System.out.println("option: " + option + " max: " + max);
                System.out.println(voteCount.get(option));
                System.out.println(voteCount.get(max));
                if (voteCount.get(max) == null || (int) voteCount.get(option) > (int) voteCount.get(max)) {
                    max = option;
                }
            }
            return proposal.getOptions().get(max);
        }
        return "None";
    }

    /**
     *
     * @param proposal The proposal we wish to get the vote summary of
     * @return An arraylist of strings that represents voting options and their
     * count
     */
    public static ArrayList<String> getVoteSummary(Proposal proposal) {
        // Create an index of options -> numVotes
        Map<Integer, Integer> voteCount = new HashMap<Integer, Integer>();
        VoteModel voteModel = new VoteModel();

        for (Integer i : proposal.getVotes()) {
            Vote vote = (Vote) voteModel.get(i);
            if (voteCount.containsKey(vote.getOptionID())) {
                Integer num = voteCount.get(vote.getOptionID());
                voteCount.put(vote.getOptionID(), new Integer(++num));
            } else {
                voteCount.put(vote.getOptionID(), new Integer(1));
            }
        }

        ArrayList<String> results = new ArrayList<String>();

        // Loop through the index and find which key has the highest value
        for (Integer option : voteCount.keySet()) {
            results.add(proposal.getOptions().get(option) + " had " + voteCount.get(option) + " votes");
        }
        return results;
    }

    /**
     *
     * @param p The proposal we wish to delete
     * @return whether or not the deletion of the proposal was successful
     */
    public static boolean deleteProposal(Proposal p) {
        if (FOTE.getUser().getId() != p.getAuthor()) {
            return false;
        } else {
            return MongoHelper.delete(p, "proposals");
        }
    }
}
