/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.TransaksiLaundryDetail;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface TransaksiLaundryDetailInterface {
    /**
     * 
     * @param transaksiLaundryDetail
     * @return 
     */
    public boolean insert(TransaksiLaundryDetail transaksiLaundryDetail);
    
    /**
     * 
     * @param idTransaksiLaundryDetail
     * @return 
     */
    public boolean delete(String idTransaksiLaundryDetail);
    
    /**
     * 
     * @param idTransaksiLaundry
     * @return 
     */
    public List<TransaksiLaundryDetail> selectByIdTransaksiLaundry(String idTransaksiLaundry);
}
