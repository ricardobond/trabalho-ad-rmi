package ufg.ad.cliente;

import java.rmi.Naming;  
import java.rmi.RemoteException;  
import java.rmi.NotBoundException;  
import java.net.MalformedURLException;  

import twitter4j.QueryResult;
import twitter4j.Tweet;
  
public class MensageiroClient {

    public static void main(String args[]) {
        try {
            Mensageiro m = (Mensageiro) Naming.lookup("rmi://localhost/MensageiroService");
            System.out.println(m.lerMensagem());
            System.out.println(m.listaTweets("#asminapira"));
            m.enviarMensagem("Hello World!");

        } catch (MalformedURLException e) {
            System.out.println();
            System.out.println("MalformedURLException: " + e.toString());
        } catch (RemoteException e) {
            System.out.println();
            System.out.println("RemoteException: " + e.toString());
        } catch (NotBoundException e) {
            System.out.println();
            System.out.println("NotBoundException: " + e.toString());
        } catch (Exception e) {
            System.out.println();
            System.out.println("Exception: " + e.toString());
        }
    }
}