/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.LaundryService;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class LaundryServiceModel extends AbstractTableModel{
    
    private List<LaundryService> list;
    
    public LaundryServiceModel(List<LaundryService> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: 
                return this.list.get(rowIndex).getIdBarang();
            case 1: 
                return this.list.get(rowIndex).getNamaBarang();
            case 2:
                return this.list.get(rowIndex).getHarga();
            default: 
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Kode";
            case 1:
                return "Name";
            case 2: 
                return "Cost";
            default:
                return null;
        }
    }
    
}
