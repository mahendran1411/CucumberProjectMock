package org.stepdefinition;

import org.junit.Assert;
import org.utilities.BaseClass;
import org.utilities.LoginPojo;

import io.cucumber.java.en.*;

public class LoginStepDefinition extends BaseClass {
	@Given("User have to open edge browser and open the instagram application")
	public void user_have_to_open_edge_browser_and_open_the_instagram_application() {
	   launchEdge();
	   loadUrl("https://www.instagram.com/");
	}

	@When("To pass mobilenumber and have to click login button")
	public void to_pass_mobilenumber_and_have_to_click_login_button() {
	    LoginPojo l = new LoginPojo();
	    fill(l.getInstemail(), "0953152764");
	    fill(l.getInstpass(), "6532685");
	    btnClick(l.getInstlog());
	}

	@When("User should print the url")
	public void user_should_print_the_url() {
	    printCurrentUrl();
	}

	@Then("User should navigate to incorrect credential page")
	public void user_should_navigate_to_incorrect_credential_page() {
		String url = driver.getCurrentUrl();
	    Assert.assertTrue("pass",url.contains("instagram") );
	}
	@Given("Maximize the window and waiting for loading")
	public void maximize_the_window_and_waiting_for_loading() {
	    winMax();
	    waitToLoadAllLocators(10);
	}

}
