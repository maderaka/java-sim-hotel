/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.Tamu;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface TamuInterface {
    
    /**
     * 
     * @param tamu
     * @return 
     */
    public boolean insert(Tamu tamu);
    
    /**
     * 
     * @param tamu
     * @return 
     */
    public boolean update(Tamu tamu);
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean delete(String id);
    
    /**
     * 
     * @param id
     * @return 
     */
    public Tamu selectById(String id);
    
    /**
     * 
     * @return 
     */
    public String selectMax();
    
    /**
     * 
     * @return 
     */
    public List<Tamu> selectAll();
}
