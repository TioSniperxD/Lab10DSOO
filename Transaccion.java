import java.util.Date;

public class Transaccion {
    protected String idCliente;
    protected String idCuenta;
    protected double monto;
    protected String tipo;
    protected String fecha;
    protected Cuenta cuenta;

    //CONSTRUCTOR CON EMPLEADO
    public Transaccion(String idCliente, String idCuenta, double monto, String tipo) {
        this.idCliente = idCliente;
        this.idCuenta = idCuenta;
        this.monto = monto;
        this.tipo = tipo;
        this.fecha = generarFecha();
        this.cuenta = null;
    }

    public Transaccion() {
    }

    public Transaccion(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Transaccion(String idCliente, String idCuenta) {
        this.idCliente = idCliente;
        this.idCuenta = idCuenta;
    }
    
    //GENERA LA FECHA (Apr 17 12:34:56)
    private String generarFecha() {
        return new Date().toString().substring(4, 19);
    }

    //VALIDAR DATOS
    public boolean datosValidos() {
        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return false;
        }
        if (idCliente == null || idCliente.trim().isEmpty()) {
            System.out.println("ID del cliente vacío.");
            return false;
        }
        if (idCuenta == null || idCuenta.trim().isEmpty()) {
            System.out.println("ID de la cuenta vacío.");
            return false;
        }
        if (tipo == null || tipo.trim().isEmpty()) {
            System.out.println("Tipo inválido.");
            return false;
        }
        return true;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return tipo + " | Cliente: " + idCliente +
               " | Cuenta: " + idCuenta +
               " | Monto: " + monto +
               " | Fecha: " + fecha;
    }
}