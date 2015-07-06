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

public class Users {
    
    private String idUser;
    private String username;
    private String passWord;   
    private Date dateCreate;
    private int status;
    private Pegawai pegawai = new Pegawai();
    private String aksesMenu;
    
    
    public Users(){
        
    }
    
    public Users(String idUsers,String username,String password, Date dateCreate,int status){
        this.idUser = idUsers;
        this.username   = username;
        this.passWord   = password;
        this.dateCreate = dateCreate;
        this.status     = status;
    }

    /**
     * @return the idUser
     */
    public String getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the passWord
     */
    public String getPassWord() {
        return passWord;
    }

    /**
     * @param passWord the passWord to set
     */
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    /**
     * @return the dateCreate
     */
    public Date getDateCreate() {
        return dateCreate;
    }

    /**
     * @param dateCreate the dateCreate to set
     */
    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * @return the pegawai
     */
    public Pegawai getPegawai() {
        return pegawai;
    }

    /**
     * @param pegawai the pegawai to set
     */
    public void setPegawai(Pegawai pegawai) {
        this.pegawai = pegawai;
    }

    /**
     * @return the aksesMenu
     */
    public String getAksesMenu() {
        return aksesMenu;
    }

    /**
     * @param aksesMenu the aksesMenu to set
     */
    public void setAksesMenu(String aksesMenu) {
        this.aksesMenu = aksesMenu;
    }
}
