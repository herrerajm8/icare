/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Administrator
 */
public class Medz {

    /**
     * @return the medID
     */
    public int getmedicine_id() {
        return medicine_id;
    }

    /**
     * @return the amt
     */
    public int getamount() {
        return amount;
    }

    /**
     * @return the remain
     */
    public int getremaining() {
        return remaining;
    }

    /**
     * @return the medName
     */
    public String getmedicine_name() {
        return medicine_name;
    }

    /**
     * @return the dosageForm
     */
    public String getdosageForm() {
        return dosageForm;
    }

    /**
     * @return the medDesc
     */
    public String getmedicine_desc() {
        return medicine_desc;
    }
    private int medicine_id;
    private int amount;
    private int remaining;
    private String medicine_name;
    private String dosageForm;
    private String medicine_desc;
    
    public Medz(int medicine_id,int amount,int remaining,String medicine_name,String dosageForm,String medicine_desc){
        this.medicine_id=medicine_id;
        this.amount=amount;
        this.remaining=remaining;
        this.medicine_name=medicine_name;
        this.dosageForm=dosageForm;
        this.medicine_desc=medicine_desc;
    }
}
