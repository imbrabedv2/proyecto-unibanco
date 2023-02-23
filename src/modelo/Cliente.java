package modelo;

public class Cliente {
    private String nombre;
    private String apellido;
    private String cedula;
    private String email;
   	private Cuenta cuenta;

    public Cliente(String nombre, String apellido, String cedula, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getEmail() {
        return email;
    }
    public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}


} 

