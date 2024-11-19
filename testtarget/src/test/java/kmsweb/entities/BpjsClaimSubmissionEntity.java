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

import kmsweb.entities.enums.*;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.util.*;
import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class BpjsClaimSubmissionEntity extends AbstractEntity {

	public BpjsClaimSubmissionEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var BpjsDiagnoseOneMany = new EntityReference();
			BpjsDiagnoseOneMany.entityName = "BpjsDiagnose";
			BpjsDiagnoseOneMany.oppositeName = "BpjsDiagnose";
			BpjsDiagnoseOneMany.name = "BpjsClaimSubmissions";
			BpjsDiagnoseOneMany.optional = true;
			BpjsDiagnoseOneMany.type = "One";
			BpjsDiagnoseOneMany.oppositeType = "Many";

		References.add(BpjsDiagnoseOneMany);

		var BpjsDoctorMappingOneMany = new EntityReference();
			BpjsDoctorMappingOneMany.entityName = "BpjsDoctorMapping";
			BpjsDoctorMappingOneMany.oppositeName = "BpjsDoctorMapping";
			BpjsDoctorMappingOneMany.name = "BpjsClaimSubmissions";
			BpjsDoctorMappingOneMany.optional = true;
			BpjsDoctorMappingOneMany.type = "One";
			BpjsDoctorMappingOneMany.oppositeType = "Many";

		References.add(BpjsDoctorMappingOneMany);

		var BpjsHealthFacilityOneMany = new EntityReference();
			BpjsHealthFacilityOneMany.entityName = "BpjsHealthFacility";
			BpjsHealthFacilityOneMany.oppositeName = "BpjsHealthFacility";
			BpjsHealthFacilityOneMany.name = "BpjsClaimSubmissions";
			BpjsHealthFacilityOneMany.optional = true;
			BpjsHealthFacilityOneMany.type = "One";
			BpjsHealthFacilityOneMany.oppositeType = "Many";

		References.add(BpjsHealthFacilityOneMany);

		var BpjsProcedureOneMany = new EntityReference();
			BpjsProcedureOneMany.entityName = "BpjsProcedure";
			BpjsProcedureOneMany.oppositeName = "BpjsProcedure";
			BpjsProcedureOneMany.name = "BpjsClaimSubmissions";
			BpjsProcedureOneMany.optional = true;
			BpjsProcedureOneMany.type = "One";
			BpjsProcedureOneMany.oppositeType = "Many";

		References.add(BpjsProcedureOneMany);

		var BpjsServiceMappingOneMany = new EntityReference();
			BpjsServiceMappingOneMany.entityName = "BpjsServiceMapping";
			BpjsServiceMappingOneMany.oppositeName = "BpjsServiceMapping";
			BpjsServiceMappingOneMany.name = "BpjsClaimSubmissions";
			BpjsServiceMappingOneMany.optional = true;
			BpjsServiceMappingOneMany.type = "One";
			BpjsServiceMappingOneMany.oppositeType = "Many";

		References.add(BpjsServiceMappingOneMany);

		var PatientGeneralInfoOneMany = new EntityReference();
			PatientGeneralInfoOneMany.entityName = "PatientGeneralInfo";
			PatientGeneralInfoOneMany.oppositeName = "PatientGeneralInfo";
			PatientGeneralInfoOneMany.name = "BpjsClaimSubmissions";
			PatientGeneralInfoOneMany.optional = true;
			PatientGeneralInfoOneMany.type = "One";
			PatientGeneralInfoOneMany.oppositeType = "Many";

		References.add(PatientGeneralInfoOneMany);

		var PatientPaymentBPJSOneMany = new EntityReference();
			PatientPaymentBPJSOneMany.entityName = "PatientPaymentBPJS";
			PatientPaymentBPJSOneMany.oppositeName = "PatientPaymentBPJS";
			PatientPaymentBPJSOneMany.name = "BpjsClaimSubmissions";
			PatientPaymentBPJSOneMany.optional = true;
			PatientPaymentBPJSOneMany.type = "One";
			PatientPaymentBPJSOneMany.oppositeType = "Many";

		References.add(PatientPaymentBPJSOneMany);

		var BpjsDismissalConditionsOneMany = new EntityReference();
			BpjsDismissalConditionsOneMany.entityName = "BpjsDismissalCondition";
			BpjsDismissalConditionsOneMany.oppositeName = "BpjsClaimSubmission";
			BpjsDismissalConditionsOneMany.name = "BpjsDismissalConditions";
			BpjsDismissalConditionsOneMany.optional = true;
			BpjsDismissalConditionsOneMany.type = "One";
			BpjsDismissalConditionsOneMany.oppositeType = "Many";

		References.add(BpjsDismissalConditionsOneMany);

		var BpjsDismissalMappingsOneMany = new EntityReference();
			BpjsDismissalMappingsOneMany.entityName = "BpjsDismissalMapping";
			BpjsDismissalMappingsOneMany.oppositeName = "BpjsClaimSubmission";
			BpjsDismissalMappingsOneMany.name = "BpjsDismissalMappings";
			BpjsDismissalMappingsOneMany.optional = true;
			BpjsDismissalMappingsOneMany.type = "One";
			BpjsDismissalMappingsOneMany.oppositeType = "Many";

		References.add(BpjsDismissalMappingsOneMany);

		var BpjsTreatmentRoomsOneMany = new EntityReference();
			BpjsTreatmentRoomsOneMany.entityName = "BpjsTreatmentRoom";
			BpjsTreatmentRoomsOneMany.oppositeName = "BpjsClaimSubmission";
			BpjsTreatmentRoomsOneMany.name = "BpjsTreatmentRooms";
			BpjsTreatmentRoomsOneMany.optional = true;
			BpjsTreatmentRoomsOneMany.type = "One";
			BpjsTreatmentRoomsOneMany.oppositeType = "Many";

		References.add(BpjsTreatmentRoomsOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for SEP No here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for SEP No here] end
	private String sepNo;

	// % protected region % [Modify attribute annotation for Admission Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Admission Date here] end
	private OffsetDateTime admissionDate;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

	// % protected region % [Modify attribute annotation for Insurance Provider here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Insurance Provider here] end
	private String insuranceProvider;

	// % protected region % [Modify attribute annotation for Treatment Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Treatment Type here] end
	private String treatmentType;

	// % protected region % [Modify attribute annotation for Follow Up Plan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Follow Up Plan here] end
	private String followUpPlan;

	// % protected region % [Modify attribute annotation for Control Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Control Date here] end
	private OffsetDateTime controlDate;

	// % protected region % [Modify attribute annotation for Additional Diagnosis here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Additional Diagnosis here] end
	private String additionalDiagnosis;

	// % protected region % [Modify attribute annotation for Additional Procedure here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Additional Procedure here] end
	private String additionalProcedure;

	// % protected region % [Modify attribute annotation for Kelas Rawat here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kelas Rawat here] end
	private KelasRawatEnum kelasRawat;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private Set<BpjsDismissalConditionEntity> bpjsDismissalConditions = new HashSet<>();

	private Set<BpjsDismissalMappingEntity> bpjsDismissalMappings = new HashSet<>();

	private Set<BpjsTreatmentRoomEntity> bpjsTreatmentRooms = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private BpjsDiagnoseEntity bpjsDiagnose;

	private BpjsDoctorMappingEntity bpjsDoctorMapping;

	private BpjsHealthFacilityEntity bpjsHealthFacility;

	private BpjsProcedureEntity bpjsProcedure;

	private BpjsServiceMappingEntity bpjsServiceMapping;

	private PatientGeneralInfoEntity patientGeneralInfo;

	private PatientPaymentBPJSEntity patientPaymentBPJS;

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
	 * Similar to {@link this#addBpjsDismissalConditions(BpjsDismissalConditionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDismissalConditionEntity to be added to this entity
	 */
	public void addBpjsDismissalConditions(@NonNull BpjsDismissalConditionEntity entity) {
		addBpjsDismissalConditions(entity, true);
	}

	/**
	 * Add a new BpjsDismissalConditionEntity to bpjsDismissalConditions in this entity.
	 *
	 * @param entity the given BpjsDismissalConditionEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsDismissalConditions(@NonNull BpjsDismissalConditionEntity entity, boolean reverseAdd) {
		if (!this.bpjsDismissalConditions.contains(entity)) {
			bpjsDismissalConditions.add(entity);
			if (reverseAdd) {
				entity.setBpjsClaimSubmission(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsDismissalConditions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to be added to this entity
	 */
	public void addBpjsDismissalConditions(@NonNull Collection<BpjsDismissalConditionEntity> entities) {
		addBpjsDismissalConditions(entities, true);
	}

	/**
	 * Add a new collection of BpjsDismissalConditionEntity to BPJS Dismissal Conditions in this entity.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsDismissalConditions(@NonNull Collection<BpjsDismissalConditionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsDismissalConditions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsDismissalConditions(BpjsDismissalConditionEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDismissalConditionEntity to be set to this entity
	 */
	public void removeBpjsDismissalConditions(@NonNull BpjsDismissalConditionEntity entity) {
		this.removeBpjsDismissalConditions(entity, true);
	}

	/**
	 * Remove the given BpjsDismissalConditionEntity from this entity.
	 *
	 * @param entity the given BpjsDismissalConditionEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsDismissalConditions(@NonNull BpjsDismissalConditionEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsClaimSubmission(false);
		}
		this.bpjsDismissalConditions.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsDismissalConditions(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to be removed to this entity
	 */
	public void removeBpjsDismissalConditions(@NonNull Collection<BpjsDismissalConditionEntity> entities) {
		this.removeBpjsDismissalConditions(entities, true);
	}

	/**
	 * Remove the given collection of BpjsDismissalConditionEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsDismissalConditions(@NonNull Collection<BpjsDismissalConditionEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsDismissalConditions(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsDismissalConditions(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to be set to this entity
	 */
	public void setBpjsDismissalConditions(@NonNull Collection<BpjsDismissalConditionEntity> entities) {
		setBpjsDismissalConditions(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Dismissal Conditions with the given ones.
	 *
	 * @param entities the given collection of BpjsDismissalConditionEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsDismissalConditions(@NonNull Collection<BpjsDismissalConditionEntity> entities, boolean reverseAdd) {

		this.unsetBpjsDismissalConditions();
		this.bpjsDismissalConditions = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsDismissalConditions.forEach(bpjsDismissalConditionsEntity -> bpjsDismissalConditionsEntity.setBpjsClaimSubmission(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsDismissalConditions(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsDismissalConditions() {
		this.unsetBpjsDismissalConditions(true);
	}

	/**
	 * Remove all the entities in BPJS Dismissal Conditions from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsDismissalConditions(boolean doReverse) {
		if (doReverse) {
			this.bpjsDismissalConditions.forEach(bpjsDismissalConditionsEntity -> bpjsDismissalConditionsEntity.unsetBpjsClaimSubmission(false));
		}
		this.bpjsDismissalConditions.clear();
	}

/**
	 * Similar to {@link this#addBpjsDismissalMappings(BpjsDismissalMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDismissalMappingEntity to be added to this entity
	 */
	public void addBpjsDismissalMappings(@NonNull BpjsDismissalMappingEntity entity) {
		addBpjsDismissalMappings(entity, true);
	}

	/**
	 * Add a new BpjsDismissalMappingEntity to bpjsDismissalMappings in this entity.
	 *
	 * @param entity the given BpjsDismissalMappingEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsDismissalMappings(@NonNull BpjsDismissalMappingEntity entity, boolean reverseAdd) {
		if (!this.bpjsDismissalMappings.contains(entity)) {
			bpjsDismissalMappings.add(entity);
			if (reverseAdd) {
				entity.setBpjsClaimSubmission(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsDismissalMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to be added to this entity
	 */
	public void addBpjsDismissalMappings(@NonNull Collection<BpjsDismissalMappingEntity> entities) {
		addBpjsDismissalMappings(entities, true);
	}

	/**
	 * Add a new collection of BpjsDismissalMappingEntity to BPJS Dismissal Mappings in this entity.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsDismissalMappings(@NonNull Collection<BpjsDismissalMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsDismissalMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsDismissalMappings(BpjsDismissalMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDismissalMappingEntity to be set to this entity
	 */
	public void removeBpjsDismissalMappings(@NonNull BpjsDismissalMappingEntity entity) {
		this.removeBpjsDismissalMappings(entity, true);
	}

	/**
	 * Remove the given BpjsDismissalMappingEntity from this entity.
	 *
	 * @param entity the given BpjsDismissalMappingEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsDismissalMappings(@NonNull BpjsDismissalMappingEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsClaimSubmission(false);
		}
		this.bpjsDismissalMappings.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsDismissalMappings(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to be removed to this entity
	 */
	public void removeBpjsDismissalMappings(@NonNull Collection<BpjsDismissalMappingEntity> entities) {
		this.removeBpjsDismissalMappings(entities, true);
	}

	/**
	 * Remove the given collection of BpjsDismissalMappingEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsDismissalMappings(@NonNull Collection<BpjsDismissalMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsDismissalMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsDismissalMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to be set to this entity
	 */
	public void setBpjsDismissalMappings(@NonNull Collection<BpjsDismissalMappingEntity> entities) {
		setBpjsDismissalMappings(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Dismissal Mappings with the given ones.
	 *
	 * @param entities the given collection of BpjsDismissalMappingEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsDismissalMappings(@NonNull Collection<BpjsDismissalMappingEntity> entities, boolean reverseAdd) {

		this.unsetBpjsDismissalMappings();
		this.bpjsDismissalMappings = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsDismissalMappings.forEach(bpjsDismissalMappingsEntity -> bpjsDismissalMappingsEntity.setBpjsClaimSubmission(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsDismissalMappings(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsDismissalMappings() {
		this.unsetBpjsDismissalMappings(true);
	}

	/**
	 * Remove all the entities in BPJS Dismissal Mappings from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsDismissalMappings(boolean doReverse) {
		if (doReverse) {
			this.bpjsDismissalMappings.forEach(bpjsDismissalMappingsEntity -> bpjsDismissalMappingsEntity.unsetBpjsClaimSubmission(false));
		}
		this.bpjsDismissalMappings.clear();
	}

/**
	 * Similar to {@link this#addBpjsTreatmentRooms(BpjsTreatmentRoomEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsTreatmentRoomEntity to be added to this entity
	 */
	public void addBpjsTreatmentRooms(@NonNull BpjsTreatmentRoomEntity entity) {
		addBpjsTreatmentRooms(entity, true);
	}

	/**
	 * Add a new BpjsTreatmentRoomEntity to bpjsTreatmentRooms in this entity.
	 *
	 * @param entity the given BpjsTreatmentRoomEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsTreatmentRooms(@NonNull BpjsTreatmentRoomEntity entity, boolean reverseAdd) {
		if (!this.bpjsTreatmentRooms.contains(entity)) {
			bpjsTreatmentRooms.add(entity);
			if (reverseAdd) {
				entity.setBpjsClaimSubmission(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsTreatmentRooms(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to be added to this entity
	 */
	public void addBpjsTreatmentRooms(@NonNull Collection<BpjsTreatmentRoomEntity> entities) {
		addBpjsTreatmentRooms(entities, true);
	}

	/**
	 * Add a new collection of BpjsTreatmentRoomEntity to BPJS Treatment Rooms in this entity.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsTreatmentRooms(@NonNull Collection<BpjsTreatmentRoomEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsTreatmentRooms(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsTreatmentRooms(BpjsTreatmentRoomEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsTreatmentRoomEntity to be set to this entity
	 */
	public void removeBpjsTreatmentRooms(@NonNull BpjsTreatmentRoomEntity entity) {
		this.removeBpjsTreatmentRooms(entity, true);
	}

	/**
	 * Remove the given BpjsTreatmentRoomEntity from this entity.
	 *
	 * @param entity the given BpjsTreatmentRoomEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsTreatmentRooms(@NonNull BpjsTreatmentRoomEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetBpjsClaimSubmission(false);
		}
		this.bpjsTreatmentRooms.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsTreatmentRooms(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to be removed to this entity
	 */
	public void removeBpjsTreatmentRooms(@NonNull Collection<BpjsTreatmentRoomEntity> entities) {
		this.removeBpjsTreatmentRooms(entities, true);
	}

	/**
	 * Remove the given collection of BpjsTreatmentRoomEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsTreatmentRooms(@NonNull Collection<BpjsTreatmentRoomEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsTreatmentRooms(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsTreatmentRooms(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to be set to this entity
	 */
	public void setBpjsTreatmentRooms(@NonNull Collection<BpjsTreatmentRoomEntity> entities) {
		setBpjsTreatmentRooms(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Treatment Rooms with the given ones.
	 *
	 * @param entities the given collection of BpjsTreatmentRoomEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsTreatmentRooms(@NonNull Collection<BpjsTreatmentRoomEntity> entities, boolean reverseAdd) {

		this.unsetBpjsTreatmentRooms();
		this.bpjsTreatmentRooms = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsTreatmentRooms.forEach(bpjsTreatmentRoomsEntity -> bpjsTreatmentRoomsEntity.setBpjsClaimSubmission(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsTreatmentRooms(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsTreatmentRooms() {
		this.unsetBpjsTreatmentRooms(true);
	}

	/**
	 * Remove all the entities in BPJS Treatment Rooms from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsTreatmentRooms(boolean doReverse) {
		if (doReverse) {
			this.bpjsTreatmentRooms.forEach(bpjsTreatmentRoomsEntity -> bpjsTreatmentRoomsEntity.unsetBpjsClaimSubmission(false));
		}
		this.bpjsTreatmentRooms.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setBpjsDiagnose(BpjsDiagnoseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set to this entity
	 */
	public void setBpjsDiagnose(@NonNull BpjsDiagnoseEntity entity) {
		setBpjsDiagnose(entity, true);
	}

	/**
	 * Set or update the bpjsDiagnose in this entity with single BpjsDiagnoseEntity.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set or updated to bpjsDiagnose
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDiagnose(@NonNull BpjsDiagnoseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnose here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDiagnose here] end

		if (sameAsFormer(this.bpjsDiagnose, entity)) {
			return;
		}

		if (this.bpjsDiagnose != null) {
			this.bpjsDiagnose.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsDiagnose = entity;
		if (reverseAdd) {
			this.bpjsDiagnose.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnose incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDiagnose incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDiagnose(boolean)} but default to true.
	 */
	public void unsetBpjsDiagnose() {
		this.unsetBpjsDiagnose(true);
	}

	/**
	 * Remove BPJS Diagnose in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDiagnose(boolean reverse) {
		if (reverse && this.bpjsDiagnose != null) {
			this.bpjsDiagnose.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsDiagnose = null;
	}
	/**
	 * Similar to {@link this#setBpjsDoctorMapping(BpjsDoctorMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDoctorMappingEntity to be set to this entity
	 */
	public void setBpjsDoctorMapping(@NonNull BpjsDoctorMappingEntity entity) {
		setBpjsDoctorMapping(entity, true);
	}

	/**
	 * Set or update the bpjsDoctorMapping in this entity with single BpjsDoctorMappingEntity.
	 *
	 * @param entity the given BpjsDoctorMappingEntity to be set or updated to bpjsDoctorMapping
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDoctorMapping(@NonNull BpjsDoctorMappingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDoctorMapping here] end

		if (sameAsFormer(this.bpjsDoctorMapping, entity)) {
			return;
		}

		if (this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsDoctorMapping = entity;
		if (reverseAdd) {
			this.bpjsDoctorMapping.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDoctorMapping incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDoctorMapping(boolean)} but default to true.
	 */
	public void unsetBpjsDoctorMapping() {
		this.unsetBpjsDoctorMapping(true);
	}

	/**
	 * Remove BPJS Doctor Mapping in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDoctorMapping(boolean reverse) {
		if (reverse && this.bpjsDoctorMapping != null) {
			this.bpjsDoctorMapping.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsDoctorMapping = null;
	}
	/**
	 * Similar to {@link this#setBpjsHealthFacility(BpjsHealthFacilityEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsHealthFacilityEntity to be set to this entity
	 */
	public void setBpjsHealthFacility(@NonNull BpjsHealthFacilityEntity entity) {
		setBpjsHealthFacility(entity, true);
	}

	/**
	 * Set or update the bpjsHealthFacility in this entity with single BpjsHealthFacilityEntity.
	 *
	 * @param entity the given BpjsHealthFacilityEntity to be set or updated to bpjsHealthFacility
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsHealthFacility(@NonNull BpjsHealthFacilityEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsHealthFacility here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsHealthFacility here] end

		if (sameAsFormer(this.bpjsHealthFacility, entity)) {
			return;
		}

		if (this.bpjsHealthFacility != null) {
			this.bpjsHealthFacility.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsHealthFacility = entity;
		if (reverseAdd) {
			this.bpjsHealthFacility.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsHealthFacility incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsHealthFacility incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsHealthFacility(boolean)} but default to true.
	 */
	public void unsetBpjsHealthFacility() {
		this.unsetBpjsHealthFacility(true);
	}

	/**
	 * Remove BPJS Health Facility in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsHealthFacility(boolean reverse) {
		if (reverse && this.bpjsHealthFacility != null) {
			this.bpjsHealthFacility.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsHealthFacility = null;
	}
	/**
	 * Similar to {@link this#setBpjsProcedure(BpjsProcedureEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsProcedureEntity to be set to this entity
	 */
	public void setBpjsProcedure(@NonNull BpjsProcedureEntity entity) {
		setBpjsProcedure(entity, true);
	}

	/**
	 * Set or update the bpjsProcedure in this entity with single BpjsProcedureEntity.
	 *
	 * @param entity the given BpjsProcedureEntity to be set or updated to bpjsProcedure
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsProcedure(@NonNull BpjsProcedureEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsProcedure here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsProcedure here] end

		if (sameAsFormer(this.bpjsProcedure, entity)) {
			return;
		}

		if (this.bpjsProcedure != null) {
			this.bpjsProcedure.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsProcedure = entity;
		if (reverseAdd) {
			this.bpjsProcedure.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsProcedure incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsProcedure incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsProcedure(boolean)} but default to true.
	 */
	public void unsetBpjsProcedure() {
		this.unsetBpjsProcedure(true);
	}

	/**
	 * Remove BPJS Procedure in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsProcedure(boolean reverse) {
		if (reverse && this.bpjsProcedure != null) {
			this.bpjsProcedure.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsProcedure = null;
	}
	/**
	 * Similar to {@link this#setBpjsServiceMapping(BpjsServiceMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsServiceMappingEntity to be set to this entity
	 */
	public void setBpjsServiceMapping(@NonNull BpjsServiceMappingEntity entity) {
		setBpjsServiceMapping(entity, true);
	}

	/**
	 * Set or update the bpjsServiceMapping in this entity with single BpjsServiceMappingEntity.
	 *
	 * @param entity the given BpjsServiceMappingEntity to be set or updated to bpjsServiceMapping
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsServiceMapping(@NonNull BpjsServiceMappingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsServiceMapping here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsServiceMapping here] end

		if (sameAsFormer(this.bpjsServiceMapping, entity)) {
			return;
		}

		if (this.bpjsServiceMapping != null) {
			this.bpjsServiceMapping.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsServiceMapping = entity;
		if (reverseAdd) {
			this.bpjsServiceMapping.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsServiceMapping incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsServiceMapping incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsServiceMapping(boolean)} but default to true.
	 */
	public void unsetBpjsServiceMapping() {
		this.unsetBpjsServiceMapping(true);
	}

	/**
	 * Remove BPJS Service Mapping in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsServiceMapping(boolean reverse) {
		if (reverse && this.bpjsServiceMapping != null) {
			this.bpjsServiceMapping.removeBpjsClaimSubmissions(this, false);
		}
		this.bpjsServiceMapping = null;
	}
	/**
	 * Similar to {@link this#setPatientGeneralInfo(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatientGeneralInfo(@NonNull PatientGeneralInfoEntity entity) {
		setPatientGeneralInfo(entity, true);
	}

	/**
	 * Set or update the patientGeneralInfo in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patientGeneralInfo
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientGeneralInfo(@NonNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientGeneralInfo here] end

		if (sameAsFormer(this.patientGeneralInfo, entity)) {
			return;
		}

		if (this.patientGeneralInfo != null) {
			this.patientGeneralInfo.removeBpjsClaimSubmissions(this, false);
		}
		this.patientGeneralInfo = entity;
		if (reverseAdd) {
			this.patientGeneralInfo.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientGeneralInfo incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientGeneralInfo(boolean)} but default to true.
	 */
	public void unsetPatientGeneralInfo() {
		this.unsetPatientGeneralInfo(true);
	}

	/**
	 * Remove Patient General Info in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientGeneralInfo(boolean reverse) {
		if (reverse && this.patientGeneralInfo != null) {
			this.patientGeneralInfo.removeBpjsClaimSubmissions(this, false);
		}
		this.patientGeneralInfo = null;
	}
	/**
	 * Similar to {@link this#setPatientPaymentBPJS(PatientPaymentBPJSEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientPaymentBPJSEntity to be set to this entity
	 */
	public void setPatientPaymentBPJS(@NonNull PatientPaymentBPJSEntity entity) {
		setPatientPaymentBPJS(entity, true);
	}

	/**
	 * Set or update the patientPaymentBPJS in this entity with single PatientPaymentBPJSEntity.
	 *
	 * @param entity the given PatientPaymentBPJSEntity to be set or updated to patientPaymentBPJS
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientPaymentBPJS(@NonNull PatientPaymentBPJSEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientPaymentBPJS here] end

		if (sameAsFormer(this.patientPaymentBPJS, entity)) {
			return;
		}

		if (this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.removeBpjsClaimSubmissions(this, false);
		}
		this.patientPaymentBPJS = entity;
		if (reverseAdd) {
			this.patientPaymentBPJS.addBpjsClaimSubmissions(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientPaymentBPJS incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatientPaymentBPJS(boolean)} but default to true.
	 */
	public void unsetPatientPaymentBPJS() {
		this.unsetPatientPaymentBPJS(true);
	}

	/**
	 * Remove Patient Payment BPJS in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientPaymentBPJS(boolean reverse) {
		if (reverse && this.patientPaymentBPJS != null) {
			this.patientPaymentBPJS.removeBpjsClaimSubmissions(this, false);
		}
		this.patientPaymentBPJS = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
