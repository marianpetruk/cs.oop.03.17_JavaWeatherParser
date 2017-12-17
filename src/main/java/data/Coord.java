package data;

import org.json.simple.JSONObject;

public class Coord extends Data {
    private final double lon;
    private final double lat;
    private final JSONObject coord;
    private final String city;

    public Coord(JSONObject json) {
        this.coord = (JSONObject) json.get("coord");
        this.city = (String) json.get("name");
        this.lon = (Double) this.coord.get("lon");
        this.lat = (Double) this.coord.get("lat");
//        new Double(object.toString());
    }

    public Double getLat() {
        return this.lat;
    }

    public Double getLon() {
        return this.lon;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public JSONObject toJson() {
        return this.coord;
    }

    @Override
    public String toString() {
        return String.format("Coordinates of %s city: latitude = %s deg. and longitude = %s deg. ", getCity(), getLat().toString(), getLon().toString());
    }
}