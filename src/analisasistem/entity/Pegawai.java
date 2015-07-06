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
public class Pegawai {
    private String id;
    private Jabatan jabatan;
    private String nama;
    private int jenisKelamin;
    private String TempatLahir;
    private Date tanggalLahir;
    private String alamat;
    private String kota;
    private String provinsi;
    private String negara;
    private String telp; 
    private String email;
    
    public Pegawai(){
        this.jabatan = new Jabatan();
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the jabatan
     */
    public Jabatan getJabatan() {
        return jabatan;
    }

    /**
     * @param jabatan the jabatan to set
     */
    public void setJabatan(Jabatan jabatan) {
        this.jabatan = jabatan;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the jenisKelamin
     */
    public int getJenisKelamin() {
        return jenisKelamin;
    }

    /**
     * @param jenisKelamin the jenisKelamin to set
     */
    public void setJenisKelamin(int jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    /**
     * @return the TempatLahir
     */
    public String getTempatLahir() {
        return TempatLahir;
    }

    /**
     * @param TempatLahir the TempatLahir to set
     */
    public void setTempatLahir(String TempatLahir) {
        this.TempatLahir = TempatLahir;
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
     * @return the kota
     */
    public String getKota() {
        return kota;
    }

    /**
     * @param kota the kota to set
     */
    public void setKota(String kota) {
        this.kota = kota;
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

    /**
     * @return the telp
     */
    public String getTelp() {
        return telp;
    }

    /**
     * @param telp the telp to set
     */
    public void setTelp(String telp) {
        this.telp = telp;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
