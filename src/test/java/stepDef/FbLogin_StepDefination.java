package stepDef;

import org.junit.Assert;

import fbpom.FbHome;
import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import util.FbBase;

public class FbLogin_StepDefination extends FbBase {
	public static FbHome f;

	@Given("User Load the URL")
	public void user_load_the_url() {
		loadUrl("https://www.facebook.com/");
		f = new FbHome();
	}

	@When("User Enter the UserName")
	public void user_enter_the_user_name() {
		f.getuName().sendKeys("Shivin");
	}

	@Given("User Open the Chrome Browser")
	public void a() {
		browserOpen("Chrome");

	}

	@When("User Enter the Invalid UserName")
	public void user_enter_the_invalid_user_name() {
		f.getuName().sendKeys("Shivin1");
	}

	@When("User Enter the Invalid Password")
	public void user_enter_the_invalid_password() {
		f.getPword().sendKeys("Tech1");
	}

	@When("User Enter the Password")
	public void user_enter_the_password() {
		f.getPword().sendKeys("Tech");
	}

	@When("User Click the Login button")
	public void user_click_the_login_button() {
		f.getLg().click();
	}

	@Then("Login Sucess")
	public void login_sucess() {
		System.out.println("Login Done");
	}

	@Then("Login Sucess valid")
	public void login_sucess_valid() {
		Assert.fail();
	}

	@Then("User Close the Browser")
	public void user_close_the_browser() {
		driver.quit();
	}

	@When("User Enter the UserName {string}")
	public void user_enter_the_user_name(String string) {
		f.getuName().sendKeys(string);
	}

	@When("User Enter the Password {string}")
	public void user_enter_the_password(String string) {
		f.getPword().sendKeys(string);
	}

	@Given("User Open the Edge")
	public void user_open_the_edge() {
		browserOpen("edge");

	}

}
