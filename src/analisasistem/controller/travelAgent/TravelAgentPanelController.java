/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller.travelAgent;

import analisasistem.dao.TravelAgentDAO;
import analisasistem.entity.TravelAgent;
import analisasistem.interfaces.TravelAgentInterface;
import analisasistem.library.Laporan;
import analisasistem.library.OtomatisasiId;
import analisasistem.model.tableModel.TravelAgentModel;
import analisasistem.view.travelAgent.AgentForm;
import analisasistem.view.travelAgent.AgentListView;
import java.util.List;

/**
 *
 * @author Raka New
 */
public class TravelAgentPanelController {
    private AgentListView agentView;
    private List<TravelAgent>list;
    private TravelAgentInterface travelData;
    /**
     * Constructor
     * 
     * @param agentView AgentListView
     */
    public TravelAgentPanelController(AgentListView agentView){
        this.agentView = agentView;
        this.travelData = new TravelAgentDAO();
    }
    /**
     * 
     */
    public void isiTable(){
        this.list = this.travelData.getAll();
        TravelAgentModel model = new TravelAgentModel(this.list);
        this.agentView.getTblTravelAgent().setModel(model);
    }
    /**
     * 
     */
    public void viewFormDialog(){
        String id = (String) this.agentView.getTblTravelAgent().getValueAt(this.agentView.getTblTravelAgent().getSelectedRow(), 1);
        AgentForm dialog = new AgentForm(null,true);
        System.out.println("Id"+id);
        dialog.setAksi(2);
        dialog.getBtnSave().setText("Save Changed");
        dialog.getTxId().setText(id);
        dialog.viewDataTravelAgent();
        dialog.setEnabled(true);
        dialog.setVisible(true);
        
    }

    public void addTravelAgent(){
        OtomatisasiId oto = new OtomatisasiId();
        AgentForm agentForm = new AgentForm(null, true);
        agentForm.setAksi(1);
        agentForm.getTxId().setText(oto.forTravelAgent());
        agentForm.setVisible(true);
        agentForm.setEnabled(true);
    }
    
    public void reportAgent(){
        int row = this.agentView.getTblTravelAgent().getSelectedRow();
        String id_agent = (String) this.agentView.getTblTravelAgent().getValueAt(row, 1);
        Laporan laporan = new Laporan();
        laporan.forAgentReport(id_agent);
    }
}
