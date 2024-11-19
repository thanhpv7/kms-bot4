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

import kmsweb.entities.enums.*;
import lombok.*;
import javax.validation.constraints.NotNull;

import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class CashAllocationEntity extends AbstractEntity {

	public CashAllocationEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Cash Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Cash Type here] end
	private CashTypeEnum cashType;

	// % protected region % [Modify attribute annotation for Allocated Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Allocated Date here] end
	private OffsetDateTime allocatedDate;

	// % protected region % [Modify attribute annotation for Source Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Source Date here] end
	private OffsetDateTime sourceDate;

	// % protected region % [Modify attribute annotation for Cash Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Cash Number here] end
	private String cashNumber;

	// % protected region % [Modify attribute annotation for Source Document Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Source Document Type here] end
	private SourceDocumentTypeEnum sourceDocumentType;

	// % protected region % [Modify attribute annotation for Source Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Source Number here] end
	private String sourceNumber;

	// % protected region % [Modify attribute annotation for Source Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Source Amount here] end
	private Double sourceAmount;

	// % protected region % [Modify attribute annotation for Outstanding Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Outstanding Amount here] end
	private Double outstandingAmount;

	// % protected region % [Modify attribute annotation for Allocated Amount here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Allocated Amount here] end
	private Double allocatedAmount;

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



	// % protected region % [Add any additional class methods  here] off begin
	// % protected region % [Add any additional class methods  here] end
}
