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
public class ClienteCon {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean RegistrarCliente(Cliente cl) {
        String sql = "Insert into cliente values (?,?,?,?)";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getId());
            ps.setString(2, cl.getNombre());
            ps.setString(3, cl.getClave());
            ps.setString(4, cl.getDireccion());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public List ListarClientes() {
        List<Cliente> listaCl = new ArrayList();
        String sql = "SELECT * FROM cliente";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente cl = new Cliente();
                cl.setId(rs.getString("id_cliente"));
                cl.setNombre(rs.getString("nombre"));
                cl.setDireccion(rs.getString("direccion"));
                listaCl.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listaCl;
    }

    public List MostrarDatos(Cliente cl) {
        List<Cliente> mostrar = new ArrayList();
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                cl.setId(rs.getString("id_cliente"));
                cl.setNombre(rs.getString("nombre"));
                cl.setDireccion(rs.getString("direccion"));
                mostrar.add(cl);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return mostrar;
    }

    public boolean ModificarDatos(Cliente cl) {
        String sql = "UPDATE cliente set nombre = ?, contrasena = ?, direccion = ? WHERE id_cliente = ?";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cl.getNombre());
            ps.setString(2, cl.getClave());
            ps.setString(3, cl.getDireccion());
            ps.setString(4, cl.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    public boolean EliminarCliente(String id_cliente) {
        String sql = "delete from cliente where id_cliente = ?";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, id_cliente);
            int resultado =ps.executeUpdate();
            if (resultado > 0) {
                return true;
            } else {
                return false; // No borró nada porque no encontró el ID
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }
}
