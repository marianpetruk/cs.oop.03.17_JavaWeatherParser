package data;

import org.json.simple.JSONObject;

public class Wind extends Data {
    private final Number deg;
    private final Number speed;
    private final JSONObject wind;

    public Wind(JSONObject json) {
        this.wind = (JSONObject) json.get("wind");
        this.deg = (Number) this.wind.get("deg");
        this.speed = (Number) this.wind.get("speed");
    }

    public Number getDeg() {
        return this.deg;
    }

    public Number getSpeed() {
        return this.speed;
    }

    @Override
    public JSONObject toJson() {
        return this.wind;
    }

    @Override
    public String toString() {
        return String.format("Direction of Wind for today is %s deg. and speed is %s m/s.", getDeg().toString(), getSpeed().toString());
    }
}