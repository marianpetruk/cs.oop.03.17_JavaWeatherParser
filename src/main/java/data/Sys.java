package data;

import org.json.simple.JSONObject;

public class Sys extends Data {
    private final String country;
    private final long sunrice;
    private final long sunset;
    private final JSONObject sys;

    public Sys(JSONObject json) {
        this.sys = (JSONObject) json.get("sys");
        this.country = (String) this.sys.get("country");
        this.sunrice = (Long) this.sys.get("sunrise");
        this.sunset = (Long) this.sys.get("sunset");
    }

    public String getCountry() {
        return this.country;
    }

    public Long getSunrise() {
        return this.sunrice;
    }

    public Long getSunset() {
        return this.sunset;
    }

    @Override
    public JSONObject toJson() {
        return this.sys;
    }

    @Override
    public String toString() {
        return String.format("Country code is %s, sun rises on %s and sets on %s.", getCountry(), new java.util.Date((long) getSunrise() * 1000), new java.util.Date((long) getSunset() * 1000));
    }
}