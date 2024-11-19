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

import io.swagger.v3.oas.annotations.media.Schema;
import kmsweb.dtos.MedicationAdministeredHistoryEntityDto;
import kmsweb.entities.listeners.MedicationAdministeredHistoryEntityListener;
import kmsweb.serializers.MedicationAdministeredHistorySerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import kmsweb.deserializers.DateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

import java.time.*;
import java.time.temporal.ChronoUnit;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Optional;
import java.util.UUID;
import java.util.Objects;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Getter
@Setter
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
@NoArgsConstructor
@Entity
// % protected region % [Override the auditing annotation or add additional annotations here] off begin
@Audited
// % protected region % [Override the auditing annotation or add additional annotations here] end
@ExcludeSuperclassListeners
@EntityListeners({MedicationAdministeredHistoryEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = MedicationAdministeredHistorySerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class MedicationAdministeredHistoryEntity extends AbstractEntity {

	/**
	 * Takes a MedicationAdministeredHistoryEntityDto and converts it into a MedicationAdministeredHistoryEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param medicationAdministeredHistoryEntityDto
	 */
	public MedicationAdministeredHistoryEntity(MedicationAdministeredHistoryEntityDto medicationAdministeredHistoryEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (medicationAdministeredHistoryEntityDto.getId() != null) {
			this.setId(medicationAdministeredHistoryEntityDto.getId());
		}

		if (medicationAdministeredHistoryEntityDto.getDatetime() != null) {
			this.setDatetime(medicationAdministeredHistoryEntityDto.getDatetime());
		}

		if (medicationAdministeredHistoryEntityDto.getAdministrationNotes() != null) {
			this.setAdministrationNotes(medicationAdministeredHistoryEntityDto.getAdministrationNotes());
		}

		if (medicationAdministeredHistoryEntityDto.getAdministeredQuantity() != null) {
			this.setAdministeredQuantity(medicationAdministeredHistoryEntityDto.getAdministeredQuantity());
		}

		if (medicationAdministeredHistoryEntityDto.getTakenHomeQuantity() != null) {
			this.setTakenHomeQuantity(medicationAdministeredHistoryEntityDto.getTakenHomeQuantity());
		}

		if (medicationAdministeredHistoryEntityDto.getReturnedQuantity() != null) {
			this.setReturnedQuantity(medicationAdministeredHistoryEntityDto.getReturnedQuantity());
		}

		if (medicationAdministeredHistoryEntityDto.getTotalAdministeredQuantity() != null) {
			this.setTotalAdministeredQuantity(medicationAdministeredHistoryEntityDto.getTotalAdministeredQuantity());
		}

		if (medicationAdministeredHistoryEntityDto.getMedicationItem() != null) {
			this.setMedicationItem(medicationAdministeredHistoryEntityDto.getMedicationItem());
		}

		if (medicationAdministeredHistoryEntityDto.getStaff() != null) {
			this.setStaff(medicationAdministeredHistoryEntityDto.getStaff());
		}

		if (medicationAdministeredHistoryEntityDto.getMedicationCompound() != null) {
			this.setMedicationCompound(medicationAdministeredHistoryEntityDto.getMedicationCompound());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for DateTime here] off begin
	@CsvCustomBindByName(column = "DATETIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "datetime")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The DateTime of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for DateTime here] end
	private OffsetDateTime datetime;

	// % protected region % [Modify attribute annotation for Administration Notes here] off begin
	@CsvBindByName(column = "ADMINISTRATION_NOTES", required = false)
	@Nullable
	@Column(name = "administration_notes")
	@Schema(description = "The Administration Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Administration Notes here] end
	private String administrationNotes;

	// % protected region % [Modify attribute annotation for Administered Quantity here] off begin
	@CsvBindByName(column = "ADMINISTERED_QUANTITY", required = false)
	@Nullable
	@Column(name = "administered_quantity")
	@Schema(description = "The Administered Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Administered Quantity here] end
	private Integer administeredQuantity;

	// % protected region % [Modify attribute annotation for Taken Home Quantity here] off begin
	@CsvBindByName(column = "TAKEN_HOME_QUANTITY", required = false)
	@Nullable
	@Column(name = "taken_home_quantity")
	@Schema(description = "The Taken Home Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Taken Home Quantity here] end
	private Integer takenHomeQuantity;

	// % protected region % [Modify attribute annotation for Returned Quantity here] off begin
	@CsvBindByName(column = "RETURNED_QUANTITY", required = false)
	@Nullable
	@Column(name = "returned_quantity")
	@Schema(description = "The Returned Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Returned Quantity here] end
	private Integer returnedQuantity;

	// % protected region % [Modify attribute annotation for Total Administered Quantity here] off begin
	@CsvBindByName(column = "TOTAL_ADMINISTERED_QUANTITY", required = false)
	@Nullable
	@Column(name = "total_administered_quantity")
	@Schema(description = "The Total Administered Quantity of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total Administered Quantity here] end
	private Integer totalAdministeredQuantity;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Medication Item here] off begin
	@Schema(description = "The Medication Item entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Item here] end
	private MedicationItemEntity medicationItem;

	// % protected region % [Update the annotation for medicationItemId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_ITEM_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicationItemId here] end
	private UUID medicationItemId;

	// % protected region % [Update the annotation for Staff here] off begin
	@Schema(description = "The Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Staff here] end
	private StaffEntity staff;

	// % protected region % [Update the annotation for staffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for staffId here] end
	private UUID staffId;

	// % protected region % [Update the annotation for Medication Compound here] off begin
	@Schema(description = "The Medication Compound entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Medication Compound here] end
	private MedicationCompoundEntity medicationCompound;

	// % protected region % [Update the annotation for medicationCompoundId here] off begin
	@Transient
	@CsvCustomBindByName(column = "MEDICATION_COMPOUND_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for medicationCompoundId here] end
	private UUID medicationCompoundId;

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
	 * Similar to {@link this#setMedicationItem(MedicationItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationItemEntity to be set to this entity
	 */
	public void setMedicationItem(@NotNull MedicationItemEntity entity) {
		setMedicationItem(entity, true);
	}

	/**
	 * Set or update the medicationItem in this entity with single MedicationItemEntity.
	 *
	 * @param entity the given MedicationItemEntity to be set or updated to medicationItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationItem(@NotNull MedicationItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicationItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicationItem here] end

		if (sameAsFormer(this.medicationItem, entity)) {
			return;
		}

		if (this.medicationItem != null) {
			this.medicationItem.removeMedicationAdministeredHisotries(this, false);
		}
		this.medicationItem = entity;
		if (reverseAdd) {
			this.medicationItem.addMedicationAdministeredHisotries(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicationItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicationItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicationItem(boolean)} but default to true.
	 */
	public void unsetMedicationItem() {
		this.unsetMedicationItem(true);
	}

	/**
	 * Remove Medication Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicationItem(boolean reverse) {
		if (reverse && this.medicationItem != null) {
			this.medicationItem.removeMedicationAdministeredHisotries(this, false);
		}
		this.medicationItem = null;
	}
	/**
	 * Similar to {@link this#setStaff(StaffEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given StaffEntity to be set to this entity
	 */
	public void setStaff(@NotNull StaffEntity entity) {
		setStaff(entity, true);
	}

	/**
	 * Set or update the staff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to staff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setStaff here] off begin
		// % protected region % [Add any additional logic here before the main logic for setStaff here] end

		if (sameAsFormer(this.staff, entity)) {
			return;
		}

		if (this.staff != null) {
			this.staff.removeMedicationAdministeredHisotries(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addMedicationAdministeredHisotries(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setStaff incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetStaff(boolean)} but default to true.
	 */
	public void unsetStaff() {
		this.unsetStaff(true);
	}

	/**
	 * Remove Staff in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetStaff(boolean reverse) {
		if (reverse && this.staff != null) {
			this.staff.removeMedicationAdministeredHisotries(this, false);
		}
		this.staff = null;
	}
	/**
	 * Similar to {@link this#setMedicationCompound(MedicationCompoundEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given MedicationCompoundEntity to be set to this entity
	 */
	public void setMedicationCompound(@NotNull MedicationCompoundEntity entity) {
		setMedicationCompound(entity, true);
	}

	/**
	 * Set or update the medicationCompound in this entity with single MedicationCompoundEntity.
	 *
	 * @param entity the given MedicationCompoundEntity to be set or updated to medicationCompound
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setMedicationCompound(@NotNull MedicationCompoundEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setMedicationCompound here] off begin
		// % protected region % [Add any additional logic here before the main logic for setMedicationCompound here] end

		if (sameAsFormer(this.medicationCompound, entity)) {
			return;
		}

		if (this.medicationCompound != null) {
			this.medicationCompound.removeMedicationAdministeredHistories(this, false);
		}
		this.medicationCompound = entity;
		if (reverseAdd) {
			this.medicationCompound.addMedicationAdministeredHistories(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setMedicationCompound incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setMedicationCompound incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetMedicationCompound(boolean)} but default to true.
	 */
	public void unsetMedicationCompound() {
		this.unsetMedicationCompound(true);
	}

	/**
	 * Remove Medication Compound in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetMedicationCompound(boolean reverse) {
		if (reverse && this.medicationCompound != null) {
			this.medicationCompound.removeMedicationAdministeredHistories(this, false);
		}
		this.medicationCompound = null;
	}

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "DATETIME,ADMINISTRATION_NOTES,ADMINISTERED_QUANTITY,TAKEN_HOME_QUANTITY,RETURNED_QUANTITY,TOTAL_ADMINISTERED_QUANTITY,MEDICATION_ITEM_ID,STAFF_ID,MEDICATION_COMPOUND_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<MedicationItemEntity> medicationItemRelation = Optional.ofNullable(this.medicationItem);
		medicationItemRelation.ifPresent(entity -> this.medicationItemId = entity.getId());

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		Optional<MedicationCompoundEntity> medicationCompoundRelation = Optional.ofNullable(this.medicationCompound);
		medicationCompoundRelation.ifPresent(entity -> this.medicationCompoundId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object medicationAdministeredHistory) {
		if (this == medicationAdministeredHistory) {
			return true;
		}
		if (medicationAdministeredHistory == null || this.getClass() != medicationAdministeredHistory.getClass()) {
			return false;
		}
		if (!super.equals(medicationAdministeredHistory)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		MedicationAdministeredHistoryEntity that = (MedicationAdministeredHistoryEntity) medicationAdministeredHistory;
		return
			Objects.equals(
			     this.datetime != null ? this.datetime.truncatedTo(ChronoUnit.DAYS) : null,
			     that.datetime != null ? that.datetime.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.administrationNotes, that.administrationNotes) &&
			Objects.equals(this.administeredQuantity, that.administeredQuantity) &&
			Objects.equals(this.takenHomeQuantity, that.takenHomeQuantity) &&
			Objects.equals(this.returnedQuantity, that.returnedQuantity) &&
			Objects.equals(this.totalAdministeredQuantity, that.totalAdministeredQuantity) &&
			Objects.equals(this.medicationItemId, that.medicationItemId) &&
			Objects.equals(this.staffId, that.staffId) &&
			Objects.equals(this.medicationCompoundId, that.medicationCompoundId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
