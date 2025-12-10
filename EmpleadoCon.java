
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
    
    public boolean RegistrarEmpleado(Empleado emp){
        String sql = "Insert into empleado values (?,?,?,?)";
        try {
            con = cn.contectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, emp.getId());
            ps.setString(2, emp.getNombre());
            ps.setString(3, emp.getDireccion());
            ps.setString(4, emp.getClave());
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
}
