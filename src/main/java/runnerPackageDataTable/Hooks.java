package runnerPackageDataTable;

import org.tasks.flipkart.Resources.Utilities;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends Utilities{
	@Before
	public void browserLaunch(){
		Utilities.browserOpen();
		
	}
	@After
	public void browserQuit(){
		Utilities.browserClose();
	}

}
