package com.org.signup.maven;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignupTest {
	WebDriver driver;

	@BeforeTest
	public void Browser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Selenium\\Geckodriver\\geckodriver.exe\\");
		driver = new FirefoxDriver();
		driver.get("https://signup.com/Register");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='register-fname']")).sendKeys("ABC");
		driver.findElement(By.xpath("//input[@id='register-lname']")).sendKeys("XYZ");
		driver.findElement(By.xpath("//input[@id='register-password']")).sendKeys("1234");
	}

	@Test(priority = 1)

	public void Scroll() throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("scroll(0,800)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		((JavascriptExecutor) driver).executeScript("scroll(0,00)");

	}

	@Test(priority = 2)

	public void MultipleWindow() throws InterruptedException {
		driver.findElement(By.xpath("//button[@type='button']")).click();
		driver.getWindowHandle();
		Set<String> new_window = driver.getWindowHandles();
		for (String child : new_window) 
		{
			driver.switchTo().window(child);
		}
        Thread.sleep(3000);
		System.out.println("Total number of winodws Opened = " + new_window.size());
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(" //a[@class='_42ft _4jy0 _4jy3 _4jy2 selected _51sy']")).click();
		Thread.sleep(5000);
		driver.close();
		Set<String> new_winodw = driver.getWindowHandles();
		System.out.println("Number of windows opened = " + new_window.size());

		for (String window : new_winodw) {
			driver.switchTo().window(window);

		}
		driver.findElement(By.xpath("//input[@id='u_0_k']")).sendKeys("ABC");
		Select day = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		day.selectByValue("3");
		Thread.sleep(1000);
		List<WebElement> days = day.getOptions();

		for (WebElement days_options : days) {
			System.out.println("Days = " + days_options.getText());
		}
		System.out.println("Total number of elements present in the list is " + days.size());

	}

	@Test(priority = 3)

	public void Dropdown2() throws InterruptedException 
	{
		Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		month.selectByValue("6");
		Thread.sleep(2000);
		List<WebElement> months = month.getOptions();
		for (WebElement months_list : months) {
			System.out.println("Months List = " + months_list.getText());
		}

		System.out.println("Total number of elements in the list = " + months.size());
	}
	
	@Test(priority=4)
	public void DropDown3() throws InterruptedException
	{
		Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		year.selectByValue("2014");
		Thread.sleep(2000);
		List<WebElement> year_list = year.getOptions();
		for (WebElement year1 : year_list) 
		{
			System.out.println("Elements in the list = "+year1.getText());
		}
		System.out.println("Total number of elements in the list = "+year_list.size());
	}
  

  @Test(priority=5)
  public void raidoButton() throws InterruptedException
  {
	  Thread.sleep(2000);
	 //driver.findElement(By.xpath("//input[@id='u_0_6' and @xpath='1']")).click();
	  //driver.findElement(By.id("u_0_6")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//button[@id='u_0_12']")).click();
	  Thread.sleep(2000);
	  driver.close();
  }

 /*@Test(priority=6)
 public void ParentWindowClick()
 { 
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 
	 
	 String window = driver.getWindowHandle();
	 
	 
		driver.switchTo().window(window);
	
	 driver.findElement(By.xpath("//span[contains(text(),'Already registered?')]")).click();
	 driver.navigate().back();
	 driver.quit();
 }*/















}

