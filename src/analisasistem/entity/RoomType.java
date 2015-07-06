/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.entity;

import java.io.Serializable;

/**
 *
 * @author RakaMSM
 */

public class RoomType implements Serializable {
    private String id;
    private String name;
    private String keterangan;
    private int jumlah_kasur;
    private int cost;

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    /**
     * @return the jumlah_kasur
     */
    public int getJumlah_kasur() {
        return jumlah_kasur;
    }

    /**
     * @param jumlah_kasur the jumlah_kasur to set
     */
    public void setJumlah_kasur(int jumlah_kasur) {
        this.jumlah_kasur = jumlah_kasur;
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(int cost) {
        this.cost = cost;
    }
    
    

}
