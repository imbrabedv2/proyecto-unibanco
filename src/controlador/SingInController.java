package controlador;

import java.io.IOException;
import util.TextFormaterUtil;
import exceptions.ValorRequeridoException;
import modelo.appController;
import util.MensajeUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import modelo.TipoCuenta;

public class SingInController {
	private Stage stage;
	private Scene scene;
	private Parent root;

    @FXML
    private Label CrearCuentaLabel;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private TextField cedulaTextField;
    
    @FXML
    private TextField contraseñaTextField;

    @FXML
    private Button crearCuentaButton;

    @FXML
    private TextField emailTextField;
    
    @FXML
    private TextField saldoInicialTextField;

    @FXML
    private TextField nombreTextField;
    @FXML
    private ComboBox<TipoCuenta> tipoCuentaComboBox;
    
    public void initialize() {
        cedulaTextField.setTextFormatter(new TextFormatter<>(TextFormaterUtil::integerFormat));
        saldoInicialTextField.setTextFormatter(new TextFormatter<Object>(TextFormaterUtil::doubleFormat));
        for (TipoCuenta tipoCuenta : TipoCuenta.values()) {
            tipoCuentaComboBox.getItems().add(tipoCuenta);
        }
    }

    @FXML
    void onCrearCuentaClick(ActionEvent event) throws ValorRequeridoException, IOException {
        try {
            if(nombreTextField.getText().isEmpty()) {
                throw new ValorRequeridoException("nombre");
            }
            if(apellidoTextField.getText().isEmpty()) {
                throw new ValorRequeridoException("apellidos");
            }
            if(cedulaTextField.getText().isEmpty()) {
                throw new ValorRequeridoException("cedula");
            }
            if(emailTextField.getText().isEmpty()) {
                throw new ValorRequeridoException("email");
            }
            if (contraseñaTextField.getText().isEmpty()) {
                throw new ValorRequeridoException("contraseña");
            }
            if (saldoInicialTextField.getText().isEmpty()) {
                throw new ValorRequeridoException("saldo");
            }
            if (tipoCuentaComboBox.getValue() == null) {
                throw new ValorRequeridoException("tipo cuenta");
            }
            appController.INSTANCE.getBanco().crearCliente(nombreTextField.getText(), apellidoTextField.getText(), cedulaTextField.getText(), emailTextField.getText());
            appController.INSTANCE.getBanco().crearCuenta(cedulaTextField.getText(), Double.parseDouble(saldoInicialTextField.getText()), tipoCuentaComboBox.getValue(), contraseñaTextField.getText());
            appController.INSTANCE.setCuentaActual(appController.INSTANCE.getBanco().buscarCliente(cedulaTextField.getText()).getCuenta());
            MensajeUtil.mensajeInformacion("Creacion de Cuenta Correcta", "Creacion de Cuenta exitosa exitoso");
            root= FXMLLoader.load(getClass().getResource("/vista/Menu.fxml"));
            stage= (Stage)((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e) {
            MensajeUtil.mensajeAlerta(e.getMessage(), "Error");
        }
    }
		
}

