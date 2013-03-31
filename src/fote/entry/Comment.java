package fote.entry;

/**
 * This class implements a Comment
 * @author Bob Nisco
 */
public class Comment extends Entry {
    private String text;
    private Integer author;
    
    /**
     *
     */
    public Comment() {
        super();
        this.text = "";
        this.author = -1;
    }

    /**
     *
     * @param text the text of this comment
     * @param author the integer representation of the author of this comment
     */
    public Comment(String text, Integer author) {
        super();
        this.text = text;
        this.author = author;
    }

    /**
     * 
     * @return the text of this comment
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @return the authorID of this comment
     */
    public Integer getAuthor() {
        return author;
    }

    /**
     *
     * @param text text that this text should be set to
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     *
     * @param author integer representation of the author which you are setting
     */
    public void setAuthor(Integer author) {
        this.author = author;
    }
    
    /**
     *
     * @returna a string representation of this comment
     */
    @Override
    public String toString() {
        return "Text: " + this.getText() +
               " AuthorID: " + this.getAuthor();
    }
}
