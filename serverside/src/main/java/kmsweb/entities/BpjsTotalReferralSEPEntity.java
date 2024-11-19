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
import kmsweb.dtos.BpjsTotalReferralSEPEntityDto;
import kmsweb.entities.listeners.BpjsTotalReferralSEPEntityListener;
import kmsweb.serializers.BpjsTotalReferralSEPSerializer;
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
@EntityListeners({BpjsTotalReferralSEPEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = BpjsTotalReferralSEPSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class BpjsTotalReferralSEPEntity extends AbstractEntity {

	/**
	 * Takes a BpjsTotalReferralSEPEntityDto and converts it into a BpjsTotalReferralSEPEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param bpjsTotalReferralSEPEntityDto
	 */
	public BpjsTotalReferralSEPEntity(BpjsTotalReferralSEPEntityDto bpjsTotalReferralSEPEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (bpjsTotalReferralSEPEntityDto.getId() != null) {
			this.setId(bpjsTotalReferralSEPEntityDto.getId());
		}

		if (bpjsTotalReferralSEPEntityDto.getReferralType() != null) {
			this.setReferralType(bpjsTotalReferralSEPEntityDto.getReferralType());
		}

		if (bpjsTotalReferralSEPEntityDto.getReferralNo() != null) {
			this.setReferralNo(bpjsTotalReferralSEPEntityDto.getReferralNo());
		}

		if (bpjsTotalReferralSEPEntityDto.getTotalSEP() != null) {
			this.setTotalSEP(bpjsTotalReferralSEPEntityDto.getTotalSEP());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Referral Type here] off begin
	@CsvBindByName(column = "REFERRAL_TYPE", required = false)
	@Nullable
	@Column(name = "referral_type")
	@Schema(description = "The Referral Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral Type here] end
	private String referralType;

	// % protected region % [Modify attribute annotation for Referral No here] off begin
	@CsvBindByName(column = "REFERRAL_NO", required = false)
	@Nullable
	@Column(name = "referral_no")
	@Schema(description = "The Referral No of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Referral No here] end
	private String referralNo;

	// % protected region % [Modify attribute annotation for Total SEP here] off begin
	@CsvBindByName(column = "TOTAL_SEP", required = false)
	@Nullable
	@Column(name = "total_sep")
	@Schema(description = "The Total SEP of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Total SEP here] end
	private String totalSEP;

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
		return "REFERRAL_TYPE,REFERRAL_NO,TOTAL_SEP,ID";
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
	public boolean equals(Object bpjsTotalReferralSEP) {
		if (this == bpjsTotalReferralSEP) {
			return true;
		}
		if (bpjsTotalReferralSEP == null || this.getClass() != bpjsTotalReferralSEP.getClass()) {
			return false;
		}
		if (!super.equals(bpjsTotalReferralSEP)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		BpjsTotalReferralSEPEntity that = (BpjsTotalReferralSEPEntity) bpjsTotalReferralSEP;
		return
			Objects.equals(this.referralType, that.referralType) &&
			Objects.equals(this.referralNo, that.referralNo) &&
			Objects.equals(this.totalSEP, that.totalSEP);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
