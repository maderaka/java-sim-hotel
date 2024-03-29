/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.view.travelAgent;

import analisasistem.controller.travelAgent.TravelAgentPanelController;

/**
 *
 * @author Raka New
 */
public class AgentListView extends javax.swing.JPanel {
    /**
     * 
     */
    private TravelAgentPanelController controller;
    /**
     * Creates new form AgentListView
     */
    public AgentListView() {
        initComponents();
        this.controller = new TravelAgentPanelController(this);
        this.controller.isiTable();
        this.defaultConfig();
    }
    private void defaultConfig(){
        analisasistem.library.TableStyle style = new analisasistem.library.TableStyle();
        style.setSize(this.tblTravelAgent, new int[]{30,100,150,80,150,150,150},true);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTravelAgent = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Kampus\\SEMESTER VI\\ADSI\\Perangkat Lunak\\AnalisaSistem\\images\\black\\multi-agents.png")); // NOI18N
        jLabel1.setText("Travel Agents");

        tblTravelAgent.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTravelAgent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTravelAgentMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblTravelAgentMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblTravelAgent);

        btnAdd.setText("Tambah Agent");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jButton1.setText("View");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Report");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnAdd, jButton1});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnAdd)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.controller.viewFormDialog();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        this.controller.addTravelAgent();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblTravelAgentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTravelAgentMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTravelAgentMouseClicked

    private void tblTravelAgentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTravelAgentMousePressed
        // TODO add your handling code here:
       if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            this.controller.viewFormDialog();
        }
    }//GEN-LAST:event_tblTravelAgentMousePressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.controller.reportAgent();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTravelAgent;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the btnAdd
     */
    public javax.swing.JButton getBtnAdd() {
        return btnAdd;
    }

    /**
     * @param btnAdd the btnAdd to set
     */
    public void setBtnAdd(javax.swing.JButton btnAdd) {
        this.btnAdd = btnAdd;
    }

    /**
     * @return the tblTravelAgent
     */
    public javax.swing.JTable getTblTravelAgent() {
        return tblTravelAgent;
    }

    /**
     * @param tblTravelAgent the tblTravelAgent to set
     */
    public void setTblTravelAgent(javax.swing.JTable tblTravelAgent) {
        this.tblTravelAgent = tblTravelAgent;
    }
}
