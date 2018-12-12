/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JOptionPane;
import Model.*;
/**
 *
 * @author Administrator
 */
public class MainControl {
    private boolean res;

    public boolean isRes() {
        return res;
    }

    public void setRes(boolean res) {
        this.res = res;
    }

    public Meds getMed() {
        return med;
    }

    public void setMed(Meds med) {
        this.med = med;
    }

    public Docs getDoc() {
        return doc;
    }

    public void setDoc(Docs doc) {
        this.doc = doc;
    }

    public Nurs getNur() {
        return nur;
    }

    public void setNur(Nurs nur) {
        this.nur = nur;
    }

    public Pats getPat() {
        return pat;
    }

    public void setPat(Pats pat) {
        this.pat = pat;
    }
    private Meds med;
    private Docs doc;
    private Nurs nur;
    private Pats pat;

    public MainControl() {
    }
    
    public void addMed(String mname,String dform,int amount, String descrption, int count){
        try{
            this.setMed(new Meds(mname, dform, amount, descrption, count));
            setRes(getMed().insertMed());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    public void addDoc(String fname,String lname,String mname,String special,int uid){
         try{
            this.setDoc(new Docs(fname, lname, mname, special, uid));
            setRes(getDoc().isnertDoc());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
    }
    public void addNur(String fname,String lname,String mname){
        try{
            this.setNur(new Nurs(fname, lname, mname));
            setRes(getNur().insertNurs());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());       
    }
    }
    public void addPats(String adoctor,String fname,String lname,String mname,String diag,String padd,int page,String gender,int rn,String det){
        try{
            this.setPat(new Pats(adoctor, fname, lname, mname, diag, padd, page, gender, rn,det));
            setRes(getPat().insertPats());
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());       
    }
    }
}
