package menuAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.tasks.flipkart.Resources.FlipKartAutomationPages;
import org.tasks.flipkart.Resources.Utilities;

public class MainScriptMenuAutomation {

	public static void main(String[] args) throws InterruptedException {
		Utilities.browserOpen();
		Utilities.launchURL("https://www.flipkart.com/");
		try {
			Thread.sleep(3000);
			Utilities.driver.findElement(By.xpath("//*[text() = '✕']")).click();
		} catch (Exception e) {
			System.out.println("Exception successfully encountered");
		}
		JavascriptExecutor js = (JavascriptExecutor) Utilities.driver;
		//js.executeScript("window.scrollBy(0,30)");
		//js.executeScript("window.scrollBy(0,-20)");
		Thread.sleep(3000);
	
		FlipKartAutomationPages.navToSubMenu("Sports, Books & More", "Football");
		Thread.sleep(3000);
		Utilities.browserClose();
		
	}

}
