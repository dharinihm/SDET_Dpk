package com.practice.vtiger;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;

public class Tester3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		String parentwid = driver.getWindowHandle();
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("12345");
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();

		driver.findElement(By.name("lastname")).sendKeys("Shalini");

		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img[@alt= 'Select']")).click();
		Set<String> wids = driver.getWindowHandles();
		for (String wid : wids) {
			if (!(wid.equals(parentwid) )) {
				driver.switchTo().window(wid);
				break;
			}
			driver.findElement(By.linkText("SDET20_1")).click();
			driver.switchTo().window(parentwid);

		}

		driver.findElement(By.xpath("//input[@value= '  Save  ']")).click();
		WebElement admin = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Action action = new Action(driver);
	
		// driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}

}
