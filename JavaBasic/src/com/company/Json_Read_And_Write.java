package com.company;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.FileReader;

/**
 * JSON的读写
 * Created by moqiaowen on 2017/5/17.
 */
public class Json_Read_And_Write {

    public static void main(String[] args) throws Exception {
        readJson();

        Json_Read_And_Write.writeJson();
    }

    public static void readJson() throws Exception {
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(new FileReader("language.json"));

        System.out.println("cat = " + object.get("cat").getAsString());
        System.out.println("pop = " + object.get("pop").getAsBoolean());


        JsonArray array = object.get("languages").getAsJsonArray();

        for (int i = 0; i < array.size(); i++) {
            System.out.println("-------------------");

            JsonObject subObject = array.get(i).getAsJsonObject();
            System.out.println("id = " + subObject.get("id").getAsInt());
            System.out.println("ide = " + subObject.get("ide").getAsString());
            System.out.println("name = " + subObject.get("name").getAsString());
        }
    }

    public static void writeJson() throws Exception {
        JsonObject object = new JsonObject();
        object.addProperty("cat", "it");

        JsonArray array = new JsonArray();

        JsonObject lan1 = new JsonObject();
        lan1.addProperty("id", 1);
        lan1.addProperty("name", "java");
        lan1.addProperty("ide", "Eclipse");

        JsonObject lan2 = new JsonObject();
        lan2.addProperty("id", 2);
        lan2.addProperty("name", "Swift");
        lan2.addProperty("ide", "Xcode");

        JsonObject lan3 = new JsonObject();
        lan3.addProperty("id", 3);
        lan3.addProperty("name", "C#");
        lan3.addProperty("ide", "Visual Studio");

        array.add(lan1);
        array.add(lan2);
        array.add(lan3);

        object.add("languages", array);

        object.addProperty("pop",true);

        System.out.println(object);
    }
}
