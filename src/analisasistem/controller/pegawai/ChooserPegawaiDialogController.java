/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller.pegawai;

import analisasistem.entity.Pegawai;
import analisasistem.view.pegawai.ChooserPegawaiDialog;
import java.util.List;

/**
 *
 * @author Raka New
 */
public class ChooserPegawaiDialogController {
    private ChooserPegawaiDialog dialog;
    public ChooserPegawaiDialogController(ChooserPegawaiDialog dialog){
        this.dialog = dialog;
        this.defaultConfig();
    }
    
    private void defaultConfig(){
        this.isiTable();
    }
    
    public void isiTable(){
        analisasistem.interfaces.PegawaiInterface data = new analisasistem.dao.PegawaiDAO();
        List<Pegawai> list = data.getPegawaiChooser();
        analisasistem.model.tableModel.PegawaiChooserModel model = new analisasistem.model.tableModel.PegawaiChooserModel(list);
        this.dialog.getTbPegawai().setModel(model);
    }
    
    public void addPegawai(){
        int row = this.dialog.getTbPegawai().getSelectedRow();
        this.dialog.getTextFieldIdPegawai().setText((String) this.dialog.getTbPegawai().getValueAt(row, 0));
        this.dialog.dispose();
    }
    

    
}
