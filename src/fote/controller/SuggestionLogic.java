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
 * This class handles logic for suggestions, such as creating, 
 * updating, and deleting.
 * @author Bob Nisco
 */
public class SuggestionLogic {
    /**
     * Create a suggestion and attempt to save it to Mongo
     * @param subject
     * @param description
     * @return if the entry was successfully saved to Mongo
     */
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
    /**
     * Check for empty fields and a valid author
     * @param s
     * @return whether or not the suggestion is valid
     */
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
    /**
     * 
     * @param s
     * @return a list of comments found for the suggestion
     */
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
    /**
     * Add a comment to the suggestion object and save it to Mongo
     * @param sug
     * @param commentText
     * @return whether or not the entry was successfully savd to Mongo
     */
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
    /**
     * 
     * @param suggestion
     * @param subject
     * @param description
     * @return whether or not the update was successful
     */
    public static boolean updateSuggestion(Suggestion suggestion, String subject, String description) {
        suggestion.setSubject(subject);
        suggestion.setDescription(description);
        return MongoHelper.save(suggestion, "suggestions");
    }
    /**
     * Remove the entry from Mongo only if the user is the owner
     * @param s
     * @return whether or not the entry was deleted
     */
    public static boolean deleteSuggestion(Suggestion s) {
        if (FOTE.getUser().getId() != s.getAuthor()) {
            return false;
        } else {
            return MongoHelper.delete(s, "suggestions");
        }
    }
}
