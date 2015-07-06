/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.Pegawai;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class PegawaiChooserModel extends AbstractTableModel{
    List<Pegawai> list;
    
    public PegawaiChooserModel(List<Pegawai> list){
        this.list = list;
    }
    
    @Override
    public int getRowCount() {
       //To change body of generated methods, choose Tools | Templates.
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        //To change body of generated methods, choose Tools | Templates.
        return 3;
    }
    
    /**
     * 
     * @param columnIndex
     * @return 
     */
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Id";
            case 1: return "Nama";
            case 2: return "Jabatan";
            default: return null;    
        }
    }

    /**
     * 
     * @param rowIndex
     * @param columnIndex
     * @return 
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //To change body of generated methods, choose Tools | Templates.
        switch(columnIndex){
            case 0: return this.list.get(rowIndex).getId();
            case 1: return this.list.get(rowIndex).getNama();
            case 2: return this.list.get(rowIndex).getJabatan().getNamaJabatan();
            default: return null;
        }
    }
    
}
