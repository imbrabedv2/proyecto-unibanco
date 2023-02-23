package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Banco {
	private int numeroCuenta;
    private String nombre;
    private List<Cliente> clientes;
    private List<Transaccion> transacciones;
    private List<Cuenta> cuentas;

    public Banco(String nombre) {
    	this.numeroCuenta=0;
        this.nombre = nombre;
        this.clientes = new ArrayList<>();
        this.transacciones = new ArrayList<>();
        this.cuentas = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.add(cuenta);
    }

    public void agregarTransaccion(Transaccion transaccion) {
        transacciones.add(transaccion);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Transaccion> getTransacciones() {
        return transacciones;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    
    public Cliente buscarCliente(String cedula) {
        Optional<Cliente> resultado = clientes.stream()
                .filter(cliente -> cliente.getCedula().equals(cedula)).findFirst();
        return resultado.orElse(null);
    }
    
    public void crearCliente(String nombre, String apellido, String cedula, String email) {
        clientes.add(new Cliente(nombre, apellido, cedula, email));
    }
    
    public void crearCuenta(String cedula, double saldo, TipoCuenta tipoCuenta, String contrasena) {
        Cliente cliente = buscarCliente(cedula);
        Cuenta cuenta = new Cuenta(numeroCuenta + 1,contrasena, saldo, tipoCuenta);
        cuentas.add(cuenta);
        cuenta.setCliente(cliente);
        cliente.setCuenta(cuenta);
        numeroCuenta++;
    }
    
    public Cuenta buscarCuenta(String cedula) {
        Optional<Cuenta> resultado = cuentas.stream()
                .filter( cuenta -> cuenta.getCliente().getCedula().equals(cedula) ).findFirst();
        return resultado.orElse(null);
    }
    
}

