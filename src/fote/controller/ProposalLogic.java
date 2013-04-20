/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fote.controller;

import fote.FOTE;
import fote.entry.Entry;
import fote.entry.Proposal;
import fote.entry.Vote;
import fote.model.UserModel;
import fote.model.VoteModel;
import fote.util.MongoHelper;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Jason
 */
public class ProposalLogic {
    //TODO Make this accept all the date shit too so that we can tell people they suck if they dont enter valid info
    public static boolean createProposal(Date expiration, String subject, String description, String priority, ArrayList<String> options){
        Integer priorityNum = Proposal.getPriorityLevel(priority);
        ArrayList<Vote> votes = new ArrayList<Vote>();
        ArrayList<Integer> comments = new ArrayList<Integer>();
        ArrayList<Integer> attachments = new ArrayList<Integer>();
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
    
    public static boolean isExpired(Proposal p) {
        Date now = new Date();
        return p.getExpirationDate().before(now);
    }
    
    public static void vote(Proposal proposal, int optionId) {
        Vote vote = new Vote(FOTE.getUser().getId(), optionId, proposal.getId());
        MongoHelper.save(vote, "votes");
        vote = (Vote) MongoHelper.fetch(vote, "votes");
        proposal.getVotes().add(vote);
        MongoHelper.save(proposal, "proposals");
    }
}

