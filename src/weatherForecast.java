import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;


import java.io.IOException;
import java.lang.Exception;
import java.util.logging.Level;
import java.util.logging.Logger;

public class weatherForecast extends Application {





    public static void main(String[] args) throws  Exception  {


        Application.launch(weatherForecast.class,(java.lang.String[])null );


    }

    public void start(Stage mainsStage) throws IOException {

        try {

            FXMLLoader loader = new FXMLLoader(weatherForecast.class.getResource("weatherGui.fxml"));
            Pane page = (Pane) loader.load();

            Scene scene = new Scene(page);

            mainsStage.setTitle("Weather Forecast");
            mainsStage.setScene(scene);
            mainsStage.show();

        }

        catch (Exception e) {

            Logger.getLogger(weatherForecast.class.getName()).log(Level.SEVERE, null, e);
        }


    }


}
