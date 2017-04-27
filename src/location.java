import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import mypackage.ExceptionException;
import mypackage.MelbourneWeather2Stub;


import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class location extends Application  {

    @FXML private Label txtLocation;
    @FXML private Label temperature;
    @FXML private Label rainfall;



    void init (String selectedItem) throws Exception {
        txtLocation.setText((selectedItem));
        weather(selectedItem);
        }


    @Override
    public void start(Stage primaryStage) throws Exception {
        try {

            FXMLLoader loader = new FXMLLoader(location.class.getResource("locationGui.fxml"));
            Pane page = (Pane) loader.load();

            Scene scene = new Scene(page);
            Stage stage = new Stage();

            stage.setTitle("Weather Forecast");
            stage.setScene(scene);
            stage.show();


        }

        catch (Exception e) {

            Logger.getLogger(location.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public static void main(String[] args) throws RemoteException, ExceptionException {

        Application.launch(location.class,(java.lang.String[])null );






    }



    private void  weather(String loc) throws Exception {
        final MelbourneWeather2Stub MelbourneWeather = new MelbourneWeather2Stub();
        MelbourneWeather2Stub.GetLocationsResponse LocationsResponse = MelbourneWeather.getLocations();
        String[] locations = LocationsResponse.get_return();


        MelbourneWeather2Stub.GetRainfall RainfallRequest = new MelbourneWeather2Stub.GetRainfall();
        RainfallRequest.setLocation(loc);
        MelbourneWeather2Stub.GetRainfallResponse RainfallResponse = MelbourneWeather.getRainfall(RainfallRequest);
        String[] rainfal = ((RainfallResponse.get_return()));
        rainfall.setText(rainfal[1]);


        //temperature
        MelbourneWeather2Stub.GetTemperature tempReq=new MelbourneWeather2Stub.GetTemperature();
        tempReq.setLocation(loc);
        MelbourneWeather2Stub.GetTemperatureResponse temperatureResponse=MelbourneWeather.getTemperature(tempReq);
        String[] temp=(temperatureResponse.get_return());
        temperature.setText(temp[1]);







    }


}

