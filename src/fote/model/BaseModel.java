package fote.model;

import fote.entry.Entry;
import fote.util.MongoHelper;
import java.util.ArrayList;

/**
 *
 * @author Bob Nisco
 */
public abstract class BaseModel {

    private String document;
    private Class clss;
    
    public BaseModel(String doc, Class cls) {
        this.document = doc;
        this.clss = cls;
    }

    public Iterable<Entry> query(String queryString) {
        Iterable<Entry> resultSet = MongoHelper.query(queryString, clss, document);
        return resultSet;
    }
    
    public Iterable<Entry> query(String queryString, ArrayList<Integer> numbers) {
        Iterable<Entry> resultSet = MongoHelper.query(queryString, numbers, clss, document);
        return resultSet;
    }
}
