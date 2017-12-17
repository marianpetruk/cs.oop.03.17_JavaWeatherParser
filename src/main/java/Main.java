import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        URL oracle = new URL("http://api.openweathermap.org/data/2.5/weather?q=Lviv&APPID=5496614f4ca95e6dcc0445c1e7f3916d");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));

        String inputLine;
        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();


    }

}
