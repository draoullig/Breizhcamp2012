package com.arkea.serveur.processor;

import java.util.List;

import org.apache.thrift.TException;

import com.arkea.thrift.data.message.Message;
import com.arkea.thrift.data.utilisateur.Utilisateur;
import com.arkea.thrift.service.chatroom.*;


public class ChatRoomProcessor implements ChatRoomService.Iface{

	@Override
	public List<Message> getListeMessage() throws TException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void envoyerMessage(Message message) throws TException {
		System.out.println(message.getContenu());
		
	}

	@Override
	public void enregistrerUtilisateur(Utilisateur utilisateur)
			throws TException {
		System.out.println(utilisateur.getPseudo());
		
	}
	

}

