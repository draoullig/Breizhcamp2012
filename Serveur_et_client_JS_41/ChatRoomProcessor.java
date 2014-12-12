package com.arkea.serveur.processor;

import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import org.apache.thrift.TException;

import com.arkea.thrift.data.exception.ServiceException;
import com.arkea.thrift.data.message.Message;
import com.arkea.thrift.data.utilisateur.Utilisateur;
import com.arkea.thrift.service.chatroom.ChatRoomService;


public class ChatRoomProcessor implements ChatRoomService.Iface{

	private Hashtable<String, Utilisateur> lstUtilisateurs = 
            new Hashtable<String, Utilisateur>();
	
	private LinkedList<Message> lstMessages = new LinkedList<Message>();
	
	@Override
	public List<Message> getListeMessage() throws TException,ServiceException {
		return lstMessages;
	}

	@Override
	public void envoyerMessage(Message message) throws TException,ServiceException {
		System.out.println(message.getContenu());
		addMessage(message);
		
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
	
	private synchronized void addMessage(Message message) 
            throws ServiceException {
	  try {
	    if (message.getUtilisateur().getMotdepasse().equals(
	          lstUtilisateurs.get(message.getUtilisateur().
	          getPseudo()).getMotdepasse())) {
	      if (lstMessages.size() == 20) {
	        lstMessages.remove(0);
	      }
	      lstMessages.add(message);   
	    } else {
	      throw new ServiceException("err2", 
	        "Identité non valide lors d'un ajout de message !");
	    }
	  } catch(Exception e) {
	    throw new ServiceException("err3", 
	      "Erreur technique lors d'un ajout de message !");
	  }
	}

}

