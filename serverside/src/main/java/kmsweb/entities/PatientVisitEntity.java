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
import kmsweb.dtos.PatientVisitEntityDto;
import kmsweb.entities.listeners.PatientVisitEntityListener;
import kmsweb.serializers.PatientVisitSerializer;
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

import java.util.*;
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
@EntityListeners({PatientVisitEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PatientVisitSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PatientVisitEntity extends AbstractEntity {

	/**
	 * Takes a PatientVisitEntityDto and converts it into a PatientVisitEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param patientVisitEntityDto
	 */
	public PatientVisitEntity(PatientVisitEntityDto patientVisitEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (patientVisitEntityDto.getId() != null) {
			this.setId(patientVisitEntityDto.getId());
		}

		if (patientVisitEntityDto.getVisitNumber() != null) {
			this.setVisitNumber(patientVisitEntityDto.getVisitNumber());
		}

		if (patientVisitEntityDto.getRegistrationType() != null) {
			this.setRegistrationType(patientVisitEntityDto.getRegistrationType());
		}

		if (patientVisitEntityDto.getVisitDate() != null) {
			this.setVisitDate(patientVisitEntityDto.getVisitDate());
		}

		if (patientVisitEntityDto.getRegistrationLocation() != null) {
			this.setRegistrationLocation(patientVisitEntityDto.getRegistrationLocation());
		}

		if (patientVisitEntityDto.getPatientPaymentType() != null) {
			this.setPatientPaymentType(patientVisitEntityDto.getPatientPaymentType());
		}

		if (patientVisitEntityDto.getVisitType() != null) {
			this.setVisitType(patientVisitEntityDto.getVisitType());
		}

		if (patientVisitEntityDto.getBpjsPcareRegistrations() != null) {
			this.setBpjsPcareRegistrations(patientVisitEntityDto.getBpjsPcareRegistrations());
		}

		if (patientVisitEntityDto.getBpjsVisitDatas() != null) {
			this.setBpjsVisitDatas(patientVisitEntityDto.getBpjsVisitDatas());
		}

		if (patientVisitEntityDto.getBpjsPcarePendaftarans() != null) {
			this.setBpjsPcarePendaftarans(patientVisitEntityDto.getBpjsPcarePendaftarans());
		}

		if (patientVisitEntityDto.getInvoices() != null) {
			this.setInvoices(patientVisitEntityDto.getInvoices());
		}

		if (patientVisitEntityDto.getPatientVisitPatientPaymentInsurance() != null) {
			this.setPatientVisitPatientPaymentInsurance(patientVisitEntityDto.getPatientVisitPatientPaymentInsurance());
		}

		if (patientVisitEntityDto.getPatientVisitPatientPaymentOthers() != null) {
			this.setPatientVisitPatientPaymentOthers(patientVisitEntityDto.getPatientVisitPatientPaymentOthers());
		}

		if (patientVisitEntityDto.getPatientVisitPaymentSelfPaying() != null) {
			this.setPatientVisitPaymentSelfPaying(patientVisitEntityDto.getPatientVisitPaymentSelfPaying());
		}

		if (patientVisitEntityDto.getRegistrations() != null) {
			this.setRegistrations(patientVisitEntityDto.getRegistrations());
		}

		if (patientVisitEntityDto.getPatient() != null) {
			this.setPatient(patientVisitEntityDto.getPatient());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Visit Number here] off begin
	@CsvBindByName(column = "VISIT_NUMBER", required = true)
	@NotNull(message = "Visit Number must not be empty")
	@Column(name = "visit_number")
	@Schema(description = "The Visit Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visit Number here] end
	private String visitNumber;

	// % protected region % [Modify attribute annotation for Registration Type here] off begin
	@CsvBindByName(column = "REGISTRATION_TYPE", required = false)
	@Nullable
	@Column(name = "registration_type")
	@Schema(description = "The Registration Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Registration Type here] end
	private String registrationType;

	// % protected region % [Modify attribute annotation for Visit Date here] off begin

	@CsvCustomBindByName(column = "VISIT_DATE", converter = DateTimeConverter.class, required = true)
	@NotNull(message = "Visit Date must not be empty")
	@Column(name = "visit_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Visit Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visit Date here] end
	private OffsetDateTime visitDate;

	// % protected region % [Modify attribute annotation for Registration Location here] off begin
	@CsvBindByName(column = "REGISTRATION_LOCATION", required = true)
	@NotNull(message = "Registration Location must not be empty")
	@Column(name = "registration_location")
	@Schema(description = "The Registration Location of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Registration Location here] end
	private String registrationLocation;

	// % protected region % [Modify attribute annotation for Patient Payment Type here] off begin
	@CsvBindByName(column = "PATIENT_PAYMENT_TYPE", required = false)
	@Nullable
	@Column(name = "patient_payment_type")
	@Schema(description = "The Patient Payment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient Payment Type here] end
	private String patientPaymentType;

	// % protected region % [Modify attribute annotation for Visit Type here] off begin
	@CsvBindByName(column = "VISIT_TYPE", required = false)
	@Nullable
	@Column(name = "visit_type")
	@Schema(description = "The Visit Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Visit Type here] end
	private String visitType;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for BPJS Pcare Registrations here] off begin
	@Schema(description = "The BPJS Pcare Registrations entities that are related to this entity.")
	@OneToOne(mappedBy = "patientVisit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Pcare Registrations here] end
	private BpjsPcareRegistrationsEntity bpjsPcareRegistrations;

	// % protected region % [Update the annotation for bpjsPcareRegistrationsId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PCARE_REGISTRATIONS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsPcareRegistrationsId here] end
	private UUID bpjsPcareRegistrationsId;

	// % protected region % [Update the annotation for BPJS Visit Datas here] off begin
	@Schema(description = "The BPJS Visit Data entities that are related to this entity.")
	@OneToMany(mappedBy = "patientVisit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Visit Datas here] end
	private Set<BpjsVisitDataEntity> bpjsVisitDatas = new HashSet<>();

	// % protected region % [Update the annotation for bpjsVisitDatasIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_VISIT_DATAS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsVisitDatasIds here] end
	private Set<UUID> bpjsVisitDatasIds = new HashSet<>();

	// % protected region % [Update the annotation for Bpjs Pcare Pendaftarans here] off begin
	@Schema(description = "The Bpjs Pcare Pendaftaran entities that are related to this entity.")
	@OneToMany(mappedBy = "patientVisit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Bpjs Pcare Pendaftarans here] end
	private Set<BpjsPcarePendaftaranEntity> bpjsPcarePendaftarans = new HashSet<>();

	// % protected region % [Update the annotation for bpjsPcarePendaftaransIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_PCARE_PENDAFTARANS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for bpjsPcarePendaftaransIds here] end
	private Set<UUID> bpjsPcarePendaftaransIds = new HashSet<>();

	// % protected region % [Update the annotation for Invoices here] off begin
	@Schema(description = "The Invoice entities that are related to this entity.")
	@OneToMany(mappedBy = "patientVisit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Invoices here] end
	private Set<InvoiceEntity> invoices = new HashSet<>();

	// % protected region % [Update the annotation for invoicesIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "INVOICES_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for invoicesIds here] end
	private Set<UUID> invoicesIds = new HashSet<>();

	// % protected region % [Update the annotation for Patient Visit Patient Payment Insurance here] off begin
	@Schema(description = "The Patient Visit Patient Payment Insurance entities that are related to this entity.")
	@OneToOne(mappedBy = "patientVisit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Visit Patient Payment Insurance here] end
	private PatientVisitPatientPaymentInsuranceEntity patientVisitPatientPaymentInsurance;

	// % protected region % [Update the annotation for patientVisitPatientPaymentInsuranceId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientVisitPatientPaymentInsuranceId here] end
	private UUID patientVisitPatientPaymentInsuranceId;

	// % protected region % [Update the annotation for Patient Visit Patient Payment Others here] off begin
	@Schema(description = "The Patient Visit Patient Payment Others entities that are related to this entity.")
	@OneToOne(mappedBy = "patientVisit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Visit Patient Payment Others here] end
	private PatientVisitPatientPaymentOthersEntity patientVisitPatientPaymentOthers;

	// % protected region % [Update the annotation for patientVisitPatientPaymentOthersId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientVisitPatientPaymentOthersId here] end
	private UUID patientVisitPatientPaymentOthersId;

	// % protected region % [Update the annotation for Patient Visit Payment Self Paying here] off begin
	@Schema(description = "The Patient Visit Payment Self Paying entities that are related to this entity.")
	@OneToOne(mappedBy = "patientVisit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Visit Payment Self Paying here] end
	private PatientVisitPaymentSelfPayingEntity patientVisitPaymentSelfPaying;

	// % protected region % [Update the annotation for patientVisitPaymentSelfPayingId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VISIT_PAYMENT_SELF_PAYING_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientVisitPaymentSelfPayingId here] end
	private UUID patientVisitPaymentSelfPayingId;

	// % protected region % [Update the annotation for Registrations here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToMany(mappedBy = "patientVisit", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registrations here] end
	private Set<RegistrationEntity> registrations = new HashSet<>();

	// % protected region % [Update the annotation for registrationsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATIONS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for registrationsIds here] end
	private Set<UUID> registrationsIds = new HashSet<>();

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Patient here] off begin
	@Schema(description = "The Patient entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient here] end
	private PatientGeneralInfoEntity patient;

	// % protected region % [Update the annotation for patientId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientId here] end
	private UUID patientId;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing reference methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setBpjsPcareRegistrations(BpjsPcareRegistrationsEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setBpjsPcareRegistrations(@NotNull BpjsPcareRegistrationsEntity entity) {
		setBpjsPcareRegistrations(entity, true);
	}

	/**
	 * Set or update bpjsPcareRegistrations with the given BpjsPcareRegistrationsEntity.
	 *
	 * @param entity the PatientVisitEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsPcareRegistrations(@NotNull BpjsPcareRegistrationsEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcareRegistrations here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsPcareRegistrations here] end

		if (sameAsFormer(this.bpjsPcareRegistrations, entity)) {
			return;
		}

		if (this.bpjsPcareRegistrations != null) {
			this.bpjsPcareRegistrations.unsetPatientVisit();
		}

		this.bpjsPcareRegistrations = entity;

		if (reverseAdd) {
			this.bpjsPcareRegistrations.setPatientVisit(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsPcareRegistrations outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsPcareRegistrations outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsPcareRegistrations(boolean)} but default to true.
	 */
	public void unsetBpjsPcareRegistrations() {
		this.unsetBpjsPcareRegistrations(true);
	}

	/**
	 * Remove the BpjsPcareRegistrationsEntity in BPJS Pcare Registrations from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsPcareRegistrations(boolean reverse) {
		if (reverse && this.bpjsPcareRegistrations != null) {
			this.bpjsPcareRegistrations.unsetPatientVisit(false);
		}
		this.bpjsPcareRegistrations = null;
	}

/**
	 * Similar to {@link this#addBpjsVisitDatas(BpjsVisitDataEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsVisitDataEntity to be added to this entity
	 */
	public void addBpjsVisitDatas(@NotNull BpjsVisitDataEntity entity) {
		addBpjsVisitDatas(entity, true);
	}

	/**
	 * Add a new BpjsVisitDataEntity to bpjsVisitDatas in this entity.
	 *
	 * @param entity the given BpjsVisitDataEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsVisitDatas(@NonNull BpjsVisitDataEntity entity, boolean reverseAdd) {
		if (!this.bpjsVisitDatas.contains(entity)) {
			bpjsVisitDatas.add(entity);
			if (reverseAdd) {
				entity.setPatientVisit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsVisitDatas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to be added to this entity
	 */
	public void addBpjsVisitDatas(@NotNull Collection<BpjsVisitDataEntity> entities) {
		addBpjsVisitDatas(entities, true);
	}

	/**
	 * Add a new collection of BpjsVisitDataEntity to BPJS Visit Datas in this entity.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsVisitDatas(@NonNull Collection<BpjsVisitDataEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsVisitDatas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsVisitDatas(BpjsVisitDataEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsVisitDataEntity to be set to this entity
	 */
	public void removeBpjsVisitDatas(@NotNull BpjsVisitDataEntity entity) {
		this.removeBpjsVisitDatas(entity, true);
	}

	/**
	 * Remove the given BpjsVisitDataEntity from this entity.
	 *
	 * @param entity the given BpjsVisitDataEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsVisitDatas(@NotNull BpjsVisitDataEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientVisit(false);
		}
		this.bpjsVisitDatas.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsVisitDatas(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to be removed to this entity
	 */
	public void removeBpjsVisitDatas(@NotNull Collection<BpjsVisitDataEntity> entities) {
		this.removeBpjsVisitDatas(entities, true);
	}

	/**
	 * Remove the given collection of BpjsVisitDataEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsVisitDatas(@NonNull Collection<BpjsVisitDataEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsVisitDatas(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsVisitDatas(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to be set to this entity
	 */
	public void setBpjsVisitDatas(@NotNull Collection<BpjsVisitDataEntity> entities) {
		setBpjsVisitDatas(entities, true);
	}

	/**
	 * Replace the current entities in BPJS Visit Datas with the given ones.
	 *
	 * @param entities the given collection of BpjsVisitDataEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsVisitDatas(@NotNull Collection<BpjsVisitDataEntity> entities, boolean reverseAdd) {

		this.unsetBpjsVisitDatas();
		this.bpjsVisitDatas = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsVisitDatas.forEach(bpjsVisitDatasEntity -> bpjsVisitDatasEntity.setPatientVisit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsVisitDatas(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsVisitDatas() {
		this.unsetBpjsVisitDatas(true);
	}

	/**
	 * Remove all the entities in BPJS Visit Datas from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsVisitDatas(boolean doReverse) {
		if (doReverse) {
			this.bpjsVisitDatas.forEach(bpjsVisitDatasEntity -> bpjsVisitDatasEntity.unsetPatientVisit(false));
		}
		this.bpjsVisitDatas.clear();
	}

/**
	 * Similar to {@link this#addBpjsPcarePendaftarans(BpjsPcarePendaftaranEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPcarePendaftaranEntity to be added to this entity
	 */
	public void addBpjsPcarePendaftarans(@NotNull BpjsPcarePendaftaranEntity entity) {
		addBpjsPcarePendaftarans(entity, true);
	}

	/**
	 * Add a new BpjsPcarePendaftaranEntity to bpjsPcarePendaftarans in this entity.
	 *
	 * @param entity the given BpjsPcarePendaftaranEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addBpjsPcarePendaftarans(@NonNull BpjsPcarePendaftaranEntity entity, boolean reverseAdd) {
		if (!this.bpjsPcarePendaftarans.contains(entity)) {
			bpjsPcarePendaftarans.add(entity);
			if (reverseAdd) {
				entity.setPatientVisit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addBpjsPcarePendaftarans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to be added to this entity
	 */
	public void addBpjsPcarePendaftarans(@NotNull Collection<BpjsPcarePendaftaranEntity> entities) {
		addBpjsPcarePendaftarans(entities, true);
	}

	/**
	 * Add a new collection of BpjsPcarePendaftaranEntity to Bpjs Pcare Pendaftarans in this entity.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addBpjsPcarePendaftarans(@NonNull Collection<BpjsPcarePendaftaranEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addBpjsPcarePendaftarans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeBpjsPcarePendaftarans(BpjsPcarePendaftaranEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsPcarePendaftaranEntity to be set to this entity
	 */
	public void removeBpjsPcarePendaftarans(@NotNull BpjsPcarePendaftaranEntity entity) {
		this.removeBpjsPcarePendaftarans(entity, true);
	}

	/**
	 * Remove the given BpjsPcarePendaftaranEntity from this entity.
	 *
	 * @param entity the given BpjsPcarePendaftaranEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeBpjsPcarePendaftarans(@NotNull BpjsPcarePendaftaranEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientVisit(false);
		}
		this.bpjsPcarePendaftarans.remove(entity);
	}

	/**
	 * Similar to {@link this#removeBpjsPcarePendaftarans(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to be removed to this entity
	 */
	public void removeBpjsPcarePendaftarans(@NotNull Collection<BpjsPcarePendaftaranEntity> entities) {
		this.removeBpjsPcarePendaftarans(entities, true);
	}

	/**
	 * Remove the given collection of BpjsPcarePendaftaranEntity from  to this entity.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeBpjsPcarePendaftarans(@NonNull Collection<BpjsPcarePendaftaranEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeBpjsPcarePendaftarans(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setBpjsPcarePendaftarans(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to be set to this entity
	 */
	public void setBpjsPcarePendaftarans(@NotNull Collection<BpjsPcarePendaftaranEntity> entities) {
		setBpjsPcarePendaftarans(entities, true);
	}

	/**
	 * Replace the current entities in Bpjs Pcare Pendaftarans with the given ones.
	 *
	 * @param entities the given collection of BpjsPcarePendaftaranEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setBpjsPcarePendaftarans(@NotNull Collection<BpjsPcarePendaftaranEntity> entities, boolean reverseAdd) {

		this.unsetBpjsPcarePendaftarans();
		this.bpjsPcarePendaftarans = new HashSet<>(entities);
		if (reverseAdd) {
			this.bpjsPcarePendaftarans.forEach(bpjsPcarePendaftaransEntity -> bpjsPcarePendaftaransEntity.setPatientVisit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetBpjsPcarePendaftarans(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetBpjsPcarePendaftarans() {
		this.unsetBpjsPcarePendaftarans(true);
	}

	/**
	 * Remove all the entities in Bpjs Pcare Pendaftarans from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetBpjsPcarePendaftarans(boolean doReverse) {
		if (doReverse) {
			this.bpjsPcarePendaftarans.forEach(bpjsPcarePendaftaransEntity -> bpjsPcarePendaftaransEntity.unsetPatientVisit(false));
		}
		this.bpjsPcarePendaftarans.clear();
	}

/**
	 * Similar to {@link this#addInvoices(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be added to this entity
	 */
	public void addInvoices(@NotNull InvoiceEntity entity) {
		addInvoices(entity, true);
	}

	/**
	 * Add a new InvoiceEntity to invoices in this entity.
	 *
	 * @param entity the given InvoiceEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addInvoices(@NonNull InvoiceEntity entity, boolean reverseAdd) {
		if (!this.invoices.contains(entity)) {
			invoices.add(entity);
			if (reverseAdd) {
				entity.setPatientVisit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 */
	public void addInvoices(@NotNull Collection<InvoiceEntity> entities) {
		addInvoices(entities, true);
	}

	/**
	 * Add a new collection of InvoiceEntity to Invoices in this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeInvoices(InvoiceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceEntity to be set to this entity
	 */
	public void removeInvoices(@NotNull InvoiceEntity entity) {
		this.removeInvoices(entity, true);
	}

	/**
	 * Remove the given InvoiceEntity from this entity.
	 *
	 * @param entity the given InvoiceEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeInvoices(@NotNull InvoiceEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientVisit(false);
		}
		this.invoices.remove(entity);
	}

	/**
	 * Similar to {@link this#removeInvoices(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 */
	public void removeInvoices(@NotNull Collection<InvoiceEntity> entities) {
		this.removeInvoices(entities, true);
	}

	/**
	 * Remove the given collection of InvoiceEntity from  to this entity.
	 *
	 * @param entities the given collection of InvoiceEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeInvoices(@NonNull Collection<InvoiceEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeInvoices(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setInvoices(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of InvoiceEntity to be set to this entity
	 */
	public void setInvoices(@NotNull Collection<InvoiceEntity> entities) {
		setInvoices(entities, true);
	}

	/**
	 * Replace the current entities in Invoices with the given ones.
	 *
	 * @param entities the given collection of InvoiceEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setInvoices(@NotNull Collection<InvoiceEntity> entities, boolean reverseAdd) {

		this.unsetInvoices();
		this.invoices = new HashSet<>(entities);
		if (reverseAdd) {
			this.invoices.forEach(invoicesEntity -> invoicesEntity.setPatientVisit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetInvoices(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetInvoices() {
		this.unsetInvoices(true);
	}

	/**
	 * Remove all the entities in Invoices from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetInvoices(boolean doReverse) {
		if (doReverse) {
			this.invoices.forEach(invoicesEntity -> invoicesEntity.unsetPatientVisit(false));
		}
		this.invoices.clear();
	}

	/**
	 * Similar to {@link this#setPatientVisitPatientPaymentInsurance(PatientVisitPatientPaymentInsuranceEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisitPatientPaymentInsurance(@NotNull PatientVisitPatientPaymentInsuranceEntity entity) {
		setPatientVisitPatientPaymentInsurance(entity, true);
	}

	/**
	 * Set or update patientVisitPatientPaymentInsurance with the given PatientVisitPatientPaymentInsuranceEntity.
	 *
	 * @param entity the PatientVisitEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisitPatientPaymentInsurance(@NotNull PatientVisitPatientPaymentInsuranceEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPatientPaymentInsurance here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPatientPaymentInsurance here] end

		if (sameAsFormer(this.patientVisitPatientPaymentInsurance, entity)) {
			return;
		}

		if (this.patientVisitPatientPaymentInsurance != null) {
			this.patientVisitPatientPaymentInsurance.unsetPatientVisit();
		}

		this.patientVisitPatientPaymentInsurance = entity;

		if (reverseAdd) {
			this.patientVisitPatientPaymentInsurance.setPatientVisit(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPatientPaymentInsurance outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPatientPaymentInsurance outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisitPatientPaymentInsurance(boolean)} but default to true.
	 */
	public void unsetPatientVisitPatientPaymentInsurance() {
		this.unsetPatientVisitPatientPaymentInsurance(true);
	}

	/**
	 * Remove the PatientVisitPatientPaymentInsuranceEntity in Patient Visit Patient Payment Insurance from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisitPatientPaymentInsurance(boolean reverse) {
		if (reverse && this.patientVisitPatientPaymentInsurance != null) {
			this.patientVisitPatientPaymentInsurance.unsetPatientVisit(false);
		}
		this.patientVisitPatientPaymentInsurance = null;
	}

	/**
	 * Similar to {@link this#setPatientVisitPatientPaymentOthers(PatientVisitPatientPaymentOthersEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisitPatientPaymentOthers(@NotNull PatientVisitPatientPaymentOthersEntity entity) {
		setPatientVisitPatientPaymentOthers(entity, true);
	}

	/**
	 * Set or update patientVisitPatientPaymentOthers with the given PatientVisitPatientPaymentOthersEntity.
	 *
	 * @param entity the PatientVisitEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisitPatientPaymentOthers(@NotNull PatientVisitPatientPaymentOthersEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPatientPaymentOthers here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPatientPaymentOthers here] end

		if (sameAsFormer(this.patientVisitPatientPaymentOthers, entity)) {
			return;
		}

		if (this.patientVisitPatientPaymentOthers != null) {
			this.patientVisitPatientPaymentOthers.unsetPatientVisit();
		}

		this.patientVisitPatientPaymentOthers = entity;

		if (reverseAdd) {
			this.patientVisitPatientPaymentOthers.setPatientVisit(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPatientPaymentOthers outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPatientPaymentOthers outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisitPatientPaymentOthers(boolean)} but default to true.
	 */
	public void unsetPatientVisitPatientPaymentOthers() {
		this.unsetPatientVisitPatientPaymentOthers(true);
	}

	/**
	 * Remove the PatientVisitPatientPaymentOthersEntity in Patient Visit Patient Payment Others from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisitPatientPaymentOthers(boolean reverse) {
		if (reverse && this.patientVisitPatientPaymentOthers != null) {
			this.patientVisitPatientPaymentOthers.unsetPatientVisit(false);
		}
		this.patientVisitPatientPaymentOthers = null;
	}

	/**
	 * Similar to {@link this#setPatientVisitPaymentSelfPaying(PatientVisitPaymentSelfPayingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisitPaymentSelfPaying(@NotNull PatientVisitPaymentSelfPayingEntity entity) {
		setPatientVisitPaymentSelfPaying(entity, true);
	}

	/**
	 * Set or update patientVisitPaymentSelfPaying with the given PatientVisitPaymentSelfPayingEntity.
	 *
	 * @param entity the PatientVisitEntity to be set or updated
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisitPaymentSelfPaying(@NotNull PatientVisitPaymentSelfPayingEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPaymentSelfPaying here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisitPaymentSelfPaying here] end

		if (sameAsFormer(this.patientVisitPaymentSelfPaying, entity)) {
			return;
		}

		if (this.patientVisitPaymentSelfPaying != null) {
			this.patientVisitPaymentSelfPaying.unsetPatientVisit();
		}

		this.patientVisitPaymentSelfPaying = entity;

		if (reverseAdd) {
			this.patientVisitPaymentSelfPaying.setPatientVisit(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPaymentSelfPaying outgoingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisitPaymentSelfPaying outgoingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisitPaymentSelfPaying(boolean)} but default to true.
	 */
	public void unsetPatientVisitPaymentSelfPaying() {
		this.unsetPatientVisitPaymentSelfPaying(true);
	}

	/**
	 * Remove the PatientVisitPaymentSelfPayingEntity in Patient Visit Payment Self Paying from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisitPaymentSelfPaying(boolean reverse) {
		if (reverse && this.patientVisitPaymentSelfPaying != null) {
			this.patientVisitPaymentSelfPaying.unsetPatientVisit(false);
		}
		this.patientVisitPaymentSelfPaying = null;
	}

/**
	 * Similar to {@link this#addRegistrations(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be added to this entity
	 */
	public void addRegistrations(@NotNull RegistrationEntity entity) {
		addRegistrations(entity, true);
	}

	/**
	 * Add a new RegistrationEntity to registrations in this entity.
	 *
	 * @param entity the given RegistrationEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addRegistrations(@NonNull RegistrationEntity entity, boolean reverseAdd) {
		if (!this.registrations.contains(entity)) {
			registrations.add(entity);
			if (reverseAdd) {
				entity.setPatientVisit(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 */
	public void addRegistrations(@NotNull Collection<RegistrationEntity> entities) {
		addRegistrations(entities, true);
	}

	/**
	 * Add a new collection of RegistrationEntity to Registrations in this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addRegistrations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeRegistrations(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void removeRegistrations(@NotNull RegistrationEntity entity) {
		this.removeRegistrations(entity, true);
	}

	/**
	 * Remove the given RegistrationEntity from this entity.
	 *
	 * @param entity the given RegistrationEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeRegistrations(@NotNull RegistrationEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetPatientVisit(false);
		}
		this.registrations.remove(entity);
	}

	/**
	 * Similar to {@link this#removeRegistrations(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 */
	public void removeRegistrations(@NotNull Collection<RegistrationEntity> entities) {
		this.removeRegistrations(entities, true);
	}

	/**
	 * Remove the given collection of RegistrationEntity from  to this entity.
	 *
	 * @param entities the given collection of RegistrationEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeRegistrations(@NonNull Collection<RegistrationEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeRegistrations(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setRegistrations(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of RegistrationEntity to be set to this entity
	 */
	public void setRegistrations(@NotNull Collection<RegistrationEntity> entities) {
		setRegistrations(entities, true);
	}

	/**
	 * Replace the current entities in Registrations with the given ones.
	 *
	 * @param entities the given collection of RegistrationEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setRegistrations(@NotNull Collection<RegistrationEntity> entities, boolean reverseAdd) {

		this.unsetRegistrations();
		this.registrations = new HashSet<>(entities);
		if (reverseAdd) {
			this.registrations.forEach(registrationsEntity -> registrationsEntity.setPatientVisit(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetRegistrations(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetRegistrations() {
		this.unsetRegistrations(true);
	}

	/**
	 * Remove all the entities in Registrations from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetRegistrations(boolean doReverse) {
		if (doReverse) {
			this.registrations.forEach(registrationsEntity -> registrationsEntity.unsetPatientVisit(false));
		}
		this.registrations.clear();
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming references methods
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Similar to {@link this#setPatient(PatientGeneralInfoEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set to this entity
	 */
	public void setPatient(@NotNull PatientGeneralInfoEntity entity) {
		setPatient(entity, true);
	}

	/**
	 * Set or update the patient in this entity with single PatientGeneralInfoEntity.
	 *
	 * @param entity the given PatientGeneralInfoEntity to be set or updated to patient
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatient(@NotNull PatientGeneralInfoEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatient here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatient here] end

		if (sameAsFormer(this.patient, entity)) {
			return;
		}

		if (this.patient != null) {
			this.patient.removeVisits(this, false);
		}
		this.patient = entity;
		if (reverseAdd) {
			this.patient.addVisits(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatient incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatient incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPatient(boolean)} but default to true.
	 */
	public void unsetPatient() {
		this.unsetPatient(true);
	}

	/**
	 * Remove Patient in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatient(boolean reverse) {
		if (reverse && this.patient != null) {
			this.patient.removeVisits(this, false);
		}
		this.patient = null;
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
		return "VISIT_NUMBER,REGISTRATION_TYPE,VISIT_DATE,REGISTRATION_LOCATION,PATIENT_PAYMENT_TYPE,VISIT_TYPE,PATIENT_ID,BPJS_PCARE_REGISTRATIONS_ID,BPJS_VISIT_DATAS_IDS,BPJS_PCARE_PENDAFTARANS_IDS,INVOICES_IDS,PATIENT_VISIT_PATIENT_PAYMENT_INSURANCE_ID,PATIENT_VISIT_PATIENT_PAYMENT_OTHERS_ID,PATIENT_VISIT_PAYMENT_SELF_PAYING_ID,REGISTRATIONS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		Optional<PatientGeneralInfoEntity> patientRelation = Optional.ofNullable(this.patient);
		patientRelation.ifPresent(entity -> this.patientId = entity.getId());

		Optional<BpjsPcareRegistrationsEntity> bpjsPcareRegistrationsRelation = Optional.ofNullable(this.bpjsPcareRegistrations);
		bpjsPcareRegistrationsRelation.ifPresent(entity -> this.bpjsPcareRegistrationsId = entity.getId());

		this.bpjsVisitDatasIds = new HashSet<>();
		for (BpjsVisitDataEntity bpjsVisitDatas: this.bpjsVisitDatas) {
			this.bpjsVisitDatasIds.add(bpjsVisitDatas.getId());
		}

		this.bpjsPcarePendaftaransIds = new HashSet<>();
		for (BpjsPcarePendaftaranEntity bpjsPcarePendaftarans: this.bpjsPcarePendaftarans) {
			this.bpjsPcarePendaftaransIds.add(bpjsPcarePendaftarans.getId());
		}

		this.invoicesIds = new HashSet<>();
		for (InvoiceEntity invoices: this.invoices) {
			this.invoicesIds.add(invoices.getId());
		}

		Optional<PatientVisitPatientPaymentInsuranceEntity> patientVisitPatientPaymentInsuranceRelation = Optional.ofNullable(this.patientVisitPatientPaymentInsurance);
		patientVisitPatientPaymentInsuranceRelation.ifPresent(entity -> this.patientVisitPatientPaymentInsuranceId = entity.getId());

		Optional<PatientVisitPatientPaymentOthersEntity> patientVisitPatientPaymentOthersRelation = Optional.ofNullable(this.patientVisitPatientPaymentOthers);
		patientVisitPatientPaymentOthersRelation.ifPresent(entity -> this.patientVisitPatientPaymentOthersId = entity.getId());

		Optional<PatientVisitPaymentSelfPayingEntity> patientVisitPaymentSelfPayingRelation = Optional.ofNullable(this.patientVisitPaymentSelfPaying);
		patientVisitPaymentSelfPayingRelation.ifPresent(entity -> this.patientVisitPaymentSelfPayingId = entity.getId());

		this.registrationsIds = new HashSet<>();
		for (RegistrationEntity registrations: this.registrations) {
			this.registrationsIds.add(registrations.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object patientVisit) {
		if (this == patientVisit) {
			return true;
		}
		if (patientVisit == null || this.getClass() != patientVisit.getClass()) {
			return false;
		}
		if (!super.equals(patientVisit)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PatientVisitEntity that = (PatientVisitEntity) patientVisit;
		return
			Objects.equals(this.visitNumber, that.visitNumber) &&
			Objects.equals(this.registrationType, that.registrationType) &&
			Objects.equals(
			     this.visitDate != null ? this.visitDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.visitDate != null ? that.visitDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.registrationLocation, that.registrationLocation) &&
			Objects.equals(this.patientPaymentType, that.patientPaymentType) &&
			Objects.equals(this.visitType, that.visitType) &&
			Objects.equals(this.bpjsPcareRegistrationsId, that.bpjsPcareRegistrationsId) &&
			Objects.equals(this.bpjsVisitDatasIds, that.bpjsVisitDatasIds) &&
			Objects.equals(this.bpjsPcarePendaftaransIds, that.bpjsPcarePendaftaransIds) &&
			Objects.equals(this.invoicesIds, that.invoicesIds) &&
			Objects.equals(this.patientVisitPatientPaymentInsuranceId, that.patientVisitPatientPaymentInsuranceId) &&
			Objects.equals(this.patientVisitPatientPaymentOthersId, that.patientVisitPatientPaymentOthersId) &&
			Objects.equals(this.patientVisitPaymentSelfPayingId, that.patientVisitPaymentSelfPayingId) &&
			Objects.equals(this.registrationsIds, that.registrationsIds) &&
			Objects.equals(this.patientId, that.patientId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
