package com.cnkvha.BukkitPE;

import org.yaml.snakeyaml.Yaml;

import com.cnkvha.BukkitPE.Debugging.*;
import com.cnkvha.BukkitPE.Utils.*;

public class BukkitPE {
	public static void main(String[] args) throws Exception{
		Definations.config = new Config("server.properties", Constants.SERVERPROPERTIES_PRESET);
		Definations.ServerPort = Integer.parseInt(Definations.config.get("server-port").toString());
		Log.Info("Starting Minecraft PE server on UDP port " + Definations.config.get("server-port"));
		
	}
}
