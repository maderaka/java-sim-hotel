/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.model.tableModel;

import analisasistem.entity.TipeIdentitas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Raka New
 */
public class TipeIdentitasModel extends AbstractTableModel{
    private List<TipeIdentitas> list;
    public TipeIdentitasModel(List<TipeIdentitas> list){
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
            case 0: return this.list.get(rowIndex).getIdTipeIdentitas();
            case 1: return this.list.get(rowIndex).getNamaTipeIdentitas();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        switch(columnIndex){
            case 0: return "Id Tipe Identitas";
            case 1: return "Nama Tipe Identitas";
            default: return null;
        }
    }
    
}
