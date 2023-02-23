package exceptions;

public class ValorRequeridoException extends Exception {

    public ValorRequeridoException(String nombre) {
        super(String.format("El campo %s es requerido", nombre));
    }
}
