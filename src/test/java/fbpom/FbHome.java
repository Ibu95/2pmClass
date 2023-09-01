package fbpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import util.FbBase;

public class FbHome extends FbBase {

	public FbHome() {
		PageFactory.initElements(driver, this);
	}

	@FindBys({ @FindBy(id = "email"), @FindBy(xpath = "//input[@name='email']") })
	private WebElement uName;
	@FindAll({ @FindBy(name = "pass"), @FindBy(id = "pss") })
	private WebElement pword;
	@FindBy(name = "login")
	private WebElement lg;

	public WebElement getuName() {
		return uName;
	}

	public WebElement getPword() {
		return pword;
	}

	public WebElement getLg() {
		return lg;
	}

}
