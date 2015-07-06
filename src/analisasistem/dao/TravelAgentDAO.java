/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import analisasistem.config.Database;
import analisasistem.entity.TravelAgent;
import analisasistem.interfaces.TravelAgentInterface;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Raka New
 */

public class TravelAgentDAO implements TravelAgentInterface{
    /**
     * 
     */
    public Connection conn;
    private Statement stat;
    private PreparedStatement pStat;
    private ResultSet rs;
    private List<TravelAgent> list;
    private TravelAgent agent = new TravelAgent();
    
    /**
     * 
     */
    public TravelAgentDAO(){
        this.conn = Database.getConn();
    }
    
    @Override
    public List<TravelAgent> getAll(){
        this.list = new ArrayList<TravelAgent>();
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_ALL);
            while(rs.next()){
                TravelAgent ag = new TravelAgent();
                ag.setId(rs.getString("id_agent"));
                ag.setName(rs.getString("name_agent"));
                ag.setAlamat(rs.getString("alamat_agent"));
                ag.setNegara(rs.getString("negara_agent"));
                ag.setProvinsi(rs.getString("provinsi_agent"));
                ag.setWebsite(rs.getString("website_agent"));
                ag.setPhone(rs.getString("telp_agent"));
                ag.setEmail(rs.getString("email_agent"));
                ag.setFax(rs.getString("fax_agent"));
                ag.setRegDate(rs.getString("reg_agent"));
                ag.setStatus(rs.getInt("status_agent"));
                ag.setContactName(rs.getString("contact_name_agent"));
                ag.setContactPosisi(rs.getString("contact_posisi_agent"));
                ag.setContactPhone(rs.getString("contact_phone_agent"));
                ag.setFee(rs.getInt("fee_agent"));
                this.list.add(ag);
            }
        }catch(SQLException ex){
            Logger.getLogger(PegawaiDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.list;
    }

    @Override
    public boolean insert(TravelAgent agent) {
        boolean bool = false;
            
        try{
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, agent.getId());
            this.pStat.setString(2, agent.getName());
            this.pStat.setString(3, agent.getAlamat());
            this.pStat.setString(4, agent.getProvinsi());
            this.pStat.setString(5, agent.getNegara());
            this.pStat.setString(6, agent.getPhone());
            this.pStat.setString(7, agent.getFax());
            this.pStat.setString(8, agent.getEmail());
            this.pStat.setString(9, agent.getWebsite());
            this.pStat.setDouble(10, agent.getFee());
            this.pStat.setInt(11, agent.getStatus());
            this.pStat.setString(12, agent.getContactName());
            this.pStat.setString(13, agent.getContactPosisi());
            this.pStat.setString(14, agent.getContactPhone());
            if(this.pStat.executeUpdate() == 1){
                bool = true;
            }else{
                bool = false;
            }
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return bool;
        
    }

    @Override
    public boolean delete(String id_agent) {
        try{
            this.pStat = this.conn.prepareStatement(DELETE);
            this.pStat.setString(1, id_agent);
            this.rs = this.pStat.executeQuery();
            return true;
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(String id, TravelAgent agent) {
        try{
            this.pStat = this.conn.prepareStatement(UPDATE);
            this.pStat.setString(1, agent.getName());
            this.pStat.setString(2, agent.getAlamat());
            this.pStat.setString(3, agent.getProvinsi());
            this.pStat.setString(4, agent.getNegara());
            this.pStat.setString(5, agent.getPhone());
            this.pStat.setString(6, agent.getFax());
            this.pStat.setString(7, agent.getEmail());
            this.pStat.setString(8, agent.getWebsite());
            this.pStat.setDouble(9, agent.getFee());
            this.pStat.setInt(10, agent.getStatus());
            this.pStat.setString(11, agent.getContactName());
            this.pStat.setString(12, agent.getContactPosisi());
            this.pStat.setString(13, agent.getContactPhone());
            this.pStat.setString(14, id);
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            
        }
        return false;
    }

    @Override
    public TravelAgent getById(String id_agent){
        try{
            this.pStat = this.conn.prepareStatement(SELECT_BY_ID);
            this.pStat.setString(1, id_agent);
            this.rs = this.pStat.executeQuery();
            while(this.rs.next()){
                this.agent.setId(rs.getString("id_agent"));
                this.agent.setName(rs.getString("name_agent"));
                this.agent.setAlamat(rs.getString("alamat_agent"));
                this.agent.setNegara(rs.getString("negara_agent"));
                this.agent.setProvinsi(rs.getString("provinsi_agent"));
                this.agent.setWebsite(rs.getString("website_agent"));
                this.agent.setPhone(rs.getString("telp_agent"));
                this.agent.setEmail(rs.getString("email_agent"));
                this.agent.setFax(rs.getString("fax_agent"));
                this.agent.setRegDate(rs.getString("reg_agent"));
                this.agent.setStatus(rs.getInt("status_agent"));
                this.agent.setContactName(rs.getString("contact_name_agent"));
                this.agent.setContactPosisi(rs.getString("contact_posisi_agent"));
                this.agent.setContactPhone(rs.getString("contact_phone_agent"));
                this.agent.setFee(rs.getInt("fee_agent"));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        return this.agent;
    }

    @Override
    public String getMax() {
        String id_agent = null;
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_MAX);
            while(this.rs.next()){
                id_agent = this.rs.getString(1);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return id_agent;
    }
    
    final String SELECT_ALL = "SELECT `id_agent`, `name_agent`, "
            + "`alamat_agent`, `provinsi_agent`, `negara_agent`, "
            + "`telp_agent`, `fax_agent`, `email_agent`, `website_agent`, "
            + "`reg_agent`, `fee_agent`, `status_agent`, `contact_name_agent`, "
            + "`contact_posisi_agent`, `contact_phone_agent` FROM `travel_agent`";
    
    final String INSERT = "INSERT INTO `travel_agent`"
            + "(`id_agent`, `name_agent`, `alamat_agent`, "
            + "`provinsi_agent`, `negara_agent`, `telp_agent`, "
            + "`fax_agent`, `email_agent`, `website_agent`, "
            + "`fee_agent`, `status_agent`, `contact_name_agent`, "
            + "`contact_posisi_agent`, `contact_phone_agent`) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
    final String UPDATE = "UPDATE `travel_agent` SET "
            + "`name_agent`=?,"
            + "`alamat_agent`=?,"
            + "`provinsi_agent`=?,"
            + "`negara_agent`=?,"
            + "`telp_agent`=?,"
            + "`fax_agent`=?,"
            + "`email_agent`=?,"
            + "`website_agent`=?,"
            + "`fee_agent`=?,"
            + "`status_agent`=?,"
            + "`contact_name_agent`=?,"
            + "`contact_posisi_agent`=?,"
            + "`contact_phone_agent`=? "
            + "WHERE `id_agent`=?";
    
    final String DELETE = "DELETE FROM `travel_agent` WHERE `id_agent`=?";
    
    final String SELECT_BY_ID = "SELECT `id_agent`, `name_agent`, "
            + "`alamat_agent`, `provinsi_agent`, `negara_agent`, "
            + "`telp_agent`, `fax_agent`, `email_agent`, `website_agent`, "
            + "`reg_agent`, `fee_agent`, `status_agent`, `contact_name_agent`, "
            + "`contact_posisi_agent`, `contact_phone_agent` FROM `travel_agent` "
            + "WHERE `id_agent`=?";
    
    final String SELECT_MAX = "SELECT MAX(`id_agent`) FROM `travel_agent`";
}
