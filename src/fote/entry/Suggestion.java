package fote.entry;

/**
 * This class implements a Suggestion
 * @author Bob Nisco
 */
public class Suggestion extends Entry {
    private String subject, description;
    private User author;
    
    public Suggestion() {
        super();
        this.subject = "";
        this.description = "";
        this.author = new User();
    }
    
    public Suggestion(String subject, String description, User author) {
        super();
        this.subject = subject;
        this.description = description;
        this.author = author;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
