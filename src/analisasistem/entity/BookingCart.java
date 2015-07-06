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
public class BookingCart {
    private analisasistem.entity.Rooms rooms = new analisasistem.entity.Rooms();
    private Date checkin;
    private Date checkout;

    /**
     * @return the checkin
     */
    public Date getCheckin() {
        return checkin;
    }

    /**
     * @param checkin the checkin to set
     */
    public void setCheckin(Date checkin) {
        this.checkin = checkin;
    }

    /**
     * @return the checkout
     */
    public Date getCheckout() {
        return checkout;
    }

    /**
     * @param checkout the checkout to set
     */
    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    /**
     * @return the rooms
     */
    public analisasistem.entity.Rooms getRooms() {
        return rooms;
    }

    /**
     * @param rooms the rooms to set
     */
    public void setRooms(analisasistem.entity.Rooms rooms) {
        this.rooms = rooms;
    }
}
