package fote.entry;

/**
 * This class implements a Comment
 * @author Bob Nisco
 */
public class Comment extends Entry {
    private String text;
    private Integer author;
    
    public Comment() {
        super();
        this.text = "";
        this.author = -1;
    }

    public Comment(String text, Integer author) {
        super();
        this.text = text;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public Integer getAuthor() {
        return author;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }
}
