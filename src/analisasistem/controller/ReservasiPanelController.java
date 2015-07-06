/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package analisasistem.controller;
import analisasistem.dao.ReservasiDAO;
import analisasistem.entity.Person;
import analisasistem.entity.Reservasi;
import analisasistem.interfaces.ReservasiInterface;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raka New
 */
public class ReservasiPanelController{
    
    /**
     * 
     */
    private analisasistem.view.reservasi.ReservasiPanel panel;
    private analisasistem.interfaces.ReservasiInterface data = new analisasistem.dao.ReservasiDAO();
    private List<Reservasi> list = new ArrayList<Reservasi>();
    
    /**
     * 
     * @param panel 
     */
    public ReservasiPanelController(analisasistem.view.reservasi.ReservasiPanel panel){
        this.panel = panel;
    }
    
    /**
     * 
     */
    public void isiTable(){
        this.list = data.selectAll();
        analisasistem.model.tableModel.ReservasiModel model = new analisasistem.model.tableModel.ReservasiModel(this.list);
        this.panel.getTbReservasi().setModel(model);
    }
    
    /**
     * 
     */
    public void addReservasi(){
        analisasistem.view.reservasi.ReservasiFormDialog dialog = new analisasistem.view.reservasi.ReservasiFormDialog(null,true);
        dialog.setEnabled(true);
        dialog.setVisible(true);
    }
    
    public void viewData(){
        String noReservasi = (String) this.panel.getTbReservasi().getValueAt(this.panel.getTbReservasi().getSelectedRow(), 1);
        Person person = new Person();
        analisasistem.view.reservasi.ReservasiFormDialog dialog = new analisasistem.view.reservasi.ReservasiFormDialog(null,true);
        this.setValueForm(dialog, this.getPersonData(noReservasi));
        dialog.setAction(2);
        dialog.setEnabled(true);
        dialog.setVisible(true);
    }
    
    private Person getPersonData(String noReservasi){
        Person person = new Person();
        ReservasiInterface reservasiData = new ReservasiDAO();
        person = reservasiData.selectById(noReservasi);
        return person;
    }
    
    /**
     * 
     * @param dialog
     * @param reservasi 
     * Masih revisi
     */
    private void setValueForm(analisasistem.view.reservasi.ReservasiFormDialog dialog, Person person){
        dialog.getTxNoReservasi().setText(person.getReservasi().getIdReservasi());
        dialog.getTxFirstName().setText(person.getNama());
        dialog.getTxCompany().setText(person.getCompany());
        dialog.getTxPhone().setText(person.getTelephone());
        dialog.getTxEmail().setText(person.getEmail());
        dialog.getTxAddress().setText(person.getAddress());
        dialog.getTxState().setText(person.getState());
        dialog.getTxNationallity().setText(person.getNationality());
        dialog.getJcbCheckIn().setDate(person.getReservasi().getCheckIn());
        dialog.getJcbCheckOut().setDate(person.getReservasi().getCheckOut());
        dialog.getTxArrivalNo().setText(person.getReservasi().getArrivalNo());
        dialog.getTxDepartureNo().setText(person.getReservasi().getDepartureNo());
        dialog.getTxArrivalTime().setText(person.getReservasi().getArrivalTime());
        dialog.getTxDepartureTime().setText(person.getReservasi().getDepartureTime());
        this.setSelectedArrivalTransfer(dialog, person.getReservasi().getArrival_transfer());
        this.setSelectedDepartureTransfer(dialog, person.getReservasi().getDeparture_transfer());
        dialog.getTxAreaMemo().setText(person.getReservasi().getMemo());
        dialog.getTxAgent().setText(person.getReservasi().getAgent().getId());
    }
    
    private void setSelectedArrivalTransfer(analisasistem.view.reservasi.ReservasiFormDialog dialog,int i){
        if(i == 1){
            dialog.getRadioYesArrival().setSelected(true);
        }else{
            dialog.getRadioNoArrival().setSelected(true);
        }
    }
    
    private void setSelectedDepartureTransfer(analisasistem.view.reservasi.ReservasiFormDialog dialog, int i){
        if(i == 1){
            dialog.getRadioYesDeparture().setSelected(true);
        }else{
            dialog.getRadioNoDeparture().setSelected(true);
        }
    }
    /**
     * 
     * @param dialog
     * @param noReservasi 
     */
    /*private void setBookingCart(analisasistem.view.reservasi.ReservasiFormDialog dialog, String noReservasi){
        analisasistem.interfaces.ReservasiDetailInterface dataReservasi = new analisasistem.dao.ReservasiDetailDAO();
        List<analisasistem.entity.ReservasiDetail> listRsvDetail = dataReservasi.selectByIdReservasi(noReservasi);
        
        analisasistem.model.tableModel.ReservasiDetailModel model = new analisasistem.model.tableModel.ReservasiDetailModel(listRsvDetail);
        
        dialog.getTbBookingCart().setModel(model);
    }*/
}