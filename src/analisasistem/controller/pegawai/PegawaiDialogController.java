/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.controller.pegawai;

import analisasistem.dao.PegawaiDAO;
import analisasistem.entity.Jabatan;
import analisasistem.entity.Pegawai;
import analisasistem.view.pegawai.FormPegawaiDialog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Raka New
 */

public class PegawaiDialogController {
    private FormPegawaiDialog form;
    private PegawaiDAO pegawaiDAO;
    private analisasistem.model.tableModel.JabatanModel modelJabatan;
   
    public PegawaiDialogController(FormPegawaiDialog form){
        this.form = form;
        this.pegawaiDAO = new PegawaiDAO();
        this.setJabatan();
    }
    
    public void setId(){
        //PG-1302001
        String max_id =null;
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMM");
        if(this.pegawaiDAO.getMax() != null){
            int maxInt = Integer.parseInt(this.pegawaiDAO.getMax().substring(7));
            maxInt++;
            String s1 = String.format("%03d%n", maxInt);
            this.form.getTxId().setText("PG-"+format.format(d)+s1);
        }else{
            this.form.getTxId().setText("PG-"+format.format(d)+"001");
        }
        
    }
    
    public void dispose(){
        this.form.dispose();
    }
    
    public void insert(){
       Pegawai pegawai = new Pegawai();
       pegawai.setId(this.form.getTxId().getText());
       pegawai.setNama(this.form.getTxNama().getText());
       pegawai.setJenisKelamin(this.getJenisKelamin());
       pegawai.setTanggalLahir(new java.sql.Date(this.form.getDateChooserLahir().getDate().getTime()));
       pegawai.setTempatLahir(this.form.getTxTempatLahir().getText());
       pegawai.setAlamat(this.form.getTxAreaAlamat().getText());
       pegawai.setProvinsi(this.form.getTxProvinsi().getText());
       pegawai.setKota(this.form.getTxKota().getText());
       pegawai.setTelp(this.form.getTxPhone().getText());
       pegawai.getJabatan().setIdJabatan(this.getJabatanSelected());
       if(this.pegawaiDAO.insert(pegawai)){
           JOptionPane.showMessageDialog(this.form, "Data berhasil ditambagkan");
       }
    }
    
    public void update(){
        Pegawai pegawai = new Pegawai();
        pegawai.setId(this.form.getTxId().getText());
        pegawai.setNama(this.form.getTxNama().getText());
        pegawai.setTempatLahir(this.form.getTxTempatLahir().getText());
        pegawai.setJenisKelamin(this.getJenisKelamin());
        pegawai.setTanggalLahir(new java.sql.Date(this.form.getDateChooserLahir().getDate().getTime()));
        pegawai.setAlamat(this.form.getTxAreaAlamat().getText());
        pegawai.setProvinsi(this.form.getTxProvinsi().getText());
        pegawai.setKota(this.form.getTxKota().getText());
        pegawai.setTelp(this.form.getTxPhone().getText());
        pegawai.getJabatan().setIdJabatan(this.getJabatanSelected());
        if(this.pegawaiDAO.update(pegawai)){
            JOptionPane.showMessageDialog(null, "Perubahan data berhasil dilakukan");
        }else{
            JOptionPane.showMessageDialog(null, "Perubahan data gagal dilakukan");
        }
    }
    
    public void viewDataPegawai(){
       Pegawai pegawai = this.pegawaiDAO.getById(this.form.getTxId().getText());
       this.setJabatanSelected(pegawai.getJabatan().getIdJabatan());
       this.form.getTxId().setText(pegawai.getId());
       this.form.getTxNama().setText(pegawai.getNama());
       this.form.getTxAreaAlamat().setText(pegawai.getAlamat());
       this.form.getTxKota().setText(pegawai.getKota());
       this.form.getTxProvinsi().setText(pegawai.getProvinsi());
       this.form.getTxTempatLahir().setText(pegawai.getTempatLahir());
       this.form.getDateChooserLahir().setDate(new Date());
       this.form.getTxAreaAlamat().setText(pegawai.getAlamat());
       this.form.getTxProvinsi().setText(pegawai.getAlamat());
       this.form.getTxKota().setText(pegawai.getKota());
       this.form.getTxPhone().setText(pegawai.getTelp());
       this.setJenisKelamin(pegawai.getJenisKelamin());
    }
    /**
     * 
     * @return integer
     */
    public int getJenisKelamin(){
        int sex = 0;
        if(this.form.getRadioLaki().isSelected()){
            sex = 1;
        }else if(this.form.getRadioLaki().isSelected()){
            sex = 0;
        }
        return sex;
    }
    /**
     * 
     * @param sex int
     */
    private void setJenisKelamin(int sex){
        if(sex ==1){
            this.form.getRadioLaki().setSelected(true);
        }else if(sex ==0){
            this.form.getRadioPerempuan().setSelected(true);
        }
    }
    /**
     * 
     * @param date Date
     * @return 
     */
    public Date generateData(Date date){
        Date tanggal = null;
        String tanggalStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-d");
        try {
            tanggal = format.parse(tanggalStr);
        } catch (ParseException ex) {
            Logger.getLogger(PegawaiDialogController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tanggal;
    }
    
    /**
     * 
     */
    private String getJabatanSelected(){
        int index = this.form.getJcbJabatan().getSelectedIndex();
        System.out.println(index);
        System.out.println(this.modelJabatan.getValueAt(index, 0));
        return (String) this.modelJabatan.getValueAt(index, 0);
    }
    
    /**
     * 
     * Method ini digunakan untuk mengatur jabatan pegawai yang terpilih di JComboBox agar
     * sesuai dengan data di tabel pegawai
     * 
     * @param idJabatan 
     */
    private void setJabatanSelected(String idJabatan){
        for(int i=0;i<this.modelJabatan.getRowCount();i++){
            if(this.modelJabatan.getValueAt(i, 0).equals(idJabatan)){
                this.form.getJcbJabatan().setSelectedIndex(i);
            }
        }
        
    }
    
    /**
     * 
     */
    private void setJabatan(){
        this.form.getJcbJabatan().removeAllItems();
        analisasistem.interfaces.JabatanInterface data = new analisasistem.dao.JabatanDAO();
        List<Jabatan> list = data.selectAll();
        this.modelJabatan = new analisasistem.model.tableModel.JabatanModel(list);
        for(int i=0;i<this.modelJabatan.getRowCount();i++){
            this.form.getJcbJabatan().addItem(this.modelJabatan.getValueAt(i, 1));
        }
    }
    
    /**
     * 
     */
    public void action(){
        if(this.form.getAction() == 1){
            this.insert();
        }else if(this.form.getAction() == 2){
            this.update();
        }
    }
}
