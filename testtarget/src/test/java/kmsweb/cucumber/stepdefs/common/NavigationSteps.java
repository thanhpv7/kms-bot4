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
package kmsweb.cucumber.stepdefs.common;

import kmsweb.cucumber.stepdefs.AbstractStepDef;
import kmsweb.cucumber.utils.NavigationUtils;
import kmsweb.cucumber.utils.WaitUtils;
import io.cucumber.java.en.*;
import lombok.extern.slf4j.Slf4j;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Slf4j
public class NavigationSteps extends AbstractStepDef {
	@Then("I refresh the page")
	public void refreshPage() throws Exception {
		NavigationUtils.refreshPage(webDriver);
		WaitUtils.waitForPage(webDriver);
	}

	@Given("I navigate to url (.*)")
	public void navigateToUrl(String url) {
		NavigationUtils.goToUrl(webDriver, url);
	}

	@Then("I navigate to {string}")
	public void navigateToUrlInSite(String url) throws Exception {
		log.debug("Navigating to url");

		NavigationUtils.goToUrl(webDriver, properties.get("selenium.url") + "/" + url);

		log.debug("Navigated to url");
	}
}