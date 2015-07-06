/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.config.Database;
import analisasistem.entity.LaundryService;
import analisasistem.interfaces.LaundryServiceInterface;
import java.sql.Connection;
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
public class LaundryServiceDAO implements LaundryServiceInterface{
    /**
     * 
     */
    private Connection conn;
    private PreparedStatement pStat;
    private Statement stat;
    private List<LaundryService> list;
    private ResultSet rs;
    private LaundryService laundry = new LaundryService();
    
    /**
     * SQL ini digunakan untuk mengambil semua data dari tabel tblaundryservice
     * 
     */
    private final String SELECT_ALL = "SELECT `id_laundry`, `namabarang_laundry`, `cost_laundry`, `desc_laundry` FROM `laundry`";
    
    /**
     * SQL ini digunakan untuk menambah data laundry service
     * 
     */
    private final String INSERT     = "INSERT INTO `laundry`(`id_laundry`, `namabarang_laundry`, `cost_laundry`, `desc_laundry`) VALUES (?,?,?,?)";
    
    /**
     * SQL ini digunakan untuk mengubah atau memperbaharui data laundry service
     */
    private final String UPDATE = "UPDATE `laundry` SET `namabarang_laundry`=?,`cost_laundry`=?,`desc_laundry`=? WHERE `id_laundry`=?";
    
    /**
     * 
     */
    private final String DELETE = "DELETE FROM `laundry` WHERE `id_laundry`=?";
    /**
     * 
     */
    private final String GET_BY_ID ="SELECT `id_laundry`, `namabarang_laundry`, `cost_laundry`, `desc_laundry` FROM `laundry` WHERE `id_laundry`=?";
    
    /**
     * 
     */
    private final String SELECT_MAX ="SELECT MAX(`id_laundry`) FROM `laundry`";
    
    /**
     * 
     */
    public LaundryServiceDAO(){
        this.conn = Database.getConn();
    }
    
    /**
     * 
     * @return Jlist
     */
    @Override
    public List<LaundryService> getAll() {
        this.list = new ArrayList<LaundryService>();
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_ALL);
            while(this.rs.next()){
                LaundryService lS = new LaundryService();
                lS.setIdBarang(this.rs.getString("id_laundry"));
                lS.setNamaBarang(this.rs.getString("namabarang_laundry"));
                lS.setHarga(this.rs.getInt("cost_laundry"));
                this.list.add(lS);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return this.list;
    }

    /**
     * 
     * @param lS
     * @return boolean
     */
    @Override
    public boolean insert(LaundryService lS) {
        this.laundry = lS;
        try {
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, this.laundry.getIdBarang());
            this.pStat.setString(2, this.laundry.getNamaBarang());
            this.pStat.setInt(3, this.laundry.getHarga());
            this.pStat.setString(4, this.laundry.getDescBarang());
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaundryServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }

    @Override
    public boolean update(LaundryService lS) {
        try{
            this.pStat = this.conn.prepareStatement(UPDATE);
            this.pStat.setString(1, lS.getNamaBarang());
            this.pStat.setInt(2, lS.getHarga());
            this.pStat.setString(3, lS.getDescBarang());
            this.pStat.setString(4, lS.getIdBarang());
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
     * Method ini digunakan untuk mengambil detail data laundry service berdasarkan id barang
     * 
     * @param idBarang
     * @return LaundryBarang
     */
    @Override
    public LaundryService getById(String idBarang) {
        try{
           this.pStat = this.conn.prepareStatement(GET_BY_ID);
           this.pStat.setString(1, idBarang);
           this.rs = this.pStat.executeQuery();
           if(this.rs.next()){
               this.laundry.setIdBarang(this.rs.getString("id_laundry"));
               this.laundry.setNamaBarang(this.rs.getString("namabarang_laundry"));
               this.laundry.setHarga(this.rs.getInt("cost_laundry"));
               this.laundry.setDescBarang(this.rs.getString("desc_laundry"));
           }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return this.laundry;
    }

    @Override
    public String selectMax() {
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_MAX);
            if(this.rs.next()){
                return rs.getString(1);
            }
        }catch(SQLException e){
            
        }finally{
            try {
                this.stat.close();
            } catch (SQLException ex) {
                Logger.getLogger(LaundryServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    /**
     * 
     * Method ini digunakan untuk menghapus data laundry service berdasarkan id barang yang digunakan
     * @param idBarang
     * @return boolean
     */
    @Override
    public boolean delete(String idBarang) {
        try{
            this.pStat = this.conn.prepareStatement(DELETE);
            this.pStat.setString(1, idBarang);
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(LaundryServiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
