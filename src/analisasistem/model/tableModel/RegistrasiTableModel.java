/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.Registrasi;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class RegistrasiTableModel extends AbstractTableModel{
    
    private List<Registrasi> list = new ArrayList<Registrasi>();
    
    public RegistrasiTableModel(List<Registrasi> list){
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
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //To change body of generated methods, choose Tools | Templates.
        int no = 1;
        switch(columnIndex){
            case 0:
                return no+rowIndex;
            case 1: 
                return this.list.get(rowIndex).getIdRegistrasi();
            case 2:
                return this.list.get(rowIndex).getTamu().getFullName();
            case 3:
                return this.list.get(rowIndex).getCheckIn();
            case 4:
                return this.list.get(rowIndex).getCheckOut();
            case 5:
                return this.list.get(rowIndex).getTamu().getPhone();
            case 6:
                return this.list.get(rowIndex).getAgent().getName();
            default:
                return null;
        } 
    }
    
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: 
                return "No";
            case 1: 
                return "No. Registrasi";
            case 2: 
                return "Full Name";
            case 3: 
                return "Check In";
            case 4: 
                return "Check Out";
            case 5: 
                return "Phone";
            case 6: 
                return "Agent";
            default: return null;
        }
    }
    
}
