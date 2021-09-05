package com.practice.vtiger;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Tester1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("12345");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

		driver.findElement(By.name("accountname")).sendKeys("SDET20_1");

		WebElement industry = driver.findElement(By.name("industry"));
		Select select = new Select(industry);
		select.selectByVisibleText("Banking");

		WebElement rating = driver.findElement(By.name("rating"));
		Select select1 = new Select(rating);
		select1.selectByIndex(2);

		WebElement type = driver.findElement(By.name("accounttype"));
		Select select2 = new Select(type);
		select2.selectByValue("Customer");

		driver.findElement(By.xpath("//input[@value= '  Save  ']")).click();
		//driver.findElement(By.linkText("Sign Out")).click();

		driver.quit();
	}

}
