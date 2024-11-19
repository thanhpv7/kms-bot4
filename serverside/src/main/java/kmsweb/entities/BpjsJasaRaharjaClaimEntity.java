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
import kmsweb.dtos.BpjsJasaRaharjaClaimEntityDto;
import kmsweb.entities.listeners.BpjsJasaRaharjaClaimEntityListener;
import kmsweb.serializers.BpjsJasaRaharjaClaimSerializer;
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
@EntityListeners({BpjsJasaRaharjaClaimEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsJasaRaharjaClaimSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsJasaRaharjaClaimEntity extends AbstractEntity {

	/**
	 * Takes a BpjsJasaRaharjaClaimEntityDto and converts it into a BpjsJasaRaharjaClaimEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsJasaRaharjaClaimEntityDto
	 */
	public BpjsJasaRaharjaClaimEntity(BpjsJasaRaharjaClaimEntityDto bpjsJasaRaharjaClaimEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsJasaRaharjaClaimEntityDto.getId() != null) {
			this.setId(bpjsJasaRaharjaClaimEntityDto.getId());
		}

		if (bpjsJasaRaharjaClaimEntityDto.getNoSEP() != null) {
			this.setNoSEP(bpjsJasaRaharjaClaimEntityDto.getNoSEP());
		}

		if (bpjsJasaRaharjaClaimEntityDto.getSepDate() != null) {
			this.setSepDate(bpjsJasaRaharjaClaimEntityDto.getSepDate());
		}

		if (bpjsJasaRaharjaClaimEntityDto.getDismissalDate() != null) {
			this.setDismissalDate(bpjsJasaRaharjaClaimEntityDto.getDismissalDate());
		}

		if (bpjsJasaRaharjaClaimEntityDto.getPatientID() != null) {
			this.setPatientID(bpjsJasaRaharjaClaimEntityDto.getPatientID());
		}

		if (bpjsJasaRaharjaClaimEntityDto.getTreatmentType() != null) {
			this.setTreatmentType(bpjsJasaRaharjaClaimEntityDto.getTreatmentType());
		}

		if (bpjsJasaRaharjaClaimEntityDto.getPolyclinic() != null) {
			this.setPolyclinic(bpjsJasaRaharjaClaimEntityDto.getPolyclinic());
		}

		if (bpjsJasaRaharjaClaimEntityDto.getBpjsCardNo() != null) {
			this.setBpjsCardNo(bpjsJasaRaharjaClaimEntityDto.getBpjsCardNo());
		}

		if (bpjsJasaRaharjaClaimEntityDto.getName() != null) {
			this.setName(bpjsJasaRaharjaClaimEntityDto.getName());
		}

		if (bpjsJasaRaharjaClaimEntityDto.getIncidentDate() != null) {
			this.setIncidentDate(bpjsJasaRaharjaClaimEntityDto.getIncidentDate());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for No SEP here] off begin
	@CsvBindByName(column = "NO_SEP", required = false)
	@Nullable
	@Column(name = "no_sep")
	@Schema(description = "The No SEP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for No SEP here] end
	private String noSEP;

	// % protected region % [Modify attribute annotation for SEP Date here] off begin
	@CsvCustomBindByName(column = "SEP_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "sep_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The SEP Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for SEP Date here] end
	private OffsetDateTime sepDate;

	// % protected region % [Modify attribute annotation for Dismissal Date here] off begin
	@CsvCustomBindByName(column = "DISMISSAL_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "dismissal_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Dismissal Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dismissal Date here] end
	private OffsetDateTime dismissalDate;

	// % protected region % [Modify attribute annotation for Patient ID here] off begin
	@CsvBindByName(column = "PATIENT_ID", required = false)
	@Nullable
	@Column(name = "patient_id")
	@Schema(description = "The Patient ID of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Patient ID here] end
	private String patientID;

	// % protected region % [Modify attribute annotation for Treatment Type here] off begin
	@CsvBindByName(column = "TREATMENT_TYPE", required = false)
	@Nullable
	@Column(name = "treatment_type")
	@Schema(description = "The Treatment Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Treatment Type here] end
	private String treatmentType;

	// % protected region % [Modify attribute annotation for Polyclinic here] off begin
	@CsvBindByName(column = "POLYCLINIC", required = false)
	@Nullable
	@Column(name = "polyclinic")
	@Schema(description = "The Polyclinic of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Polyclinic here] end
	private String polyclinic;

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

	// % protected region % [Modify attribute annotation for Incident Date here] off begin
	@CsvCustomBindByName(column = "INCIDENT_DATE", converter = DateTimeConverter.class, required = false)
	@Nullable
	@Column(name = "incident_date")
	@JsonDeserialize(using = DateTimeDeserializer.class)
	@Schema(description = "The Incident Date of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Incident Date here] end
	private OffsetDateTime incidentDate;

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
		return "NO_SEP,SEP_DATE,DISMISSAL_DATE,PATIENT_ID,TREATMENT_TYPE,POLYCLINIC,BPJS_CARD_NO,NAME,INCIDENT_DATE,ID";
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
	public boolean equals(Object bpjsJasaRaharjaClaim) {
		if (this == bpjsJasaRaharjaClaim) {
			return true;
		}
		if (bpjsJasaRaharjaClaim == null || this.getClass() != bpjsJasaRaharjaClaim.getClass()) {
			return false;
		}
		if (!super.equals(bpjsJasaRaharjaClaim)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsJasaRaharjaClaimEntity that = (BpjsJasaRaharjaClaimEntity) bpjsJasaRaharjaClaim;
		return
			Objects.equals(this.noSEP, that.noSEP) &&
			Objects.equals(
			     this.sepDate != null ? this.sepDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.sepDate != null ? that.sepDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(
			     this.dismissalDate != null ? this.dismissalDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.dismissalDate != null ? that.dismissalDate.truncatedTo(ChronoUnit.DAYS) : null
			     ) &&
			Objects.equals(this.patientID, that.patientID) &&
			Objects.equals(this.treatmentType, that.treatmentType) &&
			Objects.equals(this.polyclinic, that.polyclinic) &&
			Objects.equals(this.bpjsCardNo, that.bpjsCardNo) &&
			Objects.equals(this.name, that.name) &&
			Objects.equals(
			     this.incidentDate != null ? this.incidentDate.truncatedTo(ChronoUnit.DAYS) : null,
			     that.incidentDate != null ? that.incidentDate.truncatedTo(ChronoUnit.DAYS) : null
			     );
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
