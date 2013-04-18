package fote.model;

import fote.entry.Comment;

/**
 *
 * @author Bob Nisco
 */
public class CommentModel extends BaseModel {
    public CommentModel() {
        super("comments", Comment.class);
    }
}
