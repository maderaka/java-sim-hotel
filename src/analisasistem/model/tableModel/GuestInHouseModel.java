/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.RegistrasiDetail;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class GuestInHouseModel extends AbstractTableModel{
    private List<RegistrasiDetail> list;
    
    public GuestInHouseModel(List<RegistrasiDetail> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
       //To change body of generated methods, choose Tools | Templates.
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return rowIndex+1;
            case 1: return this.list.get(rowIndex).getReservasi().getIdRegistrasi();
            case 2: return this.list.get(rowIndex).getRoom().getNo();
            case 3: return this.list.get(rowIndex).getReservasi().getCheckIn();
            case 4: return this.list.get(rowIndex).getReservasi().getCheckOut();
            case 5: return this.list.get(rowIndex).getReservasi().getTamu().getFullName();
            case 6: return this.list.get(rowIndex).getReservasi().getTamu().getPhone();
            default: return null;
        }//To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "No.";
            case 1: return "No. Registrasi";
            case 2: return "No. Kamar";
            case 3: return "Check in";
            case 4: return "Check out";
            case 5: return "Nama";
            case 6: return "Telphone";
            default: return null;
        }
    }
    
}
