package data;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import static java.lang.Long.valueOf;

public class Visibility extends Data {
    private final long visibility;

    public Visibility(JSONObject json) {
        this.visibility = valueOf((json.get("visibility")).toString());
    }

    public Long getVisibility() {
        return this.visibility;
    }

    @Override
    public JSONObject toJson() {
        JSONParser parser = new JSONParser();
        JSONObject json = null;
        try {
            json = (JSONObject) parser.parse(Long.toString(this.visibility));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public String toString() {
        return String.format("Visibility today is %s m.", getVisibility().toString());
    }
}