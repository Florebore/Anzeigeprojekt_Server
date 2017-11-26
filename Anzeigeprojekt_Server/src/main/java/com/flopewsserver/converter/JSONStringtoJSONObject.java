/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver.converter;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 *
 * @author Florian
 */
public class JSONStringtoJSONObject {
    
    
    public JsonObject JSONStringtoJSONObject(String JSONString){

    
        JsonObject object;
        try (JsonReader jsonReader = Json.createReader(new StringReader(JSONString))) {
            object = jsonReader.readObject();
            jsonReader.close();
        }

    return object;
    
}
}