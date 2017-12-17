package data;

import org.json.simple.JSONObject;

public class JsonData extends JSONObject {

    public final JSONObject jsonObject;

    public JsonData(JSONObject json) {
        this.jsonObject = json;
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

}