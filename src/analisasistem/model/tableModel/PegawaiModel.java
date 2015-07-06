/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.Pegawai;
import analisasistem.library.SexLibrary;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class PegawaiModel extends AbstractTableModel{
    
    private List<Pegawai> list;
    private int no =1;
    public PegawaiModel(List<Pegawai>list){
        this.list = list;
    }
    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SexLibrary sex = new SexLibrary();
        switch(columnIndex){
            case 0:
                return rowIndex+1;
            case 1:
                return this.list.get(rowIndex).getId();
            case 2:
                return this.list.get(rowIndex).getNama();
            case 3:
                return sex.getString(this.list.get(rowIndex).getJenisKelamin());
            case 4:
                return this.list.get(rowIndex).getTempatLahir();
            case 5:
                return this.list.get(rowIndex).getTanggalLahir();
            case 6:
                return this.list.get(rowIndex).getAlamat();
            case 7: 
                return this.list.get(rowIndex).getKota();
            case 8:
                return this.list.get(rowIndex).getProvinsi();
            case 9:
                return this.list.get(rowIndex).getTelp();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "No";
            case 1:
                return "Id";
            case 2:
                return "Nama";
            case 3:
                return "Sex";
            case 4:
                return "Tempat lahir";
            case 5:
                return "Tanggal Lahir";
            case 6:
                return "Alamat";
            case 7:
                return "Kota";
            case 8:
                return "Provinsi";
            case 9:
                return "Telphone";
            default:
                return null;
        }
    }
    public String generateData(Date date){
        String dateStr;
        SimpleDateFormat format = new SimpleDateFormat("MMM DD, yyyy");
        dateStr = format.format(date);
        return dateStr;
    }
    
}
