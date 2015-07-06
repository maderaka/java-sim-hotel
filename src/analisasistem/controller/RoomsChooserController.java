/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller;

import analisasistem.entity.Rooms;
import analisasistem.view.rooms.RoomsChooser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Raka New
 * 
 */

public class RoomsChooserController {
    private RoomsChooser chooser;
    private List<Rooms> list = new ArrayList<Rooms>();
    private JTextField txRooms;
    private List<Rooms> listRoomsSelected = new ArrayList<Rooms>(); 
    private JTextField idKamar = new JTextField();
    analisasistem.interfaces.RoomsInterface dataRooms = new analisasistem.dao.RoomsDAO();
    
    /**
     * 
     * @param chooser
     * @param txRooms 
     */
    
    public RoomsChooserController(RoomsChooser chooser, JTextField txRooms, List<Rooms> listRoomsSelected){
        this.chooser = chooser;
        this.txRooms = txRooms;
        this.listRoomsSelected = listRoomsSelected;
        this.defaultConfig();
    }
    
    public RoomsChooserController(RoomsChooser chooser, JTextField txRooms,JTextField idKamar, List<Rooms> listRoomsSelected){
        this.chooser = chooser;
        this.txRooms = txRooms;
        this.idKamar = idKamar;
        this.listRoomsSelected = listRoomsSelected;
        this.defaultConfig();
    }
    
    /**
     * 
     */
    private void defaultConfig(){
        this.isiTable();
    }
    
    /**
     * 
     */
    private void isiTable(){
        this.list = this.dataRooms.getAll();
        analisasistem.model.tableModel.RoomsWithTypeModel model = new analisasistem.model.tableModel.RoomsWithTypeModel(this.list);
        this.chooser.getTbRoomsChooser().setModel(model);
    }
    
    public void action(){
        if(this.chooser.getSingleChoose() == 1){
            this.chooseSingleRoom();
        }else if(this.chooser.getSingleChoose() == 2){
            this.choose();
        }
    }
    
    private void choose(){
        int row[] = this.chooser.getTbRoomsChooser().getSelectedRows();
        String rooms = "";
        for(int i =0;i<row.length;i++){
            if(!(i == (row.length-1))){
                rooms += (String) this.chooser.getTbRoomsChooser().getValueAt(row[i], 0)+",";
            }else{
                rooms += (String) this.chooser.getTbRoomsChooser().getValueAt(row[i], 0);
            }
            Rooms roomsEntity = new Rooms();
            roomsEntity.getRoomType().setId((String) this.chooser.getTbRoomsChooser().getValueAt(row[i], 2));
            roomsEntity.setId((String) this.chooser.getTbRoomsChooser().getValueAt(row[i], 0));
            this.listRoomsSelected.add(roomsEntity);
        }
        String a[] = new String[row.length];
        a = rooms.split(",");
        this.chooser.setListRooms(this.listRoomsSelected);
        this.chooser.getTx().setText(rooms);
        this.chooser.dispose();
    }
    
    private void chooseSingleRoom(){
        int row = this.chooser.getTbRoomsChooser().getSelectedRow();
        //this.chooser.getIdKamar().setText((String) this.chooser.getTbRoomsChooser().getValueAt(row, 0));
        System.out.println("Id Kamar = "+(String) this.chooser.getTbRoomsChooser().getValueAt(row, 0));
        this.chooser.getTx().setText((String) this.chooser.getTbRoomsChooser().getValueAt(row, 0));
        //System.out.println("Id Kamar di Chooser : "+this.chooser.getIdKamar().getText());
        this.chooser.dispose();
    }
    
    public void dispose(){
        this.chooser.dispose();
    }
}
