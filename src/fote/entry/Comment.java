package fote.entry;

/**
 * This class implements a Comment
 * @author Bob Nisco
 */
public class Comment extends Entry {
    private String text;
    private User author;
    
    public Comment() {
        super();
        this.text = "";
        this.author = new User();
    }

    public Comment(String text, User author) {
        super();
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public User getAuthor() {
        return author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
