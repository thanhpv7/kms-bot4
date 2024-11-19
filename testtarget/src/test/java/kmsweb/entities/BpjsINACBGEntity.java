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
public class BpjsINACBGEntity extends AbstractEntity {

	public BpjsINACBGEntity() {
		initialiseReferences();
	}

	private void initialiseReferences() {

	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//
	// Attributes
	//
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	// % protected region % [Modify attribute annotation for Health Facility Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Health Facility Code here] end
	private String healthFacilityCode;

	// % protected region % [Modify attribute annotation for Health Facility Name here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Health Facility Name here] end
	private String healthFacilityName;

	// % protected region % [Modify attribute annotation for Address here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Address here] end
	private String address;

	// % protected region % [Modify attribute annotation for State Province here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for State Province here] end
	private String stateProvince;

	// % protected region % [Modify attribute annotation for City Regency here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for City Regency here] end
	private String cityRegency;

	// % protected region % [Modify attribute annotation for Regional here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Regional here] end
	private String regional;

	// % protected region % [Modify attribute annotation for Hospital Class here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Hospital Class here] end
	private String hospitalClass;

	// % protected region % [Modify attribute annotation for INACBG Tariff 1 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for INACBG Tariff 1 here] end
	private String inacbgTariff1;

	// % protected region % [Modify attribute annotation for INACBG Tariff 2 here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for INACBG Tariff 2 here] end
	private String inacbgTariff2;

	// % protected region % [Modify attribute annotation for Additional Upgrade VIP here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Additional Upgrade VIP here] end
	private String additionalUpgradeVIP;

	// % protected region % [Modify attribute annotation for Payplan ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Payplan ID here] end
	private String payplanID;

	// % protected region % [Modify attribute annotation for Payment Plan Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Payment Plan Code here] end
	private String paymentPlanCode;

	// % protected region % [Modify attribute annotation for Tariff Code here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Tariff Code here] end
	private String tariffCode;

	// % protected region % [Modify attribute annotation for URL here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for URL here] end
	private String url;

	// % protected region % [Modify attribute annotation for Username here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Username here] end
	private String username;

	// % protected region % [Modify attribute annotation for Password here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Password here] end
	private String password;

	// % protected region % [Modify attribute annotation for Secret Key here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Secret Key here] end
	private String secretKey;

	// % protected region % [Modify attribute annotation for Coder ID here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Coder ID here] end
	private String coderID;

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
