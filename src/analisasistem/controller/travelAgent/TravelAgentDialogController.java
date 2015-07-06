/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller.travelAgent;

import analisasistem.dao.TravelAgentDAO;
import analisasistem.entity.TravelAgent;
import analisasistem.interfaces.TravelAgentInterface;
import analisasistem.view.travelAgent.AgentForm;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Raka New
 */
public class TravelAgentDialogController {
    private TravelAgentInterface travelData;
    private TravelAgent travelAgent;
    /**
     * 
     */
    
    private AgentForm form;
    /**
     * 
     * @param form AgentForm
     */
    public TravelAgentDialogController(AgentForm form){
        this.form = form;
        this.travelData = new TravelAgentDAO();
        this.travelAgent = new TravelAgent();
    }
    
    /**
     * 
     */
    public void insert(){
       this.travelAgent.setId(this.generateId());
       this.travelAgent.setName(this.form.getTxName().getText());
       this.travelAgent.setAlamat(this.form.getTxAreaAlamat().getText());
       this.travelAgent.setNegara(this.form.getTxKota().getText());
       this.travelAgent.setProvinsi(this.form.getTxProvinsi().getText());
       this.travelAgent.setEmail(this.form.getTxEmail().getText());
       this.travelAgent.setPhone(this.form.getTxPhone().getText());
       this.travelAgent.setFax(this.form.getTxFax().getText());
       this.travelAgent.setWebsite(this.form.getTxWebsite().getText());
       this.travelAgent.setEmail(this.form.getTxEmail().getText());
       this.travelAgent.setContactName(this.form.getTxContactName().getText());
       this.travelAgent.setContactPosisi(this.form.getTxContactPosition().getText());
       this.travelAgent.setContactPhone(this.form.getTxContactPhone().getText());
       this.travelAgent.setFee(Integer.parseInt(this.form.getTxDiskon().getText()));
       if(this.travelData.insert(travelAgent)){
           JOptionPane.showMessageDialog(null, "Data travel agent berhasil dicatat");
       }else{
           JOptionPane.showMessageDialog(null, "Data travel agent gagal dicatat");
       }
    }
    /**
     * 
     * Update Travel Agent
     * 
     */
    public void update(){
        this.travelAgent.setName(this.form.getTxName().getText());
        this.travelAgent.setAlamat(this.form.getTxAreaAlamat().getText());
        this.travelAgent.setNegara(this.form.getTxKota().getText());
        this.travelAgent.setProvinsi(this.form.getTxProvinsi().getText());
        this.travelAgent.setPhone(this.form.getTxPhone().getText());
        this.travelAgent.setEmail(this.form.getTxEmail().getText());
        this.travelAgent.setFax(this.form.getTxFax().getText());
        this.travelAgent.setWebsite(this.form.getTxWebsite().getText());
        this.travelAgent.setContactName(this.form.getTxContactName().getText());
        this.travelAgent.setContactPhone(this.form.getTxContactPhone().getText());
        this.travelAgent.setContactPosisi(this.form.getTxContactPosition().getText());
        this.travelAgent.setFee(Integer.parseInt(this.form.getTxDiskon().getText()));
        this.travelAgent.setStatus(this.generateStatus());
        if(this.travelData.update(this.form.getTxId().getText(), this.travelAgent)){
            JOptionPane.showMessageDialog(this.form, "Data travel agent "+this.travelAgent.getName()+" berhasil diperbaharui");
        }else{
            JOptionPane.showMessageDialog(this.form, "Data travel agent "+this.travelAgent.getName()+" gagal diperbaharui");
        }
    }
    /**
     * 
     * @return int
     */
    public int generateStatus(){
        if(this.form.getRadioActive().isSelected() == true){
            return 1;
        }else if (this.form.getRadioNonActive().isSelected() == true){
            return 0;
        }else{
            return 0;
        }
    }
    private void setStatusForm(TravelAgent agent){
        this.travelAgent = agent;
        if(this.travelAgent.getStatus() == 1){
            this.form.getRadioActive().setSelected(true);
        }else if(this.travelAgent.getStatus() == 0){
            this.form.getRadioNonActive().setSelected(true);
        }
    }
    /**
     * 
     * Generate Id
     * Method ini digunakan untuk menciptakan id travel agent
     * 
     */
    private String generateId(){
        int max_id;
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yy");
        if(this.travelData.getMax() != null){
            max_id = Integer.parseInt(this.travelData.getMax().substring(4));
            max_id++;
            String s1 = String.format("%03d%n", max_id);
            return ("AG"+format.format(d)+s1);
        }
        return "AG"+format.format(d)+"001"; 
    }
    /**
     * Set Id
     */
    public void setId(){
        String id_agent = this.generateId();
        this.form.getTxId().setText(id_agent);
    }
    
    /**
     * Cancel
     */
    public void cancel(){
        this.form.dispose();
    }
    
    /**
     * 
     */
    public void viewDataTraveAgent(){
        String id = this.form.getTxId().getText();
        this.travelAgent = this.travelData.getById(id);
        this.form.getTxName().setText(this.travelAgent.getName());
        this.form.getTxAreaAlamat().setText(this.travelAgent.getAlamat());
        this.form.getTxKota().setText(this.travelAgent.getNegara());
        this.form.getTxProvinsi().setText(this.travelAgent.getProvinsi());
        this.form.getTxEmail().setText(this.travelAgent.getEmail());
        this.form.getTxPhone().setText(this.travelAgent.getPhone());
        this.form.getTxFax().setText(this.travelAgent.getFax());
        this.form.getTxWebsite().setText(this.travelAgent.getWebsite());
        this.form.getTxContactName().setText(this.travelAgent.getContactName());
        this.form.getTxContactPosition().setText(this.travelAgent.getContactPosisi());
        this.form.getTxContactPhone().setText(this.travelAgent.getContactPhone());
        this.form.getTxDiskon().setText(Integer.toString(this.travelAgent.getFee()));
        this.form.getLblRegister().setText(": "+this.travelAgent.getRegDate());
        
        this.setStatusForm(this.travelAgent);
    }
    
}
