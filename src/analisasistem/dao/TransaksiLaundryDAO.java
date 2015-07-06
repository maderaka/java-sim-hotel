/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.config.Database;
import analisasistem.entity.TransaksiLaundry;
import analisasistem.interfaces.TransaksiLaundryInterface;
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

public class TransaksiLaundryDAO implements TransaksiLaundryInterface{
    
    private List<TransaksiLaundry> list = new ArrayList<TransaksiLaundry>();
    private Statement stat;
    private PreparedStatement pStat;
    private ResultSet rs;
    private Connection conn;
    
    private final String INSERT = "INSERT INTO `transaksi_laundry`"
            + "(`reg_id_user`, "
            + "`id_registrasi`, "
            + "`id_transaksi_laundry`, "
            + "`id_user`, "
            + "`total_transaksi_laundry`, "
            + "`date_transaksi_laundry`, "
            + "`date_selesai_transaksi_laundry`, "
            + "`name_guest`, "
            + "`id_kamar`) "
            + "VALUES (?,?,?,?,?,?,?,?,?)";
    
    private final String UPDATE = "UPDATE `detail_reservasi` SET "
            + "`id_user`=?,"
            + "`id_reservasi`=?,"
            + "`id_tipekamar`=?,"
            + "`id_kamar`=? "
            + "WHERE `id_detal_reservasi`=?";
    
    private final String SELECT_ALL = "SELECT * FROM `transaksi_laundry` INNER JOIN `kamar` ON `kamar`.`id_kamar`=`transaksi_laundry`.`id_kamar`";
    private final String SELECT_BY_ID = "";
    private final String DELETE = "";
    private final String SELECT_MAX = "SELECT MAX(`id_transaksi_laundry`) FROM `transaksi_laundry`";
    
    public TransaksiLaundryDAO(){
        this.conn = Database.getConn();
    }

    @Override
    public boolean insert(TransaksiLaundry transaksiLaundry) {
        //To change body of generated methods, choose Tools | Templates.
        /*private final String INSERT = "INSERT INTO `transaksi_laundry`"
            + "(`reg_id_user`, "
            + "`id_registrasi`, "
            + "`id_transaksi_laundry`, "
            + "`id_user`, "
            + "`total_transaksi_laundry`, "
            + "`date_transaksi_laundry`, "
            + "`date_selesai_transaksi_laundry`, "
            + "`name_guest`, "
            + "`id_kamar`) "
            + "VALUES (?,?,?,?,?,?,?,?,?)";*/
        try{
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, transaksiLaundry.getUser().getIdUser());
            this.pStat.setString(2, transaksiLaundry.getRegistrasi().getIdRegistrasi());
            this.pStat.setString(3, transaksiLaundry.getNoTransaksiLaundry());
            this.pStat.setString(4, transaksiLaundry.getUser().getIdUser());
            this.pStat.setInt(5, transaksiLaundry.getTotalTransaksi());
            this.pStat.setDate(6, new java.sql.Date(transaksiLaundry.getTanggalTransaksiLaundry().getTime()));
            this.pStat.setDate(7, new java.sql.Date(transaksiLaundry.getTanggalSelesai().getTime()));
            this.pStat.setString(8, transaksiLaundry.getGuestName());
            this.pStat.setString(9, transaksiLaundry.getRooms().getId());
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Error pada insert transaksi laundry "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(TransaksiLaundry transaksiLaundry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TransaksiLaundry> getAll() {
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_ALL);
            while(this.rs.next()){
                TransaksiLaundry t = new TransaksiLaundry();
                t.getRegistrasi().setIdRegistrasi(rs.getString("id_registrasi"));
                t.setNoTransaksiLaundry(rs.getString("id_transaksi_laundry"));
                t.setTotalTransaksi(rs.getInt("total_transaksi_laundry"));
                t.setTanggalTransaksiLaundry(rs.getDate("date_transaksi_laundry"));
                t.setTanggalSelesai(rs.getDate("date_selesai_transaksi_laundry"));
                t.setGuestName(rs.getString("name_guest"));
                t.getRooms().setId(rs.getString("id_kamar"));
                t.getRooms().setNo(rs.getString("no_kamar"));
                this.list.add(t);
            }
        }catch(SQLException e){
            System.out.println("Terjadi Kesalahan pada method getAll = "+e.getMessage());
        }
        return this.list;
    }

    @Override
    public TransaksiLaundry getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMax() {
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_MAX);
            if(this.rs.next()){
                return this.rs.getString(1);
            }else{
                return null;
            }
        }catch(SQLException e){
            System.out.println("Terjadi Error pada getMax Transaksi Laundry DAO "+e.getMessage());
        }
        return null;
        //To change body of generated methods, choose Tools | Templates.
    }
}
