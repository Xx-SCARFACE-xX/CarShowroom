package controllers;

import main.DBConnect;
import main.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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

public class RegisterController {

    @FXML
    private GridPane root;

    @FXML
    private TextField regusername;

    @FXML
    private PasswordField regpassword;

    @FXML
    private PasswordField regconpassword;

    @FXML
    private Button toregister;

    @FXML
    private Button backToLogin;

    @FXML
    private Label regstatus;

    @FXML
    void newRegister(javafx.event.ActionEvent event) {
        if (regusername.getText().isEmpty()||regpassword.getText().isEmpty()||regconpassword.getText().isEmpty())
        {regstatus.setText("Pls fill all dets");}

        else if(!regconpassword.getText().equals(regpassword.getText()))
        {regstatus.setText("Passwords dfont match");}

        else if(doesUserExist(regusername.getText()))
        {regstatus.setText("User already exists");}

        else
        {
            String query = "INSERT INTO `users`(`username`, `password`) VALUES ('%s','%s')";
            query = String.format(query, regusername.getText(),regpassword.getText());
            try {
                DBConnect.getStatement().executeUpdate(query);
                regstatus.setText("User registered");
            }
            catch(SQLException e)
            { e.printStackTrace();
            }

        }

    }

    boolean doesUserExist (String username) {
        boolean exist = false;
        String query = "SELECT * FROM `users` WHERE username = '%s'";
        try {
            ResultSet set = DBConnect.getStatement().executeQuery(String.format(query, username));
            exist = set.next();
        }
        catch(SQLException e)
        { e.printStackTrace();
        }
        return exist;

    }

    @FXML
    void openLogin(javafx.event.ActionEvent event) throws IOException {
        Stage loginStage = Main.stage;
        loginStage.setTitle("Login");
        Parent root = FXMLLoader.load(getClass().getResource("/fxmls/login.fxml"));
        loginStage.setScene(new Scene(root));
        loginStage.show();
    }

}
