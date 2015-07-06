/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.Users;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class UsersModel extends AbstractTableModel{
    
    private List<Users> list = new ArrayList<Users>();
   
    public UsersModel(List<Users> list){
        this.list = list;
    }
    @Override
    public int getRowCount() {
        //To change body of generated methods, choose Tools | Templates.
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        //To change body of generated methods, choose Tools | Templates.
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //To change body of generated methods, choose Tools | Templates.
        switch(columnIndex){
            case 0: return this.list.get(rowIndex).getIdUser();
            case 1: return this.list.get(rowIndex).getUsername();
            case 2: return this.list.get(rowIndex).getPegawai().getNama();
            case 3: return this.list.get(rowIndex).getPegawai().getJabatan().getNamaJabatan();
            case 4: return this.list.get(rowIndex).getDateCreate();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id";
            case 1: return "Username";
            case 2: return "Nama Pegawai";
            case 3: return "Nama Jabatan";
            case 4: return "Tanggal Registrasi";
            default: return null;
        }
    }
    
}
