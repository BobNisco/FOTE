package fote.entry;

/**
 * This class implements a vote
 * @author Bob Nisco
 */
public class Vote extends Entry {
    private Integer userID, optionID, proposalID;
    
    /**
     *
     */
    public Vote() {
        this.userID = -1;
        this.optionID = -1;
        this.proposalID = -1;
    }

    /**
     *
     * @param userID
     * @param optionID
     * @param proposalID
     */
    public Vote(Integer userID, Integer optionID, Integer proposalID) {
        this.userID = userID;
        this.optionID = optionID;
        this.proposalID = proposalID;
    }

    /**
     *
     * @return the userID of this vote
     */
    public Integer getUserID() {
        return userID;
    }

    /**
     *
     * @return the optionID of this vote
     */
    public Integer getOptionID() {
        return optionID;
    }

    /**
     *
     * @return the proposalId of this vote
     */
    public Integer getProposalID() {
        return proposalID;
    }

    /**
     *
     * @param userID the new userID value
     */
    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    /**
     *
     * @param optionID the new optionID value
     */
    public void setOptionID(Integer optionID) {
        this.optionID = optionID;
    }

    /**
     *
     * @param proposalID the new proposalID value
     */
    public void setProposalID(Integer proposalID) {
        this.proposalID = proposalID;
    }
    
    /**
     * 
     * @return a string representation of this vote
     */
    @Override
    public String toString() {
        return "UserID: " + this.getUserID() +
               " OptionID: " + this.getOptionID() +
               " ProposalID: " + this.getProposalID();
    }
}
