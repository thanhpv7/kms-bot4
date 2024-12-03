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
import kmsweb.dtos.SatuSehatConfigurationEntityDto;
import kmsweb.entities.listeners.SatuSehatConfigurationEntityListener;
import kmsweb.serializers.SatuSehatConfigurationSerializer;
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
@EntityListeners({SatuSehatConfigurationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = SatuSehatConfigurationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class SatuSehatConfigurationEntity extends AbstractEntity {

	/**
	 * Takes a SatuSehatConfigurationEntityDto and converts it into a SatuSehatConfigurationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param satuSehatConfigurationEntityDto
	 */
	public SatuSehatConfigurationEntity(SatuSehatConfigurationEntityDto satuSehatConfigurationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (satuSehatConfigurationEntityDto.getId() != null) {
			this.setId(satuSehatConfigurationEntityDto.getId());
		}

		if (satuSehatConfigurationEntityDto.getOrganizationID() != null) {
			this.setOrganizationID(satuSehatConfigurationEntityDto.getOrganizationID());
		}

		if (satuSehatConfigurationEntityDto.getClientID() != null) {
			this.setClientID(satuSehatConfigurationEntityDto.getClientID());
		}

		if (satuSehatConfigurationEntityDto.getSecretKey() != null) {
			this.setSecretKey(satuSehatConfigurationEntityDto.getSecretKey());
		}

		if (satuSehatConfigurationEntityDto.getTokenRequest() != null) {
			this.setTokenRequest(satuSehatConfigurationEntityDto.getTokenRequest());
		}

		if (satuSehatConfigurationEntityDto.getBaseURL() != null) {
			this.setBaseURL(satuSehatConfigurationEntityDto.getBaseURL());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Organization ID here] off begin
	@CsvBindByName(column = "ORGANIZATION_ID", required = false)
	@Nullable
	@Column(name = "organization_id")
	@Schema(description = "The Organization ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Organization ID here] end
	private String organizationID;

	// % protected region % [Modify attribute annotation for Client ID here] off begin
	@CsvBindByName(column = "CLIENT_ID", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 1000", max = 1000)
	@Column(name = "client_id")
	@Schema(description = "The Client ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Client ID here] end
	private String clientID;

	// % protected region % [Modify attribute annotation for Secret Key here] off begin
	@CsvBindByName(column = "SECRET_KEY", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 1000", max = 1000)
	@Column(name = "secret_key")
	@Schema(description = "The Secret Key of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Secret Key here] end
	private String secretKey;

	// % protected region % [Modify attribute annotation for Token Request here] off begin
	@CsvBindByName(column = "TOKEN_REQUEST", required = false)
	@Nullable
	@Length(message = "Length must be less than or equal to 1000", max = 1000)
	@Column(name = "token_request")
	@Schema(description = "The Token Request of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Token Request here] end
	private String tokenRequest;

	// % protected region % [Modify attribute annotation for Base URL here] off begin
	@CsvBindByName(column = "BASE_URL", required = false)
	@Nullable
	@Column(name = "base_url")
	@Schema(description = "The Base URL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Base URL here] end
	private String baseURL;

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
		return "ORGANIZATION_ID,CLIENT_ID,SECRET_KEY,TOKEN_REQUEST,BASE_URL,ID";
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
	public boolean equals(Object satuSehatConfiguration) {
		if (this == satuSehatConfiguration) {
			return true;
		}
		if (satuSehatConfiguration == null || this.getClass() != satuSehatConfiguration.getClass()) {
			return false;
		}
		if (!super.equals(satuSehatConfiguration)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		SatuSehatConfigurationEntity that = (SatuSehatConfigurationEntity) satuSehatConfiguration;
		return
			Objects.equals(this.organizationID, that.organizationID) &&
			Objects.equals(this.clientID, that.clientID) &&
			Objects.equals(this.secretKey, that.secretKey) &&
			Objects.equals(this.tokenRequest, that.tokenRequest) &&
			Objects.equals(this.baseURL, that.baseURL);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
