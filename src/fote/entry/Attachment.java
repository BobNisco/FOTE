package fote.entry;

/**
 * This class implements an Attachment
 * @author Bob Nisco
 */
public class Attachment extends Entry {
    private Integer owner;
    private String fileName;
    
    public Attachment() {
        this.owner = -1;
        this.fileName = "";
    }

    public Attachment(Integer owner, String fileName) {
        this.owner = owner;
        this.fileName = fileName;
    }

    public Integer getOwner() {
        return owner;
    }

    public String getFileName() {
        return fileName;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
