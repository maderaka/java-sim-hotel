/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.library;
import analisasistem.config.Database;
import static java.awt.Frame.MAXIMIZED_BOTH;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import java.util.*;
import java.io.*;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Raka New
 */
public class Laporan {
    private Connection conn;
    public Laporan(){
        this.conn = Database.getConn(); 
    }
    
    public void forAgentReport(String id_agent){
        String namaFile = "src/analisasistem/report/travel-agent-report.jrxml";
        try{
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("id_agent", id_agent);
            File reportFile = new File(namaFile);
            JasperReport jasper = JasperCompileManager.compileReport(reportFile.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, param, this.conn);
            JasperViewer viewer = new JasperViewer(jasperPrint, false);
            viewer.setExtendedState(MAXIMIZED_BOTH);
            viewer.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data tidak dapat dicetak","Cetak Data",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }
    
    
    public void laporanReservasi(String filename){
        String namaFile = "src/analisasistem/report/"+filename;
        try{
            //JasperViewer viewer = new JasperViewer(jprint, false);
            Map<String, Object> parameters = new HashMap<String, Object>();
            File reportFile = new File(namaFile);
            //JasperReport jreport=(JasperReport)JRLoader.loadObject(reportFile.getPath());
            JasperReport JRpt = JasperCompileManager.compileReport(reportFile.getPath());
            JasperPrint jasperPrint = JasperFillManager.fillReport(JRpt, parameters, this.conn);
            JasperViewer viewer = new JasperViewer(jasperPrint,false);
            viewer.setExtendedState(MAXIMIZED_BOTH);
            viewer.setVisible(true);
            //JasperViewer.viewReport(jasperPrint,false);
            //JasperViewer.setDefaultLookAndFeelDecorated(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Data tidak dapat dicetak","Cetak Data",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }
}
