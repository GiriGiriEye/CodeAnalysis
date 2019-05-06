package com.nju.edu.CodeAnalysis.config;

import java.util.Properties;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileOutputStream;

public class PropertiesLoader {
	
	private Properties config;
	
	private PropertiesLoader() {
		configInit();
	}
	
	private static class PropertiesLoaderInstance {
		private static final PropertiesLoader INSTANCE = new PropertiesLoader();
	}
	
	public static PropertiesLoader getInstance() {
		return PropertiesLoaderInstance.INSTANCE;
	}
	
	private void configInit() {
		try {
			config = new Properties();
			InputStream in = PropertiesLoader.class.getResourceAsStream(("config.properties"));
		
			config.load(in);
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public void setCPUNumber() {	
		try {
			int cpuNumber = Runtime.getRuntime().availableProcessors();
			config.setProperty("cpu_number", String.valueOf(cpuNumber));
			String outFileName = PropertiesLoader.class.getResource(("config.properties")).getFile();
			System.out.println(outFileName);
			FileOutputStream out = new FileOutputStream(outFileName);
			
			config.store(out,"set CPUNumber");
			out.flush();
	        out.close();
			System.out.println(config.toString());
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	public int getCPUNumber() {
		return Integer.parseInt(config.getProperty("cpu_number"));
	}
	
	public String getJobName() {
		return config.getProperty("job_name");
	}
}
