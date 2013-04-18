package fote.entry;

import java.util.ArrayList;
import java.util.Date;

/**
 * This class implements an Entry
 * @author Bob Nisco
 */
public class Proposal extends Entry {
    private String subject, description;
    private Integer priority, author;
    private ArrayList<String> options;
    private ArrayList<Integer> comments, attachments;
    private ArrayList<Vote> votes;
    private Date expirationDate;
    
    /**
     *
     */
    public Proposal() {
        this.expirationDate = new Date();
        this.subject = "";
        this.description = "";
        this.priority = -1;
        this.author = -1;
        this.options = new ArrayList<String>();
        this.votes = new ArrayList<Vote>();
        this.comments = new ArrayList<Integer>();
        this.attachments = new ArrayList<Integer>();
    }

    /**
     *
     * @param expirationDate
     * @param subject
     * @param description
     * @param priority
     * @param author
     * @param options
     * @param voteCount
     * @param comments
     * @param attachments
     */
    public Proposal(Date expirationDate, String subject, String description, 
            Integer priority, Integer author, ArrayList<String> options, 
            ArrayList<Vote> votes, ArrayList<Integer> comments, 
            ArrayList<Integer> attachments) {
        this.expirationDate = expirationDate;
        this.subject = subject;
        this.description = description;
        this.priority = priority;
        this.author = author;
        this.options = options;
        this.votes = votes;
        this.comments = comments;
        this.attachments = attachments;
    }
    
    public String getPriorityLevel(Integer level) {
        String result = "";
        if (level == 1) {
            result = "Backlog";
        } else if (level == 2) {
            result = "Low";
        } else if (level == 3) {
            result = "Moderate";
        } else if (level == 4) {
            result = "Important";
        } else if (level == 5) {
            result = "Urgent";
        }
        return result;
    }
    
    public Integer getPriorityLevel(String level) {
        Integer result = 0;
        level = level.toLowerCase();
        if (level .equals("backlog")) {
            result = 1;
        } else if (level.equals("low")) {
            result = 2;
        } else if (level.equals("moderate")) {
            result = 3;
        } else if (level.equals("important")) {
            result = 4;
        } else if (level.equals("urgent")) {
            result = 5;
        }
        return result;
    }

    /**
     *
     * @return the expiration date of this proposal
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    /**
     *
     * @return the subject of this proposal
     */
    public String getSubject() {
        return subject;
    }

    /**
     *
     * @return the description of this proposal
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return the priority of this proposal
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     *
     * @return an ArrayList of the options of this proposal
     */
    public ArrayList<String> getOptions() {
        return options;
    }

    /**
     *
     * @return an ArrayList of the votes of this proposal
     */
    public ArrayList<Vote> getVotes() {
        return votes;
    }

    /**
     *
     * @param expirationDate the new expirationDate value
     */
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    /**
     *
     * @param subject the new Subject value
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param priority the new priority value
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     *
     * @param options the new options
     */
    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    /**
     *
     * @param voteCount the new votes
     */
    public void setVotes(ArrayList<Vote> voteCount) {
        this.votes = voteCount;
    }

    /**
     *
     * @return the authorID of this proposal
     */
    public Integer getAuthor() {
        return author;
    }

    /**
     *
     * @param author the new Author ID
     */
    public void setAuthor(Integer author) {
        this.author = author;
    }

    /**
     *
     * @return an ArrayList of the commentIDs of this proposal
     */
    public ArrayList<Integer> getComments() {
        return comments;
    }

    /**
     *
     * @return an ArrayList of the attachmentIDs of this proposal
     */
    public ArrayList<Integer> getAttachments() {
        return attachments;
    }

    /**
     *
     * @param comments the new comments value
     */
    public void setComments(ArrayList<Integer> comments) {
        this.comments = comments;
    }

    /**
     *
     * @param attachments the new attachments value
     */
    public void setAttachments(ArrayList<Integer> attachments) {
        this.attachments = attachments;
    }
    
    /**
     *
     * @return a string representation of this Proposal
     */
    @Override
    public String toString() {
        String result = "Subject: " + this.getSubject() +
                " Description: " + this.getDescription() +
                " Priority: " + this.getPriority() +
                " AuthorID: " + this.getAuthor() +
                " ExpirateDate: " + this.getExpirationDate().toString() +
                " Options: ";
        for (String option : this.getOptions()) {
            result += option + ", ";
        }
        result += " VoteCountIDs: ";
        for (Vote vote : this.getVotes()) {
            result += vote.toString() + ", ";
        }
        result += " CommentIDs: ";
        for (Integer comment : this.getComments()) {
            result += comment + ", ";
        }
        result += " AttachmentIDs: ";
        for (Integer attachment : this.getAttachments()) {
            result += attachment + ", ";
        }
        return result;
    }
}
