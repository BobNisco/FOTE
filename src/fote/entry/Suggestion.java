package fote.entry;

import java.util.ArrayList;

/**
 * This class implements a Suggestion
 * @author Bob Nisco
 */
public class Suggestion extends Entry {
    private String subject, description;
    private Integer author;
    private ArrayList<Integer> comments, attachments;
    
    public Suggestion() {
        super();
        this.subject = "";
        this.description = "";
        this.author = -1;
        this.comments = new ArrayList<Integer>();
        this.attachments = new ArrayList<Integer>();
    }
    
    public Suggestion(String subject, String description, Integer author,
            ArrayList<Integer> comments, ArrayList<Integer> attachments) {
        super();
        this.subject = subject;
        this.description = description;
        this.author = author;
        this.comments = comments;
        this.attachments = attachments;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getDescription() {
        return this.description;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
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
