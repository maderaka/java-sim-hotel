/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.config.Database;
import analisasistem.entity.RegistrasiDetail;
import analisasistem.interfaces.RegistrasiDetailInterface;
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
public class RegistrasiDetailDAO implements RegistrasiDetailInterface{
    private List<RegistrasiDetail> list = new ArrayList<RegistrasiDetail>();
    private Connection conn;
    private PreparedStatement pStat;
    private ResultSet rs;
    private Statement stat;
    
    private final String INSERT = "INSERT INTO `detail_registrasi`"
            + "(`id_user`, "
            + "`id_registrasi`, "
            + "`id_tipekamar`, "
            + "`id_kamar`)"
            + "VALUES (?,?,?,?)";
    
    private final String SELECT_ALL = "SELECT * FROM `detail_registrasi`";
    
    private final String SELECT_BY_ID = "SELECT `id_user`, `id_registrasi`, "
            + "`id_tipekamar`, `id_kamar`, `id_detail_registrasi` FROM `detail_registrasi` "
            + "INNER JOIN `tipe_kamar`.`id_tipekamar`=`detail_registrasi`.`id_tipekamar"
            + "WHERE `id_registrasi`=?";
    
    private final String SELECT_GUEST_IN_HOUSE = "SELECT \n" +
"    `registrasi`.`id_registrasi`,\n" +
"    `detail_registrasi`.`id_kamar`,\n" +
"    `registrasi`.`checkin_registrasi`,\n" +
"    `registrasi`.`checkout_registrasi`,\n" +
"    `tamu`.`nama_tamu`,\n" +
"    `tamu`.`telp_tamu`\n" +
"FROM\n" +
"    `detail_registrasi`\n" +
"        JOIN\n" +
"    `registrasi` ON `registrasi`.`id_registrasi` = `detail_registrasi`.`id_registrasi`\n" +
"        INNER JOIN\n" +
"    `tamu` ON `registrasi`.`id_tamu` = `tamu`.`id_tamu`\n" +
"WHERE\n" +
"    `detail_registrasi`.`id_registrasi` IN (SELECT \n" +
"            `registrasi`.`id_registrasi`\n" +
"        FROM\n" +
"            `registrasi`\n" +
"        WHERE\n" +
"            NOT `registrasi`.`id_registrasi` IN (SELECT \n" +
"                    `checkout`.`id_reg`\n" +
"                FROM\n" +
"                    `checkout`));";
    private RegistrasiDetail registrasiDetail = new RegistrasiDetail();
    
    public RegistrasiDetailDAO(){
        this.conn = Database.getConn();
    }
    
    @Override
    public boolean insert(RegistrasiDetail registrasiDetail) {
        try{
            this.pStat = this.conn.prepareStatement(INSERT);
            //this.pStat.setString(1, registrasiDetail.getReservasi().getUsers().getIdUser());
            //this.pStat.setString(2, registrasiDetail.getReservasi().getIdReservasi());
            this.pStat.setString(3, registrasiDetail.getRoom().getRoomType().getId());
            this.pStat.setString(4, registrasiDetail.getRoom().getId());
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
    public boolean delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(RegistrasiDetail registrasiDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegistrasiDetail> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RegistrasiDetail getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<RegistrasiDetail> getAllByRegistrasi(String idRegistrasi) {
        try{
            this.pStat = this.conn.prepareStatement(SELECT_BY_ID);
            this.pStat.setString(1, idRegistrasi);
            this.rs = this.pStat.executeQuery();
            while(this.rs.next()){
                RegistrasiDetail obj = new RegistrasiDetail();
                obj.getRoom().setId(rs.getString("id_kamar"));
                obj.getRoom().setNo(rs.getString("no_kamar"));
                obj.getRoom().getRoomType().setId("id_tipekamar");
                obj.getRoom().getRoomType().setName(rs.getString("nama_tipekamar"));
                this.list.add(obj);
            }
        }catch(SQLException e){
            System.out.println("Terdapat error pada "+e.getMessage());
        }
        return this.list;
    }

    @Override
    public List<RegistrasiDetail> getGuestInHouse() {
        //To change body of generated methods, choose Tools | Templates.
        try{
           this.stat = this.conn.createStatement();
           this.rs = this.stat.executeQuery(SELECT_GUEST_IN_HOUSE);
           while(this.rs.next()){
               RegistrasiDetail obj = new RegistrasiDetail();
               obj.getReservasi().setIdRegistrasi(this.rs.getString("id_registrasi"));
               obj.getRoom().setNo(this.rs.getString("id_kamar"));
               System.out.println(this.rs.getString("id_kamar"));
               obj.getReservasi().setCheckIn(this.rs.getDate("checkin_registrasi"));
               obj.getReservasi().setCheckOut(this.rs.getDate("checkout_registrasi"));
               obj.getReservasi().getTamu().setFullName(this.rs.getString("nama_tamu"));
               obj.getReservasi().getTamu().setPhone(this.rs.getString("telp_tamu"));
               this.list.add(obj);
           }
        }catch(SQLException e){
            System.out.println("gagal mengambil data guest in house");
            System.out.println(e.getMessage());
        }
        return this.list;
    }
    
}
