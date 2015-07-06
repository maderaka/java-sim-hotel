/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.entity.RoomType;
import analisasistem.interfaces.RoomTypeInterface;
import analisasistem.config.Database;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raka New
 */
public class RoomTypeDAO implements RoomTypeInterface{
    private java.sql.Connection conn = null;
    final String INSERT         = "INSERT INTO `tipe_kamar`(`id_tipekamar`, `nama_tipekamar`, `cost_night_tipekamar`, "
                                    + "`bed_tipekamar`, `desc_tipekamar`) "
                                    + "VALUES (?,?,?,?,?)";
    final String UPDATE         = "UPDATE `tipe_kamar` SET `nama_tipekamar`=?,"
                                    + "`cost_night_tipekamar`=?,`bed_tipekamar`=?,"
                                    + "`desc_tipekamar`=? WHERE `id_tipekamar`=?";
    final String DELETE         = "DELETE FROM `tipe_kamar` WHERE `id_tipekamar`=?;";
    final String SELECT         = "SELECT * FROM `tipe_kamar`;";
    final String CARINAME       = "SELECT * FROM `tipe_kamar`;";
    final String CARI_BY_ID     = "SELECT * FROM `tipe_kamar` WHERE `id_tipekamar`=?;";
    final String SELECT_MAX_ID  = "SELECT MAX(`id_tipekamar`) FROM `tipe_kamar`";
    
    public RoomTypeDAO(){
        this.conn = Database.getConn();
    }

    @Override
    public boolean insert(RoomType roomType) {
        boolean status = false;
        PreparedStatement pStat =  null;
        try{
            pStat = this.conn.prepareStatement(INSERT);
            pStat.setString(1, roomType.getId());
            pStat.setString(2, roomType.getName());
            pStat.setInt(3, roomType.getCost());
            pStat.setInt(4, roomType.getJumlah_kasur());
            pStat.setString(5, roomType.getKeterangan());
            if(pStat.executeUpdate() == 1){
                status = true;
            }else{
                status = false;
            }
        }catch(SQLException e){
            status = false;
            System.out.println("Error = "+e.getMessage());
        }finally{
            try {
                pStat.close();
            } catch (SQLException ex) {
                Logger.getLogger(RoomTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return status;
    }

    @Override
    public boolean delete(String id) {
        boolean status = false;
        PreparedStatement pStat = null;
        try{
            pStat = this.conn.prepareStatement(DELETE);
            pStat.setString(1, id);
            if(pStat.executeUpdate() == 1){
                status = true;
            }else{
                status = false;
            }
        }catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }finally{
            try{
                pStat.close();
            }catch(SQLException e){
                System.out.println("Error "+e.getMessage());
            }
        }
        return status;
    }

    @Override
    public boolean update(RoomType roomType) {
        boolean status=false;
        PreparedStatement pStat = null;
        try{
            pStat = this.conn.prepareStatement(UPDATE);
            pStat.setString(1,roomType.getName());
            pStat.setInt(2, roomType.getCost());
            pStat.setInt(3, roomType.getJumlah_kasur());
            pStat.setString(4,roomType.getKeterangan());
            pStat.setString(5,roomType.getId());
            pStat.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }finally{
            try{
                pStat.close();
            }catch(SQLException e){
                
            }
        }
        return status;
    }

    @Override
    public List<RoomType> getAll(){
        List<RoomType> listRoomType = null;
        listRoomType = new ArrayList<RoomType>();
        try{
            Statement stat = this.conn.createStatement();
            ResultSet rs = stat.executeQuery(SELECT);
            while(rs.next()){
                RoomType roomType = new RoomType();
                roomType.setId(rs.getString("id_tipekamar"));
                roomType.setName(rs.getString("nama_tipekamar"));
                roomType.setKeterangan(rs.getString("desc_tipekamar"));
                roomType.setJumlah_kasur(rs.getInt("bed_tipekamar"));
                roomType.setCost(rs.getInt("cost_night_tipekamar"));
                listRoomType.add(roomType);
            }
        }catch(SQLException e){
            System.out.println("Terdapat patal error "+e.getMessage());
        }
        return listRoomType;
    }
    
    @Override
    public List<RoomType> getByKeyword(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RoomType getById(String id){
        System.out.println(id);
        RoomType roomType = new RoomType();
        PreparedStatement pStat = null;
        try{
            pStat = this.conn.prepareStatement(CARI_BY_ID);
            pStat.setString(1, id);
            ResultSet rs = pStat.executeQuery();
            while(rs.next()){
                roomType.setId(rs.getString("id_tipekamar"));
                roomType.setName(rs.getString("nama_tipekamar"));
                roomType.setKeterangan(rs.getString("desc_tipekamar"));
                roomType.setJumlah_kasur(rs.getInt("bed_tipekamar"));
                roomType.setCost(rs.getInt("cost_night_tipekamar"));
            }
        }catch(SQLException e){
            System.out.println("Error get ById "+e.getMessage());
        }
        return roomType;
    }

    @Override
    public String getMaxId() {
        try{
            Statement stat = this.conn.createStatement();
            ResultSet rs = stat.executeQuery(SELECT_MAX_ID);
            if(rs.next()){
                return rs.getString(1);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
