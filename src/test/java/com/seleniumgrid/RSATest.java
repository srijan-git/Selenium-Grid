package com.seleniumgrid;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class RSATest {
	@Test
	public void HomePageCheck() throws MalformedURLException, URISyntaxException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");

		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URI("http://192.168.0.202:4444").toURL(), capabilities);
			driver.get("https://rahulshettyacademy.com/");
			System.out.println(driver.getTitle());
		} catch (MalformedURLException | URISyntaxException e) {
			System.err.println("Invalid URL or URI syntax: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Error during WebDriver execution: " + e.getMessage());
		} finally {
			if (driver != null) {
				driver.close();
			}
		}
	}

}
