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
public class BpjsGeneralEntity extends AbstractEntity {

	public BpjsGeneralEntity() {
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

	// % protected region % [Modify attribute annotation for BPJS Web Service URL here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for BPJS Web Service URL here] end
	private String bpjsWebServiceURL;

	// % protected region % [Modify attribute annotation for Aplicare Web Service URL here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Aplicare Web Service URL here] end
	private String aplicareWebServiceURL;

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

	// % protected region % [Modify attribute annotation for MJKN WS BPJS URL here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for MJKN WS BPJS URL here] end
	private String mjknWSBPJSURL;

	// % protected region % [Modify attribute annotation for MJKN WS BPJS User Key here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for MJKN WS BPJS User Key here] end
	private String mjknWSBPJSUserKey;

	// % protected region % [Modify attribute annotation for Vclaim User Key here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Vclaim User Key here] end
	private String vclaimUserKey;

	// % protected region % [Modify attribute annotation for Connect To Other System here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Connect To Other System here] end
	private Boolean connectToOtherSystem;

	// % protected region % [Modify attribute annotation for IsMobileJKN here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for IsMobileJKN here] end
	private Boolean ismobilejkn;

	// % protected region % [Modify attribute annotation for External System URL here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for External System URL here] end
	private String externalSystemURL;

	// % protected region % [Modify attribute annotation for Basic Auth here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Basic Auth here] end
	private Boolean basicAuth;

	// % protected region % [Modify attribute annotation for Basic Auth Username here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Basic Auth Username here] end
	private String basicAuthUsername;

	// % protected region % [Modify attribute annotation for Basic Auth Password here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Basic Auth Password here] end
	private String basicAuthPassword;

	// % protected region % [Modify attribute annotation for Bypass SSL Validation here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Bypass SSL Validation here] end
	private Boolean bypassSSLValidation;

	// % protected region % [Modify attribute annotation for Claim Status here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Claim Status here] end
	private Boolean claimStatus;

	// % protected region % [Modify attribute annotation for Facility Type here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Facility Type here] end
	private String facilityType;

	// % protected region % [Modify attribute annotation for Send Non JKN here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Send Non JKN here] end
	private Boolean sendNonJKN;

	// % protected region % [Modify attribute annotation for Vclaim Integration here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for Vclaim Integration here] end
	private Boolean vclaimIntegration;

	// % protected region % [Modify attribute annotation for External Vclaim Service URL here] off begin
	@ToString.Include
	@Setter
	// % protected region % [Modify attribute annotation for External Vclaim Service URL here] end
	private String externalVclaimServiceURL;

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
