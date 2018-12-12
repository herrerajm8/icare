/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Leo James
 */
public class User {
    private int patientID,assignedDoctor,patient_Age,room_No;
    private String patient_FirstName,patient_LastName,patient_MI,diagnosis,patient_Address,gender;
    SimpleDateFormat admit = new SimpleDateFormat("E yyyy/mm/dd HH-mm-ss");
    Date date_Admitted;
    
    
    public User(int patientID,int assignedDoctor,String patient_FirstName,String patient_LastName,String patient_MI,String diagnosis,String patient_Address,int patient_Age,String gender,int room_No,Date date_Admitted){
        this.patientID=patientID;
        this.assignedDoctor=assignedDoctor;
        this.patient_FirstName=patient_FirstName;
        this.patient_LastName=patient_LastName;
        this.patient_MI=patient_MI;
        this.diagnosis=diagnosis;
        this.patient_Address=patient_Address;
        this.patient_Age=patient_Age;
        this.gender=gender;
        this.room_No=room_No;
        this.date_Admitted=date_Admitted;
    }
    public int getpatientID(){
        return patientID;
    }
    public int getassignedDoctor(){
        return assignedDoctor;
    }
    public String getpatient_FirstName(){
        return patient_FirstName;
    }
    public String getpatient_LastName(){
        return patient_LastName;
    }
    public String getpatient_MI(){
        return patient_MI;
    }
    public String getdiagnosis(){
        return diagnosis;
    }
    public String getpatient_Address(){
        return patient_Address;
    }
    public int getpatient_Age(){
        return patient_Age;
    }
    public String getgender(){
        return gender;
    }
    public int getroom_No(){
        return room_No;
    }
    public Date getdate_Admitted(){
        
        return date_Admitted;
    }
}
