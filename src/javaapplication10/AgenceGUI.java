/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication10;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nada haninou
 */
public class AgenceGUI extends javax.swing.JFrame {

    /**
     * Creates new form AgenceGUI
     */
    public AgenceGUI() {
        initComponents();
        tablemodele=(DefaultTableModel)TableVehicules.getModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBoxVehicule = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableVehicules = new javax.swing.JTable();
        Filter = new javax.swing.JComboBox<>();
        FilterValue = new javax.swing.JTextField();
        Applyfilter = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBoxVehicule.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Camionnette", "Minibus", "Voiture", " " }));

        TableVehicules.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Marque", "Modele", "Reference", "Couleur", "Charge", "NbPlaces"
            }
        ));
        jScrollPane1.setViewportView(TableVehicules);

        jScrollPane2.setViewportView(jScrollPane1);

        Filter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Marque", "Modele", "Reference", "Couleur", "NbPlaces", "Charge" }));

        Applyfilter.setText("Apply");
        Applyfilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyfilterActionPerformed(evt);
            }
        });

        jButton1.setText("Ajouter Vehicule");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(Filter, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxVehicule, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(FilterValue, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(Applyfilter))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jComboBoxVehicule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FilterValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Applyfilter))
                .addGap(65, 65, 65)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ApplyfilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyfilterActionPerformed
        tablemodele.setRowCount(0);
        switch(jComboBoxVehicule.getSelectedItem().toString()){
            case "Voiture":
            {
                try {
                    voiture();
                } catch (SQLException ex) {
                    Logger.getLogger(AgenceGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

            case "Camionnette":
            {
                try {
                    Camionnette();
                } catch (SQLException ex) {
                    Logger.getLogger(AgenceGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case "Minibus":
            {
                try {
                    Minibus();
                } catch (SQLException ex) {
                    Logger.getLogger(AgenceGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
            
    }//GEN-LAST:event_ApplyfilterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFrameX myFrame = new JFrameX();
        myFrame.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(AgenceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgenceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgenceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgenceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgenceGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Applyfilter;
    private javax.swing.JComboBox<String> Filter;
    private javax.swing.JTextField FilterValue;
    private javax.swing.JTable TableVehicules;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBoxVehicule;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void voiture() throws SQLException {
        AdministationVoiture admin= new AdministationVoiture();
        DefaultTableModel tablemodele=(DefaultTableModel)TableVehicules.getModel();
        LinkedList<Voiture> voitures;
        switch(Filter.getSelectedItem().toString()){
            
          case "Modele": 
                        voitures=admin.RecherchParModele(FilterValue.getText());
                        

                         String[][] table= new String[voitures.size()][6];
                         
                         for (int i=0;i<voitures.size();i++){
                             table[i][0]=voitures.get(i).getMarque();
                             table[i][1]=voitures.get(i).getModele();
                             table[i][2]=voitures.get(i).getRef();
                             table[i][3]=voitures.get(i).getCouleur();
                             table[i][4]="";
                             table[i][5]="";
                             
                             tablemodele.addRow(table[i]);
                             
                         }
                         break;
           case "Marque": 
                        voitures=admin.RecherchParMarque(FilterValue.getText());
                        

                         String[][] tablee= new String[voitures.size()][6];
                         
                         for (int i=0;i<voitures.size();i++){
                             tablee[i][0]=voitures.get(i).getMarque();
                             tablee[i][1]=voitures.get(i).getModele();
                             tablee[i][2]=voitures.get(i).getRef();
                             tablee[i][3]=voitures.get(i).getCouleur();
                             tablee[i][4]="";
                             tablee[i][5]="";
                             
                             tablemodele.addRow(tablee[i]);
                             
                         }
                         break;
            case "Reference": 
                        Voiture v=admin.RecherchParReference(FilterValue.getText());
                        

                         String[] tableee= new String[6];
                         
                         
                             tableee[0]=v.getMarque();
                             tableee[1]=v.getModele();
                             tableee[2]=v.getRef();
                             tableee[3]=v.getCouleur();
                             tableee[4]="";
                             tableee[5]="";
                             
                             tablemodele.addRow(tableee);
                             
                         
                         break;
            case "Couleur": 
                        voitures=admin.RecherchParCouleur(FilterValue.getText());
                        

                         String[][] tableeee= new String[voitures.size()][6];
                         
                         for (int i=0;i<voitures.size();i++){
                             tableeee[i][0]=voitures.get(i).getMarque();
                             tableeee[i][1]=voitures.get(i).getModele();
                             tableeee[i][2]=voitures.get(i).getRef();
                             tableeee[i][3]=voitures.get(i).getCouleur();
                             tableeee[i][4]="";
                             tableeee[i][5]="";
                             
                             tablemodele.addRow(tableeee[i]);
                             
                         }
                         
                             
                             
                            
                             
                         
                         break;
          
                      
      }
    }

    private void Camionnette() throws SQLException {
        AdministrationCamionette admin= new AdministrationCamionette();
        DefaultTableModel tablemodele=(DefaultTableModel)TableVehicules.getModel();
        LinkedList<Camionnette> Camionnettes;
        switch(Filter.getSelectedItem().toString()){
            
          case "Modele": 
                        Camionnettes=admin.RecherchParModele(FilterValue.getText());
                        

                         String[][] table= new String[Camionnettes.size()][6];
                         
                         for (int i=0;i<Camionnettes.size();i++){
                             table[i][0]=Camionnettes.get(i).getMarque();
                             table[i][1]=Camionnettes.get(i).getModele();
                             table[i][2]=Camionnettes.get(i).getRef();
                             table[i][3]=Camionnettes.get(i).getCouleur();
                             table[i][4]=String.valueOf(Camionnettes.get(i).getChargeMax());
                             
                             //table[i][4]=Camionnettes.get(i).getChargeMax();
                             table[i][5]="";
                             
                             tablemodele.addRow(table[i]);
                             
                         }
                         break;
           case "Marque": 
                        Camionnettes=admin.RecherchParMarque(FilterValue.getText());
                        

                         String[][] tablee= new String[Camionnettes.size()][6];
                         
                         for (int i=0;i<Camionnettes.size();i++){
                             tablee[i][0]=Camionnettes.get(i).getMarque();
                             tablee[i][1]=Camionnettes.get(i).getModele();
                             tablee[i][2]=Camionnettes.get(i).getRef();
                             tablee[i][3]=Camionnettes.get(i).getCouleur();
                             tablee[i][4]=String.valueOf(Camionnettes.get(i).getChargeMax());
                             tablee[i][5]="";
                             
                             tablemodele.addRow(tablee[i]);
                             
                         }
                         break;
            case "Reference": 
                        Camionnette v=admin.RecherchParReference(FilterValue.getText());
                        

                         String[] tableee= new String[6];
                         
                         
                             tableee[0]=v.getMarque();
                             tableee[1]=v.getModele();
                             tableee[2]=v.getRef();
                             tableee[3]=v.getCouleur();
                             tableee[4]=String.valueOf(v.getChargeMax());
                             tableee[5]="";
                             
                             tablemodele.addRow(tableee);
                             
                         
                         break;
            case "Couleur": 
                        Camionnettes=admin.RecherchParCouleur(FilterValue.getText());
                        

                         String[][] tableeee= new String[Camionnettes.size()][6];
                         
                         for (int i=0;i<Camionnettes.size();i++){
                             tableeee[i][0]=Camionnettes.get(i).getMarque();
                             tableeee[i][1]=Camionnettes.get(i).getModele();
                             tableeee[i][2]=Camionnettes.get(i).getRef();
                             tableeee[i][3]=Camionnettes.get(i).getCouleur();
                             tableeee[i][4]=String.valueOf(Camionnettes.get(i).getChargeMax());
                             tableeee[i][5]="";
                             
                             tablemodele.addRow(tableeee[i]);
                             
                         }
                         
                             
                             
                            
                             
                         
                         break;
            case "Charge": 
                        Camionnettes=admin.RecherchParChargeMax(Double.parseDouble(FilterValue.getText()));
                        

                         String[][] tabler= new String[Camionnettes.size()][6];
                         
                         for (int i=0;i<Camionnettes.size();i++){
                             tabler[i][0]=Camionnettes.get(i).getMarque();
                             tabler[i][1]=Camionnettes.get(i).getModele();
                             tabler[i][2]=Camionnettes.get(i).getRef();
                             tabler[i][3]=Camionnettes.get(i).getCouleur();
                             tabler[i][4]=String.valueOf(Camionnettes.get(i).getChargeMax());
                             
                             //table[i][4]=Camionnettes.get(i).getChargeMax();
                             tabler[i][5]="";
                             
                             tablemodele.addRow(tabler[i]);
                             
                         }
                         break;
          
                      
      }
    }

    private void Minibus() throws SQLException {
        AdministrationiMiniBus admin= new AdministrationiMiniBus();
        DefaultTableModel tablemodele=(DefaultTableModel)TableVehicules.getModel();
        LinkedList<MiniBus> Minibus;
        switch(Filter.getSelectedItem().toString()){
            
          case "Modele": 
                        Minibus=admin.RecherchParModele(FilterValue.getText());
                        

                         String[][] table= new String[Minibus.size()][6];
                         
                         for (int i=0;i<Minibus.size();i++){
                             table[i][0]=Minibus.get(i).getMarque();
                             table[i][1]=Minibus.get(i).getModele();
                             table[i][2]=Minibus.get(i).getRef();
                             table[i][3]=Minibus.get(i).getCouleur();
                             table[i][4]="";
                             
                             
                             table[i][5]=String.valueOf(Minibus.get(i).getNombrePlaces());
                             
                             tablemodele.addRow(table[i]);
                             
                         }
                         break;
           case "Marque": 
                        Minibus=admin.RecherchParMarque(FilterValue.getText());
                        

                         String[][] tablee= new String[Minibus.size()][6];
                         
                         for (int i=0;i<Minibus.size();i++){
                             tablee[i][0]=Minibus.get(i).getMarque();
                             tablee[i][1]=Minibus.get(i).getModele();
                             tablee[i][2]=Minibus.get(i).getRef();
                             tablee[i][3]=Minibus.get(i).getCouleur();
                             tablee[i][4]="";
                             tablee[i][5]=String.valueOf(Minibus.get(i).getNombrePlaces());
                             
                             tablemodele.addRow(tablee[i]);
                             
                         }
                         break;
            case "Reference": 
                        MiniBus v=admin.RecherchParReference(FilterValue.getText());
                        

                         String[] tableee= new String[6];
                         
                         
                             tableee[0]=v.getMarque();
                             tableee[1]=v.getModele();
                             tableee[2]=v.getRef();
                             tableee[3]=v.getCouleur();
                             tableee[4]="";
                             tableee[5]=String.valueOf(v.getNombrePlaces());
                             
                             tablemodele.addRow(tableee);
                             
                         
                         break;
            case "Couleur": 
                        Minibus=admin.RecherchParCouleur(FilterValue.getText());
                        

                         String[][] tableeee= new String[Minibus.size()][6];
                         
                         for (int i=0;i<Minibus.size();i++){
                             tableeee[i][0]=Minibus.get(i).getMarque();
                             tableeee[i][1]=Minibus.get(i).getModele();
                             tableeee[i][2]=Minibus.get(i).getRef();
                             tableeee[i][3]=Minibus.get(i).getCouleur();
                             tableeee[i][4]="";
                             tableeee[i][5]=String.valueOf(Minibus.get(i).getNombrePlaces());
                             
                             tablemodele.addRow(tableeee[i]);
                             
                         }
                         
                             
                             
                            
                             
                         
                         break;
            case "NbPlaces": 
                        Minibus=admin.RecherchParnombredeplace(Integer.parseInt(FilterValue.getText()));
                        

                        String[][] tablerr= new String[Minibus.size()][6];
                         
                         for (int i=0;i<Minibus.size();i++){
                             tablerr[i][0]=Minibus.get(i).getMarque();
                             tablerr[i][1]=Minibus.get(i).getModele();
                             tablerr[i][2]=Minibus.get(i).getRef();
                             tablerr[i][3]=Minibus.get(i).getCouleur();
                             tablerr[i][4]="";
                             
                             
                             tablerr[i][5]=String.valueOf(Minibus.get(i).getNombrePlaces());
                             
                             tablemodele.addRow(tablerr[i]);
                             
                         }
                         break;
          
    }}
    DefaultTableModel tablemodele;
}