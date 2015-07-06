/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

/**
 * 
 */
import analisasistem.entity.TransaksiLaundry;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface TransaksiLaundryInterface {
    
    /**
     * 
     * @param transaksiLaundry
     * @return 
     */
    public boolean insert(TransaksiLaundry transaksiLaundry);
    
    /**
     * 
     * @param transaksiLaundry
     * @return 
     */
    public boolean update(TransaksiLaundry transaksiLaundry);
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean delete(String id);
    
    /**
     * 
     * @return 
     */
    public List<TransaksiLaundry> getAll();
    
    /**
     * 
     * @param id
     * @return 
     */
    public TransaksiLaundry getById(String id);
    
    /**
     * 
     * @return 
     */
    public String getMax();
}
