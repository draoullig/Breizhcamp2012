package com.arkea.serveur.servlet;

import org.apache.thrift.protocol.TJSONProtocol;
import org.apache.thrift.server.TServlet;
import com.arkea.serveur.processor.ChatRoomProcessor;
import com.arkea.thrift.service.chatroom.ChatRoomService;

public class ChatRoomServlet extends TServlet {

	private static final long serialVersionUID = 1L;

	public ChatRoomServlet() {
		super(new ChatRoomService.Processor<ChatRoomService.Iface>(
				new ChatRoomProcessor()), new TJSONProtocol.Factory());
	}

}

