/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.config.Database;
import analisasistem.entity.Pegawai;
import analisasistem.interfaces.PegawaiInterface;
import java.sql.Connection;
import java.sql.Date;
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
public class PegawaiDAO implements PegawaiInterface {
    
    private Connection conn;
    
    final String SELECT     = "SELECT * FROM pegawai;";
    
    final String INSERT     = "INSERT INTO `pegawai`"
            + "(`id_pegawai`, `id_jabatan`,`name_pegawai`, `tempat_lahir_pegawai`, "
            + "`tanggal_lahir_pegawai`, `alamat_pegawai`, `kota_pegawai`, `provinsi_pegawai`, `negara_pegawai`, "
            + "`telp_pegawai`, `email_pegawai`, `jk_pegawai`)"
            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    
    final String UPDATE     = "UPDATE `pegawai` SET `id_jabatan`=?,`id_user`=?,`name_pegawai`=?,`tempat_lahir_pegawai`=?,"
            + "`tanggal_lahir_pegawai`=?,`alamat_pegawai`=?,`kota_pegawai`=?,`provinsi_pegawai`=?,`negara_pegawai`=?,"
            + "`telp_pegawai`=?,`email_pegawai`=?,`jk_pegawai`=? WHERE `id_pegawai`=?";
    
    final String DELETE     = "";
    
    final String SELECT_BY_ID ="SELECT * FROM `pegawai` WHERE `id_pegawai`=?";
    
    final String SELECT_MAX = "SELECT MAX(`id_pegawai`) FROM `pegawai`;";
    
    private final String SELECT_CHOOSER = "SELECT \n" +
                                        "pegawai.id_pegawai AS id, pegawai.name_pegawai AS nama, jabatan.nama_jabatan AS jabatan\n" +
                                        "FROM pegawai\n" +
                                        "JOIN jabatan ON jabatan.id_jabatan=pegawai.id_jabatan\n"+
                                        "WHERE pegawai.id_pegawai NOT In(SELECT user.id_pegawai FROM user)";
    
    private PreparedStatement pStat;
    
    private Statement stat;
    
    private List<Pegawai> listPegawai;
    
    public PegawaiDAO(){
        this.conn = Database.getConn();
    }
    @Override
    public List<Pegawai> getAll() {
        this.listPegawai = new ArrayList<Pegawai>();
        try{
            stat = this.conn.createStatement();
            ResultSet rs = stat.executeQuery(SELECT);
            while(rs.next()){
                Pegawai pegawai = new Pegawai();
                pegawai.setId(rs.getString(1));
                pegawai.setNama(rs.getString("name_pegawai"));
                pegawai.setJenisKelamin(rs.getInt("jk_pegawai"));
                pegawai.setTempatLahir(rs.getString("tempat_lahir_pegawai"));
                pegawai.setTanggalLahir(rs.getDate("tanggal_lahir_pegawai"));
                pegawai.setAlamat(rs.getString("alamat_pegawai"));
                pegawai.setKota(rs.getString("kota_pegawai"));
                pegawai.setProvinsi(rs.getString("provinsi_pegawai"));
                pegawai.setTelp(rs.getString("telp_pegawai"));
                pegawai.getJabatan().setIdJabatan(rs.getString("id_jabatan"));
                this.listPegawai.add(pegawai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.listPegawai;
    }

    @Override
    public boolean insert(Pegawai pegawai) {
        boolean status = false;
        try {
            pStat = this.conn.prepareStatement(INSERT);
            pStat.setString(1, pegawai.getId());
            pStat.setString(2, pegawai.getJabatan().getIdJabatan());
            pStat.setString(3, pegawai.getNama());
            pStat.setString(4, pegawai.getTempatLahir());
            pStat.setDate(5, (Date) pegawai.getTanggalLahir());
            pStat.setString(6, pegawai.getAlamat());
            pStat.setString(7, pegawai.getKota());
            pStat.setString(8, pegawai.getProvinsi());
            pStat.setString(9, pegawai.getNegara());
            pStat.setString(10, pegawai.getTelp());
            pStat.setString(11, pegawai.getEmail());
            pStat.setInt(12, pegawai.getJenisKelamin());
            if(pStat.executeUpdate() == 1){
                status = true;
            }else{
                status = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status;
    }

    /**
     * 
     * @param pegawai Pegawai
     * @return 
     */
    @Override
    public boolean update(Pegawai pegawai) {
        try{
            this.pStat = this.conn.prepareStatement(UPDATE);
            
            pStat.setString(1, pegawai.getJabatan().getIdJabatan());
            //pStat.setString(2, pegawai.getUsers().getIdUser());
            pStat.setString(3, pegawai.getNama());
            pStat.setString(4, pegawai.getTempatLahir());
            pStat.setDate(5, (Date) pegawai.getTanggalLahir());
            pStat.setString(6, pegawai.getAlamat());
            pStat.setString(7, pegawai.getKota());
            pStat.setString(8, pegawai.getProvinsi());
            pStat.setString(9, pegawai.getNegara());
            pStat.setString(10, pegawai.getTelp());
            pStat.setString(11, pegawai.getEmail());
            pStat.setInt(12, pegawai.getJenisKelamin());
            pStat.setString(13, pegawai.getId());
            
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            
        }
        return false;
    }

    /**
     * 
     * @param id String
     * @return boolean
     */
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
            
        }
        return false;
    }

    /**
     * 
     * @param id String
     * @return Pegawai
     */
    @Override
    public Pegawai getById(String id) {
        Pegawai pegawai = new Pegawai();
        try{
            pStat = this.conn.prepareStatement(SELECT_BY_ID);
            pStat.setString(1, id);
            ResultSet rs = pStat.executeQuery();
            while(rs.next()){
                pegawai.setId(rs.getString("id_pegawai"));
                pegawai.getJabatan().setIdJabatan("id_jabatan");
                //pegawai.getUsers().setIdUser("id_user");
                pegawai.setNama(rs.getString("name_pegawai"));
                pegawai.setTempatLahir(rs.getString("tempat_lahir_pegawai"));
                pegawai.setTanggalLahir(rs.getDate("tanggal_lahir_pegawai"));
                pegawai.setAlamat(rs.getString("alamat_pegawai"));
                pegawai.setKota(rs.getString("kota_pegawai"));
                pegawai.setProvinsi(rs.getString("provinsi_pegawai"));
                pegawai.setNegara(rs.getString("negara_pegawai"));
                pegawai.setTelp(rs.getString("telp_pegawai"));
                pegawai.setEmail(rs.getString("email_pegawai"));
                pegawai.setJenisKelamin(rs.getInt("jk_pegawai"));
            }
        }catch(SQLException ex){
            System.out.println("Exception: "+ex.getMessage());
        }
        return pegawai;
    }
    
    /**
     * 
     * @return String
     */
    @Override
    public String getMax(){
        String id =null;
        try {
            stat = this.conn.createStatement();
            ResultSet rs = stat.executeQuery(SELECT_MAX);
            while(rs.next()){
                id = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PegawaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    @Override
    public List<Pegawai> getPegawaiChooser() {
        this.listPegawai = new ArrayList<Pegawai>();
        try{
            //pegawai.id_pegawai, pegawai.name_pegawai, jabatan.nama_jabatan
            this.stat = this.conn.createStatement();
            ResultSet rs = this.stat.executeQuery(SELECT_CHOOSER);
            while(rs.next()){
                Pegawai pegawai = new Pegawai();
                pegawai.setId(rs.getString("id"));
                pegawai.setNama(rs.getString("nama"));
                pegawai.getJabatan().setNamaJabatan(rs.getString("jabatan"));
                this.listPegawai.add(pegawai);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return this.listPegawai;
    }

    
}
