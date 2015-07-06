/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.ReservasiDetail;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface ReservasiDetailInterface {
    
    /**
     * 
     * @param detail
     * @return 
     */
    public boolean insert(ReservasiDetail detail);
    
    /**
     * 
     * @param detail
     * @return 
     */
    public boolean update(ReservasiDetail detail);
    
    /**
     * 
     * @return 
     */
    public List<ReservasiDetail> selectAll();
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean delete(int id);
    
    /**
     * 
     * @return 
     */
    public List<ReservasiDetail> selectByIdReservasi(String idReservasi);
    
    /**
     * 
     * @return 
     */
    public List<ReservasiDetail> selectById();
}
