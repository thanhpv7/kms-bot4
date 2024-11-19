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
package kmsweb.cucumber.pom.pages.admin.crud.edit;

import com.google.inject.Inject;
import kmsweb.cucumber.utils.*;
import kmsweb.entities.AbstractEntity;
import kmsweb.entities.BodyChartExaminationEntity;

import cucumber.runtime.java.guice.ScenarioScoped;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.NonNull;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.interactions.Actions;
import java.util.*;

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Body Chart ExaminationPage is a Page POM that is associated with the admin/entities/body-chart-examination url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesBodyChartExaminationCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='bc01Subjective-field']")
	private WebElement bc01SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc01Objective-field']")
	private WebElement bc01ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc02Subjective-field']")
	private WebElement bc02SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc02Objective-field']")
	private WebElement bc02ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc03Subjective-field']")
	private WebElement bc03SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc03Objective-field']")
	private WebElement bc03ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc04Subjective-field']")
	private WebElement bc04SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc04Objective-field']")
	private WebElement bc04ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc05Subjective-field']")
	private WebElement bc05SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc05Objective-field']")
	private WebElement bc05ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc06Subjective-field']")
	private WebElement bc06SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc06Objective-field']")
	private WebElement bc06ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc07Subjective-field']")
	private WebElement bc07SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc07Objective-field']")
	private WebElement bc07ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc08Subjective-field']")
	private WebElement bc08SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc08Objective-field']")
	private WebElement bc08ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc09Subjective-field']")
	private WebElement bc09SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc09Objective-field']")
	private WebElement bc09ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc10Subjective-field']")
	private WebElement bc10SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc10Objective-field']")
	private WebElement bc10ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc11Subjective-field']")
	private WebElement bc11SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc11Objective-field']")
	private WebElement bc11ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc12Subjective-field']")
	private WebElement bc12SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc12Objective-field']")
	private WebElement bc12ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc13Subjective-field']")
	private WebElement bc13SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc13Objective-field']")
	private WebElement bc13ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc14Subjective-field']")
	private WebElement bc14SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc14Objective-field']")
	private WebElement bc14ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc15Subjective-field']")
	private WebElement bc15SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc15Objective-field']")
	private WebElement bc15ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc16Subjective-field']")
	private WebElement bc16SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc16Objective-field']")
	private WebElement bc16ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc17Subjective-field']")
	private WebElement bc17SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc17Objective-field']")
	private WebElement bc17ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc18Subjective-field']")
	private WebElement bc18SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc18Objective-field']")
	private WebElement bc18ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc19Subjective-field']")
	private WebElement bc19SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc19Objective-field']")
	private WebElement bc19ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc20Subjective-field']")
	private WebElement bc20SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc20Objective-field']")
	private WebElement bc20ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc21Subjective-field']")
	private WebElement bc21SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc21Objective-field']")
	private WebElement bc21ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc22Subjective-field']")
	private WebElement bc22SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc22Objective-field']")
	private WebElement bc22ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc23Subjective-field']")
	private WebElement bc23SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc23Objective-field']")
	private WebElement bc23ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc24Subjective-field']")
	private WebElement bc24SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc24Objective-field']")
	private WebElement bc24ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc25Subjective-field']")
	private WebElement bc25SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc25Objective-field']")
	private WebElement bc25ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc26Subjective-field']")
	private WebElement bc26SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc26Objective-field']")
	private WebElement bc26ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc27Subjective-field']")
	private WebElement bc27SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc27Objective-field']")
	private WebElement bc27ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc28Subjective-field']")
	private WebElement bc28SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc28Objective-field']")
	private WebElement bc28ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc29Subjective-field']")
	private WebElement bc29SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc29Objective-field']")
	private WebElement bc29ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc30Subjective-field']")
	private WebElement bc30SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc30Objective-field']")
	private WebElement bc30ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc31Subjective-field']")
	private WebElement bc31SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc31Objective-field']")
	private WebElement bc31ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc32Subjective-field']")
	private WebElement bc32SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc32Objective-field']")
	private WebElement bc32ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc33Subjective-field']")
	private WebElement bc33SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc33Objective-field']")
	private WebElement bc33ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc34Subjective-field']")
	private WebElement bc34SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc34Objective-field']")
	private WebElement bc34ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc35Subjective-field']")
	private WebElement bc35SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc35Objective-field']")
	private WebElement bc35ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc36Subjective-field']")
	private WebElement bc36SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc36Objective-field']")
	private WebElement bc36ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc37Subjective-field']")
	private WebElement bc37SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc37Objective-field']")
	private WebElement bc37ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc38Subjective-field']")
	private WebElement bc38SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc38Objective-field']")
	private WebElement bc38ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc39Subjective-field']")
	private WebElement bc39SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc39Objective-field']")
	private WebElement bc39ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc40Subjective-field']")
	private WebElement bc40SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc40Objective-field']")
	private WebElement bc40ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc41Subjective-field']")
	private WebElement bc41SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc41Objective-field']")
	private WebElement bc41ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc42Subjective-field']")
	private WebElement bc42SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc42Objective-field']")
	private WebElement bc42ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc43Subjective-field']")
	private WebElement bc43SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc43Objective-field']")
	private WebElement bc43ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc44Subjective-field']")
	private WebElement bc44SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc44Objective-field']")
	private WebElement bc44ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc45Subjective-field']")
	private WebElement bc45SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc45Objective-field']")
	private WebElement bc45ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc46Subjective-field']")
	private WebElement bc46SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc46Objective-field']")
	private WebElement bc46ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc47Subjective-field']")
	private WebElement bc47SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc47Objective-field']")
	private WebElement bc47ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc48Subjective-field']")
	private WebElement bc48SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc48Objective-field']")
	private WebElement bc48ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc49Subjective-field']")
	private WebElement bc49SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc49Objective-field']")
	private WebElement bc49ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc50Subjective-field']")
	private WebElement bc50SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc50Objective-field']")
	private WebElement bc50ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc51Subjective-field']")
	private WebElement bc51SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc51Objective-field']")
	private WebElement bc51ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc52Subjective-field']")
	private WebElement bc52SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc52Objective-field']")
	private WebElement bc52ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc53Subjective-field']")
	private WebElement bc53SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc53Objective-field']")
	private WebElement bc53ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc54Subjective-field']")
	private WebElement bc54SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc54Objective-field']")
	private WebElement bc54ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc55Subjective-field']")
	private WebElement bc55SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc55Objective-field']")
	private WebElement bc55ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc56Subjective-field']")
	private WebElement bc56SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc56Objective-field']")
	private WebElement bc56ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc57Subjective-field']")
	private WebElement bc57SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc57Objective-field']")
	private WebElement bc57ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc58Subjective-field']")
	private WebElement bc58SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc58Objective-field']")
	private WebElement bc58ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc59Subjective-field']")
	private WebElement bc59SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc59Objective-field']")
	private WebElement bc59ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc60Subjective-field']")
	private WebElement bc60SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc60Objective-field']")
	private WebElement bc60ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc61Subjective-field']")
	private WebElement bc61SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc61Objective-field']")
	private WebElement bc61ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc62Subjective-field']")
	private WebElement bc62SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc62Objective-field']")
	private WebElement bc62ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc63Subjective-field']")
	private WebElement bc63SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc63Objective-field']")
	private WebElement bc63ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc64Subjective-field']")
	private WebElement bc64SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc64Objective-field']")
	private WebElement bc64ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc65Subjective-field']")
	private WebElement bc65SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc65Objective-field']")
	private WebElement bc65ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc66Subjective-field']")
	private WebElement bc66SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc66Objective-field']")
	private WebElement bc66ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc67Subjective-field']")
	private WebElement bc67SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc67Objective-field']")
	private WebElement bc67ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc68Subjective-field']")
	private WebElement bc68SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc68Objective-field']")
	private WebElement bc68ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc69Subjective-field']")
	private WebElement bc69SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc69Objective-field']")
	private WebElement bc69ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc70Subjective-field']")
	private WebElement bc70SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc70Objective-field']")
	private WebElement bc70ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc71Subjective-field']")
	private WebElement bc71SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc71Objective-field']")
	private WebElement bc71ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc72Subjective-field']")
	private WebElement bc72SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc72Objective-field']")
	private WebElement bc72ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc73Subjective-field']")
	private WebElement bc73SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc73Objective-field']")
	private WebElement bc73ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc74Subjective-field']")
	private WebElement bc74SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc74Objective-field']")
	private WebElement bc74ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc75Subjective-field']")
	private WebElement bc75SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc75Objective-field']")
	private WebElement bc75ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc76Subjective-field']")
	private WebElement bc76SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc76Objective-field']")
	private WebElement bc76ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc77Subjective-field']")
	private WebElement bc77SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc77Objective-field']")
	private WebElement bc77ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc78Subjective-field']")
	private WebElement bc78SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc78Objective-field']")
	private WebElement bc78ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc79Subjective-field']")
	private WebElement bc79SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc79Objective-field']")
	private WebElement bc79ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc80Subjective-field']")
	private WebElement bc80SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc80Objective-field']")
	private WebElement bc80ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc81Subjective-field']")
	private WebElement bc81SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc81Objective-field']")
	private WebElement bc81ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc82Subjective-field']")
	private WebElement bc82SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc82Objective-field']")
	private WebElement bc82ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc83Subjective-field']")
	private WebElement bc83SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc83Objective-field']")
	private WebElement bc83ObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc84Subjective-field']")
	private WebElement bc84SubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='bc84Objective-field']")
	private WebElement bc84ObjectiveField;
	

	// Outgoing one-to-one

	// Incoming one-to-one
	@FindBy(how = How.XPATH, using = "//ng-select[@id='medicalExaminationRecordId-field']")
	private WebElement medicalExaminationRecordField;

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesBodyChartExaminationCrudEditPage(
			// % protected region % [Add any additional constructor parameters here] off begin
			// % protected region % [Add any additional constructor parameters here] end
			@NonNull WebDriver webDriver,
			@NonNull Properties properties
	) {
		super(
			// % protected region % [Add any additional constructor arguments here] off begin
			// % protected region % [Add any additional constructor arguments here] end
			webDriver,
			properties,
			"admin/entities/body-chart-examination/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (BodyChartExaminationEntity) abstractEntity;
		bc01SubjectiveField.sendKeys(entity.getBc01Subjective());
		bc01ObjectiveField.sendKeys(entity.getBc01Objective());
		bc02SubjectiveField.sendKeys(entity.getBc02Subjective());
		bc02ObjectiveField.sendKeys(entity.getBc02Objective());
		bc03SubjectiveField.sendKeys(entity.getBc03Subjective());
		bc03ObjectiveField.sendKeys(entity.getBc03Objective());
		bc04SubjectiveField.sendKeys(entity.getBc04Subjective());
		bc04ObjectiveField.sendKeys(entity.getBc04Objective());
		bc05SubjectiveField.sendKeys(entity.getBc05Subjective());
		bc05ObjectiveField.sendKeys(entity.getBc05Objective());
		bc06SubjectiveField.sendKeys(entity.getBc06Subjective());
		bc06ObjectiveField.sendKeys(entity.getBc06Objective());
		bc07SubjectiveField.sendKeys(entity.getBc07Subjective());
		bc07ObjectiveField.sendKeys(entity.getBc07Objective());
		bc08SubjectiveField.sendKeys(entity.getBc08Subjective());
		bc08ObjectiveField.sendKeys(entity.getBc08Objective());
		bc09SubjectiveField.sendKeys(entity.getBc09Subjective());
		bc09ObjectiveField.sendKeys(entity.getBc09Objective());
		bc10SubjectiveField.sendKeys(entity.getBc10Subjective());
		bc10ObjectiveField.sendKeys(entity.getBc10Objective());
		bc11SubjectiveField.sendKeys(entity.getBc11Subjective());
		bc11ObjectiveField.sendKeys(entity.getBc11Objective());
		bc12SubjectiveField.sendKeys(entity.getBc12Subjective());
		bc12ObjectiveField.sendKeys(entity.getBc12Objective());
		bc13SubjectiveField.sendKeys(entity.getBc13Subjective());
		bc13ObjectiveField.sendKeys(entity.getBc13Objective());
		bc14SubjectiveField.sendKeys(entity.getBc14Subjective());
		bc14ObjectiveField.sendKeys(entity.getBc14Objective());
		bc15SubjectiveField.sendKeys(entity.getBc15Subjective());
		bc15ObjectiveField.sendKeys(entity.getBc15Objective());
		bc16SubjectiveField.sendKeys(entity.getBc16Subjective());
		bc16ObjectiveField.sendKeys(entity.getBc16Objective());
		bc17SubjectiveField.sendKeys(entity.getBc17Subjective());
		bc17ObjectiveField.sendKeys(entity.getBc17Objective());
		bc18SubjectiveField.sendKeys(entity.getBc18Subjective());
		bc18ObjectiveField.sendKeys(entity.getBc18Objective());
		bc19SubjectiveField.sendKeys(entity.getBc19Subjective());
		bc19ObjectiveField.sendKeys(entity.getBc19Objective());
		bc20SubjectiveField.sendKeys(entity.getBc20Subjective());
		bc20ObjectiveField.sendKeys(entity.getBc20Objective());
		bc21SubjectiveField.sendKeys(entity.getBc21Subjective());
		bc21ObjectiveField.sendKeys(entity.getBc21Objective());
		bc22SubjectiveField.sendKeys(entity.getBc22Subjective());
		bc22ObjectiveField.sendKeys(entity.getBc22Objective());
		bc23SubjectiveField.sendKeys(entity.getBc23Subjective());
		bc23ObjectiveField.sendKeys(entity.getBc23Objective());
		bc24SubjectiveField.sendKeys(entity.getBc24Subjective());
		bc24ObjectiveField.sendKeys(entity.getBc24Objective());
		bc25SubjectiveField.sendKeys(entity.getBc25Subjective());
		bc25ObjectiveField.sendKeys(entity.getBc25Objective());
		bc26SubjectiveField.sendKeys(entity.getBc26Subjective());
		bc26ObjectiveField.sendKeys(entity.getBc26Objective());
		bc27SubjectiveField.sendKeys(entity.getBc27Subjective());
		bc27ObjectiveField.sendKeys(entity.getBc27Objective());
		bc28SubjectiveField.sendKeys(entity.getBc28Subjective());
		bc28ObjectiveField.sendKeys(entity.getBc28Objective());
		bc29SubjectiveField.sendKeys(entity.getBc29Subjective());
		bc29ObjectiveField.sendKeys(entity.getBc29Objective());
		bc30SubjectiveField.sendKeys(entity.getBc30Subjective());
		bc30ObjectiveField.sendKeys(entity.getBc30Objective());
		bc31SubjectiveField.sendKeys(entity.getBc31Subjective());
		bc31ObjectiveField.sendKeys(entity.getBc31Objective());
		bc32SubjectiveField.sendKeys(entity.getBc32Subjective());
		bc32ObjectiveField.sendKeys(entity.getBc32Objective());
		bc33SubjectiveField.sendKeys(entity.getBc33Subjective());
		bc33ObjectiveField.sendKeys(entity.getBc33Objective());
		bc34SubjectiveField.sendKeys(entity.getBc34Subjective());
		bc34ObjectiveField.sendKeys(entity.getBc34Objective());
		bc35SubjectiveField.sendKeys(entity.getBc35Subjective());
		bc35ObjectiveField.sendKeys(entity.getBc35Objective());
		bc36SubjectiveField.sendKeys(entity.getBc36Subjective());
		bc36ObjectiveField.sendKeys(entity.getBc36Objective());
		bc37SubjectiveField.sendKeys(entity.getBc37Subjective());
		bc37ObjectiveField.sendKeys(entity.getBc37Objective());
		bc38SubjectiveField.sendKeys(entity.getBc38Subjective());
		bc38ObjectiveField.sendKeys(entity.getBc38Objective());
		bc39SubjectiveField.sendKeys(entity.getBc39Subjective());
		bc39ObjectiveField.sendKeys(entity.getBc39Objective());
		bc40SubjectiveField.sendKeys(entity.getBc40Subjective());
		bc40ObjectiveField.sendKeys(entity.getBc40Objective());
		bc41SubjectiveField.sendKeys(entity.getBc41Subjective());
		bc41ObjectiveField.sendKeys(entity.getBc41Objective());
		bc42SubjectiveField.sendKeys(entity.getBc42Subjective());
		bc42ObjectiveField.sendKeys(entity.getBc42Objective());
		bc43SubjectiveField.sendKeys(entity.getBc43Subjective());
		bc43ObjectiveField.sendKeys(entity.getBc43Objective());
		bc44SubjectiveField.sendKeys(entity.getBc44Subjective());
		bc44ObjectiveField.sendKeys(entity.getBc44Objective());
		bc45SubjectiveField.sendKeys(entity.getBc45Subjective());
		bc45ObjectiveField.sendKeys(entity.getBc45Objective());
		bc46SubjectiveField.sendKeys(entity.getBc46Subjective());
		bc46ObjectiveField.sendKeys(entity.getBc46Objective());
		bc47SubjectiveField.sendKeys(entity.getBc47Subjective());
		bc47ObjectiveField.sendKeys(entity.getBc47Objective());
		bc48SubjectiveField.sendKeys(entity.getBc48Subjective());
		bc48ObjectiveField.sendKeys(entity.getBc48Objective());
		bc49SubjectiveField.sendKeys(entity.getBc49Subjective());
		bc49ObjectiveField.sendKeys(entity.getBc49Objective());
		bc50SubjectiveField.sendKeys(entity.getBc50Subjective());
		bc50ObjectiveField.sendKeys(entity.getBc50Objective());
		bc51SubjectiveField.sendKeys(entity.getBc51Subjective());
		bc51ObjectiveField.sendKeys(entity.getBc51Objective());
		bc52SubjectiveField.sendKeys(entity.getBc52Subjective());
		bc52ObjectiveField.sendKeys(entity.getBc52Objective());
		bc53SubjectiveField.sendKeys(entity.getBc53Subjective());
		bc53ObjectiveField.sendKeys(entity.getBc53Objective());
		bc54SubjectiveField.sendKeys(entity.getBc54Subjective());
		bc54ObjectiveField.sendKeys(entity.getBc54Objective());
		bc55SubjectiveField.sendKeys(entity.getBc55Subjective());
		bc55ObjectiveField.sendKeys(entity.getBc55Objective());
		bc56SubjectiveField.sendKeys(entity.getBc56Subjective());
		bc56ObjectiveField.sendKeys(entity.getBc56Objective());
		bc57SubjectiveField.sendKeys(entity.getBc57Subjective());
		bc57ObjectiveField.sendKeys(entity.getBc57Objective());
		bc58SubjectiveField.sendKeys(entity.getBc58Subjective());
		bc58ObjectiveField.sendKeys(entity.getBc58Objective());
		bc59SubjectiveField.sendKeys(entity.getBc59Subjective());
		bc59ObjectiveField.sendKeys(entity.getBc59Objective());
		bc60SubjectiveField.sendKeys(entity.getBc60Subjective());
		bc60ObjectiveField.sendKeys(entity.getBc60Objective());
		bc61SubjectiveField.sendKeys(entity.getBc61Subjective());
		bc61ObjectiveField.sendKeys(entity.getBc61Objective());
		bc62SubjectiveField.sendKeys(entity.getBc62Subjective());
		bc62ObjectiveField.sendKeys(entity.getBc62Objective());
		bc63SubjectiveField.sendKeys(entity.getBc63Subjective());
		bc63ObjectiveField.sendKeys(entity.getBc63Objective());
		bc64SubjectiveField.sendKeys(entity.getBc64Subjective());
		bc64ObjectiveField.sendKeys(entity.getBc64Objective());
		bc65SubjectiveField.sendKeys(entity.getBc65Subjective());
		bc65ObjectiveField.sendKeys(entity.getBc65Objective());
		bc66SubjectiveField.sendKeys(entity.getBc66Subjective());
		bc66ObjectiveField.sendKeys(entity.getBc66Objective());
		bc67SubjectiveField.sendKeys(entity.getBc67Subjective());
		bc67ObjectiveField.sendKeys(entity.getBc67Objective());
		bc68SubjectiveField.sendKeys(entity.getBc68Subjective());
		bc68ObjectiveField.sendKeys(entity.getBc68Objective());
		bc69SubjectiveField.sendKeys(entity.getBc69Subjective());
		bc69ObjectiveField.sendKeys(entity.getBc69Objective());
		bc70SubjectiveField.sendKeys(entity.getBc70Subjective());
		bc70ObjectiveField.sendKeys(entity.getBc70Objective());
		bc71SubjectiveField.sendKeys(entity.getBc71Subjective());
		bc71ObjectiveField.sendKeys(entity.getBc71Objective());
		bc72SubjectiveField.sendKeys(entity.getBc72Subjective());
		bc72ObjectiveField.sendKeys(entity.getBc72Objective());
		bc73SubjectiveField.sendKeys(entity.getBc73Subjective());
		bc73ObjectiveField.sendKeys(entity.getBc73Objective());
		bc74SubjectiveField.sendKeys(entity.getBc74Subjective());
		bc74ObjectiveField.sendKeys(entity.getBc74Objective());
		bc75SubjectiveField.sendKeys(entity.getBc75Subjective());
		bc75ObjectiveField.sendKeys(entity.getBc75Objective());
		bc76SubjectiveField.sendKeys(entity.getBc76Subjective());
		bc76ObjectiveField.sendKeys(entity.getBc76Objective());
		bc77SubjectiveField.sendKeys(entity.getBc77Subjective());
		bc77ObjectiveField.sendKeys(entity.getBc77Objective());
		bc78SubjectiveField.sendKeys(entity.getBc78Subjective());
		bc78ObjectiveField.sendKeys(entity.getBc78Objective());
		bc79SubjectiveField.sendKeys(entity.getBc79Subjective());
		bc79ObjectiveField.sendKeys(entity.getBc79Objective());
		bc80SubjectiveField.sendKeys(entity.getBc80Subjective());
		bc80ObjectiveField.sendKeys(entity.getBc80Objective());
		bc81SubjectiveField.sendKeys(entity.getBc81Subjective());
		bc81ObjectiveField.sendKeys(entity.getBc81Objective());
		bc82SubjectiveField.sendKeys(entity.getBc82Subjective());
		bc82ObjectiveField.sendKeys(entity.getBc82Objective());
		bc83SubjectiveField.sendKeys(entity.getBc83Subjective());
		bc83ObjectiveField.sendKeys(entity.getBc83Objective());
		bc84SubjectiveField.sendKeys(entity.getBc84Subjective());
		bc84ObjectiveField.sendKeys(entity.getBc84Objective());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}