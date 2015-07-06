/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller;

import analisasistem.entity.RoomType;
import analisasistem.view.roomtype.RoomTypeDialog;
import analisasistem.dao.RoomTypeDAO;
import analisasistem.model.tableModel.RoomTypeModel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Raka New
 */

public class RoomTypeDialogController {
    
   /**
    * 
    */
    private RoomType roomType = new RoomType();
    private RoomTypeDialog roomTypeDialog;    
    private List<RoomType> list;
    private RoomTypeDAO roomTypeDAO;
    private RoomTypeModel roomTypeModel;
            
    /**
     * 
     * @param roomTypeDialog 
     */
    public RoomTypeDialogController(RoomTypeDialog roomTypeDialog){
        this.roomTypeDialog = roomTypeDialog;
        this.roomTypeDAO = new RoomTypeDAO();
    }
    
    /**
     * 
     */
    public void isiRoomTypeId(){
        analisasistem.library.OtomatisasiId oto = new analisasistem.library.OtomatisasiId();
        this.roomTypeDialog.getTxId().setText(oto.forRoomType());
    }
    
    /**
     * 
     */
    public void insert(){
        this.roomType.setId(this.roomTypeDialog.getTxId().getText());
        this.roomType.setName(this.roomTypeDialog.getTxNama().getText());
        this.roomType.setKeterangan(this.roomTypeDialog.getTxAreaKeterangan().getText()); 
        this.roomType.setJumlah_kasur(Integer.parseInt(this.roomTypeDialog.getSpinJumlahKasur().getValue()+""));
        this.roomType.setCost(Integer.parseInt(this.roomTypeDialog.getBiaya().getText()));
        if(this.roomTypeDAO.insert(roomType)){
            JOptionPane.showMessageDialog(this.roomTypeDialog,"Penambahan Data Tipe Kamar berhasil dilakukan");
        }
    }
    
    /**
     * 
     */
    public void isiTable(){
        list  = this.roomTypeDAO.getAll();
        this.roomTypeModel = new RoomTypeModel(list);
        this.roomTypeDialog.getTbRoomType().setModel(roomTypeModel);
    }
    
    /**
     * 
     */
    public void reset(){
        this.roomTypeDialog.getTxId().setText("");
        this.roomTypeDialog.getTxNama().setText("");
        this.roomTypeDialog.getTxAreaKeterangan().setText("");
        this.roomTypeDialog.getSpinJumlahKasur().setValue(0);
        this.roomTypeDialog.getBiaya().setText("");
    }
    
    /**
     * 
     */
    public void update(){
        this.roomType.setId(this.roomTypeDialog.getTxId().getText());
        this.roomType.setName(this.roomTypeDialog.getTxNama().getText());
        this.roomType.setKeterangan(this.roomTypeDialog.getTxAreaKeterangan().getText());
        this.roomType.setCost(Integer.parseInt(this.roomTypeDialog.getBiaya().getText()));
    }
    
    /**
     * 
     * @param row 
     */
    public void isiField(int row){
        String id = (String) this.roomTypeDialog.getTbRoomType().getValueAt(row, 0);
        this.roomType = this.roomTypeDAO.getById(id);
        this.roomTypeDialog.getTxId().setText(this.roomType.getId());
        this.roomTypeDialog.getTxNama().setText(this.roomType.getName());
        this.roomTypeDialog.getTxAreaKeterangan().setText(this.roomType.getKeterangan());
        this.roomTypeDialog.getSpinJumlahKasur().setValue(this.roomType.getJumlah_kasur());
        this.roomTypeDialog.getBiaya().setText(Integer.toString(this.roomType.getCost()));
    }
}
