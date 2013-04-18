/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fote.model;

import fote.entry.User;

/**
 *
 * @author Bob Nisco
 */
public class UserModel extends BaseModel {
    public UserModel() {
        super("users", User.class);
    }
}
