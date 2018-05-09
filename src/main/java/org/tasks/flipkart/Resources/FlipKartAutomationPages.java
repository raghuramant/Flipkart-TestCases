package org.tasks.flipkart.Resources;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKartAutomationPages extends Utilities {
	static String parentWindowID;
	static String allWindowsID;
	static Actions act;

	public static void productSearch(String productName) throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(productName);
		driver.findElement(By.xpath("//*[@type = 'submit']")).click();
		parentWindowID = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement itemToBeSentToCart = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[1]/div[2]/div/a[1]/div[1]/div")));
		itemToBeSentToCart.click();

	}

	public static void addToCart() throws InterruptedException {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String currentWindowID : allWindowsID) {
			if (!currentWindowID.equals(parentWindowID))
				driver.switchTo().window(currentWindowID);
		}

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement addToCart = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = '_2AkmmA _2Npkh4 _2MWPVK']")));
		addToCart.click();
		// driver.findElement(By.xpath("//*[@class = '_2AkmmA _2Npkh4
		// _2MWPVK']")).click();
		// driver.findElement(By.xpath("//span[@class = 'DJrnBo' and
		// contains(text(), 'Cart')]")).click();
		Thread.sleep(1000);

	}

	public static boolean verifyItemInCart() {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement linkTextElement = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/a")));
		boolean textDisplayed = linkTextElement.isDisplayed();
		return textDisplayed;

	}

	public static boolean verifyListOfItemsInCart(int ref) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement linkTextElement = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[2]/div[" + ref + "]/div[1]/div[1]/div[1]/a")));
		boolean textDisplayed = linkTextElement.isDisplayed();
		return textDisplayed;

	}

	public static void navToSubMenu(String mainMenu, String subMenu) throws InterruptedException {

		String mainMenuReference = "//span[text() = '$']";
		String mainMenuLocator = mainMenuReference.replace("$", mainMenu);

		WebElement mainMenuElement = driver.findElement(By.xpath(mainMenuLocator));

		act = new Actions(driver);

		if (mainMenu.contains("Sports,")) {
			act.moveToElement(driver.findElement(By.linkText("Login & Signup"))).build().perform();
		}
		act.moveToElement(mainMenuElement).build().perform();
		Thread.sleep(2000);

		String subMenuReference = "//a/span[text()='$']";
		String subMenuLocator = subMenuReference.replace("$", subMenu);

		WebElement subMenuElement = driver.findElement(By.xpath(subMenuLocator));
		act.moveToElement(subMenuElement).click().build().perform();

	}

}
