package ufg.ad.cliente;

import java.io.Serializable;
import java.rmi.Remote;  
import java.rmi.RemoteException;  

import twitter4j.QueryResult;
import twitter4j.TwitterException;
  
public interface Mensageiro extends Remote, Serializable {  
  
    public void enviarMensagem( String msg ) throws RemoteException;  
    public String lerMensagem() throws RemoteException;  
    public String listaTweets(String hashtag) throws RemoteException;
}