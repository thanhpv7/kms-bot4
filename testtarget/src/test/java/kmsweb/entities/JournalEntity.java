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

import java.time.*;

// % protected region % [Import any additional imports here] off begin
// % protected region % [Import any additional imports here] end

@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@ToString(callSuper = true, onlyExplicitlyIncluded = true)
public class JournalEntity extends AbstractEntity {

	public JournalEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Journal Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Journal Number here] end
	private String journalNumber;

	// % protected region % [Modify attribute annotation for Transaction Date here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Date here] end
	private OffsetDateTime transactionDate;

	// % protected region % [Modify attribute annotation for Reference Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Reference Number here] end
	private String referenceNumber;

	// % protected region % [Modify attribute annotation for Transaction Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Type here] end
	private String transactionType;

	// % protected region % [Modify attribute annotation for Transaction Detail Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Transaction Detail Type here] end
	private String transactionDetailType;

	// % protected region % [Modify attribute annotation for Account Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Account Number here] end
	private String accountNumber;

	// % protected region % [Modify attribute annotation for Debit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Debit here] end
	private Double debit;

	// % protected region % [Modify attribute annotation for Credit here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Credit here] end
	private Double credit;

	// % protected region % [Modify attribute annotation for Posting Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Posting Status here] end
	private String postingStatus;

	// % protected region % [Modify attribute annotation for Posting Date Time here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Posting Date Time here] end
	private OffsetDateTime postingDateTime;

	// % protected region % [Modify attribute annotation for Supplier Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Supplier Number here] end
	private String supplierNumber;

	// % protected region % [Modify attribute annotation for Supplier Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Supplier Name here] end
	private String supplierName;

	// % protected region % [Modify attribute annotation for Customer Number here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Customer Number here] end
	private String customerNumber;

	// % protected region % [Modify attribute annotation for Customer Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Customer Name here] end
	private String customerName;

	// % protected region % [Modify attribute annotation for Revenue Center here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Revenue Center here] end
	private String revenueCenter;

	// % protected region % [Modify attribute annotation for Description here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Description here] end
	private String description;

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
