/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Leo James
 */
public class Docz {

    /**
     * @return the doctor_id
     */
    public int getDoctor_id() {
        return doctor_id;
    }

    /**
     * @param doctor_id the doctor_id to set
     */
    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @return the doctor_fname
     */
    public String getDoctor_fname() {
        return doctor_fname;
    }

    /**
     * @return the doctor_lname
     */
    public String getDoctor_lname() {
        return doctor_lname;
    }

    /**
     * @return the doctor_mi
     */
    public String getDoctor_mi() {
        return doctor_mi;
    }

    /**
     * @return the specialization
     */
    public String getSpecialization() {
        return specialization;
    }
    private int doctor_id;
    private int user_id;
    private String doctor_lname;
    private String doctor_fname;
    private String doctor_mi;
    private String specialization;
    
    public Docz(int doctor_id,int user_id,String doctor_lname,String doctor_fname,String doctor_mi,String specialization){
        this.doctor_id=doctor_id;
        this.user_id=user_id;
        this.doctor_lname=doctor_lname;
        this.doctor_fname=doctor_fname;
        this.doctor_mi=doctor_mi;
        this.specialization=specialization;
    }
}
