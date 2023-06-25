/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiket.view;


//import com.sun.jdi.connect.spi.Connection;
import java.sql.*;

/**
 *
 * @author ALEXIS
 */
public class MysqlConnection {
    public static Connection Connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/tiket", "root", "");
            return connection;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
