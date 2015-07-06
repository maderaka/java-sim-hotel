/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.BookingCart;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class BookingCartModel extends AbstractTableModel {
    List<BookingCart> list = new ArrayList<BookingCart>();
    SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy");
    
    /**
     * 
     * @param list 
     */
    public BookingCartModel(List<BookingCart> list){
        this.list = list;
    }
    /**
     * 
     * @param list 
     */
    public void setList(List<BookingCart> list){
        this.list = list;
    }
    
    /**
     * 
     * @return 
     */
    public List<BookingCart> getList(){
        return this.list;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int getRowCount() {
        //To change body of generated methods, choose Tools | Templates.
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        //To change body of generated methods, choose Tools | Templates.
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return this.list.get(rowIndex).getRooms().getId();
            case 1: return this.list.get(rowIndex).getRooms().getNo();
            case 2: return sdf.format(this.list.get(rowIndex).getCheckin());
            case 3: return sdf.format(this.list.get(rowIndex).getCheckout());
            default: return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Kode";
            case 1: return "Room";
            case 2: return "Check In";
            case 3: return "Check Out";
            default: return null;
        }
    }
    
}
