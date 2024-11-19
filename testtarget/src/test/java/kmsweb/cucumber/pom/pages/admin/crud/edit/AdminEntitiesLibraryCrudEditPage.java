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
import kmsweb.entities.LibraryEntity;

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
 * LibraryPage is a Page POM that is associated with the admin/entities/library url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesLibraryCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	// TODO default handling dataAttribute libraryDocumentField;
	@FindBy(how = How.XPATH, using = "//*[@id='libraryDocument-field']")
	private WebElement libraryDocumentField;
	@FindBy(how = How.XPATH, using = "//*[@id='libraryItemCode-field']")
	private WebElement libraryItemCodeField;
	@FindBy(how = How.XPATH, using = "//*[@id='libraryItemDescription-field']")
	private WebElement libraryItemDescriptionField;
	@FindBy(how = How.XPATH, using = "//*[@id='classification-field']")
	private WebElement classificationField;
	@FindBy(how = How.XPATH, using = "//*[@id='author-field']")
	private WebElement authorField;
	@FindBy(how = How.XPATH, using = "//*[@id='publisher-field']")
	private WebElement publisherField;
	

	// Outgoing one-to-one

	// Incoming one-to-one

	// Outgoing one-to-many

	// Incoming one-to-many

	// Outgoing many-to-many

	// Incoming many-to-many

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	@Inject
	public AdminEntitiesLibraryCrudEditPage(
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
			"admin/entities/library/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (LibraryEntity) abstractEntity;
		// TODO default handling for dataAttribute libraryDocumentField
		libraryDocumentField.sendKeys(entity.getLibraryDocument().toString());

		libraryItemCodeField.sendKeys(entity.getLibraryItemCode());
		libraryItemDescriptionField.sendKeys(entity.getLibraryItemDescription());
		classificationField.sendKeys(entity.getClassification());
		authorField.sendKeys(entity.getAuthor());
		publisherField.sendKeys(entity.getPublisher());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}