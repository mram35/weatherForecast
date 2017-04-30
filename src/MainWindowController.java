import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import mypackage.ExceptionException;

import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindowController {


    @FXML private Button searchButton;
    @FXML private TextField txtRegion;
    @FXML private ChoiceBox<String> locationArr;


    public void initialize() throws RemoteException, ExceptionException {

        Location newLoc = new Location();


        locationArr.getItems().addAll(newLoc.getLocations());

        searchButton.setOnAction((ActionEvent event) -> {

            try {

                FXMLLoader loader = new FXMLLoader(getClass().getResource("WeatherDisplay.fxml"));

                Parent root = loader.load();
                weatherDisplay newDisplay = loader.getController();
                newDisplay.init(locationArr.getSelectionModel().getSelectedItem());


                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.setTitle("Weather Forecast");
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {

                Logger.getLogger(weatherForecast.class.getName()).log(Level.SEVERE, null, e);
            }

        });

    }

}



