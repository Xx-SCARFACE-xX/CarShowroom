package controllers;

        import main.DBConnect;
        import main.Main;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.fxml.FXMLLoader;
        import javafx.scene.Scene;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.control.TextField;
        import javafx.scene.layout.GridPane;
        import javafx.stage.Stage;

        import java.io.IOException;
        import java.sql.ResultSet;
        import java.sql.SQLException;

public class SearchController {

    @FXML
    private GridPane root;

    @FXML
    private TextField searchvid;

    @FXML
    private Button SearchCar;

    @FXML
    private Label status;

    @FXML
    private Label id1;
    @FXML
    private Label brand1;
    @FXML
    private Label model1;
    @FXML
    private Label type1;
    @FXML
    private Label colour1;
    @FXML
    private Label status1;


    @FXML
    void onSearchCar(ActionEvent event)  throws IOException {
        String query = "SELECT * FROM `cars` WHERE `VEHICLE_ID` = '%s' ";
        query = String.format(query, searchvid.getText());

        if(searchvid.getText().isEmpty())
        {
            status.setText("Status: Field cannot be empty");
        }
        else
        {
            try
            {
                ResultSet set = DBConnect.getStatement().executeQuery(String.format(query));
                if(set.next())
                {

                    {
                        status.setText("Status: Vehicle found");

                        int vid = set.getInt("VEHICLE_ID");
                        String svid =  Integer.toString(vid);
                        id1.setText(svid);

                        String vbrand= set.getString("BRAND");
                        brand1.setText(vbrand);

                        String vmodel = set.getString("MODEL");
                        model1.setText(vmodel);

                        String vtype = set.getString("TYPE");
                        type1.setText(vtype);

                        String vcolour = set.getString("COLOUR");
                        colour1.setText(vcolour);

                        String vstatus = set.getString("STATUS");
                        status1.setText(vstatus);

                    }
                }
                else
                {
                    status.setText("Status: Incorrect Vehicle ID");
                }
                set.close();
            }
            catch(SQLException e)
            { e.printStackTrace();
            }
        }

    }

    @FXML
    void onBackToMng(ActionEvent event) throws IOException {
        Stage registerStage = Main.stage;
        registerStage.setTitle("Management");
        root = FXMLLoader.load(getClass().getResource("/fxmls/Management.fxml"));
        registerStage.setScene(new Scene(root));
        registerStage.show();
    }

}
