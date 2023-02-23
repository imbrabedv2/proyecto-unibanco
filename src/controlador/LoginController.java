package controlador;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import java.io.IOException;

import exceptions.ClienteNoExisteException;
import exceptions.ValorRequeridoException;
import modelo.appController;
import util.MensajeUtil;

import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	private Stage stage;
	private Scene scene;
	private Parent root;
    @FXML
    private Label contraseñaLabel;

    @FXML
    private TextField contraseñaTextField;

    @FXML
    private Button crearCuentaButton;

    @FXML
    private Button logInButton;

    @FXML
    private Label numeroDocumentoLabel;

    @FXML
    private TextField numeroDocumentoTextField;

    @FXML
    private Label tittleLabel;
	
	public void onCrearCuentaClick(ActionEvent event) throws IOException {
		root= FXMLLoader.load(getClass().getResource("/vista/singIn.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void onLoginClick(ActionEvent event) throws ValorRequeridoException, IOException {
        try {
            if (numeroDocumentoTextField.getText().isEmpty()) {
                throw new ValorRequeridoException("Cedula");
            }
            if (contraseñaTextField.getText().isEmpty()) {
                throw new ValorRequeridoException("contraseña");
            }
            if (appController.INSTANCE.getBanco().buscarCliente(numeroDocumentoTextField.getText()) == null) {
                throw new ClienteNoExisteException(numeroDocumentoTextField.getText());
            }
            if (contraseñaTextField.getText().equals(appController.INSTANCE.getBanco().buscarCuenta(numeroDocumentoTextField.getText()).getContrasena())) {
                MensajeUtil.mensajeInformacion("Inicio de secion correcto", "Inicio de sesion exitoso");
                appController.INSTANCE.setCuentaActual(appController.INSTANCE.getBanco().buscarCliente(numeroDocumentoTextField.getText()).getCuenta());
                
				root= FXMLLoader.load(getClass().getResource("/vista/Menu.fxml"));
				stage= (Stage)((Node)event.getSource()).getScene().getWindow();
				scene= new Scene(root);
				stage.setScene(scene);
				stage.show();
            }
        }catch (Exception e) {
            MensajeUtil.mensajeInformacion(e.getMessage(),"Error");
        }
	}

}
