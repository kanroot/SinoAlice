package controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonReader {

    public JsonReader() {
    }

    public static JSONArray parserJson(String json){
        JSONArray jsonArray = new JSONArray();
        try {
            Reader reader = new FileReader(System.getenv("path")+ json +".json");
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            jsonArray = (JSONArray) jsonObject.get("data");
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }


}
