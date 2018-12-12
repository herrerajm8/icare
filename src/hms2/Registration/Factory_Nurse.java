/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms2.Registration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author student
 */
public class Factory_Nurse extends Factory_Users{
    
    
    @Override
    public Factory_Nurse createUsers(String fname, String lname, String mi, String spec, int id) {
        System.out.println("Nurse Created");
        
        Connection conn = null;
        String sql = "INSERT INTO nurselist(nurse_fname, nurse_lname, nurse_mi, user_id) VALUES (?, ?, ?, ?)";
        PreparedStatement pst=null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");

            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, mi);
            pst.setInt(4, id);
            

            int i = pst.executeUpdate();
            System.out.println("Added");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        
        return new Factory_Nurse();
    }
    
}
