/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication100;

/**
 *
 * @author Administrator
 */
public class PatList {

    public int getPat_id() {
        return pat_id;
    }

    public int getPat_age() {
        return pat_age;
    }

    public int getPat_rn() {
        return pat_rn;
    }

    public String getAss_doc() {
        return ass_doc;
    }

    public String getPat_fname() {
        return pat_fname;
    }

    public String getPat_lname() {
        return pat_lname;
    }

    public String getPat_mi() {
        return pat_mi;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public String getPat_adr() {
        return pat_adr;
    }

    public String getPat_gender() {
        return pat_gender;
    }

    public String getD_admitted() {
        return d_admitted;
    }

    public String getD_released() {
        return d_released;
    }

    


    
    private int pat_id;
    private int pat_age;
    private int pat_rn;
    private String ass_doc;
    private String pat_fname;
    private String pat_lname;
    private String pat_mi;
    private String diagnosis;
    private String pat_adr;
    private String pat_gender;
    private String d_admitted;
    private String d_released;
    public PatList(int pat_id,int pat_age,int pat_rn,String ass_doc,String pat_fname,String pat_lname,String pat_mi,String diagnosis,String pat_adr,String pat_gender,String p_admitted,String p_released){
        this.pat_id=pat_id;
        this.pat_age=pat_age;
        this.ass_doc=ass_doc;
        this.pat_fname=pat_fname;
        this.pat_lname=pat_lname;
        this.pat_mi=pat_mi;
        this.d_admitted=d_admitted;
        this.d_released=d_released;
    }
}
