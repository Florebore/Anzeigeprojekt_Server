/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver;


import java.io.IOException;
import java.io.Writer;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

//TODO in Code einbauen

public class MessageEncoder implements Encoder.TextStream<JsonObject> {

    @Override
    public void init(EndpointConfig config) {}

    @Override
    public void encode(JsonObject payload, Writer writer) throws EncodeException, IOException {
        try (JsonWriter jsonWriter = Json.createWriter(writer)) {
            jsonWriter.writeObject(payload);
        }
    }

    @Override
    public void destroy() {}
}


@ServerEndpoint(value = "/changes", encoders = {JsonEncoder.class})
public class ToDoChangeTracker {

    private Session session;

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
    }

    @OnClose
    public void onClose() {
        this.session = null;
    }

    public void onToDoChange([...]) throws EncodeException {
        if (this.session != null && this.session.isOpen()) {
            try {

                JsonObject event = Json.createObjectBuilder().
                        add("name",[...]).
                        build();
                this.session.getBasicRemote().sendObject(event);

            } catch (IOException ex) {
                //we ignore this
            }
        }
    }

}

