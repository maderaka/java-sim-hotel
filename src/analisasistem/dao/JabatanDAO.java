/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.config.Database;
import analisasistem.entity.Jabatan;
import analisasistem.interfaces.JabatanInterface;
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
public class JabatanDAO implements JabatanInterface{
    private Connection conn;
    private Statement stat;
    private PreparedStatement pStat;
    private ResultSet rs;
    private List<Jabatan> list;
    private final String INSERT     = "INSERT INTO `jabatan`(`id_jabatan`,`nama_jabatan`) VALUES(?,?);";
    private final String UPDATE     = "UPDATE `jabatan` SET `nama_jabatan`=? WHERE `id_jabatan`=?";
    private final String SELECT_ALL = "SELECT `id_jabatan`,`nama_jabatan` FROM `jabatan`";
    private final String SELECT_BY_ID = "SELECT `id_jabatan`,`nama_jabatan` FROM `jabatan` WHERE `id_jabatan`=?";
    private final String SELECT_MAX_ID = "SELECT max(`id_jabatan`) FROM `jabatan`";
    public JabatanDAO(){
        this.conn = Database.getConn();
    }

    @Override
    public boolean insert(Jabatan jabatan) {
        try{
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, jabatan.getIdJabatan());
            this.pStat.setString(2, jabatan.getNamaJabatan());
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
    public boolean update(Jabatan jabatan) {
        try{
            this.pStat = this.conn.prepareStatement(UPDATE);
            this.pStat.setString(1, jabatan.getNamaJabatan());
            this.pStat.setString(2, jabatan.getIdJabatan());
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
    public List<Jabatan> selectAll(){
        this.list = new ArrayList<Jabatan>();
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_ALL);
            while(rs.next()){
                Jabatan jabatan = new Jabatan();
                jabatan.setIdJabatan(rs.getString("id_jabatan"));
                jabatan.setNamaJabatan(rs.getString("nama_jabatan"));
                
                list.add(jabatan);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return this.list;
    }

    @Override
    public Jabatan selectById(String id) {
        Jabatan jabatan = new Jabatan();
        try{            
            this.pStat = this.conn.prepareStatement(SELECT_BY_ID);
            this.pStat.setString(1, id);
            ResultSet rs = this.pStat.executeQuery();
            if(rs.next()){
                jabatan.setIdJabatan(rs.getString("id_jabatan"));
                jabatan.setNamaJabatan(rs.getString("nama_jabatan"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return jabatan;
    }

    @Override
    public String selectMaxId() {
        String maxid = null;
        try{
            this.stat = this.conn.createStatement();
            ResultSet rs = this.stat.executeQuery(SELECT_MAX_ID);
            if(rs.next()){
                maxid = rs.getString(1);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return maxid;
    }
    
}
