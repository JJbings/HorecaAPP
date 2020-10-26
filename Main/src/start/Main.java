package start;


import BL.algorithm.AlgorithmStrategy;
import BL.dataProviders.Interface.BookingDataProvider;
import BL.restaurant.User;
import DataAccess.dataProviders.BookingDataStore;
import javafx.application.Application;
import javafx.stage.Stage;
import sample.startGui.StartGui;

import java.io.IOException;
import java.time.LocalDate;


public class Main extends Application {
    private User user;


    public static void main(String[] args) throws IOException {
        Application.launch(args);

    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        BookingDataProvider bookingDataProvider = new BookingDataStore();


        user = new StartLogic().startUser(bookingDataProvider);
        user.setBookingDataProvider(bookingDataProvider);


        new StartGui().Gui(primaryStage, user);


    }


}
