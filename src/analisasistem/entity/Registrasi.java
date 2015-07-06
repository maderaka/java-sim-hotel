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
public class Registrasi {
    private Users user = new Users();
    private String idRegistrasi;
    private Reservasi reservasi = new Reservasi();
    private TravelAgent agent = new TravelAgent();
    private Tamu tamu = new Tamu();
    private Date date;
    private int pax;
    private Date checkIn;
    private Date checkOut;
    private String arrivalTime;
    private String departureTime;
    private String arrivalNo;
    private String departureNo;
    private int arrival_transfer;
    private int departure_transfer;
    private String memo;

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
     * @return the idRegistrasi
     */
    public String getIdRegistrasi() {
        return idRegistrasi;
    }

    /**
     * @param idRegistrasi the idRegistrasi to set
     */
    public void setIdRegistrasi(String idRegistrasi) {
        this.idRegistrasi = idRegistrasi;
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
     * @return the agent
     */
    public TravelAgent getAgent() {
        return agent;
    }

    /**
     * @param agent the agent to set
     */
    public void setAgent(TravelAgent agent) {
        this.agent = agent;
    }

    /**
     * @return the tamu
     */
    public Tamu getTamu() {
        return tamu;
    }

    /**
     * @param tamu the tamu to set
     */
    public void setTamu(Tamu tamu) {
        this.tamu = tamu;
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
     * @return the pax
     */
    public int getPax() {
        return pax;
    }

    /**
     * @param pax the pax to set
     */
    public void setPax(int pax) {
        this.pax = pax;
    }

    /**
     * @return the checkIn
     */
    public Date getCheckIn() {
        return checkIn;
    }

    /**
     * @param checkIn the checkIn to set
     */
    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    /**
     * @return the checkOut
     */
    public Date getCheckOut() {
        return checkOut;
    }

    /**
     * @param checkOut the checkOut to set
     */
    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    /**
     * @return the arrivalTime
     */
    public String getArrivalTime() {
        return arrivalTime;
    }

    /**
     * @param arrivalTime the arrivalTime to set
     */
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    /**
     * @return the departureTime
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * @param departureTime the departureTime to set
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    /**
     * @return the arrivalNo
     */
    public String getArrivalNo() {
        return arrivalNo;
    }

    /**
     * @param arrivalNo the arrivalNo to set
     */
    public void setArrivalNo(String arrivalNo) {
        this.arrivalNo = arrivalNo;
    }

    /**
     * @return the departureNo
     */
    public String getDepartureNo() {
        return departureNo;
    }

    /**
     * @param departureNo the departureNo to set
     */
    public void setDepartureNo(String departureNo) {
        this.departureNo = departureNo;
    }

    /**
     * @return the arrival_transfer
     */
    public int getArrival_transfer() {
        return arrival_transfer;
    }

    /**
     * @param arrival_transfer the arrival_transfer to set
     */
    public void setArrival_transfer(int arrival_transfer) {
        this.arrival_transfer = arrival_transfer;
    }

    /**
     * @return the departure_transfer
     */
    public int getDeparture_transfer() {
        return departure_transfer;
    }

    /**
     * @param departure_transfer the departure_transfer to set
     */
    public void setDeparture_transfer(int departure_transfer) {
        this.departure_transfer = departure_transfer;
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
}
