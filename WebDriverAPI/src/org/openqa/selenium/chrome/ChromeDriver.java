package org.openqa.selenium.chrome;

import org.openqa.selenium.WebDriver;

public class ChromeDriver implements WebDriver {

	public ChromeDriver() {
		System.out.println("Launching Chrome");
	}

	public void get(String url) {
		System.out.println("Navigating to the " + url + " in Chrome");
	}

	public void getTitle() {
		System.out.println("Getting the title from current page in Chrome");
	}

	public void click() {
		System.out.println("Clicking on an Element in Chrome");
	}

	public void sendKeys() {
		System.out.println("Typing in an element in Chrome");
	}
}
