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
public class NumberingSetupEntity extends AbstractEntity {

	public NumberingSetupEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Numbering Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Numbering Type here] end
	private NumberingTypeEnum numberingType;

	// % protected region % [Modify attribute annotation for Prefix here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Prefix here] end
	private String prefix;

	// % protected region % [Modify attribute annotation for Date Format here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Date Format here] end
	private DateFormatEnum dateFormat;

	// % protected region % [Modify attribute annotation for Sufix here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Sufix here] end
	private String sufix;

	// % protected region % [Modify attribute annotation for Last Counter here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Counter here] end
	private Integer lastCounter;

	// % protected region % [Modify attribute annotation for Editable here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Editable here] end
	private Boolean editable;

	// % protected region % [Modify attribute annotation for Reset per Day here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Reset per Day here] end
	private Boolean resetPerDay;

	// % protected region % [Modify attribute annotation for Counter Length here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Counter Length here] end
	private Integer counterLength;

	// % protected region % [Modify attribute annotation for Last Updated here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Last Updated here] end
	private OffsetDateTime lastUpdated;

	// % protected region % [Modify attribute annotation for Preview here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Preview here] end
	private String preview;

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
