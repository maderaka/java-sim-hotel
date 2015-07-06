/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.config.Database;
import analisasistem.entity.CheckOut;
import analisasistem.interfaces.CheckOutInterface;
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
public class CheckOutDAO implements CheckOutInterface{
    private Connection conn;
    private Statement stat;
    private PreparedStatement pStat;
    private List<CheckOut> list;
    private ResultSet rs;
    private CheckOut co;
    
    public CheckOutDAO(){
        this.conn = Database.getConn();
        this.co = new CheckOut();
    }
    @Override
    public boolean insert(CheckOut co) {
        try{
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, co.getId());
            this.pStat.setDate(2, new java.sql.Date(co.getDate().getTime()));
            this.pStat.setString(3, co.getMemo());
            this.pStat.setString(4, co.getRegistrasi().getIdRegistrasi());
            this.pStat.setString(5, co.getUser().getIdUser());
            if(this.pStat.executeUpdate() == 1) return true;
        }catch(SQLException e){
            System.out.println("terjadi error pada saat insert user");
            System.out.println(e.getMessage());
            return false;
        }
        return false;
    }

    @Override
    public CheckOut selectById(String id) {
        //To change body of generated methods, choose Tools | Templates.
        try{
            this.pStat = this.conn.prepareStatement(SELECT_BY_ID);
            this.pStat.setString(1, id);
            this.rs = this.pStat.executeQuery();
            if(this.rs.next()){
                this.co.setId(this.rs.getString("id_checkout"));
                this.co.setMemo(this.rs.getString("memo_checkout"));
                this.co.setDate(this.rs.getDate("date_checkout"));
                this.co.getRegistrasi().setIdRegistrasi(this.rs.getString("id_reg"));
                this.co.getUser().setIdUser(this.rs.getString("id_user"));
            }
        }catch(SQLException e){
            System.out.println("terjadi error pada saat mengambil data checkout");
            System.out.println(e.getMessage());
        }
        return this.co;
    }

    @Override
    public List<CheckOut> selectAll() {
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_ALL);
            this.list = new ArrayList<CheckOut>();
            while(this.rs.next()){
                CheckOut co = new CheckOut();
                co.setId(this.rs.getString("id_checkout"));
                co.setMemo(this.rs.getString("memo_checkout"));
                co.setDate(this.rs.getDate("date_checkout"));
                co.getRegistrasi().setIdRegistrasi(this.rs.getString("id_reg"));
                co.getUser().setIdUser(this.rs.getString("id_user"));
                this.list.add(co);
            }
        }catch(SQLException e){
            System.out.println("terjadi error pada saat mengambil semua data check out");
            System.out.println(e.getMessage());
        }
        return this.list;
    }
    
    final static String INSERT = "INSERT INTO `checkout`(`id_checkout`,`date_checkout`,`memo_checkout`,`id_reg`,`id_user`) VALUE (?,?,?,?,?)";
    final static String SELECT_ALL = "SELECT * FROM `checkout`";
    final static String SELECT_BY_ID = "SELECT \n" +
                        "    `registrasi`.`id_registrasi`,\n" +
                        "    `registrasi`.`id_tamu`,\n" +
                        "    `tamu`.`nama_tamu`\n" +
                        "FROM\n" +
                        "    `registrasi`\n" +
                        "        INNER JOIN\n" +
                        "    `tamu` ON `registrasi`.`id_tamu` = `tamu`.`id_tamu`\n" +
                        "WHERE\n" +
                        "    `id_registrasi` = ?";
    final String SELECT_MAX = "SELECT MAX(`id_checkout`) as `max` FROM `checkout`;";

    @Override
    public String selectMax() {
        //To change body of generated methods, choose Tools | Templates.
        try{
            this.stat = this.conn.createStatement();
            this.rs = this.stat.executeQuery(SELECT_MAX);
            if(this.rs.next()){
                return this.rs.getString("max");
            }
        }catch(SQLException e){
            System.out.println("terjadi error pada pengambilan data maksimal check out");
            System.out.println(e.getMessage());
        }
        return null;
    }
    
}
