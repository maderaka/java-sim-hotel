/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package analisasistem.controller;
import analisasistem.entity.LaundryService;
import analisasistem.entity.TransaksiLaundry;
import analisasistem.entity.TransaksiLaundryDetail;
import analisasistem.library.OtomatisasiId;
import analisasistem.model.tableModel.TransaksiLaundryDetailModel;
import analisasistem.view.laundry.FormTransaksiLaundry;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Raka New
 * 
 */

public class TransaksiLaundryController {
    private FormTransaksiLaundry form;
    private analisasistem.interfaces.LaundryServiceInterface dataLaundry = new analisasistem.dao.LaundryServiceDAO();
    private analisasistem.model.tableModel.LaundryServiceModel model;   
    private analisasistem.model.tableModel.TransaksiLaundryDetailModel modelTransaksiDetail;
    private TransaksiLaundry transaksi = new TransaksiLaundry();
    private String user = "US-1306001";
    private int grandTotal = 0;
    private String curencyStr = "Rp. ";
    private List<TransaksiLaundryDetail> listTransaksiLaundryDetail = new ArrayList<TransaksiLaundryDetail>();
    public TransaksiLaundryController(FormTransaksiLaundry form){
        this.form = form;
        this.defaultConfig();
    }
    
    private void setGrandTotalText(){
        this.form.getLabelTotalTransaksi().setText(this.curencyStr+this.grandTotal);
    }
    private void defaultConfig(){
        this.isiTable(); // use to fill laundry data to JTable
        OtomatisasiId oto = new OtomatisasiId(); // initialize class library OtomatisasiId, use to create id laundry transaction
        this.form.getTxNoTransaksi().setText(oto.forTransaksiLaundry());
        this.generateTableDetail();
        this.setStyleModel(); // use for styling table Laundry
        this.grandTotal = this.generateGrandTotal(); // use for create grand total laundry transanction
        this.setGrandTotalText(); // use for setting grand total text
    }
    
    private void generateTableDetail(){
        this.modelTransaksiDetail = new analisasistem.model.tableModel.TransaksiLaundryDetailModel(this.listTransaksiLaundryDetail);
        this.form.getTbTransaksiLaundry().setModel(this.modelTransaksiDetail);
    }
    
    private void setStyleModel(){
        analisasistem.library.TableStyle style = new analisasistem.library.TableStyle();
        style.setRowHeight(25);
        style.setSize(this.form.getTbLaundry(), new int[]{50,80,80}, true);
    }
    
    private void isiTable(){
        List<LaundryService> list = new ArrayList<LaundryService>();
        list = this.dataLaundry.getAll();
        model = new analisasistem.model.tableModel.LaundryServiceModel(list);
        this.form.getTbLaundry().setModel(model);
    }
    
    private boolean insert(TransaksiLaundry transaksi){
        analisasistem.interfaces.TransaksiLaundryInterface dataTransaksi = new analisasistem.dao.TransaksiLaundryDAO();
        if(dataTransaksi.insert(transaksi)){
            return true;
        }else{
            return false;
        }
    }
    
    public void chooseRooms(){
        analisasistem.view.rooms.RoomsChooser roomChooser = new analisasistem.view.rooms.RoomsChooser(null, true);
        roomChooser.setTextField(this.form.getTxNoKamar());
        roomChooser.setIdKamar(this.form.getIdKamar());
        roomChooser.setSingelChoose(1);
        roomChooser.starter();
        roomChooser.setEnabled(true);
        roomChooser.setVisible(true);
    }
    
    private boolean update(TransaksiLaundry transaksi){
        return false;
    }
    
    private TransaksiLaundry getValueRegistrasi(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.transaksi.setNoTransaksiLaundry(this.form.getTxNoTransaksi().getText());
        this.transaksi.getUser().setIdUser(this.user);
        this.transaksi.getRegistrasi().setIdRegistrasi(this.form.getTxRegNo().getText());
        this.transaksi.setTotalTransaksi(Integer.parseInt(this.form.getLabelTotalTransaksi().getText().substring(4)));
        this.transaksi.setTanggalTransaksiLaundry(new Date());
        this.transaksi.setTanggalSelesai(this.form.getJcbTanggalSelesai().getDate());
        this.transaksi.setGuestName(this.form.getTxGuestName().getText());
        this.transaksi.getRooms().setId(this.form.getTxNoKamar().getText());
        return this.transaksi;
    }
    private boolean insertTransaksiLaundry(TransaksiLaundry transaksi){
        analisasistem.interfaces.TransaksiLaundryDetailInterface dataTransaksiDetail = new analisasistem.dao.TransaksiLaundryDetailDAO();
        for(int i=0;i<this.listTransaksiLaundryDetail.size();i++){
            TransaksiLaundryDetail detail = new TransaksiLaundryDetail();
            detail.getUser().setIdUser(transaksi.getUser().getIdUser());
            detail.getRegistrasi().setIdRegistrasi(transaksi.getRegistrasi().getIdRegistrasi());
            detail.getTransaksiLaundry().setNoTransaksiLaundry(transaksi.getNoTransaksiLaundry());
            detail.getLaundry().setIdBarang(this.listTransaksiLaundryDetail.get(i).getLaundry().getIdBarang());
            detail.setQtyTransaksi(this.listTransaksiLaundryDetail.get(i).getQtyTransaksi());
            detail.setSubtotalTransaksi(this.listTransaksiLaundryDetail.get(i).getSubtotalTransaksi());
            if(dataTransaksiDetail.insert(detail)){
                System.out.println("BErhasil insert transaksi laundry detail");
            }else{
                System.out.println("Gagagl insert transaksi laundry detail");
            }
        }
        return false;
    }
    public void action(){
        if(this.form.getAction() == 1){
            TransaksiLaundry t = this.getValueRegistrasi();
            if(this.insert(t)){
                JOptionPane.showMessageDialog(null,"Well done! Data Transaksi Laundry berhasil di input");
                this.insertTransaksiLaundry(t);
            }
        }else if(this.form.getAction() == 2){
            if(this.update(this.getValueRegistrasi())){
            }
        }
    }
    
    public void addLaundry(){
        int row = this.form.getTbLaundry().getSelectedRow();
        LaundryService laundry = new LaundryService();
        String idBarang = (String) this.form.getTbLaundry().getValueAt(row, 0);
        System.out.println(idBarang);
        laundry = this.dataLaundry.getById(idBarang);
        TransaksiLaundryDetail detail = new TransaksiLaundryDetail();
        detail = this.setTransaksiLaundryDetailData(laundry);
        for(int i=0;i<this.listTransaksiLaundryDetail.size();i++){
            if(this.listTransaksiLaundryDetail.get(i).getLaundry().getIdBarang().equals(detail.getLaundry().getIdBarang())){
                detail.setQtyTransaksi(this.listTransaksiLaundryDetail.get(i).getQtyTransaksi()+1);
                int subtotal = this.listTransaksiLaundryDetail.get(i).getSubtotalTransaksi()+this.listTransaksiLaundryDetail.get(i).getLaundry().getHarga();
                detail.setSubtotalTransaksi(subtotal);
                this.listTransaksiLaundryDetail.set(i, detail);
                this.listTransaksiLaundryDetail.remove(i);
            }
        }
        this.listTransaksiLaundryDetail.add(detail);
        this.grandTotal = this.generateGrandTotal();
        this.setGrandTotalText();
        this.modelTransaksiDetail = new TransaksiLaundryDetailModel(this.listTransaksiLaundryDetail);
        this.form.getTbTransaksiLaundry().setModel(this.modelTransaksiDetail);
    }
    
    private int generateGrandTotal(){
        int total = 0;
        for(int i = 0;i<this.listTransaksiLaundryDetail.size();i++){
            total += this.listTransaksiLaundryDetail.get(i).getSubtotalTransaksi();
        }
        return total;
    }
    private TransaksiLaundryDetail setTransaksiLaundryDetailData(LaundryService laundry){
        TransaksiLaundryDetail detail = new TransaksiLaundryDetail();
        int qty;
        detail.getLaundry().setIdBarang(laundry.getIdBarang());
        detail.getLaundry().setNamaBarang(laundry.getNamaBarang());
        detail.getLaundry().setHarga(laundry.getHarga());
        detail.setQtyTransaksi(1);
        detail.setSubtotalTransaksi(laundry.getHarga()*1);
        return detail;
    }
    
}
