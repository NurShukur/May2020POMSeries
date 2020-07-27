package com.qa.hubspot.utils;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {

	Properties prop; 
	ChromeOptions co;
	FirefoxOptions fo;
	EdgeOptions eg; 
public OptionsManager (Properties prop) {
	
	this.prop=prop;
	
}

public ChromeOptions getChromeOptions () {
	
	 co = new ChromeOptions();
	if (Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless") ;
	if (Boolean.parseBoolean(prop.getProperty("incognito"))) co.addArguments("--incognito") ;
	
	return co; 
	
}

public FirefoxOptions getFirefoxOptions () {
	
	 fo = new FirefoxOptions();
	if (Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless") ;
	
	return fo; 
	
}

public EdgeOptions getEdgeOptions () {
	
	 eg = new EdgeOptions();
	if (Boolean.parseBoolean(prop.getProperty("headless"))) co.addArguments("--headless") ;
	
	return eg; 
	
}
}
