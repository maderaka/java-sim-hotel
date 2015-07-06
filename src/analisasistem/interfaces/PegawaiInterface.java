/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.Pegawai;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface PegawaiInterface {
    
    public List<Pegawai> getAll();
    
    public boolean insert(Pegawai pegawai);
    
    public boolean update(Pegawai pegawai);
    
    public boolean delete(String id);
    
    public Pegawai getById(String id);
    
    public String getMax();
    
    public List<Pegawai> getPegawaiChooser();
}
