package fote.controller;

import fote.FOTE;
import fote.entry.Suggestion;
import fote.model.UserModel;
import fote.util.MongoHelper;

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
        if (!UserModel.isValidUser(s.getAuthor())) {
            return false;
        }
        return true;
    }
}
