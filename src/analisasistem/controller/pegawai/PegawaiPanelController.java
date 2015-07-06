/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller.pegawai;

import analisasistem.dao.PegawaiDAO;
import analisasistem.entity.Pegawai;
import analisasistem.interfaces.PegawaiInterface;
import analisasistem.model.tableModel.PegawaiModel;
import analisasistem.view.pegawai.FormPegawaiDialog;
import analisasistem.view.pegawai.PegawaiPanel;
import java.util.List;

/**
 *
 * @author Raka New
 */

public class PegawaiPanelController {
    private analisasistem.view.pegawai.PegawaiPanel pegawaiPanel;
    private List<Pegawai> list;
    private PegawaiInterface pegawaiData;
    public PegawaiPanelController(PegawaiPanel pegawaiPanel){
        this.pegawaiPanel = pegawaiPanel;
        this.pegawaiData = new PegawaiDAO();
    }
    public void isiTabel(){
        this.list =  this.pegawaiData.getAll();
        PegawaiModel model = new PegawaiModel(this.list);
        this.pegawaiPanel.getTbPegawai().setModel(model);
    }    
    
    public void setView(String id){
        Pegawai pegawai = new Pegawai();
    }
    
    public void setViewDialogPegawai(){
        FormPegawaiDialog formDialog = new FormPegawaiDialog(null,true);
        formDialog.setId();
        formDialog.setEnabled(true);
        formDialog.setVisible(true);
    }
    
    public void viewPegawai(){
        String id = (String) this.pegawaiPanel.getTbPegawai().getValueAt(this.pegawaiPanel.getTbPegawai().getSelectedRow(), 1);
        FormPegawaiDialog formDialog = new FormPegawaiDialog(null,true);
        formDialog.getTxId().setText(id);
        formDialog.setAction(2);
        formDialog.getBtnSimpan().setText("Update");
        formDialog.viewDataPegawai();
        formDialog.setEnabled(true);
        formDialog.setVisible(true);
    }
}
