/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication100;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "patientrec", catalog = "icaredb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Patientrec.findAll", query = "SELECT p FROM Patientrec p")
    , @NamedQuery(name = "Patientrec.findByPatientID", query = "SELECT p FROM Patientrec p WHERE p.patientID = :patientID")
    , @NamedQuery(name = "Patientrec.findByAssignedDoctor", query = "SELECT p FROM Patientrec p WHERE p.assignedDoctor = :assignedDoctor")
    , @NamedQuery(name = "Patientrec.findByPatientFirstName", query = "SELECT p FROM Patientrec p WHERE p.patientFirstName = :patientFirstName")
    , @NamedQuery(name = "Patientrec.findByPatientLastName", query = "SELECT p FROM Patientrec p WHERE p.patientLastName = :patientLastName")
    , @NamedQuery(name = "Patientrec.findByPatientMI", query = "SELECT p FROM Patientrec p WHERE p.patientMI = :patientMI")
    , @NamedQuery(name = "Patientrec.findByDiagnosis", query = "SELECT p FROM Patientrec p WHERE p.diagnosis = :diagnosis")
    , @NamedQuery(name = "Patientrec.findByPatientAddress", query = "SELECT p FROM Patientrec p WHERE p.patientAddress = :patientAddress")
    , @NamedQuery(name = "Patientrec.findByPatientAge", query = "SELECT p FROM Patientrec p WHERE p.patientAge = :patientAge")
    , @NamedQuery(name = "Patientrec.findByGender", query = "SELECT p FROM Patientrec p WHERE p.gender = :gender")
    , @NamedQuery(name = "Patientrec.findByRoomNo", query = "SELECT p FROM Patientrec p WHERE p.roomNo = :roomNo")
    , @NamedQuery(name = "Patientrec.findByDateAdmitted", query = "SELECT p FROM Patientrec p WHERE p.dateAdmitted = :dateAdmitted")
    , @NamedQuery(name = "Patientrec.findByDateReleased", query = "SELECT p FROM Patientrec p WHERE p.dateReleased = :dateReleased")})
public class Patientrec implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patientID")
    private Integer patientID;
    @Column(name = "assignedDoctor")
    private Integer assignedDoctor;
    @Basic(optional = false)
    @Column(name = "patient_FirstName")
    private String patientFirstName;
    @Basic(optional = false)
    @Column(name = "patient_LastName")
    private String patientLastName;
    @Column(name = "patient_MI")
    private String patientMI;
    @Basic(optional = false)
    @Column(name = "diagnosis")
    private String diagnosis;
    @Basic(optional = false)
    @Column(name = "patient_Address")
    private String patientAddress;
    @Basic(optional = false)
    @Column(name = "patient_Age")
    private int patientAge;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "room_No")
    private int roomNo;
    @Basic(optional = false)
    @Column(name = "date_Admitted")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdmitted;
    @Column(name = "date_Released")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReleased;

    public Patientrec() {
    }

    public Patientrec(Integer patientID) {
        this.patientID = patientID;
    }

    public Patientrec(Integer patientID, String patientFirstName, String patientLastName, String diagnosis, String patientAddress, int patientAge, String gender, int roomNo, Date dateAdmitted) {
        this.patientID = patientID;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.diagnosis = diagnosis;
        this.patientAddress = patientAddress;
        this.patientAge = patientAge;
        this.gender = gender;
        this.roomNo = roomNo;
        this.dateAdmitted = dateAdmitted;
    }

    public Integer getPatientID() {
        return patientID;
    }

    public void setPatientID(Integer patientID) {
        Integer oldPatientID = this.patientID;
        this.patientID = patientID;
        changeSupport.firePropertyChange("patientID", oldPatientID, patientID);
    }

    public Integer getAssignedDoctor() {
        return assignedDoctor;
    }

    public void setAssignedDoctor(Integer assignedDoctor) {
        Integer oldAssignedDoctor = this.assignedDoctor;
        this.assignedDoctor = assignedDoctor;
        changeSupport.firePropertyChange("assignedDoctor", oldAssignedDoctor, assignedDoctor);
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        String oldPatientFirstName = this.patientFirstName;
        this.patientFirstName = patientFirstName;
        changeSupport.firePropertyChange("patientFirstName", oldPatientFirstName, patientFirstName);
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        String oldPatientLastName = this.patientLastName;
        this.patientLastName = patientLastName;
        changeSupport.firePropertyChange("patientLastName", oldPatientLastName, patientLastName);
    }

    public String getPatientMI() {
        return patientMI;
    }

    public void setPatientMI(String patientMI) {
        String oldPatientMI = this.patientMI;
        this.patientMI = patientMI;
        changeSupport.firePropertyChange("patientMI", oldPatientMI, patientMI);
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        String oldDiagnosis = this.diagnosis;
        this.diagnosis = diagnosis;
        changeSupport.firePropertyChange("diagnosis", oldDiagnosis, diagnosis);
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        String oldPatientAddress = this.patientAddress;
        this.patientAddress = patientAddress;
        changeSupport.firePropertyChange("patientAddress", oldPatientAddress, patientAddress);
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        int oldPatientAge = this.patientAge;
        this.patientAge = patientAge;
        changeSupport.firePropertyChange("patientAge", oldPatientAge, patientAge);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        int oldRoomNo = this.roomNo;
        this.roomNo = roomNo;
        changeSupport.firePropertyChange("roomNo", oldRoomNo, roomNo);
    }

    public Date getDateAdmitted() {
        return dateAdmitted;
    }

    public void setDateAdmitted(Date dateAdmitted) {
        Date oldDateAdmitted = this.dateAdmitted;
        this.dateAdmitted = dateAdmitted;
        changeSupport.firePropertyChange("dateAdmitted", oldDateAdmitted, dateAdmitted);
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(Date dateReleased) {
        Date oldDateReleased = this.dateReleased;
        this.dateReleased = dateReleased;
        changeSupport.firePropertyChange("dateReleased", oldDateReleased, dateReleased);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientID != null ? patientID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patientrec)) {
            return false;
        }
        Patientrec other = (Patientrec) object;
        if ((this.patientID == null && other.patientID != null) || (this.patientID != null && !this.patientID.equals(other.patientID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication100.Patientrec[ patientID=" + patientID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
