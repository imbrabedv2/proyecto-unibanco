package modelo;

public enum appController {

    INSTANCE;
    private final Banco banco;

    private Cuenta cuentaActual;

    appController() {
        this.banco = new Banco("Unibanco");
        this.cuentaActual = null;
    }
    public Banco getBanco() {
        return this.banco;
    }

    public Cuenta getCuentaActual() {
        return cuentaActual;
    }

    public void setCuentaActual(Cuenta cuentaActual) {
        this.cuentaActual = cuentaActual;
    }
}
