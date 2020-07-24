package com.qa.hubspot.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.utils.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {


	public WebDriver driver;
	
	public Properties prop; 
	
	public OptionsManager optionsManager; 
	public static ThreadLocal <WebDriver> tlDriver=new  ThreadLocal <WebDriver> (); 
	 
	 
	public WebDriver init_driver(Properties prop) {
		
		
	String browserName=prop.getProperty("browser").trim();
		
		System.out.println("Browser name is : " +browserName);
		 optionsManager =new OptionsManager (prop) ; 
		
		if (browserName.equalsIgnoreCase("chrome")) { 
			WebDriverManager.chromedriver().setup();
			//driver =new ChromeDriver (optionsManager.getChromeOptions()) ; 
			tlDriver.set(new ChromeDriver (optionsManager.getChromeOptions()) );
			}
		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//driver =new FirefoxDriver (optionsManager.getFirefoxOptions()) ; 
			tlDriver.set(new FirefoxDriver (optionsManager.getFirefoxOptions()));
			}
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver =new EdgeDriver() ; 
		}
		else {	
			System.out.println("Your browser" +browserName+ " not founded..., please pass valid browser");
		}
		getDriver().manage().deleteAllCookies();  // delete cookies
		getDriver().manage().window().maximize(); //maximize windows 
		getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // 
		getDriver().get(prop.getProperty("url"));
		return getDriver(); 

	}
	
	public static synchronized WebDriver getDriver () {
		
		return tlDriver.get(); 
	}
	
	//help make connection with propoerties
	public Properties init_prop() {
		prop = new Properties();
		String path=null;
		String env= null; 
		
		
		try {
			
			env=System.getProperty("env");
			System.out.println("Running on Environment ---->>" +env);
			
			if (env == null) {
				
				path=".\\src\\main\\java\\com\\qa\\config\\properties\\config.properties";
				}

			else {
				switch (env) {
				case "qa":
					path=".\\src\\main\\java\\com\\qa\\config\\properties\\qa.config.properties"; 
					break;
					
				case "dev":
					path=".\\src\\main\\java\\com\\qa\\config\\properties\\dev.config.properties"; 
					break;
				case "stage":
					path=".\\src\\main\\java\\com\\qa\\config\\properties\\stage.config.properties"; 
					break;
				default:
					System.out.println("Please pass the correct env value  ....");
					break;
				}
			}
			
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	//take screenshot:
		public String getScreenshot(){
			File src  = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
			String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
			File destination = new File(path);
			try {
				FileUtils.copyFile(src, destination);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return path;
		}
	

}
