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

package kmsweb.cucumber.pom.pages.registration;

import com.google.inject.Inject;
import kmsweb.cucumber.pom.pages.AbstractPage;
import kmsweb.cucumber.utils.TypingUtils;
import cucumber.runtime.java.guice.ScenarioScoped;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.*;

@Slf4j
@ScenarioScoped
public class RegistrationPage extends AbstractPage {

	@FindBy(xpath = "//input[@id='email-address-field']")
	private WebElement inputField;

	@FindBy(xpath = "//input[@id='password-field']")
	private WebElement passwordField;

	@FindBy(xpath = "//input[@id='confirm-password-field']")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@id='name-field']")
	private WebElement nameField;

	@Inject
	public RegistrationPage(
			WebDriver webDriver,
			Properties properties
	) {
		super(
				webDriver,
				properties,
				"register"
		);
		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	public void fillForm(String username, String password) {
		TypingUtils.clearAndType(webDriver, inputField, username);
		TypingUtils.clearAndType(webDriver, passwordField, password);
		TypingUtils.clearAndType(webDriver, confirmPasswordField, password);
		TypingUtils.clearAndType(webDriver, nameField, username);

		Actions action = new Actions(webDriver);
		action.sendKeys(Keys.ENTER).perform();
	}
}