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
    
    /**
     *
     */
    public Suggestion() {
        super();
        this.subject = "";
        this.description = "";
        this.author = -1;
        this.comments = new ArrayList<Integer>();
        this.attachments = new ArrayList<Integer>();
    }
    
    /**
     *
     * @param subject
     * @param description
     * @param author
     * @param comments
     * @param attachments
     */
    public Suggestion(String subject, String description, Integer author,
            ArrayList<Integer> comments, ArrayList<Integer> attachments) {
        super();
        this.subject = subject;
        this.description = description;
        this.author = author;
        this.comments = comments;
        this.attachments = attachments;
    }

    /**
     *
     * @return the subject of this suggestion
     */
    public String getSubject() {
        return this.subject;
    }

    /**
     *
     * @return the description of this suggestion
     */
    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @param subject the new subject value
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     *
     * @param description the new description value
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return the authorID of this suggestion
     */
    public Integer getAuthor() {
        return author;
    }

    /**
     *
     * @param author the new AuthorID value
     */
    public void setAuthor(Integer author) {
        this.author = author;
    }

    /**
     *
     * @return an ArrayList of the commentIDs of this suggestion
     */
    public ArrayList<Integer> getComments() {
        return comments;
    }

    /**
     *
     * @return an ArrayList of the attachmentIDs of this suggestion
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
     * @return a string representation of this suggestion
     */
    @Override
    public String toString() {
        String result = "Subject: " + this.getSubject() +
                " Description: " + this.getDescription() +
                " AuthorID: " + this.getAuthor() +
                " CommentIDs: ";
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
