// package inf142;

//Av Hans Martin Aannestad

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

public class WPS {
 public static void main(String[] args) throws IOException {

  DatagramSocket serverSocket = new DatagramSocket(6789);
  byte[] mottaData = new byte[1024];
  byte[] dataTilK = new byte[1024];

  while(true){
     DatagramPacket mottaPakke = new DatagramPacket(mottaData, mottaData.length);
	 serverSocket.receive(mottaPakke);                                               // Motta pakke
	 
	 String setning = new String(mottaPakke.getData());
	 String vertsnavn = setning;
	 String stinavn = "/";   // Kun implementert standard
	 
	 InetAddress IPAdresse = mottaPakke.getAddress();    // Hent (klient) avsenders IP-adresse
	 int port = mottaPakke.getPort();                    // Hent (klient) avsenders Port
	 
	 InetAddress vertsAdresse = InetAddress.getByName(vertsnavn);
	 Socket klientTCPSocket = new Socket(vertsAdresse,80); 
	                                                                  // Web server TCP socket:
	 DataOutputStream utTilServer = new DataOutputStream(klientTCPSocket.getOutputStream());
	 BufferedReader innFraServer = new BufferedReader(new InputStreamReader(klientTCPSocket.getInputStream()));
	 //setning = innFraServer.readLine();
	 	 
	 //utTilServer.writeBytes(setning + '\n');
	 utTilServer.writeBytes("HEAD / HTTP/1.1\r\n");
	 utTilServer.writeBytes("Accept: text/html, text/*\r\n\r\n");
	 	    
	 String neste; String hentData = "";              // Hent ut data linje for linje           
	 while((neste = innFraServer.readLine()) != null) { hentData = hentData + neste + "\n"; }
	 klientTCPSocket.close();
	 
	 dataTilK = hentData.getBytes();       // Konverter data for å sende med datagram
	 
	 DatagramPacket sendPakke = new DatagramPacket(dataTilK, dataTilK.length, IPAdresse, port);  // Datagram til klient
	 serverSocket.send(sendPakke);  // Skriv ut datagram til socket
     
  }
 }
}

