package com.cnkvha.BukkitPE.Network.EventSystem;

import java.util.EventObject;

public class UDPRecvEvent extends EventObject {
	private byte[] packet;
	public UDPRecvEvent(byte[] source) {
		super(source);
		// TODO Auto-generated constructor stub
		this.packet = source;
	}
}
