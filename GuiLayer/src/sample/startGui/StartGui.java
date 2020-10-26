package sample.startGui;

import BL.restaurant.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class StartGui {
    static ControllerLogin controllerLogin;

    public void Gui(Stage primaryStage, User user) throws IOException {


        //Controller table display
        FXMLLoader loader3 = new FXMLLoader(new File("C:/Users/bjoco/IdeaProjects/HorecaAPPFX/GuiLayer/src/sample/startGui/mainGui.fxml").toURI().toURL());
        ControllerMain controllerMain = new ControllerMain(user);
        loader3.setController(controllerMain);
        VBox vbox = loader3.load();
        Scene scene3 = new Scene(vbox);
        scene3.getStylesheets().add("Style.css");
        Stage stage3 = new Stage();
        stage3.setScene(scene3);


        //Controller restaurant display
        FXMLLoader loaderRestaurant = new FXMLLoader(new File("C:/Users/bjoco/IdeaProjects/HorecaAPPFX/GuiLayer/src/sample/startGui/AddRestaurant.fxml").toURI().toURL());
        ControllerRestaurant controllerRestaurant = new ControllerRestaurant(user, stage3, controllerMain);
        loaderRestaurant.setController(controllerRestaurant);
        Pane pane2 = loaderRestaurant.load();
        Scene scene2 = new Scene(pane2);
        scene2.getStylesheets().add("Style.css");
        Stage stage2 = new Stage();
        stage2.setScene(scene2);
        controllerMain.setStage2(stage2);


        //controller Login display
        FXMLLoader loaderLogin = new FXMLLoader(new File("C:/Users/bjoco/IdeaProjects/HorecaAPPFX/GuiLayer/src/sample/startGui/Login.fxml").toURI().toURL());
        ControllerLogin controllerLogin = new ControllerLogin(user, stage2);
        loaderLogin.setController(controllerLogin);
        Pane pane = loaderLogin.load();
        primaryStage.setTitle("HorecaAPP");
        Scene scene1 = new Scene(pane);
        scene1.getStylesheets().add("Style.css");
        primaryStage.setScene(scene1);
        primaryStage.show();


    }

}
