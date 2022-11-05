package org.openqa.selenium.ie;

import org.openqa.selenium.WebDriver;

public class InternetExplorerDriver implements WebDriver {

	public InternetExplorerDriver() {
		System.out.println("Launching InternetExplorer");
	}

	public void get(String url) {
		System.out.println("Navigating to the " + url + " in InternetExplorer");
	}
	
	public void getTitle() {
		System.out.println("Getting the title from current page in InternetExplorer");
	}

	public void click() {
		System.out.println("Clicking on an Element in InternetExplorer");
	}

	public void sendKeys() {
		System.out.println("Typing in an element in InternetExplorer");
	}
}
