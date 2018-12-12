/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Registration;

import hms2.Login.LoginUserPass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public abstract class Factory_Users {
    public abstract Factory_Users createUsers(String fname, String lname, String mi, String spec, int id);
    
    public int createUserData(String uname, String pword) {
        int res = -1;
        Connection conn = null;
        String sql = "INSERT INTO users(username, password, isAdmin) VALUES (?, ?, 0)";
        PreparedStatement pst=null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");

            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, uname);
            pst.setString(2, pword);
            

            int i = pst.executeUpdate();
            System.out.println(i);
            System.out.println("Added");
            res = LoginUserPass.instance().userPass(uname, pword);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return res;
    }
    
    
    
}
