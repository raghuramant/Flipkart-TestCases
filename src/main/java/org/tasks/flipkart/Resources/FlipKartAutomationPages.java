package org.tasks.flipkart.Resources;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKartAutomationPages extends Utilities {
	static String parentWindowID;
	static String allWindowsID;

	public static void productSearch(String productName) throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(productName);
		driver.findElement(By.xpath("//*[@type = 'submit']")).click();
		parentWindowID = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement itemToBeSentToCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[1]/div[2]/div/a[1]/div[1]/div")));
		itemToBeSentToCart.click();

	}
	
	public static void addToCart() throws InterruptedException{
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String currentWindowID : allWindowsID) {
			if(!currentWindowID.equals(parentWindowID))
				driver.switchTo().window(currentWindowID);
		}
			
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement addToCart = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = '_2AkmmA _2Npkh4 _2MWPVK']")));
		addToCart.click();
		//driver.findElement(By.xpath("//*[@class = '_2AkmmA _2Npkh4 _2MWPVK']")).click();
		//driver.findElement(By.xpath("//span[@class = 'DJrnBo' and contains(text(), 'Cart')]")).click();
		Thread.sleep(1000);
		
	}
	
	public static boolean verifyItemInCart(){
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement linkTextElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/a")));
		boolean textDisplayed = linkTextElement.isDisplayed();
		return textDisplayed;
		
	}

}
