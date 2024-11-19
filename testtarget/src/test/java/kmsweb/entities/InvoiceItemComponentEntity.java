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

import lombok.*;
import javax.validation.constraints.NotNull;


// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class InvoiceItemComponentEntity extends AbstractEntity {

	public InvoiceItemComponentEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {


		var InvoiceItemOneMany = new EntityReference();
			InvoiceItemOneMany.entityName = "InvoiceItem";
			InvoiceItemOneMany.oppositeName = "InvoiceItem";
			InvoiceItemOneMany.name = "InvoiceItemComponents";
			InvoiceItemOneMany.optional = true;
			InvoiceItemOneMany.type = "One";
			InvoiceItemOneMany.oppositeType = "Many";

		References.add(InvoiceItemOneMany);

		var PriceComponentOneMany = new EntityReference();
			PriceComponentOneMany.entityName = "PriceComponent";
			PriceComponentOneMany.oppositeName = "PriceComponent";
			PriceComponentOneMany.name = "InvoiceItemComponents";
			PriceComponentOneMany.optional = true;
			PriceComponentOneMany.type = "One";
			PriceComponentOneMany.oppositeType = "Many";

		References.add(PriceComponentOneMany);
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Price here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Price here] end
	private Double price;

	// % protected region % [Modify attribute annotation for Medical Staff here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Medical Staff here] end
	private String medicalStaff;

	// % protected region % [Modify attribute annotation for Notes here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Notes here] end
	private String notes;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-one
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming one-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private InvoiceItemEntity invoiceItem;

	private PriceComponentEntity priceComponent;

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Outgoing many-to-many
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Incoming many-to-many
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
	 * Similar to {@link this#setInvoiceItem(InvoiceItemEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given InvoiceItemEntity to be set to this entity
	 */
	public void setInvoiceItem(@NonNull InvoiceItemEntity entity) {
		setInvoiceItem(entity, true);
	}

	/**
	 * Set or update the invoiceItem in this entity with single InvoiceItemEntity.
	 *
	 * @param entity the given InvoiceItemEntity to be set or updated to invoiceItem
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setInvoiceItem(@NonNull InvoiceItemEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setInvoiceItem here] off begin
		// % protected region % [Add any additional logic here before the main logic for setInvoiceItem here] end

		if (sameAsFormer(this.invoiceItem, entity)) {
			return;
		}

		if (this.invoiceItem != null) {
			this.invoiceItem.removeInvoiceItemComponents(this, false);
		}
		this.invoiceItem = entity;
		if (reverseAdd) {
			this.invoiceItem.addInvoiceItemComponents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setInvoiceItem incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setInvoiceItem incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetInvoiceItem(boolean)} but default to true.
	 */
	public void unsetInvoiceItem() {
		this.unsetInvoiceItem(true);
	}

	/**
	 * Remove Invoice Item in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetInvoiceItem(boolean reverse) {
		if (reverse && this.invoiceItem != null) {
			this.invoiceItem.removeInvoiceItemComponents(this, false);
		}
		this.invoiceItem = null;
	}
	/**
	 * Similar to {@link this#setPriceComponent(PriceComponentEntity, boolean)} but
	 * default to true for reverse add.
	 *
	 * @param entity the given PriceComponentEntity to be set to this entity
	 */
	public void setPriceComponent(@NonNull PriceComponentEntity entity) {
		setPriceComponent(entity, true);
	}

	/**
	 * Set or update the priceComponent in this entity with single PriceComponentEntity.
	 *
	 * @param entity the given PriceComponentEntity to be set or updated to priceComponent
	 * @param reverseAdd whether this entity should be set or updated to the given entity
	 */
	public void setPriceComponent(@NonNull PriceComponentEntity entity, boolean reverseAdd) {
		// % protected region % [Add any additional logic here before the main logic for setPriceComponent here] off begin
		// % protected region % [Add any additional logic here before the main logic for setPriceComponent here] end

		if (sameAsFormer(this.priceComponent, entity)) {
			return;
		}

		if (this.priceComponent != null) {
			this.priceComponent.removeInvoiceItemComponents(this, false);
		}
		this.priceComponent = entity;
		if (reverseAdd) {
			this.priceComponent.addInvoiceItemComponents(this, false);
		}

		// % protected region % [Add any additional logic here after the main logic for setPriceComponent incomingOneToMany here] off begin
		// % protected region % [Add any additional logic here after the main logic for setPriceComponent incomingOneToMany here] end
	}

	/**
	 * Similar to {@link this#unsetPriceComponent(boolean)} but default to true.
	 */
	public void unsetPriceComponent() {
		this.unsetPriceComponent(true);
	}

	/**
	 * Remove Price Component in this entity.
	 *
	 * @param reverse whether this entity should be removed from the given entity
	 */
	public void unsetPriceComponent(boolean reverse) {
		if (reverse && this.priceComponent != null) {
			this.priceComponent.removeInvoiceItemComponents(this, false);
		}
		this.priceComponent = null;
	}

	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
