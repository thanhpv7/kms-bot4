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
import kmsweb.dtos.BpjsPcareRegistrationsEntityDto;
import kmsweb.entities.listeners.BpjsPcareRegistrationsEntityListener;
import kmsweb.serializers.BpjsPcareRegistrationsSerializer;
import kmsweb.lib.validators.ValidatorPatterns;
import kmsweb.services.utils.converters.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.opencsv.bean.CsvIgnore;
import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvCustomBindByName;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.lang.Nullable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.hibernate.envers.Audited;

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
@EntityListeners({BpjsPcareRegistrationsEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsPcareRegistrationsSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsPcareRegistrationsEntity extends AbstractEntity {

	/**
	 * Takes a BpjsPcareRegistrationsEntityDto and converts it into a BpjsPcareRegistrationsEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsPcareRegistrationsEntityDto
	 */
	public BpjsPcareRegistrationsEntity(BpjsPcareRegistrationsEntityDto bpjsPcareRegistrationsEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsPcareRegistrationsEntityDto.getId() != null) {
			this.setId(bpjsPcareRegistrationsEntityDto.getId());
		}

		if (bpjsPcareRegistrationsEntityDto.getKdproviderpeserta() != null) {
			this.setKdproviderpeserta(bpjsPcareRegistrationsEntityDto.getKdproviderpeserta());
		}

		if (bpjsPcareRegistrationsEntityDto.getTgldaftar() != null) {
			this.setTgldaftar(bpjsPcareRegistrationsEntityDto.getTgldaftar());
		}

		if (bpjsPcareRegistrationsEntityDto.getNokartu() != null) {
			this.setNokartu(bpjsPcareRegistrationsEntityDto.getNokartu());
		}

		if (bpjsPcareRegistrationsEntityDto.getKdpoli() != null) {
			this.setKdpoli(bpjsPcareRegistrationsEntityDto.getKdpoli());
		}

		if (bpjsPcareRegistrationsEntityDto.getKeluhan() != null) {
			this.setKeluhan(bpjsPcareRegistrationsEntityDto.getKeluhan());
		}

		if (bpjsPcareRegistrationsEntityDto.getKunjsakit() != null) {
			this.setKunjsakit(bpjsPcareRegistrationsEntityDto.getKunjsakit());
		}

		if (bpjsPcareRegistrationsEntityDto.getSistole() != null) {
			this.setSistole(bpjsPcareRegistrationsEntityDto.getSistole());
		}

		if (bpjsPcareRegistrationsEntityDto.getDiastole() != null) {
			this.setDiastole(bpjsPcareRegistrationsEntityDto.getDiastole());
		}

		if (bpjsPcareRegistrationsEntityDto.getBeratbadan() != null) {
			this.setBeratbadan(bpjsPcareRegistrationsEntityDto.getBeratbadan());
		}

		if (bpjsPcareRegistrationsEntityDto.getTinggibadan() != null) {
			this.setTinggibadan(bpjsPcareRegistrationsEntityDto.getTinggibadan());
		}

		if (bpjsPcareRegistrationsEntityDto.getResprate() != null) {
			this.setResprate(bpjsPcareRegistrationsEntityDto.getResprate());
		}

		if (bpjsPcareRegistrationsEntityDto.getLingkarperut() != null) {
			this.setLingkarperut(bpjsPcareRegistrationsEntityDto.getLingkarperut());
		}

		if (bpjsPcareRegistrationsEntityDto.getRujukinternal() != null) {
			this.setRujukinternal(bpjsPcareRegistrationsEntityDto.getRujukinternal());
		}

		if (bpjsPcareRegistrationsEntityDto.getHeartrate() != null) {
			this.setHeartrate(bpjsPcareRegistrationsEntityDto.getHeartrate());
		}

		if (bpjsPcareRegistrationsEntityDto.getRujukbalik() != null) {
			this.setRujukbalik(bpjsPcareRegistrationsEntityDto.getRujukbalik());
		}

		if (bpjsPcareRegistrationsEntityDto.getKdtkp() != null) {
			this.setKdtkp(bpjsPcareRegistrationsEntityDto.getKdtkp());
		}

		if (bpjsPcareRegistrationsEntityDto.getPatientVisit() != null) {
			this.setPatientVisit(bpjsPcareRegistrationsEntityDto.getPatientVisit());
		}

		if (bpjsPcareRegistrationsEntityDto.getRegistration() != null) {
			this.setRegistration(bpjsPcareRegistrationsEntityDto.getRegistration());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for kdProviderPeserta here] off begin
	@CsvBindByName(column = "KDPROVIDERPESERTA", required = false)
	@Nullable
	@Column(name = "kdproviderpeserta")
	@Schema(description = "The kdProviderPeserta of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdProviderPeserta here] end
	private String kdproviderpeserta;

	// % protected region % [Modify attribute annotation for tglDaftar here] off begin
	@CsvBindByName(column = "TGLDAFTAR", required = false)
	@Nullable
	@Column(name = "tgldaftar")
	@Schema(description = "The tglDaftar of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tglDaftar here] end
	private String tgldaftar;

	// % protected region % [Modify attribute annotation for noKartu here] off begin
	@CsvBindByName(column = "NOKARTU", required = false)
	@Nullable
	@Column(name = "nokartu")
	@Schema(description = "The noKartu of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for noKartu here] end
	private String nokartu;

	// % protected region % [Modify attribute annotation for kdPoli here] off begin
	@CsvBindByName(column = "KDPOLI", required = false)
	@Nullable
	@Column(name = "kdpoli")
	@Schema(description = "The kdPoli of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdPoli here] end
	private String kdpoli;

	// % protected region % [Modify attribute annotation for keluhan here] off begin
	@CsvBindByName(column = "KELUHAN", required = false)
	@Nullable
	@Column(name = "keluhan")
	@Schema(description = "The keluhan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for keluhan here] end
	private String keluhan;

	// % protected region % [Modify attribute annotation for kunjSakit here] off begin
	@CsvBindByName(column = "KUNJSAKIT", required = false)
	@Nullable
	@Column(name = "kunjsakit")
	@Schema(description = "The kunjSakit of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kunjSakit here] end
	private String kunjsakit;

	// % protected region % [Modify attribute annotation for sistole here] off begin
	@CsvBindByName(column = "SISTOLE", required = false)
	@Nullable
	@Column(name = "sistole")
	@Schema(description = "The sistole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for sistole here] end
	private String sistole;

	// % protected region % [Modify attribute annotation for diastole here] off begin
	@CsvBindByName(column = "DIASTOLE", required = false)
	@Nullable
	@Column(name = "diastole")
	@Schema(description = "The diastole of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for diastole here] end
	private String diastole;

	// % protected region % [Modify attribute annotation for beratBadan here] off begin
	@CsvBindByName(column = "BERATBADAN", required = false)
	@Nullable
	@Column(name = "beratbadan")
	@Schema(description = "The beratBadan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for beratBadan here] end
	private String beratbadan;

	// % protected region % [Modify attribute annotation for tinggiBadan here] off begin
	@CsvBindByName(column = "TINGGIBADAN", required = false)
	@Nullable
	@Column(name = "tinggibadan")
	@Schema(description = "The tinggiBadan of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for tinggiBadan here] end
	private String tinggibadan;

	// % protected region % [Modify attribute annotation for respRate here] off begin
	@CsvBindByName(column = "RESPRATE", required = false)
	@Nullable
	@Column(name = "resprate")
	@Schema(description = "The respRate of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for respRate here] end
	private String resprate;

	// % protected region % [Modify attribute annotation for lingkarPerut here] off begin
	@CsvBindByName(column = "LINGKARPERUT", required = false)
	@Nullable
	@Column(name = "lingkarperut")
	@Schema(description = "The lingkarPerut of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for lingkarPerut here] end
	private String lingkarperut;

	// % protected region % [Modify attribute annotation for rujukInternal here] off begin
	@CsvBindByName(column = "RUJUKINTERNAL", required = false)
	@Nullable
	@Column(name = "rujukinternal")
	@Schema(description = "The rujukInternal of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for rujukInternal here] end
	private String rujukinternal;

	// % protected region % [Modify attribute annotation for heartRate here] off begin
	@CsvBindByName(column = "HEARTRATE", required = false)
	@Nullable
	@Column(name = "heartrate")
	@Schema(description = "The heartRate of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for heartRate here] end
	private String heartrate;

	// % protected region % [Modify attribute annotation for rujukBalik here] off begin
	@CsvBindByName(column = "RUJUKBALIK", required = false)
	@Nullable
	@Column(name = "rujukbalik")
	@Schema(description = "The rujukBalik of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for rujukBalik here] end
	private String rujukbalik;

	// % protected region % [Modify attribute annotation for kdTkp here] off begin
	@CsvBindByName(column = "KDTKP", required = false)
	@Nullable
	@Column(name = "kdtkp")
	@Schema(description = "The kdTkp of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for kdTkp here] end
	private String kdtkp;

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

	// % protected region % [Update the annotation for Patient Visit here] off begin
	@Schema(description = "The Patient Visit entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Patient Visit here] end
	private PatientVisitEntity patientVisit;

	// % protected region % [Update the annotation for patientVisitId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PATIENT_VISIT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for patientVisitId here] end
	private UUID patientVisitId;

	// % protected region % [Update the annotation for Registration here] off begin
	@Schema(description = "The Registration entities that are related to this entity.")
	@OneToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Registration here] end
	private RegistrationEntity registration;

	// % protected region % [Update the annotation for registrationId here] off begin
	@Transient
	@CsvCustomBindByName(column = "REGISTRATION_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for registrationId here] end
	private UUID registrationId;

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
	 * Similar to {@link this#setPatientVisit(PatientVisitEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PatientVisitEntity to be set to this entity
	 */
	public void setPatientVisit(PatientVisitEntity entity) {
		setPatientVisit(entity, true);
	}

	/**
	 * Set or update the patientVisit in this entity with single PatientVisitEntity.
	 *
	 * @param entity the given PatientVisitEntity to be set or updated to patientVisit
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPatientVisit(PatientVisitEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPatientVisit here] end

		if (sameAsFormer(this.patientVisit, entity)) {
			return;
		}

		if (this.patientVisit != null) {
			this.patientVisit.unsetBpjsPcareRegistrations(false);
		}

		this.patientVisit = entity;
		if (reverseAdd) {
			this.patientVisit.setBpjsPcareRegistrations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPatientVisit incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetPatientVisit(boolean)} but default to true.
	 */
	public void unsetPatientVisit() {
		this.unsetPatientVisit(true);
	}

	/**
	 * Remove the PatientVisitEntity of patientVisit from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPatientVisit(boolean reverse) {
		if (reverse && this.patientVisit != null) {
			this.patientVisit.unsetBpjsPcareRegistrations();
		}
		this.patientVisit = null;
	}
	/**
	 * Similar to {@link this#setRegistration(RegistrationEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given RegistrationEntity to be set to this entity
	 */
	public void setRegistration(RegistrationEntity entity) {
		setRegistration(entity, true);
	}

	/**
	 * Set or update the registration in this entity with single RegistrationEntity.
	 *
	 * @param entity the given RegistrationEntity to be set or updated to registration
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setRegistration(RegistrationEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] off begin
		// % protected region % [Add any additional logic here before the main logic for setRegistration here] end

		if (sameAsFormer(this.registration, entity)) {
			return;
		}

		if (this.registration != null) {
			this.registration.unsetBpjsPcareRegistrations(false);
		}

		this.registration = entity;
		if (reverseAdd) {
			this.registration.setBpjsPcareRegistrations(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] off begin
		// % protected region % [Add any additional logic here after the main logic for setRegistration incomingOneToOne here] end
	}

	/**
	 * Similar to {@link this#unsetRegistration(boolean)} but default to true.
	 */
	public void unsetRegistration() {
		this.unsetRegistration(true);
	}

	/**
	 * Remove the RegistrationEntity of registration from this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetRegistration(boolean reverse) {
		if (reverse && this.registration != null) {
			this.registration.unsetBpjsPcareRegistrations();
		}
		this.registration = null;
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
		return "KDPROVIDERPESERTA,TGLDAFTAR,NOKARTU,KDPOLI,KELUHAN,KUNJSAKIT,SISTOLE,DIASTOLE,BERATBADAN,TINGGIBADAN,RESPRATE,LINGKARPERUT,RUJUKINTERNAL,HEARTRATE,RUJUKBALIK,KDTKP,PATIENT_VISIT_ID,REGISTRATION_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<PatientVisitEntity> patientVisitRelation = Optional.ofNullable(this.patientVisit);
		patientVisitRelation.ifPresent(entity -> this.patientVisitId = entity.getId());

		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsPcareRegistrations) {
		if (this == bpjsPcareRegistrations) {
			return true;
		}
		if (bpjsPcareRegistrations == null || this.getClass() != bpjsPcareRegistrations.getClass()) {
			return false;
		}
		if (!super.equals(bpjsPcareRegistrations)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsPcareRegistrationsEntity that = (BpjsPcareRegistrationsEntity) bpjsPcareRegistrations;
		return
			Objects.equals(this.kdproviderpeserta, that.kdproviderpeserta) &&
			Objects.equals(this.tgldaftar, that.tgldaftar) &&
			Objects.equals(this.nokartu, that.nokartu) &&
			Objects.equals(this.kdpoli, that.kdpoli) &&
			Objects.equals(this.keluhan, that.keluhan) &&
			Objects.equals(this.kunjsakit, that.kunjsakit) &&
			Objects.equals(this.sistole, that.sistole) &&
			Objects.equals(this.diastole, that.diastole) &&
			Objects.equals(this.beratbadan, that.beratbadan) &&
			Objects.equals(this.tinggibadan, that.tinggibadan) &&
			Objects.equals(this.resprate, that.resprate) &&
			Objects.equals(this.lingkarperut, that.lingkarperut) &&
			Objects.equals(this.rujukinternal, that.rujukinternal) &&
			Objects.equals(this.heartrate, that.heartrate) &&
			Objects.equals(this.rujukbalik, that.rujukbalik) &&
			Objects.equals(this.kdtkp, that.kdtkp) &&
			Objects.equals(this.patientVisitId, that.patientVisitId) &&
			Objects.equals(this.registrationId, that.registrationId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
