package edu.truman.serverside;

import java.net.InetAddress;

public class ClientInformation 
{
	private InetAddress ip;
	private int port;
	public ClientInformation() 
	{
		
	}
	
	// Constructor initialize the values
	public ClientInformation(InetAddress ip, int port) 
	{
		this.ip = ip;
		this.port = port;
	}
	
	public InetAddress getIp() 
	{
		return ip;
	}
	public void setIp(InetAddress ip) 
	{
		this.ip = ip;
	}
	public int getPort() 
	{
		return port;
	}
	public void setPort(int port) 
	{
		this.port = port;
	}
	public String toString() 
	{
		return "Client: " + getIp() + " and " +getPort() + "has connected";
	}

}
