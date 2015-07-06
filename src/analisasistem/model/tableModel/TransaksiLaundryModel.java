/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.TransaksiLaundry;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class TransaksiLaundryModel extends AbstractTableModel{
    private List<TransaksiLaundry> list = new ArrayList<TransaksiLaundry>();
    public TransaksiLaundryModel(List<TransaksiLaundry> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return this.list.get(rowIndex).getNoTransaksiLaundry();
            case 1:
                return this.list.get(rowIndex).getRegistrasi().getIdRegistrasi();
            case 2:
                return this.list.get(rowIndex).getTanggalTransaksiLaundry();
            case 3:
                return this.list.get(rowIndex).getGuestName();
            case 4:
                return "Rp. "+this.list.get(rowIndex).getTotalTransaksi();
            case 5:
                return this.list.get(rowIndex).getTanggalTransaksiLaundry();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0:
                return "No Transaksi";
            case 1:
                return "No Registrasi";
            case 2:
                return "Tanggal";
            case 3: 
                return "Guest Name";
            case 4:
                return "Total";
            case 5:
                return "Tanggal Selesai";
            default:
                return null;
        }
    }
    
}
