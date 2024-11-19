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
public class PcareUmumEntity extends AbstractEntity {

	public PcareUmumEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Cons ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Cons ID here] end
	private String consID;

	// % protected region % [Modify attribute annotation for Secret Key here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Secret Key here] end
	private String secretKey;

	// % protected region % [Modify attribute annotation for Web Service URL here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Web Service URL here] end
	private String webServiceURL;

	// % protected region % [Modify attribute annotation for Auth Username here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Auth Username here] end
	private String authUsername;

	// % protected region % [Modify attribute annotation for Auth Password here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Auth Password here] end
	private String authPassword;

	// % protected region % [Modify attribute annotation for Kode Aplikasi here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Kode Aplikasi here] end
	private String kodeAplikasi;

	// % protected region % [Modify attribute annotation for User Key here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for User Key here] end
	private String userKey;

	// % protected region % [Modify attribute annotation for Regional Division here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Regional Division here] end
	private String regionalDivision;

	// % protected region % [Modify attribute annotation for Branch Office here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Branch Office here] end
	private String branchOffice;

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
