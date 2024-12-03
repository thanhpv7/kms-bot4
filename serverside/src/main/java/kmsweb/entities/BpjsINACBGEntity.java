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
import kmsweb.dtos.BpjsINACBGEntityDto;
import kmsweb.entities.listeners.BpjsINACBGEntityListener;
import kmsweb.serializers.BpjsINACBGSerializer;
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
@EntityListeners({BpjsINACBGEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsINACBGSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsINACBGEntity extends AbstractEntity {

	/**
	 * Takes a BpjsINACBGEntityDto and converts it into a BpjsINACBGEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsINACBGEntityDto
	 */
	public BpjsINACBGEntity(BpjsINACBGEntityDto bpjsINACBGEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsINACBGEntityDto.getId() != null) {
			this.setId(bpjsINACBGEntityDto.getId());
		}

		if (bpjsINACBGEntityDto.getHealthFacilityCode() != null) {
			this.setHealthFacilityCode(bpjsINACBGEntityDto.getHealthFacilityCode());
		}

		if (bpjsINACBGEntityDto.getHealthFacilityName() != null) {
			this.setHealthFacilityName(bpjsINACBGEntityDto.getHealthFacilityName());
		}

		if (bpjsINACBGEntityDto.getAddress() != null) {
			this.setAddress(bpjsINACBGEntityDto.getAddress());
		}

		if (bpjsINACBGEntityDto.getStateProvince() != null) {
			this.setStateProvince(bpjsINACBGEntityDto.getStateProvince());
		}

		if (bpjsINACBGEntityDto.getCityRegency() != null) {
			this.setCityRegency(bpjsINACBGEntityDto.getCityRegency());
		}

		if (bpjsINACBGEntityDto.getRegional() != null) {
			this.setRegional(bpjsINACBGEntityDto.getRegional());
		}

		if (bpjsINACBGEntityDto.getHospitalClass() != null) {
			this.setHospitalClass(bpjsINACBGEntityDto.getHospitalClass());
		}

		if (bpjsINACBGEntityDto.getInacbgTariff1() != null) {
			this.setInacbgTariff1(bpjsINACBGEntityDto.getInacbgTariff1());
		}

		if (bpjsINACBGEntityDto.getInacbgTariff2() != null) {
			this.setInacbgTariff2(bpjsINACBGEntityDto.getInacbgTariff2());
		}

		if (bpjsINACBGEntityDto.getAdditionalUpgradeVIP() != null) {
			this.setAdditionalUpgradeVIP(bpjsINACBGEntityDto.getAdditionalUpgradeVIP());
		}

		if (bpjsINACBGEntityDto.getPayplanID() != null) {
			this.setPayplanID(bpjsINACBGEntityDto.getPayplanID());
		}

		if (bpjsINACBGEntityDto.getPaymentPlanCode() != null) {
			this.setPaymentPlanCode(bpjsINACBGEntityDto.getPaymentPlanCode());
		}

		if (bpjsINACBGEntityDto.getTariffCode() != null) {
			this.setTariffCode(bpjsINACBGEntityDto.getTariffCode());
		}

		if (bpjsINACBGEntityDto.getUrl() != null) {
			this.setUrl(bpjsINACBGEntityDto.getUrl());
		}

		if (bpjsINACBGEntityDto.getUsername() != null) {
			this.setUsername(bpjsINACBGEntityDto.getUsername());
		}

		if (bpjsINACBGEntityDto.getPassword() != null) {
			this.setPassword(bpjsINACBGEntityDto.getPassword());
		}

		if (bpjsINACBGEntityDto.getSecretKey() != null) {
			this.setSecretKey(bpjsINACBGEntityDto.getSecretKey());
		}

		if (bpjsINACBGEntityDto.getCoderID() != null) {
			this.setCoderID(bpjsINACBGEntityDto.getCoderID());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Health Facility Code here] off begin
	@CsvBindByName(column = "HEALTH_FACILITY_CODE", required = true)
	@NotNull(message = "Health Facility Code must not be empty")
	@Length(message = "Length must be less than or equal to 25", max = 25)
	@Column(name = "health_facility_code")
	@Schema(description = "The Health Facility Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Health Facility Code here] end
	private String healthFacilityCode;

	// % protected region % [Modify attribute annotation for Health Facility Name here] off begin
	@CsvBindByName(column = "HEALTH_FACILITY_NAME", required = true)
	@NotNull(message = "Health Facility Name must not be empty")
	@Length(message = "Length must be less than or equal to 100", max = 100)
	@Column(name = "health_facility_name")
	@Schema(description = "The Health Facility Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Health Facility Name here] end
	private String healthFacilityName;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@CsvBindByName(column = "ADDRESS", required = true)
	@NotNull(message = "Address must not be empty")
	@Column(name = "address")
	@Schema(description = "The Address of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for State Province here] off begin
	@CsvBindByName(column = "STATE_PROVINCE", required = true)
	@NotNull(message = "State Province must not be empty")
	@Length(message = "Length must be less than or equal to 50", max = 50)
	@Column(name = "state_province")
	@Schema(description = "The State Province of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for State Province here] end
	private String stateProvince;

	// % protected region % [Modify attribute annotation for City Regency here] off begin
	@CsvBindByName(column = "CITY_REGENCY", required = true)
	@NotNull(message = "City Regency must not be empty")
	@Length(message = "Length must be less than or equal to 50", max = 50)
	@Column(name = "city_regency")
	@Schema(description = "The City Regency of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for City Regency here] end
	private String cityRegency;

	// % protected region % [Modify attribute annotation for Regional here] off begin
	@CsvBindByName(column = "REGIONAL", required = true)
	@NotNull(message = "Regional must not be empty")
	@Length(message = "Length must be less than or equal to 50", max = 50)
	@Column(name = "regional")
	@Schema(description = "The Regional of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Regional here] end
	private String regional;

	// % protected region % [Modify attribute annotation for Hospital Class here] off begin
	@CsvBindByName(column = "HOSPITAL_CLASS", required = true)
	@NotNull(message = "Hospital Class must not be empty")
	@Length(message = "Length must be less than or equal to 25", max = 25)
	@Column(name = "hospital_class")
	@Schema(description = "The Hospital Class of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Class here] end
	private String hospitalClass;

	// % protected region % [Modify attribute annotation for INACBG Tariff 1 here] off begin
	@CsvBindByName(column = "INACBG_TARIFF_1", required = true)
	@NotNull(message = "INACBG Tariff 1 must not be empty")
	@Length(message = "Length must be less than or equal to 100", max = 100)
	@Column(name = "inacbg_tariff_1")
	@Schema(description = "The INACBG Tariff 1 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for INACBG Tariff 1 here] end
	private String inacbgTariff1;

	// % protected region % [Modify attribute annotation for INACBG Tariff 2 here] off begin
	@CsvBindByName(column = "INACBG_TARIFF_2", required = true)
	@NotNull(message = "INACBG Tariff 2 must not be empty")
	@Length(message = "Length must be less than or equal to 100", max = 100)
	@Column(name = "inacbg_tariff_2")
	@Schema(description = "The INACBG Tariff 2 of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for INACBG Tariff 2 here] end
	private String inacbgTariff2;

	// % protected region % [Modify attribute annotation for Additional Upgrade VIP here] off begin
	@CsvBindByName(column = "ADDITIONAL_UPGRADE_VIP", required = true)
	@NotNull(message = "Additional Upgrade VIP must not be empty")
	@Length(message = "Length must be less than or equal to 100", max = 100)
	@Column(name = "additional_upgrade_vip")
	@Schema(description = "The Additional Upgrade VIP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Additional Upgrade VIP here] end
	private String additionalUpgradeVIP;

	// % protected region % [Modify attribute annotation for Payplan ID here] off begin
	@CsvBindByName(column = "PAYPLAN_ID", required = true)
	@NotNull(message = "Payplan ID must not be empty")
	@Length(message = "Length must be less than or equal to 100", max = 100)
	@Column(name = "payplan_id")
	@Schema(description = "The Payplan ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Payplan ID here] end
	private String payplanID;

	// % protected region % [Modify attribute annotation for Payment Plan Code here] off begin
	@CsvBindByName(column = "PAYMENT_PLAN_CODE", required = true)
	@NotNull(message = "Payment Plan Code must not be empty")
	@Length(message = "Length must be less than or equal to 100", max = 100)
	@Column(name = "payment_plan_code")
	@Schema(description = "The Payment Plan Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Payment Plan Code here] end
	private String paymentPlanCode;

	// % protected region % [Modify attribute annotation for Tariff Code here] off begin
	@CsvBindByName(column = "TARIFF_CODE", required = true)
	@NotNull(message = "Tariff Code must not be empty")
	@Length(message = "Length must be less than or equal to 50", max = 50)
	@Column(name = "tariff_code")
	@Schema(description = "The Tariff Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tariff Code here] end
	private String tariffCode;

	// % protected region % [Modify attribute annotation for URL here] off begin
	@CsvBindByName(column = "URL", required = true)
	@NotNull(message = "URL must not be empty")
	@Column(name = "url")
	@Schema(description = "The URL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for URL here] end
	private String url;

	// % protected region % [Modify attribute annotation for Username here] off begin
	@CsvBindByName(column = "USERNAME", required = true)
	@NotNull(message = "Username must not be empty")
	@Length(message = "Length must be less than or equal to 100", max = 100)
	@Column(name = "username")
	@Schema(description = "The Username of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Username here] end
	private String username;

	// % protected region % [Modify attribute annotation for Password here] off begin
	@CsvBindByName(column = "PASSWORD", required = true)
	@NotNull(message = "Password must not be empty")
	@Length(message = "Length must be less than or equal to 100", max = 100)
	@Column(name = "password")
	@Schema(description = "The Password of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Password here] end
	private String password;

	// % protected region % [Modify attribute annotation for Secret Key here] off begin
	@CsvBindByName(column = "SECRET_KEY", required = true)
	@NotNull(message = "Secret Key must not be empty")
	@Length(message = "Length must be less than or equal to 225", max = 225)
	@Column(name = "secret_key")
	@Schema(description = "The Secret Key of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Secret Key here] end
	private String secretKey;

	// % protected region % [Modify attribute annotation for Coder ID here] off begin
	@CsvBindByName(column = "CODER_ID", required = true)
	@NotNull(message = "Coder ID must not be empty")
	@Length(message = "Length must be less than or equal to 100", max = 100)
	@Column(name = "coder_id")
	@Schema(description = "The Coder ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Coder ID here] end
	private String coderID;

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
	 * The CSV annotations used to generate and import CSV files require headers on the abstract entity attributes
	 * (id, created, modified, created by, modified by).  These should not be present in imports, as this information is
	 * added by the server when saving entities.  Therefore a string containing the example csv headers is required
	 *
	 * @return the headers recommended in the CSV import file in CSV format
	 */
	public static String getExampleCsvHeader() {

		// % protected region % [Modify the headers in the CSV file here] off begin
		return "HEALTH_FACILITY_CODE,HEALTH_FACILITY_NAME,ADDRESS,STATE_PROVINCE,CITY_REGENCY,REGIONAL,HOSPITAL_CLASS,INACBG_TARIFF_1,INACBG_TARIFF_2,ADDITIONAL_UPGRADE_VIP,PAYPLAN_ID,PAYMENT_PLAN_CODE,TARIFF_CODE,URL,USERNAME,PASSWORD,SECRET_KEY,CODER_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object bpjsINACBG) {
		if (this == bpjsINACBG) {
			return true;
		}
		if (bpjsINACBG == null || this.getClass() != bpjsINACBG.getClass()) {
			return false;
		}
		if (!super.equals(bpjsINACBG)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsINACBGEntity that = (BpjsINACBGEntity) bpjsINACBG;
		return
			Objects.equals(this.healthFacilityCode, that.healthFacilityCode) &&
			Objects.equals(this.healthFacilityName, that.healthFacilityName) &&
			Objects.equals(this.address, that.address) &&
			Objects.equals(this.stateProvince, that.stateProvince) &&
			Objects.equals(this.cityRegency, that.cityRegency) &&
			Objects.equals(this.regional, that.regional) &&
			Objects.equals(this.hospitalClass, that.hospitalClass) &&
			Objects.equals(this.inacbgTariff1, that.inacbgTariff1) &&
			Objects.equals(this.inacbgTariff2, that.inacbgTariff2) &&
			Objects.equals(this.additionalUpgradeVIP, that.additionalUpgradeVIP) &&
			Objects.equals(this.payplanID, that.payplanID) &&
			Objects.equals(this.paymentPlanCode, that.paymentPlanCode) &&
			Objects.equals(this.tariffCode, that.tariffCode) &&
			Objects.equals(this.url, that.url) &&
			Objects.equals(this.username, that.username) &&
			Objects.equals(this.password, that.password) &&
			Objects.equals(this.secretKey, that.secretKey) &&
			Objects.equals(this.coderID, that.coderID);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
