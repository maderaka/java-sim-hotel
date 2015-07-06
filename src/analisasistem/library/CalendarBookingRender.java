/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.library;

import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Raka New
 */
public class CalendarBookingRender implements TableCellRenderer{
    private int tahun;
    private int bulan;
    private static Color color;
    @Override
    public Component getTableCellRendererComponent(final JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        //To change body of generated methods, choose Tools | Templates.
        JLabel label = null;
        if(row == 5){
            label = new JLabel(value.toString()){
                @Override
                protected void paintComponent(final Graphics g){
                    CalendarBookingRender.color = Color.RED;
                    final Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(new GradientPaint(0,0,CalendarBookingRender.color,0,getHeight(),CalendarBookingRender.color));
                    g2.fillRect(0, 0, getHeight(), getWidth());
                    //g2.fill3DRect(0, 0, getHeight(), getWidth(), true);
                    super.paintComponent(g);
                }
            };   
        }else{
            label = new JLabel(value.toString()){
                @Override
                protected void paintComponent(final Graphics g){
                    CalendarBookingRender.color = table.getBackground();
                    final Graphics2D g2 = (Graphics2D) g.create();
                    g2.setPaint(new GradientPaint(0,0,CalendarBookingRender.color,0,getHeight(),CalendarBookingRender.color));
                    g2.fillRect(0, 0, getHeight(), getWidth());
                    //g2.fill3DRect(0, 0, getHeight(), getWidth(), true);
                    super.paintComponent(g);
                }
            };
        }
        label.setOpaque(false);
        if(isSelected){
            label.setForeground(Color.BLACK);
            label.setBackground(Color.BLACK);
        }else{
            label.setForeground(CalendarBookingRender.color);
            label.setBackground(CalendarBookingRender.color);
        }
        return label;
    }
    
}
