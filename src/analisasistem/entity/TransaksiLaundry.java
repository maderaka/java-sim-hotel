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
public class TransaksiLaundry {
    private String guestName;
    private Registrasi registrasi = new Registrasi();
    private Users user = new Users();
    private String noTransaksiLaundry;
    private int totalTransaksi;
    private Date tanggalTransaksiLaundry;
    private Date tanggalSelesai;
    private Rooms rooms = new Rooms();

    /**
     * @return the guestName
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * @param guestName the guestName to set
     */
    public void setGuestName(String guestName) {
        this.guestName = guestName;
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
     * @return the noTransaksiLaundry
     */
    public String getNoTransaksiLaundry() {
        return noTransaksiLaundry;
    }

    /**
     * @param noTransaksiLaundry the noTransaksiLaundry to set
     */
    public void setNoTransaksiLaundry(String noTransaksiLaundry) {
        this.noTransaksiLaundry = noTransaksiLaundry;
    }

    /**
     * @return the totalTransaksi
     */
    public int getTotalTransaksi() {
        return totalTransaksi;
    }

    /**
     * @param totalTransaksi the totalTransaksi to set
     */
    public void setTotalTransaksi(int totalTransaksi) {
        this.totalTransaksi = totalTransaksi;
    }

    /**
     * @return the tanggalTransaksiLaundry
     */
    public Date getTanggalTransaksiLaundry() {
        return tanggalTransaksiLaundry;
    }

    /**
     * @param tanggalTransaksiLaundry the tanggalTransaksiLaundry to set
     */
    public void setTanggalTransaksiLaundry(Date tanggalTransaksiLaundry) {
        this.tanggalTransaksiLaundry = tanggalTransaksiLaundry;
    }

    /**
     * @return the tanggalSelesai
     */
    public Date getTanggalSelesai() {
        return tanggalSelesai;
    }

    /**
     * @param tanggalSelesai the tanggalSelesai to set
     */
    public void setTanggalSelesai(Date tanggalSelesai) {
        this.tanggalSelesai = tanggalSelesai;
    }

    /**
     * @return the rooms
     */
    public Rooms getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }
}
