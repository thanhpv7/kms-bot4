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
import kmsweb.dtos.ChartOfAccountEntityDto;
import kmsweb.entities.listeners.ChartOfAccountEntityListener;
import kmsweb.serializers.ChartOfAccountSerializer;
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

import java.util.*;
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
@EntityListeners({ChartOfAccountEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = ChartOfAccountSerializer.class)
@Table(
	uniqueConstraints = {
		@UniqueConstraint(columnNames = {"account_code"}, name = "account_code"),
	}
)
public class ChartOfAccountEntity extends AbstractEntity {

	/**
	 * Takes a ChartOfAccountEntityDto and converts it into a ChartOfAccountEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param chartOfAccountEntityDto
	 */
	public ChartOfAccountEntity(ChartOfAccountEntityDto chartOfAccountEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (chartOfAccountEntityDto.getId() != null) {
			this.setId(chartOfAccountEntityDto.getId());
		}

		if (chartOfAccountEntityDto.getAccountCode() != null) {
			this.setAccountCode(chartOfAccountEntityDto.getAccountCode());
		}

		if (chartOfAccountEntityDto.getAccountName() != null) {
			this.setAccountName(chartOfAccountEntityDto.getAccountName());
		}

		if (chartOfAccountEntityDto.getAccountType() != null) {
			this.setAccountType(chartOfAccountEntityDto.getAccountType());
		}

		if (chartOfAccountEntityDto.getTaxCode() != null) {
			this.setTaxCode(chartOfAccountEntityDto.getTaxCode());
		}

		if (chartOfAccountEntityDto.getDashboard() != null) {
			this.setDashboard(chartOfAccountEntityDto.getDashboard());
		}

		if (chartOfAccountEntityDto.getExpenseClaim() != null) {
			this.setExpenseClaim(chartOfAccountEntityDto.getExpenseClaim());
		}

		if (chartOfAccountEntityDto.getEnablePayment() != null) {
			this.setEnablePayment(chartOfAccountEntityDto.getEnablePayment());
		}

		if (chartOfAccountEntityDto.getDescription() != null) {
			this.setDescription(chartOfAccountEntityDto.getDescription());
		}

		if (chartOfAccountEntityDto.getChartOfAccountMappings() != null) {
			this.setChartOfAccountMappings(chartOfAccountEntityDto.getChartOfAccountMappings());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Account Code here] off begin
	@CsvBindByName(column = "ACCOUNT_CODE", required = false)
	@Nullable
	@Column(name = "account_code")
	@Schema(description = "The Account Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Account Code here] end
	private String accountCode;

	// % protected region % [Modify attribute annotation for Account Name here] off begin
	@CsvBindByName(column = "ACCOUNT_NAME", required = false)
	@Nullable
	@Column(name = "account_name")
	@Schema(description = "The Account Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Account Name here] end
	private String accountName;

	// % protected region % [Modify attribute annotation for Account Type here] off begin
	@CsvBindByName(column = "ACCOUNT_TYPE", required = false)
	@Nullable
	@Column(name = "account_type")
	@Schema(description = "The Account Type of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Account Type here] end
	private String accountType;

	// % protected region % [Modify attribute annotation for Tax Code here] off begin
	@CsvBindByName(column = "TAX_CODE", required = false)
	@Nullable
	@Column(name = "tax_code")
	@Schema(description = "The Tax Code of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Tax Code here] end
	private String taxCode;

	// % protected region % [Modify attribute annotation for Dashboard here] off begin
	@CsvBindByName(column = "DASHBOARD", required = false)
	@Nullable
	@Column(name = "dashboard")
	@Schema(description = "The Dashboard of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Dashboard here] end
	private Boolean dashboard = false ;

	// % protected region % [Modify attribute annotation for Expense Claim here] off begin
	@CsvBindByName(column = "EXPENSE_CLAIM", required = false)
	@Nullable
	@Column(name = "expense_claim")
	@Schema(description = "The Expense Claim of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Expense Claim here] end
	private Boolean expenseClaim = false ;

	// % protected region % [Modify attribute annotation for Enable Payment here] off begin
	@CsvBindByName(column = "ENABLE_PAYMENT", required = false)
	@Nullable
	@Column(name = "enable_payment")
	@Schema(description = "The Enable Payment of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Enable Payment here] end
	private Boolean enablePayment = false ;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@CsvBindByName(column = "DESCRIPTION", required = false)
	@Nullable
	@Column(name = "description")
	@Schema(description = "The Description of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing references
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Update the annotation for Chart of Account Mappings here] off begin
	@Schema(description = "The Chart of Account Mapping entities that are related to this entity.")
	@OneToMany(mappedBy = "chartOfAccount", cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Chart of Account Mappings here] end
	private Set<ChartOfAccountMappingEntity> chartOfAccountMappings = new HashSet<>();

	// % protected region % [Update the annotation for chartOfAccountMappingsIds here] off begin
	@Transient
	@CsvCustomBindByName(column = "CHART_OF_ACCOUNT_MAPPINGS_IDS", converter = UUIDHashSetConverter.class)
	// % protected region % [Update the annotation for chartOfAccountMappingsIds here] end
	private Set<UUID> chartOfAccountMappingsIds = new HashSet<>();

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

/**
	 * Similar to {@link this#addChartOfAccountMappings(ChartOfAccountMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ChartOfAccountMappingEntity to be added to this entity
	 */
	public void addChartOfAccountMappings(@NotNull ChartOfAccountMappingEntity entity) {
		addChartOfAccountMappings(entity, true);
	}

	/**
	 * Add a new ChartOfAccountMappingEntity to chartOfAccountMappings in this entity.
	 *
	 * @param entity the given ChartOfAccountMappingEntity  to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entity
	 */
	public void addChartOfAccountMappings(@NonNull ChartOfAccountMappingEntity entity, boolean reverseAdd) {
		if (!this.chartOfAccountMappings.contains(entity)) {
			chartOfAccountMappings.add(entity);
			if (reverseAdd) {
				entity.setChartOfAccount(this, false);
			}
		}
	}

	/**
	 * Similar to {@link this#addChartOfAccountMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to be added to this entity
	 */
	public void addChartOfAccountMappings(@NotNull Collection<ChartOfAccountMappingEntity> entities) {
		addChartOfAccountMappings(entities, true);
	}

	/**
	 * Add a new collection of ChartOfAccountMappingEntity to Chart of Account Mappings in this entity.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to be added to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void addChartOfAccountMappings(@NonNull Collection<ChartOfAccountMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> addChartOfAccountMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#removeChartOfAccountMappings(ChartOfAccountMappingEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given ChartOfAccountMappingEntity to be set to this entity
	 */
	public void removeChartOfAccountMappings(@NotNull ChartOfAccountMappingEntity entity) {
		this.removeChartOfAccountMappings(entity, true);
	}

	/**
	 * Remove the given ChartOfAccountMappingEntity from this entity.
	 *
	 * @param entity the given ChartOfAccountMappingEntity to be removed from this entity
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void removeChartOfAccountMappings(@NotNull ChartOfAccountMappingEntity entity, boolean reverse) {
		if (reverse) {
			entity.unsetChartOfAccount(false);
		}
		this.chartOfAccountMappings.remove(entity);
	}

	/**
	 * Similar to {@link this#removeChartOfAccountMappings(Collection, boolean)} but
	 * default to true for reverse remove.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to be removed to this entity
	 */
	public void removeChartOfAccountMappings(@NotNull Collection<ChartOfAccountMappingEntity> entities) {
		this.removeChartOfAccountMappings(entities, true);
	}

	/**
	 * Remove the given collection of ChartOfAccountMappingEntity from  to this entity.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to be removed to this entity
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void removeChartOfAccountMappings(@NonNull Collection<ChartOfAccountMappingEntity> entities, boolean reverseAdd) {
		entities.forEach(entity -> this.removeChartOfAccountMappings(entity, reverseAdd));
	}

	/**
	 * Similar to {@link this#setChartOfAccountMappings(Collection, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to be set to this entity
	 */
	public void setChartOfAccountMappings(@NotNull Collection<ChartOfAccountMappingEntity> entities) {
		setChartOfAccountMappings(entities, true);
	}

	/**
	 * Replace the current entities in Chart of Account Mappings with the given ones.
	 *
	 * @param entities the given collection of ChartOfAccountMappingEntity to replace the old ones
	 * @param reverseAdd whether this entity should be added to the given entities
	 */
	public void setChartOfAccountMappings(@NotNull Collection<ChartOfAccountMappingEntity> entities, boolean reverseAdd) {

		this.unsetChartOfAccountMappings();
		this.chartOfAccountMappings = new HashSet<>(entities);
		if (reverseAdd) {
			this.chartOfAccountMappings.forEach(chartOfAccountMappingsEntity -> chartOfAccountMappingsEntity.setChartOfAccount(this, false));
		}
	}

	/**
	 * Similar to {@link this#unsetChartOfAccountMappings(boolean)} but
	 * default to true for reverse unset
	 */
	public void unsetChartOfAccountMappings() {
		this.unsetChartOfAccountMappings(true);
	}

	/**
	 * Remove all the entities in Chart of Account Mappings from this entity.
	 * @param doReverse whether this entity should be removed from the given entities
	 */
	public void unsetChartOfAccountMappings(boolean doReverse) {
		if (doReverse) {
			this.chartOfAccountMappings.forEach(chartOfAccountMappingsEntity -> chartOfAccountMappingsEntity.unsetChartOfAccount(false));
		}
		this.chartOfAccountMappings.clear();
	}
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
		return "ACCOUNT_CODE,ACCOUNT_NAME,ACCOUNT_TYPE,TAX_CODE,DASHBOARD,EXPENSE_CLAIM,ENABLE_PAYMENT,DESCRIPTION,CHART_OF_ACCOUNT_MAPPINGS_IDS,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		this.chartOfAccountMappingsIds = new HashSet<>();
		for (ChartOfAccountMappingEntity chartOfAccountMappings: this.chartOfAccountMappings) {
			this.chartOfAccountMappingsIds.add(chartOfAccountMappings.getId());
		}

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object chartOfAccount) {
		if (this == chartOfAccount) {
			return true;
		}
		if (chartOfAccount == null || this.getClass() != chartOfAccount.getClass()) {
			return false;
		}
		if (!super.equals(chartOfAccount)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		ChartOfAccountEntity that = (ChartOfAccountEntity) chartOfAccount;
		return
			Objects.equals(this.accountCode, that.accountCode) &&
			Objects.equals(this.accountName, that.accountName) &&
			Objects.equals(this.accountType, that.accountType) &&
			Objects.equals(this.taxCode, that.taxCode) &&
			Objects.equals(this.dashboard, that.dashboard) &&
			Objects.equals(this.expenseClaim, that.expenseClaim) &&
			Objects.equals(this.enablePayment, that.enablePayment) &&
			Objects.equals(this.description, that.description) &&
			Objects.equals(this.chartOfAccountMappingsIds, that.chartOfAccountMappingsIds);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
