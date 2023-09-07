/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistem_akuntansi.Factory;
import sistem_akuntansi.entity.Perkiraan;
import sistem_akuntansi.model.PerkiraanModel;



/**
 *
 * @author AROCHMAN ARYANTA
 */
public class PerkiraanForm extends javax.swing.JInternalFrame {
    /**
     * Creates new form FormPerkiraan
     */
    private Perkiraan perkiraan;
    private PerkiraanData perkiraanData;
    private PerkiraanModel perkiraanModel;
    private Connection connection;
    
    public PerkiraanForm(MainMenu main) {
        initComponents();
        
        //tambahkan 
        connection = Factory.getConnection();
        defaultComponent();
        perkiraanData = new PerkiraanData(main, true);
        perkiraanData.setLocationRelativeTo(this);
        perkiraan= new Perkiraan();
        perkiraanModel= new PerkiraanModel(connection);
       
    }
    
    private void defaultComponent(){
        radioHeader.setSelected(true);
        comboKelompok.setSelectedIndex(0);
        textKodeKelompok.setText("1");
        textKodePerkiraan.setText(null);
        textNama.setText(null);
        textFieldSaldoAkhir.setValue(0);
        radioDetail.requestFocus();        
        textKodeKelompok.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        radioHeader = new javax.swing.JRadioButton();
        radioDetail = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        comboKelompok = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        textKodeKelompok = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textKodePerkiraan = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        textNama = new javax.swing.JTextField();
        buttonBaru = new javax.swing.JButton();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        textFieldSaldoAkhir = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("FORM PERKIRAAN");

        jLabel1.setText("Tipe");

        radioHeader.setSelected(true);
        radioHeader.setText("Header");
        radioHeader.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioHeaderActionPerformed(evt);
            }
        });

        buttonGroup2.add(radioDetail);
        radioDetail.setText("Detail");
        radioDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioDetailActionPerformed(evt);
            }
        });

        jLabel2.setText("Kelompok");

        comboKelompok.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Harta", "Hutang", "Modal", "Pendapatan", "HPP", "Biaya", "Pendapatan Lain-lain", "Biaya Lain-lain" }));
        comboKelompok.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboKelompokItemStateChanged(evt);
            }
        });
        comboKelompok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKelompokActionPerformed(evt);
            }
        });

        jLabel3.setText("Kode");

        textKodeKelompok.setEditable(false);

        jLabel4.setText("-");

        jLabel5.setText("Nama perkiraan");

        buttonBaru.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonBaru.setText("BARU");
        buttonBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonBaruActionPerformed(evt);
            }
        });

        buttonTambah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonTambah.setText("TAMBAH");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonUbah.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonUbah.setText("UBAH");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });

        buttonHapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        buttonHapus.setText("HAPUS");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        textFieldSaldoAkhir.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0"))));
        textFieldSaldoAkhir.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        textFieldSaldoAkhir.setValue(0);

        jLabel6.setText("Saldo akhir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonBaru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonHapus))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radioHeader)
                                .addGap(35, 35, 35)
                                .addComponent(radioDetail))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textKodeKelompok, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textKodePerkiraan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboKelompok, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(textFieldSaldoAkhir, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(textNama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))))
                .addContainerGap(106, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(radioHeader)
                    .addComponent(radioDetail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboKelompok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textKodeKelompok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(textKodePerkiraan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldSaldoAkhir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonBaru)
                    .addComponent(buttonTambah)
                    .addComponent(buttonUbah)
                    .addComponent(buttonHapus))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboKelompokItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboKelompokItemStateChanged
        // TODO add your handling code here:
        int kodeKelompok= comboKelompok.getSelectedIndex()+1;
        textKodeKelompok.setText(Integer.toString(kodeKelompok));
    }//GEN-LAST:event_comboKelompokItemStateChanged

    private void radioDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioDetailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioDetailActionPerformed

    private void radioHeaderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioHeaderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radioHeaderActionPerformed

    private void buttonBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonBaruActionPerformed
        // TODO add your handling code here:
        defaultComponent();
    }//GEN-LAST:event_buttonBaruActionPerformed

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
        //ubah nilai entity
        perkiraan.setTipe(radioHeader.isSelected()?"H":"D");
        perkiraan.setKelompok(Integer.parseInt(textKodeKelompok.getText()));
        perkiraan.setKode(textKodeKelompok.getText()+"-"+textKodePerkiraan.getText());        
        perkiraan.setNama(textNama.getText());
        perkiraan.setSaldo_akhir(Double.parseDouble(textFieldSaldoAkhir.getValue().toString()));
        try {
            //tambah data
            connection.setAutoCommit(false);
            perkiraanModel.insert(perkiraan);
            connection.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan", "BERHASIL", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal ditambahkan", "GAGAL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PerkiraanForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        // TODO add your handling code here:
        //ubah nilai entity
        perkiraan.setTipe(radioHeader.isSelected()?"H":"D");
        perkiraan.setKelompok(Integer.parseInt(textKodeKelompok.getText()));
        perkiraan.setKode(textKodeKelompok.getText()+"-"+textKodePerkiraan.getText());        
        perkiraan.setNama(textNama.getText());
        perkiraan.setSaldo_akhir(Double.parseDouble(textFieldSaldoAkhir.getValue().toString()));
        
        try {
            //ubah data
            connection.setAutoCommit(false);
            perkiraanModel.update(perkiraan);
            connection.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil diubah", "BERHASIL", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal diubah", "GAGAL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PerkiraanForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
        //ubah nilai entity
        perkiraan.setTipe(radioHeader.isSelected()?"H":"D");
        perkiraan.setKelompok(Integer.parseInt(textKodeKelompok.getText()));
        perkiraan.setKode(textKodeKelompok.getText()+"-"+textKodePerkiraan.getText());        
        perkiraan.setNama(textNama.getText());
        perkiraan.setSaldo_akhir(Double.parseDouble(textFieldSaldoAkhir.getValue().toString()));
        try {
            //hapus data
            connection.setAutoCommit(false);
            perkiraanModel.delete(perkiraan);
            connection.commit();
            JOptionPane.showMessageDialog(this, "Data berhasil dihapus", "BERHASIL", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Data gagal dihapus", "GAGAL", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(PerkiraanForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void comboKelompokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKelompokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboKelompokActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        MainMenu frame = new MainMenu();
        PerkiraanForm form = new PerkiraanForm(frame);
        frame.setVisible(true);
        frame.desktopPane.add(form);
        form.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonBaru;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JComboBox comboKelompok;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton radioDetail;
    private javax.swing.JRadioButton radioHeader;
    private javax.swing.JFormattedTextField textFieldSaldoAkhir;
    private javax.swing.JTextField textKodeKelompok;
    private javax.swing.JTextField textKodePerkiraan;
    private javax.swing.JTextField textNama;
    // End of variables declaration//GEN-END:variables
}