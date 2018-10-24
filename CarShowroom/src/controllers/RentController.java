package controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.DBConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import main.Main;

import java.io.IOException;
import java.sql.SQLException;


public class RentController
{

    @FXML
    private GridPane root;

    @FXML
    private Button RentCar;

    @FXML
    private TextField rentvid;

    @FXML
    void onRentCar (ActionEvent event)throws IOException {
        String query = "UPDATE `cars` SET `STATUS` = 'Unavailable' WHERE `VEHICLE_ID` = ('%d')";
        query = String.format(query, Integer.parseInt(rentvid.getText()));
        try {
            DBConnect.getStatement().executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Stage mngStage = Main.stage;
        mngStage.setTitle("Management");
        root = FXMLLoader.load(getClass().getResource("/fxmls/management.fxml"));
        mngStage.setScene(new Scene(root));
        mngStage.show();

    }

}