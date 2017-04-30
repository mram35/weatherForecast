import mypackage.MelbourneWeather2Stub;

public class Temperature {
    private Double tempVal;
    private String locationChoice;

    public Temperature(String chosenLocation){
        this.locationChoice=chosenLocation;
    }
    private Double setDoubleTemperature(String locationChoice) throws Exception{
        //temperature
        final MelbourneWeather2Stub MelbourneWeather = new MelbourneWeather2Stub();
        MelbourneWeather2Stub.GetTemperature tempReq = new MelbourneWeather2Stub.GetTemperature();
        tempReq.setLocation(locationChoice);
        MelbourneWeather2Stub.GetTemperatureResponse temperatureResponse = MelbourneWeather.getTemperature(tempReq);
        String[] temp = (temperatureResponse.get_return());
        tempVal = Double.parseDouble(temp[1]);
        return tempVal;
    }

    public Double getDoublTemperature() throws Exception {
        return setDoubleTemperature(locationChoice);
    }
}
