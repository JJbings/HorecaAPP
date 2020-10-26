package sample.startGui;


import BL.algorithm.AlgorithmStrategy;
import BL.algorithm.MaxPlusExtraSeats;
import BL.booking.Bookable;
import BL.booking.Booking;
import BL.dataProviders.Interface.BookingDataProvider;
import BL.restaurant.Restaurant;
import BL.restaurant.User;
import BL.restaurant.table.Table;
import BL.restaurant.table.TableType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class ControllerMain implements Initializable {
    //Variables
    private Restaurant selectedRestaurant;
    private final BookingDataProvider bookingData;
    private Stage stage2;
    private final ObservableList<Table> tables;


    //GUI Objects
    @FXML
    Button resetbutton;
    @FXML
    Button magicButton;
    @FXML
    ImageView magic;
    @FXML
    private Button addButton;
    @FXML
    private Button closeAddPaneButton;
    @FXML
    private Pane addPane;
    @FXML
    private Button selectBookingDate;
    @FXML
    private DatePicker dp;
    @FXML
    private TableView<Bookable> bookingDataTable;
    @FXML
    private AnchorPane anchorTab2;
    private Button button1;
    @FXML
    private Button endB;
    @FXML
    private Button button2;
    @FXML
    private TabPane tabPane;
    @FXML
    public VBox vBox;
    @FXML
    private TilePane tilePane;
    @FXML
    private Group group;
    @FXML
    private TableView<Table> tableView = new TableView<>();
    @FXML
    public TableColumn nrColumn;
    @FXML
    public TableColumn maxColumn;
    @FXML
    public TableColumn minColumn;
    @FXML
    public TableColumn dateC;
    @FXML
    public TableColumn nameC;
    @FXML
    public TableColumn timeC;
    @FXML
    public TableColumn visitorsC;
    @FXML
    public TableColumn tableC;
    @FXML
    private TextField bookingNameTextfield;
    @FXML
    private TextField bookingAmountTextfield;
    @FXML
    private TextField bookingTimeTextfield;
    @FXML
    private DatePicker bookingDate;
    @FXML
    private Button addBookingButton;
    @FXML
    private TableColumn avgColumn;
    @FXML
    private Label titleLabel;
    @FXML
    private TextField minTextField;
    @FXML
    private TextField maxTextField;
    @FXML
    private TextField nrTextField;
    @FXML
    private TableView treeTable;


    //Constructor
    public ControllerMain(User user) {
        this.bookingData = user.getBookingDataProvider();
        tables = FXCollections.observableArrayList();


    }

    //Setters

    public void setStage2(Stage stage2) {
        this.stage2 = stage2;
    }

    public void setSelectedRestaurant(Restaurant selectedRestaurant) {
        this.selectedRestaurant = selectedRestaurant;
        titleLabel.setText(selectedRestaurant.getRestaurantName());
    }


    //Methods

    //Initialization
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nrColumn.setCellValueFactory(new PropertyValueFactory<>("tableNr"));
        maxColumn.setCellValueFactory(new PropertyValueFactory<>("maxSeats"));
        minColumn.setCellValueFactory(new PropertyValueFactory<>("minSeats"));
        avgColumn.setCellValueFactory(new PropertyValueFactory<>("avgSeats"));
        addPane.setVisible(false);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");

        dateC.setCellValueFactory(new PropertyValueFactory<>("bookedDate"));
        dateC.setCellFactory(column -> new TableCell<Bookable, LocalDate>() {
            @Override
            protected void updateItem(LocalDate bookedDate, boolean empty) {
                super.updateItem(bookedDate, empty);
                if (empty) {
                    setText("");
                } else {
                    setText(formatter.format(bookedDate));
                }
            }
        });

        timeC.setCellValueFactory(new PropertyValueFactory<>("bookedTime"));
        timeC.setCellFactory(column -> new TableCell<Bookable, LocalTime>() {
            @Override
            protected void updateItem(LocalTime bookedTime, boolean empty) {
                super.updateItem(bookedTime, empty);
                if (empty) {
                    setText("");
                } else {
                    setText(formatter2.format(bookedTime));
                }
            }
        });


        nameC.setCellValueFactory(new PropertyValueFactory<>("bookedName"));
        visitorsC.setCellValueFactory(new PropertyValueFactory<>("visitors"));
        dp.setShowWeekNumbers(true);
        tableC.setCellValueFactory((new PropertyValueFactory<>("table")));


    }


    //Updating the tables list in the gui
    public void updateTablesList() {
        treeTable.getItems().clear();
        treeTable.getItems().addAll(selectedRestaurant.getTablesArray());
    }

    //Adding a table to the restaurant based upon the users choice, also check if all fields are filled in
    public void addTable(TableType type) {


        try {


            if (selectedRestaurant.checkTableNumber(Integer.parseInt(nrTextField.getText()))) {
                selectedRestaurant.addTable(type, Integer.parseInt(maxTextField.getText()),
                        Integer.parseInt(minTextField.getText()), Integer.parseInt(nrTextField.getText()));


            } else {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setHeaderText("ERROR");
                error.setContentText(" Table number already exists!");
                error.showAndWait();
            }

            for (int i = 0; i < selectedRestaurant.getTablesArray().size(); i++) {

                if (!treeTable.getItems().contains(selectedRestaurant.getTablesArray().get(i))) {
                    treeTable.getItems().add(selectedRestaurant.getTablesArray().get(i));
                    maxTextField.clear();
                    minTextField.clear();
                    nrTextField.clear();

                }
            }

        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setHeaderText("ERROR");
            error.setContentText("Please fill in every field.");
            error.showAndWait();

        }

    }

    //Adding a Square table
    public void addSquareTable(MouseEvent mouseEvent) {

        addTable(TableType.SQUARE_TABLE);

    }

    //Adding a round table
    public void addRoundTable(MouseEvent mouseEvent) {

        addTable(TableType.ROUND_TABLE);


    }

    //Deleting a table
    public void deleteTable(MouseEvent mouseEvent) {
        selectedRestaurant.deleteTable((Table) treeTable.getSelectionModel().getSelectedItem());
        treeTable.getItems().clear();
        treeTable.getItems().addAll(selectedRestaurant.getTablesArray());


        //treeTable.getItems().remove(treeTable.getSelectionModel().getSelectedIndex());
    }

    //Going back to the previous menu
    public void backButton(MouseEvent mouseEvent) throws IOException {
        ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();

        stage2.show();


    }

    //Filtering the booking table to the selected date
    public void selectBookingDate(MouseEvent mouseEvent) {


        bookingDataTable.getItems().clear();

        ObservableList<Bookable> a = FXCollections.observableArrayList();

        for (int i = 0; i < bookingData.getAllBookings().size(); i++) {

            if (bookingData.getAllBookings().get(i).getBookedDate().equals(dp.getValue())) {
                bookingDataTable.getItems().add(bookingData.getAllBookings().get(i));

            }
        }


    }


    //Showing the add window
    public void showAddButton(MouseEvent mouseEvent) {
        addPane.setVisible(true);
    }


    //Closing the add window
    public void closeAddPane(MouseEvent mouseEvent) {
        addPane.setVisible(false);
    }

    //Adding a booking to the booking data
    public void addBooking(MouseEvent mouseEvent) throws ParseException {


        bookingData.addBooking(new Booking(bookingDate.getValue(), LocalTime.parse(bookingTimeTextfield.getText()), bookingNameTextfield.getText(), Integer.parseInt(bookingAmountTextfield.getText())));
        selectBookingDate(mouseEvent);
        bookingTimeTextfield.clear();
        bookingNameTextfield.clear();
        bookingAmountTextfield.clear();
    }

    public void doMagic(MouseEvent mouseEvent) {
        selectedRestaurant.setiAlgorithmStrategy(new MaxPlusExtraSeats());
        selectedRestaurant.doMagic(dp.getValue());
        magic.setVisible(true);
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                return null;
            }
        };

        sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                magic.setVisible(false);
            }
        });
        new Thread(sleeper).start();
        selectBookingDate(mouseEvent);

    }

    public void doReset(MouseEvent mouseEvent) {
        bookingData.resetBookings();
        selectBookingDate(mouseEvent);
    }
}