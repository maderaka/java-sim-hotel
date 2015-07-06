/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.dao;

import analisasistem.config.Database;
import analisasistem.entity.TransaksiLaundryDetail;
import analisasistem.interfaces.TransaksiLaundryDetailInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Raka New
 */
public class TransaksiLaundryDetailDAO implements TransaksiLaundryDetailInterface{
    private Connection conn;
    private Statement stat;
    private PreparedStatement pStat;
    private ResultSet rs;
    private TransaksiLaundryDetail transaksiDetail = new TransaksiLaundryDetail();
    private final String INSERT = "INSERT INTO `detail_transaksi_laundry`"
            + "(`reg_id_user`, "
            + "`id_registrasi`, "
            + "`id_transaksi_laundry`, "
            + "`id_laundry`, "
            + "`qty_detail_transaksi_laundry`, "
            + "`subtotal_detail_transaksi`) "
            + "VALUES (?,?,?,?,?,?)";
    public TransaksiLaundryDetailDAO(){
        this.conn = Database.getConn();
    }
    @Override
    public boolean insert(TransaksiLaundryDetail transaksiLaundryDetail) {
        //To change body of generated methods, choose Tools | Templates.
        try{
            this.pStat = this.conn.prepareStatement(INSERT);
            this.pStat.setString(1, transaksiLaundryDetail.getUser().getIdUser());
            this.pStat.setString(2, transaksiLaundryDetail.getRegistrasi().getIdRegistrasi());
            this.pStat.setString(3, transaksiLaundryDetail.getTransaksiLaundry().getNoTransaksiLaundry());
            this.pStat.setString(4, transaksiLaundryDetail.getLaundry().getIdBarang());
            this.pStat.setInt(5, transaksiLaundryDetail.getQtyTransaksi());
            this.pStat.setInt(6, transaksiLaundryDetail.getSubtotalTransaksi());
            if(this.pStat.executeUpdate() == 1){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println("Terjadi error pada insert transaksi laundry detail "+e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(String idTransaksiLaundryDetail) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TransaksiLaundryDetail> selectByIdTransaksiLaundry(String idTransaksiLaundry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
