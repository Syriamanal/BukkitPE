package com.cnkvha.BukkitPE.Network;

import java.io.IOException;
import java.net.*;
import java.util.Vector;

import com.cnkvha.BukkitPE.Debugging.Log;
import com.cnkvha.BukkitPE.Network.EventSystem.UDPRecvEventListener;

public class UDPListener extends Thread {
	private SocketAddress localAddr;
	private DatagramSocket socket;
	
	private InetAddress LocalAddr;
	private int Port = 0;
	
	private Vector repo = new Vector();
	
	public UDPListener(String IP, int port) throws UnknownHostException
	{
		this.LocalAddr = InetAddress.getByName(IP);
		this.Port = port;
		try {
			this.socket = new DatagramSocket();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Log.Error("Socket creation faild on " + IP + ":" + Port);
		}
	}
	
	public void registerRecvEvent(UDPRecvEventListener l){
		this.repo.addElement(l);
	}
	
	public void sendTo(byte[] buff, String ip, int port) throws IOException{
		DatagramPacket p = new DatagramPacket(buff, buff.length, InetAddress.getByName(ip), port);
		this.socket.send(p);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
