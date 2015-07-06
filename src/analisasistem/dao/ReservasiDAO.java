/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.config.Database;
import analisasistem.entity.Person;
import analisasistem.entity.Reservasi;
import java.sql.Connection;
import java.sql.Date;
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
public class ReservasiDAO implements analisasistem.interfaces.ReservasiInterface{
    Connection conn;
    private Statement stat;
    private PreparedStatement pStat;
    private List<Reservasi> list;
    public ReservasiDAO(){
        this.conn = Database.getConn();
    }

    /**
     * 
     * @return 
     */
    @Override
    public List<Reservasi> selectAll() {
        this.list = new ArrayList<Reservasi>();
        try{
            this.stat = this.conn.createStatement();
            ResultSet rs = this.stat.executeQuery(SELECT_ALL);
            while(rs.next()){
                Reservasi reservasi = new Reservasi();
                reservasi.setIdReservasi(rs.getString("id_reservasi"));
                reservasi.setDate_reservasi(rs.getDate("date_reservasi"));
                reservasi.setCheckIn(rs.getDate("checkin_reservasi"));
                reservasi.setCheckOut(rs.getDate("checkout_reservasi"));
                reservasi.setArrivalTime(rs.getString("arrival_reservasi"));
                reservasi.setDepartureTime(rs.getString("departure_reservasi"));
                reservasi.setArrivalNo(rs.getString("arrivalno_reservasi"));
                reservasi.setDepartureNo(rs.getString("departureno_reservasi"));
                reservasi.setArrivalNo(rs.getString("arrival_transfer_reservasi"));
                reservasi.setDepartureNo(rs.getString("departure_transfer_reservasi"));
                reservasi.setMemo(rs.getString("memo_reservasi"));
                reservasi.setNamaPerson(rs.getString("nama_person"));
                reservasi.setPhone(rs.getString("telp_person"));
                reservasi.setCompany(rs.getString("company_person"));
                
                reservasi.getAgent().setName(rs.getString("name_agent"));
                this.list.add(reservasi);
            }
        }catch(SQLException e){
            System.out.println("Error pada DAO Reservasi Select All : "+e.getMessage());
        }
        return this.list;
    }

    /**
     * 
     * @param reservasi
     * @return 
     */
    @Override
    public boolean insert(Reservasi reservasi) {
        try{
            if(reservasi.getAgent().getId().equals("")){
                 this.pStat = this.conn.prepareStatement(INSERT_WO_AGENT);
            }else{
                this.pStat = this.conn.prepareStatement(INSERT_WI_AGENT);
                this.pStat.setString(15, reservasi.getAgent().getId());
            }
            this.pStat.setString(1, reservasi.getUsers().getIdUser());
            this.pStat.setString(2, reservasi.getIdReservasi());
            this.pStat.setString(3, reservasi.getPerUsers().getIdUser());
            this.pStat.setString(4, "");
            this.pStat.setString(5, reservasi.getIdPerson());
            this.pStat.setDate(6, (Date) reservasi.getCheckIn());
            this.pStat.setDate(7, (Date) reservasi.getCheckOut());
            this.pStat.setString(8, reservasi.getArrivalTime());
            this.pStat.setString(9, reservasi.getDepartureTime());
            this.pStat.setString(10, reservasi.getArrivalNo());
            this.pStat.setString(11, reservasi.getDepartureNo());
            this.pStat.setInt(12,reservasi.getArrival_transfer());
            this.pStat.setInt(13, reservasi.getDeparture_transfer());
            this.pStat.setString(14, reservasi.getMemo());
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
     * @param reservasi
     * @return 
     */
    @Override
    public boolean update(Reservasi reservasi) {
        try{
            this.pStat = this.conn.prepareStatement(UPDATE);
            this.pStat.setString(1, reservasi.getUsers().getIdUser());
            this.pStat.setString(2, reservasi.getIdReservasi());
            this.pStat.setString(3, reservasi.getAgent().getId());
            this.pStat.setString(4, reservasi.getPerUsers().getIdUser());
            this.pStat.setString(5, "");
            this.pStat.setString(6, reservasi.getIdPerson());
            this.pStat.setDate(7, (Date) reservasi.getCheckIn());
            this.pStat.setDate(8, (Date) reservasi.getCheckOut());
            this.pStat.setString(9, reservasi.getArrivalTime());
            this.pStat.setString(10, reservasi.getDepartureTime());
            this.pStat.setString(11, reservasi.getArrivalNo());
            this.pStat.setString(12, reservasi.getDepartureNo());
            this.pStat.setInt(13,reservasi.getArrival_transfer());
            this.pStat.setInt(14, reservasi.getDeparture_transfer());
            this.pStat.setString(15, reservasi.getMemo());
            
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
     * @param noReservasi
     * @return Reservasi
     */
    @Override
    public boolean delete(String noReservasi) {
        try{
            this.pStat = this.conn.prepareStatement(DELETE);
            this.pStat.setString(1, noReservasi);
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
     * @param noReservasi
     * @return Reservasi
     */
    @Override
    public Person selectById(String noReservasi) {
        Person person = new Person();
        try{
            this.pStat = this.conn.prepareStatement(SELECT_BY_ID);
            this.pStat.setString(1, noReservasi);
            ResultSet rs = this.pStat.executeQuery();
            if(rs.next()){
                person.getReservasi().setIdReservasi(rs.getString("id_reservasi"));
                person.getReservasi().setCheckIn(rs.getDate("checkin_reservasi"));
                person.getReservasi().setCheckOut(rs.getDate("checkout_reservasi"));
                person.getReservasi().setArrivalNo(rs.getString("arrivalno_reservasi"));
                person.getReservasi().setDepartureNo(rs.getString("departureno_reservasi"));
                person.getReservasi().setArrivalTime(rs.getString("arrival_reservasi"));
                person.getReservasi().setDepartureTime(rs.getString("departure_reservasi"));
                person.getReservasi().setMemo(rs.getString("memo_reservasi"));
                person.setId(rs.getString("id_person"));
                person.setNama(rs.getString("nama_person"));
                person.setEmail(rs.getString("email_person"));
                person.setCompany(rs.getString("company_person"));
                person.setAddress(rs.getString("address_person"));
                person.setNationality(rs.getString("nationality_person"));
                person.setState(rs.getString("state_person"));
                person.setTelephone(rs.getString("telp_person"));
                person.getReservasi().getAgent().setName(rs.getString("name_agent"));
                person.getReservasi().getAgent().setId(rs.getString("id_agent"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return person;
    }
    
    /**
     * 
     * @return String 
     */
    @Override
    public String selectMaxId() {
        try{
            this.pStat = this.conn.prepareStatement(SELECT_MAX_ID);
            ResultSet rs = this.pStat.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    /**
     * 
     */
    private final String SELECT_ALL = "SELECT *" +
            "FROM `reservasi`" +
            "LEFT JOIN `person` ON `person`.`id_person` = `reservasi`.`id_person`" +
            "LEFT JOIN `travel_agent` ON `travel_agent`.`id_agent` = `reservasi`.`id_agent`";
    
    private final String INSERT_WO_AGENT = "INSERT INTO `reservasi`"
            + "(`id_user`, `id_reservasi`,`per_id_user`, "
            + "`per_id_reservasi`, `id_person`, "
            + "`checkin_reservasi`, `checkout_reservasi`, `arrival_reservasi`, "
            + "`departure_reservasi`, `arrivalno_reservasi`, `departureno_reservasi`, "
            + "`arrival_transfer_reservasi`, `departure_transfer_reservasi`, `memo_reservasi`) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    private final String INSERT_WI_AGENT = "INSERT INTO `reservasi`"
            + "(`id_user`, `id_reservasi`, `per_id_user`, "
            + "`per_id_reservasi`, `id_person`, "
            + "`checkin_reservasi`, `checkout_reservasi`, `arrival_reservasi`, "
            + "`departure_reservasi`, `arrivalno_reservasi`, `departureno_reservasi`, "
            + "`arrival_transfer_reservasi`, `departure_transfer_reservasi`, `memo_reservasi`,`id_agent`) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private final String UPDATE = "UPDATE `tbreservasi` SET `first_name`=?,`last_name`=?,`phone`=?,`company`=?,`id_pegawai`=?,`arrival_time`=?,`departure_time`=?,`agent_id`=?,`memo`=? WHERE `no_reservasi`=?";
    private final String DELETE = "DELETE FROM `tbreservasi` WHERE `no_reservasi`=?";
    private final String SELECT_BY_ID ="SELECT * " +
            "FROM `reservasi`" +
            "LEFT JOIN `person` ON `person`.`id_person` = `reservasi`.`id_person`" +
            "LEFT JOIN `travel_agent` ON `travel_agent`.`id_agent` = `reservasi`.`id_agent`"
            + "WHERE `reservasi`.`id_reservasi`=?";
    private final String SELECT_MAX_ID ="SELECT max(`id_reservasi`) FROM `reservasi`";
}
