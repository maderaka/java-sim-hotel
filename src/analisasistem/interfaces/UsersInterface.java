/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.Users;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface UsersInterface {
    /**
     * 
     * @return 
     */
    public List<Users> selectAll();
    
    /**
     * 
     * @return 
     */
    public Users selectById(String id);
    
    /**
     * 
     * @param user
     * @return 
     */
    public boolean insert(Users user);
    
    /**
     * 
     * @param user
     * @return 
     */
    public boolean update(Users user);
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean delete(String id);
    
    /**
     * 
     * @return String
     */
    public String getMax();
}
