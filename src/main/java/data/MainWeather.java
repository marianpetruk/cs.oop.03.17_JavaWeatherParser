package data;

import org.json.simple.JSONObject;

public class MainWeather extends Data {
    private final double temp;
    private final long humidity;
    private final long pressure;
    private final JSONObject mainWeather;

    public MainWeather(JSONObject json) {
        this.mainWeather = (JSONObject) json.get("main");
        this.temp = (Double) this.mainWeather.get("temp");
        this.humidity = (Long) this.mainWeather.get("humidity");
        this.pressure = (Long) this.mainWeather.get("pressure");
    }

    public Double getKelvinTemp() {
        return this.temp;
    }

    public Double getCelciusTemp() {
        return this.temp - 273.15;
    }

    public Long getHumidity() {
        return this.humidity;
    }

    public Long getPressure() {
        return this.pressure;
    }

    @Override
    public JSONObject toJson() {
        return this.mainWeather;
    }

    @Override
    public String toString() {
        return String.format("Temperature for today is %s deg. Kelvin or %s deg. Celsius, humidity is %s%% and air pressure is %s hpa.", getKelvinTemp(), getCelciusTemp(), getHumidity(), getPressure());
    }
}