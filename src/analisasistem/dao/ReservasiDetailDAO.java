/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.entity.ReservasiDetail;
import analisasistem.interfaces.ReservasiDetailInterface;
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
public class ReservasiDetailDAO implements ReservasiDetailInterface {
    private Connection conn;
    private ResultSet rs;
    private Statement stat;
    private PreparedStatement pStat;
    private List<ReservasiDetail> list = new ArrayList<ReservasiDetail>();
    public ReservasiDetailDAO(){
        this.conn = analisasistem.config.Database.getConn();
    }

    @Override
    public boolean insert(ReservasiDetail detail) {
        
         // To change body of generated methods, choose Tools | Templates.
         // INSERT INTO `detail_reservasi`(`id_user`, `id_reservasi`, `id_tipekamar`, `id_kamar`) 
         // VALUES ([value-1],[value-2],[value-3],[value-4],[value-5]) 
        
        try{
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, detail.getReservasi().getUsers().getIdUser());
            this.pStat.setString(2, detail.getReservasi().getIdReservasi());
            this.pStat.setString(3, detail.getRoom().getRoomType().getId());
            this.pStat.setString(4, detail.getRoom().getId());
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

    @Override
    public boolean update(ReservasiDetail detail) {
         //To change body of generated methods, choose Tools | Templates.
        try{
            this.pStat = this.conn.prepareStatement(UPDATE);
            this.pStat.setString(1, detail.getReservasi().getIdReservasi());
            this.pStat.setString(2, detail.getRoom().getId());
            
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

    @Override
    public List<ReservasiDetail> selectAll() {
        //To change body of generated methods, choose Tools | Templates.
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_ALL);
            while(this.rs.next()){
                
            }
        }catch(SQLException e){
            
        }
        return this.list;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReservasiDetail> selectByIdReservasi(String idReservasi) {
        //To change body of generated methods, choose Tools | Templates.
        try{
            this.pStat = this.conn.prepareStatement(SELECT_BY_RESERVASI);
            this.pStat.setString(1, idReservasi);
            this.rs = this.pStat.executeQuery();
            while(this.rs.next()){
                ReservasiDetail obj = new ReservasiDetail();
                obj.getRoom().setId(rs.getString("id_rooms"));
                obj.getRoom().setNo(rs.getString("name_rooms"));
                obj.getRoom().getRoomType().setName(rs.getString("tipe_kamar"));
                this.list.add(obj);
            }
        }catch(SQLException e){
            System.out.println("Terdapat error pada "+e.getMessage());
        }
        return this.list;
    }

    @Override
    public List<ReservasiDetail> selectById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private final String INSERT = "INSERT INTO `detail_reservasi`(`id_user`, `id_reservasi`, `id_tipekamar`, `id_kamar`) VALUES (?,?,?,?)";
    private final String DELETE = "UPDATE `detail_reservasi` SET "
            + "`id_user`=?,"
            + "`id_reservasi`=?,"
            + "`id_tipekamar`=?,"
            + "`id_kamar`=?,"
            + "`id_detail_reservasi`=? "
            + "WHERE `id_detail_reservasi";
    private final String DELETE_BY_RESERVASI = "DELETE FROM `tbreservasidetail` WHERE `id_reservasi`=?";
    private final String UPDATE = "UPDATE `tbreservasidetail` SET `id_reservasi`=?,`id_rooms`=?,`check_in`=?,`check_out`=? WHERE `id_detail`=?;";
    private final String SELECT_ALL = "SELECT `id_detail`, `id_reservasi`, `id_rooms`, `check_in`, `check_out` FROM `tbreservasidetail`";
    private final String SELECT_BY_RESERVASI = "SELECT `tbreservasidetail`.`id_detail` , `tbreservasidetail`.`id_rooms` , `tbreservasidetail`.`check_in` , `tbreservasidetail`.`check_out` , `tbrooms`.`name_rooms` , `tbroomtype`.`name` AS `tipe_kamar`\n" +
        "FROM `tbreservasidetail`\n" +
        "JOIN `tbrooms` ON `tbrooms`.`id_rooms` = `tbreservasidetail`.`id_rooms`\n" +
        "JOIN `tbroomtype` ON `tbrooms`.`id_roomtype` = `tbroomtype`.`id`\n" +
        "WHERE `id_reservasi` = ?";
}
