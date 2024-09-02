/**
 * 
 */
package com.catchup.handler;

import com.catchup.carrier.Message;
import jakarta.json.Json;
import jakarta.websocket.Encoder;
import jakarta.websocket.EndpointConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author Santosh
 *
 */
public class MessageEncoder implements Encoder.Text<Message>{

	final static Logger logger = LogManager.getLogger(MessageEncoder.class);

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void init(EndpointConfig arg0) {
		// TODO Auto-generated method stub
		
	}

	public String encode(Message message) {
		logger.debug("Inside message encoder.");
		return Json.createObjectBuilder().add("content", message.getMessageContent())
		.add("sender", message.getMessageSender())
		.add("received", message.getMessageReceivedAt())
		.add("rcontent", message.getrContent())
		.add("rsender", message.getrSender())
		.add("rreceived", message.getrReceivedAt())
		.add("isemo", message.isEmoticon())
		.build().toString();
	}

	

}
