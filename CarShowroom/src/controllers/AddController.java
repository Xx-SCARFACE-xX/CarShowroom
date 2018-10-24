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


public class AddController
{

    @FXML
    private GridPane root;

    @FXML
    private Button submit;

    @FXML
    private TextField addbrand;

    @FXML
    private TextField addmodel;

    @FXML
    private TextField addtype;

    @FXML
    private TextField addcolour;

    @FXML
    private TextField addstatus;

    @FXML
    private TextField addrprice;

    @FXML
    private TextField addsprice;

    @FXML
    void onSubmit (ActionEvent event)throws IOException {
        String query = "INSERT INTO `cars`(`BRAND`, `MODEL`, `TYPE`, `COLOUR`, `STATUS`, `RENT_PRICE`, `SELLING_PRICE`) VALUES ('%s','%s','%s','%s','%s','%d','%d')";
        query = String.format(query, addbrand.getText(), addmodel.getText(), addtype.getText(), addcolour.getText(), addstatus.getText(), Integer.parseInt(addrprice.getText()), Integer.parseInt(addsprice.getText()));
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