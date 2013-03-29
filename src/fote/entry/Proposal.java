package fote.entry;

/**
 * This class implements an Entry
 * @author Bob Nisco
 */
public class Proposal extends Entry {
    private String expirationDate, subject, description;
    private int priority;
    private String[] options;
    private int[] voteCount;
    
    public Proposal() {
        this.expirationDate = "";
        this.subject = "";
        this.description = "";
        this.priority = 0;
        this.options = new String[5];
        this.voteCount = new int[5];
    }

    public Proposal(String expirationDate, String subject, String description, int priority, String[] options, int[] voteCount) {
        this.expirationDate = expirationDate;
        this.subject = subject;
        this.description = description;
        this.priority = priority;
        this.options = options;
        this.voteCount = voteCount;
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

    public int getPriority() {
        return priority;
    }

    public String[] getOptions() {
        return options;
    }

    public int[] getVoteCount() {
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

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public void setVoteCount(int[] voteCount) {
        this.voteCount = voteCount;
    }
}
