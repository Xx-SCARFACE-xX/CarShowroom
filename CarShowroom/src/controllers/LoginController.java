package controllers;

import main.DBConnect;
import main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {

    @FXML
    private GridPane root;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button login;

    @FXML
    private Button register;

    @FXML
    private Label status;

    @FXML
    void onLogin(ActionEvent event)  throws IOException {
        String query = "SELECT * FROM `users` WHERE `username` = '%s' && `password` = '%s'";
        query = String.format(query, username.getText(),password.getText());

        if(username.getText().isEmpty()||password.getText().isEmpty())
        {
            status.setText("username or password cannot be empty");
        }
        else
        {
            try
            {
                ResultSet set = DBConnect.getStatement().executeQuery(String.format(query));
                if(set.next())
                {

                    {
                        status.setText("Log in success");
                        Stage mngStage = Main.stage;
                        mngStage.setTitle("Welcome");
                        root = FXMLLoader.load(getClass().getResource("/fxmls/welcome.fxml"));
                        mngStage.setScene(new Scene(root));
                        mngStage.show();
                    }
                }
                else
                {
                    status.setText("Incorrect username or password");
                }
                set.close();
            }
            catch(SQLException e)
            { e.printStackTrace();
            }
        }

    }

    @FXML
    void onRegister(ActionEvent event) throws IOException {
        Stage registerStage = Main.stage;
        registerStage.setTitle("Register");
        root = FXMLLoader.load(getClass().getResource("/fxmls/register.fxml"));
        registerStage.setScene(new Scene(root));
        registerStage.show();
    }

}
