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
package kmsweb.cucumber.pom.pages;

import com.github.webdriverextensions.WebDriverExtensionFieldDecorator;
import kmsweb.cucumber.pom.enums.VisibilityEnum;
import kmsweb.cucumber.utils.NavigationUtils;
import kmsweb.cucumber.utils.WaitUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Stack;
import java.util.Properties;

import java.util.Stack;
import java.util.Properties;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Base class for all page object models in the application.
 */
@Slf4j
public abstract class AbstractPage {

	protected WebDriver webDriver;

	protected Properties properties;

	/**
	 * Url of the page
	 */
	@Getter
	protected String pageUrl;

	@Getter
	@FindBy(id = "toast-container")
	private WebElement toastContainer;


	// This is used to track circular cascade dependencies and prevent infinite recursion
	protected static final Stack<String> pageRedirectStack = new Stack<>();

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	protected AbstractPage(
			@NonNull WebDriver webDriver,
			@NonNull Properties properties,
			@NonNull String pageUrlSlug
	) {

		this.webDriver = webDriver;
		this.properties = properties;
		this.pageUrl = properties.get("selenium.url") + "/" + pageUrlSlug;

		PageFactory.initElements(new WebDriverExtensionFieldDecorator(webDriver), this);

		// % protected region % [Add any additional constructor logic after the main body here for constructor with three params] off begin
		// % protected region % [Add any additional constructor logic after the main body here for constructor with three params] end
	}

	protected AbstractPage(
			@NonNull WebDriver webDriver,
			@NonNull Properties properties
	) {

		this.webDriver = webDriver;
		this.properties = properties;

		PageFactory.initElements(webDriver, this);

		// % protected region % [Add any additional constructor logic after the main body here for constructor with two params] off begin
		// % protected region % [Add any additional constructor logic after the main body here for constructor with two params] end
	}

	public void navigate() {
		log.debug("Navigating to url: " + pageUrl);

		// % protected region % [Add any additional logic for navigate before the main body here] off begin
		// % protected region % [Add any additional logic for navigate before the main body here] end

		NavigationUtils.goToUrl(webDriver, pageUrl);

		// % protected region % [Add any additional logic for navigate after the main body here] off begin
		// % protected region % [Add any additional logic for navigate after the main body here] end

		log.debug("Navigated to: " + pageUrl);
	}

	public void navigate(String referrerUrl) {
		pageRedirectStack.push(referrerUrl);
		navigate();
	}

	public void navigateBack() {
		NavigationUtils.goToUrl(webDriver, pageRedirectStack.pop());
	}

	protected boolean isCurrentPageInStack() {
		return this.pageRedirectStack.contains(this.pageUrl);
	}

	/**
	 * Clear any toast messages by clicking on them or waiting until they disappear
	 * Does nothing if there are no toast messages
	 */
	public void clearAndWaitForToastNotifications() {
		final String alertXpath = "//div[@role='alert']";
		try {
			var alerts = toastContainer.findElements(By.xpath(alertXpath));
			alerts.forEach(alert -> {
				try {
					WaitUtils.waitForElement(webDriver, alert, VisibilityEnum.CLICKABLE);
				} catch (Exception e) {
					log.error("Cannot click on alert");
				}
				alert.click();
			});
			WaitUtils.waitForElement(webDriver, By.xpath(alertXpath), VisibilityEnum.NOT_EXISTS);

		} catch (Exception e) {
			// If the toast message disappears before we are ready that is acceptable
			log.error("Cannot find toast to handle", e);
		}
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}