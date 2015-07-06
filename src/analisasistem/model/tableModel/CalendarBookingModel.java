/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class CalendarBookingModel extends AbstractTableModel{
    Date d = new Date();
    int jumlahHari;
    private List<analisasistem.entity.Rooms> rooms = new ArrayList<analisasistem.entity.Rooms>();
    public CalendarBookingModel(List<analisasistem.entity.Rooms> room,int jumlahHari){
        this.rooms = room;
        this.jumlahHari = jumlahHari;
    }
    public List<analisasistem.entity.Rooms> getList(){
        return this.rooms;
    }
    @Override
    public int getRowCount() {
        return this.rooms.size();
    }

    @Override
    public int getColumnCount() {
        return 2+this.jumlahHari;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return this.rooms.get(rowIndex).getNo();
            case 1: return this.rooms.get(rowIndex).getRoomType().getName();
            default: return " ";
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "No Kamar";
            case 1: return "Tipe Kamar";
            default: return this.generateDate(columnIndex);
        }
    }
    
    private String generateDate(int i){
        return Integer.toString(i-1);
    }
    
}
