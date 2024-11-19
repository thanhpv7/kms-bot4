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
import kmsweb.dtos.BpjsSpecialReferralEntityDto;
import kmsweb.entities.listeners.BpjsSpecialReferralEntityListener;
import kmsweb.serializers.BpjsSpecialReferralSerializer;
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
@EntityListeners({BpjsSpecialReferralEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsSpecialReferralSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsSpecialReferralEntity extends AbstractEntity {

	/**
	 * Takes a BpjsSpecialReferralEntityDto and converts it into a BpjsSpecialReferralEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsSpecialReferralEntityDto
	 */
	public BpjsSpecialReferralEntity(BpjsSpecialReferralEntityDto bpjsSpecialReferralEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsSpecialReferralEntityDto.getId() != null) {
			this.setId(bpjsSpecialReferralEntityDto.getId());
		}

		if (bpjsSpecialReferralEntityDto.getReferralID() != null) {
			this.setReferralID(bpjsSpecialReferralEntityDto.getReferralID());
		}

		if (bpjsSpecialReferralEntityDto.getReferralNo() != null) {
			this.setReferralNo(bpjsSpecialReferralEntityDto.getReferralNo());
		}

		if (bpjsSpecialReferralEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsSpecialReferralEntityDto.getBpjsCardNo());
		}

		if (bpjsSpecialReferralEntityDto.getName() != null) {
			this.setName(bpjsSpecialReferralEntityDto.getName());
		}

		if (bpjsSpecialReferralEntityDto.getPpkDiagnose() != null) {
			this.setPpkDiagnose(bpjsSpecialReferralEntityDto.getPpkDiagnose());
		}

		if (bpjsSpecialReferralEntityDto.getReferralStartDate() != null) {
			this.setReferralStartDate(bpjsSpecialReferralEntityDto.getReferralStartDate());
		}

		if (bpjsSpecialReferralEntityDto.getReferralEndDate() != null) {
			this.setReferralEndDate(bpjsSpecialReferralEntityDto.getReferralEndDate());
		}

		if (bpjsSpecialReferralEntityDto.getAdditionalDiagnose() != null) {
			this.setAdditionalDiagnose(bpjsSpecialReferralEntityDto.getAdditionalDiagnose());
		}

		if (bpjsSpecialReferralEntityDto.getAdditionalProcedure() != null) {
			this.setAdditionalProcedure(bpjsSpecialReferralEntityDto.getAdditionalProcedure());
		}

		if (bpjsSpecialReferralEntityDto.getPrimaryDiagnose() != null) {
			this.setPrimaryDiagnose(bpjsSpecialReferralEntityDto.getPrimaryDiagnose());
		}

		if (bpjsSpecialReferralEntityDto.getPrimaryProcedure() != null) {
			this.setPrimaryProcedure(bpjsSpecialReferralEntityDto.getPrimaryProcedure());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Referral ID here] off begin
	@CsvBindByName(column = "REFERRAL_ID", required = false)
	@Nullable
	@Column(name = "referral_id")
	@Schema(description = "The Referral ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral ID here] end
	private String referralID;

	// % protected region % [Modify attribute annotation for Referral No here] off begin
	@CsvBindByName(column = "REFERRAL_NO", required = false)
	@Nullable
	@Column(name = "referral_no")
	@Schema(description = "The Referral No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral No here] end
	private String referralNo;

	// % protected region % [Modify attribute annotation for BPJS Card No here] off begin
	@CsvBindByName(column = "BPJS_CARD_NO", required = false)
	@Nullable
	@Column(name = "bpjs_card_no")
	@Schema(description = "The BPJS Card No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BPJS Card No here] end
	private String bpjsCardNo;

	// % protected region % [Modify attribute annotation for Name here] off begin
	@CsvBindByName(column = "NAME", required = false)
	@Nullable
	@Column(name = "name")
	@Schema(description = "The Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for PPK Diagnose here] off begin
	@CsvBindByName(column = "PPK_DIAGNOSE", required = false)
	@Nullable
	@Column(name = "ppk_diagnose")
	@Schema(description = "The PPK Diagnose of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for PPK Diagnose here] end
	private String ppkDiagnose;

	// % protected region % [Modify attribute annotation for Referral Start Date here] off begin
	@CsvBindByName(column = "REFERRAL_START_DATE", required = false)
	@Nullable
	@Column(name = "referral_start_date")
	@Schema(description = "The Referral Start Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Start Date here] end
	private String referralStartDate;

	// % protected region % [Modify attribute annotation for Referral End Date here] off begin
	@CsvBindByName(column = "REFERRAL_END_DATE", required = false)
	@Nullable
	@Column(name = "referral_end_date")
	@Schema(description = "The Referral End Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral End Date here] end
	private String referralEndDate;

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

	// % protected region % [Update the annotation for Additional Diagnose here] off begin
	@Schema(description = "The Additional Diagnose entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Additional Diagnose here] end
	private BpjsDiagnoseEntity additionalDiagnose;

	// % protected region % [Update the annotation for additionalDiagnoseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADDITIONAL_DIAGNOSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for additionalDiagnoseId here] end
	private UUID additionalDiagnoseId;

	// % protected region % [Update the annotation for Additional Procedure here] off begin
	@Schema(description = "The Additional Procedure entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Additional Procedure here] end
	private BpjsProcedureEntity additionalProcedure;

	// % protected region % [Update the annotation for additionalProcedureId here] off begin
	@Transient
	@CsvCustomBindByName(column = "ADDITIONAL_PROCEDURE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for additionalProcedureId here] end
	private UUID additionalProcedureId;

	// % protected region % [Update the annotation for Primary Diagnose here] off begin
	@Schema(description = "The Primary Diagnose entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Primary Diagnose here] end
	private BpjsDiagnoseEntity primaryDiagnose;

	// % protected region % [Update the annotation for primaryDiagnoseId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRIMARY_DIAGNOSE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for primaryDiagnoseId here] end
	private UUID primaryDiagnoseId;

	// % protected region % [Update the annotation for Primary Procedure here] off begin
	@Schema(description = "The Primary Procedure entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Primary Procedure here] end
	private BpjsProcedureEntity primaryProcedure;

	// % protected region % [Update the annotation for primaryProcedureId here] off begin
	@Transient
	@CsvCustomBindByName(column = "PRIMARY_PROCEDURE_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for primaryProcedureId here] end
	private UUID primaryProcedureId;

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
	 * Similar to {@link this#setAdditionalDiagnose(BpjsDiagnoseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set to this entity
	 */
	public void setAdditionalDiagnose(@NotNull BpjsDiagnoseEntity entity) {
		setAdditionalDiagnose(entity, true);
	}

	/**
	 * Set or update the additionalDiagnose in this entity with single BpjsDiagnoseEntity.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set or updated to additionalDiagnose
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdditionalDiagnose(@NotNull BpjsDiagnoseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdditionalDiagnose here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdditionalDiagnose here] end

		if (sameAsFormer(this.additionalDiagnose, entity)) {
			return;
		}

		if (this.additionalDiagnose != null) {
			this.additionalDiagnose.removeAdditionalDiagnose(this, false);
		}
		this.additionalDiagnose = entity;
		if (reverseAdd) {
			this.additionalDiagnose.addAdditionalDiagnose(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdditionalDiagnose incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdditionalDiagnose incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdditionalDiagnose(boolean)} but default to true.
	 */
	public void unsetAdditionalDiagnose() {
		this.unsetAdditionalDiagnose(true);
	}

	/**
	 * Remove Additional Diagnose in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdditionalDiagnose(boolean reverse) {
		if (reverse && this.additionalDiagnose != null) {
			this.additionalDiagnose.removeAdditionalDiagnose(this, false);
		}
		this.additionalDiagnose = null;
	}
	/**
	 * Similar to {@link this#setAdditionalProcedure(BpjsProcedureEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsProcedureEntity to be set to this entity
	 */
	public void setAdditionalProcedure(@NotNull BpjsProcedureEntity entity) {
		setAdditionalProcedure(entity, true);
	}

	/**
	 * Set or update the additionalProcedure in this entity with single BpjsProcedureEntity.
	 *
	 * @param entity the given BpjsProcedureEntity to be set or updated to additionalProcedure
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setAdditionalProcedure(@NotNull BpjsProcedureEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setAdditionalProcedure here] off begin
		// % protected region % [Add any additional logic here before the main logic for setAdditionalProcedure here] end

		if (sameAsFormer(this.additionalProcedure, entity)) {
			return;
		}

		if (this.additionalProcedure != null) {
			this.additionalProcedure.removeAdditionalProcedure(this, false);
		}
		this.additionalProcedure = entity;
		if (reverseAdd) {
			this.additionalProcedure.addAdditionalProcedure(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setAdditionalProcedure incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setAdditionalProcedure incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetAdditionalProcedure(boolean)} but default to true.
	 */
	public void unsetAdditionalProcedure() {
		this.unsetAdditionalProcedure(true);
	}

	/**
	 * Remove Additional Procedure in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetAdditionalProcedure(boolean reverse) {
		if (reverse && this.additionalProcedure != null) {
			this.additionalProcedure.removeAdditionalProcedure(this, false);
		}
		this.additionalProcedure = null;
	}
	/**
	 * Similar to {@link this#setPrimaryDiagnose(BpjsDiagnoseEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set to this entity
	 */
	public void setPrimaryDiagnose(@NotNull BpjsDiagnoseEntity entity) {
		setPrimaryDiagnose(entity, true);
	}

	/**
	 * Set or update the primaryDiagnose in this entity with single BpjsDiagnoseEntity.
	 *
	 * @param entity the given BpjsDiagnoseEntity to be set or updated to primaryDiagnose
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrimaryDiagnose(@NotNull BpjsDiagnoseEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPrimaryDiagnose here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPrimaryDiagnose here] end

		if (sameAsFormer(this.primaryDiagnose, entity)) {
			return;
		}

		if (this.primaryDiagnose != null) {
			this.primaryDiagnose.removePrimaryDiagnose(this, false);
		}
		this.primaryDiagnose = entity;
		if (reverseAdd) {
			this.primaryDiagnose.addPrimaryDiagnose(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPrimaryDiagnose incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPrimaryDiagnose incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPrimaryDiagnose(boolean)} but default to true.
	 */
	public void unsetPrimaryDiagnose() {
		this.unsetPrimaryDiagnose(true);
	}

	/**
	 * Remove Primary Diagnose in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPrimaryDiagnose(boolean reverse) {
		if (reverse && this.primaryDiagnose != null) {
			this.primaryDiagnose.removePrimaryDiagnose(this, false);
		}
		this.primaryDiagnose = null;
	}
	/**
	 * Similar to {@link this#setPrimaryProcedure(BpjsProcedureEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given BpjsProcedureEntity to be set to this entity
	 */
	public void setPrimaryProcedure(@NotNull BpjsProcedureEntity entity) {
		setPrimaryProcedure(entity, true);
	}

	/**
	 * Set or update the primaryProcedure in this entity with single BpjsProcedureEntity.
	 *
	 * @param entity the given BpjsProcedureEntity to be set or updated to primaryProcedure
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPrimaryProcedure(@NotNull BpjsProcedureEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPrimaryProcedure here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPrimaryProcedure here] end

		if (sameAsFormer(this.primaryProcedure, entity)) {
			return;
		}

		if (this.primaryProcedure != null) {
			this.primaryProcedure.removePrimaryProcedure(this, false);
		}
		this.primaryProcedure = entity;
		if (reverseAdd) {
			this.primaryProcedure.addPrimaryProcedure(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPrimaryProcedure incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPrimaryProcedure incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPrimaryProcedure(boolean)} but default to true.
	 */
	public void unsetPrimaryProcedure() {
		this.unsetPrimaryProcedure(true);
	}

	/**
	 * Remove Primary Procedure in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPrimaryProcedure(boolean reverse) {
		if (reverse && this.primaryProcedure != null) {
			this.primaryProcedure.removePrimaryProcedure(this, false);
		}
		this.primaryProcedure = null;
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
		return "REFERRAL_ID,REFERRAL_NO,BPJS_CARD_NO,NAME,PPK_DIAGNOSE,REFERRAL_START_DATE,REFERRAL_END_DATE,ADDITIONAL_DIAGNOSE_ID,ADDITIONAL_PROCEDURE_ID,PRIMARY_DIAGNOSE_ID,PRIMARY_PROCEDURE_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<BpjsDiagnoseEntity> additionalDiagnoseRelation = Optional.ofNullable(this.additionalDiagnose);
		additionalDiagnoseRelation.ifPresent(entity -> this.additionalDiagnoseId = entity.getId());

		Optional<BpjsProcedureEntity> additionalProcedureRelation = Optional.ofNullable(this.additionalProcedure);
		additionalProcedureRelation.ifPresent(entity -> this.additionalProcedureId = entity.getId());

		Optional<BpjsDiagnoseEntity> primaryDiagnoseRelation = Optional.ofNullable(this.primaryDiagnose);
		primaryDiagnoseRelation.ifPresent(entity -> this.primaryDiagnoseId = entity.getId());

		Optional<BpjsProcedureEntity> primaryProcedureRelation = Optional.ofNullable(this.primaryProcedure);
		primaryProcedureRelation.ifPresent(entity -> this.primaryProcedureId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsSpecialReferral) {
		if (this == bpjsSpecialReferral) {
			return true;
		}
		if (bpjsSpecialReferral == null || this.getClass() != bpjsSpecialReferral.getClass()) {
			return false;
		}
		if (!super.equals(bpjsSpecialReferral)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsSpecialReferralEntity that = (BpjsSpecialReferralEntity) bpjsSpecialReferral;
		return
			Objects.equals(this.referralID, that.referralID) &&
			Objects.equals(this.referralNo, that.referralNo) &&
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.name, that.name) &&
			Objects.equals(this.ppkDiagnose, that.ppkDiagnose) &&
			Objects.equals(this.referralStartDate, that.referralStartDate) &&
			Objects.equals(this.referralEndDate, that.referralEndDate) &&
			Objects.equals(this.additionalDiagnoseId, that.additionalDiagnoseId) &&
			Objects.equals(this.additionalProcedureId, that.additionalProcedureId) &&
			Objects.equals(this.primaryDiagnoseId, that.primaryDiagnoseId) &&
			Objects.equals(this.primaryProcedureId, that.primaryProcedureId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
