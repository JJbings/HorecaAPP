module GuiLayer {
    requires Business;
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    exports sample.startGui;
    opens sample.startGui;


}