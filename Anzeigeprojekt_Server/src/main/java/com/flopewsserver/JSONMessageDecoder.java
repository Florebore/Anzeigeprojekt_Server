/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver;

import java.io.IOException;
import java.io.Reader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

/**
 *
 * @author Florian
 */

//TODO Einbinden in COde
public class JSONMessageDecoder implements Decoder.TextStream<JsonObject> {

    @Override
    public void init(EndpointConfig config) {
    }

    @Override
    public JsonObject decode(Reader reader) throws DecodeException, IOException {
        try (JsonReader jsonReader = Json.createReader(reader)) {
            return jsonReader.readObject();
        }
    }

    @Override
    public void destroy() {
    }

   }
    

