/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class CuentaCliente {
    private String id_cliente;
    private String id_cuenta;
    private double saldo;

    public CuentaCliente() {
    }

    public CuentaCliente(String id_cuenta, double saldo) {
        this.id_cuenta = id_cuenta;
        this.saldo = saldo;
    }

    public CuentaCliente(String id_cliente, String id_cuenta) {
        this.id_cliente = id_cliente;
        this.id_cuenta = id_cuenta;
    }

    public CuentaCliente(String id_cliente, String id_cuenta, double saldo) {
        this.id_cliente = id_cliente;
        this.id_cuenta = id_cuenta;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(String id_cuenta) {
        this.id_cuenta = id_cuenta;
    }
    
    
}
