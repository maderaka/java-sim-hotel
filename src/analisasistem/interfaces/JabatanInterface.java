/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.Jabatan;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface JabatanInterface {
    
    public boolean insert(Jabatan jabatan);
    
    public boolean update(Jabatan jabatan);
    
    public List<Jabatan> selectAll();
    
    public Jabatan selectById(String id);
    
    public String selectMaxId();
    
}
