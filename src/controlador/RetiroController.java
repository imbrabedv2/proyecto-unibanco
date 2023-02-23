package controlador;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import exceptions.ValorRequeridoException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import modelo.Cuenta;
import modelo.TipoTransaccion;
import modelo.Transaccion;
import modelo.appController;
import util.MensajeUtil;
import util.TextFormaterUtil;

public class RetiroController {
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private TextField contraseñaTextField;

    @FXML
    private Button retirarButton;
    @FXML
    private Button cancelarRetiroButton;

    @FXML
    private Label retiroLabel;

    @FXML
    private TextField valorRetiroTextField;
    
    private Cuenta cuenta = appController.INSTANCE.getCuentaActual();
    
    public void initialize() {
    	valorRetiroTextField.setTextFormatter(new TextFormatter<Object>(TextFormaterUtil::doubleFormat));
    }
    
    @FXML
    void onRetirarClick(ActionEvent event) throws IOException {
        try {
            if (valorRetiroTextField.getText().isEmpty()) {
                throw new ValorRequeridoException("saldo a depositar");
            }
            Transaccion transaccion = new Transaccion(LocalTime.now(), DateTimeFormatter.ofPattern("ddMMyyHHmmssSSS"), Double.parseDouble(valorRetiroTextField.getText()), TipoTransaccion.RETIRO, cuenta);
            transaccion.retirar(Double.parseDouble(valorRetiroTextField.getText()),contraseñaTextField.getText() );
            valorRetiroTextField.setText("");
            MensajeUtil.mensajeInformacion("Retiro Exitoso", "El retiro de "+valorRetiroTextField.getText()+" fue exitoso¡");
            root= FXMLLoader.load(getClass().getResource("/vista/Menu.fxml"));
            stage= (Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            MensajeUtil.mensajeAlerta(e.getMessage(), "Error");
        }
    }
    
    @FXML
    void onCancelarRetiroClick(ActionEvent event) throws IOException {
		root= FXMLLoader.load(getClass().getResource("/vista/Menu.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

}

