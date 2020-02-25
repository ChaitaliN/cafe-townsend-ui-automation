package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.Before;
import cucumber.api.java.After;
import driver.Framework;
import webpage.CreatePage;
import webpage.HomePage;
import webpage.LoginPage;

public class Create {

    String adminUsername = "Luke";
    String adminPassword = "Skywalker";

    public Framework framework;
    public LoginPage loginPage;
    public HomePage homePage;
    public CreatePage createPage;

    @Before()
    public void setup() {
        framework = new Framework();
        loginPage = new LoginPage(framework.getDriver());
        homePage = new HomePage(framework.getDriver());
        createPage = new CreatePage(framework.getDriver());
    }

	@Given("^I am logged in as Luke$")
	public void i_am_logged_in_as_luke() throws Throwable {
        this.loginPage.formDisplay();
        this.loginPage.enterUsername(this.adminUsername);
        this.loginPage.enterPassword(this.adminPassword);
        this.loginPage.clickLogin();
	}

	@Given("^I am on the landing page$")
	public void i_am_on_the_landing_page() throws Throwable {
        this.homePage.employeeListDisplay();
	}

	@When("^I click the Create button$")
	public void i_click_the_create_button() throws Throwable {
        this.homePage.clickCreateButton();
	}

    @When("^I enter employee firstname \"([^\"]*)\"$")
    public void i_enter_employee_firstname(String firstName) throws Throwable {
        this.createPage.enterFirstName(firstName);
    }

    @When("^I enter employee lastname \"([^\"]*)\"$")
    public void i_enter_employee_lastname(String lastName) throws Throwable {
        this.createPage.enterLastName(lastName);
    }

    @When("^I enter employee startDate \"([^\"]*)\"$")
    public void i_enter_employee_startDate(String startDate) throws Throwable {
        this.createPage.enterStartDate(startDate);
    }

    @When("^I enter employee email \"([^\"]*)\"$")
    public void i_enter_employee_email(String email) throws Throwable {
        this.createPage.enterEmail(email);
    }

	@When("^I click on Add button$")
	public void user_submit_the_Create_form() throws Throwable {
        this.createPage.clickAddButton();
	}

    @When("^I select newly created employee name from the list \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_select_newly_created_employee_name_from_the_list(String firstName,
            String lastName) throws Throwable {
        this.homePage.doubleClickNameFromList(firstName, lastName);
    }

    @Then("^I should see correct details for newly created employee \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\", \"([^\"]*)\"$")
    public void i_should_see_correct_details_for_newly_created_employee(String firstName,
            String lastName, String startDate, String email) throws Throwable {
	    this.createPage.assertFirstName(firstName);
	    this.createPage.assertLastName(lastName);
	    this.createPage.assertStartDate(startDate);
	    this.createPage.assertEmail(email);
    }

	@Then("^I fail to create new employee$")
	public void i_fail_to_create_new_employee() throws Throwable {
	    this.createPage.checkAddBtnDisable();
	    this.createPage.acceptAlert();
	}

	@When("^I click on Cancel button$")
	public void i_click_on_cancel_button() throws Throwable {
	    this.createPage.clickCancelButton();
	}

	@Then("^I should go back to home page$")
	public void i_should_go_back_to_home_page() throws Throwable {
	    this.homePage.employeeListDisplay();
	}

	@After
	public void teardown() {
        this.framework.closeDriver();
	}
}
