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
 * @author User
 */
public class CuentaCon {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCuenta(CuentaCliente cc){
        String sql = "INSERT INTO cuenta VALUES (?,?,?)";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cc.getId_cuenta());
            ps.setDouble(2, 0);
            ps.setString(3, cc.getId_cliente());
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
    
    public boolean Deposito(CuentaCliente cc) {
        String sql = "UPDATE Cuenta SET saldo = saldo + ? WHERE id_cuenta = ? AND id_cliente = ?";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, cc.getSaldo());
            ps.setString(2, cc.getId_cuenta());
            ps.setString(3, cc.getId_cliente());
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
    
    public boolean Retiro(CuentaCliente cc) {
        String sql = "UPDATE Cuenta SET saldo = saldo - ? WHERE id_cuenta = ? AND id_cliente = ?";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, cc.getSaldo());
            ps.setString(2, cc.getId_cuenta());
            ps.setString(3, cc.getId_cliente());
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
    
    public List MostrarSaldo(Cuenta ct) {
        List<Cuenta> mostrar = new ArrayList();
        String sql = "SELECT * FROM cuenta WHERE id_cuenta = ?";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, ct.getIdCuenta());
            rs = ps.executeQuery();
            while (rs.next()) {
                Cuenta saldo = new Cuenta();
                saldo.setIdCuenta(rs.getString("id_cuenta"));
                saldo.setSaldo(rs.getDouble("saldo"));
                mostrar.add(saldo);
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
