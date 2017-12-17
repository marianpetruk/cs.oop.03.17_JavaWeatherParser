import java.io.IOException;

import data.Sys;
import org.json.simple.parser.ParseException;


public class Main {

    private static final String APPID = "5496614f4ca95e6dcc0445c1e7f3916d";

    public static void main(String[] args) throws IOException, ParseException {
        WeatherParser weatherParser = new WeatherParser("Lviv", APPID);

//        System.out.println(weatherParser.getJson() + "\n");

        System.out.println("Weather description: " + weatherParser.getWeather().getDescription() + "."); // print('description:', result['weather'][0]['description'])
        System.out.println("Temperature in Kelvin: " + weatherParser.getMainWeather().getKelvinTemp() + " deg."); // print('temperature in Kelvin:', result['main']['temp'])
        System.out.println("Temperature in Celsius: " + weatherParser.getMainWeather().getCelciusTemp() + " deg.\n"); // print('temperature in Celsius:', result['main']['temp'] - 273.15)

        weatherParser.printWeather();


    }

}
