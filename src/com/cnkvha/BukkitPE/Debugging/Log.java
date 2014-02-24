package com.cnkvha.BukkitPE.Debugging;

import com.cnkvha.BukkitPE.Utils.*;

public class Log {
	public static void Info(String s){
		System.out.println("[Info] " + s);
	}
	public static void Error(String s){
		System.out.println("[Error] " + s);
	}
	public static void Debug(String s){
		if(Constants.DEBUG){
			System.out.println("[Debug] " + s);
		}
	}
}
