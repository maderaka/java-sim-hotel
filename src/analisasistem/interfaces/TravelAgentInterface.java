/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;
import analisasistem.entity.TravelAgent;
import java.util.List;
/**
 *
 * @author Raka New
 */
public interface TravelAgentInterface {
    
    public List<TravelAgent> getAll();
    
    public boolean insert(TravelAgent agent);
    
    public boolean delete(String id);
    
    public boolean update(String id, TravelAgent agent);
    
    public TravelAgent getById(String id_agent);
    
    public String getMax();
    
}
