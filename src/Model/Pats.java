/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.AdminHome4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class Pats {
    
    

    public String getAdoctor() {
        return adoctor;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getMname() {
        return mname;
    }

    public String getDiag() {
        return diag;
    }

    public String getPadd() {
        return padd;
    }

    public int getPage() {
        return page;
    }

    public String getGender() {
        return gender;
    }

    public int getRn() {
        return rn;
    }
    String adoctor;
    String fname;
    String lname;
    String mname;
    String diag;
    String padd;
    int page;
    String gender;
    String det;

    public String getDet() {
        return det;
    }
    int rn;
    public Pats(String adoctor,String fname,String lname,String mname,String diag,String padd,int page,String gender,int rn,String det) {
        this.adoctor=adoctor;
        this.fname=fname;
        this.lname=lname;
        this.mname=mname;
        this.diag=diag;
        this.padd=padd;
        this.page=page;
        this.gender=gender;
        this.rn=rn;
        this.det=det;
    }
    
    public boolean insertPats(){
        boolean res=false;
        try{
            Connection conn = null;
            PreparedStatement ps;
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            ps = conn.prepareStatement("INSERT INTO `patientrec`(`patient_FirstName`, `patient_LastName`, `patient_MI`, `diagnosis`, `patient_Address`, `patient_Age`, `gender`, `room_No`, `date_Admitted`) VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, this.getFname());
            ps.setString(2, this.getLname());
            ps.setString(3, this.getMname());
            ps.setString(4, this.getDiag());
            ps.setString(5, this.getPadd());
            ps.setInt(6, this.getPage());
            ps.setString(7, this.getGender());
            ps.setInt(8, this.getRn());
            ps.setString(9, this.getDet());
            int i = ps.executeUpdate();
            res=true;
            new AdminHome4().setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        return res;
    }
}
