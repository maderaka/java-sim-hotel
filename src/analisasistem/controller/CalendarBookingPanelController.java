/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller;

import analisasistem.entity.BookingCart;
import analisasistem.model.tableModel.BookingCartModel;
import analisasistem.model.tableModel.CalendarBookingModel;
import analisasistem.view.reservasi.ReservasiFormDialog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Raka New
 */
public class CalendarBookingPanelController {
    private analisasistem.view.calendarbooking.CalendarBookingPanel panel;
    private analisasistem.interfaces.RoomsInterface dataRoom;
    private List<analisasistem.entity.Rooms> list;
    private List<BookingCart> listBookingCart;
    private BookingCartModel model;
    private int jumlahHari = 29;
    public CalendarBookingPanelController(analisasistem.view.calendarbooking.CalendarBookingPanel panel){
        this.panel = panel;
        this.dataRoom = new analisasistem.dao.RoomsDAO();
        this.listBookingCart = new ArrayList<BookingCart>();
        this.model = new BookingCartModel(this.listBookingCart);
        //this.staticConfig();
    }
    
    /**
     * 
     */
    private void setJcbMonth(){
        this.panel.getJcbMonth().removeAllItems();
        Object[] bulan;
        bulan = new Object[]{"January","February","March","April","May","June","July","August","September","October","November","December"};
        for(int i=0;i<bulan.length;i++){
            this.panel.getJcbMonth().addItem(bulan[i]);
        }
    }
    
    /**
     * 
     */
    private void setJcbYears(){
        this.panel.getJcbYears().removeAllItems();
        for(int i=0;i<50;i++){
            this.panel.getJcbYears().addItem(2010+i);
        }
        this.panel.getJcbYears().setSelectedItem(2013);
    }
    
    private Object getSelectedYear(){
        return this.panel.getJcbYears().getSelectedItem();
    }
    
    private Object getSelectedMonth(){
        return this.panel.getJcbMonth().getSelectedItem();
    }
    /**
     * 
     */
    public void defaultConfig(){
        this.setJcbMonth();
        this.setJcbYears();
        Date date = new Date();
        this.panel.getJcbMonth().setSelectedIndex(date.getMonth());
        this.panel.getJcbYears().setSelectedItem(date.getYear());
    }
    
    public void isiTable(){
        this.list = this.dataRoom.getAll();
        analisasistem.model.tableModel.CalendarBookingModel modelCalendar = new analisasistem.model.tableModel.CalendarBookingModel(this.list,this.jumlahHari);
        this.panel.getTbPegawai().setModel(modelCalendar);
        for(int i=2;i<this.panel.getTbCalendarBooking().getModel().getColumnCount();i++){
            //this.panel.getTbCalendarBooking().getColumnModel().getColumn(i).setCellRenderer(new CalendarBookingRender());
        }
    }
    
    public int getJumlahHari(){
        return this.jumlahHari;
    }
    
    public void addReservation() throws ParseException{
        this.listBookingCart = new ArrayList<BookingCart>();
        this.listBookingCart = this.model.getList();
        
        int [] row = this.panel.getTbPegawai().getSelectedRows();
        int [] column = this.panel.getTbPegawai().getSelectedColumns();
        String checkin = this.getSelectedMonth()+" "+(column[0]-1)+", "+this.getSelectedYear();
        String checkout = this.getSelectedMonth()+" "+(column.length+column[0]-1)+", "+this.getSelectedYear();
        SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy");
        Date date,date2;
        date = sdf.parse(checkin);
        date2 = sdf.parse(checkout);
        
        for(int i=0;i<row.length;i++){
            BookingCart booking = new BookingCart();
            CalendarBookingModel model1 = (CalendarBookingModel) this.panel.getTbCalendarBooking().getModel();
            booking.getRooms().setId(model1.getList().get(row[i]).getId());
            booking.getRooms().setNo((String) this.panel.getTbPegawai().getValueAt(row[i], 1));
            booking.setCheckin(date);
            booking.setCheckout(date2);
            this.listBookingCart.add(booking);
            
            /**if(form.getTxNoKamar().getText().equals("")){
                form.getTxNoKamar().setText((String) this.panel.getTbPegawai().getValueAt(row[i], 0));
            }else{
                form.getTxNoKamar().setText(form.getTxNoKamar().getText()+","+this.panel.getTbPegawai().getValueAt(row[i], 0));
            }**/
            System.out.println("Room yang di booking "+this.panel.getTbPegawai().getValueAt(row[i], 0));
            System.out.println("Pada Tanggal ");
            for(int j=column[0];j<column.length+column[0];j++){
                System.out.print(j-1+" | ");
            }
            System.out.println();
        }
        System.out.println(checkin);
        
        this.model = new BookingCartModel(this.listBookingCart);
        this.panel.getTbBookingCart().setModel(this.model);
        this.panel.styleBookingCartTable();
        
    }
    
    public void fillForm(){
        ReservasiFormDialog form = new ReservasiFormDialog(null,true);
        //form.getTbBookingCart().setModel(this.model);
        form.setVisible(true);
        form.setEnabled(true);
    }
}
