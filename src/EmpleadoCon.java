
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class EmpleadoCon {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarEmpleado(Empleado emp){
        String sql = "Insert into empleado values (?,?,?,?)";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getId());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getClave());
            ps.setString(4, emp.getDireccion());
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
    public boolean ModificarDatos(Empleado el) {
        String sql = "UPDATE empleado set nombre = ?, contrasena = ?, direccion = ? WHERE id_empleado = ?";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, el.getNombre());
            ps.setString(2, el.getClave());
            ps.setString(3, el.getDireccion());
            ps.setString(4, el.getId());
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
    
    public boolean EliminarEmpleado(String id_empleado) {
        String sql = "delete from empleado where id_empleado = ?";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, id_empleado);
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
    
    public List ListarClientes() {
        List<Empleado> listaEp = new ArrayList();
        String sql = "SELECT * FROM empleado";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Empleado emp = new Empleado();
                emp.setId(rs.getString("id_empleado"));
                emp.setNombre(rs.getString("nombre"));
                emp.setDireccion(rs.getString("direccion"));
                listaEp.add(emp);
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
        return listaEp;
    }
    public List MostrarDatos(Empleado em) {
        List<Empleado> mostrar = new ArrayList();
        String sql = "SELECT * FROM empleado WHERE id_empleado = ?";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, em.getId());
            rs = ps.executeQuery();
            while (rs.next()) {
                em.setId(rs.getString("id_empleado"));
                em.setNombre(rs.getString("nombre"));
                em.setDireccion(rs.getString("direccion"));
                mostrar.add(em);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return mostrar;
    }
}
