package ufg.ad.servidor;

import java.rmi.RemoteException;  
import java.rmi.server.UnicastRemoteObject;  

import ufg.ad.cliente.Mensageiro;

public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MensageiroImpl() throws RemoteException {  
        super();  
    }  
  
    public void enviarMensagem( String msg ) throws RemoteException {  
        System.out.println( msg );  
    }  
  
    public String lerMensagem() throws RemoteException {  
        return "This is not a Hello World! message";  
    }  
}