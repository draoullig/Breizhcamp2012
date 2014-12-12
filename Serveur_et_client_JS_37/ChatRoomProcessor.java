package com.arkea.serveur.processor;

import java.util.Hashtable;
import java.util.List;
import org.apache.thrift.TException;
import com.arkea.thrift.data.exception.ServiceException;

import com.arkea.thrift.data.message.Message;
import com.arkea.thrift.data.utilisateur.Utilisateur;
import com.arkea.thrift.service.chatroom.ChatRoomService;


public class ChatRoomProcessor implements ChatRoomService.Iface{

	private Hashtable<String, Utilisateur> lstUtilisateurs = 
            new Hashtable<String, Utilisateur>();
	
	@Override
	public List<Message> getListeMessage() throws TException,ServiceException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void envoyerMessage(Message message) throws TException,ServiceException {
		System.out.println(message.getContenu());
		
	}

	@Override
	public void enregistrerUtilisateur(Utilisateur utilisateur)
			throws TException,ServiceException {
		
		if(!lstUtilisateurs.containsKey(utilisateur.getPseudo())) {
		    lstUtilisateurs.put(utilisateur.getPseudo(), utilisateur);
		} else {
		    throw new ServiceException("err1","Pseudo déjà existant !");
		}
		
	}
	

}

