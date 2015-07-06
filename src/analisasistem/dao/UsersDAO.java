/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.entity.Users;
import analisasistem.interfaces.UsersInterface;
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
public class UsersDAO implements UsersInterface{
    /**
     * 
     */
    public UsersDAO(){
        this.conn = analisasistem.config.Database.getConn();
    }
    
    @Override
    public List<Users> selectAll() {
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_ALL);
            while(this.rs.next()){
                Users users = new Users(
                            this.rs.getString("id_user"),
                            this.rs.getString("name_user"),
                            null,
                            this.rs.getDate("date_user"),
                            this.rs.getInt("status_user")
                        );
                users.getPegawai().getJabatan().setNamaJabatan(this.rs.getString("nama_jabatan"));
                users.getPegawai().setNama(this.rs.getString("name_pegawai"));
                this.list.add(users);
            }
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return this.list;
    }

    @Override
    public Users selectById(String id) {
        //To change body of generated methods, choose Tools | Templates.
        Users user = new Users();
        try{
            this.pStat = this.conn.prepareStatement(SELECT_BY_ID);
            this.pStat.setString(1, id);
            this.rs =  this.pStat.executeQuery();
            if(this.rs.next()){
                user.setIdUser(rs.getString("id_user"));
                user.setUsername(rs.getString("name_user"));
                user.setPassWord(rs.getString("password_user"));
                user.setStatus(rs.getInt("status_user"));
                user.setDateCreate(rs.getDate("date_user"));
                user.getPegawai().setId(rs.getString("id_pegawai"));
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return user;
    }

    @Override
    public boolean insert(Users user){
        try{
            //`id_user`,`id_pegawai`,`name_user`,`password_user`,`menu_user`,`date_user`,`status_user`";
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, user.getIdUser());
            this.pStat.setString(2, user.getPegawai().getId());
            this.pStat.setString(3, user.getUsername());
            this.pStat.setString(4, user.getPassWord());
            this.pStat.setString(5, user.getAksesMenu());
            this.pStat.setInt(6, user.getStatus());
            // no comment
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Users user) {
        try{
            this.pStat = this.conn.prepareStatement(UPDATE);
            this.pStat.setString(1, user.getUsername());
            this.pStat.setString(2, user.getPassWord());
            this.pStat.setString(3, user.getPegawai().getId());
            this.pStat.setInt(4, user.getStatus());
            this.pStat.setDate(5, (java.sql.Date) user.getDateCreate());
            this.pStat.setString(6, user.getIdUser());
            
            // no comment
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
         //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) {
        try{
            this.pStat = this.conn.prepareStatement(DELETE);
            this.pStat.setString(1,id);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    @Override
    public String getMax() {
        String max = "";
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_MAX);
            if(this.rs.next()){
                max = this.rs.getString("max");
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return max;
    }
    
    /**
     * 
     */
    private Connection conn;
    private PreparedStatement pStat;
    private Statement stat;
    private ResultSet rs;
    private List<Users> list = new ArrayList<Users>();
    
    private final String SELECT_ALL     = "SELECT user.id_user,user.name_user, user.status_user,user.date_user, pegawai.name_pegawai, jabatan.nama_jabatan\n" +
                                        "FROM user \n" +
                                        "JOIN pegawai ON pegawai.id_pegawai=user.id_pegawai\n" +
                                        "JOIN jabatan ON jabatan.id_jabatan=pegawai.id_jabatan;";
    private final String SELECT_BY_ID   = "SELECT `id_user`, `name_user`, `password_user`, `id_pegawai`, `status` `date_user` FROM `tbusers` WHEHE `id_user`=?;";
    private final String DELETE         = "DELETE FROM `tbusers` WHERE `id_user`=?;";
    private final String UPDATE         = "UPDATE user SET `name_user`=?,`password_user`=?,`id_pegawai`=?,`status`=?,`date_user`=? WHERE `id_user`=?;";
    private final String INSERT         = "INSERT INTO user (`id_user`,`id_pegawai`,`name_user`,`password_user`,`menu_user`,`status_user`) VALUES(?,?,?,?,?,?);";
    private final String SELECT_MAX     = "SELECT max(id_user) AS max FROM user;";
}
