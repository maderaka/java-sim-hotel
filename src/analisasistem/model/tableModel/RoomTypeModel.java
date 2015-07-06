/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;
import analisasistem.entity.RoomType;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */

public class RoomTypeModel extends AbstractTableModel {
    
    List <RoomType> list;
    private RoomType roomType;
    public RoomTypeModel(List<RoomType> list){
        this.list = list;
    }
    @Override
    public int getRowCount() {
        return list.size();
    }
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: 
                return list.get(rowIndex).getId();
            case 1:
                return list.get(rowIndex).getName();
            case 2: 
                return list.get(rowIndex).getJumlah_kasur();
            default:
                return null;
        }
    }
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: 
                return "Id";
            case 1: 
                return "Nama";
            case 2:
                return "Jumlah Kasur";
            case 3: 
                return "Keterangan";
            default: 
                return null;
        }
        
    }
}
