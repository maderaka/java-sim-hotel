/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller.checkout;

import analisasistem.dao.CheckOutDAO;
import analisasistem.dao.RegistrasiDAO;
import analisasistem.entity.CheckOut;
import analisasistem.entity.Registrasi;
import analisasistem.interfaces.CheckOutInterface;
import analisasistem.interfaces.RegistrasiInterface;
import analisasistem.view.checkout.CheckOutFormDialog;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Raka New
 */
public class CheckOutFormController {
    private CheckOutFormDialog dialog;
    private CheckOutInterface coData;
    private CheckOut co;
    public CheckOutFormController(CheckOutFormDialog dialog){
        this.dialog = dialog;   
        this.coData = new CheckOutDAO();
        this.co = new CheckOut();
    }
    
    public void insert(){
        this.co.setId(this.dialog.getTxCheckOutNo().getText());
        this.co.setDate(new java.sql.Date(new Date().getTime()));
        this.co.setMemo(this.dialog.getTxMemo().getText());
        this.co.getRegistrasi().setIdRegistrasi(this.dialog.getTxRegistrasiNo().getText());
        this.co.getUser().setIdUser("US-1309005");
        if(this.coData.insert(this.co)){
            JOptionPane.showMessageDialog(this.dialog, "Proses Check out berhasil dilakukan");
        }
    }
    
    public void showByReg(){
        RegistrasiInterface regData = new RegistrasiDAO();
        Registrasi registrasi = regData.selectById(this.dialog.getTxRegistrasiNo().getText());
        this.dialog.getTxGuestName().setText(registrasi.getTamu().getFullName());
        this.dialog.getTxRegistrasiNo().setText(registrasi.getIdRegistrasi());
        this.dialog.getTxCheckOutNo().setText(this.getCheckOutId());
        this.dialog.getTxTanggal().setText(new Date().toString());
    }
    
    public String getCheckOutId(){
        analisasistem.library.OtomatisasiId id = new analisasistem.library.OtomatisasiId();
        return id.forCheckOut();
    }
}
