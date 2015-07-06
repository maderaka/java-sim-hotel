/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller.users;
import analisasistem.entity.Users;
import analisasistem.view.users.UserDialogForm;
import java.util.Date;
import javax.swing.JOptionPane;
/**
 *
 * @author Raka New
 */
public class UserDialogFormController {
    private UserDialogForm dialog;
    
    public UserDialogFormController(UserDialogForm dialog){
        this.dialog = dialog;
    }
    public void cariPegawai(){
        analisasistem.view.pegawai.ChooserPegawaiDialog dialogChooser = new analisasistem.view.pegawai.ChooserPegawaiDialog(null, true);
        dialogChooser.setTextFieldIdPegawai(this.dialog.getTxIdPegawai());
        dialogChooser.setVisible(true);
        dialogChooser.setEnabled(true);
    }
    
    public void insert(){
        Users user = new Users();
        user.setIdUser(this.dialog.getTxIdPengguna().getText());
        user.setUsername(this.dialog.getTxNamaPengguna().getText());
        user.setPassWord(this.dialog.getTxPassword().getText());
        user.getPegawai().setId(this.dialog.getTxIdPegawai().getText());
        analisasistem.interfaces.UsersInterface data = new analisasistem.dao.UsersDAO();
        if(data.insert(user)){
            System.out.println("Pengguna berhasil terdaftar");
        }
    }
}
