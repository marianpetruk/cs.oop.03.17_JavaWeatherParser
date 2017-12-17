import data.MainWeather;
import data.Weather;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import data.*;


public class WeatherParser {
    private static final String API_URL = "http://api.openweathermap.org/data/2.5/weather";
    private final String city;
    private JSONObject json;

    public WeatherParser(String city, String appId) {
        this.city = city;
        URL openweathermap = null;
        this.json = null;
        try {
            openweathermap = new URL(String.format("%s?q=%s&APPID=%s", API_URL, this.city, appId));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        try {
            this.json = getJsonFromUrl(openweathermap);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getCity() {
        return this.city;
    }

    public Weather getWeather() {
        return new Weather(this.json);
    }

    public MainWeather getMainWeather() {
        return new MainWeather(this.json);
    }

    public Clouds getClouds() {
        return new Clouds(this.json);
    }

    public Coord getCoords() {
        return new Coord(this.json);
    }

    public Sys getSys() {
        return new Sys(this.json);
    }

    public Visibility getVisibility() {
        return new Visibility(this.json);
    }

    public Wind getWind() {
        return new Wind(this.json);
    }

    public JSONObject getJson() {
        return new JsonData(this.json).getJsonObject();
    }

    public void printWeather() {
        System.out.println(getClouds().toString());
        System.out.println(getCoords().toString());
        System.out.println(getMainWeather().toString());
        System.out.println(getSys().toString());
        System.out.println(getVisibility().toString());
        System.out.println(getWeather().toString());
        System.out.println(getWind().toString());
    }

    public JSONObject getJsonFromUrl(URL url) throws ParseException, IOException {
        BufferedReader in = null;
        try {
            in = new BufferedReader(
                    new InputStreamReader(url.openStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        StringBuilder rawWeatherApiData = new StringBuilder();
        String inputLine;

        if (in != null) {
            while ((inputLine = in.readLine()) != null) {
                rawWeatherApiData.append(inputLine);
            }
            in.close();
        }
//        JSONObject weatherJson = urlReader.getJsonFromURL(weatherURL);
//        System.out.println(rawWeatherApiData);

        JSONParser parser = new JSONParser();
        return (JSONObject) parser.parse(String.valueOf(rawWeatherApiData));
    }
}
