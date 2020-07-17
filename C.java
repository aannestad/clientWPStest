// package inf142;

// Av Hans Martin Aannestad

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class C {
 public static void main(String[] args) throws IOException {
	
 DatagramSocket klientSocket = new DatagramSocket();
 InetAddress IPAdresse = InetAddress.getByName("127.0.0.1"); 
 
 byte[] mottaData = new byte[1024]; 
 
 BufferedReader brukerInnput = new BufferedReader(new InputStreamReader(System.in)); // Lag inputstrøm
 System.out.println("Skriv inn vertsnavn (f.eks: www.wikipedia.org):");
 String setning = brukerInnput.readLine();
 byte[] sendeData = new byte[1024];
 sendeData = setning.getBytes();
 DatagramPacket sendePakke = new DatagramPacket(sendeData, sendeData.length,IPAdresse,6789);
 klientSocket.send(sendePakke);          // Send data til server
 
 DatagramPacket mottaPakke = new DatagramPacket(mottaData, mottaData.length); // Motta fra server
 klientSocket.receive(mottaPakke);
 String mottaSetning = new String(mottaPakke.getData()); 

 System.out.println("Mottatt: " + mottaSetning.trim());
 klientSocket.close();
 }
}
