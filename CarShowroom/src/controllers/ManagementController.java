package controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.DBConnect;
import main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class ManagementController
{

    @FXML
    private GridPane root;

    @FXML
    private Button logOut;

    @FXML
    private Button buy;

    @FXML
    private Button rent;

    @FXML
    private Button add;

    @FXML
    private Button delete;

    @FXML
    private Button return1;

    @FXML
    private Button search;


    @FXML
    private TableView<CarTable> tableview;

    @FXML
    private TableColumn<CarTable, Integer> vidcol;

    @FXML
    private TableColumn<CarTable, String> brandcol;

    @FXML
    private TableColumn<CarTable, String> modelcol;

    @FXML
    private TableColumn<CarTable, String> typecol;

    @FXML
    private TableColumn<CarTable, String> colourcol;

    @FXML
    private TableColumn<CarTable, String> statuscol;

    @FXML
    private TableColumn<CarTable, Integer> rpricecol;

    @FXML
    private TableColumn<CarTable, Integer> spricecol;


    ObservableList<CarTable> data;


    @FXML
    void onLogOut(ActionEvent event) throws IOException {
        Stage logoutStage = Main.stage;
        logoutStage.setTitle("Login");
        root = FXMLLoader.load(getClass().getResource("/fxmls/login.fxml"));
        logoutStage.setScene(new Scene(root));
        logoutStage.show();
    }

    @FXML
    void onAdd (ActionEvent event) throws IOException {
        Stage addStage = Main.stage;
        addStage.setTitle("Add");
        root = FXMLLoader.load(getClass().getResource("/fxmls/add.fxml"));
        addStage.setScene(new Scene(root));
        addStage.show();
    }


    @FXML
    void onRent (ActionEvent event) throws IOException {
        Stage addStage = Main.stage;
        addStage.setTitle("Rent");
        root = FXMLLoader.load(getClass().getResource("/fxmls/rent.fxml"));
        addStage.setScene(new Scene(root));
        addStage.show();
    }

    @FXML
    void onReturn (ActionEvent event) throws IOException {
        Stage addStage = Main.stage;
        addStage.setTitle("Return");
        root = FXMLLoader.load(getClass().getResource("/fxmls/return.fxml"));
        addStage.setScene(new Scene(root));
        addStage.show();
    }

    @FXML
    void onDelete (ActionEvent event) throws IOException {
        Stage addStage = Main.stage;
        addStage.setTitle("Delete");
        root = FXMLLoader.load(getClass().getResource("/fxmls/delete.fxml"));
        addStage.setScene(new Scene(root));
        addStage.show();
    }

    @FXML
    void onBuy (ActionEvent event) throws IOException {
        Stage addStage = Main.stage;
        addStage.setTitle("Buy");
        root = FXMLLoader.load(getClass().getResource("/fxmls/buy.fxml"));
        addStage.setScene(new Scene(root));
        addStage.show();
    }
    @FXML
    void onSearch (ActionEvent event) throws IOException {
        Stage addStage = Main.stage;
        addStage.setTitle("Search");
        root = FXMLLoader.load(getClass().getResource("/fxmls/search.fxml"));
        addStage.setScene(new Scene(root));
        addStage.show();
    }


    @FXML
    void initialize() {
        vidcol.setCellValueFactory(new PropertyValueFactory<CarTable, Integer>("VEHICLE_ID"));
        brandcol.setCellValueFactory(new PropertyValueFactory<CarTable, String>("BRAND"));
        modelcol.setCellValueFactory(new PropertyValueFactory<CarTable, String>("MODEL"));
        typecol.setCellValueFactory(new PropertyValueFactory<CarTable, String>("TYPE"));
        colourcol.setCellValueFactory(new PropertyValueFactory<CarTable, String>("COLOUR"));
        statuscol.setCellValueFactory(new PropertyValueFactory<CarTable, String>("STATUS"));
        rpricecol.setCellValueFactory(new PropertyValueFactory<CarTable, Integer>("RENT_PRICE"));
        spricecol.setCellValueFactory(new PropertyValueFactory<CarTable, Integer>("SELLING_PRICE"));

        try {
            buildData();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private void buildData() throws SQLException {
        data = FXCollections.observableArrayList();

        String query = "SELECT * FROM `cars`";
        ResultSet rs = DBConnect.getStatement().executeQuery(query);


        while (rs.next()) {
            CarTable mt = new CarTable();
            mt.vid.set(rs.getInt("VEHICLE_ID"));
            mt.brand.set(rs.getString("BRAND"));
            mt.model.set(rs.getString("MODEL"));
            mt.type.set(rs.getString("TYPE"));
            mt.colour.set(rs.getString("COLOUR"));
            mt.astatus.set(rs.getString("STATUS"));
            mt.rprice.set(rs.getInt("RENT_PRICE"));
            mt.sprice.set(rs.getInt("SELLING_PRICE"));
            data.add(mt);
        }
        tableview.setItems(data);
    }

}
