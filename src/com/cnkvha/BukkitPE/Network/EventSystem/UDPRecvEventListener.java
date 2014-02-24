package com.cnkvha.BukkitPE.Network.EventSystem;

import java.util.EventListener;

public interface UDPRecvEventListener extends EventListener {
	public void onRecv(UDPRecvEvent event);
}
