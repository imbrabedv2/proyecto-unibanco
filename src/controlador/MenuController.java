package controlador;

import java.io.IOException;

import util.MensajeUtil;

import modelo.Cliente;
import modelo.Cuenta;
import modelo.appController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MenuController {
	private Stage stage;
	private Scene scene;
	private Parent root;
    @FXML
    private Button consultarSaldoButton;

    @FXML
    private Button depositoButton;
    
    @FXML
    private Label nombreLabel;

    @FXML
    private Label numeroCuentaLabel;

    @FXML
    private Button retiroButton;
    
    @FXML
    private Button salirButton;

    @FXML
    private Label tipoCuentaLabel;
    
    private Cuenta cuenta = appController.INSTANCE.getCuentaActual();
    private Cliente cliente= appController.INSTANCE.getCuentaActual().getCliente();
    
    public void initialize() {
    	nombreLabel.setText(String.format("Nombre: %S %S", cliente.getNombre(),cliente.getApellido()));
    	numeroCuentaLabel.setText(String.format("Numero de Cuenta: %S", cuenta.getNumeroCuenta()));
    	tipoCuentaLabel.setText(String.format("Tipo de Cuenta:  %S", cuenta.getTipoCuenta()));
    }

    @FXML
    void onConsultarSaldoClick(ActionEvent event) {
    	MensajeUtil.mensajeInformacion("El saldo de la cuenta es: "+ cuenta.getSaldo(), "Saldo actual");
    }

    @FXML
    void onDepositoClick(ActionEvent event) throws IOException {
		root= FXMLLoader.load(getClass().getResource("/vista/Deposito.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void onRetiroClick(ActionEvent event) throws IOException {
		root= FXMLLoader.load(getClass().getResource("/vista/Retiro.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();	
    }
    
    @FXML
    void onSalirClick(ActionEvent event) throws IOException {
		root= FXMLLoader.load(getClass().getResource("/vista/login.fxml"));
		stage= (Stage)((Node)event.getSource()).getScene().getWindow();
		scene= new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

}

