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
import kmsweb.dtos.PharmacySetupEntityDto;
import kmsweb.entities.listeners.PharmacySetupEntityListener;
import kmsweb.serializers.PharmacySetupSerializer;
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
@EntityListeners({PharmacySetupEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = PharmacySetupSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class PharmacySetupEntity extends AbstractEntity {

	/**
	 * Takes a PharmacySetupEntityDto and converts it into a PharmacySetupEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param pharmacySetupEntityDto
	 */
	public PharmacySetupEntity(PharmacySetupEntityDto pharmacySetupEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (pharmacySetupEntityDto.getId() != null) {
			this.setId(pharmacySetupEntityDto.getId());
		}

		if (pharmacySetupEntityDto.getHospitalPharmacy() != null) {
			this.setHospitalPharmacy(pharmacySetupEntityDto.getHospitalPharmacy());
		}

		if (pharmacySetupEntityDto.getHeadOfPharmacy() != null) {
			this.setHeadOfPharmacy(pharmacySetupEntityDto.getHeadOfPharmacy());
		}

		if (pharmacySetupEntityDto.getPharmacistLicenseNo() != null) {
			this.setPharmacistLicenseNo(pharmacySetupEntityDto.getPharmacistLicenseNo());
		}

		if (pharmacySetupEntityDto.getLabelSetup() != null) {
			this.setLabelSetup(pharmacySetupEntityDto.getLabelSetup());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Hospital Pharmacy here] off begin
	@CsvBindByName(column = "HOSPITAL_PHARMACY", required = false)
	@Nullable
	@Column(name = "hospital_pharmacy")
	@Schema(description = "The Hospital Pharmacy of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Hospital Pharmacy here] end
	private String hospitalPharmacy;

	// % protected region % [Modify attribute annotation for Head of Pharmacy here] off begin
	@CsvBindByName(column = "HEAD_OF_PHARMACY", required = false)
	@Nullable
	@Column(name = "head_of_pharmacy")
	@Schema(description = "The Head of Pharmacy of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Head of Pharmacy here] end
	private String headOfPharmacy;

	// % protected region % [Modify attribute annotation for Pharmacist License No here] off begin
	@CsvBindByName(column = "PHARMACIST_LICENSE_NO", required = false)
	@Nullable
	@Column(name = "pharmacist_license_no")
	@Schema(description = "The Pharmacist License No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Pharmacist License No here] end
	private String pharmacistLicenseNo;

	// % protected region % [Modify attribute annotation for Label setup here] off begin
	@CsvBindByName(column = "LABEL_SETUP", required = false)
	@Nullable
	@Column(name = "label_setup")
	@Schema(description = "The Label setup of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Label setup here] end
	private String labelSetup;

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
		return "HOSPITAL_PHARMACY,HEAD_OF_PHARMACY,PHARMACIST_LICENSE_NO,LABEL_SETUP,ID";
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
	public boolean equals(Object pharmacySetup) {
		if (this == pharmacySetup) {
			return true;
		}
		if (pharmacySetup == null || this.getClass() != pharmacySetup.getClass()) {
			return false;
		}
		if (!super.equals(pharmacySetup)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		PharmacySetupEntity that = (PharmacySetupEntity) pharmacySetup;
		return
			Objects.equals(this.hospitalPharmacy, that.hospitalPharmacy) &&
			Objects.equals(this.headOfPharmacy, that.headOfPharmacy) &&
			Objects.equals(this.pharmacistLicenseNo, that.pharmacistLicenseNo) &&
			Objects.equals(this.labelSetup, that.labelSetup);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
