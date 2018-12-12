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
public class Meds {

    public String getMname() {
        return mname;
    }

    public String getDform() {
        return dform;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public int getCount() {
        return count;
    }
    private String mname;
    private String dform;
    private String description;
    private int amount;
    private int count;
    public Meds(String mname,String dform,int amount, String description, int count) {
        this.mname = mname;
        this.dform = dform;
        this.description = description;
        this.count = count;
        this.amount = amount;
    }
    
    public boolean insertMed(){
        boolean res = false;
        try{
            Connection conn = null;
            PreparedStatement ps;
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            ps = conn.prepareStatement("INSERT INTO `medicinelist`(`medicine_name`, `dosageForm`, `amount`, `medicine_desc`, `remaining`) VALUES (?,?,?,?,?)");
            ps.setString(1, this.getMname());
            ps.setString(2, this.dform);
            ps.setInt(3, this.getAmount());
            ps.setString(4, this.getDescription());
            ps.setInt(5, this.getCount());
            
            int i = ps.executeUpdate();
            
            res = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        return res;
    }
    
}
