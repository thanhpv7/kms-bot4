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
public class HemodialysisMonitoringEntity extends AbstractEntity {

	public HemodialysisMonitoringEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var HemodialysisExaminationOneMany = new EntityReference();
			HemodialysisExaminationOneMany.entityName = "HemodialysisExamination";
			HemodialysisExaminationOneMany.oppositeName = "HemodialysisExamination";
			HemodialysisExaminationOneMany.name = "HemodialysisMonitorings";
			HemodialysisExaminationOneMany.optional = true;
			HemodialysisExaminationOneMany.type = "One";
			HemodialysisExaminationOneMany.oppositeType = "Many";

		References.add(HemodialysisExaminationOneMany);

		var MedicalStaffOneMany = new EntityReference();
			MedicalStaffOneMany.entityName = "Staff";
			MedicalStaffOneMany.oppositeName = "MedicalStaff";
			MedicalStaffOneMany.name = "HemodialysisMonitorings";
			MedicalStaffOneMany.optional = true;
			MedicalStaffOneMany.type = "One";
			MedicalStaffOneMany.oppositeType = "Many";

		References.add(MedicalStaffOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for DateTime here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for DateTime here] end
	private OffsetDateTime datetime;

	// % protected region % [Modify attribute annotation for Systole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Systole here] end
	private Double systole;

	// % protected region % [Modify attribute annotation for Diastole here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Diastole here] end
	private Double diastole;

	// % protected region % [Modify attribute annotation for Heart Rate here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Heart Rate here] end
	private Double heartRate;

	// % protected region % [Modify attribute annotation for Temperature here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Temperature here] end
	private Double temperature;

	// % protected region % [Modify attribute annotation for Temperature Unit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Temperature Unit here] end
	private String temperatureUnit;

	// % protected region % [Modify attribute annotation for Respiratory here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Respiratory here] end
	private Double respiratory;

	// % protected region % [Modify attribute annotation for QB here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for QB here] end
	private Double qb;

	// % protected region % [Modify attribute annotation for QD here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for QD here] end
	private Double qd;

	// % protected region % [Modify attribute annotation for Venous Pressure here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Venous Pressure here] end
	private Double venousPressure;

	// % protected region % [Modify attribute annotation for TMP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for TMP here] end
	private Double tmp;

	// % protected region % [Modify attribute annotation for UFG here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UFG here] end
	private Double ufg;

	// % protected region % [Modify attribute annotation for UFR here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UFR here] end
	private Double ufr;

	// % protected region % [Modify attribute annotation for UF here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for UF here] end
	private Double uf;

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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private HemodialysisExaminationEntity hemodialysisExamination;

	private StaffEntity medicalStaff;

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


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setHemodialysisExamination(HemodialysisExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given HemodialysisExaminationEntity to be set to this entity
	 */
	public void setHemodialysisExamination(@NonNull HemodialysisExaminationEntity entity) {
		setHemodialysisExamination(entity, true);
	}

	/**
	 * Set or update the hemodialysisExamination in this entity with single HemodialysisExaminationEntity.
	 *
	 * @param entity the given HemodialysisExaminationEntity to be set or updated to hemodialysisExamination
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setHemodialysisExamination(@NonNull HemodialysisExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setHemodialysisExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setHemodialysisExamination here] end

		if (sameAsFormer(this.hemodialysisExamination, entity)) {
			return;
		}

		if (this.hemodialysisExamination != null) {
			this.hemodialysisExamination.removeHemodialysisMonitorings(this, false);
		}
		this.hemodialysisExamination = entity;
		if (reverseAdd) {
			this.hemodialysisExamination.addHemodialysisMonitorings(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setHemodialysisExamination incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setHemodialysisExamination incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetHemodialysisExamination(boolean)} but default to true.
	 */
	public void unsetHemodialysisExamination() {
		this.unsetHemodialysisExamination(true);
	}

	/**
	 * Remove Hemodialysis Examination in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetHemodialysisExamination(boolean reverse) {
		if (reverse && this.hemodialysisExamination != null) {
			this.hemodialysisExamination.removeHemodialysisMonitorings(this, false);
		}
		this.hemodialysisExamination = null;
	}
	/**
	 * Similar to {@link this#setMedicalStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setMedicalStaff(@NonNull StaffEntity entity) {
		setMedicalStaff(entity, true);
	}

	/**
	 * Set or update the medicalStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to medicalStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicalStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicalStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicalStaff here] end

		if (sameAsFormer(this.medicalStaff, entity)) {
			return;
		}

		if (this.medicalStaff != null) {
			this.medicalStaff.removeHemodialysisMonitorings(this, false);
		}
		this.medicalStaff = entity;
		if (reverseAdd) {
			this.medicalStaff.addHemodialysisMonitorings(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicalStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicalStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicalStaff(boolean)} but default to true.
	 */
	public void unsetMedicalStaff() {
		this.unsetMedicalStaff(true);
	}

	/**
	 * Remove Medical Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicalStaff(boolean reverse) {
		if (reverse && this.medicalStaff != null) {
			this.medicalStaff.removeHemodialysisMonitorings(this, false);
		}
		this.medicalStaff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
