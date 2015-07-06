/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import java.util.List;

/**
 *
 * @author Raka New
 */
public interface PersonInterface {
    /**
     * 
     * @param person
     * @return 
     */
    public boolean insert(analisasistem.entity.Person person);
    
    /**
     * 
     * @param person
     * @return 
     */
    public boolean update(analisasistem.entity.Person person);
    
    /**
     * 
     * @param person
     * @return 
     */
    public boolean delete(String id);
    
    /**
     * 
     * @return 
     */
    public List<analisasistem.entity.Person> selectAll();
    
    /**
     * 
     * @param id
     * @return 
     */
    public analisasistem.entity.Person selectById(String id);
    
    /**
     * 
     */
    public String getMax();
}
