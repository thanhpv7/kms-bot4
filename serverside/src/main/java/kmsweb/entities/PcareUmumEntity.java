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
import kmsweb.dtos.PcareUmumEntityDto;
import kmsweb.entities.listeners.PcareUmumEntityListener;
import kmsweb.serializers.PcareUmumSerializer;
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
@EntityListeners({PcareUmumEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PcareUmumSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PcareUmumEntity extends AbstractEntity {

	/**
	 * Takes a PcareUmumEntityDto and converts it into a PcareUmumEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pcareUmumEntityDto
	 */
	public PcareUmumEntity(PcareUmumEntityDto pcareUmumEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pcareUmumEntityDto.getId() != null) {
			this.setId(pcareUmumEntityDto.getId());
		}

		if (pcareUmumEntityDto.getConsID() != null) {
			this.setConsID(pcareUmumEntityDto.getConsID());
		}

		if (pcareUmumEntityDto.getSecretKey() != null) {
			this.setSecretKey(pcareUmumEntityDto.getSecretKey());
		}

		if (pcareUmumEntityDto.getWebServiceURL() != null) {
			this.setWebServiceURL(pcareUmumEntityDto.getWebServiceURL());
		}

		if (pcareUmumEntityDto.getAuthUsername() != null) {
			this.setAuthUsername(pcareUmumEntityDto.getAuthUsername());
		}

		if (pcareUmumEntityDto.getAuthPassword() != null) {
			this.setAuthPassword(pcareUmumEntityDto.getAuthPassword());
		}

		if (pcareUmumEntityDto.getKodeAplikasi() != null) {
			this.setKodeAplikasi(pcareUmumEntityDto.getKodeAplikasi());
		}

		if (pcareUmumEntityDto.getUserKey() != null) {
			this.setUserKey(pcareUmumEntityDto.getUserKey());
		}

		if (pcareUmumEntityDto.getRegionalDivision() != null) {
			this.setRegionalDivision(pcareUmumEntityDto.getRegionalDivision());
		}

		if (pcareUmumEntityDto.getBranchOffice() != null) {
			this.setBranchOffice(pcareUmumEntityDto.getBranchOffice());
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

	// % protected region % [Modify attribute annotation for Web Service URL here] off begin
	@CsvBindByName(column = "WEB_SERVICE_URL", required = true)
	@NotNull(message = "Web Service URL must not be empty")
	@Column(name = "web_service_url")
	@Schema(description = "The Web Service URL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Web Service URL here] end
	private String webServiceURL;

	// % protected region % [Modify attribute annotation for Auth Username here] off begin
	@CsvBindByName(column = "AUTH_USERNAME", required = true)
	@NotNull(message = "Auth Username must not be empty")
	@Column(name = "auth_username")
	@Schema(description = "The Auth Username of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Auth Username here] end
	private String authUsername;

	// % protected region % [Modify attribute annotation for Auth Password here] off begin
	@CsvBindByName(column = "AUTH_PASSWORD", required = true)
	@NotNull(message = "Auth Password must not be empty")
	@Column(name = "auth_password")
	@Schema(description = "The Auth Password of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Auth Password here] end
	private String authPassword;

	// % protected region % [Modify attribute annotation for Kode Aplikasi here] off begin
	@CsvBindByName(column = "KODE_APLIKASI", required = true)
	@NotNull(message = "Kode Aplikasi must not be empty")
	@Column(name = "kode_aplikasi")
	@Schema(description = "The Kode Aplikasi of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Kode Aplikasi here] end
	private String kodeAplikasi;

	// % protected region % [Modify attribute annotation for User Key here] off begin
	@CsvBindByName(column = "USER_KEY", required = false)
	@Nullable
	@Column(name = "user_key")
	@Schema(description = "The User Key of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for User Key here] end
	private String userKey;

	// % protected region % [Modify attribute annotation for Regional Division here] off begin
	@CsvBindByName(column = "REGIONAL_DIVISION", required = false)
	@Nullable
	@Column(name = "regional_division")
	@Schema(description = "The Regional Division of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Regional Division here] end
	private String regionalDivision;

	// % protected region % [Modify attribute annotation for Branch Office here] off begin
	@CsvBindByName(column = "BRANCH_OFFICE", required = false)
	@Nullable
	@Column(name = "branch_office")
	@Schema(description = "The Branch Office of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Branch Office here] end
	private String branchOffice;

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
		return "CONS_ID,SECRET_KEY,WEB_SERVICE_URL,AUTH_USERNAME,AUTH_PASSWORD,KODE_APLIKASI,USER_KEY,REGIONAL_DIVISION,BRANCH_OFFICE,ID";
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
	public boolean equals(Object pcareUmum) {
		if (this == pcareUmum) {
			return true;
		}
		if (pcareUmum == null || this.getClass() != pcareUmum.getClass()) {
			return false;
		}
		if (!super.equals(pcareUmum)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PcareUmumEntity that = (PcareUmumEntity) pcareUmum;
		return
			Objects.equals(this.consID, that.consID) &&
			Objects.equals(this.secretKey, that.secretKey) &&
			Objects.equals(this.webServiceURL, that.webServiceURL) &&
			Objects.equals(this.authUsername, that.authUsername) &&
			Objects.equals(this.authPassword, that.authPassword) &&
			Objects.equals(this.kodeAplikasi, that.kodeAplikasi) &&
			Objects.equals(this.userKey, that.userKey) &&
			Objects.equals(this.regionalDivision, that.regionalDivision) &&
			Objects.equals(this.branchOffice, that.branchOffice);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
