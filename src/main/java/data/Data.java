package data;

import org.json.simple.JSONObject;

public abstract class Data {
    public abstract JSONObject toJson();

    public abstract String toString();
}
