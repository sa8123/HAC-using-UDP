package edu.truman.serverside;
import edu.truman.serverside.*;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;

public class ServerSide 
{
	DatagramSocket socket = null;
	//Constructor
	public ServerSide()
	{
		
	}
	
	public void listenToSocket() 
	{
		try 
		{
			socket = new DatagramSocket(9876);
			byte [] incomingData = new byte[1024];
			//ArrayList<ClientInformation> ipArray = new ArrayList<ClientInformation>();
			ArrayList<InetAddress> ipArray = new ArrayList<InetAddress>();
			while(true) 
			{
				// Declaring the socket to receive data and store the message in message.
				DatagramPacket receivePacket = new DatagramPacket(incomingData, incomingData.length);
				System.out.println("--------Server is listening ----------\n");
				socket.receive(receivePacket);
				String message = new String(receivePacket.getData());
				InetAddress address = receivePacket.getAddress();
				int port = receivePacket.getPort();
				System.out.println("Received message from client: " + message);
                System.out.println("Client IP:"+ address.getHostAddress());
                System.out.println("Client port: "+ port);
                ipArray.add(address);
                //System.out.println("First element of database " + ipArray.get(0));
                String response = (ipArray.get(0)).toString();
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, address, port);
                socket.send(sendPacket);
				/*
				 * if(ipArray.contains(address)) { System.out.println("Welcome back!:"
				 * +address); } else { ipArray.add(address); }
				 */
                Thread.sleep(2000);
                
                //Check if the client is already registered.
                	
                	
                //socket.close();
				
				
			}
		} 
		catch (SocketException e) 
		{	
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		catch(IndexOutOfBoundsException e) 
		{
			e.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		ServerSide theServer = new ServerSide();
		theServer.listenToSocket();

	}

}
