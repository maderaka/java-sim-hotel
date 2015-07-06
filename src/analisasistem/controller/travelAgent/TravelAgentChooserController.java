/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller.travelAgent;

import analisasistem.entity.TravelAgent;
import analisasistem.view.travelAgent.TravelAgentChooser;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Raka New
 */
public class TravelAgentChooserController {
    
    private TravelAgentChooser chooserForm;
    private List<TravelAgent> list = new ArrayList<TravelAgent>();
    private JTextField tx;
    analisasistem.interfaces.TravelAgentInterface dataAgent = new analisasistem.dao.TravelAgentDAO();
    
    /**
     * 
     */
    public TravelAgentChooserController(TravelAgentChooser chooserForm, JTextField tx){
        this.chooserForm = chooserForm;
        this.tx = tx;
        
        this.defaultConfig();
    }
    
    private void defaultConfig(){
        this.isiTable();
    }
    
    private void isiTable(){
        this.list = dataAgent.getAll();
        analisasistem.model.tableModel.TravelAgentModel model = new analisasistem.model.tableModel.TravelAgentModel(list);
        this.chooserForm.getTbTravelAgent().setModel(model);
    }
    
    public void setTx(JTextField tx){
        this.tx = tx;
    }
    
    public JTextField getTx(){
        return this.tx;
    }
    
    public void choose(){
        int row = this.chooserForm.getTbTravelAgent().getSelectedRow();
        String idRooms = (String) this.chooserForm.getTbTravelAgent().getValueAt(row, 1);
        System.out.println(idRooms);
        this.chooserForm.getTx().setText(idRooms);
        this.chooserForm.dispose();
    }
}