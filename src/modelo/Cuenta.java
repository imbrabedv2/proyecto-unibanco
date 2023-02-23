package modelo;

import java.util.List;

public class Cuenta {	
	private double saldo;
	private Cliente cliente;
	private int numeroCuenta;
    private String contrasena;
    private TipoCuenta tipoCuenta;
    private List<Transaccion> transacciones;
 
	public Cuenta(int numeroCuenta, String contrasena, double saldo, TipoCuenta tipoCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.contrasena = contrasena;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
    }   
	
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getContrasena() {
        return contrasena;
    }

    public double getSaldo() {
        return saldo;
    } 
    
    public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }   
    public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public void setTransacciones(List<Transaccion> transacciones) {
        this.transacciones = transacciones;
    }
}

