/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller;

import analisasistem.dao.RegistrasiDAO;
import analisasistem.dao.ReservasiDAO;
import analisasistem.entity.Person;
import analisasistem.entity.Registrasi;
import analisasistem.entity.RegistrasiDetail;
import analisasistem.entity.Reservasi;
import analisasistem.entity.Rooms;
import analisasistem.entity.Tamu;
import analisasistem.interfaces.RegistrasiInterface;
import analisasistem.interfaces.ReservasiInterface;
import analisasistem.library.OtomatisasiId;
import analisasistem.view.registrasi.FormRegistrasi;
import analisasistem.view.rooms.RoomsChooser;
import analisasistem.view.travelAgent.TravelAgentChooser;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Raka New
 */

public class RegistrasiDialogController{
    
    private FormRegistrasi form;
    private Registrasi registrasi = new Registrasi();
    private RegistrasiInterface dataReg = new RegistrasiDAO();
    private List<Rooms> listRoomsSelected = new ArrayList<Rooms>();
    public RegistrasiDialogController(FormRegistrasi form){
        this.form = form;
        this.defaultConfig();
    }
    
    private void defaultConfig(){
        OtomatisasiId oto = new OtomatisasiId();
        String id = oto.forRegistrasi();
        this.form.getNoRegistrasi().setText(id);
        this.setDateRegistrasi();
    }
    
    private void setDateRegistrasi(){
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("d MMMM yyyy H:m:s");
        this.form.getTxDateReg().setText(format.format(d));
    }
    /**
     * 
     * @return 
     */
    private Tamu getTamuValue(){
        Registrasi registrasi = new Registrasi();
        OtomatisasiId oto = new OtomatisasiId();
        registrasi.getTamu().setIdTamu(oto.forTamu());
        registrasi.getTamu().setNoIdentitas(this.form.getTxIdentitasNo().getText());
        registrasi.getTamu().getTipeIdentitas().setIdTipeIdentitas(this.form.getJenisIdentitas().getSelectedIndex());
        registrasi.getTamu().setFullName(this.form.getTxNama().getText());
        registrasi.getTamu().setJk(this.getSelectedJk());
        registrasi.getTamu().setTempatLahir(this.form.getTxTempat().getText());
        registrasi.getTamu().setTanggalLahir(this.form.getJcbTanggalLahir().getDate());
        registrasi.getTamu().setAlamat(this.form.getTxAlamat().getText());
        registrasi.getTamu().setProvinsi(this.form.getTxProvinsi().getText());
        registrasi.getTamu().setNegara(this.form.getTxProvinsi().getText());
        registrasi.getTamu().setPhone(this.form.getTxPhone().getText());
        return registrasi.getTamu();
    }
    
    private Registrasi getRegistrasi(Tamu tamu){
        Registrasi registrasi = new Registrasi();
        OtomatisasiId oto = new OtomatisasiId();
        registrasi.setIdRegistrasi(oto.forRegistrasi());
        registrasi.getAgent().setId(this.form.getTxAgent().getText());
        registrasi.getTamu().setIdTamu(tamu.getIdTamu());
        registrasi.setDate(new Date());
        registrasi.setPax(Integer.parseInt(this.form.getTxPax().getText()));
        registrasi.setCheckIn(this.form.getJcbCheckIn().getDate());
        registrasi.setCheckOut(this.form.getJcbCheckOut().getDate());
        registrasi.setArrivalNo(this.form.getTxArrivalNo().getText());
        registrasi.setDepartureNo(this.form.getTxDepartureNo().getText());
        registrasi.setArrivalTime(this.form.getTxArrivalTime().getText());
        registrasi.setDepartureTime(this.form.getTxDepartureTime().getText());
        registrasi.setArrival_transfer(this.getSelectedArrivalTransfer());
        registrasi.setDeparture_transfer(this.getSelectedDepartureTransfer());
        return registrasi;
    }
    
    /**
     * 
     * @return integer
     */
    private int getSelectedArrivalTransfer(){
        if(this.form.getDepartureYesTransfer().isSelected()){
            return 1;
        }else{
            return 0;
        }
    }
    
    private int getSelectedJk(){
        if(this.form.getRadioMale().isSelected()){
            return 1;
        }else{
            return 0;
        }
    }
    
    /**
     * 
     * @return integer
     */
    private int getSelectedDepartureTransfer(){
        if(this.form.getArrivalYesTransfer().isSelected()){
            return 1;
        }else{
            return 0;
        }
    }
    
    public void action(){
        if(this.form.getAction() == 1){
           this.insert();
        }else if(this.form.getAction() == 2){
            System.out.println("------Update--------");
        }
    }
    
    private void insert(){
        analisasistem.interfaces.TamuInterface dataTamu = new analisasistem.dao.TamuDAO();
        Tamu t = new Tamu();
        t = this.getTamuValue();
        
        if(dataTamu.insert(t)){
            this.registrasi = this.getRegistrasi(t);
            if(this.dataReg.insert(this.registrasi)){
                JOptionPane.showMessageDialog(null, "Data Registrasi Berhasil disimpan");
                this.form.getBtnCancel().setText("Close");
            }else{
                JOptionPane.showMessageDialog(null, "Data Registrasi Gagal disimpan");
            }
            if(this.insertRegistrasiDetail(this.registrasi)){
                JOptionPane.showMessageDialog(null, "Data Registrasi Detail Berhasil disimpan");
            }else{
                JOptionPane.showMessageDialog(null, "Data Registrasi Detail Gagal disimpan");
            }
        }else{
            System.out.println("Data Tamu Gagal Disimpan");
            System.out.println("Proses registrasi tidak dapat dilakukan apabila data tamu tidak dapat tersimpan terlebih dahulu");
        }
    }
    
    private boolean insertRegistrasiDetail(Registrasi registrasi){
        boolean returnValue = true;
        this.registrasi = registrasi;
        analisasistem.interfaces.RegistrasiDetailInterface dataDetail = new analisasistem.dao.RegistrasiDetailDAO();
        String rooms[] = this.getSelectedRooms();
        for(int i=0;i<rooms.length;i++){
            RegistrasiDetail detail = new RegistrasiDetail();
            //detail.getReservasi().getUsers().setIdUser("US-1306001");
            detail.getRoom().setId(rooms[i]);
            //detail.getReservasi().setIdReservasi(registrasi.getIdRegistrasi());
            detail.getRoom().getRoomType().setId(this.listRoomsSelected.get(i).getRoomType().getId());
            System.out.println("Tipe Kamar yang dipilih "+this.listRoomsSelected.get(i).getRoomType().getId());
            if(dataDetail.insert(detail)){
                System.out.println("Insert reservasi detail berhasil dilakukan");
            }else{
                System.out.println("Insert reservasi detail gagal dilakukan");
                returnValue = false;
                
            }
        }
        return returnValue;
    }
    private String[] getSelectedRooms(){
        String rooms = this.form.getTxRooms().getText();
        String roomsArray[] = rooms.split(",");
        return roomsArray;
    }
    
    
    public void close(){
        this.form.dispose();
    }
    
    public void chooseRooms(){
        RoomsChooser chooserDialog = new RoomsChooser(null,true);
        chooserDialog.setListRooms(this.listRoomsSelected);
        chooserDialog.setTextField(this.form.getTxRooms());
        chooserDialog.starter();
        chooserDialog.setEnabled(true);
        chooserDialog.setVisible(true);
    }
    
    public void cekReservasi(){
        Person person = new Person();
        ReservasiInterface rsvData = new ReservasiDAO();
        person = rsvData.selectById(this.form.getNoReservasi().getText());
        this.setValueFormRsv(person);
    }
    
    public void setValueFormRsv(Person person){
        this.form.getTxNama().setText(person.getNama());
        this.form.getTxAlamat().setText(person.getAddress());
        this.form.getTxPhone().setText(person.getTelephone());
        this.form.getTxNegara().setText(person.getNationality());
        this.form.getJcbCheckIn().setDate(person.getReservasi().getCheckIn());
        this.form.getJcbCheckOut().setDate(person.getReservasi().getCheckOut());
        this.form.getTxArrivalNo().setText(person.getReservasi().getArrivalNo());
        this.form.getTxDepartureNo().setText(person.getReservasi().getDepartureNo());
    }
    
    public void setValueForm(Registrasi registrasi){
        this.form.getNoRegistrasi().setText(registrasi.getIdRegistrasi());
        this.form.getNoReservasi().setText(registrasi.getReservasi().getIdReservasi());
        this.form.getTxPax().setText(Integer.toString(registrasi.getPax()));
        this.form.getJcbCheckIn().setDate(registrasi.getCheckIn());
        this.form.getJcbCheckOut().setDate(registrasi.getCheckOut());
        this.form.getTxArrivalNo().setText(registrasi.getArrivalNo());
        this.form.getTxDepartureNo().setText(registrasi.getDepartureNo());
        this.form.getTxArrivalTime().setText(registrasi.getArrivalTime());
        this.form.getTxDepartureTime().setText(registrasi.getDepartureTime());
        this.setSelectedArrivalTransfer(registrasi.getArrival_transfer());
        this.setSelectedDepartureTransfer(registrasi.getDeparture_transfer());
        this.form.getTxAgent().setText(registrasi.getAgent().getId());
        
        this.form.getTxIdentitasNo().setText(registrasi.getTamu().getNoIdentitas());
        this.form.getTxNama().setText(registrasi.getTamu().getFullName());
        this.form.getTxTempat().setText(registrasi.getTamu().getTempatLahir());
        this.setSelectedJk(registrasi.getTamu().getJk());
        //this.form.getJcbTanggalLahir().setDate(new Date(registrasi.getTamu().getTempatLahir
        this.form.getTxAlamat().setText(registrasi.getTamu().getAlamat());
        this.form.getTxProvinsi().setText(registrasi.getTamu().getProvinsi());
        this.form.getTxNegara().setText(registrasi.getTamu().getNegara());
        this.form.getTxPhone().setText(registrasi.getTamu().getPhone());      
    }
    
    private void setSelectedJk(int i){
        if(i == 1){
            this.form.getRadioMale().setSelected(true);
        }else{
            this.form.getRadioFemale().setSelected(true);
        }
    }
    
    private void setSelectedArrivalTransfer(int i){
        if(i == 1){
            this.form.getArrivalYesTransfer().setSelected(true);
        }else{
            this.form.getArrivalNoTransfer().setSelected(true);
        }
    }
    
    private void setSelectedDepartureTransfer(int i){
        if(i == 1){
            this.form.getDepartureYesTransfer().setSelected(true);
        }else{
            this.form.getDepartureNoTransfer().setSelected(true);
        }
    }
    
    public void chooseAgents(){
        TravelAgentChooser chooserDialog = new TravelAgentChooser(null,true);
        chooserDialog.setTextField(this.form.getTxAgent());
        chooserDialog.setEnabled(true);
        chooserDialog.setVisible(true);
    }
}
