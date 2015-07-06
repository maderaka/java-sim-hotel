/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.view.pegawai;

import analisasistem.controller.pegawai.PegawaiPanelController;

/**
 *
 * @author Raka New
 */
public class PegawaiPanel extends javax.swing.JPanel {
    /**
     * Declaration variable and object
     */
    private PegawaiPanelController controller;
    
    /**
     * Creates new form PegawaiPanel
     */
    public PegawaiPanel() {
        initComponents();
        this.controller = new PegawaiPanelController(this);
        this.controller.isiTabel();
        this.defaultConfig();
    }
    private void defaultConfig(){
        analisasistem.library.TableStyle style = new analisasistem.library.TableStyle();
        style.setSize(this.tbPegawai, new int[]{60,100,150,80,150,150,150,150,150,150},true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tbPegawai = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnTambahBaru = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnView = new javax.swing.JButton();

        tbPegawai.setModel(new javax.swing.table.DefaultTableModel(
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
        tbPegawai.setGridColor(new java.awt.Color(204, 204, 204));
        tbPegawai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPegawaiMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPegawai);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Kampus\\SEMESTER VI\\ADSI\\Perangkat Lunak\\AnalisaSistem\\images\\blue\\female-user.png")); // NOI18N
        jLabel1.setText("Data Pegawai");

        btnTambahBaru.setText("Tambah Baru");
        btnTambahBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahBaruActionPerformed(evt);
            }
        });

        jButton1.setText("Refresh");

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnView, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTambahBaru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnTambahBaru, btnView, jButton1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnTambahBaru)
                    .addComponent(jButton1)
                    .addComponent(btnView))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahBaruActionPerformed
        // TODO add your handling code here:
        this.controller.setViewDialogPegawai();
    }//GEN-LAST:event_btnTambahBaruActionPerformed

    private void tbPegawaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPegawaiMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            this.controller.viewPegawai();
        }
        
    }//GEN-LAST:event_tbPegawaiMouseClicked

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        this.controller.viewPegawai();
    }//GEN-LAST:event_btnViewActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTambahBaru;
    private javax.swing.JButton btnView;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbPegawai;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnTambahBaru
     */
    public javax.swing.JButton getBtnTambahBaru() {
        return btnTambahBaru;
    }

    /**
     * @param btnTambahBaru the btnTambahBaru to set
     */
    public void setBtnTambahBaru(javax.swing.JButton btnTambahBaru) {
        this.btnTambahBaru = btnTambahBaru;
    }

    /**
     * @return the tbPegawai
     */
    public javax.swing.JTable getTbPegawai() {
        return tbPegawai;
    }

    /**
     * @param tbPegawai the tbPegawai to set
     */
    public void setTbPegawai(javax.swing.JTable tbPegawai) {
        this.tbPegawai = tbPegawai;
    }
}