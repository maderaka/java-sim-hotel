/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.RegistrasiDetail;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface RegistrasiDetailInterface {
    
    /**
     * 
     * @param registrasiDetail
     * @return 
     */
    public boolean insert(RegistrasiDetail registrasiDetail);
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean delete(String id);
    
    /**
     * 
     * @param registrasiDetail
     * @return 
     */
    public boolean update(RegistrasiDetail registrasiDetail);
    
    /**
     * 
     * @return 
     */
    public List<RegistrasiDetail> getAll();
    
    /**
     * 
     * @param idRegistrasi String 
     * @return 
     */
    public List<RegistrasiDetail> getAllByRegistrasi(String idRegistrasi);
    
    /**
     * 
     * @param id
     * @return 
     */
    public RegistrasiDetail getById(String id);
    
    /**
     * 
     * @return 
     */
    public List<RegistrasiDetail> getGuestInHouse();
    
}
