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
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PreoperativeRecordsEntity extends AbstractEntity {

	public PreoperativeRecordsEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var AdditionalAnesthesiologistsOneMany = new EntityReference();
			AdditionalAnesthesiologistsOneMany.entityName = "CoTreatingDoctor";
			AdditionalAnesthesiologistsOneMany.oppositeName = "AdditionalAnesthesiologist";
			AdditionalAnesthesiologistsOneMany.name = "AdditionalAnesthesiologists";
			AdditionalAnesthesiologistsOneMany.optional = true;
			AdditionalAnesthesiologistsOneMany.type = "One";
			AdditionalAnesthesiologistsOneMany.oppositeType = "Many";

		References.add(AdditionalAnesthesiologistsOneMany);

		var AdditionalSurgeryNursesOneMany = new EntityReference();
			AdditionalSurgeryNursesOneMany.entityName = "CoTreatingDoctor";
			AdditionalSurgeryNursesOneMany.oppositeName = "AdditionalSurgeryNurse";
			AdditionalSurgeryNursesOneMany.name = "AdditionalSurgeryNurses";
			AdditionalSurgeryNursesOneMany.optional = true;
			AdditionalSurgeryNursesOneMany.type = "One";
			AdditionalSurgeryNursesOneMany.oppositeType = "Many";

		References.add(AdditionalSurgeryNursesOneMany);

		var AnesthesiaMedicalTranscriberOneMany = new EntityReference();
			AnesthesiaMedicalTranscriberOneMany.entityName = "Staff";
			AnesthesiaMedicalTranscriberOneMany.oppositeName = "AnesthesiaMedicalTranscriber";
			AnesthesiaMedicalTranscriberOneMany.name = "AnesthesiaMedicalTranscriber";
			AnesthesiaMedicalTranscriberOneMany.optional = true;
			AnesthesiaMedicalTranscriberOneMany.type = "One";
			AnesthesiaMedicalTranscriberOneMany.oppositeType = "Many";

		References.add(AnesthesiaMedicalTranscriberOneMany);

		var AnesthesiologistOneMany = new EntityReference();
			AnesthesiologistOneMany.entityName = "Staff";
			AnesthesiologistOneMany.oppositeName = "Anesthesiologist";
			AnesthesiologistOneMany.name = "Anesthesiologist";
			AnesthesiologistOneMany.optional = true;
			AnesthesiologistOneMany.type = "One";
			AnesthesiologistOneMany.oppositeType = "Many";

		References.add(AnesthesiologistOneMany);

		var AnesthesiologyNurseOneMany = new EntityReference();
			AnesthesiologyNurseOneMany.entityName = "Staff";
			AnesthesiologyNurseOneMany.oppositeName = "AnesthesiologyNurse";
			AnesthesiologyNurseOneMany.name = "AnesthesiologyNurse";
			AnesthesiologyNurseOneMany.optional = true;
			AnesthesiologyNurseOneMany.type = "One";
			AnesthesiologyNurseOneMany.oppositeType = "Many";

		References.add(AnesthesiologyNurseOneMany);

		var BedFacilitiesOneMany = new EntityReference();
			BedFacilitiesOneMany.entityName = "BedFacility";
			BedFacilitiesOneMany.oppositeName = "PreoperativeRecords";
			BedFacilitiesOneMany.name = "BedFacilities";
			BedFacilitiesOneMany.optional = true;
			BedFacilitiesOneMany.type = "One";
			BedFacilitiesOneMany.oppositeType = "Many";

		References.add(BedFacilitiesOneMany);

		var CoTreatingAnesthesiologistsOneMany = new EntityReference();
			CoTreatingAnesthesiologistsOneMany.entityName = "CoTreatingDoctor";
			CoTreatingAnesthesiologistsOneMany.oppositeName = "CoTreatingAnesthesiologist";
			CoTreatingAnesthesiologistsOneMany.name = "CoTreatingAnesthesiologists";
			CoTreatingAnesthesiologistsOneMany.optional = true;
			CoTreatingAnesthesiologistsOneMany.type = "One";
			CoTreatingAnesthesiologistsOneMany.oppositeType = "Many";

		References.add(CoTreatingAnesthesiologistsOneMany);

		var CoTreatingSurgeonsOneMany = new EntityReference();
			CoTreatingSurgeonsOneMany.entityName = "CoTreatingDoctor";
			CoTreatingSurgeonsOneMany.oppositeName = "CoTreatingSurgeon";
			CoTreatingSurgeonsOneMany.name = "CoTreatingSurgeons";
			CoTreatingSurgeonsOneMany.optional = true;
			CoTreatingSurgeonsOneMany.type = "One";
			CoTreatingSurgeonsOneMany.oppositeType = "Many";

		References.add(CoTreatingSurgeonsOneMany);

		var PreSurgeryICD10OneMany = new EntityReference();
			PreSurgeryICD10OneMany.entityName = "DiagnosesAndProcedures";
			PreSurgeryICD10OneMany.oppositeName = "PreSurgeryICD10";
			PreSurgeryICD10OneMany.name = "PreSurgeryICD10";
			PreSurgeryICD10OneMany.optional = true;
			PreSurgeryICD10OneMany.type = "One";
			PreSurgeryICD10OneMany.oppositeType = "Many";

		References.add(PreSurgeryICD10OneMany);

		var PreSurgeryICD9CMOneMany = new EntityReference();
			PreSurgeryICD9CMOneMany.entityName = "DiagnosesAndProcedures";
			PreSurgeryICD9CMOneMany.oppositeName = "PreSurgeryICD9CM";
			PreSurgeryICD9CMOneMany.name = "PreSurgeryICD9CM";
			PreSurgeryICD9CMOneMany.optional = true;
			PreSurgeryICD9CMOneMany.type = "One";
			PreSurgeryICD9CMOneMany.oppositeType = "Many";

		References.add(PreSurgeryICD9CMOneMany);

		var OperatingTheaterMedicalExaminationRecordOneOne = new EntityReference();
			OperatingTheaterMedicalExaminationRecordOneOne.entityName = "OperatingTheaterMedicalExaminationRecord";
			OperatingTheaterMedicalExaminationRecordOneOne.oppositeName = "OperatingTheaterMedicalExaminationRecord";
			OperatingTheaterMedicalExaminationRecordOneOne.name = "PreoperativeRecords";
			OperatingTheaterMedicalExaminationRecordOneOne.optional = true;
			OperatingTheaterMedicalExaminationRecordOneOne.type = "One";
			OperatingTheaterMedicalExaminationRecordOneOne.oppositeType = "One";

		References.add(OperatingTheaterMedicalExaminationRecordOneOne);

		var PreoperativeRoomsOneMany = new EntityReference();
			PreoperativeRoomsOneMany.entityName = "RoomFacility";
			PreoperativeRoomsOneMany.oppositeName = "PreoperativeRooms";
			PreoperativeRoomsOneMany.name = "PreoperativeRooms";
			PreoperativeRoomsOneMany.optional = true;
			PreoperativeRoomsOneMany.type = "One";
			PreoperativeRoomsOneMany.oppositeType = "Many";

		References.add(PreoperativeRoomsOneMany);

		var SurgeonOneMany = new EntityReference();
			SurgeonOneMany.entityName = "Staff";
			SurgeonOneMany.oppositeName = "Surgeon";
			SurgeonOneMany.name = "Surgeon";
			SurgeonOneMany.optional = true;
			SurgeonOneMany.type = "One";
			SurgeonOneMany.oppositeType = "Many";

		References.add(SurgeonOneMany);

		var SurgicalMedicalTranscriberOneMany = new EntityReference();
			SurgicalMedicalTranscriberOneMany.entityName = "Staff";
			SurgicalMedicalTranscriberOneMany.oppositeName = "SurgicalMedicalTranscriber";
			SurgicalMedicalTranscriberOneMany.name = "SurgicalMedicalTranscriber";
			SurgicalMedicalTranscriberOneMany.optional = true;
			SurgicalMedicalTranscriberOneMany.type = "One";
			SurgicalMedicalTranscriberOneMany.oppositeType = "Many";

		References.add(SurgicalMedicalTranscriberOneMany);

		var SurgicalNurseOneMany = new EntityReference();
			SurgicalNurseOneMany.entityName = "Staff";
			SurgicalNurseOneMany.oppositeName = "SurgicalNurse";
			SurgicalNurseOneMany.name = "SurgicalNurse";
			SurgicalNurseOneMany.optional = true;
			SurgicalNurseOneMany.type = "One";
			SurgicalNurseOneMany.oppositeType = "Many";

		References.add(SurgicalNurseOneMany);
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

	// % protected region % [Modify attribute annotation for Physical Status Evaluation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Physical Status Evaluation here] end
	private String physicalStatusEvaluation;

	// % protected region % [Modify attribute annotation for Surgery Risk here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surgery Risk here] end
	private String surgeryRisk;

	// % protected region % [Modify attribute annotation for Psychological State here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Psychological State here] end
	private String psychologicalState;

	// % protected region % [Modify attribute annotation for Anesthesia Surgery Risk here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia Surgery Risk here] end
	private String anesthesiaSurgeryRisk;

	// % protected region % [Modify attribute annotation for Preoperative Evaluation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Preoperative Evaluation here] end
	private String preoperativeEvaluation;

	// % protected region % [Modify attribute annotation for Anesthesia Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Anesthesia Notes here] end
	private String anesthesiaNotes;

	// % protected region % [Modify attribute annotation for Surgical Specialty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surgical Specialty here] end
	private String surgicalSpecialty;

	// % protected region % [Modify attribute annotation for Antibiotic Prophylaxis Given here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Antibiotic Prophylaxis Given here] end
	private String antibioticProphylaxisGiven;

	// % protected region % [Modify attribute annotation for Surgery Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surgery Type here] end
	private String surgeryType;

	// % protected region % [Modify attribute annotation for Surgery Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surgery Class here] end
	private String surgeryClass;

	// % protected region % [Modify attribute annotation for Surgical Surgery Risk here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Surgical Surgery Risk here] end
	private String surgicalSurgeryRisk;

	// % protected region % [Modify attribute annotation for Physical Status Classification here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Physical Status Classification here] end
	private String physicalStatusClassification;

	// % protected region % [Modify attribute annotation for Pre Surgery Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Pre Surgery Diagnosis here] end
	private String preSurgeryDiagnosis;

	// % protected region % [Modify attribute annotation for Preoperative Instructions here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Preoperative Instructions here] end
	private String preoperativeInstructions;

	// % protected region % [Modify attribute annotation for Preoperative Surgical Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Preoperative Surgical Notes here] end
	private String preoperativeSurgicalNotes;

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

	private OperatingTheaterMedicalExaminationRecordEntity operatingTheaterMedicalExaminationRecord;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<CoTreatingDoctorEntity> additionalAnesthesiologists = new HashSet<>();

	private Set<CoTreatingDoctorEntity> additionalSurgeryNurses = new HashSet<>();

	private Set<BedFacilityEntity> bedFacilities = new HashSet<>();

	private Set<CoTreatingDoctorEntity> coTreatingAnesthesiologists = new HashSet<>();

	private Set<CoTreatingDoctorEntity> coTreatingSurgeons = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private StaffEntity anesthesiaMedicalTranscriber;

	private StaffEntity anesthesiologist;

	private StaffEntity anesthesiologyNurse;

	private DiagnosesAndProceduresEntity preSurgeryICD10;

	private DiagnosesAndProceduresEntity preSurgeryICD9CM;

	private RoomFacilityEntity preoperativeRooms;

	private StaffEntity surgeon;

	private StaffEntity surgicalMedicalTranscriber;

	private StaffEntity surgicalNurse;

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
	 * Similar to {@link this#addAdditionalAnesthesiologists(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalAnesthesiologists(@NonNull CoTreatingDoctorEntity entity) {
		addAdditionalAnesthesiologists(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to additionalAnesthesiologists in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdditionalAnesthesiologists(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.additionalAnesthesiologists.contains(entity)) {
			additionalAnesthesiologists.add(entity);
			if (reverseAdd) {
				entity.setAdditionalAnesthesiologist(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdditionalAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		addAdditionalAnesthesiologists(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Additional Anesthesiologists in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdditionalAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdditionalAnesthesiologists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdditionalAnesthesiologists(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeAdditionalAnesthesiologists(@NonNull CoTreatingDoctorEntity entity) {
		this.removeAdditionalAnesthesiologists(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdditionalAnesthesiologists(@NonNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdditionalAnesthesiologist(false);
		}
		this.additionalAnesthesiologists.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdditionalAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeAdditionalAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeAdditionalAnesthesiologists(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdditionalAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdditionalAnesthesiologists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdditionalAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setAdditionalAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		setAdditionalAnesthesiologists(entities, true);
	}

	/**
	 * Replace the current entities in Additional Anesthesiologists with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdditionalAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetAdditionalAnesthesiologists();
		this.additionalAnesthesiologists = new HashSet<>(entities);
		if (reverseAdd) {
			this.additionalAnesthesiologists.forEach(additionalAnesthesiologistsEntity -> additionalAnesthesiologistsEntity.setAdditionalAnesthesiologist(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdditionalAnesthesiologists(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdditionalAnesthesiologists() {
		this.unsetAdditionalAnesthesiologists(true);
	}

	/**
	 * Remove all the entities in Additional Anesthesiologists from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdditionalAnesthesiologists(boolean doReverse) {
		if (doReverse) {
			this.additionalAnesthesiologists.forEach(additionalAnesthesiologistsEntity -> additionalAnesthesiologistsEntity.unsetAdditionalAnesthesiologist(false));
		}
		this.additionalAnesthesiologists.clear();
	}

/**
	 * Similar to {@link this#addAdditionalSurgeryNurses(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalSurgeryNurses(@NonNull CoTreatingDoctorEntity entity) {
		addAdditionalSurgeryNurses(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to additionalSurgeryNurses in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addAdditionalSurgeryNurses(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.additionalSurgeryNurses.contains(entity)) {
			additionalSurgeryNurses.add(entity);
			if (reverseAdd) {
				entity.setAdditionalSurgeryNurse(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addAdditionalSurgeryNurses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addAdditionalSurgeryNurses(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		addAdditionalSurgeryNurses(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Additional Surgery Nurses in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addAdditionalSurgeryNurses(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addAdditionalSurgeryNurses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeAdditionalSurgeryNurses(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeAdditionalSurgeryNurses(@NonNull CoTreatingDoctorEntity entity) {
		this.removeAdditionalSurgeryNurses(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeAdditionalSurgeryNurses(@NonNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetAdditionalSurgeryNurse(false);
		}
		this.additionalSurgeryNurses.remove(entity);
	}

	/**
	 * Similar to {@link this#removeAdditionalSurgeryNurses(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeAdditionalSurgeryNurses(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeAdditionalSurgeryNurses(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeAdditionalSurgeryNurses(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeAdditionalSurgeryNurses(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setAdditionalSurgeryNurses(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setAdditionalSurgeryNurses(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		setAdditionalSurgeryNurses(entities, true);
	}

	/**
	 * Replace the current entities in Additional Surgery Nurses with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setAdditionalSurgeryNurses(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetAdditionalSurgeryNurses();
		this.additionalSurgeryNurses = new HashSet<>(entities);
		if (reverseAdd) {
			this.additionalSurgeryNurses.forEach(additionalSurgeryNursesEntity -> additionalSurgeryNursesEntity.setAdditionalSurgeryNurse(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetAdditionalSurgeryNurses(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetAdditionalSurgeryNurses() {
		this.unsetAdditionalSurgeryNurses(true);
	}

	/**
	 * Remove all the entities in Additional Surgery Nurses from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetAdditionalSurgeryNurses(boolean doReverse) {
		if (doReverse) {
			this.additionalSurgeryNurses.forEach(additionalSurgeryNursesEntity -> additionalSurgeryNursesEntity.unsetAdditionalSurgeryNurse(false));
		}
		this.additionalSurgeryNurses.clear();
	}

/**
	 * Similar to {@link this#addBedFacilities(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be added to this entity
	 */
	public void addBedFacilities(@NonNull BedFacilityEntity entity) {
		addBedFacilities(entity, true);
	}

	/**
	 * Add a new BedFacilityEntity to bedFacilities in this entity.
	 *
	 * @param entity the given BedFacilityEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBedFacilities(@NonNull BedFacilityEntity entity, boolean reverseAdd) {
		if (!this.bedFacilities.contains(entity)) {
			bedFacilities.add(entity);
			if (reverseAdd) {
				entity.setPreoperativeRecords(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBedFacilities(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BedFacilityEntity to be added to this entity
	 */
	public void addBedFacilities(@NonNull Collection<BedFacilityEntity> entities) {
		addBedFacilities(entities, true);
	}

	/**
	 * Add a new collection of BedFacilityEntity to Bed Facilities in this entity.
	 *
	 * @param entities the given collection of BedFacilityEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBedFacilities(@NonNull Collection<BedFacilityEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBedFacilities(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBedFacilities(BedFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BedFacilityEntity to be set to this entity
	 */
	public void removeBedFacilities(@NonNull BedFacilityEntity entity) {
		this.removeBedFacilities(entity, true);
	}

	/**
	 * Remove the given BedFacilityEntity from this entity.
	 *
	 * @param entity the given BedFacilityEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBedFacilities(@NonNull BedFacilityEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPreoperativeRecords(false);
		}
		this.bedFacilities.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBedFacilities(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BedFacilityEntity to be removed to this entity
	 */
	public void removeBedFacilities(@NonNull Collection<BedFacilityEntity> entities) {
		this.removeBedFacilities(entities, true);
	}

	/**
	 * Remove the given collection of BedFacilityEntity from  to this entity.
	 *
	 * @param entities the given collection of BedFacilityEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBedFacilities(@NonNull Collection<BedFacilityEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBedFacilities(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBedFacilities(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BedFacilityEntity to be set to this entity
	 */
	public void setBedFacilities(@NonNull Collection<BedFacilityEntity> entities) {
		setBedFacilities(entities, true);
	}

	/**
	 * Replace the current entities in Bed Facilities with the given ones.
	 *
	 * @param entities the given collection of BedFacilityEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBedFacilities(@NonNull Collection<BedFacilityEntity> entities, boolean reverseAdd) {

		this.unsetBedFacilities();
		this.bedFacilities = new HashSet<>(entities);
		if (reverseAdd) {
			this.bedFacilities.forEach(bedFacilitiesEntity -> bedFacilitiesEntity.setPreoperativeRecords(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBedFacilities(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBedFacilities() {
		this.unsetBedFacilities(true);
	}

	/**
	 * Remove all the entities in Bed Facilities from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBedFacilities(boolean doReverse) {
		if (doReverse) {
			this.bedFacilities.forEach(bedFacilitiesEntity -> bedFacilitiesEntity.unsetPreoperativeRecords(false));
		}
		this.bedFacilities.clear();
	}

/**
	 * Similar to {@link this#addCoTreatingAnesthesiologists(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingAnesthesiologists(@NonNull CoTreatingDoctorEntity entity) {
		addCoTreatingAnesthesiologists(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to coTreatingAnesthesiologists in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCoTreatingAnesthesiologists(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.coTreatingAnesthesiologists.contains(entity)) {
			coTreatingAnesthesiologists.add(entity);
			if (reverseAdd) {
				entity.setCoTreatingAnesthesiologist(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCoTreatingAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		addCoTreatingAnesthesiologists(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Co Treating Anesthesiologists in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCoTreatingAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCoTreatingAnesthesiologists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCoTreatingAnesthesiologists(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeCoTreatingAnesthesiologists(@NonNull CoTreatingDoctorEntity entity) {
		this.removeCoTreatingAnesthesiologists(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCoTreatingAnesthesiologists(@NonNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetCoTreatingAnesthesiologist(false);
		}
		this.coTreatingAnesthesiologists.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCoTreatingAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeCoTreatingAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeCoTreatingAnesthesiologists(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCoTreatingAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCoTreatingAnesthesiologists(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCoTreatingAnesthesiologists(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setCoTreatingAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		setCoTreatingAnesthesiologists(entities, true);
	}

	/**
	 * Replace the current entities in Co Treating Anesthesiologists with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCoTreatingAnesthesiologists(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetCoTreatingAnesthesiologists();
		this.coTreatingAnesthesiologists = new HashSet<>(entities);
		if (reverseAdd) {
			this.coTreatingAnesthesiologists.forEach(coTreatingAnesthesiologistsEntity -> coTreatingAnesthesiologistsEntity.setCoTreatingAnesthesiologist(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCoTreatingAnesthesiologists(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCoTreatingAnesthesiologists() {
		this.unsetCoTreatingAnesthesiologists(true);
	}

	/**
	 * Remove all the entities in Co Treating Anesthesiologists from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCoTreatingAnesthesiologists(boolean doReverse) {
		if (doReverse) {
			this.coTreatingAnesthesiologists.forEach(coTreatingAnesthesiologistsEntity -> coTreatingAnesthesiologistsEntity.unsetCoTreatingAnesthesiologist(false));
		}
		this.coTreatingAnesthesiologists.clear();
	}

/**
	 * Similar to {@link this#addCoTreatingSurgeons(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingSurgeons(@NonNull CoTreatingDoctorEntity entity) {
		addCoTreatingSurgeons(entity, true);
	}

	/**
	 * Add a new CoTreatingDoctorEntity to coTreatingSurgeons in this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addCoTreatingSurgeons(@NonNull CoTreatingDoctorEntity entity, boolean reverseAdd) {
		if (!this.coTreatingSurgeons.contains(entity)) {
			coTreatingSurgeons.add(entity);
			if (reverseAdd) {
				entity.setCoTreatingSurgeon(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addCoTreatingSurgeons(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 */
	public void addCoTreatingSurgeons(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		addCoTreatingSurgeons(entities, true);
	}

	/**
	 * Add a new collection of CoTreatingDoctorEntity to Co Treating Surgeons in this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addCoTreatingSurgeons(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addCoTreatingSurgeons(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeCoTreatingSurgeons(CoTreatingDoctorEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be set to this entity
	 */
	public void removeCoTreatingSurgeons(@NonNull CoTreatingDoctorEntity entity) {
		this.removeCoTreatingSurgeons(entity, true);
	}

	/**
	 * Remove the given CoTreatingDoctorEntity from this entity.
	 *
	 * @param entity the given CoTreatingDoctorEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeCoTreatingSurgeons(@NonNull CoTreatingDoctorEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetCoTreatingSurgeon(false);
		}
		this.coTreatingSurgeons.remove(entity);
	}

	/**
	 * Similar to {@link this#removeCoTreatingSurgeons(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 */
	public void removeCoTreatingSurgeons(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		this.removeCoTreatingSurgeons(entities, true);
	}

	/**
	 * Remove the given collection of CoTreatingDoctorEntity from  to this entity.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeCoTreatingSurgeons(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeCoTreatingSurgeons(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setCoTreatingSurgeons(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to be set to this entity
	 */
	public void setCoTreatingSurgeons(@NonNull Collection<CoTreatingDoctorEntity> entities) {
		setCoTreatingSurgeons(entities, true);
	}

	/**
	 * Replace the current entities in Co Treating Surgeons with the given ones.
	 *
	 * @param entities the given collection of CoTreatingDoctorEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setCoTreatingSurgeons(@NonNull Collection<CoTreatingDoctorEntity> entities, boolean reverseAdd) {

		this.unsetCoTreatingSurgeons();
		this.coTreatingSurgeons = new HashSet<>(entities);
		if (reverseAdd) {
			this.coTreatingSurgeons.forEach(coTreatingSurgeonsEntity -> coTreatingSurgeonsEntity.setCoTreatingSurgeon(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetCoTreatingSurgeons(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetCoTreatingSurgeons() {
		this.unsetCoTreatingSurgeons(true);
	}

	/**
	 * Remove all the entities in Co Treating Surgeons from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetCoTreatingSurgeons(boolean doReverse) {
		if (doReverse) {
			this.coTreatingSurgeons.forEach(coTreatingSurgeonsEntity -> coTreatingSurgeonsEntity.unsetCoTreatingSurgeon(false));
		}
		this.coTreatingSurgeons.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setAnesthesiaMedicalTranscriber(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setAnesthesiaMedicalTranscriber(@NonNull StaffEntity entity) {
		setAnesthesiaMedicalTranscriber(entity, true);
	}

	/**
	 * Set or update the anesthesiaMedicalTranscriber in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to anesthesiaMedicalTranscriber
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAnesthesiaMedicalTranscriber(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiaMedicalTranscriber here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiaMedicalTranscriber here] end

		if (sameAsFormer(this.anesthesiaMedicalTranscriber, entity)) {
			return;
		}

		if (this.anesthesiaMedicalTranscriber != null) {
			this.anesthesiaMedicalTranscriber.removeAnesthesiaMedicalTranscriber(this, false);
		}
		this.anesthesiaMedicalTranscriber = entity;
		if (reverseAdd) {
			this.anesthesiaMedicalTranscriber.addAnesthesiaMedicalTranscriber(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAnesthesiaMedicalTranscriber incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAnesthesiaMedicalTranscriber incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAnesthesiaMedicalTranscriber(boolean)} but default to true.
	 */
	public void unsetAnesthesiaMedicalTranscriber() {
		this.unsetAnesthesiaMedicalTranscriber(true);
	}

	/**
	 * Remove Anesthesia Medical Transcriber in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAnesthesiaMedicalTranscriber(boolean reverse) {
		if (reverse && this.anesthesiaMedicalTranscriber != null) {
			this.anesthesiaMedicalTranscriber.removeAnesthesiaMedicalTranscriber(this, false);
		}
		this.anesthesiaMedicalTranscriber = null;
	}
	/**
	 * Similar to {@link this#setAnesthesiologist(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setAnesthesiologist(@NonNull StaffEntity entity) {
		setAnesthesiologist(entity, true);
	}

	/**
	 * Set or update the anesthesiologist in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to anesthesiologist
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAnesthesiologist(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiologist here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiologist here] end

		if (sameAsFormer(this.anesthesiologist, entity)) {
			return;
		}

		if (this.anesthesiologist != null) {
			this.anesthesiologist.removeAnesthesiologist(this, false);
		}
		this.anesthesiologist = entity;
		if (reverseAdd) {
			this.anesthesiologist.addAnesthesiologist(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAnesthesiologist incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAnesthesiologist incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAnesthesiologist(boolean)} but default to true.
	 */
	public void unsetAnesthesiologist() {
		this.unsetAnesthesiologist(true);
	}

	/**
	 * Remove Anesthesiologist in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAnesthesiologist(boolean reverse) {
		if (reverse && this.anesthesiologist != null) {
			this.anesthesiologist.removeAnesthesiologist(this, false);
		}
		this.anesthesiologist = null;
	}
	/**
	 * Similar to {@link this#setAnesthesiologyNurse(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setAnesthesiologyNurse(@NonNull StaffEntity entity) {
		setAnesthesiologyNurse(entity, true);
	}

	/**
	 * Set or update the anesthesiologyNurse in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to anesthesiologyNurse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAnesthesiologyNurse(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiologyNurse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAnesthesiologyNurse here] end

		if (sameAsFormer(this.anesthesiologyNurse, entity)) {
			return;
		}

		if (this.anesthesiologyNurse != null) {
			this.anesthesiologyNurse.removeAnesthesiologyNurse(this, false);
		}
		this.anesthesiologyNurse = entity;
		if (reverseAdd) {
			this.anesthesiologyNurse.addAnesthesiologyNurse(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAnesthesiologyNurse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAnesthesiologyNurse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAnesthesiologyNurse(boolean)} but default to true.
	 */
	public void unsetAnesthesiologyNurse() {
		this.unsetAnesthesiologyNurse(true);
	}

	/**
	 * Remove Anesthesiology Nurse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAnesthesiologyNurse(boolean reverse) {
		if (reverse && this.anesthesiologyNurse != null) {
			this.anesthesiologyNurse.removeAnesthesiologyNurse(this, false);
		}
		this.anesthesiologyNurse = null;
	}
	/**
	 * Similar to {@link this#setPreSurgeryICD10(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setPreSurgeryICD10(@NonNull DiagnosesAndProceduresEntity entity) {
		setPreSurgeryICD10(entity, true);
	}

	/**
	 * Set or update the preSurgeryICD10 in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to preSurgeryICD10
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPreSurgeryICD10(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPreSurgeryICD10 here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPreSurgeryICD10 here] end

		if (sameAsFormer(this.preSurgeryICD10, entity)) {
			return;
		}

		if (this.preSurgeryICD10 != null) {
			this.preSurgeryICD10.removePreSurgeryICD10(this, false);
		}
		this.preSurgeryICD10 = entity;
		if (reverseAdd) {
			this.preSurgeryICD10.addPreSurgeryICD10(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPreSurgeryICD10 incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPreSurgeryICD10 incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPreSurgeryICD10(boolean)} but default to true.
	 */
	public void unsetPreSurgeryICD10() {
		this.unsetPreSurgeryICD10(true);
	}

	/**
	 * Remove Pre Surgery ICD 10 in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPreSurgeryICD10(boolean reverse) {
		if (reverse && this.preSurgeryICD10 != null) {
			this.preSurgeryICD10.removePreSurgeryICD10(this, false);
		}
		this.preSurgeryICD10 = null;
	}
	/**
	 * Similar to {@link this#setPreSurgeryICD9CM(DiagnosesAndProceduresEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set to this entity
	 */
	public void setPreSurgeryICD9CM(@NonNull DiagnosesAndProceduresEntity entity) {
		setPreSurgeryICD9CM(entity, true);
	}

	/**
	 * Set or update the preSurgeryICD9CM in this entity with single DiagnosesAndProceduresEntity.
	 *
	 * @param entity the given DiagnosesAndProceduresEntity to be set or updated to preSurgeryICD9CM
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPreSurgeryICD9CM(@NonNull DiagnosesAndProceduresEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPreSurgeryICD9CM here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPreSurgeryICD9CM here] end

		if (sameAsFormer(this.preSurgeryICD9CM, entity)) {
			return;
		}

		if (this.preSurgeryICD9CM != null) {
			this.preSurgeryICD9CM.removePreSurgeryICD9CM(this, false);
		}
		this.preSurgeryICD9CM = entity;
		if (reverseAdd) {
			this.preSurgeryICD9CM.addPreSurgeryICD9CM(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPreSurgeryICD9CM incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPreSurgeryICD9CM incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPreSurgeryICD9CM(boolean)} but default to true.
	 */
	public void unsetPreSurgeryICD9CM() {
		this.unsetPreSurgeryICD9CM(true);
	}

	/**
	 * Remove Pre Surgery ICD 9 CM in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPreSurgeryICD9CM(boolean reverse) {
		if (reverse && this.preSurgeryICD9CM != null) {
			this.preSurgeryICD9CM.removePreSurgeryICD9CM(this, false);
		}
		this.preSurgeryICD9CM = null;
	}
	/**
	 * Similar to {@link this#setOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity entity) {
		setOperatingTheaterMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the operatingTheaterMedicalExaminationRecord in this entity with single OperatingTheaterMedicalExaminationRecordEntity.
	 *
	 * @param entity the given OperatingTheaterMedicalExaminationRecordEntity to be set or updated to operatingTheaterMedicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setOperatingTheaterMedicalExaminationRecord(OperatingTheaterMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setOperatingTheaterMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setOperatingTheaterMedicalExaminationRecord here] end

		if (sameAsFormer(this.operatingTheaterMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.operatingTheaterMedicalExaminationRecord != null) {
			this.operatingTheaterMedicalExaminationRecord.unsetPreoperativeRecords(false);
		}

		this.operatingTheaterMedicalExaminationRecord = entity;
		if (reverseAdd) {
			this.operatingTheaterMedicalExaminationRecord.setPreoperativeRecords(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setOperatingTheaterMedicalExaminationRecord incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setOperatingTheaterMedicalExaminationRecord incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetOperatingTheaterMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetOperatingTheaterMedicalExaminationRecord() {
		this.unsetOperatingTheaterMedicalExaminationRecord(true);
	}

	/**
	 * Remove the OperatingTheaterMedicalExaminationRecordEntity of operatingTheaterMedicalExaminationRecord from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetOperatingTheaterMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.operatingTheaterMedicalExaminationRecord != null) {
			this.operatingTheaterMedicalExaminationRecord.unsetPreoperativeRecords();
		}
		this.operatingTheaterMedicalExaminationRecord = null;
	}
	/**
	 * Similar to {@link this#setPreoperativeRooms(RoomFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RoomFacilityEntity to be set to this entity
	 */
	public void setPreoperativeRooms(@NonNull RoomFacilityEntity entity) {
		setPreoperativeRooms(entity, true);
	}

	/**
	 * Set or update the preoperativeRooms in this entity with single RoomFacilityEntity.
	 *
	 * @param entity the given RoomFacilityEntity to be set or updated to preoperativeRooms
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPreoperativeRooms(@NonNull RoomFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPreoperativeRooms here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPreoperativeRooms here] end

		if (sameAsFormer(this.preoperativeRooms, entity)) {
			return;
		}

		if (this.preoperativeRooms != null) {
			this.preoperativeRooms.removePreoperativeRooms(this, false);
		}
		this.preoperativeRooms = entity;
		if (reverseAdd) {
			this.preoperativeRooms.addPreoperativeRooms(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPreoperativeRooms incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPreoperativeRooms incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPreoperativeRooms(boolean)} but default to true.
	 */
	public void unsetPreoperativeRooms() {
		this.unsetPreoperativeRooms(true);
	}

	/**
	 * Remove Preoperative Rooms in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPreoperativeRooms(boolean reverse) {
		if (reverse && this.preoperativeRooms != null) {
			this.preoperativeRooms.removePreoperativeRooms(this, false);
		}
		this.preoperativeRooms = null;
	}
	/**
	 * Similar to {@link this#setSurgeon(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setSurgeon(@NonNull StaffEntity entity) {
		setSurgeon(entity, true);
	}

	/**
	 * Set or update the surgeon in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to surgeon
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSurgeon(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSurgeon here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSurgeon here] end

		if (sameAsFormer(this.surgeon, entity)) {
			return;
		}

		if (this.surgeon != null) {
			this.surgeon.removeSurgeon(this, false);
		}
		this.surgeon = entity;
		if (reverseAdd) {
			this.surgeon.addSurgeon(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSurgeon incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSurgeon incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSurgeon(boolean)} but default to true.
	 */
	public void unsetSurgeon() {
		this.unsetSurgeon(true);
	}

	/**
	 * Remove Surgeon in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSurgeon(boolean reverse) {
		if (reverse && this.surgeon != null) {
			this.surgeon.removeSurgeon(this, false);
		}
		this.surgeon = null;
	}
	/**
	 * Similar to {@link this#setSurgicalMedicalTranscriber(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setSurgicalMedicalTranscriber(@NonNull StaffEntity entity) {
		setSurgicalMedicalTranscriber(entity, true);
	}

	/**
	 * Set or update the surgicalMedicalTranscriber in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to surgicalMedicalTranscriber
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSurgicalMedicalTranscriber(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSurgicalMedicalTranscriber here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSurgicalMedicalTranscriber here] end

		if (sameAsFormer(this.surgicalMedicalTranscriber, entity)) {
			return;
		}

		if (this.surgicalMedicalTranscriber != null) {
			this.surgicalMedicalTranscriber.removeSurgicalMedicalTranscriber(this, false);
		}
		this.surgicalMedicalTranscriber = entity;
		if (reverseAdd) {
			this.surgicalMedicalTranscriber.addSurgicalMedicalTranscriber(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSurgicalMedicalTranscriber incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSurgicalMedicalTranscriber incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSurgicalMedicalTranscriber(boolean)} but default to true.
	 */
	public void unsetSurgicalMedicalTranscriber() {
		this.unsetSurgicalMedicalTranscriber(true);
	}

	/**
	 * Remove Surgical Medical Transcriber in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSurgicalMedicalTranscriber(boolean reverse) {
		if (reverse && this.surgicalMedicalTranscriber != null) {
			this.surgicalMedicalTranscriber.removeSurgicalMedicalTranscriber(this, false);
		}
		this.surgicalMedicalTranscriber = null;
	}
	/**
	 * Similar to {@link this#setSurgicalNurse(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setSurgicalNurse(@NonNull StaffEntity entity) {
		setSurgicalNurse(entity, true);
	}

	/**
	 * Set or update the surgicalNurse in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to surgicalNurse
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSurgicalNurse(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSurgicalNurse here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSurgicalNurse here] end

		if (sameAsFormer(this.surgicalNurse, entity)) {
			return;
		}

		if (this.surgicalNurse != null) {
			this.surgicalNurse.removeSurgicalNurse(this, false);
		}
		this.surgicalNurse = entity;
		if (reverseAdd) {
			this.surgicalNurse.addSurgicalNurse(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSurgicalNurse incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSurgicalNurse incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSurgicalNurse(boolean)} but default to true.
	 */
	public void unsetSurgicalNurse() {
		this.unsetSurgicalNurse(true);
	}

	/**
	 * Remove Surgical Nurse in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSurgicalNurse(boolean reverse) {
		if (reverse && this.surgicalNurse != null) {
			this.surgicalNurse.removeSurgicalNurse(this, false);
		}
		this.surgicalNurse = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
