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
public class Reservasi {
    private Users users = new Users();
    private String idReservasi;
    private TravelAgent agent = new TravelAgent();
    private Users perUsers = new Users();
    
    private String idPerson;
    private String namaPerson;
    private String phone;
    private String company;
    
    private Date date_reservasi;
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
     * @return the users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * @param users the users to set
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * @return the idReservasi
     */
    public String getIdReservasi() {
        return idReservasi;
    }

    /**
     * @param idReservasi the idReservasi to set
     */
    public void setIdReservasi(String idReservasi) {
        this.idReservasi = idReservasi;
    }

    /**
     * @return the perUsers
     */
    public Users getPerUsers() {
        return perUsers;
    }

    /**
     * @param perUsers the perUsers to set
     */
    public void setPerUsers(Users perUsers) {
        this.perUsers = perUsers;
    }

    /**
     * @return the person
     */

    /**
     * @return the date_reservasi
     */
    public Date getDate_reservasi() {
        return date_reservasi;
    }

    /**
     * @param date_reservasi the date_reservasi to set
     */
    public void setDate_reservasi(Date date_reservasi) {
        this.date_reservasi = date_reservasi;
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
     * @return the idPerson
     */
    public String getIdPerson() {
        return idPerson;
    }

    /**
     * @param idPerson the idPerson to set
     */
    public void setIdPerson(String idPerson) {
        this.idPerson = idPerson;
    }

    /**
     * @return the namaPerson
     */
    public String getNamaPerson() {
        return namaPerson;
    }

    /**
     * @param namaPerson the namaPerson to set
     */
    public void setNamaPerson(String namaPerson) {
        this.namaPerson = namaPerson;
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
     * @return the company
     */
    public String getCompany() {
        return company;
    }

    /**
     * @param company the company to set
     */
    public void setCompany(String company) {
        this.company = company;
    }
}