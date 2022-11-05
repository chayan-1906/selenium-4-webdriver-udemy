package org.openqa.selenium.firefox;

import org.openqa.selenium.WebDriver;

public class FirefoxDriver implements WebDriver {
	
	public FirefoxDriver() {
		System.out.println("Launching Firefox");
	}

	public void get(String url) {
		System.out.println("Navigating to the " + url + " in Firefox");
	}

	public void getTitle() {
		System.out.println("Getting the title from current page in Firefox");
	}

	public void click() {
		System.out.println("Clicking on an Element in Firefox");
	}

	public void sendKeys() {
		System.out.println("Typing in an element in Firefox");
	}

}
