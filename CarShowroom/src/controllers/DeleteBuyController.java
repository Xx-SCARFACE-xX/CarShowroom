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


public class DeleteBuyController
{

    @FXML
    private GridPane root;

    @FXML
    private Button RemoveCar;

    @FXML
    private TextField removevid;

    @FXML
    void onRemoveCar (ActionEvent event)throws IOException {
        String query = "DELETE FROM `cars` WHERE `VEHICLE_ID` = ('%d')";
        query = String.format(query, Integer.parseInt(removevid.getText()));
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