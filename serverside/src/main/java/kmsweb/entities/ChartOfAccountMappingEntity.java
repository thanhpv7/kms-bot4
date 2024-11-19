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
import kmsweb.dtos.ChartOfAccountMappingEntityDto;
import kmsweb.entities.listeners.ChartOfAccountMappingEntityListener;
import kmsweb.serializers.ChartOfAccountMappingSerializer;
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
@EntityListeners({ChartOfAccountMappingEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ChartOfAccountMappingSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"account_type"}, name = "account_type"),
	}
)
public class ChartOfAccountMappingEntity extends AbstractEntity {

	/**
	 * Takes a ChartOfAccountMappingEntityDto and converts it into a ChartOfAccountMappingEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param chartOfAccountMappingEntityDto
	 */
	public ChartOfAccountMappingEntity(ChartOfAccountMappingEntityDto chartOfAccountMappingEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (chartOfAccountMappingEntityDto.getId() != null) {
			this.setId(chartOfAccountMappingEntityDto.getId());
		}

		if (chartOfAccountMappingEntityDto.getAccountType() != null) {
			this.setAccountType(chartOfAccountMappingEntityDto.getAccountType());
		}

		if (chartOfAccountMappingEntityDto.getAccountTypeDescription() != null) {
			this.setAccountTypeDescription(chartOfAccountMappingEntityDto.getAccountTypeDescription());
		}

		if (chartOfAccountMappingEntityDto.getChartOfAccount() != null) {
			this.setChartOfAccount(chartOfAccountMappingEntityDto.getChartOfAccount());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Account Type here] off begin
	@CsvBindByName(column = "ACCOUNT_TYPE", required = false)
	@Nullable
	@Column(name = "account_type")
	@Schema(description = "The Account Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Account Type here] end
	private String accountType;

	// % protected region % [Modify attribute annotation for Account Type Description here] off begin
	@CsvBindByName(column = "ACCOUNT_TYPE_DESCRIPTION", required = false)
	@Nullable
	@Column(name = "account_type_description")
	@Schema(description = "The Account Type Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Account Type Description here] end
	private String accountTypeDescription;

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

	// % protected region % [Update the annotation for Chart of Account here] off begin
	@Schema(description = "The Chart of Account entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Chart of Account here] end
	private ChartOfAccountEntity chartOfAccount;

	// % protected region % [Update the annotation for chartOfAccountId here] off begin
	@Transient
	@CsvCustomBindByName(column = "CHART_OF_ACCOUNT_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for chartOfAccountId here] end
	private UUID chartOfAccountId;

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
	 * Similar to {@link this#setChartOfAccount(ChartOfAccountEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ChartOfAccountEntity to be set to this entity
	 */
	public void setChartOfAccount(@NotNull ChartOfAccountEntity entity) {
		setChartOfAccount(entity, true);
	}

	/**
	 * Set or update the chartOfAccount in this entity with single ChartOfAccountEntity.
	 *
	 * @param entity the given ChartOfAccountEntity to be set or updated to chartOfAccount
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setChartOfAccount(@NotNull ChartOfAccountEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setChartOfAccount here] off begin
		// % protected region % [Add any additional logic here before the main logic for setChartOfAccount here] end

		if (sameAsFormer(this.chartOfAccount, entity)) {
			return;
		}

		if (this.chartOfAccount != null) {
			this.chartOfAccount.removeChartOfAccountMappings(this, false);
		}
		this.chartOfAccount = entity;
		if (reverseAdd) {
			this.chartOfAccount.addChartOfAccountMappings(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setChartOfAccount incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setChartOfAccount incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetChartOfAccount(boolean)} but default to true.
	 */
	public void unsetChartOfAccount() {
		this.unsetChartOfAccount(true);
	}

	/**
	 * Remove Chart of Account in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetChartOfAccount(boolean reverse) {
		if (reverse && this.chartOfAccount != null) {
			this.chartOfAccount.removeChartOfAccountMappings(this, false);
		}
		this.chartOfAccount = null;
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
		return "ACCOUNT_TYPE,ACCOUNT_TYPE_DESCRIPTION,CHART_OF_ACCOUNT_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<ChartOfAccountEntity> chartOfAccountRelation = Optional.ofNullable(this.chartOfAccount);
		chartOfAccountRelation.ifPresent(entity -> this.chartOfAccountId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object chartOfAccountMapping) {
		if (this == chartOfAccountMapping) {
			return true;
		}
		if (chartOfAccountMapping == null || this.getClass() != chartOfAccountMapping.getClass()) {
			return false;
		}
		if (!super.equals(chartOfAccountMapping)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ChartOfAccountMappingEntity that = (ChartOfAccountMappingEntity) chartOfAccountMapping;
		return
			Objects.equals(this.accountType, that.accountType) &&
			Objects.equals(this.accountTypeDescription, that.accountTypeDescription) &&
			Objects.equals(this.chartOfAccountId, that.chartOfAccountId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
