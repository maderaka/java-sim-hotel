/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller.users;

import analisasistem.entity.Users;
import analisasistem.library.OtomatisasiId;
import java.awt.Frame;

/**
 *
 * @author Raka New
 */
public class UsersController {
    analisasistem.interfaces.UsersInterface dataUsers;
    analisasistem.view.users.UsersPanel panel;
    private Users user;
    public UsersController(analisasistem.view.users.UsersPanel panel){
        this.panel = panel;
        this.dataUsers = new analisasistem.dao.UsersDAO();
    }
    
    public void isiTable(){
        java.util.List<Users> list = new java.util.ArrayList<Users>();
        list = this.dataUsers.selectAll();
        analisasistem.model.tableModel.UsersModel model = new analisasistem.model.tableModel.UsersModel(list);
        this.panel.getTbUsers().setModel(model);
    }
    
    public boolean insert(Users user){
        this.user = user;
        user.setIdUser(null);
        user.setUsername(null);
        user.getPassWord();
        user.getPegawai().setId(null);
        return false;
    }
    
    public void tambahPengguna(){
        analisasistem.view.users.UserDialogForm dialog = new analisasistem.view.users.UserDialogForm(null, true);
        OtomatisasiId id = new OtomatisasiId();
        dialog.getTxIdPengguna().setText(id.forUser());
        dialog.setVisible(true);
    }
    
}
