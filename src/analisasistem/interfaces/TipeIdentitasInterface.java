/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.TipeIdentitas;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface TipeIdentitasInterface {
    
    public List<TipeIdentitas> selectAll();
    
    public TipeIdentitas selectById();
    
    public boolean insert(TipeIdentitas id);
    
    public boolean delete(int id);
}
