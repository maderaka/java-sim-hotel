/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;
import analisasistem.config.Database;
import analisasistem.entity.Registrasi;
import analisasistem.interfaces.RegistrasiInterface;
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
public class RegistrasiDAO implements RegistrasiInterface{
    private List<Registrasi> lis = new ArrayList<Registrasi>();
    private Registrasi registrasi = new Registrasi();
    private Statement stat;
    private PreparedStatement pStat;
    private ResultSet rs;
    private Connection conn;
    
    private final String SELECT_ALL = "SELECT * FROM `registrasi` "
            + "JOIN `tamu` ON `tamu`.`id_tamu`=`registrasi`.`id_tamu` "
            + "JOIN `travel_agent` ON `registrasi`.`id_agent` = `travel_agent`.`id_agent`";
    
    private final String SELECT_BY_ID = "SELECT * FROM `registrasi` "
            + "JOIN `tamu` ON `tamu`.`id_tamu`=`registrasi`.`id_tamu` "
            + "JOIN `travel_agent` ON `registrasi`.`id_agent` = `travel_agent`.`id_agent` WHERE `id_registrasi`=?";
    
    private final String INSERT = "INSERT INTO `registrasi`"
            + "(`id_user`, `id_registrasi`,`id_agent`, "
            + "`id_tamu`, `date_registrasi`, `pax_registrasi`, "
            + "`checkin_registrasi`, `checkout_registrasi`, "
            + "`arrivalno_registrasi`, `departureno_registrasi`, "
            + "`departuretime_registrasi`, `arrivaltime_register`, "
            + "`arrival_transfer_registrasi`, `departure_transfer_registrasi`) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    private final String UPDATE = "UPDATE `registrasi` "
            + "SET `id_user`=?,"
            + "`no_pembayaran`=?,"
            + "`id_agent`=?,"
            + "`id_tamu`=?,"
            + "`date_registrasi`=?,"
            + "`pax_registrasi`=?,"
            + "`checkin_registrasi`=?,"
            + "`checkout_registrasi`=?,"
            + "`arrivalno_registrasi`=?,"
            + "`departureno_registrasi`=?,"
            + "`departuretime_registrasi`=?,"
            + "`arrivaltime_register`=?,"
            + "`arrival_transfer_registrasi`=?,"
            + "`departure_transfer_registrasi`=? "
            + "WHERE `id_registrasi`=?";
    
    private final String DELETE = "DELETE FROM `registrasi` WHERE `id_registrasi`=?";
    private final String SELECT_MAX = "SELECT MAX(`id_registrasi`) FROM `registrasi`";
    
    public RegistrasiDAO(){
        this.conn = Database.getConn();
    }
    @Override
    public boolean insert(Registrasi registrasi) {
        try{
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, "US-1306001");
            this.pStat.setString(2, registrasi.getIdRegistrasi());
            this.pStat.setString(3, registrasi.getAgent().getId());
            this.pStat.setString(4, registrasi.getTamu().getIdTamu());
            this.pStat.setDate(5, new java.sql.Date(registrasi.getDate().getTime()));
            this.pStat.setInt(6, registrasi.getPax());
            this.pStat.setDate(7, new java.sql.Date(registrasi.getCheckIn().getTime()));
            this.pStat.setDate(8, new java.sql.Date(registrasi.getCheckOut().getTime()));
            this.pStat.setString(9, registrasi.getArrivalNo());
            this.pStat.setString(10, registrasi.getDepartureNo());
            this.pStat.setString(12, registrasi.getArrivalTime());
            this.pStat.setString(11, registrasi.getDepartureTime());
            this.pStat.setInt(13, registrasi.getArrival_transfer());
            this.pStat.setInt(14, registrasi.getDeparture_transfer());
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Error pada Registrasi DAO Insert "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Registrasi registrasi) {
        try{
            this.pStat = this.conn.prepareStatement(UPDATE);
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Error pada Registrasi DAO Update "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(String idRegistrasi) {
        try{
           this.pStat = this.conn.prepareStatement(DELETE);
           if(this.pStat.executeUpdate() == 1){
               return true;
           }else{
               return false;
           }
        }catch(SQLException e){
            System.out.println("Error pada Registrasi DAO Delete "+e.getMessage());
        }
        return false;
    }

    @Override
    public Registrasi selectById(String idRegistrasi) {
        /*
         * "INSERT INTO `registrasi`"
            + "(`id_user`, `id_registrasi`,`id_agent`, "
            + "`id_tamu`, `date_registrasi`, `pax_registrasi`, "
            + "`checkin_registrasi`, `checkout_registrasi`, "
            + "`arrivalno_registrasi`, `departureno_registrasi`, "
            + "`departuretime_registrasi`, `arrivaltime_register`, "
            + "`arrival_transfer_registrasi`, `departure_transfer_registrasi`) "
         */
        try{
            this.pStat = this.conn.prepareStatement(SELECT_BY_ID);
            this.pStat.setString(1, idRegistrasi);
            this.rs = this.pStat.executeQuery();
            if(this.rs.next()){
                this.registrasi.setIdRegistrasi(rs.getString("id_registrasi"));
                this.registrasi.getAgent().setId(rs.getString("id_agent"));
                this.registrasi.setDate(rs.getDate("date_registrasi"));
                this.registrasi.setPax(rs.getInt("pax_registrasi"));
                this.registrasi.setCheckIn(rs.getDate("checkin_registrasi"));
                this.registrasi.setCheckOut(rs.getDate("checkout_registrasi"));
                this.registrasi.setArrivalNo(rs.getString("arrivalno_registrasi"));
                this.registrasi.setDepartureNo(rs.getString("departureno_registrasi"));
                this.registrasi.setArrivalTime(rs.getString("arrivaltime_register"));
                this.registrasi.setDepartureTime(rs.getString("departuretime_registrasi"));
                this.registrasi.setArrival_transfer(rs.getInt("arrival_transfer_registrasi"));
                this.registrasi.setDeparture_transfer(rs.getInt("departure_transfer_registrasi"));
                
                this.registrasi.getTamu().setIdTamu(rs.getString("id_tamu"));
                this.registrasi.getTamu().setNoIdentitas(rs.getString("identitas_tamu"));
                this.registrasi.getTamu().getTipeIdentitas().setIdTipeIdentitas(rs.getInt("jenisidentitas_tamu"));
                this.registrasi.getTamu().setFullName(rs.getString("nama_tamu"));
                this.registrasi.getTamu().setJk(rs.getInt("jk_tamu"));
                this.registrasi.getTamu().setTempatLahir(rs.getString("tempat_lahir_tamu"));
                this.registrasi.getTamu().setTanggalLahir(rs.getDate("tanggal_lahir_tamu"));
                this.registrasi.getTamu().setAlamat(rs.getString("alamat_tamu"));
                this.registrasi.getTamu().setProvinsi(rs.getString("provinsi_tamu"));
                this.registrasi.getTamu().setNegara(rs.getString("negara_tamu"));
                this.registrasi.getTamu().setPhone(rs.getString("telp_tamu"));
            }
        }catch(SQLException e){
            System.out.println("Error pada Registrasi DAO SelectById "+e.getMessage());
        }
        return this.registrasi;
    }

    @Override
    public List<Registrasi> selectAll() {
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_ALL);
            while(this.rs.next()){
                Registrasi g = new Registrasi();
                g.setIdRegistrasi(rs.getString("id_registrasi"));
                g.getTamu().setFullName(rs.getString("nama_tamu"));
                g.setCheckIn(rs.getDate("checkin_registrasi"));
                g.setCheckOut(rs.getDate("checkout_registrasi"));
                g.getTamu().setPhone(rs.getString("telp_tamu"));
                g.getAgent().setName(rs.getString("name_agent"));
                this.lis.add(g);
            }
        }catch(SQLException e){
            System.out.println("Error pada Registrasi DAO Select All "+e.getMessage());
        }
        return this.lis;
        
    }

    @Override
    public String selectMax() {
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_MAX);
            if(this.rs.next()){
                return this.rs.getString(1);
            }else{
                return null;
            }
        }catch(SQLException e){
            System.out.println("Error pada pengambilan id max registrasi "+e.getMessage());
        }
        return null;
    }
    
}
