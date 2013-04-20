package fote.controller;

import fote.FOTE;
import fote.entry.Comment;
import fote.entry.Suggestion;
import fote.model.UserModel;
import fote.util.MongoHelper;
import javax.swing.JOptionPane;

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
    
    public static boolean addComment(Suggestion sug, String commentText) {
        Comment comment = new Comment(commentText, FOTE.getUser().getId());
        MongoHelper.save(comment, "comments");
        comment = (Comment) MongoHelper.fetch(comment, "comments");
        sug.getComments().add(comment.getId());
        return MongoHelper.save(sug, "suggestions");
    }
}
