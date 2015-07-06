/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package analisasistem.controller;

import analisasistem.entity.Registrasi;
import analisasistem.entity.RegistrasiDetail;
import analisasistem.view.checkout.CheckOutFormDialog;
import analisasistem.view.registrasi.RegistrasiPanel;
import java.util.List;

/**
 *
 * @author Raka New
 */

public class RegistrasiPanelController {
    
    private RegistrasiPanel panel;
    
    public RegistrasiPanelController(RegistrasiPanel panel){
        this.panel = panel;
        this.defaultConfig();
    }
    
    private void defaultConfig(){
        this.isiTable();
    }
    
    public void addRegistrasi(){
        
    }
    
    public void isiTable(){
        analisasistem.interfaces.RegistrasiDetailInterface dataRegistrasi = new analisasistem.dao.RegistrasiDetailDAO();
        List<RegistrasiDetail> list = dataRegistrasi.getGuestInHouse();
        analisasistem.model.tableModel.GuestInHouseModel model = new analisasistem.model.tableModel.GuestInHouseModel(list);
        this.panel.getTbRegistrasi().setModel(model);
    }  
    
    public void viewReservationDetail(){
        analisasistem.interfaces.RegistrasiInterface dataRegi = new analisasistem.dao.RegistrasiDAO();
        Registrasi registrasi = dataRegi.selectById(this.getIdSelected());
        analisasistem.view.registrasi.FormRegistrasi form = new analisasistem.view.registrasi.FormRegistrasi(null, true);
        form.getController().setValueForm(registrasi);
        form.setVisible(true);
        form.setEnabled(true);
    }
    
    public String getIdSelected(){
        String id;
        id = (String) this.panel.getTbRegistrasi().getValueAt(this.panel.getTbRegistrasi().getSelectedRow(), 1);
        System.out.println(id);
        return id;
    }
    
    public void doCheckOut(){
        CheckOutFormDialog dialog = new CheckOutFormDialog(null,true);
        dialog.getTxRegistrasiNo().setText(this.getIdSelected());
        dialog.defaultConfig();
        dialog.setEnabled(true);
        dialog.setVisible(true);
        
    }
}
