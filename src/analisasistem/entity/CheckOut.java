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
public class CheckOut {
    private String id;
    private Date date;
    private String memo;
    private Users user = new Users();
    private Registrasi registrasi = new Registrasi();

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
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
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
}
