/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.entity.TipeIdentitas;
import analisasistem.interfaces.TipeIdentitasInterface;
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
public class TipeIdentitasDAO implements TipeIdentitasInterface{
    private final String SELECT_ALL = "SELECT * FROM `tbtipeidentitas`";
    PreparedStatement pStat;
    Statement stat;
    List<TipeIdentitas> list;
    private Connection conn;
    public TipeIdentitasDAO(){
        this.conn = (Connection) analisasistem.config.Database.getConn();
        
    }
    
    @Override
    public List<TipeIdentitas> selectAll() {
        this.list = new ArrayList<TipeIdentitas>();
        try{
            this.stat = this.conn.createStatement();
            ResultSet rs = this.stat.executeQuery(SELECT_ALL);
            while(rs.next()){
                TipeIdentitas tipe = new TipeIdentitas();
                tipe.setIdTipeIdentitas(rs.getInt("id_tipeidentitas"));
                tipe.setNamaTipeIdentitas(rs.getString("nama_tipeidentitas"));
                this.list.add(tipe);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return this.list;
    }

    @Override
    public TipeIdentitas selectById() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insert(TipeIdentitas id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
