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
import kmsweb.dtos.BpjsPRBDetailEntityDto;
import kmsweb.entities.listeners.BpjsPRBDetailEntityListener;
import kmsweb.serializers.BpjsPRBDetailSerializer;
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
@EntityListeners({BpjsPRBDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsPRBDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsPRBDetailEntity extends AbstractEntity {

	/**
	 * Takes a BpjsPRBDetailEntityDto and converts it into a BpjsPRBDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsPRBDetailEntityDto
	 */
	public BpjsPRBDetailEntity(BpjsPRBDetailEntityDto bpjsPRBDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsPRBDetailEntityDto.getId() != null) {
			this.setId(bpjsPRBDetailEntityDto.getId());
		}

		if (bpjsPRBDetailEntityDto.getSrbNo() != null) {
			this.setSrbNo(bpjsPRBDetailEntityDto.getSrbNo());
		}

		if (bpjsPRBDetailEntityDto.getDrugCode() != null) {
			this.setDrugCode(bpjsPRBDetailEntityDto.getDrugCode());
		}

		if (bpjsPRBDetailEntityDto.getDrugName() != null) {
			this.setDrugName(bpjsPRBDetailEntityDto.getDrugName());
		}

		if (bpjsPRBDetailEntityDto.getSigna1() != null) {
			this.setSigna1(bpjsPRBDetailEntityDto.getSigna1());
		}

		if (bpjsPRBDetailEntityDto.getSigna2() != null) {
			this.setSigna2(bpjsPRBDetailEntityDto.getSigna2());
		}

		if (bpjsPRBDetailEntityDto.getQty() != null) {
			this.setQty(bpjsPRBDetailEntityDto.getQty());
		}

		if (bpjsPRBDetailEntityDto.getRegistration() != null) {
			this.setRegistration(bpjsPRBDetailEntityDto.getRegistration());
		}

		if (bpjsPRBDetailEntityDto.getBpjsDrugGenericPRB() != null) {
			this.setBpjsDrugGenericPRB(bpjsPRBDetailEntityDto.getBpjsDrugGenericPRB());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for SRB No here] off begin
	@CsvBindByName(column = "SRB_NO", required = false)
	@Nullable
	@Column(name = "srb_no")
	@Schema(description = "The SRB No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SRB No here] end
	private String srbNo;

	// % protected region % [Modify attribute annotation for Drug Code here] off begin
	@CsvBindByName(column = "DRUG_CODE", required = false)
	@Nullable
	@Column(name = "drug_code")
	@Schema(description = "The Drug Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Drug Code here] end
	private String drugCode;

	// % protected region % [Modify attribute annotation for Drug Name here] off begin
	@CsvBindByName(column = "DRUG_NAME", required = false)
	@Nullable
	@Column(name = "drug_name")
	@Schema(description = "The Drug Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Drug Name here] end
	private String drugName;

	// % protected region % [Modify attribute annotation for Signa 1 here] off begin
	@CsvBindByName(column = "SIGNA_1", required = false)
	@Nullable
	@Column(name = "signa_1")
	@Schema(description = "The Signa 1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Signa 1 here] end
	private String signa1;

	// % protected region % [Modify attribute annotation for Signa 2 here] off begin
	@CsvBindByName(column = "SIGNA_2", required = false)
	@Nullable
	@Column(name = "signa_2")
	@Schema(description = "The Signa 2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Signa 2 here] end
	private String signa2;

	// % protected region % [Modify attribute annotation for Qty here] off begin
	@CsvBindByName(column = "QTY", required = false)
	@Nullable
	@Column(name = "qty")
	@Schema(description = "The Qty of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Qty here] end
	private String qty;

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

	// % protected region % [Update the annotation for BPJS Drug Generic PRB here] off begin
	@Schema(description = "The BPJS Drug Generic PRB entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for BPJS Drug Generic PRB here] end
	private BpjsDrugGenericPRBEntity bpjsDrugGenericPRB;

	// % protected region % [Update the annotation for bpjsDrugGenericPRBId here] off begin
	@Transient
	@CsvCustomBindByName(column = "BPJS_DRUG_GENERIC_PRB_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for bpjsDrugGenericPRBId here] end
	private UUID bpjsDrugGenericPRBId;

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
			this.registration.unsetBpjsPRBDetail(false);
		}

		this.registration = entity;
		if (reverseAdd) {
			this.registration.setBpjsPRBDetail(this, false);
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
			this.registration.unsetBpjsPRBDetail();
		}
		this.registration = null;
	}
	/**
	 * Similar to {@link this#setBpjsDrugGenericPRB(BpjsDrugGenericPRBEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDrugGenericPRBEntity to be set to this entity
	 */
	public void setBpjsDrugGenericPRB(@NotNull BpjsDrugGenericPRBEntity entity) {
		setBpjsDrugGenericPRB(entity, true);
	}

	/**
	 * Set or update the bpjsDrugGenericPRB in this entity with single BpjsDrugGenericPRBEntity.
	 *
	 * @param entity the given BpjsDrugGenericPRBEntity to be set or updated to bpjsDrugGenericPRB
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setBpjsDrugGenericPRB(@NotNull BpjsDrugGenericPRBEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setBpjsDrugGenericPRB here] off begin
		// % protected region % [Add any additional logic here before the main logic for setBpjsDrugGenericPRB here] end

		if (sameAsFormer(this.bpjsDrugGenericPRB, entity)) {
			return;
		}

		if (this.bpjsDrugGenericPRB != null) {
			this.bpjsDrugGenericPRB.removeBpjsPRBDetails(this, false);
		}
		this.bpjsDrugGenericPRB = entity;
		if (reverseAdd) {
			this.bpjsDrugGenericPRB.addBpjsPRBDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setBpjsDrugGenericPRB incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setBpjsDrugGenericPRB incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetBpjsDrugGenericPRB(boolean)} but default to true.
	 */
	public void unsetBpjsDrugGenericPRB() {
		this.unsetBpjsDrugGenericPRB(true);
	}

	/**
	 * Remove BPJS Drug Generic PRB in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetBpjsDrugGenericPRB(boolean reverse) {
		if (reverse && this.bpjsDrugGenericPRB != null) {
			this.bpjsDrugGenericPRB.removeBpjsPRBDetails(this, false);
		}
		this.bpjsDrugGenericPRB = null;
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
		return "SRB_NO,DRUG_CODE,DRUG_NAME,SIGNA_1,SIGNA_2,QTY,REGISTRATION_ID,BPJS_DRUG_GENERIC_PRB_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<RegistrationEntity> registrationRelation = Optional.ofNullable(this.registration);
		registrationRelation.ifPresent(entity -> this.registrationId = entity.getId());

		Optional<BpjsDrugGenericPRBEntity> bpjsDrugGenericPRBRelation = Optional.ofNullable(this.bpjsDrugGenericPRB);
		bpjsDrugGenericPRBRelation.ifPresent(entity -> this.bpjsDrugGenericPRBId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsPRBDetail) {
		if (this == bpjsPRBDetail) {
			return true;
		}
		if (bpjsPRBDetail == null || this.getClass() != bpjsPRBDetail.getClass()) {
			return false;
		}
		if (!super.equals(bpjsPRBDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsPRBDetailEntity that = (BpjsPRBDetailEntity) bpjsPRBDetail;
		return
			Objects.equals(this.srbNo, that.srbNo) &&
			Objects.equals(this.drugCode, that.drugCode) &&
			Objects.equals(this.drugName, that.drugName) &&
			Objects.equals(this.signa1, that.signa1) &&
			Objects.equals(this.signa2, that.signa2) &&
			Objects.equals(this.qty, that.qty) &&
			Objects.equals(this.registrationId, that.registrationId) &&
			Objects.equals(this.bpjsDrugGenericPRBId, that.bpjsDrugGenericPRBId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
