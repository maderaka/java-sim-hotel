/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.entity;

import java.util.Date;

/**
 *
 * @author Raka New
 */
public class Tamu {
    private String idTamu;
    private String noIdentitas;
    private TipeIdentitas tipeIdentitas = new TipeIdentitas();
    private String fullName;
    private int jk;
    private String tempatLahir;
    private Date tanggalLahir;
    private String phone;
    private String alamat;
    private String provinsi;
    private String negara;

    /**
     * @return the idTamu
     */
    public String getIdTamu() {
        return idTamu;
    }

    /**
     * @param idTamu the idTamu to set
     */
    public void setIdTamu(String idTamu) {
        this.idTamu = idTamu;
    }

    /**
     * @return the noIdentitas
     */
    public String getNoIdentitas() {
        return noIdentitas;
    }

    /**
     * @param noIdentitas the noIdentitas to set
     */
    public void setNoIdentitas(String noIdentitas) {
        this.noIdentitas = noIdentitas;
    }

    /**
     * @return the tipeIdentitas
     */
    public TipeIdentitas getTipeIdentitas() {
        return tipeIdentitas;
    }

    /**
     * @param tipeIdentitas the tipeIdentitas to set
     */
    public void setTipeIdentitas(TipeIdentitas tipeIdentitas) {
        this.tipeIdentitas = tipeIdentitas;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the jk
     */
    public int getJk() {
        return jk;
    }

    /**
     * @param jk the jk to set
     */
    public void setJk(int jk) {
        this.jk = jk;
    }

    /**
     * @return the tempatLahir
     */
    public String getTempatLahir() {
        return tempatLahir;
    }

    /**
     * @param tempatLahir the tempatLahir to set
     */
    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }

    /**
     * @return the tanggalLahir
     */
    public Date getTanggalLahir() {
        return tanggalLahir;
    }

    /**
     * @param tanggalLahir the tanggalLahir to set
     */
    public void setTanggalLahir(Date tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the provinsi
     */
    public String getProvinsi() {
        return provinsi;
    }

    /**
     * @param provinsi the provinsi to set
     */
    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    /**
     * @return the negara
     */
    public String getNegara() {
        return negara;
    }

    /**
     * @param negara the negara to set
     */
    public void setNegara(String negara) {
        this.negara = negara;
    }
    
}
