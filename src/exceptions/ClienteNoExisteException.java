package exceptions;

public class ClienteNoExisteException extends Exception {

    public ClienteNoExisteException(String cedula) {
        super(String.format("El cliente con cedula %s no esta registrado", cedula));
    }
}
