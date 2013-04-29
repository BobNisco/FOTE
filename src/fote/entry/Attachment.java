package fote.entry;

/**
 * This class implements an Attachment
 * @author Bob Nisco
 */
public class Attachment extends Entry {
    private Integer owner;
    private String fileName;
    
    /**
     *
     */
    public Attachment() {
        this.owner = -1;
        this.fileName = "";
    }

    /**
     *
     * @param owner id representation of the owner of this attachment
     * @param fileName the fileName in which to save
     */
    public Attachment(Integer owner, String fileName) {
        this.owner = owner;
        this.fileName = fileName;
    }

    /**
     * 
     * @return an Integer representation of the owner
     */
    public Integer getOwner() {
        return owner;
    }

    /**
     * 
     * @return the fileName of this attachment
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 
     * @param owner id representation of the owner
     */
    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    /**
     * 
     * @param fileName the new fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    
    /**
     * 
     * @return a string representation of this instance of attachment
     */
    @Override
    public String toString() {
        return "OwnerID: " + this.getOwner() +
               " FileName: " + this.getFileName();
    }
}
