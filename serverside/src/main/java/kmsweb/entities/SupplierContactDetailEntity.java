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
import kmsweb.dtos.SupplierContactDetailEntityDto;
import kmsweb.entities.listeners.SupplierContactDetailEntityListener;
import kmsweb.serializers.SupplierContactDetailSerializer;
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
@EntityListeners({SupplierContactDetailEntityListener.class, AuditingEntityListener.class})
@JsonSerialize(using = SupplierContactDetailSerializer.class)
@Table(
	uniqueConstraints = {
	}
)
public class SupplierContactDetailEntity extends AbstractEntity {

	/**
	 * Takes a SupplierContactDetailEntityDto and converts it into a SupplierContactDetailEntity.
	 * Primarily used when endpoints are invoked, as they take DTOs as input, which need to be converted to the entity type
	 *
	 * @param supplierContactDetailEntityDto
	 */
	public SupplierContactDetailEntity(SupplierContactDetailEntityDto supplierContactDetailEntityDto) {
		// Need to account for potential that any field is empty.  This will be run before any server validation and
		// endpoints will most likely not be subject to clientside validation

		if (supplierContactDetailEntityDto.getId() != null) {
			this.setId(supplierContactDetailEntityDto.getId());
		}

		if (supplierContactDetailEntityDto.getName() != null) {
			this.setName(supplierContactDetailEntityDto.getName());
		}

		if (supplierContactDetailEntityDto.getPosition() != null) {
			this.setPosition(supplierContactDetailEntityDto.getPosition());
		}

		if (supplierContactDetailEntityDto.getPhoneNumber() != null) {
			this.setPhoneNumber(supplierContactDetailEntityDto.getPhoneNumber());
		}

		if (supplierContactDetailEntityDto.getMobilePhoneNumber() != null) {
			this.setMobilePhoneNumber(supplierContactDetailEntityDto.getMobilePhoneNumber());
		}

		if (supplierContactDetailEntityDto.getExt() != null) {
			this.setExt(supplierContactDetailEntityDto.getExt());
		}

		if (supplierContactDetailEntityDto.getEmail() != null) {
			this.setEmail(supplierContactDetailEntityDto.getEmail());
		}

		if (supplierContactDetailEntityDto.getSupplier() != null) {
			this.setSupplier(supplierContactDetailEntityDto.getSupplier());
		}

		// % protected region % [Add any additional DTO constructor logic here] off begin
		// % protected region % [Add any additional DTO constructor logic here] end
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Name here] off begin
	@CsvBindByName(column = "NAME", required = false)
	@Nullable
	@Column(name = "name")
	@Schema(description = "The Name of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Name here] end
	private String name;

	// % protected region % [Modify attribute annotation for Position here] off begin
	@CsvBindByName(column = "POSITION", required = false)
	@Nullable
	@Column(name = "position")
	@Schema(description = "The Position of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Position here] end
	private String position;

	// % protected region % [Modify attribute annotation for Phone Number here] off begin
	@CsvBindByName(column = "PHONE_NUMBER", required = false)
	@Nullable
	@Pattern(message = "Must match a valid numeric string",
			regexp = ValidatorPatterns.numeric)
	@Column(name = "phone_number")
	@Schema(description = "The Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Phone Number here] end
	private String phoneNumber;

	// % protected region % [Modify attribute annotation for Mobile Phone Number here] off begin
	@CsvBindByName(column = "MOBILE_PHONE_NUMBER", required = false)
	@Nullable
	@Pattern(message = "Must match a valid numeric string",
			regexp = ValidatorPatterns.numeric)
	@Column(name = "mobile_phone_number")
	@Schema(description = "The Mobile Phone Number of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Mobile Phone Number here] end
	private String mobilePhoneNumber;

	// % protected region % [Modify attribute annotation for Ext here] off begin
	@CsvBindByName(column = "EXT", required = false)
	@Nullable
	@Pattern(message = "Must match a valid numeric string",
			regexp = ValidatorPatterns.numeric)
	@Column(name = "ext")
	@Schema(description = "The Ext of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Ext here] end
	private String ext;

	// % protected region % [Modify attribute annotation for Email here] off begin
	@CsvBindByName(column = "EMAIL", required = false)
	@Nullable
	@Email
	@Column(name = "email")
	@Schema(description = "The Email of this entity.")
	@ToString.Include
	// % protected region % [Modify attribute annotation for Email here] end
	private String email;

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

	// % protected region % [Update the annotation for Supplier here] off begin
	@Schema(description = "The Supplier entities that are related to this entity.")
	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@CsvIgnore
	// % protected region % [Update the annotation for Supplier here] end
	private SupplierEntity supplier;

	// % protected region % [Update the annotation for supplierId here] off begin
	@Transient
	@CsvCustomBindByName(column = "SUPPLIER_ID", converter = UUIDConverter.class)
	// % protected region % [Update the annotation for supplierId here] end
	private UUID supplierId;

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
	 * Similar to {@link this#setSupplier(SupplierEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given SupplierEntity to be set to this entity
	 */
	public void setSupplier(@NotNull SupplierEntity entity) {
		setSupplier(entity, true);
	}

	/**
	 * Set or update the supplier in this entity with single SupplierEntity.
	 *
	 * @param entity the given SupplierEntity to be set or updated to supplier
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setSupplier(@NotNull SupplierEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setSupplier here] off begin
		// % protected region % [Add any additional logic here before the main logic for setSupplier here] end

		if (sameAsFormer(this.supplier, entity)) {
			return;
		}

		if (this.supplier != null) {
			this.supplier.removeSuplierContactDetails(this, false);
		}
		this.supplier = entity;
		if (reverseAdd) {
			this.supplier.addSuplierContactDetails(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setSupplier incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setSupplier incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetSupplier(boolean)} but default to true.
	 */
	public void unsetSupplier() {
		this.unsetSupplier(true);
	}

	/**
	 * Remove Supplier in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetSupplier(boolean reverse) {
		if (reverse && this.supplier != null) {
			this.supplier.removeSuplierContactDetails(this, false);
		}
		this.supplier = null;
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
		return "NAME,POSITION,PHONE_NUMBER,MOBILE_PHONE_NUMBER,EXT,EMAIL,SUPPLIER_ID,ID";
		// % protected region % [Modify the headers in the CSV file here] end
	}

	/**
	 * Reset the reference transient references based on the materialised references
	 * When rerun we reset the transient references and start again.
	 */
	public void addRelationEntitiesToIdSet() {
		// % protected region % [Add any additional logic for entity relations here] off begin
		Optional<SupplierEntity> supplierRelation = Optional.ofNullable(this.supplier);
		supplierRelation.ifPresent(entity -> this.supplierId = entity.getId());

		// % protected region % [Add any additional logic for entity relations here] end
	}

	@Override
	public boolean equals(Object supplierContactDetail) {
		if (this == supplierContactDetail) {
			return true;
		}
		if (supplierContactDetail == null || this.getClass() != supplierContactDetail.getClass()) {
			return false;
		}
		if (!super.equals(supplierContactDetail)) {
			return false;
		}

		// Compare references by ids only
		this.addRelationEntitiesToIdSet();
		SupplierContactDetailEntity that = (SupplierContactDetailEntity) supplierContactDetail;
		return
			Objects.equals(this.name, that.name) &&
			Objects.equals(this.position, that.position) &&
			Objects.equals(this.phoneNumber, that.phoneNumber) &&
			Objects.equals(this.mobilePhoneNumber, that.mobilePhoneNumber) &&
			Objects.equals(this.ext, that.ext) &&
			Objects.equals(this.email, that.email) &&
			Objects.equals(this.supplierId, that.supplierId);
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
