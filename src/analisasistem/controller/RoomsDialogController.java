/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller;

import analisasistem.dao.RoomTypeDAO;
import analisasistem.dao.RoomsDAO;
import analisasistem.entity.RoomType;
import analisasistem.entity.Rooms;
import analisasistem.model.tableModel.RoomTypeModel;
import analisasistem.model.tableModel.RoomsModel;
import analisasistem.view.rooms.RoomsDialog;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Raka New
 */
public class RoomsDialogController {
    private RoomsDialog roomsDialog;
    private Rooms rooms = new Rooms();
    private List<Rooms> listRooms = new ArrayList<Rooms>();
    private RoomsDAO roomsDAO;
    private RoomTypeModel roomTypeModel;
    public RoomsDialogController(RoomsDialog roomsDialog){
        this.roomsDialog = roomsDialog;
        this.roomsDAO = new RoomsDAO();
        this.roomsDialog.setAction(true);
    }
    
    /**
     * 
     */
    
    public void isiTable(){
        this.listRooms = this.roomsDAO.getAll();
        RoomsModel model = new RoomsModel(this.listRooms);
        this.roomsDialog.getTblRooms().setModel(model);
    }
    
    /**
     * 
     */
    public void defaultConfig(){
        analisasistem.library.OtomatisasiId oto = new analisasistem.library.OtomatisasiId();
        this.roomsDialog.getTxId().setText(oto.forRooms());
    }
    public void reset(){
        this.roomsDialog.getTxName().setText("");
        this.roomsDialog.getTxId().setText("");
    }
    public void isiForm(){
        List <RoomType> listRoomType;
        RoomTypeDAO roomsTypeDAO = new RoomTypeDAO();
        listRoomType = roomsTypeDAO.getAll();
        this.roomTypeModel = new RoomTypeModel(listRoomType);
        this.roomsDialog.getJcbRoomType().removeAllItems();
        for(int i=0;i<roomTypeModel.getRowCount();i++){
            this.roomsDialog.getJcbRoomType().addItem(roomTypeModel.getValueAt(i, 1));
        }
    }
    public void insert(){
        //Mengambil nilai
        int i = this.roomsDialog.getJcbRoomType().getSelectedIndex();
        String id_tipe = (String) this.roomTypeModel.getValueAt(i, 0);
        //end
        this.rooms.setId(this.roomsDialog.getTxId().getText());
        this.rooms.setNo(this.roomsDialog.getTxName().getText());
        this.rooms.getRoomType().setId(id_tipe);
        if(this.roomsDAO.insert(rooms)){
            JOptionPane.showMessageDialog(this.roomsDialog, "Penambahan data rooms berhasil dilakukan");
        }
    }
    public void update(){
        this.rooms.setId(this.roomsDialog.getTxId().getText());
        this.rooms.setNo(this.roomsDialog.getTxName().getText());
        this.rooms.getRoomType().setId(this.getRoomTypeSelected());
        analisasistem.interfaces.RoomsInterface roomsData = new analisasistem.dao.RoomsDAO();
        roomsData.update(rooms);
    }
    
    public void viewData(){
        String id = (String) this.roomsDialog.getTblRooms().getValueAt(this.roomsDialog.getTblRooms().getSelectedRow(), 0);
        analisasistem.interfaces.RoomsInterface roomsData = new analisasistem.dao.RoomsDAO();
        this.rooms = roomsData.getByid(id);
        this.roomsDialog.getTxId().setText(this.rooms.getId());
        this.roomsDialog.getTxName().setText(this.rooms.getNo());
        this.setRoomTypeSelected(this.rooms.getRoomType().getId());
        this.roomsDialog.setAction(false);
    }
    
    /**
     * 
     * @param idRoomType 
     */
    private void setRoomTypeSelected(String idRoomType){
        for(int i=0;i<this.roomTypeModel.getRowCount();i++){
            if(this.roomTypeModel.getValueAt(i, 0).equals(idRoomType)){
                this.roomsDialog.getJcbRoomType().setSelectedIndex(i);
            }
        }
    }
    
    /**
     * 
     * @return 
     */
    private String getRoomTypeSelected(){
        String id = (String) this.roomTypeModel.getValueAt(this.roomsDialog.getJcbRoomType().getSelectedIndex(), 0);
        return id;
    }
}
