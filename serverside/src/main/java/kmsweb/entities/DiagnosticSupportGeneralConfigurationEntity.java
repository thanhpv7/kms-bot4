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
import kmsweb.dtos.DiagnosticSupportGeneralConfigurationEntityDto;
import kmsweb.entities.listeners.DiagnosticSupportGeneralConfigurationEntityListener;
import kmsweb.serializers.DiagnosticSupportGeneralConfigurationSerializer;
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
@EntityListeners({DiagnosticSupportGeneralConfigurationEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = DiagnosticSupportGeneralConfigurationSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class DiagnosticSupportGeneralConfigurationEntity extends AbstractEntity {

	/**
	 * Takes a DiagnosticSupportGeneralConfigurationEntityDto and converts it into a DiagnosticSupportGeneralConfigurationEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param diagnosticSupportGeneralConfigurationEntityDto
	 */
	public DiagnosticSupportGeneralConfigurationEntity(DiagnosticSupportGeneralConfigurationEntityDto diagnosticSupportGeneralConfigurationEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (diagnosticSupportGeneralConfigurationEntityDto.getId() != null) {
			this.setId(diagnosticSupportGeneralConfigurationEntityDto.getId());
		}

		if (diagnosticSupportGeneralConfigurationEntityDto.getIsActiveLIS() != null) {
			this.setIsActiveLIS(diagnosticSupportGeneralConfigurationEntityDto.getIsActiveLIS());
		}

		if (diagnosticSupportGeneralConfigurationEntityDto.getIsLISRegistration() != null) {
			this.setIsLISRegistration(diagnosticSupportGeneralConfigurationEntityDto.getIsLISRegistration());
		}

		if (diagnosticSupportGeneralConfigurationEntityDto.getLisWebServiceURL() != null) {
			this.setLisWebServiceURL(diagnosticSupportGeneralConfigurationEntityDto.getLisWebServiceURL());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Is Active LIS here] off begin
	@CsvBindByName(column = "IS_ACTIVE_LIS", required = false)
	@Nullable
	@Column(name = "is_active_lis")
	@Schema(description = "The Is Active LIS of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is Active LIS here] end
	private Boolean isActiveLIS = false ;

	// % protected region % [Modify attribute annotation for Is LIS Registration here] off begin
	@CsvBindByName(column = "IS_LIS_REGISTRATION", required = false)
	@Nullable
	@Column(name = "is_lis_registration")
	@Schema(description = "The Is LIS Registration of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Is LIS Registration here] end
	private Boolean isLISRegistration = false ;

	// % protected region % [Modify attribute annotation for LIS Web Service URL here] off begin
	@CsvBindByName(column = "LIS_WEB_SERVICE_URL", required = false)
	@Nullable
	@Pattern(message = "Must match a valid url",
			regexp = ValidatorPatterns.url)
	@Column(name = "lis_web_service_url")
	@Schema(description = "The LIS Web Service URL of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for LIS Web Service URL here] end
	private String lisWebServiceURL;

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
		return "IS_ACTIVE_LIS,IS_LIS_REGISTRATION,LIS_WEB_SERVICE_URL,ID";
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
	public boolean equals(Object diagnosticSupportGeneralConfiguration) {
		if (this == diagnosticSupportGeneralConfiguration) {
			return true;
		}
		if (diagnosticSupportGeneralConfiguration == null || this.getClass() != diagnosticSupportGeneralConfiguration.getClass()) {
			return false;
		}
		if (!super.equals(diagnosticSupportGeneralConfiguration)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		DiagnosticSupportGeneralConfigurationEntity that = (DiagnosticSupportGeneralConfigurationEntity) diagnosticSupportGeneralConfiguration;
		return
			Objects.equals(this.isActiveLIS, that.isActiveLIS) &&
			Objects.equals(this.isLISRegistration, that.isLISRegistration) &&
			Objects.equals(this.lisWebServiceURL, that.lisWebServiceURL);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
