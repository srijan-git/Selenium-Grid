package com.seleniumgrid;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class GoogleTest {

	@Test
	public void HomePageCheck() throws MalformedURLException, URISyntaxException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("safari");

		WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URI("http://192.168.0.202:4444").toURL(), capabilities);
			driver.get("https://google.com");
			System.out.println(driver.getTitle());
			driver.findElement(By.name("q")).sendKeys("Srijan-git");
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
