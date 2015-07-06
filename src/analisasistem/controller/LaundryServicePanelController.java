/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller;

import analisasistem.dao.LaundryServiceDAO;
import analisasistem.entity.LaundryService;
import analisasistem.interfaces.LaundryServiceInterface;
import analisasistem.library.OtomatisasiId;
import analisasistem.model.tableModel.LaundryServiceModel;
import analisasistem.view.laundry.LaundryServicePanel;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Raka New
 */
public class LaundryServicePanelController {
    private LaundryServicePanel panel;
    private LaundryServiceInterface data = new LaundryServiceDAO();
    private List<LaundryService> list;
    
    public LaundryServicePanelController(LaundryServicePanel panel){
        this.panel = panel;
        this.defaultConfig();
    }
    
    private void defaultConfig(){
        OtomatisasiId oto = new OtomatisasiId();
        String id = oto.forLaundryService();
        this.panel.getTxKode().setText(id);
    }
    public void isiTable(){
        this.list = this.data.getAll();
        LaundryServiceModel model = new LaundryServiceModel(this.list);
        this.panel.getTbLaundryService().setModel(model);
    }
    
    public void insert(){
        OtomatisasiId otomatisasi = new OtomatisasiId();
        LaundryService laundry = new LaundryService();
        laundry.setIdBarang(otomatisasi.forLaundryService());
        laundry.setNamaBarang(this.panel.getTxNama().getText());
        laundry.setHarga(Integer.parseInt(this.panel.getTxBiaya().getText()));
        laundry.setDescBarang(this.panel.getTxKeterangan().getText());
        
        if(this.data.insert(laundry)){
            JOptionPane.showMessageDialog(this.panel, "Well done, proses mencatat data berhasil dilakukan");
        }else{
            JOptionPane.showMessageDialog(this.panel, "Mohon maaf, proses mencatat data gagal dilakukan");
        }
    }
    
    public void viewById(){
        this.panel.getTxKode().setText((String) this.panel.getTbLaundryService().getValueAt(this.panel.getTbLaundryService().getSelectedRow(), 0));
        String idBarang = this.panel.getTxKode().getText();
        LaundryService laundry = new LaundryService();
        laundry = data.getById(idBarang);
        this.panel.getTxKode().setText(laundry.getIdBarang());
        this.panel.getTxNama().setText(laundry.getNamaBarang());
        this.panel.getTxBiaya().setText(Integer.toString(laundry.getHarga()));
        this.panel.getTxKeterangan().setText(laundry.getDescBarang());
        this.panel.setUpdateBool(true);
        this.panel.getBtnOK().setText("Update");
    }
    
    public void update(){
        String idBarang = this.panel.getTxKode().getText();
        LaundryService laundry = new LaundryService();
        laundry.setIdBarang(this.panel.getTxKode().getText());
        laundry.setNamaBarang(this.panel.getTxNama().getText());
        laundry.setHarga(Integer.parseInt(this.panel.getTxBiaya().getText()));
        laundry.setDescBarang(this.panel.getTxKeterangan().getText());
        
        if(data.update(laundry)){
            JOptionPane.showMessageDialog(this.panel, "Well done, data laundry berhasil di update");
        }else{
            JOptionPane.showMessageDialog(this.panel, "Error, pembaruan data laundry gagal dilakukan");
        }
    }
    
    public void reset(){
        this.panel.getTxNama().setText("");
        this.panel.getTxKeterangan().setText("");
        this.panel.getTxBiaya().setText("");
        this.panel.setUpdateBool(false);
        this.panel.getBtnOK().setText("Save");
        this.defaultConfig();
    }
    
    public void delete(){
        if(data.delete(this.getId())){
            JOptionPane.showMessageDialog(this.panel,"Well done! data berhasil dihapus");
        }else{
            JOptionPane.showMessageDialog(this.panel,"Well done! data gagal dihapus");
        }
    }
    
    /**
     * 
     * @return String
     */
    private String getId(){
        return this.panel.getTxKode().getText();
    }
    
    /**
     * 
     * @return String
     */
    private String generateId(){
        OtomatisasiId otomatisasi = new OtomatisasiId();
        return otomatisasi.forLaundryService();
    }
}
