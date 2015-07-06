/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.Jabatan;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class JabatanModel extends AbstractTableModel{
    /**
     * 
     */
    private List<Jabatan> list;
    
    /**
     * 
     * @param list 
     */
    public JabatanModel(List<Jabatan> list){
        this.list = list;
    }

    @Override
    public int getRowCount() {
        return this.list.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return this.list.get(rowIndex).getIdJabatan();
            case 1: return this.list.get(rowIndex).getNamaJabatan();
            default: return null;
        }
    }
   
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0: return "Id";
            case 1: return "Nama Jabatan";
            default: return null;
        }
    }
    
}
