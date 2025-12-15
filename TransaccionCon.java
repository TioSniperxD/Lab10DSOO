/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author user
 */
public class TransaccionCon {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarTransaccion(Transaccion ts){
        String sql = "INSERT INTO transaccion (id_cliente, id_cuenta, monto, tipo, fecha) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ts.getIdCliente());
            ps.setString(2, ts.getIdCuenta());
            ps.setDouble(3, ts.getMonto());
            ps.setString(4, ts.getTipo());
            ps.setString(5, ts.getFecha());

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
    
    public List MostrarDatos(Transaccion tc) {
        List<Transaccion> mostrar = new ArrayList();
        String sql = "SELECT * FROM transaccion WHERE id_cliente = ? AND id_cuenta = ?";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tc.getIdCliente());
            ps.setString(2, tc.getIdCuenta());
            rs = ps.executeQuery();
            while (rs.next()) {
                Transaccion nuevo = new Transaccion();
                nuevo.setIdCliente(rs.getString("id_cliente"));
                nuevo.setIdCuenta(rs.getString("id_cuenta"));
                nuevo.setMonto(rs.getDouble("monto"));
                nuevo.setTipo(rs.getString("tipo"));
                nuevo.setFecha(rs.getString("fecha"));
                mostrar.add(nuevo);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return mostrar;
    }
    
    public List MostrarHistorial(Transaccion tc) {
        List<Transaccion> mostrar = new ArrayList();
        String sql = "SELECT * FROM transaccion WHERE id_cuenta = ?";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, tc.getIdCuenta());
            rs = ps.executeQuery();
            while (rs.next()) {
                Transaccion nuevo = new Transaccion();
                nuevo.setIdCuenta(rs.getString("id_cuenta"));
                nuevo.setMonto(rs.getDouble("monto"));
                nuevo.setTipo(rs.getString("tipo"));
                nuevo.setFecha(rs.getString("fecha"));
                mostrar.add(nuevo);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return mostrar;
    }
}
