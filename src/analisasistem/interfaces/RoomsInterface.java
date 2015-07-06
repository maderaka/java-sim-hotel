/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.Rooms;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface RoomsInterface {
    
    public List<Rooms> getAll();
    
    public boolean insert(Rooms room);
    
    public boolean delete(String id);
    
    public boolean update(Rooms rooms);
    
    public List<Rooms> getByType(String id);
    
    public Rooms getByid(String id);
    
    public String getMaxId();
    
    public String selectIdByName(String name);
}
