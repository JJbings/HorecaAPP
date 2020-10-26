package sample.startGui;

import BL.restaurant.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;


public class ControllerLogin implements Initializable {

    private final User user;
    private final Stage stage2;

    //GUI Objects
    @FXML
    private Button buttonLogin;
    private Button save;
    @FXML
    private Pane rootPane;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField loginField;

    //Constructor
    public ControllerLogin(User user, Stage stage2) {
        this.user = user;
        this.stage2 = stage2;


    }

    //Initialization
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    //Methods

    //Login method to validate credentials
    // todo validation
    public void Login(MouseEvent mouseEvent) throws IOException, URISyntaxException {

        if ("joco".equals(passwordField.getText()) && "joco".equals(loginField.getText())) {


            ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
            stage2.show();


        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Error ");
            error.setContentText("Password or username incorrect!");
            error.showAndWait();

        }

    }


}
