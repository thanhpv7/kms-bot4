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
package kmsweb.cucumber.pom.pages.admin.crud.list;
import kmsweb.cucumber.pom.pages.AbstractPage;
import kmsweb.cucumber.utils.WaitUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import lombok.NonNull;

@Slf4j
public abstract class CrudList extends AbstractPage {

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Create']")
	public WebElement createButton;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Confirm']")
	public WebElement confirmDelete;

	@FindBy(how = How.CSS, using = "button.icon-look")
	public List<WebElement> ViewButtons;

	@FindBy(how = How.CSS, using = "button.icon-edit")
	public List<WebElement> EditButtons;

	@FindBy(how = How.CSS, using = ".collection__edit-actions.collection__edit-actions > cb-button-group > button.icon-bin-delete")
	public List<WebElement> DeleteButtons;

	@FindBy(how = How.CSS, using = "tbody > tr.collection__item")
	public List<WebElement> CrudListItems;

	@FindBy(xpath = "//thead/tr//th")
	public List<WebElement> HeaderElements;

	//selectionCheckboxes[0] will be the 'Select All' checkbox
	@FindBy(tagName = "cb-checkbox")
	public List<WebElement> selectionCheckboxes;

	@FindBy(className = "collection__select-options")
	public List<WebElement> collectionOptions;

	@FindBy(xpath = "//section[contains(@class,'collection__selection-actions')]//cb-button-group//button")
	public WebElement deleteAllButton;
	
	@FindBy(xpath = "//*[@id='select-all-btn']")
	public List<WebElement> selectAllButton;

	@FindBy(xpath = "//*[@id='cancel-btn']")
	public WebElement cancelButton;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Previous']")
	public WebElement previousPage;

	@FindBy(how = How.XPATH, using = "//button[normalize-space()='Next']")
	public WebElement nextPage;

	@FindBy(how = How.XPATH, using = "//collection__pagination[contains(@class,'collection__pagination')]")
	public List<WebElement> paginationButtons;

	@FindBy(xpath = "//span[contains(@class,'selection-count')]")
	public WebElement selectedCount;

	@FindBy(className = "pagination__page-number")
	public WebElement pageNumber;

	protected CrudList(
			@NonNull WebDriver webDriver,
			@NonNull Properties properties,
			String pageUrlSlug
	) {
		super(
			webDriver,
			properties,
			pageUrlSlug
		);

	}

	public int attributeIndex(String attribute) {
		for (int i = 0; i < this.HeaderElements.size(); i++) {
			if (this.HeaderElements.get(i).getText().matches(attribute)) {
				return i - 1;
			}
		}

		throw new RuntimeException(attribute + " is not a valid attribute name");
	}

	public boolean isCheckboxActive(int checkboxIndex) {
		return !Arrays.asList(this.selectionCheckboxes.get(checkboxIndex).getAttribute("class").split(" ")).contains("input-group--empty");
	}

	public void waitForListElementsLoaded() {
		WaitUtils.waitForElementHasText(webDriver, By.xpath("//button[normalize-space()='Create']"), "Create");
	}
}
