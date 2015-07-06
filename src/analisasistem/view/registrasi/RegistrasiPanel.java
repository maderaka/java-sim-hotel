/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.view.registrasi;

import analisasistem.controller.RegistrasiPanelController;

/**
 *
 * @author Raka New
 */
public class RegistrasiPanel extends javax.swing.JPanel {

    private RegistrasiPanelController controller;
    /**
     * Creates new form RegistrasiPanel
     */
    public RegistrasiPanel() {
        initComponents();
        this.controller = new RegistrasiPanelController(this);
        analisasistem.library.TableStyle style = new analisasistem.library.TableStyle();
        style.setSize(tbRegistrasi, new int[]{30,100,200,100,100,100,100}, true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbRegistrasi = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnCo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        tbRegistrasi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbRegistrasi.setGridColor(new java.awt.Color(204, 204, 204));
        tbRegistrasi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbRegistrasiMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tbRegistrasiMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tbRegistrasi);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/analisasistem/image/icon30/user_group.png"))); // NOI18N
        jLabel1.setText("Guest in House");

        btnCo.setText("Check Out");
        btnCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCoActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");

        jButton3.setText("Add new");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 168, Short.MAX_VALUE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(3, 3, 3)
                        .addComponent(jButton3)
                        .addGap(6, 6, 6))
                    .addComponent(jScrollPane1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCo)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbRegistrasiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRegistrasiMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbRegistrasiMouseClicked

    private void tbRegistrasiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbRegistrasiMousePressed
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            this.controller.viewReservationDetail();
        }
    }//GEN-LAST:event_tbRegistrasiMousePressed

    private void btnCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCoActionPerformed
        // TODO add your handling code here:
        this.controller.doCheckOut();
    }//GEN-LAST:event_btnCoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbRegistrasi;
    // End of variables declaration//GEN-END:variables


    /**
     * @return the tbRegistrasi
     */
    public javax.swing.JTable getTbRegistrasi() {
        return tbRegistrasi;
    }

    /**
     * @param tbRegistrasi the tbRegistrasi to set
     */
    public void setTbRegistrasi(javax.swing.JTable tbRegistrasi) {
        this.tbRegistrasi = tbRegistrasi;
    }
}