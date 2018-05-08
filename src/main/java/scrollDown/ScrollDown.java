package scrollDown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.tasks.flipkart.Resources.Utilities;

public class ScrollDown {

	public static void main(String[] args) throws InterruptedException {
		Utilities.browserOpen();
		Utilities.launchURL("https://www.flipkart.com/");
		Thread.sleep(2000);
		try {
			Utilities.driver.findElement(By.xpath("//*[text() = '✕']")).click();
		} catch (Exception e) {
			System.out.println("Exception successfully encountered");
		}
		Thread.sleep(2000);

		WebElement siteMapElement = Utilities.driver.findElement(By.linkText("Sitemap"));
		JavascriptExecutor js = (JavascriptExecutor) Utilities.driver;

		// js.executeScript("arguments[0].scrollIntoView();", siteMapElement);
		// Element Not clickable other element would receive the click when
		// using scroll into view

		js.executeScript("window.scrollBy(0,7500)");// works fine
		Thread.sleep(3000);

		siteMapElement.click(); // without using javascriptExecutor the element
								// is available to click

	}

}
