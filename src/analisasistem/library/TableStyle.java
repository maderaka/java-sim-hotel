/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.library;

/**
 *
 * @author Raka New
 */
public class TableStyle {
    private int rowHeight = 25;
    public void setRowHeight(int rowHeight){
        this.rowHeight = rowHeight;
    }
    public void setSize(javax.swing.JTable tb, int[] lebar,boolean line){
        tb.setShowHorizontalLines(line);
        tb.setRowHeight(this.rowHeight);
        if(lebar.length != 0){
            int kolom = tb.getColumnCount();
            for(int i=0;i<kolom;i++){
                javax.swing.table.TableColumn tbc = tb.getColumnModel().getColumn(i);
                tbc.setPreferredWidth(lebar[i]);

            }
        }
    }
    
    public void setCalendarBooking(javax.swing.JTable tb, int[] lebar,boolean line){
        tb.setShowHorizontalLines(line);
        tb.setShowVerticalLines(line);
        tb.setRowHeight(25);
        int kolom = tb.getColumnCount();
        for(int i=0;i<kolom;i++){
            javax.swing.table.TableColumn tbc = tb.getColumnModel().getColumn(i);
            tbc.setPreferredWidth(lebar[i]);
        }
    }
}
