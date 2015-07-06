/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.Person;
import analisasistem.entity.Reservasi;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface ReservasiInterface {
    public List<Reservasi> selectAll();
    public boolean insert(Reservasi reservasi);
    public boolean update(Reservasi reservasi);
    public boolean delete(String noReservasi);
    public Person selectById(String noReservasi);
    public String selectMaxId();
}
