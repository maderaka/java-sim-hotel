/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Raka New
 */

public class TableRenderDemo extends JPanel {

    public TableRenderDemo() {
        super(new GridLayout(1, 0));

        final JTable table = new JTable(new MyTableModel());
        table.setPreferredScrollableViewportSize(new Dimension(600, 200));
        table.setFillsViewportHeight(true);
        table.setDefaultRenderer(Object.class, new MyRenderer());

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                int col = table.getSelectedColumn();

                JOptionPane.showInternalMessageDialog(TableRenderDemo.this,
                        "Color: " + getTableCellBackground(table, row, col));

                System.out.println("Color: " + getTableCellBackground(table, row, col));
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    public Color getTableCellBackground(JTable table, int row, int col) {
        TableCellRenderer renderer = table.getCellRenderer(row, col);
        Component component = table.prepareRenderer(renderer, row, col);    
        return component.getBackground();
    }

    class MyRenderer implements TableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            JTextField editor = new JTextField();
            if (value != null) {
                editor.setText(value.toString());
            }
            editor.setBackground((row % 2 == 0) ? Color.white : Color.BLUE);
            return editor;
        }
    }

    class MyTableModel extends AbstractTableModel {

        private String[] columnNames = {"First Name",
            "Last Name",
            "Sport",
            "# of Years",
            "Vegetarian"};
        private Object[][] data = {
            {"Kathy", "Smith",
                "Snowboarding", new Integer(5), false},
            {"John", "Doe",
                "Rowing", new Integer(3), true},
            {"Sue", "Black",
                "Knitting", new Integer(2), true},
            {"Jane", "White",
                "Speed reading", new Integer(20), true},
            {"Joe", "Brown",
                "Pool", new Integer(10), false}
        };
        public final Object[] longValues = {"Jane", "Kathy",
            "None of the above",
            new Integer(20), Boolean.TRUE};

        @Override
        public int getColumnCount() {
            return columnNames.length;
        }

        @Override
        public int getRowCount() {
            return data.length;
        }

        @Override
        public String getColumnName(int col) {
            return columnNames[col];
        }

        @Override
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("TableRenderDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TableRenderDemo newContentPane = new TableRenderDemo();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
