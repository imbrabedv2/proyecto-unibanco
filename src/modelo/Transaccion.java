package modelo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import exceptions.ValorRequeridoException;
import util.MensajeUtil;

public class Transaccion {
	private Cuenta cuenta;
    private LocalTime hora;
    private DateTimeFormatter fecha;
    private double valor;
    private TipoTransaccion tipoTransaccion;

    public Transaccion(LocalTime localTime, DateTimeFormatter fecha, double valor, TipoTransaccion tipoTransaccion, Cuenta cuenta) {
        this.hora = localTime;
        this.fecha = fecha;
        this.valor = valor;
        this.tipoTransaccion = tipoTransaccion;
        this.cuenta=cuenta;
    }

    public LocalTime getHora() {
        return hora;
    }

    public DateTimeFormatter getFecha() {
        return fecha;
    }

    public double getValor() {
        return valor;
    }

    public TipoTransaccion getTipoTransaccion() {
        return tipoTransaccion;
    }

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
    public EstadoTransaccion verificacionContrasenia(String contrasenaIngresada) {
        if (contrasenaIngresada.equals(cuenta.getContrasena())) {
            return EstadoTransaccion.EXITOSA;
        }
        else {
            return EstadoTransaccion.RECHAZADA;
        }
    }
    
    public void depositar(double saldoDepositar, String contrasenaIngresada) throws ValorRequeridoException {
        try {
            EstadoTransaccion estadoTransaccion = verificacionContrasenia(contrasenaIngresada);
            if (estadoTransaccion != EstadoTransaccion.RECHAZADA) {
                cuenta.setSaldo(cuenta.getSaldo()+saldoDepositar);
            }
        }
        catch (Exception e) {
            MensajeUtil.mensajeAlerta(e.getMessage(), "Error");
        }
    }
    
    public void retirar(double montoRetirar, String contrasenaIngresada) throws Exception {
        if (cuenta.getSaldo()>=montoRetirar) {
            EstadoTransaccion estadoTransaccion = verificacionContrasenia(contrasenaIngresada);
            if (estadoTransaccion != EstadoTransaccion.RECHAZADA) {
                cuenta.setSaldo(cuenta.getSaldo()- montoRetirar);
                MensajeUtil.mensajeInformacion("Retiro existoso. Nuevo saldo: "+ cuenta.getSaldo(), "Transacción existosa");
            }
        }
        else {
            throw new Exception("Saldo insuficiente. No se pudo realizar el retiro");
        }  
    }
}

