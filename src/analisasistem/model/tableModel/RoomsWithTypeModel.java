/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.Rooms;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class RoomsWithTypeModel extends AbstractTableModel{
    private List<Rooms> listRooms;
    private Rooms rooms;
    public RoomsWithTypeModel(List<Rooms> listRooms){
        this.listRooms = listRooms;
    }
    @Override
    public int getRowCount(){
        return this.listRooms.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: 
                return this.listRooms.get(rowIndex).getId();
            case 1:
                return this.listRooms.get(rowIndex).getNo();
            case 2:
                return this.listRooms.get(rowIndex).getRoomType().getId();
            case 3:
                return this.listRooms.get(rowIndex).getRoomType().getName();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int coloumn){
        switch(coloumn){
            case 0:
                return "Id";
            case 1:
                return "No. Kamar";
            case 2:
                return "Kode Type";
            case 3:
                return "Room Type";
            default:
                return null;
        }
        
    }
    
}
