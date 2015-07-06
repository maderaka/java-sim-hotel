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
public class ReservasiDetailModel extends AbstractTableModel{
    
    private java.util.List<analisasistem.entity.ReservasiDetail> list =  new java.util.ArrayList<analisasistem.entity.ReservasiDetail>();
    
    /**
     * 
     * @param list 
     */
    public ReservasiDetailModel(java.util.List<analisasistem.entity.ReservasiDetail> list){
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
        return 4;
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
                //return this.list.get(rowIndex).getRoom().getNama();
            case 1:
                return this.list.get(rowIndex).getRoom().getRoomType().getName();
            case 2:
                //return this.list.get(rowIndex).getCheckIn();
            case 3:
                //return this.list.get(rowIndex).getCheckOut();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: 
                return "Room";
            case 1:
                return "Room Type";
            case 2:
                return "Check In";
            case 3: 
                return "Check Out";
            default: return null;
        }
    }
    
}
