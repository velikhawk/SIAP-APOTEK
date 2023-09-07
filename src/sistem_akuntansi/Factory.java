/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem_akuntansi;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author arochman aryanta
 */
public class Factory {
    private static Connection connection;  
    
    static{
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            String url= "jdbc:mysql://localhost:3306/apotek_mulyo";
            String user= "root";
            String password= "";
            connection= DriverManager.getConnection(url, user, password);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
    public static Connection getConnection(){
         return connection;
    }
}
