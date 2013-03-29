package fote.entry;

import java.util.ArrayList;

/**
 * This class implements an Entry
 * @author Bob Nisco
 */
public class Proposal extends Entry {
    private String expirationDate, subject, description;
    private Integer priority, author;
    private ArrayList<String> options;
    private ArrayList<Integer> voteCount, comments, attachments;
    
    public Proposal() {
        this.expirationDate = "";
        this.subject = "";
        this.description = "";
        this.priority = 0;
        this.author = -1;
        this.options = new ArrayList<String>();
        this.voteCount = new ArrayList<Integer>();
        this.comments = new ArrayList<Integer>();
        this.attachments = new ArrayList<Integer>();
    }

    public Proposal(String expirationDate, String subject, String description, 
            Integer priority, Integer author, ArrayList<String> options, 
            ArrayList<Integer> voteCount, ArrayList<Integer> comments, 
            ArrayList<Integer> attachments) {
        this.expirationDate = expirationDate;
        this.subject = subject;
        this.description = description;
        this.priority = priority;
        this.author = author;
        this.options = options;
        this.voteCount = voteCount;
        this.comments = comments;
        this.attachments = attachments;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPriority() {
        return priority;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public ArrayList<Integer> getVoteCount() {
        return voteCount;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public void setVoteCount(ArrayList<Integer> voteCount) {
        this.voteCount = voteCount;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public ArrayList<Integer> getComments() {
        return comments;
    }

    public ArrayList<Integer> getAttachments() {
        return attachments;
    }

    public void setComments(ArrayList<Integer> comments) {
        this.comments = comments;
    }

    public void setAttachments(ArrayList<Integer> attachments) {
        this.attachments = attachments;
    }
}
