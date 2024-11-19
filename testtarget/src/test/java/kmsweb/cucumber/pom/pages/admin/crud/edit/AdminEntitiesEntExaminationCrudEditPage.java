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
import kmsweb.entities.EntExaminationEntity;

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
 * ENT ExaminationPage is a Page POM that is associated with the admin/entities/ent-examination url.
 *
 */
@Slf4j
@ScenarioScoped
public class AdminEntitiesEntExaminationCrudEditPage extends CrudEdit {

	// % protected region % [Add any additional fields here] off begin
	// % protected region % [Add any additional fields here] end


	@FindBy(how = How.XPATH, using = "//*[@id='rightExternalEarSubjective-field']")
	private WebElement rightExternalEarSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightExternalEarObjective-field']")
	private WebElement rightExternalEarObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightConchaSubjective-field']")
	private WebElement rightConchaSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightConchaObjective-field']")
	private WebElement rightConchaObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightEarlobeSubjective-field']")
	private WebElement rightEarlobeSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightEarlobeObjective-field']")
	private WebElement rightEarlobeObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightEarCanalSubjective-field']")
	private WebElement rightEarCanalSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightEarCanalObjective-field']")
	private WebElement rightEarCanalObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightEardrumSubjective-field']")
	private WebElement rightEardrumSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightEardrumObjective-field']")
	private WebElement rightEardrumObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftExternalEarSubjective-field']")
	private WebElement leftExternalEarSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftExternalEarObjective-field']")
	private WebElement leftExternalEarObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftConchaSubjective-field']")
	private WebElement leftConchaSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftConchaObjective-field']")
	private WebElement leftConchaObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftEarlobeSubjective-field']")
	private WebElement leftEarlobeSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftEarlobeObjective-field']")
	private WebElement leftEarlobeObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftEarCanalSubjective-field']")
	private WebElement leftEarCanalSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftEarCanalObjective-field']")
	private WebElement leftEarCanalObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftEardrumSubjective-field']")
	private WebElement leftEardrumSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftEardrumObjective-field']")
	private WebElement leftEardrumObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='nasalBoneSubjective-field']")
	private WebElement nasalBoneSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='nasalBoneObjective-field']")
	private WebElement nasalBoneObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightFrontalSinusSubjective-field']")
	private WebElement rightFrontalSinusSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightFrontalSinusObjective-field']")
	private WebElement rightFrontalSinusObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightEthmoidSinusSubjective-field']")
	private WebElement rightEthmoidSinusSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightEthmoidSinusObjective-field']")
	private WebElement rightEthmoidSinusObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightSuperiorTurbinateSubjective-field']")
	private WebElement rightSuperiorTurbinateSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightSuperiorTurbinateObjective-field']")
	private WebElement rightSuperiorTurbinateObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightMiddleTurbinateSubjective-field']")
	private WebElement rightMiddleTurbinateSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightMiddleTurbinateObjective-field']")
	private WebElement rightMiddleTurbinateObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightMaxillarySinusSubjective-field']")
	private WebElement rightMaxillarySinusSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightMaxillarySinusObjective-field']")
	private WebElement rightMaxillarySinusObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightNasalCavitySubjective-field']")
	private WebElement rightNasalCavitySubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightNasalCavityObjective-field']")
	private WebElement rightNasalCavityObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightInferiorTurbinateSubjective-field']")
	private WebElement rightInferiorTurbinateSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightInferiorTurbinateObjective-field']")
	private WebElement rightInferiorTurbinateObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftFrontalSinusSubjective-field']")
	private WebElement leftFrontalSinusSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftFrontalSinusObjective-field']")
	private WebElement leftFrontalSinusObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftEthmoidSinusSubjective-field']")
	private WebElement leftEthmoidSinusSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftEthmoidSinusObjective-field']")
	private WebElement leftEthmoidSinusObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftSuperiorTurbinateSubjective-field']")
	private WebElement leftSuperiorTurbinateSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftSuperiorTurbinateObjective-field']")
	private WebElement leftSuperiorTurbinateObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftMiddleTurbinateSubjective-field']")
	private WebElement leftMiddleTurbinateSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftMiddleTurbinateObjective-field']")
	private WebElement leftMiddleTurbinateObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftMaxillarySinusSubjective-field']")
	private WebElement leftMaxillarySinusSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftMaxillarySinusObjective-field']")
	private WebElement leftMaxillarySinusObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftNasalCavitySubjective-field']")
	private WebElement leftNasalCavitySubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftNasalCavityObjective-field']")
	private WebElement leftNasalCavityObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftInferiorTurbinateSubjective-field']")
	private WebElement leftInferiorTurbinateSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftInferiorTurbinateObjective-field']")
	private WebElement leftInferiorTurbinateObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='lingualTonsilSubjective-field']")
	private WebElement lingualTonsilSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='lingualTonsilObjective-field']")
	private WebElement lingualTonsilObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='epiglottisSubjective-field']")
	private WebElement epiglottisSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='epiglottisObjective-field']")
	private WebElement epiglottisObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightVocalFoldSubjective-field']")
	private WebElement rightVocalFoldSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightVocalFoldObjective-field']")
	private WebElement rightVocalFoldObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightVentricularFoldSubjective-field']")
	private WebElement rightVentricularFoldSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightVentricularFoldObjective-field']")
	private WebElement rightVentricularFoldObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='glottisSubjective-field']")
	private WebElement glottisSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='glottisObjective-field']")
	private WebElement glottisObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightCuneiformCartilageSubjective-field']")
	private WebElement rightCuneiformCartilageSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightCuneiformCartilageObjective-field']")
	private WebElement rightCuneiformCartilageObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightCorniculateCartilageSubjective-field']")
	private WebElement rightCorniculateCartilageSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightCorniculateCartilageObjective-field']")
	private WebElement rightCorniculateCartilageObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='tracheaSubjective-field']")
	private WebElement tracheaSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='tracheaObjective-field']")
	private WebElement tracheaObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftVocalFoldSubjective-field']")
	private WebElement leftVocalFoldSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftVocalFoldObjective-field']")
	private WebElement leftVocalFoldObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftVentricularFoldSubjective-field']")
	private WebElement leftVentricularFoldSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftVentricularFoldObjective-field']")
	private WebElement leftVentricularFoldObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftCuneiformCartilageSubjective-field']")
	private WebElement leftCuneiformCartilageSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftCuneiformCartilageObjective-field']")
	private WebElement leftCuneiformCartilageObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftCorniculateCartilageSubjective-field']")
	private WebElement leftCorniculateCartilageSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftCorniculateCartilageObjective-field']")
	private WebElement leftCorniculateCartilageObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='softPalateSubjective-field']")
	private WebElement softPalateSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='softPalateObjective-field']")
	private WebElement softPalateObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightAnteriorPillarSubjective-field']")
	private WebElement rightAnteriorPillarSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightAnteriorPillarObjective-field']")
	private WebElement rightAnteriorPillarObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='uvulaSubjective-field']")
	private WebElement uvulaSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='uvulaObjective-field']")
	private WebElement uvulaObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightPosteriorPillarSubjective-field']")
	private WebElement rightPosteriorPillarSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightPosteriorPillarObjective-field']")
	private WebElement rightPosteriorPillarObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightTonsilSubjective-field']")
	private WebElement rightTonsilSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightTonsilObjective-field']")
	private WebElement rightTonsilObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightPosteriorSubjective-field']")
	private WebElement rightPosteriorSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='rightPosteriorObjective-field']")
	private WebElement rightPosteriorObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='upperTongueSubjective-field']")
	private WebElement upperTongueSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='upperTongueObjective-field']")
	private WebElement upperTongueObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftAnteriorPillarSubjective-field']")
	private WebElement leftAnteriorPillarSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftAnteriorPillarObjective-field']")
	private WebElement leftAnteriorPillarObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftPosteriorPillarSubjective-field']")
	private WebElement leftPosteriorPillarSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftPosteriorPillarObjective-field']")
	private WebElement leftPosteriorPillarObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftTonsilSubjective-field']")
	private WebElement leftTonsilSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftTonsilObjective-field']")
	private WebElement leftTonsilObjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftPosteriorWallSubjective-field']")
	private WebElement leftPosteriorWallSubjectiveField;
	@FindBy(how = How.XPATH, using = "//*[@id='leftPosteriorWallObjective-field']")
	private WebElement leftPosteriorWallObjectiveField;
	

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
	public AdminEntitiesEntExaminationCrudEditPage(
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
			"admin/entities/ent-examination/create"
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end

		log.trace("Initialised {}", this.getClass().getSimpleName());
	}

	@Override
	protected void fillInEntityInformation(AbstractEntity abstractEntity)
	{
		var entity = (EntExaminationEntity) abstractEntity;
		rightExternalEarSubjectiveField.sendKeys(entity.getRightExternalEarSubjective());
		rightExternalEarObjectiveField.sendKeys(entity.getRightExternalEarObjective());
		rightConchaSubjectiveField.sendKeys(entity.getRightConchaSubjective());
		rightConchaObjectiveField.sendKeys(entity.getRightConchaObjective());
		rightEarlobeSubjectiveField.sendKeys(entity.getRightEarlobeSubjective());
		rightEarlobeObjectiveField.sendKeys(entity.getRightEarlobeObjective());
		rightEarCanalSubjectiveField.sendKeys(entity.getRightEarCanalSubjective());
		rightEarCanalObjectiveField.sendKeys(entity.getRightEarCanalObjective());
		rightEardrumSubjectiveField.sendKeys(entity.getRightEardrumSubjective());
		rightEardrumObjectiveField.sendKeys(entity.getRightEardrumObjective());
		leftExternalEarSubjectiveField.sendKeys(entity.getLeftExternalEarSubjective());
		leftExternalEarObjectiveField.sendKeys(entity.getLeftExternalEarObjective());
		leftConchaSubjectiveField.sendKeys(entity.getLeftConchaSubjective());
		leftConchaObjectiveField.sendKeys(entity.getLeftConchaObjective());
		leftEarlobeSubjectiveField.sendKeys(entity.getLeftEarlobeSubjective());
		leftEarlobeObjectiveField.sendKeys(entity.getLeftEarlobeObjective());
		leftEarCanalSubjectiveField.sendKeys(entity.getLeftEarCanalSubjective());
		leftEarCanalObjectiveField.sendKeys(entity.getLeftEarCanalObjective());
		leftEardrumSubjectiveField.sendKeys(entity.getLeftEardrumSubjective());
		leftEardrumObjectiveField.sendKeys(entity.getLeftEardrumObjective());
		nasalBoneSubjectiveField.sendKeys(entity.getNasalBoneSubjective());
		nasalBoneObjectiveField.sendKeys(entity.getNasalBoneObjective());
		rightFrontalSinusSubjectiveField.sendKeys(entity.getRightFrontalSinusSubjective());
		rightFrontalSinusObjectiveField.sendKeys(entity.getRightFrontalSinusObjective());
		rightEthmoidSinusSubjectiveField.sendKeys(entity.getRightEthmoidSinusSubjective());
		rightEthmoidSinusObjectiveField.sendKeys(entity.getRightEthmoidSinusObjective());
		rightSuperiorTurbinateSubjectiveField.sendKeys(entity.getRightSuperiorTurbinateSubjective());
		rightSuperiorTurbinateObjectiveField.sendKeys(entity.getRightSuperiorTurbinateObjective());
		rightMiddleTurbinateSubjectiveField.sendKeys(entity.getRightMiddleTurbinateSubjective());
		rightMiddleTurbinateObjectiveField.sendKeys(entity.getRightMiddleTurbinateObjective());
		rightMaxillarySinusSubjectiveField.sendKeys(entity.getRightMaxillarySinusSubjective());
		rightMaxillarySinusObjectiveField.sendKeys(entity.getRightMaxillarySinusObjective());
		rightNasalCavitySubjectiveField.sendKeys(entity.getRightNasalCavitySubjective());
		rightNasalCavityObjectiveField.sendKeys(entity.getRightNasalCavityObjective());
		rightInferiorTurbinateSubjectiveField.sendKeys(entity.getRightInferiorTurbinateSubjective());
		rightInferiorTurbinateObjectiveField.sendKeys(entity.getRightInferiorTurbinateObjective());
		leftFrontalSinusSubjectiveField.sendKeys(entity.getLeftFrontalSinusSubjective());
		leftFrontalSinusObjectiveField.sendKeys(entity.getLeftFrontalSinusObjective());
		leftEthmoidSinusSubjectiveField.sendKeys(entity.getLeftEthmoidSinusSubjective());
		leftEthmoidSinusObjectiveField.sendKeys(entity.getLeftEthmoidSinusObjective());
		leftSuperiorTurbinateSubjectiveField.sendKeys(entity.getLeftSuperiorTurbinateSubjective());
		leftSuperiorTurbinateObjectiveField.sendKeys(entity.getLeftSuperiorTurbinateObjective());
		leftMiddleTurbinateSubjectiveField.sendKeys(entity.getLeftMiddleTurbinateSubjective());
		leftMiddleTurbinateObjectiveField.sendKeys(entity.getLeftMiddleTurbinateObjective());
		leftMaxillarySinusSubjectiveField.sendKeys(entity.getLeftMaxillarySinusSubjective());
		leftMaxillarySinusObjectiveField.sendKeys(entity.getLeftMaxillarySinusObjective());
		leftNasalCavitySubjectiveField.sendKeys(entity.getLeftNasalCavitySubjective());
		leftNasalCavityObjectiveField.sendKeys(entity.getLeftNasalCavityObjective());
		leftInferiorTurbinateSubjectiveField.sendKeys(entity.getLeftInferiorTurbinateSubjective());
		leftInferiorTurbinateObjectiveField.sendKeys(entity.getLeftInferiorTurbinateObjective());
		lingualTonsilSubjectiveField.sendKeys(entity.getLingualTonsilSubjective());
		lingualTonsilObjectiveField.sendKeys(entity.getLingualTonsilObjective());
		epiglottisSubjectiveField.sendKeys(entity.getEpiglottisSubjective());
		epiglottisObjectiveField.sendKeys(entity.getEpiglottisObjective());
		rightVocalFoldSubjectiveField.sendKeys(entity.getRightVocalFoldSubjective());
		rightVocalFoldObjectiveField.sendKeys(entity.getRightVocalFoldObjective());
		rightVentricularFoldSubjectiveField.sendKeys(entity.getRightVentricularFoldSubjective());
		rightVentricularFoldObjectiveField.sendKeys(entity.getRightVentricularFoldObjective());
		glottisSubjectiveField.sendKeys(entity.getGlottisSubjective());
		glottisObjectiveField.sendKeys(entity.getGlottisObjective());
		rightCuneiformCartilageSubjectiveField.sendKeys(entity.getRightCuneiformCartilageSubjective());
		rightCuneiformCartilageObjectiveField.sendKeys(entity.getRightCuneiformCartilageObjective());
		rightCorniculateCartilageSubjectiveField.sendKeys(entity.getRightCorniculateCartilageSubjective());
		rightCorniculateCartilageObjectiveField.sendKeys(entity.getRightCorniculateCartilageObjective());
		tracheaSubjectiveField.sendKeys(entity.getTracheaSubjective());
		tracheaObjectiveField.sendKeys(entity.getTracheaObjective());
		leftVocalFoldSubjectiveField.sendKeys(entity.getLeftVocalFoldSubjective());
		leftVocalFoldObjectiveField.sendKeys(entity.getLeftVocalFoldObjective());
		leftVentricularFoldSubjectiveField.sendKeys(entity.getLeftVentricularFoldSubjective());
		leftVentricularFoldObjectiveField.sendKeys(entity.getLeftVentricularFoldObjective());
		leftCuneiformCartilageSubjectiveField.sendKeys(entity.getLeftCuneiformCartilageSubjective());
		leftCuneiformCartilageObjectiveField.sendKeys(entity.getLeftCuneiformCartilageObjective());
		leftCorniculateCartilageSubjectiveField.sendKeys(entity.getLeftCorniculateCartilageSubjective());
		leftCorniculateCartilageObjectiveField.sendKeys(entity.getLeftCorniculateCartilageObjective());
		softPalateSubjectiveField.sendKeys(entity.getSoftPalateSubjective());
		softPalateObjectiveField.sendKeys(entity.getSoftPalateObjective());
		rightAnteriorPillarSubjectiveField.sendKeys(entity.getRightAnteriorPillarSubjective());
		rightAnteriorPillarObjectiveField.sendKeys(entity.getRightAnteriorPillarObjective());
		uvulaSubjectiveField.sendKeys(entity.getUvulaSubjective());
		uvulaObjectiveField.sendKeys(entity.getUvulaObjective());
		rightPosteriorPillarSubjectiveField.sendKeys(entity.getRightPosteriorPillarSubjective());
		rightPosteriorPillarObjectiveField.sendKeys(entity.getRightPosteriorPillarObjective());
		rightTonsilSubjectiveField.sendKeys(entity.getRightTonsilSubjective());
		rightTonsilObjectiveField.sendKeys(entity.getRightTonsilObjective());
		rightPosteriorSubjectiveField.sendKeys(entity.getRightPosteriorSubjective());
		rightPosteriorObjectiveField.sendKeys(entity.getRightPosteriorObjective());
		upperTongueSubjectiveField.sendKeys(entity.getUpperTongueSubjective());
		upperTongueObjectiveField.sendKeys(entity.getUpperTongueObjective());
		leftAnteriorPillarSubjectiveField.sendKeys(entity.getLeftAnteriorPillarSubjective());
		leftAnteriorPillarObjectiveField.sendKeys(entity.getLeftAnteriorPillarObjective());
		leftPosteriorPillarSubjectiveField.sendKeys(entity.getLeftPosteriorPillarSubjective());
		leftPosteriorPillarObjectiveField.sendKeys(entity.getLeftPosteriorPillarObjective());
		leftTonsilSubjectiveField.sendKeys(entity.getLeftTonsilSubjective());
		leftTonsilObjectiveField.sendKeys(entity.getLeftTonsilObjective());
		leftPosteriorWallSubjectiveField.sendKeys(entity.getLeftPosteriorWallSubjective());
		leftPosteriorWallObjectiveField.sendKeys(entity.getLeftPosteriorWallObjective());

		saveButton.click();
	}
	
	// % protected region % [Add any additional methods here] off begin
	// % protected region % [Add any additional methods here] end
}