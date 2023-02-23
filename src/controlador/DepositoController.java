package controlador;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import exceptions.ValorRequeridoException;
import util.MensajeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Cuenta;
import modelo.TipoTransaccion;
import modelo.Transaccion;
import modelo.appController;

public class DepositoController {
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private Button depositarButton;
    @FXML
    private Button cancelarDepositoButton;

    @FXML
    private Label retiroLabel;

    @FXML
    private TextField valorDepositoTextField;
    
    @FXML
    private TextField contraseñaTextField;
    
    private Cuenta cuenta = appController.INSTANCE.getCuentaActual();
    
    @FXML
    void onDepositarClick(ActionEvent event) throws ValorRequeridoException, IOException {
        try {
            if (valorDepositoTextField.getText().isEmpty()) {
                throw new ValorRequeridoException("saldo a depositar");
            }
            Transaccion transaccion = new Transaccion(LocalTime.now(), DateTimeFormatter.ofPattern("ddMMyyHHmmssSSS"), Double.parseDouble(valorDepositoTextField.getText()), TipoTransaccion.DEPOSITO, cuenta);
            transaccion.depositar(Double.parseDouble(valorDepositoTextField.getText()),contraseñaTextField.getText() );
            valorDepositoTextField.setText("");
            MensajeUtil.mensajeInformacion("Deposito Exitoso", "El deposito de "+valorDepositoTextField.getText()+" fue exitoso¡");
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
    void onCancelarDepositoClick(ActionEvent event) throws IOException {
		root= FXMLLoader.load(getClass().getResource("/vista/Menu.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

}

