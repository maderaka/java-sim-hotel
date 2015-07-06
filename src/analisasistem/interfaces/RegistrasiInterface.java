/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.Registrasi;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface RegistrasiInterface {
    /**
     * 
     * @param registrasi
     * @return 
     */
    public boolean insert(Registrasi registrasi);
    
    /**
     * 
     * @param registrasi
     * @return 
     */
    public boolean update(Registrasi registrasi);
    
    /**
     * 
     * @param idRegistrasi
     * @return 
     */
    public boolean delete(String idRegistrasi);
    
    /**
     * 
     * @param idRegistrasi
     * @return 
     */
    public Registrasi selectById(String idRegistrasi);
    
    /**
     * 
     * @return 
     */
    public List<Registrasi> selectAll();
    
    /**
     * @return String
     */
    public String selectMax();
    
}
