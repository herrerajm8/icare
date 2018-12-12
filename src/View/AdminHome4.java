/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.MainControl;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javaapplication100.DocList;
import javaapplication100.MedList;
import javaapplication100.NurList;
import javaapplication100.PatList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Administrator
 */
public class AdminHome4 extends javax.swing.JFrame {

    /**
     * Creates new form AdminHome4
     */
    public AdminHome4() {
        initComponents();
        show_meds();
        show_docs();
        show_nurse();
        show_pats();
    }

    
    public ArrayList<PatList> patList(){
        ArrayList<PatList> patList = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            String query4="SELECT * FROM patientrec";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query4);
            
            PatList pats;
            while(rs.next()){
                pats=new PatList(rs.getInt("patientID"),rs.getInt("patient_Age"),rs.getInt("room_No"),rs.getString("assignedDoctor"),rs.getString("patient_FirstName"),rs.getString("patient_LastName"),rs.getString("patient_MI"),rs.getString("diagnosis"),rs.getString("patient_Address"),rs.getString("gender"),rs.getString("date_Admitted"),rs.getString("date_Released"));
                patList.add(pats);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "User Authenticity Error: " + e.getMessage());
        }
        return patList;
    }
    
    public ArrayList<NurList> nurList(){
        ArrayList<NurList> nurList = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            String query4="SELECT * FROM nurselist";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query4);
            
            NurList nurs;
            while(rs.next()){
                nurs=new NurList(rs.getInt("nurse_id"),rs.getInt("user_id"),rs.getString("nurse_fname"),rs.getString("nurse_lname"),rs.getString("nurse_mi"));
                nurList.add(nurs);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "User Authenticity Error: " + e.getMessage());
        }
        return nurList;
    }
    
    public ArrayList<MedList> medList(){
        ArrayList<MedList> medList = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            String query4="SELECT * FROM medicinelist";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query4);
            
            MedList meds;
            while(rs.next()){
                meds=new MedList(rs.getInt("medicine_id"),rs.getInt("amount"),rs.getInt("remaining"),rs.getString("medicine_name"),rs.getString("dosageForm"),rs.getString("medicine_desc"));
                medList.add(meds);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "User Authenticity Error: " + e.getMessage());
        }
        return medList;
    }
    public ArrayList<DocList> docList(){
        ArrayList<DocList> docList = new ArrayList<>();
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            String query4="SELECT * FROM doctors";
            
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query4);
            
            DocList docs;
            while(rs.next()){
                docs=new DocList(rs.getInt("doctor_id"),rs.getInt("user_id"),rs.getString("doctor_fname"),rs.getString("doctor_lname"),rs.getString("doctor_mi"),rs.getString("specialization"));
                docList.add(docs);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "User Authenticity Error: " + e.getMessage());
        }
        return docList;
    }
     public void show_meds(){
         
        ArrayList<MedList> list1 = medList();
        DefaultTableModel model = (DefaultTableModel)medTable.getModel();
        Object[] row = new Object[10];
        model.setRowCount(0);
        for(int i=0; i<list1.size();i++){
            row[0]=list1.get(i).getmedicine_id();
            row[1]=list1.get(i).getmedicine_name();
            row[2]=list1.get(i).getdosageForm();
            row[3]=list1.get(i).getamount();
            row[4]=list1.get(i).getmedicine_desc();
            row[5]=list1.get(i).getremaining();
            model.addRow(row);
        }
    }
      public void show_pats(){
         
        ArrayList<PatList> list1 = patList();
        DefaultTableModel model = (DefaultTableModel)patTable.getModel();
        Object[] row = new Object[11];
        model.setRowCount(0);
        for(int i=0; i<list1.size();i++){
            row[0]=list1.get(i).getPat_id();
            row[1]=list1.get(i).getPat_fname();
            row[2]=list1.get(i).getPat_lname();
            row[3]=list1.get(i).getPat_mi();
            row[4]=list1.get(i).getDiagnosis();
            row[5]=list1.get(i).getPat_adr();
            row[6]=list1.get(i).getPat_age();
            row[7]=list1.get(i).getPat_gender();
            row[8]=list1.get(i).getPat_rn();
            row[9]=list1.get(i).getD_admitted();
            row[10]=list1.get(i).getD_released();
            model.addRow(row);
        }
    }
     public void show_docs(){
         
        ArrayList<DocList> list1 = docList();
        DefaultTableModel model = (DefaultTableModel)docTable.getModel();
        Object[] row = new Object[10];
        model.setRowCount(0);
        for(int i=0; i<list1.size();i++){
            row[0]=list1.get(i).getDoc_id();
            row[1]=list1.get(i).getF_name();
            row[2]=list1.get(i).getL_name();
            row[3]=list1.get(i).getM_name();
            row[4]=list1.get(i).getSpecialization();
            row[5]=list1.get(i).getU_id();
            model.addRow(row);
        }
    }
     public void show_nurse(){
         
        ArrayList<NurList> list1 = nurList();
        DefaultTableModel model = (DefaultTableModel)nurTable.getModel();
        Object[] row = new Object[10];
        model.setRowCount(0);
        for(int i=0; i<list1.size();i++){
            row[0]=list1.get(i).getNur_id();
            row[1]=list1.get(i).getF_name();
            row[2]=list1.get(i).getL_name();
            row[3]=list1.get(i).getM_name();
            row[5]=list1.get(i).getU_id();
            model.addRow(row);
        }
    }
     
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        medPane = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        dform1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        mcount1 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        mamount1 = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        mdesc1 = new javax.swing.JTextArea();
        jButton8 = new javax.swing.JButton();
        mname1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        medTable = new javax.swing.JTable();
        docPane = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        dlname = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        dspec = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        dmname = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        dfname = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        duid = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        docTable = new javax.swing.JTable();
        nurPane = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton13 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        nlname = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        nmname = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        nfname = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        nurTable = new javax.swing.JTable();
        patPane = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        patTable = new javax.swing.JTable();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setPreferredSize(new java.awt.Dimension(992, 608));
        jPanel2.setLayout(null);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton5.setText("Delete");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton5MouseEntered(evt);
            }
        });

        jLabel7.setText("Amount");

        jLabel8.setText("Remaining");

        jButton6.setText("Add");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton6MouseEntered(evt);
            }
        });

        jLabel9.setText("Medice Name");

        jLabel10.setText("Description");

        jButton7.setText("Clear");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        mdesc1.setColumns(20);
        mdesc1.setRows(5);
        jScrollPane6.setViewportView(mdesc1);

        jButton8.setText("Update");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        mname1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mname1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Dosage Form");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mname1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dform1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mamount1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mcount1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mname1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dform1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mamount1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(mcount1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        medTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Dosage Form", "Amount", "Description", "Remaining"
            }
        ));
        medTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(medTable);

        javax.swing.GroupLayout medPaneLayout = new javax.swing.GroupLayout(medPane);
        medPane.setLayout(medPaneLayout);
        medPaneLayout.setHorizontalGroup(
            medPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(medPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        medPaneLayout.setVerticalGroup(
            medPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, medPaneLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(medPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("Medicine", medPane);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton9.setText("Delete");
        jButton9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton9MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton9MouseEntered(evt);
            }
        });

        jLabel12.setText("Middle Initial");

        jLabel13.setText("Specialization");

        jButton10.setText("Add");
        jButton10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton10MouseEntered(evt);
            }
        });

        jLabel14.setText("Firstname");

        jButton11.setText("Clear");
        jButton11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton11MouseClicked(evt);
            }
        });

        jButton12.setText("Update");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton12MouseClicked(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        dfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dfnameActionPerformed(evt);
            }
        });

        jLabel15.setText("Lastname");

        jLabel19.setText("Id");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dfname, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlname, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dmname, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dspec, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duid, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dfname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dlname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dmname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(dspec, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(duid, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        docTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Middle Initial", "Specialization", "User ID"
            }
        ));
        docTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                docTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(docTable);

        javax.swing.GroupLayout docPaneLayout = new javax.swing.GroupLayout(docPane);
        docPane.setLayout(docPaneLayout);
        docPaneLayout.setHorizontalGroup(
            docPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(docPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        docPaneLayout.setVerticalGroup(
            docPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docPaneLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(docPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        jTabbedPane1.addTab("Doctor", docPane);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton13.setText("Delete");
        jButton13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton13MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton13MouseEntered(evt);
            }
        });

        jLabel16.setText("Middle Initial");

        jButton14.setText("Add");
        jButton14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton14MouseEntered(evt);
            }
        });

        jLabel17.setText("Firstname");

        jButton15.setText("Clear");
        jButton15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton15MouseClicked(evt);
            }
        });

        jButton16.setText("Update");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton16MouseClicked(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        nfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nfnameActionPerformed(evt);
            }
        });

        jLabel18.setText("Lastname");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nfname, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nlname, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nmname, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nfname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nlname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nmname, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(205, 205, 205)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        nurTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Firstname", "Lastname", "Middle Initial", "User ID"
            }
        ));
        nurTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nurTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(nurTable);

        javax.swing.GroupLayout nurPaneLayout = new javax.swing.GroupLayout(nurPane);
        nurPane.setLayout(nurPaneLayout);
        nurPaneLayout.setHorizontalGroup(
            nurPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nurPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        nurPaneLayout.setVerticalGroup(
            nurPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nurPaneLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(nurPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nurse", nurPane);

        patTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Firstname", "Lastname", "Middle Initial", "Diagnosis", "Address", "Age", "Gender", "Room No.", "Date Admitted", "Date Released"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        patTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(patTable);
        if (patTable.getColumnModel().getColumnCount() > 0) {
            patTable.getColumnModel().getColumn(0).setResizable(false);
            patTable.getColumnModel().getColumn(0).setPreferredWidth(5);
            patTable.getColumnModel().getColumn(1).setResizable(false);
            patTable.getColumnModel().getColumn(2).setResizable(false);
            patTable.getColumnModel().getColumn(3).setResizable(false);
            patTable.getColumnModel().getColumn(4).setResizable(false);
            patTable.getColumnModel().getColumn(5).setResizable(false);
            patTable.getColumnModel().getColumn(6).setResizable(false);
            patTable.getColumnModel().getColumn(6).setPreferredWidth(5);
            patTable.getColumnModel().getColumn(7).setResizable(false);
            patTable.getColumnModel().getColumn(7).setPreferredWidth(10);
            patTable.getColumnModel().getColumn(8).setResizable(false);
            patTable.getColumnModel().getColumn(8).setPreferredWidth(20);
            patTable.getColumnModel().getColumn(9).setResizable(false);
            patTable.getColumnModel().getColumn(10).setResizable(false);
        }

        jButton17.setText("Add");
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
        });

        jButton18.setText("Edit");
        jButton18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton18MouseClicked(evt);
            }
        });

        jButton19.setText("Delete");
        jButton19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout patPaneLayout = new javax.swing.GroupLayout(patPane);
        patPane.setLayout(patPaneLayout);
        patPaneLayout.setHorizontalGroup(
            patPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(patPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patPaneLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton17)
                        .addGap(18, 18, 18)
                        .addComponent(jButton18)
                        .addGap(18, 18, 18)
                        .addComponent(jButton19)))
                .addContainerGap())
        );
        patPaneLayout.setVerticalGroup(
            patPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, patPaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(patPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton17)
                    .addComponent(jButton18)
                    .addComponent(jButton19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Patient", patPane);

        jPanel2.add(jTabbedPane1);
        jTabbedPane1.setBounds(20, 50, 950, 540);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javaapplication100/img/adminbg1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 0, 990, 610);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
        int ii = medTable.getSelectedRow();
        TableModel model =  medTable.getModel();
        String mid = model.getValueAt(ii, 0).toString();
        Connection conn = null;
        ResultSet rs = null;
        try{
            String sql = "DELETE FROM `medicinelist` WHERE medicine_id=" +mid ;
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);

            int i = pst.executeUpdate();
            System.out.println("Deleted");
            show_meds();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseEntered

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
        // TODO add your handling code here:
        try{
            String mname = mname1.getText();
            String mdosage = dform1.getText();
            int mamount = Integer.parseInt(mamount1.getText());
            String mdesc = mdesc1.getText();
            int mcount = Integer.parseInt(mcount1.getText());
            
            MainControl mc = new MainControl();
            mc.addMed(mname, mdesc, mamount, mdesc, mcount);
            show_meds();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.getMessage());
        }
        
    }//GEN-LAST:event_jButton6MouseClicked

    private void jButton6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6MouseEntered

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        mname1.setText(null);
        dform1.setText(null);
        mdesc1.setText(null);
        mamount1.setText(null);
        mcount1.setText(null);
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:

        Connection conn = null;
        int ii = medTable.getSelectedRow();
        TableModel model =  medTable.getModel();

        String medname = mname1.getText();
        String meddform = dform1.getText();
        String medamount = mamount1.getText();
        String meddesc = mdesc1.getText();
        String medcount = mcount1.getText();
        String mid = model.getValueAt(ii, 0).toString();

        System.out.println("Medicine ID: " + mid);
        System.out.println("Medicine name: " + medname);
        System.out.println("Dosage form: " + meddform);
        System.out.println("Amount: " + medamount);
        System.out.println("description: " + meddesc);
        System.out.println("Item count: " + medcount);

        ResultSet rs = null;
        try{
            String sql = "UPDATE `medicinelist` SET `medicine_name`=?,`dosageForm`=?,`amount`=?,`medicine_desc`=?,`remaining`=? WHERE medicine_id=" +mid ;
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, medname);
            pst.setString(2, meddform);
            pst.setString(3, medamount);
            pst.setString(4, meddesc);
            pst.setString(5,  medcount);
            int i = pst.executeUpdate();
            //rs = pst.executeQuery();
            System.out.println("Updated");
            show_meds();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Medicine updated.");
            }else{
                JOptionPane.showMessageDialog(null, "Not updated.");
            }

        }catch(Exception e){

        }
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void mname1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mname1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mname1ActionPerformed

    private void medTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medTableMouseClicked
        // TODO add your handling code here:
        int i = medTable.getSelectedRow();
        TableModel model =  medTable.getModel();
        mname1.setText(model.getValueAt(i, 1).toString());
        dform1.setText(model.getValueAt(i, 2).toString());
        mamount1.setText(model.getValueAt(i, 3).toString());
        mcount1.setText(model.getValueAt(i, 5).toString());
        mdesc1.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_medTableMouseClicked

    private void jButton9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseClicked
        // TODO add your handling code here:
        int ii = docTable.getSelectedRow();
        TableModel model =  docTable.getModel();
        String docid = model.getValueAt(ii, 0).toString();
        Connection conn = null;
        ResultSet rs = null;
        try{
            String sql = "DELETE FROM `doctors` WHERE doctor_id=" +docid ;
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);

            int i = pst.executeUpdate();
            System.out.println("Deleted");
            show_docs();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton9MouseClicked

    private void jButton9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9MouseEntered

    private void jButton10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseClicked
        // TODO add your handling code here:
        
        try{
            String fname = dfname.getText();
            String lname = dlname.getText();
            String mname = dmname.getText();
            String special = dspec.getText();
            int uid = Integer.parseInt(duid.getText());
            MainControl mc = new MainControl();
            mc.addDoc(fname, lname, mname, special, uid);
            show_docs();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton10MouseClicked

    private void jButton10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10MouseEntered

    private void jButton11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton11MouseClicked
        // TODO add your handling code here:
        dfname.setText(null);
        dlname.setText(null);
        dmname.setText(null);
        dspec.setText(null);
    }//GEN-LAST:event_jButton11MouseClicked

    private void jButton12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseClicked
        // TODO add your handling code here:
        Connection conn = null;
        int ii = docTable.getSelectedRow();
        TableModel model =  docTable.getModel();

        String df = dfname.getText();
        String dm = dmname.getText();
        String dl = dlname.getText();
        String ds = dspec.getText();
        String docid = model.getValueAt(ii, 0).toString();

        System.out.println("Doctor ID: " + docid);
        System.out.println("Doctor Firstname: " + df);
        System.out.println("Doctor Middle Initial: " + dm);
        System.out.println("Doctor Latname: " + dl);
        System.out.println("Specialization: " + ds);

        ResultSet rs = null;
        try{
            String sql = "UPDATE `doctors` SET `doctor_fname`=?,`doctor_lname`=?,`doctor_mi`=?,`specialization`=? WHERE doctor_id=" +docid;
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, df);
            pst.setString(2, dl);
            pst.setString(3, dm);
            pst.setString(4, ds);

            int i = pst.executeUpdate();
            //rs = pst.executeQuery();
            System.out.println("Updated");
            show_docs();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Medicine updated.");
            }else{
                JOptionPane.showMessageDialog(null, "Not updated.");
            }

        }catch(Exception e){

        }

    }//GEN-LAST:event_jButton12MouseClicked

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void dfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dfnameActionPerformed

    private void docTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_docTableMouseClicked
        // TODO add your handling code here:
        int i = docTable.getSelectedRow();
        TableModel model =  docTable.getModel();
        dfname.setText(model.getValueAt(i, 1).toString());
        dlname.setText(model.getValueAt(i, 2).toString());
        dmname.setText(model.getValueAt(i, 3).toString());
        dspec.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_docTableMouseClicked

    private void jButton13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseClicked
        // TODO add your handling code here:

        int ii = nurTable.getSelectedRow();
        TableModel model =  nurTable.getModel();
        String nid = model.getValueAt(ii, 0).toString();
        Connection conn = null;
        ResultSet rs = null;
        try{
            String sql = "DELETE FROM `nurselist` WHERE nurse_id=" +nid ;
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);

            int i = pst.executeUpdate();
            System.out.println("Deleted");
            show_nurse();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton13MouseClicked

    private void jButton13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13MouseEntered

    private void jButton14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseClicked
        // TODO add your handling code here:
        
        try{
            String fname = nfname.getText();
            String lname = nlname.getText();
            String mname = nmname.getText();
            MainControl mc = new MainControl();
            mc.addNur(fname, lname, mname);
            show_nurse();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }

    }//GEN-LAST:event_jButton14MouseClicked

    private void jButton14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton14MouseEntered

    private void jButton15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton15MouseClicked
        // TODO add your handling code here:
        nfname.setText(null);
        nlname.setText(null);
        nmname.setText(null);

    }//GEN-LAST:event_jButton15MouseClicked

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked
        // TODO add your handling code here:
        Connection conn = null;
        int ii = nurTable.getSelectedRow();
        TableModel model =  nurTable.getModel();

        String nf = nfname.getText();
        String nl = nlname.getText();
        String nm = nmname.getText();
        String nid = model.getValueAt(ii, 0).toString();

        System.out.println("Nurse ID: " + nid);
        System.out.println("Nurse Firstname: " + nf);
        System.out.println("Nurse Middle Initial: " + nm);
        System.out.println("Nurse Lastname: " + nl);

        ResultSet rs = null;
        try{
            String sql = "UPDATE `nurselist` SET `nurse_fname`=?,`nurse_lname`=?,`nurse_mi`=? WHERE nurse_id=" +nid   ;
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);

            pst.setString(1, nf);
            pst.setString(2, nl);
            pst.setString(3, nm);

            int i = pst.executeUpdate();
            //rs = pst.executeQuery();
            System.out.println("Updated");
            show_nurse();
            if(rs.next()){
                JOptionPane.showMessageDialog(null, "Medicine updated.");
            }else{
                JOptionPane.showMessageDialog(null, "Not updated.");
            }

        }catch(Exception e){

        }
    }//GEN-LAST:event_jButton16MouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton16ActionPerformed

    private void nfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nfnameActionPerformed

    private void nurTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nurTableMouseClicked
        // TODO add your handling code here:
        int i = nurTable.getSelectedRow();
        TableModel model =  nurTable.getModel();
        nfname.setText(model.getValueAt(i, 1).toString());
        nlname.setText(model.getValueAt(i, 2).toString());
        nmname.setText(model.getValueAt(i, 3).toString());
    }//GEN-LAST:event_nurTableMouseClicked

    private void jButton19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton19MouseClicked
        // TODO add your handling code here:
        int ii = patTable.getSelectedRow();
        TableModel model =  patTable.getModel();
        String nid = model.getValueAt(ii, 0).toString();
        Connection conn = null;
        ResultSet rs = null;
        try{
            String sql = "DELETE FROM `patientrec` WHERE patientID=" +nid ;
            Class.forName("com.mysql.jdbc.Driver");
            conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/icaredb?zeroDateTimeBehavior=exception","root","");
            PreparedStatement pst = (PreparedStatement) conn.prepareStatement(sql);

            int i = pst.executeUpdate();
            System.out.println("Deleted");
            show_pats();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton19MouseClicked

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        // TODO add your handling code here:
        new addPat().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton17MouseClicked

    private void patTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patTableMouseClicked
        // TODO add your handling code here:
        int i = patTable.getSelectedRow();
        TableModel model =  patTable.getModel();
        mname1.setText(model.getValueAt(i, 1).toString());
        dform1.setText(model.getValueAt(i, 2).toString());
        mamount1.setText(model.getValueAt(i, 3).toString());
        mcount1.setText(model.getValueAt(i, 5).toString());
        mdesc1.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_patTableMouseClicked

    private void jButton18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton18MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new addPat().setVisible(true);
    }//GEN-LAST:event_jButton18MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminHome4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome4().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dfname;
    private javax.swing.JTextField dform1;
    private javax.swing.JTextField dlname;
    private javax.swing.JTextField dmname;
    private javax.swing.JPanel docPane;
    private javax.swing.JTable docTable;
    private javax.swing.JTextField dspec;
    private javax.swing.JTextField duid;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField mamount1;
    private javax.swing.JTextField mcount1;
    private javax.swing.JTextArea mdesc1;
    private javax.swing.JPanel medPane;
    private javax.swing.JTable medTable;
    private javax.swing.JTextField mname1;
    private javax.swing.JTextField nfname;
    private javax.swing.JTextField nlname;
    private javax.swing.JTextField nmname;
    private javax.swing.JPanel nurPane;
    private javax.swing.JTable nurTable;
    private javax.swing.JPanel patPane;
    private javax.swing.JTable patTable;
    // End of variables declaration//GEN-END:variables
}
