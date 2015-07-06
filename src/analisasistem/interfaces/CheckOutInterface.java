/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.interfaces;

import analisasistem.entity.CheckOut;
import java.util.List;

/**
 *
 * @author Raka New
 */
public interface CheckOutInterface {
    public boolean insert(CheckOut co);
    public CheckOut selectById(String id);
    public List<CheckOut> selectAll();
    public String selectMax();
}
