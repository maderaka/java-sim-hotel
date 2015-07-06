/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.entity;

/**
 *
 * @author Raka New
 */
public class TransaksiLaundryDetail {
    private Users user = new Users();
    private Registrasi registrasi = new Registrasi();
    private TransaksiLaundry transaksiLaundry = new TransaksiLaundry();
    private LaundryService laundry = new LaundryService();
    private String idDetailTransaksi;
    private int qtyTransaksi;
    private int subtotalTransaksi;

    /**
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * @return the registrasi
     */
    public Registrasi getRegistrasi() {
        return registrasi;
    }

    /**
     * @param registrasi the registrasi to set
     */
    public void setRegistrasi(Registrasi registrasi) {
        this.registrasi = registrasi;
    }

    /**
     * @return the transaksiLaundry
     */
    public TransaksiLaundry getTransaksiLaundry() {
        return transaksiLaundry;
    }

    /**
     * @param transaksiLaundry the transaksiLaundry to set
     */
    public void setTransaksiLaundry(TransaksiLaundry transaksiLaundry) {
        this.transaksiLaundry = transaksiLaundry;
    }

    /**
     * @return the laundry
     */
    public LaundryService getLaundry() {
        return laundry;
    }

    /**
     * @param laundry the laundry to set
     */
    public void setLaundry(LaundryService laundry) {
        this.laundry = laundry;
    }

    /**
     * @return the idDetailTransaksi
     */
    public String getIdDetailTransaksi() {
        return idDetailTransaksi;
    }

    /**
     * @param idDetailTransaksi the idDetailTransaksi to set
     */
    public void setIdDetailTransaksi(String idDetailTransaksi) {
        this.idDetailTransaksi = idDetailTransaksi;
    }

    /**
     * @return the qtyTransaksi
     */
    public int getQtyTransaksi() {
        return qtyTransaksi;
    }

    /**
     * @param qtyTransaksi the qtyTransaksi to set
     */
    public void setQtyTransaksi(int qtyTransaksi) {
        this.qtyTransaksi = qtyTransaksi;
    }

    /**
     * @return the subtotalTransaksi
     */
    public int getSubtotalTransaksi() {
        return subtotalTransaksi;
    }

    /**
     * @param subtotalTransaksi the subtotalTransaksi to set
     */
    public void setSubtotalTransaksi(int subtotalTransaksi) {
        this.subtotalTransaksi = subtotalTransaksi;
    }
}
