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


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class PcareNonCompoundDrugEntity extends AbstractEntity {

	public PcareNonCompoundDrugEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var PcareExaminationOneMany = new EntityReference();
			PcareExaminationOneMany.entityName = "PcareExamination";
			PcareExaminationOneMany.oppositeName = "PcareExamination";
			PcareExaminationOneMany.name = "PcareNonCompoundDrugs";
			PcareExaminationOneMany.optional = true;
			PcareExaminationOneMany.type = "One";
			PcareExaminationOneMany.oppositeType = "Many";

		References.add(PcareExaminationOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Drug Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drug Code here] end
	private String drugCode;

	// % protected region % [Modify attribute annotation for Drug Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drug Name here] end
	private String drugName;

	// % protected region % [Modify attribute annotation for Signa Days here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Signa Days here] end
	private Double signaDays;

	// % protected region % [Modify attribute annotation for Signa Times here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Signa Times here] end
	private Integer signaTimes;

	// % protected region % [Modify attribute annotation for Drug Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Drug Qty here] end
	private Double drugQty;

	// % protected region % [Modify attribute annotation for Day here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Day here] end
	private Double day;

	// % protected region % [Modify attribute annotation for Request Qty here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Request Qty here] end
	private Integer requestQty;

	// % protected region % [Modify attribute annotation for Kd Obat SK here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kd Obat SK here] end
	private String kdObatSK;

	// % protected region % [Modify attribute annotation for Racikan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Racikan here] end
	private Boolean racikan;

	// % protected region % [Modify attribute annotation for Kd Racikan here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kd Racikan here] end
	private String kdRacikan;

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

	private PcareExaminationEntity pcareExamination;

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
	 * Similar to {@link this#setPcareExamination(PcareExaminationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PcareExaminationEntity to be set to this entity
	 */
	public void setPcareExamination(@NonNull PcareExaminationEntity entity) {
		setPcareExamination(entity, true);
	}

	/**
	 * Set or update the pcareExamination in this entity with single PcareExaminationEntity.
	 *
	 * @param entity the given PcareExaminationEntity to be set or updated to pcareExamination
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPcareExamination(@NonNull PcareExaminationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPcareExamination here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPcareExamination here] end

		if (sameAsFormer(this.pcareExamination, entity)) {
			return;
		}

		if (this.pcareExamination != null) {
			this.pcareExamination.removePcareNonCompoundDrugs(this, false);
		}
		this.pcareExamination = entity;
		if (reverseAdd) {
			this.pcareExamination.addPcareNonCompoundDrugs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPcareExamination incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPcareExamination incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPcareExamination(boolean)} but default to true.
	 */
	public void unsetPcareExamination() {
		this.unsetPcareExamination(true);
	}

	/**
	 * Remove PCare Examination in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPcareExamination(boolean reverse) {
		if (reverse && this.pcareExamination != null) {
			this.pcareExamination.removePcareNonCompoundDrugs(this, false);
		}
		this.pcareExamination = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
