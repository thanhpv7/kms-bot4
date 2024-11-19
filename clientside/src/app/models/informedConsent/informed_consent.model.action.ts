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

import {Action} from '@ngrx/store';
import {InformedConsentModel} from './informed_consent.model';
import {InformedConsentModelAudit} from './informed_consent.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Informed Consent model actions to be dispatched by NgRx.
 */
export enum InformedConsentModelActionTypes {
	CREATE_INFORMED_CONSENT = '[ENTITY] Create InformedConsentModel',
	CREATE_INFORMED_CONSENT_OK = '[ENTITY] Create InformedConsentModel successfully',
	CREATE_INFORMED_CONSENT_FAIL = '[ENTITY] Create InformedConsentModel failed',

	CREATE_ALL_INFORMED_CONSENT = '[ENTITY] Create All InformedConsentModel',
	CREATE_ALL_INFORMED_CONSENT_OK = '[ENTITY] Create All InformedConsentModel successfully',
	CREATE_ALL_INFORMED_CONSENT_FAIL = '[ENTITY] Create All InformedConsentModel failed',

	DELETE_INFORMED_CONSENT = '[ENTITY] Delete InformedConsentModel',
	DELETE_INFORMED_CONSENT_OK = '[ENTITY] Delete InformedConsentModel successfully',
	DELETE_INFORMED_CONSENT_FAIL = '[ENTITY] Delete InformedConsentModel failed',


	DELETE_INFORMED_CONSENT_EXCLUDING_IDS = '[ENTITY] Delete InformedConsentModels Excluding Ids',
	DELETE_INFORMED_CONSENT_EXCLUDING_IDS_OK = '[ENTITY] Delete InformedConsentModels Excluding Ids successfully',
	DELETE_INFORMED_CONSENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InformedConsentModels Excluding Ids failed',

	DELETE_ALL_INFORMED_CONSENT = '[ENTITY] Delete all InformedConsentModels',
	DELETE_ALL_INFORMED_CONSENT_OK = '[ENTITY] Delete all InformedConsentModels successfully',
	DELETE_ALL_INFORMED_CONSENT_FAIL = '[ENTITY] Delete all InformedConsentModels failed',

	UPDATE_INFORMED_CONSENT = '[ENTITY] Update InformedConsentModel',
	UPDATE_INFORMED_CONSENT_OK = '[ENTITY] Update InformedConsentModel successfully',
	UPDATE_INFORMED_CONSENT_FAIL = '[ENTITY] Update InformedConsentModel failed',

	UPDATE_ALL_INFORMED_CONSENT = '[ENTITY] Update all InformedConsentModel',
	UPDATE_ALL_INFORMED_CONSENT_OK = '[ENTITY] Update all InformedConsentModel successfully',
	UPDATE_ALL_INFORMED_CONSENT_FAIL = '[ENTITY] Update all InformedConsentModel failed',

	FETCH_INFORMED_CONSENT= '[ENTITY] Fetch InformedConsentModel',
	FETCH_INFORMED_CONSENT_OK = '[ENTITY] Fetch InformedConsentModel successfully',
	FETCH_INFORMED_CONSENT_FAIL = '[ENTITY] Fetch InformedConsentModel failed',

	FETCH_INFORMED_CONSENT_AUDIT= '[ENTITY] Fetch InformedConsentModel audit',
	FETCH_INFORMED_CONSENT_AUDIT_OK = '[ENTITY] Fetch InformedConsentModel audit successfully',
	FETCH_INFORMED_CONSENT_AUDIT_FAIL = '[ENTITY] Fetch InformedConsentModel audit failed',

	FETCH_INFORMED_CONSENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InformedConsentModel audits by entity id',
	FETCH_INFORMED_CONSENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InformedConsentModel audits by entity id successfully',
	FETCH_INFORMED_CONSENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InformedConsentModel audits by entity id failed',

	FETCH_ALL_INFORMED_CONSENT = '[ENTITY] Fetch all InformedConsentModel',
	FETCH_ALL_INFORMED_CONSENT_OK = '[ENTITY] Fetch all InformedConsentModel successfully',
	FETCH_ALL_INFORMED_CONSENT_FAIL = '[ENTITY] Fetch all InformedConsentModel failed',

	FETCH_INFORMED_CONSENT_WITH_QUERY = '[ENTITY] Fetch InformedConsentModel with query',
	FETCH_INFORMED_CONSENT_WITH_QUERY_OK = '[ENTITY] Fetch InformedConsentModel with query successfully',
	FETCH_INFORMED_CONSENT_WITH_QUERY_FAIL = '[ENTITY] Fetch InformedConsentModel with query failed',

	FETCH_LAST_INFORMED_CONSENT_WITH_QUERY = '[ENTITY] Fetch last InformedConsentModel with query',
	FETCH_LAST_INFORMED_CONSENT_WITH_QUERY_OK = '[ENTITY] Fetch last InformedConsentModel with query successfully',
	FETCH_LAST_INFORMED_CONSENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last InformedConsentModel with query failed',

	EXPORT_INFORMED_CONSENT = '[ENTITY] Export InformedConsentModel',
	EXPORT_INFORMED_CONSENT_OK = '[ENTITY] Export InformedConsentModel successfully',
	EXPORT_INFORMED_CONSENT_FAIL = '[ENTITY] Export InformedConsentModel failed',

	EXPORT_ALL_INFORMED_CONSENT = '[ENTITY] Export All InformedConsentModels',
	EXPORT_ALL_INFORMED_CONSENT_OK = '[ENTITY] Export All InformedConsentModels successfully',
	EXPORT_ALL_INFORMED_CONSENT_FAIL = '[ENTITY] Export All InformedConsentModels failed',

	EXPORT_INFORMED_CONSENT_EXCLUDING_IDS = '[ENTITY] Export InformedConsentModels excluding Ids',
	EXPORT_INFORMED_CONSENT_EXCLUDING_IDS_OK = '[ENTITY] Export InformedConsentModel excluding Ids successfully',
	EXPORT_INFORMED_CONSENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export InformedConsentModel excluding Ids failed',

	COUNT_INFORMED_CONSENTS = '[ENTITY] Fetch number of InformedConsentModel records',
	COUNT_INFORMED_CONSENTS_OK = '[ENTITY] Fetch number of InformedConsentModel records successfully ',
	COUNT_INFORMED_CONSENTS_FAIL = '[ENTITY] Fetch number of InformedConsentModel records failed',

	IMPORT_INFORMED_CONSENTS = '[ENTITY] Import InformedConsentModels',
	IMPORT_INFORMED_CONSENTS_OK = '[ENTITY] Import InformedConsentModels successfully',
	IMPORT_INFORMED_CONSENTS_FAIL = '[ENTITY] Import InformedConsentModels fail',


	INITIALISE_INFORMED_CONSENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InformedConsentModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInformedConsentAction implements Action {
	readonly className: string = 'InformedConsentModel';

	abstract readonly type: string;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	protected constructor(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
		public readonly afterwardActions: Action[] = []
	) {
		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}
}

export class InformedConsentAction extends BaseInformedConsentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InformedConsentAction here] off begin
	// % protected region % [Add any additional class fields for InformedConsentAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InformedConsentModel>,
		// % protected region % [Add any additional constructor parameters for InformedConsentAction here] off begin
		// % protected region % [Add any additional constructor parameters for InformedConsentAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InformedConsentAction here] off begin
			// % protected region % [Add any additional constructor arguments for InformedConsentAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InformedConsentAction here] off begin
		// % protected region % [Add any additional constructor logic for InformedConsentAction here] end
	}

	// % protected region % [Add any additional class methods for InformedConsentAction here] off begin
	// % protected region % [Add any additional class methods for InformedConsentAction here] end
}

export class InformedConsentActionOK extends BaseInformedConsentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InformedConsentActionOK here] off begin
	// % protected region % [Add any additional class fields for InformedConsentActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InformedConsentModel>,
		// % protected region % [Add any additional constructor parameters for InformedConsentActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InformedConsentActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InformedConsentModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InformedConsentActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InformedConsentActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InformedConsentActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InformedConsentActionOK here] end
	}

	// % protected region % [Add any additional class methods for InformedConsentActionOK here] off begin
	// % protected region % [Add any additional class methods for InformedConsentActionOK here] end
}

export class InformedConsentActionFail extends BaseInformedConsentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InformedConsentActionFail here] off begin
	// % protected region % [Add any additional class fields for InformedConsentActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InformedConsentModel>,
		// % protected region % [Add any additional constructor parameters for InformedConsentActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InformedConsentActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InformedConsentActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InformedConsentActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InformedConsentActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InformedConsentActionFail here] end
	}

	// % protected region % [Add any additional class methods for InformedConsentActionFail here] off begin
	// % protected region % [Add any additional class methods for InformedConsentActionFail here] end
}

export function isInformedConsentModelAction(e: any): e is BaseInformedConsentAction {
	return Object.values(InformedConsentModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
