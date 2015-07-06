/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.LaundryService;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface LaundryServiceInterface {
    /**
     * 
     * @return List
     * 
     */
    public List<LaundryService> getAll();
    
    /**
     * 
     * @param lS
     * @return boolean
     */
    public boolean insert(LaundryService lS);
    
    /**
     * 
     * @param lS
     * @return boolean
     */
    public boolean update(LaundryService lS);
    
    /**
     * 
     * @param idJenisBarang
     * @return boolean
     */
    public LaundryService getById(String idJenisBarang);
    
    /**
     * 
     */
    public String selectMax();
    
    /**
     * 
     */
    public boolean delete(String idBarang);
}
