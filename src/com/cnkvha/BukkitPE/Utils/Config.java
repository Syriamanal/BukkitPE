package com.cnkvha.BukkitPE.Utils;

import java.io.*;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class Config {
	
	public String fname;
	public Yaml yaml;
	public Map<String, Object> data;
	
	public Config(String filename, String defaultConfig) throws Exception{
		File file = new File(filename);
		file = new File(filename);
		if(file.exists() == false){
			try{
				file.createNewFile();
				if(defaultConfig != null){
					BufferedWriter wri = new BufferedWriter(new FileWriter(file));
					wri.write(defaultConfig);
					wri.close();
					wri = null;
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		FileInputStream fs = null;
		try {
			fs = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fs == null){
			throw new Exception("Can not read the config file: " + filename);
		}
		this.yaml = new Yaml();
		this.data = (Map<String, Object>)this.yaml.load(fs);
	}

	public Object get(String key){
		return(this.data.get(key));
	}
	
	public Object set(String key, Object obj){
		return(this.data.put(key, obj));
	}

	public void finalize() throws Throwable{
		File file = new File(this.fname);
		if(file.exists()) file.delete();
		file.createNewFile();
		BufferedWriter wri = new BufferedWriter(new FileWriter(file));
		wri.write(this.yaml.dump(this.data));
		wri.close();
		super.finalize();
	}
}

