package fote.entry;

/**
 * This class implements an Attachment
 * @author Bob Nisco
 */
public class Attachment extends Entry {
    private User owner;
    private String fileName;
    
    public Attachment() {
        this.owner = new User();
        this.fileName = "";
    }

    public Attachment(User owner, String fileName) {
        this.owner = owner;
        this.fileName = fileName;
    }

    public User getOwner() {
        return owner;
    }

    public String getFileName() {
        return fileName;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
