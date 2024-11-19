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
public class SampleCollectionItemsEntity extends AbstractEntity {

	public SampleCollectionItemsEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var SampleCollectionInformationOneMany = new EntityReference();
			SampleCollectionInformationOneMany.entityName = "SampleCollectionInformation";
			SampleCollectionInformationOneMany.oppositeName = "SampleCollectionInformation";
			SampleCollectionInformationOneMany.name = "SampleCollectionItems";
			SampleCollectionInformationOneMany.optional = true;
			SampleCollectionInformationOneMany.type = "One";
			SampleCollectionInformationOneMany.oppositeType = "Many";

		References.add(SampleCollectionInformationOneMany);

		var SampleCollectionStaffOneMany = new EntityReference();
			SampleCollectionStaffOneMany.entityName = "Staff";
			SampleCollectionStaffOneMany.oppositeName = "SampleCollectionStaff";
			SampleCollectionStaffOneMany.name = "SampleCollectionStaffs";
			SampleCollectionStaffOneMany.optional = true;
			SampleCollectionStaffOneMany.type = "One";
			SampleCollectionStaffOneMany.oppositeType = "Many";

		References.add(SampleCollectionStaffOneMany);

		var SampleDeliveryStaffOneMany = new EntityReference();
			SampleDeliveryStaffOneMany.entityName = "Staff";
			SampleDeliveryStaffOneMany.oppositeName = "SampleDeliveryStaff";
			SampleDeliveryStaffOneMany.name = "SampleDeliveryStaffs";
			SampleDeliveryStaffOneMany.optional = true;
			SampleDeliveryStaffOneMany.type = "One";
			SampleDeliveryStaffOneMany.oppositeType = "Many";

		References.add(SampleDeliveryStaffOneMany);

		var SampleProcessingStaffOneMany = new EntityReference();
			SampleProcessingStaffOneMany.entityName = "Staff";
			SampleProcessingStaffOneMany.oppositeName = "SampleProcessingStaff";
			SampleProcessingStaffOneMany.name = "SampleProcessingStaffs";
			SampleProcessingStaffOneMany.optional = true;
			SampleProcessingStaffOneMany.type = "One";
			SampleProcessingStaffOneMany.oppositeType = "Many";

		References.add(SampleProcessingStaffOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Sample Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sample Type here] end
	private String sampleType;

	// % protected region % [Modify attribute annotation for Sample Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sample Number here] end
	private String sampleNumber;

	// % protected region % [Modify attribute annotation for Sample Taking Location here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sample Taking Location here] end
	private String sampleTakingLocation;

	// % protected region % [Modify attribute annotation for Volume here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Volume here] end
	private String volume;

	// % protected region % [Modify attribute annotation for Container here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Container here] end
	private String container;

	// % protected region % [Modify attribute annotation for Transport here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transport here] end
	private String transport;

	// % protected region % [Modify attribute annotation for Sample Collection Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sample Collection Date Time here] end
	private OffsetDateTime sampleCollectionDateTime;

	// % protected region % [Modify attribute annotation for Sample Processing Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sample Processing Date Time here] end
	private OffsetDateTime sampleProcessingDateTime;

	// % protected region % [Modify attribute annotation for Sample Delivery Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sample Delivery Date Time here] end
	private OffsetDateTime sampleDeliveryDateTime;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

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

	private SampleCollectionInformationEntity sampleCollectionInformation;

	private StaffEntity sampleCollectionStaff;

	private StaffEntity sampleDeliveryStaff;

	private StaffEntity sampleProcessingStaff;

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
	 * Similar to {@link this#setSampleCollectionInformation(SampleCollectionInformationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SampleCollectionInformationEntity to be set to this entity
	 */
	public void setSampleCollectionInformation(@NonNull SampleCollectionInformationEntity entity) {
		setSampleCollectionInformation(entity, true);
	}

	/**
	 * Set or update the sampleCollectionInformation in this entity with single SampleCollectionInformationEntity.
	 *
	 * @param entity the given SampleCollectionInformationEntity to be set or updated to sampleCollectionInformation
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSampleCollectionInformation(@NonNull SampleCollectionInformationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSampleCollectionInformation here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSampleCollectionInformation here] end

		if (sameAsFormer(this.sampleCollectionInformation, entity)) {
			return;
		}

		if (this.sampleCollectionInformation != null) {
			this.sampleCollectionInformation.removeSampleCollectionItems(this, false);
		}
		this.sampleCollectionInformation = entity;
		if (reverseAdd) {
			this.sampleCollectionInformation.addSampleCollectionItems(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSampleCollectionInformation incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSampleCollectionInformation incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSampleCollectionInformation(boolean)} but default to true.
	 */
	public void unsetSampleCollectionInformation() {
		this.unsetSampleCollectionInformation(true);
	}

	/**
	 * Remove Sample Collection Information in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSampleCollectionInformation(boolean reverse) {
		if (reverse && this.sampleCollectionInformation != null) {
			this.sampleCollectionInformation.removeSampleCollectionItems(this, false);
		}
		this.sampleCollectionInformation = null;
	}
	/**
	 * Similar to {@link this#setSampleCollectionStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setSampleCollectionStaff(@NonNull StaffEntity entity) {
		setSampleCollectionStaff(entity, true);
	}

	/**
	 * Set or update the sampleCollectionStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to sampleCollectionStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSampleCollectionStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSampleCollectionStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSampleCollectionStaff here] end

		if (sameAsFormer(this.sampleCollectionStaff, entity)) {
			return;
		}

		if (this.sampleCollectionStaff != null) {
			this.sampleCollectionStaff.removeSampleCollectionStaffs(this, false);
		}
		this.sampleCollectionStaff = entity;
		if (reverseAdd) {
			this.sampleCollectionStaff.addSampleCollectionStaffs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSampleCollectionStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSampleCollectionStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSampleCollectionStaff(boolean)} but default to true.
	 */
	public void unsetSampleCollectionStaff() {
		this.unsetSampleCollectionStaff(true);
	}

	/**
	 * Remove Sample Collection Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSampleCollectionStaff(boolean reverse) {
		if (reverse && this.sampleCollectionStaff != null) {
			this.sampleCollectionStaff.removeSampleCollectionStaffs(this, false);
		}
		this.sampleCollectionStaff = null;
	}
	/**
	 * Similar to {@link this#setSampleDeliveryStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setSampleDeliveryStaff(@NonNull StaffEntity entity) {
		setSampleDeliveryStaff(entity, true);
	}

	/**
	 * Set or update the sampleDeliveryStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to sampleDeliveryStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSampleDeliveryStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSampleDeliveryStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSampleDeliveryStaff here] end

		if (sameAsFormer(this.sampleDeliveryStaff, entity)) {
			return;
		}

		if (this.sampleDeliveryStaff != null) {
			this.sampleDeliveryStaff.removeSampleDeliveryStaffs(this, false);
		}
		this.sampleDeliveryStaff = entity;
		if (reverseAdd) {
			this.sampleDeliveryStaff.addSampleDeliveryStaffs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSampleDeliveryStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSampleDeliveryStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSampleDeliveryStaff(boolean)} but default to true.
	 */
	public void unsetSampleDeliveryStaff() {
		this.unsetSampleDeliveryStaff(true);
	}

	/**
	 * Remove Sample Delivery Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSampleDeliveryStaff(boolean reverse) {
		if (reverse && this.sampleDeliveryStaff != null) {
			this.sampleDeliveryStaff.removeSampleDeliveryStaffs(this, false);
		}
		this.sampleDeliveryStaff = null;
	}
	/**
	 * Similar to {@link this#setSampleProcessingStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setSampleProcessingStaff(@NonNull StaffEntity entity) {
		setSampleProcessingStaff(entity, true);
	}

	/**
	 * Set or update the sampleProcessingStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to sampleProcessingStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSampleProcessingStaff(@NonNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSampleProcessingStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSampleProcessingStaff here] end

		if (sameAsFormer(this.sampleProcessingStaff, entity)) {
			return;
		}

		if (this.sampleProcessingStaff != null) {
			this.sampleProcessingStaff.removeSampleProcessingStaffs(this, false);
		}
		this.sampleProcessingStaff = entity;
		if (reverseAdd) {
			this.sampleProcessingStaff.addSampleProcessingStaffs(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSampleProcessingStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSampleProcessingStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSampleProcessingStaff(boolean)} but default to true.
	 */
	public void unsetSampleProcessingStaff() {
		this.unsetSampleProcessingStaff(true);
	}

	/**
	 * Remove Sample Processing Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSampleProcessingStaff(boolean reverse) {
		if (reverse && this.sampleProcessingStaff != null) {
			this.sampleProcessingStaff.removeSampleProcessingStaffs(this, false);
		}
		this.sampleProcessingStaff = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
