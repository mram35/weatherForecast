import mypackage.MelbourneWeather2Stub;

public class Rainfall {
    private Double rainfallVal;
    private String locationChoice;

    public Rainfall(String chosenLocation) {
        this.locationChoice = chosenLocation;
    }

    private String[] setDoubleRainfalVal(String locationChoice) throws Exception {
        final MelbourneWeather2Stub MelbourneWeather = new MelbourneWeather2Stub();
        MelbourneWeather2Stub.GetRainfall RainfallRequest = new MelbourneWeather2Stub.GetRainfall();
        RainfallRequest.setLocation(locationChoice);
        MelbourneWeather2Stub.GetRainfallResponse RainfallResponse = MelbourneWeather.getRainfall(RainfallRequest);
        String[] rainfal = ((RainfallResponse.get_return()));
        //rainfallVal=Double.parseDouble(rainfal[1]);
        return rainfal;
    }

    public String[] getDoubleRainfalVal() throws Exception {
        return setDoubleRainfalVal(locationChoice);
    }
}
