/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication100;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "medicinelist", catalog = "icaredb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Medicinelist.findAll", query = "SELECT m FROM Medicinelist m")
    , @NamedQuery(name = "Medicinelist.findByMedicineId", query = "SELECT m FROM Medicinelist m WHERE m.medicineId = :medicineId")
    , @NamedQuery(name = "Medicinelist.findByMedicineName", query = "SELECT m FROM Medicinelist m WHERE m.medicineName = :medicineName")
    , @NamedQuery(name = "Medicinelist.findByDosageForm", query = "SELECT m FROM Medicinelist m WHERE m.dosageForm = :dosageForm")
    , @NamedQuery(name = "Medicinelist.findByAmount", query = "SELECT m FROM Medicinelist m WHERE m.amount = :amount")
    , @NamedQuery(name = "Medicinelist.findByMedicineDesc", query = "SELECT m FROM Medicinelist m WHERE m.medicineDesc = :medicineDesc")
    , @NamedQuery(name = "Medicinelist.findByRemaining", query = "SELECT m FROM Medicinelist m WHERE m.remaining = :remaining")})
public class Medicinelist implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medicine_id")
    private Integer medicineId;
    @Basic(optional = false)
    @Column(name = "medicine_name")
    private String medicineName;
    @Basic(optional = false)
    @Column(name = "dosageForm")
    private String dosageForm;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @Column(name = "medicine_desc")
    private String medicineDesc;
    @Column(name = "remaining")
    private Integer remaining;

    public Medicinelist() {
    }

    public Medicinelist(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public Medicinelist(Integer medicineId, String medicineName, String dosageForm, int amount) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.dosageForm = dosageForm;
        this.amount = amount;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        Integer oldMedicineId = this.medicineId;
        this.medicineId = medicineId;
        changeSupport.firePropertyChange("medicineId", oldMedicineId, medicineId);
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        String oldMedicineName = this.medicineName;
        this.medicineName = medicineName;
        changeSupport.firePropertyChange("medicineName", oldMedicineName, medicineName);
    }

    public String getDosageForm() {
        return dosageForm;
    }

    public void setDosageForm(String dosageForm) {
        String oldDosageForm = this.dosageForm;
        this.dosageForm = dosageForm;
        changeSupport.firePropertyChange("dosageForm", oldDosageForm, dosageForm);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        int oldAmount = this.amount;
        this.amount = amount;
        changeSupport.firePropertyChange("amount", oldAmount, amount);
    }

    public String getMedicineDesc() {
        return medicineDesc;
    }

    public void setMedicineDesc(String medicineDesc) {
        String oldMedicineDesc = this.medicineDesc;
        this.medicineDesc = medicineDesc;
        changeSupport.firePropertyChange("medicineDesc", oldMedicineDesc, medicineDesc);
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        Integer oldRemaining = this.remaining;
        this.remaining = remaining;
        changeSupport.firePropertyChange("remaining", oldRemaining, remaining);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicineId != null ? medicineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medicinelist)) {
            return false;
        }
        Medicinelist other = (Medicinelist) object;
        if ((this.medicineId == null && other.medicineId != null) || (this.medicineId != null && !this.medicineId.equals(other.medicineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication100.Medicinelist[ medicineId=" + medicineId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
