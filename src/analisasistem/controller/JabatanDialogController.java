/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller;

import analisasistem.entity.Jabatan;
import analisasistem.library.OtomatisasiId;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Raka New
 */
public class JabatanDialogController {
    analisasistem.view.jabatan.JabatanDialog dialog;
    analisasistem.interfaces.JabatanInterface data = new analisasistem.dao.JabatanDAO();
    List<Jabatan> list;
    public JabatanDialogController(analisasistem.view.jabatan.JabatanDialog dialog){
        this.dialog = dialog;
    }
    /**
     * 
     */
    public void isiTable(){
        list = data.selectAll();
        analisasistem.model.tableModel.JabatanModel model = new analisasistem.model.tableModel.JabatanModel(list);
        this.dialog.getTbJabatan().setModel(model);
    }
    
    public void insert(){
        Jabatan jabatan = new Jabatan();
        OtomatisasiId oto = new OtomatisasiId();
        jabatan.setIdJabatan(oto.forJabatan());
        jabatan.setNamaJabatan(this.dialog.getTxNamaJabatan().getText());
        
        if(data.insert(jabatan)){
            JOptionPane.showMessageDialog(null, "Well Done! Data Jabatan berhasil dicatat");
        }else{
            JOptionPane.showMessageDialog(null, "Error! Data Jabatan gagal dicatat");
        }
    }
    
    public void update(){
        Jabatan jabatan = new Jabatan();
        jabatan.setIdJabatan(this.dialog.getTxIdJabatan().getText());
        jabatan.setNamaJabatan(this.dialog.getTxNamaJabatan().getText());
        if(this.data.update(jabatan)){
            JOptionPane.showMessageDialog(null, "Well done! Data berhasil di update");
        }else{
            JOptionPane.showMessageDialog(null,"Gagal di update");
        }
    }
    
    public void delete(){
        
    }
    
    public void viewDataJabatan(){
        String id = (String) this.dialog.getTbJabatan().getValueAt(this.dialog.getTbJabatan().getSelectedRow(), 0);
        Jabatan jabatan = this.data.selectById(id);
        this.dialog.getTxIdJabatan().setText(jabatan.getIdJabatan());
        this.dialog.getTxNamaJabatan().setText(jabatan.getNamaJabatan());
        
    }
    
    public void reset(){
        this.dialog.getTxNamaJabatan().setText(null);
        this.dialog.getTxIdJabatan().setText(null);
    }
    
    public void tbFocusGained(){
        this.dialog.getBtnUpdate().setEnabled(true);
        this.dialog.getBtnDelete().setEnabled(true);
    }
    
    public void tbFocusLost(){
        //this.dialog.getBtnUpdate().setEnabled(false);
        this.dialog.getBtnDelete().setEnabled(false);
    }
}
