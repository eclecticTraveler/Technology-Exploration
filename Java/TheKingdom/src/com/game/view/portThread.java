package com.game.view;
import java.net.*;

public class portThread extends Thread {
	
   private String host;
   private int port;
   
   // constructor
   public portThread(String host, int port){
	   this.host= host;
	   this.port = port;
   }
   
   
   // one way to run thread
   public void run(){
	   try {
			Socket socket = new Socket(host,port);
			System.out.println("Print " + port + " is open....!");
			socket.close();
			return;
		   }catch (Exception e2) {
			   System.out.println("Port " + port + " is not open..!");
		  }
   }
}
