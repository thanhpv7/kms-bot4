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
package kmsweb.entities;

import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class SampleCollectionInformationEntity extends AbstractEntity {

	public SampleCollectionInformationEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var DiagnosisExaminationRecordOneOne = new EntityReference();
			DiagnosisExaminationRecordOneOne.entityName = "DiagnosisExaminationRecord";
			DiagnosisExaminationRecordOneOne.oppositeName = "DiagnosisExaminationRecord";
			DiagnosisExaminationRecordOneOne.name = "SampleCollectionInformation";
			DiagnosisExaminationRecordOneOne.optional = true;
			DiagnosisExaminationRecordOneOne.type = "One";
			DiagnosisExaminationRecordOneOne.oppositeType = "One";

		References.add(DiagnosisExaminationRecordOneOne);

		var RegistrationOneMany = new EntityReference();
			RegistrationOneMany.entityName = "Registration";
			RegistrationOneMany.oppositeName = "Registration";
			RegistrationOneMany.name = "SampleCollectionInformations";
			RegistrationOneMany.optional = true;
			RegistrationOneMany.type = "One";
			RegistrationOneMany.oppositeType = "Many";

		References.add(RegistrationOneMany);

		var SampleCollectionItemsOneMany = new EntityReference();
			SampleCollectionItemsOneMany.entityName = "SampleCollectionItems";
			SampleCollectionItemsOneMany.oppositeName = "SampleCollectionInformation";
			SampleCollectionItemsOneMany.name = "SampleCollectionItems";
			SampleCollectionItemsOneMany.optional = true;
			SampleCollectionItemsOneMany.type = "One";
			SampleCollectionItemsOneMany.oppositeType = "Many";

		References.add(SampleCollectionItemsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Patient Informed here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Informed here] end
	private Boolean patientInformed;

	// % protected region % [Modify attribute annotation for Patient Consented here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Consented here] end
	private Boolean patientConsented;

	// % protected region % [Modify attribute annotation for Patient Fasted Enough here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Patient Fasted Enough here] end
	private Boolean patientFastedEnough;

	// % protected region % [Modify attribute annotation for Medication Taken In 24 Hours here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medication Taken In 24 Hours here] end
	private Boolean medicationTakenIn24Hours;

	// % protected region % [Modify attribute annotation for Medication Taken In 72 Hours here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medication Taken In 72 Hours here] end
	private Boolean medicationTakenIn72Hours;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private DiagnosisExaminationRecordEntity diagnosisExaminationRecord;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<SampleCollectionItemsEntity> sampleCollectionItems = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private RegistrationEntity registration;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/**
	 * Similar to {@link this#addSampleCollectionItems(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleCollectionItems(@NonNull SampleCollectionItemsEntity entity) {
		addSampleCollectionItems(entity, true);
	}

	/**
	 * Add a new SampleCollectionItemsEntity to sampleCollectionItems in this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addSampleCollectionItems(@NonNull SampleCollectionItemsEntity entity, boolean reverseAdd) {
		if (!this.sampleCollectionItems.contains(entity)) {
			sampleCollectionItems.add(entity);
			if (reverseAdd) {
				entity.setSampleCollectionInformation(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addSampleCollectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 */
	public void addSampleCollectionItems(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		addSampleCollectionItems(entities, true);
	}

	/**
	 * Add a new collection of SampleCollectionItemsEntity to Sample Collection Items in this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addSampleCollectionItems(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addSampleCollectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeSampleCollectionItems(SampleCollectionItemsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be set to this entity
	 */
	public void removeSampleCollectionItems(@NonNull SampleCollectionItemsEntity entity) {
		this.removeSampleCollectionItems(entity, true);
	}

	/**
	 * Remove the given SampleCollectionItemsEntity from this entity.
	 *
	 * @param entity the given SampleCollectionItemsEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeSampleCollectionItems(@NonNull SampleCollectionItemsEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetSampleCollectionInformation(false);
		}
		this.sampleCollectionItems.remove(entity);
	}

	/**
	 * Similar to {@link this#removeSampleCollectionItems(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 */
	public void removeSampleCollectionItems(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		this.removeSampleCollectionItems(entities, true);
	}

	/**
	 * Remove the given collection of SampleCollectionItemsEntity from  to this entity.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeSampleCollectionItems(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeSampleCollectionItems(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setSampleCollectionItems(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to be set to this entity
	 */
	public void setSampleCollectionItems(@NonNull Collection<SampleCollectionItemsEntity> entities) {
		setSampleCollectionItems(entities, true);
	}

	/**
	 * Replace the current entities in Sample Collection Items with the given ones.
	 *
	 * @param entities the given collection of SampleCollectionItemsEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setSampleCollectionItems(@NonNull Collection<SampleCollectionItemsEntity> entities, boolean reverseAdd) {

		this.unsetSampleCollectionItems();
		this.sampleCollectionItems = new HashSet<>(entities);
		if (reverseAdd) {
			this.sampleCollectionItems.forEach(sampleCollectionItemsEntity -> sampleCollectionItemsEntity.setSampleCollectionInformation(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetSampleCollectionItems(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetSampleCollectionItems() {
		this.unsetSampleCollectionItems(true);
	}

	/**
	 * Remove all the entities in Sample Collection Items from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetSampleCollectionItems(boolean doReverse) {
		if (doReverse) {
			this.sampleCollectionItems.forEach(sampleCollectionItemsEntity -> sampleCollectionItemsEntity.unsetSampleCollectionInformation(false));
		}
		this.sampleCollectionItems.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setDiagnosisExaminationRecord(DiagnosisExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set to this entity
	 */
	public void setDiagnosisExaminationRecord(DiagnosisExaminationRecordEntity entity) {
		setDiagnosisExaminationRecord(entity, true);
	}

	/**
	 * Set or update the diagnosisExaminationRecord in this entity with single DiagnosisExaminationRecordEntity.
	 *
	 * @param entity the given DiagnosisExaminationRecordEntity to be set or updated to diagnosisExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDiagnosisExaminationRecord(DiagnosisExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDiagnosisExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDiagnosisExaminationRecord here] end

		if (sameAsFormer(this.diagnosisExaminationRecord, entity)) {
			return;
		}

		if (this.diagnosisExaminationRecord != null) {
			this.diagnosisExaminationRecord.unsetSampleCollectionInformation(false);
		}

		this.diagnosisExaminationRecord = entity;
		if (reverseAdd) {
			this.diagnosisExaminationRecord.setSampleCollectionInformation(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDiagnosisExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDiagnosisExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetDiagnosisExaminationRecord(boolean)} but default to true.
	 */
	public void unsetDiagnosisExaminationRecord() {
		this.unsetDiagnosisExaminationRecord(true);
	}

	/**
	 * Remove the DiagnosisExaminationRecordEntity of diagnosisExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDiagnosisExaminationRecord(boolean reverse) {
		if (reverse && this.diagnosisExaminationRecord != null) {
			this.diagnosisExaminationRecord.unsetSampleCollectionInformation();
		}
		this.diagnosisExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(@NonNull RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.removeSampleCollectionInformations(this, false);
		}
		this.registration = entity;
		if (reverseAdd) {
			this.registration.addSampleCollectionInformations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove Registration in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.removeSampleCollectionInformations(this, false);
		}
		this.registration = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
