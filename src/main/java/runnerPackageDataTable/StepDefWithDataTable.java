package runnerPackageDataTable;

import java.util.List;

import org.openqa.selenium.By;
import org.tasks.flipkart.Resources.FlipKartAutomationPages;
import org.tasks.flipkart.Resources.Utilities;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefWithDataTable {
	List<String> dataList;

	@Given("^User navigates to Flipart WebPage$")
	public void user_navigates_to_Flipart_WebPage() throws Throwable {

		Utilities.launchURL("https://www.flipkart.com/");
		try {
			Utilities.driver.findElement(By.xpath("//*[text() = '✕']")).click();
		} catch (Exception e) {
			System.out.println("Exception successfully encountered");
		}
	}

	@When("^User searches item and adds it to the cart$")
	public void user_searches_an_item_and_adds_it_to_the_cart_individually(DataTable userData) throws Throwable {
		dataList = userData.asList(String.class);
		for (String individualItem : dataList) {
			FlipKartAutomationPages.productSearch(individualItem);
			FlipKartAutomationPages.addToCart();

		}

	}

	@Then("^User wants to verifies whether the items are available in the cart$")
	public void user_wants_to_verifies_whether_that_item_is_in_the_cart() throws Throwable {
		for (int i = 1; i <= dataList.size(); i++) {

			Assert.assertTrue(FlipKartAutomationPages.verifyListOfItemsInCart(i));
		}
		System.out.println("All available items in the cart has been successfully verified");
	}

}
