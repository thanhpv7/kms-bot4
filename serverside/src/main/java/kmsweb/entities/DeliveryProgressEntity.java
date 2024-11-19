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
import kmsweb.dtos.DeliveryProgressEntityDto;
import kmsweb.entities.listeners.DeliveryProgressEntityListener;
import kmsweb.serializers.DeliveryProgressSerializer;
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
@EntityListeners({DeliveryProgressEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = DeliveryProgressSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class DeliveryProgressEntity extends AbstractEntity {

	/**
	 * Takes a DeliveryProgressEntityDto and converts it into a DeliveryProgressEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param deliveryProgressEntityDto
	 */
	public DeliveryProgressEntity(DeliveryProgressEntityDto deliveryProgressEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (deliveryProgressEntityDto.getId() != null) {
			this.setId(deliveryProgressEntityDto.getId());
		}

		if (deliveryProgressEntityDto.getProgressDateTime() != null) {
			this.setProgressDateTime(deliveryProgressEntityDto.getProgressDateTime());
		}

		if (deliveryProgressEntityDto.getFhrPerMinute() != null) {
			this.setFhrPerMinute(deliveryProgressEntityDto.getFhrPerMinute());
		}

		if (deliveryProgressEntityDto.getAmnioticFluid() != null) {
			this.setAmnioticFluid(deliveryProgressEntityDto.getAmnioticFluid());
		}

		if (deliveryProgressEntityDto.getMoulding() != null) {
			this.setMoulding(deliveryProgressEntityDto.getMoulding());
		}

		if (deliveryProgressEntityDto.getCervicalDilatation() != null) {
			this.setCervicalDilatation(deliveryProgressEntityDto.getCervicalDilatation());
		}

		if (deliveryProgressEntityDto.getFetalHeadDescent() != null) {
			this.setFetalHeadDescent(deliveryProgressEntityDto.getFetalHeadDescent());
		}

		if (deliveryProgressEntityDto.getContractionQty() != null) {
			this.setContractionQty(deliveryProgressEntityDto.getContractionQty());
		}

		if (deliveryProgressEntityDto.getContractionMins() != null) {
			this.setContractionMins(deliveryProgressEntityDto.getContractionMins());
		}

		if (deliveryProgressEntityDto.getDripStrength() != null) {
			this.setDripStrength(deliveryProgressEntityDto.getDripStrength());
		}

		if (deliveryProgressEntityDto.getDripNumber() != null) {
			this.setDripNumber(deliveryProgressEntityDto.getDripNumber());
		}

		if (deliveryProgressEntityDto.getDrugIV() != null) {
			this.setDrugIV(deliveryProgressEntityDto.getDrugIV());
		}

		if (deliveryProgressEntityDto.getSystole() != null) {
			this.setSystole(deliveryProgressEntityDto.getSystole());
		}

		if (deliveryProgressEntityDto.getDiastole() != null) {
			this.setDiastole(deliveryProgressEntityDto.getDiastole());
		}

		if (deliveryProgressEntityDto.getPulse() != null) {
			this.setPulse(deliveryProgressEntityDto.getPulse());
		}

		if (deliveryProgressEntityDto.getTemperature() != null) {
			this.setTemperature(deliveryProgressEntityDto.getTemperature());
		}

		if (deliveryProgressEntityDto.getTemperatureUnit() != null) {
			this.setTemperatureUnit(deliveryProgressEntityDto.getTemperatureUnit());
		}

		if (deliveryProgressEntityDto.getUrineProtein() != null) {
			this.setUrineProtein(deliveryProgressEntityDto.getUrineProtein());
		}

		if (deliveryProgressEntityDto.getUrineAcetone() != null) {
			this.setUrineAcetone(deliveryProgressEntityDto.getUrineAcetone());
		}

		if (deliveryProgressEntityDto.getUrineVolume() != null) {
			this.setUrineVolume(deliveryProgressEntityDto.getUrineVolume());
		}

		if (deliveryProgressEntityDto.getProgressNotes() != null) {
			this.setProgressNotes(deliveryProgressEntityDto.getProgressNotes());
		}

		if (deliveryProgressEntityDto.getDeliveryMedicalExaminationRecord() != null) {
			this.setDeliveryMedicalExaminationRecord(deliveryProgressEntityDto.getDeliveryMedicalExaminationRecord());
		}

		if (deliveryProgressEntityDto.getStaff() != null) {
			this.setStaff(deliveryProgressEntityDto.getStaff());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Progress Date Time here] off begin
	@CsvCustomBindByName(column = "PROGRESS_DATE_TIME", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "progress_date_time")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Progress Date Time of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Progress Date Time here] end
	private OffsetDateTime progressDateTime;

	// % protected region % [Modify attribute annotation for FHR Per Minute here] off begin
	@CsvBindByName(column = "FHR_PER_MINUTE", required = false)
	@Nullable
	@Column(name = "fhr_per_minute")
	@Schema(description = "The FHR Per Minute of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for FHR Per Minute here] end
	private Integer fhrPerMinute;

	// % protected region % [Modify attribute annotation for Amniotic Fluid here] off begin
	@CsvBindByName(column = "AMNIOTIC_FLUID", required = false)
	@Nullable
	@Column(name = "amniotic_fluid")
	@Schema(description = "The Amniotic Fluid of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Amniotic Fluid here] end
	private String amnioticFluid;

	// % protected region % [Modify attribute annotation for Moulding here] off begin
	@CsvBindByName(column = "MOULDING", required = false)
	@Nullable
	@Column(name = "moulding")
	@Schema(description = "The Moulding of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Moulding here] end
	private String moulding;

	// % protected region % [Modify attribute annotation for Cervical Dilatation here] off begin
	@CsvBindByName(column = "CERVICAL_DILATATION", required = false)
	@Nullable
	@Column(name = "cervical_dilatation")
	@Schema(description = "The Cervical Dilatation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Cervical Dilatation here] end
	private Integer cervicalDilatation;

	// % protected region % [Modify attribute annotation for Fetal Head Descent here] off begin
	@CsvBindByName(column = "FETAL_HEAD_DESCENT", required = false)
	@Nullable
	@Column(name = "fetal_head_descent")
	@Schema(description = "The Fetal Head Descent of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Fetal Head Descent here] end
	private String fetalHeadDescent;

	// % protected region % [Modify attribute annotation for Contraction Qty here] off begin
	@CsvBindByName(column = "CONTRACTION_QTY", required = false)
	@Nullable
	@Column(name = "contraction_qty")
	@Schema(description = "The Contraction Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Contraction Qty here] end
	private Integer contractionQty;

	// % protected region % [Modify attribute annotation for Contraction Mins here] off begin
	@CsvBindByName(column = "CONTRACTION_MINS", required = false)
	@Nullable
	@Column(name = "contraction_mins")
	@Schema(description = "The Contraction Mins of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Contraction Mins here] end
	private String contractionMins;

	// % protected region % [Modify attribute annotation for Drip Strength here] off begin
	@CsvBindByName(column = "DRIP_STRENGTH", required = false)
	@Nullable
	@Column(name = "drip_strength")
	@Schema(description = "The Drip Strength of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Drip Strength here] end
	private Integer dripStrength;

	// % protected region % [Modify attribute annotation for Drip Number here] off begin
	@CsvBindByName(column = "DRIP_NUMBER", required = false)
	@Nullable
	@Column(name = "drip_number")
	@Schema(description = "The Drip Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Drip Number here] end
	private Integer dripNumber;

	// % protected region % [Modify attribute annotation for Drug IV here] off begin
	@CsvBindByName(column = "DRUG_IV", required = false)
	@Nullable
	@Lob
	@Column(name = "drug_iv")
	@Schema(description = "The Drug IV of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Drug IV here] end
	private String drugIV;

	// % protected region % [Modify attribute annotation for Systole here] off begin
	@CsvBindByName(column = "SYSTOLE", required = false)
	@Nullable
	@Column(name = "systole")
	@Schema(description = "The Systole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Systole here] end
	private Integer systole;

	// % protected region % [Modify attribute annotation for Diastole here] off begin
	@CsvBindByName(column = "DIASTOLE", required = false)
	@Nullable
	@Column(name = "diastole")
	@Schema(description = "The Diastole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Diastole here] end
	private Integer diastole;

	// % protected region % [Modify attribute annotation for Pulse here] off begin
	@CsvBindByName(column = "PULSE", required = false)
	@Nullable
	@Column(name = "pulse")
	@Schema(description = "The Pulse of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pulse here] end
	private Integer pulse;

	// % protected region % [Modify attribute annotation for Temperature here] off begin
	@CsvBindByName(column = "TEMPERATURE", required = false)
	@Nullable
	@Column(name = "temperature")
	@Schema(description = "The Temperature of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Temperature here] end
	private Double temperature;

	// % protected region % [Modify attribute annotation for Temperature Unit here] off begin
	@CsvBindByName(column = "TEMPERATURE_UNIT", required = false)
	@Nullable
	@Column(name = "temperature_unit")
	@Schema(description = "The Temperature Unit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Temperature Unit here] end
	private String temperatureUnit;

	// % protected region % [Modify attribute annotation for Urine Protein here] off begin
	@CsvBindByName(column = "URINE_PROTEIN", required = false)
	@Nullable
	@Column(name = "urine_protein")
	@Schema(description = "The Urine Protein of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Urine Protein here] end
	private String urineProtein;

	// % protected region % [Modify attribute annotation for Urine Acetone here] off begin
	@CsvBindByName(column = "URINE_ACETONE", required = false)
	@Nullable
	@Column(name = "urine_acetone")
	@Schema(description = "The Urine Acetone of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Urine Acetone here] end
	private String urineAcetone;

	// % protected region % [Modify attribute annotation for Urine Volume here] off begin
	@CsvBindByName(column = "URINE_VOLUME", required = false)
	@Nullable
	@Column(name = "urine_volume")
	@Schema(description = "The Urine Volume of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Urine Volume here] end
	private Double urineVolume;

	// % protected region % [Modify attribute annotation for Progress Notes here] off begin
	@CsvBindByName(column = "PROGRESS_NOTES", required = false)
	@Nullable
	@Lob
	@Column(name = "progress_notes")
	@Schema(description = "The Progress Notes of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Progress Notes here] end
	private String progressNotes;

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

	// % protected region % [Update the annotation for Delivery Medical Examination Record here] off begin
	@Schema(description = "The Delivery Medical Examination Record entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Delivery Medical Examination Record here] end
	private DeliveryMedicalExaminationRecordEntity deliveryMedicalExaminationRecord;

	// % protected region % [Update the annotation for deliveryMedicalExaminationRecordId here] off begin
	@Transient
	@CsvCustomBindByName(column = "DELIVERY_MEDICAL_EXAMINATION_RECORD_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for deliveryMedicalExaminationRecordId here] end
	private UUID deliveryMedicalExaminationRecordId;

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
	 * Similar to {@link this#setDeliveryMedicalExaminationRecord(DeliveryMedicalExaminationRecordEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set to this entity
	 */
	public void setDeliveryMedicalExaminationRecord(@NotNull DeliveryMedicalExaminationRecordEntity entity) {
		setDeliveryMedicalExaminationRecord(entity, true);
	}

	/**
	 * Set or update the deliveryMedicalExaminationRecord in this entity with single DeliveryMedicalExaminationRecordEntity.
	 *
	 * @param entity the given DeliveryMedicalExaminationRecordEntity to be set or updated to deliveryMedicalExaminationRecord
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setDeliveryMedicalExaminationRecord(@NotNull DeliveryMedicalExaminationRecordEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setDeliveryMedicalExaminationRecord here] off begin
		// % protected region % [Add any additional logic here before the main logic for setDeliveryMedicalExaminationRecord here] end

		if (sameAsFormer(this.deliveryMedicalExaminationRecord, entity)) {
			return;
		}

		if (this.deliveryMedicalExaminationRecord != null) {
			this.deliveryMedicalExaminationRecord.removeDeliveryProgresses(this, false);
		}
		this.deliveryMedicalExaminationRecord = entity;
		if (reverseAdd) {
			this.deliveryMedicalExaminationRecord.addDeliveryProgresses(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setDeliveryMedicalExaminationRecord incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setDeliveryMedicalExaminationRecord incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetDeliveryMedicalExaminationRecord(boolean)} but default to true.
	 */
	public void unsetDeliveryMedicalExaminationRecord() {
		this.unsetDeliveryMedicalExaminationRecord(true);
	}

	/**
	 * Remove Delivery Medical Examination Record in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetDeliveryMedicalExaminationRecord(boolean reverse) {
		if (reverse && this.deliveryMedicalExaminationRecord != null) {
			this.deliveryMedicalExaminationRecord.removeDeliveryProgresses(this, false);
		}
		this.deliveryMedicalExaminationRecord = null;
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
			this.staff.removeDeliveryProgresses(this, false);
		}
		this.staff = entity;
		if (reverseAdd) {
			this.staff.addDeliveryProgresses(this, false);
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
			this.staff.removeDeliveryProgresses(this, false);
		}
		this.staff = null;
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
		return "PROGRESS_DATE_TIME,FHR_PER_MINUTE,AMNIOTIC_FLUID,MOULDING,CERVICAL_DILATATION,FETAL_HEAD_DESCENT,CONTRACTION_QTY,CONTRACTION_MINS,DRIP_STRENGTH,DRIP_NUMBER,DRUG_IV,SYSTOLE,DIASTOLE,PULSE,TEMPERATURE,TEMPERATURE_UNIT,URINE_PROTEIN,URINE_ACETONE,URINE_VOLUME,PROGRESS_NOTES,DELIVERY_MEDICAL_EXAMINATION_RECORD_ID,STAFF_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<DeliveryMedicalExaminationRecordEntity> deliveryMedicalExaminationRecordRelation = Optional.ofNullable(this.deliveryMedicalExaminationRecord);
		deliveryMedicalExaminationRecordRelation.ifPresent(entity -> this.deliveryMedicalExaminationRecordId = entity.getId());

		Optional<StaffEntity> staffRelation = Optional.ofNullable(this.staff);
		staffRelation.ifPresent(entity -> this.staffId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object deliveryProgress) {
		if (this == deliveryProgress) {
			return true;
		}
		if (deliveryProgress == null || this.getClass() != deliveryProgress.getClass()) {
			return false;
		}
		if (!super.equals(deliveryProgress)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		DeliveryProgressEntity that = (DeliveryProgressEntity) deliveryProgress;
		return
			Objects.equals(
			     this.progressDateTime != null ? this.progressDateTime.truncatedTo(ChronoUnit.MILLIS) : null,
			     that.progressDateTime != null ? that.progressDateTime.truncatedTo(ChronoUnit.MILLIS) : null
			     ) &&
			Objects.equals(this.fhrPerMinute, that.fhrPerMinute) &&
			Objects.equals(this.amnioticFluid, that.amnioticFluid) &&
			Objects.equals(this.moulding, that.moulding) &&
			Objects.equals(this.cervicalDilatation, that.cervicalDilatation) &&
			Objects.equals(this.fetalHeadDescent, that.fetalHeadDescent) &&
			Objects.equals(this.contractionQty, that.contractionQty) &&
			Objects.equals(this.contractionMins, that.contractionMins) &&
			Objects.equals(this.dripStrength, that.dripStrength) &&
			Objects.equals(this.dripNumber, that.dripNumber) &&
			Objects.equals(this.drugIV, that.drugIV) &&
			Objects.equals(this.systole, that.systole) &&
			Objects.equals(this.diastole, that.diastole) &&
			Objects.equals(this.pulse, that.pulse) &&
			Objects.equals(this.temperature, that.temperature) &&
			Objects.equals(this.temperatureUnit, that.temperatureUnit) &&
			Objects.equals(this.urineProtein, that.urineProtein) &&
			Objects.equals(this.urineAcetone, that.urineAcetone) &&
			Objects.equals(this.urineVolume, that.urineVolume) &&
			Objects.equals(this.progressNotes, that.progressNotes) &&
			Objects.equals(this.deliveryMedicalExaminationRecordId, that.deliveryMedicalExaminationRecordId) &&
			Objects.equals(this.staffId, that.staffId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
