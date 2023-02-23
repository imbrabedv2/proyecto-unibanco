package util;

import javafx.scene.control.Alert;

public class MensajeUtil {

    public static void mensajeInformacion(String mensaje, String titulo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    public static void mensajeAlerta(String mensaje, String titulo) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
