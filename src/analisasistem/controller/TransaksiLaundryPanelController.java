/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller;

import analisasistem.entity.TransaksiLaundry;
import analisasistem.view.laundry.TransaksiLaundryPanel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Raka New
 */
public class TransaksiLaundryPanelController {
    
    private TransaksiLaundryPanel panel;
    private analisasistem.interfaces.TransaksiLaundryInterface dataTransaksi = new analisasistem.dao.TransaksiLaundryDAO();
    public TransaksiLaundryPanelController(TransaksiLaundryPanel panel){
        this.panel = panel;
        this.defaultConfig();
    }
    
    private void defaultConfig(){
        this.isiTable();
        
        analisasistem.library.TableStyle style = new analisasistem.library.TableStyle();
        style.setSize(this.panel.getTbTransaksiLaundry(), new int[]{60,100,100,100,100,100}, true);
    }
    
    private void isiTable(){
        List<TransaksiLaundry> list = new ArrayList<TransaksiLaundry>();
        list = dataTransaksi.getAll();
        analisasistem.model.tableModel.TransaksiLaundryModel model = new analisasistem.model.tableModel.TransaksiLaundryModel(list);
        this.panel.getTbTransaksiLaundry().setModel(model);
    }
    public void insert(){
        
    }
    
    public void viewData(){
        
    }
}
