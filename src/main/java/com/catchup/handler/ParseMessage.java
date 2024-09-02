/**
 * 
 */
package com.catchup.handler;

import com.catchup.carrier.Message;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.websocket.Decoder;
import jakarta.websocket.EndpointConfig;

import java.io.StringReader;
import java.time.LocalTime;

/**
 * @author Santosh
 *
 */
public class ParseMessage implements Decoder.Text<Message> {

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	public Message decode(String messageString) {
		LocalTime lt = LocalTime.now();
		JsonObject jsonObject = Json.createReader(new StringReader(messageString)).readObject();
        return new Message(jsonObject.getString("sender"), jsonObject.getString("content"),
				lt.getHour() + ":" + lt.getMinute(), jsonObject.getString("rsender"), jsonObject.getString("rcontent"),
				jsonObject.getString("rreceived"),jsonObject.getBoolean("isemo"));
	}

	public boolean willDecode(String arg0) {
		return true;
	}

	

}
