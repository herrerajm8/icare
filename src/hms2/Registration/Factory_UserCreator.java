/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Registration;

import java.util.HashMap;

/**
 *
 * @author student
 */
public class Factory_UserCreator {
    private static Factory_UserCreator instance;
    private HashMap m_RegisteredProducts = new HashMap();
    
    private Factory_UserCreator() {}
    
    public static synchronized Factory_UserCreator instance(){
        if (instance == null) {
            instance = new Factory_UserCreator();
        }
        return instance;
    }
    
    public void registerUsers(String productID, Factory_Users productClass){
        m_RegisteredProducts.put(productID, productClass);
    }

    public void createUsers(String productID, String Username, String password, String fname, String lname, String mi, String spec){
        int id = ((Factory_Users)m_RegisteredProducts.get(productID)).createUserData(Username, password);
        ((Factory_Users)m_RegisteredProducts.get(productID)).createUsers(fname, lname, mi, spec, id);
        
    }

    
}
