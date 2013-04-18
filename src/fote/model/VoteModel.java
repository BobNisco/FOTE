package fote.model;

import fote.entry.Vote;

/**
 *
 * @author Bob Nisco
 */
public class VoteModel extends BaseModel {
    public VoteModel() {
        super("votes", Vote.class);
    }
}
