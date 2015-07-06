/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.TravelAgent;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class TravelAgentModel extends AbstractTableModel {
    
    /**
     * Declaration variable & object
     */
    private List<TravelAgent> list;
    private int no = 1;
    
    /**
     * 
     */
    public TravelAgentModel(List<TravelAgent>list){
        this.list = list;
    }
    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return rowIndex+1;
            case 1:
                return this.list.get(rowIndex).getId();
            case 2:
                return this.list.get(rowIndex).getName();
            case 3:
                return this.list.get(rowIndex).getProvinsi();
            case 4:
                return this.list.get(rowIndex).getContactName();
            case 5:
                return this.list.get(rowIndex).getContactPhone();
            case 6:
                return this.list.get(rowIndex).getRegDate();
            default:
                return null;
        }
    }
    
    /**
     * 
     */
    @Override
    public String getColumnName(int name){
        switch(name){
            case 0:
                return "No";
            case 1:
                return "Id Travel Agent";
            case 2:
                return "Name";
            case 3:
                return "Provinsi";
            case 4:
                return "Contact Name";
            case 5:
                return "Contact Phone";
            case 6:
                return "Registration";
            default:
                return null;
        }
    }
    
}
