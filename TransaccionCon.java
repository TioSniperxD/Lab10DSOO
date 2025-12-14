/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class TransaccionCon {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    
    public boolean RegistrarTransaccion(Transaccion ts){
        String sql = "INSERT INTO transaccion (id_cliente, id_cuenta,id_empleado, monto, tipo, fecha) VALUES (? ,? , ?, ?, ?, ?)";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ts.getId_cuenta());
            ps.setDouble(2, 0);
            ps.setString(3, ts.getId_cliente());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            }catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
    
}
