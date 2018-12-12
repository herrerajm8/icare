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
public class Factory_Doctor extends Factory_Users{

    
    
    @Override
    public Factory_Doctor createUsers(String fname, String lname, String mi, String spec, int id) {
        System.out.println("Doctor created");
        
        Connection conn = null;
        String sql = "INSERT INTO doctors(doctor_fname, doctor_lname, doctor_mi, specialization, user_id) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement pst=null;
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");

            pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, fname);
            pst.setString(2, lname);
            pst.setString(3, mi);
            pst.setString(4, spec);
            pst.setInt(5, id);
            
            int i = pst.executeUpdate();
            System.out.println("Added");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
        return new Factory_Doctor();
    }
    
}
