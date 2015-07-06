/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.entity;

/**
 *
 * @author Raka New
 */
public class LaundryService {
    private String idBarang;
    private String namaBarang;
    private String descBarang;
    private int harga;

    /**
     * @return the idBarang
     */
    public String getIdBarang() {
        return idBarang;
    }

    /**
     * @param idBarang the idBarang to set
     */
    public void setIdBarang(String idBarang) {
        this.idBarang = idBarang;
    }

    /**
     * @return the namaBarang
     */
    public String getNamaBarang() {
        return namaBarang;
    }

    /**
     * @param namaBarang the namaBarang to set
     */
    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    /**
     * @return the descBarang
     */
    public String getDescBarang() {
        return descBarang;
    }

    /**
     * @param descBarang the descBarang to set
     */
    public void setDescBarang(String descBarang) {
        this.descBarang = descBarang;
    }

    /**
     * @return the harga
     */
    public int getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(int harga) {
        this.harga = harga;
    }
}
