/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
/**
 *
 * @author User
 */
public class Conexion {
    static String url="jdbc:mysql://localhost:3306/banco";
    static String user = "root";
    static String password = "";
    
        public static Connection contectar(){
        Connection con = null;
        try {
            con = DriverManager.getConnection(url,user,password);
            System.out.println("Conexión exitosa");
        } catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
