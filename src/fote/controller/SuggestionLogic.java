package fote.controller;

import fote.FOTE;
import fote.entry.Comment;
import fote.entry.Entry;
import fote.entry.Suggestion;
import fote.model.CommentModel;
import fote.model.UserModel;
import fote.util.MongoHelper;
import java.util.ArrayList;

/**
 *
 * @author Bob Nisco
 */
public class SuggestionLogic {
    public static boolean createSuggestion(String subject, String description) {
        Suggestion suggestion = new Suggestion();
        suggestion.setSubject(subject);
        suggestion.setDescription(description);
        suggestion.setAuthor(FOTE.getUser().getId());
        
        if (isValidSuggestion(suggestion)) {
            if (MongoHelper.save(suggestion, "suggestions")) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public static boolean isValidSuggestion(Suggestion s) {
        if (s.getSubject().isEmpty()) {
            return false;
        }
        if (s.getDescription().isEmpty()) {
            return false;
        }
        if (!UserModel.isValidUser(s.getAuthor())) {
            return false;
        }
        System.out.println("This is a valid suggestion");
        return true;
    }
    
    public static ArrayList<Comment> getComments(Suggestion s){
        ArrayList<Comment> comments = new ArrayList<Comment>();
        CommentModel commentModel = new CommentModel();
        Iterable<Entry> commentsQuery = commentModel.query("{id:{$in:#}}", s.getComments());
        
        for (Entry entry : commentsQuery){
            Comment comment = (Comment) entry;
            comments.add(comment);
        }
        return comments;
    }
    
    public static boolean addComment(Suggestion sug, String commentText) {
        if (commentText.trim().length() > 0) {
            Comment comment = new Comment(commentText, FOTE.getUser().getId());
            MongoHelper.save(comment, "comments");
            comment = (Comment) MongoHelper.fetch(comment, "comments");
            sug.getComments().add(comment.getId());
            return MongoHelper.save(sug, "suggestions");
        } else {
            return false;
        }
    }
}
