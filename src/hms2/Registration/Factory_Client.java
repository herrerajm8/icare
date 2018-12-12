/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Registration;

/**
 *
 * @author student
 */
public class Factory_Client {
    private static Factory_Client instance;
    
    public static synchronized Factory_Client instance(){
        if (instance == null) {
            instance = new Factory_Client();
        }
        return instance;
    }
    public void doCreate(String Username, String password, String fname, String lname, String mi, String utype, String spec) {
        switch(utype) 
        {
            case "Nurse":
                Factory_UserCreator.instance().registerUsers("Nurse", new Factory_Nurse());
                Factory_UserCreator.instance().createUsers("Nurse", Username, password, fname, lname, mi, spec);
                break;
            case "Doctor":
                Factory_UserCreator.instance().registerUsers("Doctor", new Factory_Doctor());
                Factory_UserCreator.instance().createUsers("Doctor", Username, password, fname, lname, mi, spec);
                break;
        }
        
        
        
        
    }
}
