package webpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="login-form")
    WebElement loginForm;

	@FindBy(xpath="//*[@id='login-form']/fieldset/label[1]/input")
	WebElement username;

	@FindBy(xpath="//*[@id='login-form']/fieldset/label[2]/input")
	WebElement password;

	@FindBy(xpath="//*[@id='login-form']/fieldset/button")
	WebElement loginButton;


	public void formDisplay() throws Throwable {
		loginForm.isDisplayed();
	}

	public void enterUsername(String name) throws Throwable {
	    username.clear();
	    username.sendKeys(name);
	}

	public void enterPassword(String pass) throws Throwable {
	    password.clear();
	    password.sendKeys(pass);
	}

	public void clickLogin() throws Throwable {
	    loginButton.click();
	}

}
