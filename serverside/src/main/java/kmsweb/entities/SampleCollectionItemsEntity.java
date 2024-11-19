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
import kmsweb.dtos.SampleCollectionItemsEntityDto;
import kmsweb.entities.listeners.SampleCollectionItemsEntityListener;
import kmsweb.serializers.SampleCollectionItemsSerializer;
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
@EntityListeners({SampleCollectionItemsEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = SampleCollectionItemsSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class SampleCollectionItemsEntity extends AbstractEntity {

	/**
	 * Takes a SampleCollectionItemsEntityDto and converts it into a SampleCollectionItemsEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param sampleCollectionItemsEntityDto
	 */
	public SampleCollectionItemsEntity(SampleCollectionItemsEntityDto sampleCollectionItemsEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (sampleCollectionItemsEntityDto.getId() != null) {
			this.setId(sampleCollectionItemsEntityDto.getId());
		}

		if (sampleCollectionItemsEntityDto.getSampleType() != null) {
			this.setSampleType(sampleCollectionItemsEntityDto.getSampleType());
		}

		if (sampleCollectionItemsEntityDto.getSampleNumber() != null) {
			this.setSampleNumber(sampleCollectionItemsEntityDto.getSampleNumber());
		}

		if (sampleCollectionItemsEntityDto.getSampleTakingLocation() != null) {
			this.setSampleTakingLocation(sampleCollectionItemsEntityDto.getSampleTakingLocation());
		}

		if (sampleCollectionItemsEntityDto.getVolume() != null) {
			this.setVolume(sampleCollectionItemsEntityDto.getVolume());
		}

		if (sampleCollectionItemsEntityDto.getContainer() != null) {
			this.setContainer(sampleCollectionItemsEntityDto.getContainer());
		}

		if (sampleCollectionItemsEntityDto.getTransport() != null) {
			this.setTransport(sampleCollectionItemsEntityDto.getTransport());
		}

		if (sampleCollectionItemsEntityDto.getSampleCollectionDateTime() != null) {
			this.setSampleCollectionDateTime(sampleCollectionItemsEntityDto.getSampleCollectionDateTime());
		}

		if (sampleCollectionItemsEntityDto.getSampleProcessingDateTime() != null) {
			this.setSampleProcessingDateTime(sampleCollectionItemsEntityDto.getSampleProcessingDateTime());
		}

		if (sampleCollectionItemsEntityDto.getSampleDeliveryDateTime() != null) {
			this.setSampleDeliveryDateTime(sampleCollectionItemsEntityDto.getSampleDeliveryDateTime());
		}

		if (sampleCollectionItemsEntityDto.getNotes() != null) {
			this.setNotes(sampleCollectionItemsEntityDto.getNotes());
		}

		if (sampleCollectionItemsEntityDto.getSampleCollectionInformation() != null) {
			this.setSampleCollectionInformation(sampleCollectionItemsEntityDto.getSampleCollectionInformation());
		}

		if (sampleCollectionItemsEntityDto.getSampleCollectionStaff() != null) {
			this.setSampleCollectionStaff(sampleCollectionItemsEntityDto.getSampleCollectionStaff());
		}

		if (sampleCollectionItemsEntityDto.getSampleDeliveryStaff() != null) {
			this.setSampleDeliveryStaff(sampleCollectionItemsEntityDto.getSampleDeliveryStaff());
		}

		if (sampleCollectionItemsEntityDto.getSampleProcessingStaff() != null) {
			this.setSampleProcessingStaff(sampleCollectionItemsEntityDto.getSampleProcessingStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Sample Type here] off begin
	@CsvBindByName(column = "SAMPLE_TYPE", required = false)
	@Nullable
	@Column(name = "sample_type")
	@Schema(description = "The Sample Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sample Type here] end
	private String sampleType;

	// % protected region % [Modify attribute annotation for Sample Number here] off begin
	@CsvBindByName(column = "SAMPLE_NUMBER", required = false)
	@Nullable
	@Column(name = "sample_number")
	@Schema(description = "The Sample Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sample Number here] end
	private String sampleNumber;

	// % protected region % [Modify attribute annotation for Sample Taking Location here] off begin
	@CsvBindByName(column = "SAMPLE_TAKING_LOCATION", required = false)
	@Nullable
	@Column(name = "sample_taking_location")
	@Schema(description = "The Sample Taking Location of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sample Taking Location here] end
	private String sampleTakingLocation;

	// % protected region % [Modify attribute annotation for Volume here] off begin
	@CsvBindByName(column = "VOLUME", required = false)
	@Nullable
	@Column(name = "volume")
	@Schema(description = "The Volume of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Volume here] end
	private String volume;

	// % protected region % [Modify attribute annotation for Container here] off begin
	@CsvBindByName(column = "CONTAINER", required = false)
	@Nullable
	@Column(name = "container")
	@Schema(description = "The Container of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Container here] end
	private String container;

	// % protected region % [Modify attribute annotation for Transport here] off begin
	@CsvBindByName(column = "TRANSPORT", required = false)
	@Nullable
	@Column(name = "transport")
	@Schema(description = "The Transport of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Transport here] end
	private String transport;

	// % protected region % [Modify attribute annotation for Sample Collection Date Time here] off begin

	@CsvCustomBindByName(column = "SAMPLE_COLLECTION_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "sample_collection_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Sample Collection Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sample Collection Date Time here] end
	private OffsetDateTime sampleCollectionDateTime;

	// % protected region % [Modify attribute annotation for Sample Processing Date Time here] off begin

	@CsvCustomBindByName(column = "SAMPLE_PROCESSING_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "sample_processing_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Sample Processing Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sample Processing Date Time here] end
	private OffsetDateTime sampleProcessingDateTime;

	// % protected region % [Modify attribute annotation for Sample Delivery Date Time here] off begin

	@CsvCustomBindByName(column = "SAMPLE_DELIVERY_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "sample_delivery_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Sample Delivery Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Sample Delivery Date Time here] end
	private OffsetDateTime sampleDeliveryDateTime;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@CsvBindByName(column = "NOTES", required = false)
	@Nullable
	@Column(name = "notes")
	@Schema(description = "The Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

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

	// % protected region % [Update the annotation for Sample Collection Information here] off begin
	@Schema(description = "The Sample Collection Information entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Sample Collection Information here] end
	private SampleCollectionInformationEntity sampleCollectionInformation;

	// % protected region % [Update the annotation for sampleCollectionInformationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SAMPLE_COLLECTION_INFORMATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for sampleCollectionInformationId here] end
	private UUID sampleCollectionInformationId;

	// % protected region % [Update the annotation for Sample Collection Staff here] off begin
	@Schema(description = "The Sample Collection Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Sample Collection Staff here] end
	private StaffEntity sampleCollectionStaff;

	// % protected region % [Update the annotation for sampleCollectionStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SAMPLE_COLLECTION_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for sampleCollectionStaffId here] end
	private UUID sampleCollectionStaffId;

	// % protected region % [Update the annotation for Sample Delivery Staff here] off begin
	@Schema(description = "The Sample Delivery Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Sample Delivery Staff here] end
	private StaffEntity sampleDeliveryStaff;

	// % protected region % [Update the annotation for sampleDeliveryStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SAMPLE_DELIVERY_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for sampleDeliveryStaffId here] end
	private UUID sampleDeliveryStaffId;

	// % protected region % [Update the annotation for Sample Processing Staff here] off begin
	@Schema(description = "The Sample Processing Staff entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Sample Processing Staff here] end
	private StaffEntity sampleProcessingStaff;

	// % protected region % [Update the annotation for sampleProcessingStaffId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SAMPLE_PROCESSING_STAFF_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for sampleProcessingStaffId here] end
	private UUID sampleProcessingStaffId;

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
	public void setSampleCollectionInformation(@NotNull SampleCollectionInformationEntity entity) {
		setSampleCollectionInformation(entity, true);
	}

	/**
	 * Set or update the sampleCollectionInformation in this entity with single SampleCollectionInformationEntity.
	 *
	 * @param entity the given SampleCollectionInformationEntity to be set or updated to sampleCollectionInformation
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSampleCollectionInformation(@NotNull SampleCollectionInformationEntity entity, boolean reverseAdd) {
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
	public void setSampleCollectionStaff(@NotNull StaffEntity entity) {
		setSampleCollectionStaff(entity, true);
	}

	/**
	 * Set or update the sampleCollectionStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to sampleCollectionStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSampleCollectionStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
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
	public void setSampleDeliveryStaff(@NotNull StaffEntity entity) {
		setSampleDeliveryStaff(entity, true);
	}

	/**
	 * Set or update the sampleDeliveryStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to sampleDeliveryStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSampleDeliveryStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
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
	public void setSampleProcessingStaff(@NotNull StaffEntity entity) {
		setSampleProcessingStaff(entity, true);
	}

	/**
	 * Set or update the sampleProcessingStaff in this entity with single StaffEntity.
	 *
	 * @param entity the given StaffEntity to be set or updated to sampleProcessingStaff
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSampleProcessingStaff(@NotNull StaffEntity entity, boolean reverseAdd) {
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

	/**
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "SAMPLE_TYPE,SAMPLE_NUMBER,SAMPLE_TAKING_LOCATION,VOLUME,CONTAINER,TRANSPORT,SAMPLE_COLLECTION_DATE_TIME,SAMPLE_PROCESSING_DATE_TIME,SAMPLE_DELIVERY_DATE_TIME,NOTES,SAMPLE_COLLECTION_INFORMATION_ID,SAMPLE_COLLECTION_STAFF_ID,SAMPLE_DELIVERY_STAFF_ID,SAMPLE_PROCESSING_STAFF_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<SampleCollectionInformationEntity> sampleCollectionInformationRelation = Optional.ofNullable(this.sampleCollectionInformation);
		sampleCollectionInformationRelation.ifPresent(entity -> this.sampleCollectionInformationId = entity.getId());

		Optional<StaffEntity> sampleCollectionStaffRelation = Optional.ofNullable(this.sampleCollectionStaff);
		sampleCollectionStaffRelation.ifPresent(entity -> this.sampleCollectionStaffId = entity.getId());

		Optional<StaffEntity> sampleDeliveryStaffRelation = Optional.ofNullable(this.sampleDeliveryStaff);
		sampleDeliveryStaffRelation.ifPresent(entity -> this.sampleDeliveryStaffId = entity.getId());

		Optional<StaffEntity> sampleProcessingStaffRelation = Optional.ofNullable(this.sampleProcessingStaff);
		sampleProcessingStaffRelation.ifPresent(entity -> this.sampleProcessingStaffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object sampleCollectionItems) {
		if (this == sampleCollectionItems) {
			return true;
		}
		if (sampleCollectionItems == null || this.getClass() != sampleCollectionItems.getClass()) {
			return false;
		}
		if (!super.equals(sampleCollectionItems)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		SampleCollectionItemsEntity that = (SampleCollectionItemsEntity) sampleCollectionItems;
		return
			Objects.equals(this.sampleType, that.sampleType) &&
			Objects.equals(this.sampleNumber, that.sampleNumber) &&
			Objects.equals(this.sampleTakingLocation, that.sampleTakingLocation) &&
			Objects.equals(this.volume, that.volume) &&
			Objects.equals(this.container, that.container) &&
			Objects.equals(this.transport, that.transport) &&
			Objects.equals(
			     this.sampleCollectionDateTime != null ? this.sampleCollectionDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.sampleCollectionDateTime != null ? that.sampleCollectionDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.sampleProcessingDateTime != null ? this.sampleProcessingDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.sampleProcessingDateTime != null ? that.sampleProcessingDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(
			     this.sampleDeliveryDateTime != null ? this.sampleDeliveryDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.sampleDeliveryDateTime != null ? that.sampleDeliveryDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.notes, that.notes) &&
			Objects.equals(this.sampleCollectionInformationId, that.sampleCollectionInformationId) &&
			Objects.equals(this.sampleCollectionStaffId, that.sampleCollectionStaffId) &&
			Objects.equals(this.sampleDeliveryStaffId, that.sampleDeliveryStaffId) &&
			Objects.equals(this.sampleProcessingStaffId, that.sampleProcessingStaffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
