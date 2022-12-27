/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package crudmahasiswasederhana.views;

import crudmahasiswasederhana.interfc.MahasiswaInterface;
import crudmahasiswasederhana.models.Mahasiswa;
import crudmahasiswasederhana.models.MahasiswaController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class MahasiswaFrame extends javax.swing.JFrame {

    List<Mahasiswa> record = new ArrayList<Mahasiswa>();
    MahasiswaInterface mhsServis;
    int row;
    public MahasiswaFrame() {
        initComponents();
        mhsServis = new MahasiswaController();
        
        MahasiswaTabel.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            
          @Override
            public void valueChanged(ListSelectionEvent e) {
                row = MahasiswaTabel.getSelectedRow();
                if(row!=-1){
                    isiText();
                }
            }
        });
        this.statusAwal();
    }

     void loadData(){
            try{
                record = mhsServis.getAll();
            }catch (SQLException ex){
                Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
         void isiTabel(){
            Object data[][]=new Object [record.size()][3];
            int x = 0;
            for(Mahasiswa mhs:record){
                data[x][0]=mhs.getNim();
                data[x][1]=mhs.getNama();
                data[x][2]=mhs.getAlamat();
                x++;
            }
            String judul[]={"nim", "nama", "alamat"};
            MahasiswaTabel.setModel(new DefaultTableModel(data, judul));
            jScrollPane1.setViewportView(MahasiswaTabel);
        }
         
        void isiText(){
            Mahasiswa mhs=record.get(row);
            NimTextField.setText((String) mhs.getNim());
            NamaTextField.setText((String) mhs.getNama());
            AlamatTextField.setText((String) mhs.getAlamat());
         }
        
        void kosongkanText(){
            NimTextField.setText("");
            NamaTextField.setText("");
            AlamatTextField.setText("");
        }
        
        void statusAwal(){
            kosongkanText();
            loadData();
            isiTabel();      
        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NimLabel = new javax.swing.JLabel();
        NamaLabel = new javax.swing.JLabel();
        AlamatLabel = new javax.swing.JLabel();
        NimTextField = new javax.swing.JTextField();
        NamaTextField = new javax.swing.JTextField();
        AlamatTextField = new javax.swing.JTextField();
        TambahButton = new javax.swing.JButton();
        UbahButton = new javax.swing.JButton();
        HapusButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MahasiswaTabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NimLabel.setText("Nim");

        NamaLabel.setText("Nama");

        AlamatLabel.setText("Alamat");

        NimTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NimTextFieldActionPerformed(evt);
            }
        });

        NamaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaTextFieldActionPerformed(evt);
            }
        });

        AlamatTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AlamatTextFieldActionPerformed(evt);
            }
        });

        TambahButton.setText("Tambah");
        TambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahButtonActionPerformed(evt);
            }
        });

        UbahButton.setText("Ubah");
        UbahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbahButtonActionPerformed(evt);
            }
        });

        HapusButton.setText("Hapus");
        HapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusButtonActionPerformed(evt);
            }
        });

        MahasiswaTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(MahasiswaTabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(TambahButton)
                .addGap(53, 53, 53)
                .addComponent(UbahButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(HapusButton)
                .addGap(30, 30, 30))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NimLabel)
                            .addComponent(NamaLabel)
                            .addComponent(AlamatLabel))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NimTextField)
                            .addComponent(NamaTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(AlamatTextField)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NimLabel)
                    .addComponent(NimTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NamaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NamaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AlamatLabel)
                    .addComponent(AlamatTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TambahButton)
                        .addComponent(UbahButton))
                    .addComponent(HapusButton))
                .addGap(17, 17, 17)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NimTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NimTextFieldActionPerformed

    }//GEN-LAST:event_NimTextFieldActionPerformed

    private void NamaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaTextFieldActionPerformed

    private void AlamatTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AlamatTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AlamatTextFieldActionPerformed

    private void TambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahButtonActionPerformed
        try{
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(NimTextField.getText());
            mhs.setNama(NamaTextField.getText());
            mhs.setAlamat(AlamatTextField.getText());
            mhsServis.insert(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data tersimpan");
        }catch(SQLException ex){
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TambahButtonActionPerformed

    private void UbahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbahButtonActionPerformed
        try{
            Mahasiswa mhs = new Mahasiswa();
            mhs.setNim(NimTextField.getText());
            mhs.setNama(NamaTextField.getText());
            mhs.setAlamat(AlamatTextField.getText());
            mhsServis.update(mhs);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data berhasil diubah");
        }catch(SQLException ex){
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_UbahButtonActionPerformed

    private void HapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusButtonActionPerformed
        try{
            String nim = NimTextField.getText();
            mhsServis.delete(nim);
            this.statusAwal();
            JOptionPane.showMessageDialog(this, "data berhasil dihapus");
        }catch(SQLException ex){
            Logger.getLogger(MahasiswaFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_HapusButtonActionPerformed

    
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
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MahasiswaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MahasiswaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlamatLabel;
    private javax.swing.JTextField AlamatTextField;
    private javax.swing.JButton HapusButton;
    private javax.swing.JTable MahasiswaTabel;
    private javax.swing.JLabel NamaLabel;
    private javax.swing.JTextField NamaTextField;
    private javax.swing.JLabel NimLabel;
    private javax.swing.JTextField NimTextField;
    private javax.swing.JButton TambahButton;
    private javax.swing.JButton UbahButton;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
