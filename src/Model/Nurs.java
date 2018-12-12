/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Nurs {
    String fname;
    String lname;
    String mname;
    int uid;

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMname() {
        return mname;
    }

    public Nurs(String fname,String lname,String mname) {
        this.fname=fname;
        this.lname=lname;
        this.mname=mname;
    }
    public boolean insertNurs(){
        boolean res=false;
        try{
            Connection conn = null;
            PreparedStatement ps;
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            ps = conn.prepareStatement("INSERT INTO `nurselist`(`nurse_fname`, `nurse_lname`, `nurse_mi`, `user_id`) VALUES (?,?,?,?)");
            ps.setString(1, this.getFname());
            ps.setString(2, this.getLname());
            ps.setString(3, this.getMname());
            
            int i = ps.executeUpdate();
            res=true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        return res;
    }
}
