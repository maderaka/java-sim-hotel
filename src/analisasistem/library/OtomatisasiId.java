/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package analisasistem.library;
import analisasistem.dao.TravelAgentDAO;
import analisasistem.interfaces.TravelAgentInterface;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * OtomatisasiId
 * @author Raka New
 * 
 * Kelas ini digunakan khusus untuk membuat berbagai id, untuk berbagai table di sistem ini
 * Adapun id yang berhasil dibuat di kelas ini antara lain:
 * 
 * TravelAgent,
 */
public class OtomatisasiId {
    private String id;
    private int maxId;
    
    /**
     * The constructor
     */
    public OtomatisasiId(){
        this.id = null;
        this.maxId = 0;
    }
    
    public String forRoomType(){
        analisasistem.interfaces.RoomTypeInterface roomTypeData = new analisasistem.dao.RoomTypeDAO();
        if(roomTypeData.getMaxId() != null){
            this.maxId = Integer.parseInt(roomTypeData.getMaxId().substring(2));
            this.maxId++;
            return ("RT"+String.format("%02d%n", this.maxId));
        }else{
            return "RT01";
        }
    }
    
    public String forRooms(){
        analisasistem.interfaces.RoomsInterface roomsData = new analisasistem.dao.RoomsDAO();
        if(roomsData.getMaxId() != null){
            this.maxId = Integer.parseInt(roomsData.getMaxId().substring(1));
            this.maxId++;
            return ("R"+String.format("%03d%n", this.maxId));
        }else{
            return "R001";
        }
    }
    /**
     * Kelas ini digunakan untuk membuat id travel agent
     * @return String
     */
    public String forTravelAgent(){
        TravelAgentInterface data = new TravelAgentDAO();
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yy");
        if(data.getMax() != null){
            this.maxId = Integer.parseInt(data.getMax().substring(4));
            this.maxId++;
            String s1 = String.format("%03d%n", this.maxId);
            this.id = ("AG"+format.format(d)+s1);
        }else{
            this.id = "AG"+format.format(d)+"001";
        }
        
        return this.id;
    }
    
    /**
     * 
     * @return String
     */
    public String forJabatan(){
        analisasistem.interfaces.JabatanInterface data = new analisasistem.dao.JabatanDAO();
        if(data.selectMaxId() != null){
            this.maxId = Integer.parseInt(data.selectMaxId().substring(2));
            this.maxId++;
            String s1 = String.format("%02d%n", this.maxId);
            this.id = "JB"+s1;
        }else{
            this.id = "JB01";
        }
        return this.id;
    }
    
    /**
     * 
     * @return String
     */
    public String forLaundryService(){
        analisasistem.interfaces.LaundryServiceInterface data = new analisasistem.dao.LaundryServiceDAO();
        if(data.selectMax() != null){
            this.maxId = Integer.parseInt(data.selectMax().substring(1));
            this.maxId++;
            String no = String.format("%03d%n", this.maxId);
            this.id = ("L"+no);
        }else{
            this.id = "L"+"001";
        }
        return this.id;
    }
    
    public String forPerson(){
        analisasistem.interfaces.PersonInterface data = new analisasistem.dao.PersonDAO();
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        if(data.getMax() != null){
            this.maxId = Integer.parseInt(data.getMax().substring(9));
            this.maxId++;
            String no = String.format("%03d%n",this.maxId);
            this.id = "P-"+format.format(d)+"-"+no;
        }else{
            this.id = "P-130201-001";
        }
        return this.id;
    }
    
    /**
     * 
     * @return 
     */
    public String forReservasi(){
        analisasistem.interfaces.ReservasiInterface data = new analisasistem.dao.ReservasiDAO();
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        if(data.selectMaxId() != null){
            this.maxId = Integer.parseInt(data.selectMaxId().substring(11));
            this.maxId++;
            String no = String.format("%03d%n", this.maxId);
            this.id = ("RSV-"+format.format(d)+"-"+no);
        }else{
            this.id = ("RSV-"+format.format(d)+"-001");
        }
        return this.id;
    }
    
    /**
     * 
     * @return 
     */
    public String forRegistrasi(){
        analisasistem.interfaces.RegistrasiInterface data = new analisasistem.dao.RegistrasiDAO();
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        if(data.selectMax() != null){
            this.maxId = Integer.parseInt(data.selectMax().substring(11));
            this.maxId++;
            String no = String.format("%03d%n", this.maxId);
            this.id = ("REG-"+format.format(d)+"-"+no);
        }else{
            this.id = ("REG"+format.format(d)+"-001");
        }
        return this.id;
    }
    
    /**
     * 
     * @return 
     */
    public String forTamu(){
        analisasistem.interfaces.TamuInterface data = new analisasistem.dao.TamuDAO();
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        
        if(data.selectMax() != null){
            this.maxId = Integer.parseInt(data.selectMax().substring(9));
            this.maxId++;
            String no = String.format("%03d%n", this.maxId);
            this.id = ("T-"+format.format(d)+"-"+no);
        }else{
            this.id = ("T-"+format.format(d)+"-001");
        }
        return this.id;
    }
    
    public String forUser(){
        analisasistem.interfaces.UsersInterface data = new analisasistem.dao.UsersDAO();
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMM");
        
        if(data.getMax() != null){
            this.maxId = Integer.parseInt(data.getMax().substring(8));
            this.maxId++;
            String no = String.format("%03d%n", this.maxId);
            this.id = ("US-"+format.format(d)+no);
        }else{
            this.id = ("US-"+format.format(d)+"001");
        }
        return this.id;
    }
    
    public String forTransaksiLaundry(){
        analisasistem.interfaces.TransaksiLaundryInterface dataLaundry = new analisasistem.dao.TransaksiLaundryDAO();
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        // LD-130304-001
        if(dataLaundry.getMax() != null){
            this.maxId = Integer.parseInt(dataLaundry.getMax().substring(10));
            this.maxId++;
            String no = String.format("%03d%n", this.maxId);
            this.id = ("LD-"+format.format(d)+"-"+no);
        }else{
            this.id = ("LD-"+format.format(d)+"-001");
        }
        return this.id;
    }
    
    public String forCheckOut(){
        analisasistem.interfaces.CheckOutInterface checkout = new analisasistem.dao.CheckOutDAO();
        Date d = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        if(checkout.selectMax() != null){
            this.maxId = Integer.parseInt(checkout.selectMax().substring(10));
            this.maxId++;
            String no = String.format("%06d%n", this.maxId);
            this.id = ("CO/"+format.format(d)+no);
        }else{
            this.id = ("CO/"+format.format(d)+"000001");
        }
        return this.id;
    }
}