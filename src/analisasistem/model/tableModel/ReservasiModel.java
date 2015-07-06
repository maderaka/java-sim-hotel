/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class ReservasiModel extends AbstractTableModel{
    
    private java.util.List<analisasistem.entity.Reservasi> list = new java.util.ArrayList<analisasistem.entity.Reservasi>();
    
    /**
     * 
     * @param list 
     */
    public ReservasiModel(java.util.List list){
        this.list = list;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int getRowCount() {
        return this.list.size();
    }

    /**
     * 
     * @return 
     */
    @Override
    public int getColumnCount() {
        return 8;
    }

    /**
     * 
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return rowIndex+1;
            case 1: 
                if(this.list.get(rowIndex).getIdReservasi().equals("")){
                    return "---";
                }else{
                    return this.list.get(rowIndex).getIdReservasi();
                }
            case 2:
                if(this.list.get(rowIndex).getNamaPerson() == null){
                    return "---";
                }else{
                    return this.list.get(rowIndex).getNamaPerson();
                }
            case 3:
                if(this.list.get(rowIndex).getPhone() == null){
                    return "---";
                }else{
                    return this.list.get(rowIndex).getPhone();
                }
            case 4:
                return this.list.get(rowIndex).getArrivalTime();
            case 5:
                return this.list.get(rowIndex).getDepartureTime();
            case 6:
                if(this.list.get(rowIndex).getCompany() == null){
                    return "---";
                }else{
                    return this.list.get(rowIndex).getCompany();
                }
            case 7:
                if(this.list.get(rowIndex).getAgent().getName() == null){
                    return "---";
                }else{
                    return this.list.get(rowIndex).getAgent().getName();
                }
            default: return null;
        }
        
    }
    
    /**
     * 
     * @param columnIndex
     * @return 
     */
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: 
                return "NO";
            case 1: 
                return "No Reservasi";
            case 2: 
                return "Name";
            case 3: 
                return "Phone";
            case 4: 
                return "Arrival Time";
            case 5: 
                return "Departure Time";
            case 6: 
                return "Company";
            case 7:
                return "Travel Agent";
            default: return null;
        }
    }
    
}
