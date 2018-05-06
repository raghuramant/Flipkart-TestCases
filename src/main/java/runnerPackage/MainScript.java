package runnerPackage;

import org.openqa.selenium.By;
import org.tasks.flipkart.Resources.FlipKartAutomationPages;
import org.tasks.flipkart.Resources.Utilities;

public class MainScript {

	public static void main(String[] args) throws InterruptedException {
		Utilities.browserOpen();
		Utilities.launchURL("https://www.flipkart.com/");
		try{
			Utilities.driver.findElement(By.xpath("//*[text() = '✕']")).click();
		}catch(Exception e){
			System.out.println("Exception successfully encountered");
		}
		
		FlipKartAutomationPages.productSearch("Sony LED TV");
		FlipKartAutomationPages.addToCart();
		System.out.println(FlipKartAutomationPages.verifyItemInCart());

	}

}
