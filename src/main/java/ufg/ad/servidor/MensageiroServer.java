package ufg.ad.servidor;

import java.rmi.Naming;  

import ufg.ad.cliente.Mensageiro;

public class MensageiroServer {  
  
    public MensageiroServer() {  
        try {  
            Mensageiro m = new MensageiroImpl();  
            Naming.rebind("rmi://localhost:1099/MensageiroService", m);  
        }  
        catch( Exception e ) {  
            System.out.println( "Trouble: " + e );  
        }  
    }  
  
    public static void main(String[] args) {  
        new MensageiroServer();  
    }  
}