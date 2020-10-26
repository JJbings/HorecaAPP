module Main {
    requires Business;
    requires DataLayer;
    requires GuiLayer;
    requires javafx.graphics;
    requires  javafx.fxml;
    exports start;
    opens start;




}