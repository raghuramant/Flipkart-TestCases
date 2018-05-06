package runnerPackage;

import org.openqa.selenium.By;
import org.tasks.flipkart.Resources.FlipKartAutomationPages;
import org.tasks.flipkart.Resources.Utilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDef {
	@Given("^User is in Flipart WebPage$")
	public void user_is_in_Flipart_WebPage() throws Throwable {
		Utilities.browserOpen();
		Utilities.launchURL("https://www.flipkart.com/");
		try{
			Utilities.driver.findElement(By.xpath("//*[text() = '✕']")).click();
		}catch(Exception e){
			System.out.println("Exception successfully encountered");
		}
	}

	@When("^User searches an \"([^\"]*)\" and adds it to the cart$")
	public void user_searches_an_and_adds_it_to_the_cart(String item) throws Throwable{ 
		FlipKartAutomationPages.productSearch(item);
		FlipKartAutomationPages.addToCart();
	}

	@Then("^User verifies whether that item is in the cart$")
	public void user_verifies_whether_that_item_is_in_the_cart() throws Throwable {
		Assert.assertTrue(FlipKartAutomationPages.verifyItemInCart());
		System.out.println("The item has been successfully verified");
		Utilities.browserClose();
	}

}
