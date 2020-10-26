package sample.startGui;

import BL.restaurant.Restaurant;
import BL.restaurant.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerRestaurant implements Initializable {
    //Variables
    private final ObservableList<Restaurant> restaurants;
    private final User user;
    private final Stage stage3;
    private final ControllerMain controllerMain;

    //GUI Objects
    @FXML
    private ListView resList;
    @FXML
    private TextField resName;
    @FXML
    private TextField resAdress;


    //Constructor
    public ControllerRestaurant(User user, Stage stage3, ControllerMain controllerMain) {
        this.user = user;

        this.restaurants = FXCollections.observableArrayList();
        this.stage3 = stage3;
        this.controllerMain = controllerMain;


    }

    //Methods

    //Initialization (needs to be overridden part of implementation)
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateList();

    }

    //Adding a restaurant method and validating if both textfields are filled in, if not error message
    public void addRestaurant(MouseEvent mouseEvent) {
        Restaurant newRestaurant;
        String name;
        String adress;


        if (!resName.getText().isEmpty() && !resAdress.getText().isEmpty()) {

            name = resName.getText();
            adress = resAdress.getText();
            user.addRestaurant(name, adress);
            updateList();
            resName.clear();
            resAdress.clear();
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Invalid input");
            error.setContentText("Please specify name and adress");
            error.showAndWait();

        }


    }

    //Updating the restaurant list, shown in the gui stage
    public void updateList() {

        restaurants.setAll(user.getRestaurants());
        resList.getItems().setAll(restaurants);
    }


    //Deleting an restaurant with the delete button
    public void deleteResButton(MouseEvent mouseEvent) {
        // resList.getSelectionModel().getSelectedItem();
        // oresList.remove(resList.getSelectionModel().getSelectedItem());
        user.deleteRestaurant((Restaurant) resList.getSelectionModel().getSelectedItem());
        //resList.getItems().remove(resList.getSelectionModel().getSelectedItem());


        updateList();

    }

    //Selecting the restaurant will open next stage, also validating if something is selected, if not error massage
    public void selectResButton(MouseEvent mouseEvent) throws IOException, URISyntaxException {
        if (resList.getSelectionModel().getSelectedItem() != null) {
            controllerMain.setSelectedRestaurant((Restaurant) resList.getSelectionModel().getSelectedItem());
            controllerMain.updateTablesList();
            Restaurant selected = (Restaurant) resList.getSelectionModel().getSelectedItem();
            selected.setBookings(user.getBookingDataProvider());
            ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
            stage3.show();
        } else {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("Geen selectie gemaakt");
            error.setContentText("Selecteer een BusinessLogic.algorithm.restaurant");
            error.showAndWait();

        }
    }


    //Saving the user, this will also save restaurants and tables that are present of have been added
    //todo saving the seatings(bookings +tables)
    public void saveAll(MouseEvent mouseEvent) throws IOException {
        FileOutputStream fo = new FileOutputStream("User.ser");
        ObjectOutputStream os = new ObjectOutputStream(fo);
        os.writeObject(user);
        user.getBookingDataProvider().saveBookings();

    }
}
