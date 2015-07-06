/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package analisasistem.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Raka New
 */
public class Database {
    private static Connection conn;
    private Statement stat;
    
    public static Connection getConn(){
        if(conn == null){
           MysqlDataSource data = new MysqlDataSource();
           data.setDatabaseName("adsi");
           data.setUser("root");
           data.setPassword("");
           try{
               conn = data.getConnection();
           }catch(SQLException e){
               System.out.println("Terdapat error "+e.getMessage());
           }
        }
        return conn;
    }
   
}
