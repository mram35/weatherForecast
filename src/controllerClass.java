import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javafx.collections.FXCollections.observableArrayList;

public class controllerClass  {


    @FXML private Button searchButton;
    @FXML private TextField txtRegion;
    @FXML private ChoiceBox<String> locationArr;
    @FXML private Label lbltest;





    @FXML private void initialize() {



        locationArr.getItems().addAll("Fawkner Beacon", "Laverton",
                "Melbourne Airport", "Bundoora", "Geelong Racecourse", "Cranbourne",
                "St Kilda Harbour RMYS", "Cerberus", "Rhyll", "Frankston", "Moorabbin Airport", "Essendon Airport",
                "Avalon", "Phillip Island", "Melbourne", "Olympic Park", "Viewbank", "South Channel Island",
                "Sheoaks", "Point Wilson", "Scoresby", "Ferny Creek", "Coldstream");


        searchButton.setOnAction((ActionEvent event) -> {




            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("locationGui.fxml"));

                Parent root = (Parent) loader.load();
                location newLocation = loader.getController();
                newLocation.init(locationArr.getSelectionModel().getSelectedItem());



                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setTitle("Weather Forecast");
                stage.setScene(scene);
                stage.show();


            }

            catch (Exception e) {

                Logger.getLogger(weatherForecast.class.getName()).log(Level.SEVERE, null, e);
            }


        });



        }



    void init (String selectedItem){
        lbltest.setText((selectedItem));
    }






    }



