package com.qa.opencart.driverFactory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
	public OptionsManager(Properties prop) {
		this.prop=prop;
	}

	public ChromeOptions getChromeOptions() {
		co=new ChromeOptions();
		if (Boolean.parseBoolean(prop.getProperty("headless"))){
			System.out.println("....Running on headless mode...");
			co.setHeadless(true);
	
		}
		if (Boolean.parseBoolean(prop.getProperty("incognito"))){
			System.out.println("....Running on incognito mode...");
             co.addArguments("---incognito");
             
	}
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		fo=new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println("....Running on headless mode...");

			fo.setHeadless(true);
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			System.out.println("....Running on incognito mode...");
			fo.addArguments("--incognito");
		}
		return fo;
	
	}
	public EdgeOptions getEdgeOptions() {
		eo=new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			System.out.println("....Running on headless mode...");
			eo.setHeadless(true);
		}
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			System.out.println("....Running on incognito mode...");

			eo.addArguments("--incognito");
		}
		return eo;
	}

}
		



