package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Weather extends Data {
    private final String description;
    private final JSONObject weather;

    public Weather(JSONObject json) {
        this.weather = (JSONObject) ((JSONArray) json.get("weather")).get(0);
        this.description = this.weather.get("description").toString();
    }

    public String getDescription() {
        return this.description;
    }

    @Override
    public JSONObject toJson() {
        return this.weather;
    }

    @Override
    public String toString() {
        return String.format("Weather description for today: %s.", getDescription());
    }
}