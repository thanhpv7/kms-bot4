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

import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class InpatientMedicalExaminationRecordEntity extends AbstractEntity {

	public InpatientMedicalExaminationRecordEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BedFacilityOneMany = new EntityReference();
			BedFacilityOneMany.entityName = "BedFacility";
			BedFacilityOneMany.oppositeName = "BedFacility";
			BedFacilityOneMany.name = "InpatientMedicalExaminationRecords";
			BedFacilityOneMany.optional = true;
			BedFacilityOneMany.type = "One";
			BedFacilityOneMany.oppositeType = "Many";

		References.add(BedFacilityOneMany);

		var MedicalExaminationRecordOneOne = new EntityReference();
			MedicalExaminationRecordOneOne.entityName = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.oppositeName = "InpatientMedicalExaminationRecord";
			MedicalExaminationRecordOneOne.name = "MedicalExaminationRecord";
			MedicalExaminationRecordOneOne.optional = true;
			MedicalExaminationRecordOneOne.type = "One";
			MedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(MedicalExaminationRecordOneOne);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Start Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Start Date Time here] end
	private OffsetDateTime startDateTime;

	// % protected region % [Modify attribute annotation for End Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for End Date Time here] end
	private OffsetDateTime endDateTime;

	// % protected region % [Modify attribute annotation for Treatment Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Treatment Class here] end
	private String treatmentClass;

	// % protected region % [Modify attribute annotation for Inpatient Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Inpatient Case here] end
	private String inpatientCase;

	// % protected region % [Modify attribute annotation for Service Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Service Case here] end
	private String serviceCase;

	// % protected region % [Modify attribute annotation for Dependency Level here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dependency Level here] end
	private String dependencyLevel;

	// % protected region % [Modify attribute annotation for Current Dependency here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Current Dependency here] end
	private String currentDependency;

	// % protected region % [Modify attribute annotation for Infant Condition here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Infant Condition here] end
	private String infantCondition;

	// % protected region % [Modify attribute annotation for Neonatal Case here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Neonatal Case here] end
	private String neonatalCase;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private MedicalExaminationRecordEntity medicalExaminationRecord;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BedFacilityEntity bedFacility;

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
	 * Similar to {@link this#setMedicalExaminationRecord(MedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InpatientMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setMedicalExaminationRecord(@NonNull MedicalExaminationRecordEntity entity) {
		setMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update medicalExaminationRecord with the given MedicalExaminationRecordEntity.
	 *
	 * @param entity the InpatientMedicalExaminationRecordEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalExaminationRecord(@NonNull MedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalExaminationRecord here] end

		if (sameAsFormer(this.medicalExaminationRecord, entity)) {
			return;
		}

		if (this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetInpatientMedicalExaminationRecord();
		}

		this.medicalExaminationRecord = entity;

		if (reverseAdd) {
			this.medicalExaminationRecord.setInpatientMedicalExaminationRecord(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalExaminationRecord outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetMedicalExaminationRecord() {
		this.unsetMedicalExaminationRecord(true);
	}

	/**
	 * Remove the MedicalExaminationRecordEntity in Medical Examination Record from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.medicalExaminationRecord != null) {
			this.medicalExaminationRecord.unsetInpatientMedicalExaminationRecord(false);
		}
		this.medicalExaminationRecord = null;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setBedFacility(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be set to this entity
	 */
	public void setBedFacility(@NonNull BedFacilityEntity entity) {
		setBedFacility(entity, true);
	}

	/**
	 * Set or update the bedFacility in this entity with single BedFacilityEntity.
	 *
	 * @param entity the given BedFacilityEntity to be set or updated to bedFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBedFacility(@NonNull BedFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBedFacility here] end

		if (sameAsFormer(this.bedFacility, entity)) {
			return;
		}

		if (this.bedFacility != null) {
			this.bedFacility.removeInpatientMedicalExaminationRecords(this, false);
		}
		this.bedFacility = entity;
		if (reverseAdd) {
			this.bedFacility.addInpatientMedicalExaminationRecords(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBedFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBedFacility(boolean)} but default to true.
	 */
	public void unsetBedFacility() {
		this.unsetBedFacility(true);
	}

	/**
	 * Remove Bed Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBedFacility(boolean reverse) {
		if (reverse && this.bedFacility != null) {
			this.bedFacility.removeInpatientMedicalExaminationRecords(this, false);
		}
		this.bedFacility = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
