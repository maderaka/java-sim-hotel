/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.view.jabatan;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author Raka New
 */
public class JabatanDialog extends javax.swing.JDialog {

    /**
     * Creates new form JabatanDialog
     */
    analisasistem.controller.JabatanDialogController controller;
    private Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    public JabatanDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        controller = new analisasistem.controller.JabatanDialogController(this);
        this.setLocation(dimensi.width/2 - this.getWidth()/2, dimensi.height/2 - this.getWidth()/2);
        
    }
    public void isiTable(){
        controller.isiTable();
        this.staticConfig();
    }
    private void staticConfig(){
        analisasistem.library.TableStyle style = new analisasistem.library.TableStyle();
        style.setSize(this.tbJabatan, new int[]{20,100}, true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txIdJabatan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txNamaJabatan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbJabatan = new javax.swing.JTable();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Master Jabatan");

        jLabel1.setText("Kode Jabatan");

        txIdJabatan.setEnabled(false);

        jLabel2.setText("Nama Jabatan");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.setEnabled(false);

        tbJabatan.setModel(new javax.swing.table.DefaultTableModel(
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
        tbJabatan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbJabatanMousePressed(evt);
            }
        });
        tbJabatan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tbJabatanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tbJabatanFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(tbJabatan);

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txIdJabatan)
                            .addComponent(txNamaJabatan)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimpan)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDelete, btnReset, btnSimpan});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txIdJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txNamaJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan)
                    .addComponent(btnDelete)
                    .addComponent(btnReset)
                    .addComponent(btnUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        this.controller.insert();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        this.controller.reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void tbJabatanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbJabatanMousePressed
        // TODO add your handling code here:
        this.controller.viewDataJabatan();
    }//GEN-LAST:event_tbJabatanMousePressed

    private void tbJabatanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbJabatanFocusGained
        // TODO add your handling code here:
        this.controller.tbFocusGained();
    }//GEN-LAST:event_tbJabatanFocusGained

    private void tbJabatanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tbJabatanFocusLost
        // TODO add your handling code here:
        this.controller.tbFocusLost();
    }//GEN-LAST:event_tbJabatanFocusLost

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        this.controller.update();
        this.controller.isiTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(JabatanDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JabatanDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JabatanDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JabatanDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JabatanDialog dialog = new JabatanDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbJabatan;
    private javax.swing.JTextField txIdJabatan;
    private javax.swing.JTextField txNamaJabatan;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnDelete
     */
    public javax.swing.JButton getBtnDelete() {
        return btnDelete;
    }

    /**
     * @param btnDelete the btnDelete to set
     */
    public void setBtnDelete(javax.swing.JButton btnDelete) {
        this.btnDelete = btnDelete;
    }

    /**
     * @return the btnReset
     */
    public javax.swing.JButton getBtnReset() {
        return btnReset;
    }

    /**
     * @param btnReset the btnReset to set
     */
    public void setBtnReset(javax.swing.JButton btnReset) {
        this.btnReset = btnReset;
    }

    /**
     * @return the btnSimpan
     */
    public javax.swing.JButton getBtnSimpan() {
        return btnSimpan;
    }

    /**
     * @param btnSimpan the btnSimpan to set
     */
    public void setBtnSimpan(javax.swing.JButton btnSimpan) {
        this.btnSimpan = btnSimpan;
    }

    /**
     * @return the tbJabatan
     */
    public javax.swing.JTable getTbJabatan() {
        return tbJabatan;
    }

    /**
     * @param tbJabatan the tbJabatan to set
     */
    public void setTbJabatan(javax.swing.JTable tbJabatan) {
        this.tbJabatan = tbJabatan;
    }

    /**
     * @return the txIdJabatan
     */
    public javax.swing.JTextField getTxIdJabatan() {
        return txIdJabatan;
    }

    /**
     * @param txIdJabatan the txIdJabatan to set
     */
    public void setTxIdJabatan(javax.swing.JTextField txIdJabatan) {
        this.txIdJabatan = txIdJabatan;
    }

    /**
     * @return the txNamaJabatan
     */
    public javax.swing.JTextField getTxNamaJabatan() {
        return txNamaJabatan;
    }

    /**
     * @param txNamaJabatan the txNamaJabatan to set
     */
    public void setTxNamaJabatan(javax.swing.JTextField txNamaJabatan) {
        this.txNamaJabatan = txNamaJabatan;
    }

    /**
     * @return the btnUpdate
     */
    public javax.swing.JButton getBtnUpdate() {
        return btnUpdate;
    }

    /**
     * @param btnUpdate the btnUpdate to set
     */
    public void setBtnUpdate(javax.swing.JButton btnUpdate) {
        this.btnUpdate = btnUpdate;
    }
}
