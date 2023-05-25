package com.exam.spring05;

import java.util.Properties;

public class App {

	public static void main(String[] args) {
		Properties configs = new Properties();
		configs.put("server", "192.168.1.100");
		configs.put("connectionTime", "5000");
		
		BoardPropertiesTO configsTO = new BoardPropertiesTO();
		configsTO.setConfigs(configs);
		
		Properties newConfigs = configsTO.getConfigs();
		
		System.out.println(newConfigs.getProperty("server"));
		System.out.println(newConfigs.getProperty("connectionTime"));
	}

}
