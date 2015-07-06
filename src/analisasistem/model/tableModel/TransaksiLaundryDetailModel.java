/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.TransaksiLaundryDetail;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class TransaksiLaundryDetailModel extends AbstractTableModel{
    private List<TransaksiLaundryDetail> listDetail = new ArrayList<TransaksiLaundryDetail>();
    public TransaksiLaundryDetailModel(List<TransaksiLaundryDetail> listDetail){
        this.listDetail = listDetail;
    }
    public void setList(List<TransaksiLaundryDetail> listDetail){
        this.listDetail = listDetail;
    }
    @Override
    public int getRowCount() {
         //To change body of generated methods, choose Tools | Templates.
        return this.listDetail.size();
    }

    @Override
    public int getColumnCount() {
        //To change body of generated methods, choose Tools | Templates.
        return 5;
        
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //To change body of generated methods, choose Tools | Templates.
        switch(columnIndex){
            case 0: 
                return this.listDetail.get(rowIndex).getLaundry().getIdBarang();
            case 1:
                return this.listDetail.get(rowIndex).getLaundry().getNamaBarang();
            case 2:
                return this.listDetail.get(rowIndex).getLaundry().getHarga();
            case 3:
                return this.listDetail.get(rowIndex).getQtyTransaksi();
            case 4:
                return this.listDetail.get(rowIndex).getSubtotalTransaksi();
            default: 
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0:
                return "Id Barang";
            case 1:
                return "Nama";
            case 2:
                return "Cost";
            case 3:
                return "Qty";
            case 4:
                return "Subtotal";
            default:
                return null;
        }
    }
    
}
