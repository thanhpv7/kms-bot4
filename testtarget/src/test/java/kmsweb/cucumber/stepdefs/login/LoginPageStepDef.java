/*
 * @bot-written
 *
 * WARNING AND NOTICE
 * Any access, download, storage, and/or use of this source code is subject to the terms and conditions of the
 * Full Software Licence as accepted by you before being granted access to this source code and other materials,
 * the terms of which can be accessed on the Codebots website at https://codebots.com/full-software-licence. Any
 * commercial use in contravention of the terms of the Full Software Licence may be pursued by Codebots through
 * licence termination and further legal action, and be required to indemnify Codebots for any loss or damage,
 * including interest and costs. You are deemed to have accepted the terms of the Full Software Licence on any
 * access, download, storage, and/or use of this source code.
 *
 * BOT WARNING
 * This file is bot-written.
 * Any changes out side of "protected regions" will be lost next time the bot makes any changes.
 */
package kmsweb.cucumber.stepdefs.login;

import kmsweb.cucumber.pom.pages.login.LoginPage;
import kmsweb.cucumber.pom.pages.registration.RegistrationPage;
import kmsweb.cucumber.pom.pages.registration.RegistrationSelectPage;
import kmsweb.cucumber.pom.enums.VisibilityEnum;
import kmsweb.cucumber.stepdefs.AbstractStepDef;
import kmsweb.cucumber.utils.WaitUtils;
import com.google.inject.Inject;
import io.cucumber.java.en.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Slf4j
public class LoginPageStepDef extends AbstractStepDef {

	@Inject
	private LoginPage loginPage;

	@Inject
	private RegistrationSelectPage registrationSelectPage;

	@Inject
	private RegistrationPage registrationPage;



	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Given("I navigate to the login page")
	public void navigate() {
		loginPage.navigate();

	}

	@Given("I click the forgotten password button")
	public void iClickTheForgottenPasswordButton() {
		this.loginPage.getForgottenPassword().click();
	}

	@When("I login with username {string} with password {string}")
	public void iLoginWithUsernameWithPassword(String username, String password) throws InterruptedException {
		loginPage.insertUsername(username);
		loginPage.insertPassword(password);
		loginPage.clickLogin();
	}

	@Then("I see the homepage")
	public void iSeeTheHomePage() {
			webDriverWait.until(webDriver -> webDriver.getCurrentUrl().contains(properties.getProperty("selenium.url") + "/") &&
					!webDriver.getCurrentUrl().contains(loginPage.getPageUrl()));
	}

	@Then("I see the login page")
	public void iShouldSeeTheLoginPage() {
		webDriverWait.until(webDriver -> webDriver.getCurrentUrl().contains(properties.getProperty("selenium.url") + "/")
				&& webDriver.getCurrentUrl().contains(loginPage.getPageUrl()));
	}

	@Then("I see a login error")
	public void iSeeALoginError() throws Exception {
		WaitUtils.waitForElement(webDriver, loginPage.getLoginError(), VisibilityEnum.VISIBLE);
	}

	@Given("I navigate to the registration page")
	public void iNavigateToTheRegistrationPage() {
		loginPage.getRegistrationButton().click();
	}

	@Given("I select the {string} user type from the dropdown")
	public void iSelectTheUserTypeFromTheDropdown(String userType) {
		this.registrationSelectPage.getDropdown().click();
		webDriverWait.until(x -> this.registrationSelectPage.getDropdownOptions().size() > 0);
		this.registrationSelectPage.getDropdownOptions().stream()
				.filter(option -> option.findElement(By.tagName("span")).getText().matches(userType)).findFirst()
				.orElseThrow(() -> new NoSuchElementException("Could not find dropdown option named " + userType)).click();
		this.registrationSelectPage.getConfirmButton().click();
	}

	@When("I login with the new account credentials")
	public void iLoginWithTheNewAccountCredentials() {
		String newUsername = (String) this.testContext.get("new-username-field");
		String newPassword = (String) this.testContext.get("new-password-field");
		loginPage.insertUsername(newUsername);
		loginPage.insertPassword(newPassword);
		loginPage.clickLogin();
	}

	@When("I complete the {string} registration form")
	public void iCompleteTheRegistrationForm(String userType) throws Exception {
		String username = "";
		String password = "";


		this.testContext.put("new-username-field", username);
		this.testContext.put("new-password-field", password);
		this.registrationPage.fillForm(username, password);
		WaitUtils.waitForElement(webDriver, this.loginPage.getUsernameField(), VisibilityEnum.VISIBLE);
	}

	@When("I complete the registration form with the previously created username")
	public void iCompleteTheUserTypeRegistrationFormWithThePreviouslyCreatedUsername() {
		String username = (String) this.testContext.get("new-username-field");
		String password = (String) this.testContext.get("new-password-field");
		this.registrationPage.clearAndWaitForToastNotifications();
		this.registrationPage.fillForm(username, password);

	}

	@Then("the new user is not created")
	public void theNewUserIsNotCreated() throws Exception {
		WaitUtils.waitForElement(webDriver, this.registrationPage.getToastContainer(), VisibilityEnum.VISIBLE);
		Assert.assertTrue(this.registrationPage.getToastContainer().isDisplayed());
		Assert.assertTrue(this.registrationPage.getToastContainer().getText().contains("Username must be unique"));
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
