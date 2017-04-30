import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mypackage.ExceptionException;

import java.io.File;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class weatherDisplay extends Application {

    @FXML
    private Label txtLocation;
    @FXML
    private Label temperature;
    @FXML
    private Label rainfall;
    @FXML
    private ImageView weatherImage;
    @FXML
    private Label time;

    public static void main(String[] args) throws RemoteException, ExceptionException {

        Application.launch(weatherDisplay.class, (java.lang.String[]) null);


    }

    void init(String selectedItem) throws Exception {
        txtLocation.setText((selectedItem));
        numericWeatherDisplay(selectedItem);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            FXMLLoader loader = new FXMLLoader(weatherDisplay.class.getResource("locationGui.fxml"));
            Pane page = loader.load();

            Scene scene = new Scene(page);
            Stage stage = new Stage();

            stage.setTitle("Weather Forecast");
            stage.setScene(scene);
            stage.show();


        } catch (Exception e) {

            Logger.getLogger(weatherDisplay.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void numericWeatherDisplay(String loc) throws Exception {


        //rainfall
        Rainfall rain = new Rainfall(loc);
        String[] rainfalArray = rain.getDoubleRainfalVal();
        Double rainfal = Double.parseDouble(rainfalArray[1]);
        rainfall.setText(Double.toString(rainfal) + " mm");

        time.setText(rainfalArray[0]);

        //temperature
        Temperature temp = new Temperature(loc);
        Double tempval = temp.getDoublTemperature();
        temperature.setText(Double.toString(tempval) + " C");

        //setting image
        if (rainfal <= 0.0 && tempval > 0.0) {

            File file1 = new File("src/very_sunny.png");
            Image image1 = new Image(file1.toURI().toString());
            weatherImage.setImage(image1);
        } else if (rainfal > 0.0 && tempval > 0.0) {
            File file2 = new File("src/slightly_raining.png");
            Image image2 = new Image(file2.toURI().toString());
            weatherImage.setImage(image2);
        }
    }

}




