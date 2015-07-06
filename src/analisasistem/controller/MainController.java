/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller;

import analisasistem.library.Laporan;
import analisasistem.view.jabatan.JabatanDialog;
import analisasistem.view.laundry.LaundryServicePanel;
import analisasistem.view.MainForm;
import analisasistem.view.StartPage;
import analisasistem.view.pegawai.PegawaiPanel;
import analisasistem.view.travelAgent.AgentForm;
import analisasistem.view.travelAgent.AgentListView;
import javax.swing.JPanel;

/**
 *
 * @author Raka New
 */
public class MainController {
    private MainForm form;
    public MainController(MainForm form){
        this.form = form;
    }
    /**
     * 
     */
    public void clearPanel(){
        this.form.getMainPanel().removeAll();//
        this.form.getMainPanel().repaint(); // proses 1
    }
    /**
     * 
     */
    public void addItemPanel(JPanel panel){
        this.form.getMainPanel().add(panel); //proses 2
    }
    /**
     * 
     */
    public void reValidate(){
        this.form.getMainPanel().revalidate();//proses 3
    }
    
    public void setStartPage(){
        StartPage page = new StartPage();
        this.clearPanel();
        this.addItemPanel(page);
        this.reValidate();
    }
    /**
     * 
     */
    public void setPegawai(){
        PegawaiPanel pegawai = new PegawaiPanel();
        this.clearPanel();
        this.addItemPanel(pegawai);
        this.reValidate();
    }
    /**
     * 
     */
    public void viewTravelAgent(){
        AgentListView agentView = new AgentListView();
        this.clearPanel();
        this.addItemPanel(agentView);
        this.reValidate();
    }
    
    /**
     * 
     */
    public void viewLaundryServiceMaster(){
        LaundryServicePanel panel = new LaundryServicePanel();
        this.clearPanel();
        this.addItemPanel(panel);
        this.reValidate();
    }
    
    /**
     * call form travel agents
     */
    public void addAgent(){
        AgentForm agentForm = new AgentForm(this.form,true);
        agentForm.setEnabled(true);
        agentForm.setVisible(true);
    }
    
    /**
     * call users panel
     */
    public void viewUsers(){
        analisasistem.view.users.UsersPanel usersPanel = new analisasistem.view.users.UsersPanel();
        this.clearPanel();
        this.addItemPanel(usersPanel);
        this.reValidate();
    }
    
    /**
     * 
     */
    public void viewJabatanDialog(){
        JabatanDialog dialog = new JabatanDialog(this.form,true);
        dialog.isiTable();
        dialog.setEnabled(true);
        dialog.setVisible(true);
    }
    /**
     * 
     */
    public void addReservation(){
        analisasistem.view.reservasi.ReservasiFormDialog dialog = new analisasistem.view.reservasi.ReservasiFormDialog(this.form,true);
        dialog.setEnabled(true);
        dialog.setVisible(true);
    }
    
    public void addRegistration(){
        analisasistem.view.registrasi.FormRegistrasi dialog = new analisasistem.view.registrasi.FormRegistrasi(this.form,true);
        dialog.setEnabled(true);
        dialog.setVisible(true);
    }
    
    /**
     * 
     */
    public void viewReservation(){
        analisasistem.view.reservasi.ReservasiPanel panel = new analisasistem.view.reservasi.ReservasiPanel();
        this.clearPanel();
        this.addItemPanel(panel);
        this.reValidate();
    }
    
    public void viewRegistrasi(){
        analisasistem.view.registrasi.RegistrasiPanel panel = new analisasistem.view.registrasi.RegistrasiPanel();
        this.clearPanel();
        this.addItemPanel(panel);
        this.reValidate();
    }
    
    /**
     * 
     */
    public void viewCalendarBooking(){
        analisasistem.view.calendarbooking.CalendarBookingPanel panel = new analisasistem.view.calendarbooking.CalendarBookingPanel();
        this.clearPanel();
        this.addItemPanel(panel);
        this.reValidate();
    }
    
    public void addTransaksiLaundry(){
        analisasistem.view.laundry.FormTransaksiLaundry dialog = new analisasistem.view.laundry.FormTransaksiLaundry(form, true);
        dialog.setVisible(true);
        dialog.setEnabled(true);
    }
    
    public void viewTransaksiLaundry(){
        analisasistem.view.laundry.TransaksiLaundryPanel panel = new analisasistem.view.laundry.TransaksiLaundryPanel();
        this.clearPanel();
        this.addItemPanel(panel);
        this.reValidate();
    }
    
    public void laporanReservasi(){
        Laporan laporan = new Laporan();
        laporan.laporanReservasi("Data Reservasi.jrxml");
    }
    /**
     * Exit
     */
    public void exit(){
        System.exit(1);
    }
}
