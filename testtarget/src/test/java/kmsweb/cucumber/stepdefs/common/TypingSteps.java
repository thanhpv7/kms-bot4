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
import kmsweb.cucumber.utils.TypingUtils;
import kmsweb.cucumber.utils.WebElementUtils;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

@Slf4j
public class TypingSteps extends AbstractStepDef {

	@Then("I clear and type (.*) into the element with (.*) of (.*)")
	public void clear_and_type_to_element_by(String text, String selector, String path) throws Exception {
		By elementBy = WebElementUtils.getElementAsBy(selector, path);
		TypingUtils.clearAndType(webDriver, elementBy, text);
	}

	@Then("I type (.*) into the element with (.*) of (.*)")
	public void type_element_by(String text, String selector, String path) throws Exception {
		By elementBy = WebElementUtils.getElementAsBy(selector, path);
		TypingUtils.type(webDriver, elementBy, text);
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}

