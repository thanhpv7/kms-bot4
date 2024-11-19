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
import kmsweb.dtos.BpjsGeneralEntityDto;
import kmsweb.entities.listeners.BpjsGeneralEntityListener;
import kmsweb.serializers.BpjsGeneralSerializer;
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
@EntityListeners({BpjsGeneralEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsGeneralSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"basic_auth_username"}, name = "basic_auth_username"),
		@UniqueConstraint(columnNames = {"basic_auth_password"}, name = "basic_auth_password"),
	}
)
public class BpjsGeneralEntity extends AbstractEntity {

	/**
	 * Takes a BpjsGeneralEntityDto and converts it into a BpjsGeneralEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsGeneralEntityDto
	 */
	public BpjsGeneralEntity(BpjsGeneralEntityDto bpjsGeneralEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsGeneralEntityDto.getId() != null) {
			this.setId(bpjsGeneralEntityDto.getId());
		}

		if (bpjsGeneralEntityDto.getConsID() != null) {
			this.setConsID(bpjsGeneralEntityDto.getConsID());
		}

		if (bpjsGeneralEntityDto.getSecretKey() != null) {
			this.setSecretKey(bpjsGeneralEntityDto.getSecretKey());
		}

		if (bpjsGeneralEntityDto.getBpjsWebServiceURL() != null) {
			this.setBpjsWebServiceURL(bpjsGeneralEntityDto.getBpjsWebServiceURL());
		}

		if (bpjsGeneralEntityDto.getAplicareWebServiceURL() != null) {
			this.setAplicareWebServiceURL(bpjsGeneralEntityDto.getAplicareWebServiceURL());
		}

		if (bpjsGeneralEntityDto.getHealthFacilityCode() != null) {
			this.setHealthFacilityCode(bpjsGeneralEntityDto.getHealthFacilityCode());
		}

		if (bpjsGeneralEntityDto.getHealthFacilityName() != null) {
			this.setHealthFacilityName(bpjsGeneralEntityDto.getHealthFacilityName());
		}

		if (bpjsGeneralEntityDto.getMjknWSBPJSURL() != null) {
			this.setMjknWSBPJSURL(bpjsGeneralEntityDto.getMjknWSBPJSURL());
		}

		if (bpjsGeneralEntityDto.getMjknWSBPJSUserKey() != null) {
			this.setMjknWSBPJSUserKey(bpjsGeneralEntityDto.getMjknWSBPJSUserKey());
		}

		if (bpjsGeneralEntityDto.getVclaimUserKey() != null) {
			this.setVclaimUserKey(bpjsGeneralEntityDto.getVclaimUserKey());
		}

		if (bpjsGeneralEntityDto.getConnectToOtherSystem() != null) {
			this.setConnectToOtherSystem(bpjsGeneralEntityDto.getConnectToOtherSystem());
		}

		if (bpjsGeneralEntityDto.getIsmobilejkn() != null) {
			this.setIsmobilejkn(bpjsGeneralEntityDto.getIsmobilejkn());
		}

		if (bpjsGeneralEntityDto.getExternalSystemURL() != null) {
			this.setExternalSystemURL(bpjsGeneralEntityDto.getExternalSystemURL());
		}

		if (bpjsGeneralEntityDto.getBasicAuth() != null) {
			this.setBasicAuth(bpjsGeneralEntityDto.getBasicAuth());
		}

		if (bpjsGeneralEntityDto.getBasicAuthUsername() != null) {
			this.setBasicAuthUsername(bpjsGeneralEntityDto.getBasicAuthUsername());
		}

		if (bpjsGeneralEntityDto.getBasicAuthPassword() != null) {
			this.setBasicAuthPassword(bpjsGeneralEntityDto.getBasicAuthPassword());
		}

		if (bpjsGeneralEntityDto.getBypassSSLValidation() != null) {
			this.setBypassSSLValidation(bpjsGeneralEntityDto.getBypassSSLValidation());
		}

		if (bpjsGeneralEntityDto.getClaimStatus() != null) {
			this.setClaimStatus(bpjsGeneralEntityDto.getClaimStatus());
		}

		if (bpjsGeneralEntityDto.getFacilityType() != null) {
			this.setFacilityType(bpjsGeneralEntityDto.getFacilityType());
		}

		if (bpjsGeneralEntityDto.getSendNonJKN() != null) {
			this.setSendNonJKN(bpjsGeneralEntityDto.getSendNonJKN());
		}

		if (bpjsGeneralEntityDto.getVclaimIntegration() != null) {
			this.setVclaimIntegration(bpjsGeneralEntityDto.getVclaimIntegration());
		}

		if (bpjsGeneralEntityDto.getExternalVclaimServiceURL() != null) {
			this.setExternalVclaimServiceURL(bpjsGeneralEntityDto.getExternalVclaimServiceURL());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Cons ID here] off begin
	@CsvBindByName(column = "CONS_ID", required = true)
	@NotNull(message = "Cons ID must not be empty")
	@Length(message = "Length must be greater than or equal to 4", min = 4)
	@Length(message = "Length must be less than or equal to 15", max = 15)
	@Column(name = "cons_id")
	@Schema(description = "The Cons ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Cons ID here] end
	private String consID;

	// % protected region % [Modify attribute annotation for Secret Key here] off begin
	@CsvBindByName(column = "SECRET_KEY", required = true)
	@NotNull(message = "Secret Key must not be empty")
	@Length(message = "Length must be less than or equal to 25", max = 25)
	@Column(name = "secret_key")
	@Schema(description = "The Secret Key of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Secret Key here] end
	private String secretKey;

	// % protected region % [Modify attribute annotation for BPJS Web Service URL here] off begin
	@CsvBindByName(column = "BPJS_WEB_SERVICE_URL", required = true)
	@NotNull(message = "BPJS Web Service URL must not be empty")
	@Column(name = "bpjs_web_service_url")
	@Schema(description = "The BPJS Web Service URL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for BPJS Web Service URL here] end
	private String bpjsWebServiceURL;

	// % protected region % [Modify attribute annotation for Aplicare Web Service URL here] off begin
	@CsvBindByName(column = "APLICARE_WEB_SERVICE_URL", required = true)
	@NotNull(message = "Aplicare Web Service URL must not be empty")
	@Column(name = "aplicare_web_service_url")
	@Schema(description = "The Aplicare Web Service URL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Aplicare Web Service URL here] end
	private String aplicareWebServiceURL;

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

	// % protected region % [Modify attribute annotation for MJKN WS BPJS URL here] off begin
	@CsvBindByName(column = "MJKN_WS_BPJS_URL", required = false)
	@Nullable
	@Column(name = "mjkn_ws_bpjs_url")
	@Schema(description = "The MJKN WS BPJS URL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for MJKN WS BPJS URL here] end
	private String mjknWSBPJSURL;

	// % protected region % [Modify attribute annotation for MJKN WS BPJS User Key here] off begin
	@CsvBindByName(column = "MJKN_WS_BPJS_USER_KEY", required = false)
	@Nullable
	@Column(name = "mjkn_ws_bpjs_user_key")
	@Schema(description = "The MJKN WS BPJS User Key of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for MJKN WS BPJS User Key here] end
	private String mjknWSBPJSUserKey;

	// % protected region % [Modify attribute annotation for Vclaim User Key here] off begin
	@CsvBindByName(column = "VCLAIM_USER_KEY", required = false)
	@Nullable
	@Column(name = "vclaim_user_key")
	@Schema(description = "The Vclaim User Key of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Vclaim User Key here] end
	private String vclaimUserKey;

	// % protected region % [Modify attribute annotation for Connect To Other System here] off begin
	@CsvBindByName(column = "CONNECT_TO_OTHER_SYSTEM", required = false)
	@Nullable
	@Column(name = "connect_to_other_system")
	@Schema(description = "The Connect To Other System of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Connect To Other System here] end
	private Boolean connectToOtherSystem = false ;

	// % protected region % [Modify attribute annotation for IsMobileJKN here] off begin
	@CsvBindByName(column = "ISMOBILEJKN", required = false)
	@Nullable
	@Column(name = "ismobilejkn")
	@Schema(description = "The IsMobileJKN of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for IsMobileJKN here] end
	private Boolean ismobilejkn = false ;

	// % protected region % [Modify attribute annotation for External System URL here] off begin
	@CsvBindByName(column = "EXTERNAL_SYSTEM_URL", required = false)
	@Nullable
	@Column(name = "external_system_url")
	@Schema(description = "The External System URL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for External System URL here] end
	private String externalSystemURL;

	// % protected region % [Modify attribute annotation for Basic Auth here] off begin
	@CsvBindByName(column = "BASIC_AUTH", required = false)
	@Nullable
	@Column(name = "basic_auth")
	@Schema(description = "The Basic Auth of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Basic Auth here] end
	private Boolean basicAuth = false ;

	// % protected region % [Modify attribute annotation for Basic Auth Username here] off begin
	@CsvBindByName(column = "BASIC_AUTH_USERNAME", required = false)
	@Nullable
	@Column(name = "basic_auth_username")
	@Schema(description = "The Basic Auth Username of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Basic Auth Username here] end
	private String basicAuthUsername;

	// % protected region % [Modify attribute annotation for Basic Auth Password here] off begin
	@CsvBindByName(column = "BASIC_AUTH_PASSWORD", required = false)
	@Nullable
	@Column(name = "basic_auth_password")
	@Schema(description = "The Basic Auth Password of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Basic Auth Password here] end
	private String basicAuthPassword;

	// % protected region % [Modify attribute annotation for Bypass SSL Validation here] off begin
	@CsvBindByName(column = "BYPASS_SSL_VALIDATION", required = false)
	@Nullable
	@Column(name = "bypass_ssl_validation")
	@Schema(description = "The Bypass SSL Validation of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Bypass SSL Validation here] end
	private Boolean bypassSSLValidation = false ;

	// % protected region % [Modify attribute annotation for Claim Status here] off begin
	@CsvBindByName(column = "CLAIM_STATUS", required = false)
	@Nullable
	@Column(name = "claim_status")
	@Schema(description = "The Claim Status of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Claim Status here] end
	private Boolean claimStatus = false ;

	// % protected region % [Modify attribute annotation for Facility Type here] off begin
	@CsvBindByName(column = "FACILITY_TYPE", required = false)
	@Nullable
	@Column(name = "facility_type")
	@Schema(description = "The Facility Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Facility Type here] end
	private String facilityType;

	// % protected region % [Modify attribute annotation for Send Non JKN here] off begin
	@CsvBindByName(column = "SEND_NON_JKN", required = false)
	@Nullable
	@Column(name = "send_non_jkn")
	@Schema(description = "The Send Non JKN of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Send Non JKN here] end
	private Boolean sendNonJKN = false ;

	// % protected region % [Modify attribute annotation for Vclaim Integration here] off begin
	@CsvBindByName(column = "VCLAIM_INTEGRATION", required = false)
	@Nullable
	@Column(name = "vclaim_integration")
	@Schema(description = "The Vclaim Integration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Vclaim Integration here] end
	private Boolean vclaimIntegration = false ;

	// % protected region % [Modify attribute annotation for External Vclaim Service URL here] off begin
	@CsvBindByName(column = "EXTERNAL_VCLAIM_SERVICE_URL", required = false)
	@Nullable
	@Column(name = "external_vclaim_service_url")
	@Schema(description = "The External Vclaim Service URL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for External Vclaim Service URL here] end
	private String externalVclaimServiceURL;

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
		return "CONS_ID,SECRET_KEY,BPJS_WEB_SERVICE_URL,APLICARE_WEB_SERVICE_URL,HEALTH_FACILITY_CODE,HEALTH_FACILITY_NAME,MJKN_WS_BPJS_URL,MJKN_WS_BPJS_USER_KEY,VCLAIM_USER_KEY,CONNECT_TO_OTHER_SYSTEM,ISMOBILEJKN,EXTERNAL_SYSTEM_URL,BASIC_AUTH,BASIC_AUTH_USERNAME,BASIC_AUTH_PASSWORD,BYPASS_SSL_VALIDATION,CLAIM_STATUS,FACILITY_TYPE,SEND_NON_JKN,VCLAIM_INTEGRATION,EXTERNAL_VCLAIM_SERVICE_URL,ID";
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
	public boolean equals(Object bpjsGeneral) {
		if (this == bpjsGeneral) {
			return true;
		}
		if (bpjsGeneral == null || this.getClass() != bpjsGeneral.getClass()) {
			return false;
		}
		if (!super.equals(bpjsGeneral)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsGeneralEntity that = (BpjsGeneralEntity) bpjsGeneral;
		return
			Objects.equals(this.consID, that.consID) &&
			Objects.equals(this.secretKey, that.secretKey) &&
			Objects.equals(this.bpjsWebServiceURL, that.bpjsWebServiceURL) &&
			Objects.equals(this.aplicareWebServiceURL, that.aplicareWebServiceURL) &&
			Objects.equals(this.healthFacilityCode, that.healthFacilityCode) &&
			Objects.equals(this.healthFacilityName, that.healthFacilityName) &&
			Objects.equals(this.mjknWSBPJSURL, that.mjknWSBPJSURL) &&
			Objects.equals(this.mjknWSBPJSUserKey, that.mjknWSBPJSUserKey) &&
			Objects.equals(this.vclaimUserKey, that.vclaimUserKey) &&
			Objects.equals(this.connectToOtherSystem, that.connectToOtherSystem) &&
			Objects.equals(this.ismobilejkn, that.ismobilejkn) &&
			Objects.equals(this.externalSystemURL, that.externalSystemURL) &&
			Objects.equals(this.basicAuth, that.basicAuth) &&
			Objects.equals(this.basicAuthUsername, that.basicAuthUsername) &&
			Objects.equals(this.basicAuthPassword, that.basicAuthPassword) &&
			Objects.equals(this.bypassSSLValidation, that.bypassSSLValidation) &&
			Objects.equals(this.claimStatus, that.claimStatus) &&
			Objects.equals(this.facilityType, that.facilityType) &&
			Objects.equals(this.sendNonJKN, that.sendNonJKN) &&
			Objects.equals(this.vclaimIntegration, that.vclaimIntegration) &&
			Objects.equals(this.externalVclaimServiceURL, that.externalVclaimServiceURL);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
