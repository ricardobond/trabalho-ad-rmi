package ufg.ad.servidor;

import java.rmi.RemoteException;  
import java.rmi.server.UnicastRemoteObject;  

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Tweet;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import ufg.ad.cliente.Mensageiro;

public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro {  
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MensageiroImpl() throws RemoteException {  
        super();  
    }  
	
	private QueryResult pesquisaTweetsComHashtag(String hashtag)
			throws TwitterException {
		Twitter twitter = new TwitterFactory().getInstance();
		Query query = new Query(hashtag);
		query.rpp(20);
		QueryResult resultado;
		resultado = twitter.search(query);
		return resultado;
	}
  
    public void enviarMensagem( String msg ) throws RemoteException {  
        System.out.println( msg );  
    }  
  
    public String lerMensagem() throws RemoteException {  
        return "This is not a Hello World! message";  
    }  
    
    public String listaTweets(String hashtag) throws RemoteException {
        QueryResult resultado = null;
        String resultadoConcatenado = "";
        try {
            resultado = pesquisaTweetsComHashtag(hashtag);
        } catch (TwitterException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for (Tweet tweet : resultado.getTweets()) {
            resultadoConcatenado += "@" + tweet.getFromUser() + " " + tweet.getGeoLocation() + ": " + tweet.getText();
        }
        return resultadoConcatenado;
    }
}