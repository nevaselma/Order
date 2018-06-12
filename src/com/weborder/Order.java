package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hurig\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");

				WebDriver driver = new ChromeDriver();
				driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
				
				driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
				driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
				driver.findElement(By.name("ctl00$MainContent$login_button")).click();
				
				Thread.sleep(2000);
				driver.findElement(By.linkText("Order")).click();
				
				
				Random rg = new Random();
				int randomInt = rg.nextInt(100)+1;
				System.out.println(randomInt);
				
				
				String alphabet= "abcdefghijklmnopqrstuvwxyz";
		        String s = "";
		        Random random = new Random();
		        int randomLen = random.nextInt(5)+1;
		        for (int i = 0; i < randomLen; i++) {
		            char c = alphabet.charAt(random.nextInt(26));
		            s+=c;
		        }
		         
		        System.out.println(s);
	      
				     
				
				
				Thread.sleep(2000);
				
				driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(Keys.BACK_SPACE);
				
				driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(String.valueOf(randomInt));
				
				driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John " + s + " Smith");
				driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any St");
				driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Anytown");
				driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("VA");
				driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("50000");
				
				Thread.sleep(1000);
				
				int cardChoice = rg.nextInt(3)+1;
				System.out.println(cardChoice);
				
				switch(cardChoice) {
				case 1:{
					driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
					String numbers= "0123456789";
					String s2 = "4";
			        for (int i = 0; i < 15; i++) {
			            char c = numbers.charAt(random.nextInt(10));
			            s2+=c;
			        }
			        System.out.println(s2);
			       driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(s2);
					break;
				}
					
				case 2:{
					driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
					String numbers= "0123456789";
					String s2 = "5";
			        for (int i = 0; i < 15; i++) {
			            char c = numbers.charAt(random.nextInt(10));
			            s2+=c;
			        }
			        System.out.println(s2);
			       driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(s2);
					break;
				}
				case 3:{
					driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
					String numbers= "0123456789";
					String s2 = "3";
			        for (int i = 0; i < 14; i++) {
			            char c = numbers.charAt(random.nextInt(10));
			            s2+=c;
			        }
			        System.out.println(s2);
			       driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(s2);
					break;
				}
				}
				
				
				driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("10/20");
				Thread.sleep(2000);
				driver.findElement(By.linkText("Process")).click();
				
				
				
				String expected = "New order has been successfully added";
				String actual =driver.findElement(By.xpath("//*[@id=\"ctl00_MainContent_fmwOrder\"]/tbody/tr/td/div/strong")).getText();
				 
				if(actual.contains(expected)){
					System.out.println("pass");
				}
				else {
					System.out.println("fail");
					System.out.println("Expected:\t" + expected);
					System.out.println("Actual: \t" + actual);
				}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}