/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.config.Database;
import analisasistem.entity.Person;
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
public class PersonDAO implements analisasistem.interfaces.PersonInterface{
    
    /**
     * 
     */
    private Connection conn;
    private PreparedStatement pStat;
    private Statement stat;
    private ResultSet rs;
    
    /**
     * 
     */
    public PersonDAO(){
        this.conn = Database.getConn();
    }
    @Override
    public boolean insert(Person person) {
        try{
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, person.getUser().getIdUser());
            this.pStat.setString(2, person.getReservasi().getIdReservasi());
            this.pStat.setString(3, person.getId());
            this.pStat.setString(4, person.getNama());
            this.pStat.setString(5, person.getCompany());
            this.pStat.setString(6, person.getEmail());
            this.pStat.setString(7, person.getAddress());
            this.pStat.setString(8, person.getState());
            this.pStat.setString(9, person.getNationality());
            this.pStat.setString(10, person.getTelephone());
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Error pada insert user "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Person person) {
        try{
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, person.getReservasi().getIdReservasi());
            this.pStat.setString(2, person.getId());
            this.pStat.setString(3, person.getNama());
            this.pStat.setString(4, person.getCompany());
            this.pStat.setString(5, person.getEmail());
            this.pStat.setString(6, person.getAddress());
            this.pStat.setString(7, person.getState());
            this.pStat.setString(8, person.getNationality());
            this.pStat.setString(9, person.getTelephone());
            this.pStat.setString(10, person.getUser().getIdUser());
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            
        }
        return false;
        //To change body of generated methods, choose Tools | Templates.
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
            System.out.println("Error pada Delete Person "+e.getMessage());
        }
        return false;
    }

    @Override
    public List<Person> selectAll(){
        List<Person> list = new ArrayList<Person>();
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_ALL);
            while(this.rs.next()){
                Person person = new Person();
                person.getUser().setIdUser(rs.getString("id_user"));
                person.getReservasi().setIdReservasi(rs.getString("id_reservasi"));
                person.setId(rs.getString("id_person"));
                person.setNama(rs.getString("nama_person"));
                person.setCompany(rs.getString("company_person"));
                person.setEmail(rs.getString("email_person"));
                person.setAddress(rs.getString("address_person"));
                person.setState(rs.getString("state_person"));
                person.setNationality(rs.getString("nationality_person"));
                person.setTelephone(rs.getString("telp_person"));
                list.add(person);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public Person selectById(String id) {
        Person person = new Person();
        try{
            this.pStat = this.conn.prepareStatement(SELECT_BY_ID);
            this.pStat.setString(1, id);
            this.rs = this.pStat.executeQuery();
            if(this.rs.next()){
                person.getUser().setIdUser(rs.getString("id_user"));
                person.getReservasi().setIdReservasi(rs.getString("id_reservasi"));
                person.setId(rs.getString("id_person"));
                person.setNama(rs.getString("nama_person"));
                person.setCompany(rs.getString("company_person"));
                person.setEmail(rs.getString("email_person"));
                person.setAddress(rs.getString("address_person"));
                person.setState(rs.getString("state_person"));
                person.setNationality(rs.getString("nationality_person"));
                person.setTelephone(rs.getString("telp_person"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return person;
    }
    
    @Override
    public String getMax(){
        String idMax = "";
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_MAX);
            if(this.rs.next()){
                idMax = this.rs.getString("id");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return idMax;
    }
    
    private final String INSERT = "INSERT INTO `person`"
            + "(`id_user`, `id_reservasi`, `id_person`, `nama_person`, "
            + "`company_person`, `email_person`, `address_person`, `state_person`, "
            + "`nationality_person`, `telp_person`) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?)";
    
    private final String SELECT_BY_ID = "SELECT `id_user`, `id_reservasi`, "
            + "`id_person`, `nama_person`, `company_person`, `email_person`, "
            + "`address_person`, `state_person`, `nationality_person`, `telp_person` FROM `person` WHERE `id_person`=?";
    
    private final String SELECT_ALL = "SELECT * FROM `person` JOIN `reservasi` "
            + "ON `reservasi`.`id_person`=`person`.`id_person`";
    
    private final String DELETE = "DELETE FROM `person` WHERE `id_person`=?";
    
    private final String UPDATE = "UPDATE `person` "
            + "SET "
            + "`id_user`=?"
            + "`id_reservasi`=?,"
            + "`nama_person`=?,"
            + "`company_person`=?,"
            + "`email_person`=?,"
            + "`address_person`=?,"
            + "`state_person`=?,"
            + "`nationality_person`=?,"
            + "`telp_person`=? WHERE `id_person`=?";
    private final String SELECT_MAX = "SELECT MAX(`id_person`) AS `id` FROM `person`";
    
}
