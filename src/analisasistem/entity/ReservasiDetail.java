/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.entity;

/**
 *
 * @author Raka New
 */
public class ReservasiDetail {
    private int idDetailReservasi;
    
    private Reservasi reservasi;
    
    private Rooms room;

    public ReservasiDetail(){
        this.reservasi = new Reservasi();
        this.room = new Rooms();
    }   

    /**
     * @return the idDetailReservasi
     */
    public int getIdDetailReservasi() {
        return idDetailReservasi;
    }

    /**
     * @param idDetailReservasi the idDetailReservasi to set
     */
    public void setIdDetailReservasi(int idDetailReservasi) {
        this.idDetailReservasi = idDetailReservasi;
    }

    /**
     * @return the reservasi
     */
    public Reservasi getReservasi() {
        return reservasi;
    }

    /**
     * @param reservasi the reservasi to set
     */
    public void setReservasi(Reservasi reservasi) {
        this.reservasi = reservasi;
    }

    /**
     * @return the room
     */
    public Rooms getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(Rooms room) {
        this.room = room;
    }
}
