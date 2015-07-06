/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.RoomType;
import java.util.List;
/**
 *
 * @author Raka New
 */
public interface RoomTypeInterface {
    
    public boolean insert(RoomType roomType);
    
    public boolean delete(String id);
    
    public boolean update(RoomType roomType);
    
    public List<RoomType> getAll();
    
    public List<RoomType> getByKeyword(String key);
    
    public RoomType getById(String id);
    
    public String getMaxId();
    
}
