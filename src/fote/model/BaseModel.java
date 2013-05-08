package fote.model;

import fote.entry.Entry;
import fote.util.MongoHelper;
import java.util.ArrayList;

/**
 * This class allows for simpler and uniform querying methods by calling
 * its subclasses which do not require the mongo collection name.
 * 
 * @author Bob Nisco
 */
public abstract class BaseModel {

    private String document;
    private Class clss;
    
    /**
     * 
     * @param doc The name of the Mongo collection
     * @param cls The class type that results will be found as
     */
    public BaseModel(String doc, Class cls) {
        this.document = doc;
        this.clss = cls;
    }

    /**
     * 
     * @param queryString JSON representation of the object
     * @return an Iterable set of matching entries
     */
    public Iterable<Entry> query(String queryString) {
        Iterable<Entry> resultSet = MongoHelper.query(queryString, clss, document);
        return resultSet;
    }
    
    /**
     * 
     * @param queryString JSON representation of the object
     * @param numbers limit the results set
     * @return an iterable result set of matching entries
     */
    public Iterable<Entry> query(String queryString, ArrayList<Integer> numbers) {
        Iterable<Entry> resultSet = MongoHelper.query(queryString, numbers, clss, document);
        return resultSet;
    }
    
    public Entry get(Integer id) {
        Iterable<Entry> resultSet = MongoHelper.query("{id:" + id + "}", clss, document);
        if (resultSet.iterator().hasNext()) {
            return resultSet.iterator().next();
        }
        return null;
    }
}
