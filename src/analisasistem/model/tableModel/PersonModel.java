/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.Person;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class PersonModel extends AbstractTableModel{
    private List<Person>list;
    
    public PersonModel(List<Person>list){
        this.list = list;
    }
    @Override
    public int getRowCount() {
        return this.list.size();
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return 5;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: 
                return this.list.get(rowIndex).getReservasi().getIdReservasi();
            case 1: 
                return this.list.get(rowIndex).getReservasi().getDate_reservasi();
            case 2:
                return null;
            default: 
                return null;
        }
    }
    
}
