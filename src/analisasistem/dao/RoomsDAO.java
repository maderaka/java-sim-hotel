/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.config.Database;
import analisasistem.entity.Rooms;
import analisasistem.interfaces.RoomsInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raka New
 */
public class RoomsDAO implements RoomsInterface{
    private List<Rooms> listRooms;
    private Connection conn;
    private Statement stat;
    private PreparedStatement pStat;
    private ResultSet rs;
    public RoomsDAO(){
        this.conn = Database.getConn();
    }

    /**
     * 
     * @return 
     */
    @Override
    public List<Rooms> getAll(){
        this.listRooms = new ArrayList<Rooms>();
        try{
            this.stat = this.conn.createStatement();
            this.rs = stat.executeQuery(SELECT);
            while(rs.next()){
                Rooms room =  new Rooms();
                room.setId(rs.getString("id"));
                room.setNo(rs.getString("no"));
                room.getRoomType().setId(rs.getString("id_tipe_kamar"));
                room.getRoomType().setName(rs.getString("tipe_kamar"));
                this.listRooms.add(room);
            }
        }catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }
        return this.listRooms;
    }

    /**
     * 
     * @param room
     * @return 
     */
    @Override
    public boolean insert(Rooms room){
        boolean status = false;
        this.pStat = null;
        try{
            pStat = this.conn.prepareStatement(INSERT);
            pStat.setString(1, room.getId());
            pStat.setString(2, room.getNo());
            pStat.setString(3, room.getRoomType().getId());
            
            if(pStat.executeUpdate() == 1){
                status = true;
            }else{
                status = false;
            }
        }catch(SQLException e){
            System.out.println("Error "+e.getMessage());
        }
        return false;
        
    }

    @Override
    public boolean delete(String id) {
        try{
            this.pStat = this.conn.prepareStatement(DELETE);
            this.pStat.setString(1, id);
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * 
     * @param rooms
     * @return 
     */
    @Override
    public boolean update(Rooms rooms) {
        try{
            this.pStat = this.conn.prepareStatement(UPDATE);
            this.pStat.setString(1, rooms.getNo());
            this.pStat.setString(2, rooms.getRoomType().getId());
            this.pStat.setString(3, rooms.getId());
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public List<Rooms> getByType(String id) {
        try{
            this.pStat = this.conn.prepareStatement(CARI_BY_TYPE);
            this.pStat.setString(1, id);
            this.rs = this.pStat.executeQuery();
            while(this.rs.next()){
                Rooms rooms = new Rooms();
                rooms.setId(rs.getString("id_kamar"));
                rooms.setNo(rs.getString("no_kamar"));
                rooms.getRoomType().setId("id_tipekamar");
                this.listRooms.add(rooms);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return this.listRooms;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getMaxId() {
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_MAX_ID);
            if(this.rs.next()){
                return this.rs.getString(1);
            }else{
                return null;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 
     * @param id
     * @return 
     */
    @Override
    public Rooms getByid(String id) {
        Rooms rooms = new Rooms();
        try{
            this.pStat = this.conn.prepareStatement(SELECT_BY_ID);
            this.pStat.setString(1, id);
            this.rs = this.pStat.executeQuery();
            if(this.rs.next()){
                rooms.setId(this.rs.getString("id_kamar"));
                rooms.setNo(this.rs.getString("no_kamar"));
                rooms.getRoomType().setId(rs.getString("id_tipekamar"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return rooms;
    }
    
    /**
     * 
     */
    final String SELECT             = "SELECT kamar.id_kamar AS id ,kamar.no_kamar AS no,tipe_kamar.nama_tipekamar as tipe_kamar, tipe_kamar.id_tipekamar as id_tipe_kamar FROM `kamar` JOIN `tipe_kamar` ON `kamar`.`id_tipekamar`=`tipe_kamar`.`id_tipekamar`;";
    final String INSERT             = "INSERT INTO kamar(id_kamar,no_kamar,id_tipekamar) VALUES(?,?,?);";
    final String DELETE             = "DELETE `kamar` WHERE id_kamar=?;";
    final String UPDATE             = "UPDATE `kamar` SET `no_kamar`=?,'id_tipekamar`=? WHERE `id_kamar`=?;";
    final String CARI_BY_TYPE       = "SELECT * FROM `kamar` WHERE `id_tipekamar`=?;";
    final String SELECT_BY_ID       = "SELECT * FROM `kamar` WHERE `id_kamar`=?;";
    final String SELECT_MAX_ID      = "SELECT MAX(`id_kamar`) FROM `kamar`";
    final String SELECT_ID_BY_NAME  = "SELECT 'id_kamar' FROM `kamar` WHERE `no_kamar`=?";

    @Override
    public String selectIdByName(String name) {
        
         //To change body of generated methods, choose Tools | Templates.
        
        try{
            this.pStat = this.conn.prepareStatement(SELECT_ID_BY_NAME);
            this.pStat.setString(1, name);
            this.rs = this.pStat.executeQuery();
            if(rs.next()){
                return rs.getString("id_kamar");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
