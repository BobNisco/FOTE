package fote.model;

import fote.entry.Suggestion;

/**
 *
 * @author Bob Nisco
 */
public class SuggestionModel extends BaseModel {
    public SuggestionModel() {
        super("suggestions", Suggestion.class);
    }
}
