/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;
import analisasistem.config.Database;
import analisasistem.entity.Tamu;
import analisasistem.interfaces.TamuInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Raka New
 */

public class TamuDAO implements TamuInterface{
    private Connection conn;
    private Statement stat;
    private PreparedStatement pStat;
    private ResultSet rs;
    private final String INSERT = "INSERT INTO `tamu`(`id_tamu`, "
            + "`identitas_tamu`, `jenisidentitas_tamu`, "
            + "`nama_tamu`, `jk_tamu`, `tempat_lahir_tamu`, "
            + "`tanggal_lahir_tamu`, `alamat_tamu`, `provinsi_tamu`, "
            + "`negara_tamu`, `telp_tamu`) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    
    private final String UPDATE = "UPDATE `tamu` SET "
            + "`identitas_tamu`=?,`jenisidentitas_tamu`=?,"
            + "`nama_tamu`=?,`jk_tamu`=?,`tempat_lahir_tamu`=?,"
            + "`tanggal_lahir_tamu`=?,`alamat_tamu`=?,"
            + "`provinsi_tamu`=?,`negara_tamu`=?,"
            + "`telp_tamu`=? WHERE `id_tamu`=?";
    
    private final String SELECT_ALL = "SELECT * FROM `tamu`";
    private final String SELECT_BY_ID ="SELECT * FROM `tamu` WHERE `id_tamu`=?";
    private final String SELECT_MAX = "SELECT MAX(`id_tamu`) FROM `tamu`";
    public TamuDAO(){
        this.conn = Database.getConn();
    }
    
    @Override
    public boolean insert(Tamu tamu) {
        //To change body of generated methods, choose Tools | Templates.
        try{
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, tamu.getIdTamu());
            this.pStat.setString(2, tamu.getNoIdentitas());
            this.pStat.setInt(3, tamu.getTipeIdentitas().getIdTipeIdentitas());
            this.pStat.setString(4, tamu.getFullName());
            this.pStat.setInt(5,tamu.getJk());
            this.pStat.setString(6,tamu.getTempatLahir());
            this.pStat.setDate(7, new java.sql.Date (tamu.getTanggalLahir().getTime()));
            this.pStat.setString(8, tamu.getAlamat());
            this.pStat.setString(9, tamu.getProvinsi());
            this.pStat.setString(10, tamu.getNegara());
            this.pStat.setString(11, tamu.getPhone());
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Terjadi error pada insert tamu "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Tamu tamu) {
        
        return false;
    }

    @Override
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Tamu selectById(String id) {
        Tamu tamu = new Tamu();
        try{
            this.pStat = this.conn.prepareStatement(SELECT_BY_ID);
            this.pStat.setString(1, id);
            this.rs = this.pStat.executeQuery();
            if(this.rs.next()){
                tamu.setIdTamu(rs.getString("id_tamu"));
                tamu.setFullName(rs.getString("nama_tamu"));
                tamu.setNoIdentitas(rs.getString("identitas_tamu"));
                tamu.getTipeIdentitas().setIdTipeIdentitas(rs.getInt("jenisidentitas_tamu"));
                tamu.setJk(rs.getInt("jk_tamu"));
                tamu.setTempatLahir(rs.getString("tempat_lahir_tamu"));
                tamu.setTanggalLahir(rs.getDate("tanggal_lahir_tamu"));
                tamu.setAlamat(rs.getString("alamat_tamu"));
                tamu.setProvinsi(rs.getString("provinsi_tamu"));
                tamu.setNegara(rs.getString("negara_tamu"));
                tamu.setPhone(rs.getString("telp_tamu"));
            }
        }catch(SQLException e){
            System.out.println("Terjadi error pada select by id "+e.getMessage());
        }
        return tamu;
    }

    @Override
    public String selectMax() {
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_MAX);
            if(this.rs.next()){
                return this.rs.getString(1);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Tamu> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
