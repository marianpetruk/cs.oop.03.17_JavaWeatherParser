package data;

import org.json.simple.JSONObject;

public class Clouds extends Data {
    private final long all;
    private final JSONObject clouds;

    public Clouds(JSONObject json) {
        this.clouds = (JSONObject) json.get("clouds");
        this.all = (Long) this.clouds.get("all");
    }

    public Long getAll() {
        return this.all;
    }


    @Override
    public JSONObject toJson() {
        return this.clouds;
    }

    @Override
    public String toString() {
        return String.format("Clouds sky coverage today is %s%%.", getAll().toString());
    }
}