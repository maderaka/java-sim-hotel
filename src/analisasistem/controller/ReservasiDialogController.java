/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package analisasistem.controller;
import analisasistem.entity.Person;
import analisasistem.entity.Reservasi;
import analisasistem.entity.ReservasiDetail;
import analisasistem.entity.Rooms;
import analisasistem.library.OtomatisasiId;
import analisasistem.view.reservasi.ReservasiFormDialog;
import analisasistem.view.rooms.RoomsChooser;
import analisasistem.view.travelAgent.TravelAgentChooser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Raka New
 */

public class ReservasiDialogController {
    private ReservasiFormDialog dialog;
    private analisasistem.entity.Reservasi reservasi;
    private String user;
    private analisasistem.interfaces.ReservasiInterface data;
    private JFrame frame;
    private List<Rooms> listRooms = new ArrayList<Rooms>();
    public ReservasiDialogController(ReservasiFormDialog dialog){
        this.dialog = dialog;
        this.reservasi = new analisasistem.entity.Reservasi();
        this.data = new analisasistem.dao.ReservasiDAO();
        this.user = "US-1306001";
        this.defaultConfig();
    }
    
    private void setRadioTransfer(){
        this.dialog.getRadioNoArrival().setSelected(true);
        this.dialog.getRadioNoDeparture().setSelected(true);
    }
    /**
     * 
     * 
     */
    public void action(){
        if(this.dialog.getAction() == 1){
            this.insert();
        }else if(this.dialog.getAction() == 2){
            this.update();
        }
    }
    
    /**
     * 
     */
    private void insert(){
        Person p = new Person();
        p = this.getValuePerson();
        if(!"".equals(p.getId())){
            analisasistem.interfaces.PersonInterface personData = new analisasistem.dao.PersonDAO();
            this.reservasi = this.getValueReservasi(p);
            if(data.insert(this.reservasi)){
                JOptionPane.showMessageDialog(null, "Well done! Penambahan Data Reservasi berhasil dilakukan");
                p.setReservasi(reservasi);
                if(personData.insert(p)){
                    JOptionPane.showMessageDialog(null, "Well done! Penambahan Data Person berhasil dilakukan");
                }else{
                    JOptionPane.showMessageDialog(null, "Error! Penambahan Data Person Gagal dilakukan");
                }
                
                if(this.insertReservasiDetail(this.reservasi)){
                    JOptionPane.showMessageDialog(null, "Well done! Penambahan Data Reservsai Detail berhasil dilakukan");
                }else{
                    JOptionPane.showMessageDialog(null, "Well done! Penambahan Data Reservasi Detail gagal dilakukan");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error! Penambahan Data Reservasi Gagal dilakukan");
            }
        }
    }
    
    private boolean insertReservasiDetail(Reservasi reservasi){
        boolean returnValue = true;
        this.reservasi = reservasi;
        analisasistem.interfaces.ReservasiDetailInterface dataDetail = new analisasistem.dao.ReservasiDetailDAO();
        String rooms[] = this.getSelectedRooms();
        for(int i=0;i<rooms.length;i++){
            ReservasiDetail detail = new ReservasiDetail();
            detail.getReservasi().getUsers().setIdUser("US-1306001");
            detail.getRoom().setId(rooms[i]);
            detail.getReservasi().setIdReservasi(reservasi.getIdReservasi());
            detail.getRoom().getRoomType().setId(this.listRooms.get(i).getRoomType().getId());
            System.out.println("Tipe Kamar yang dipilih "+this.listRooms.get(i).getRoomType().getId());
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
        String rooms = this.dialog.getTxRooms().getText();
        String roomsArray[] = rooms.split(",");
        return roomsArray;
    }
    /**
     * 
     */
    private void update(){
        Person p = new Person();
        p = this.getValuePerson();
        if(!"".equals(p.getId())){
            analisasistem.interfaces.PersonInterface personData = new analisasistem.dao.PersonDAO();
            this.reservasi = this.getValueReservasi(p);
            if(data.update(this.reservasi)){
                JOptionPane.showMessageDialog(null, "Well done! Perubahan Data Reservasi berhasil dilakukan");
                p.setReservasi(reservasi);
                if(personData.update(p)){
                    JOptionPane.showMessageDialog(null, "Well done! Perubahan Data Person berhasil dilakukan");
                }else{
                    JOptionPane.showMessageDialog(null, "Error! Perubahan Data Person Gagal dilakukan");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Error! Perubahan Data Reservasi Gagal dilakukan");
            }
        }
    }
    
    /**
     * 
     * @param person
     * @return 
     */
    private analisasistem.entity.Reservasi getValueReservasi(Person person){
        this.reservasi.getUsers().setIdUser(this.user);
        this.reservasi.setIdPerson(person.getId());
        this.reservasi.setIdReservasi(this.dialog.getTxNoReservasi().getText());
        this.reservasi.getAgent().setId(this.dialog.getTxAgent().getText());
        this.reservasi.setCheckIn(new java.sql.Date(this.dialog.getJcbCheckIn().getDate().getTime()));
        this.reservasi.setCheckOut(new java.sql.Date(this.dialog.getJcbCheckOut().getDate().getTime()));
        this.reservasi.setArrivalTime(this.dialog.getTxArrivalTime().getText());
        this.reservasi.setDepartureTime(this.dialog.getTxDepartureTime().getText());
        this.reservasi.setArrivalNo(this.dialog.getTxArrivalNo().getText());
        this.reservasi.setDepartureNo(this.dialog.getTxDepartureNo().getText());
        this.reservasi.setArrival_transfer(this.getSelectedArrivalTransfer());
        this.reservasi.setDeparture_transfer(this.getSelectedDepartureTransfer());
        this.reservasi.setMemo(this.dialog.getTxAreaMemo().getText());
        return this.reservasi;
    }
    
    /**
     * 
     * @return integer
     */
    private int getSelectedArrivalTransfer(){
        if(this.dialog.getRadioYesArrival().isSelected()){
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
        if(this.dialog.getRadioYesDeparture().isSelected()){
            return 1;
        }else{
            return 0;
        }
    }
    
    private analisasistem.entity.Person getValuePerson(){
        OtomatisasiId oto = new OtomatisasiId();
        Person person = new Person();
        person.getUser().setIdUser("US-1306001");
        person.setId(oto.forPerson());
        person.setNama(this.dialog.getTxFirstName().getText());
        person.setTelephone(this.dialog.getTxPhone().getText());
        person.setCompany(this.dialog.getTxCompany().getText());
        person.setEmail(this.dialog.getTxEmail().getText());
        person.setAddress(this.dialog.getTxAddress().getText());
        person.setState(this.dialog.getTxState().getText());
        person.setNationality(this.dialog.getTxNationallity().getText());
        return person;
    }
    
    /**
     * 
     */
    public void defaultConfig(){
        analisasistem.library.OtomatisasiId oto = new analisasistem.library.OtomatisasiId();
        this.dialog.getTxNoReservasi().setText(oto.forReservasi());
        this.dialog.setAction(1);
        this.setRadioTransfer();
    }
    
    /**
     * 
     */
    public void close(){
        this.dialog.dispose();
    }
    
    public void chooseRooms(){
        RoomsChooser chooserDialog = new RoomsChooser(null,true);
        chooserDialog.setListRooms(this.listRooms);
        chooserDialog.setTextField(this.dialog.getTxRooms());
        chooserDialog.starter();
        chooserDialog.setEnabled(true);
        chooserDialog.setVisible(true);
    }
    
    public void chooseAgents(){
        TravelAgentChooser chooser = new TravelAgentChooser(null,true);
        chooser.setTextField(this.dialog.getTxAgent());
        chooser.setVisible(true);
        chooser.setEnabled(true);
    }
    
}