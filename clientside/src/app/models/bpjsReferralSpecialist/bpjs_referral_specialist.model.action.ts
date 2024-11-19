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
import {BpjsReferralSpecialistModel} from './bpjs_referral_specialist.model';
import {BpjsReferralSpecialistModelAudit} from './bpjs_referral_specialist.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Referral Specialist model actions to be dispatched by NgRx.
 */
export enum BpjsReferralSpecialistModelActionTypes {
	CREATE_BPJS_REFERRAL_SPECIALIST = '[ENTITY] Create BpjsReferralSpecialistModel',
	CREATE_BPJS_REFERRAL_SPECIALIST_OK = '[ENTITY] Create BpjsReferralSpecialistModel successfully',
	CREATE_BPJS_REFERRAL_SPECIALIST_FAIL = '[ENTITY] Create BpjsReferralSpecialistModel failed',

	CREATE_ALL_BPJS_REFERRAL_SPECIALIST = '[ENTITY] Create All BpjsReferralSpecialistModel',
	CREATE_ALL_BPJS_REFERRAL_SPECIALIST_OK = '[ENTITY] Create All BpjsReferralSpecialistModel successfully',
	CREATE_ALL_BPJS_REFERRAL_SPECIALIST_FAIL = '[ENTITY] Create All BpjsReferralSpecialistModel failed',

	DELETE_BPJS_REFERRAL_SPECIALIST = '[ENTITY] Delete BpjsReferralSpecialistModel',
	DELETE_BPJS_REFERRAL_SPECIALIST_OK = '[ENTITY] Delete BpjsReferralSpecialistModel successfully',
	DELETE_BPJS_REFERRAL_SPECIALIST_FAIL = '[ENTITY] Delete BpjsReferralSpecialistModel failed',


	DELETE_BPJS_REFERRAL_SPECIALIST_EXCLUDING_IDS = '[ENTITY] Delete BpjsReferralSpecialistModels Excluding Ids',
	DELETE_BPJS_REFERRAL_SPECIALIST_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsReferralSpecialistModels Excluding Ids successfully',
	DELETE_BPJS_REFERRAL_SPECIALIST_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsReferralSpecialistModels Excluding Ids failed',

	DELETE_ALL_BPJS_REFERRAL_SPECIALIST = '[ENTITY] Delete all BpjsReferralSpecialistModels',
	DELETE_ALL_BPJS_REFERRAL_SPECIALIST_OK = '[ENTITY] Delete all BpjsReferralSpecialistModels successfully',
	DELETE_ALL_BPJS_REFERRAL_SPECIALIST_FAIL = '[ENTITY] Delete all BpjsReferralSpecialistModels failed',

	UPDATE_BPJS_REFERRAL_SPECIALIST = '[ENTITY] Update BpjsReferralSpecialistModel',
	UPDATE_BPJS_REFERRAL_SPECIALIST_OK = '[ENTITY] Update BpjsReferralSpecialistModel successfully',
	UPDATE_BPJS_REFERRAL_SPECIALIST_FAIL = '[ENTITY] Update BpjsReferralSpecialistModel failed',

	UPDATE_ALL_BPJS_REFERRAL_SPECIALIST = '[ENTITY] Update all BpjsReferralSpecialistModel',
	UPDATE_ALL_BPJS_REFERRAL_SPECIALIST_OK = '[ENTITY] Update all BpjsReferralSpecialistModel successfully',
	UPDATE_ALL_BPJS_REFERRAL_SPECIALIST_FAIL = '[ENTITY] Update all BpjsReferralSpecialistModel failed',

	FETCH_BPJS_REFERRAL_SPECIALIST= '[ENTITY] Fetch BpjsReferralSpecialistModel',
	FETCH_BPJS_REFERRAL_SPECIALIST_OK = '[ENTITY] Fetch BpjsReferralSpecialistModel successfully',
	FETCH_BPJS_REFERRAL_SPECIALIST_FAIL = '[ENTITY] Fetch BpjsReferralSpecialistModel failed',

	FETCH_BPJS_REFERRAL_SPECIALIST_AUDIT= '[ENTITY] Fetch BpjsReferralSpecialistModel audit',
	FETCH_BPJS_REFERRAL_SPECIALIST_AUDIT_OK = '[ENTITY] Fetch BpjsReferralSpecialistModel audit successfully',
	FETCH_BPJS_REFERRAL_SPECIALIST_AUDIT_FAIL = '[ENTITY] Fetch BpjsReferralSpecialistModel audit failed',

	FETCH_BPJS_REFERRAL_SPECIALIST_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsReferralSpecialistModel audits by entity id',
	FETCH_BPJS_REFERRAL_SPECIALIST_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsReferralSpecialistModel audits by entity id successfully',
	FETCH_BPJS_REFERRAL_SPECIALIST_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsReferralSpecialistModel audits by entity id failed',

	FETCH_ALL_BPJS_REFERRAL_SPECIALIST = '[ENTITY] Fetch all BpjsReferralSpecialistModel',
	FETCH_ALL_BPJS_REFERRAL_SPECIALIST_OK = '[ENTITY] Fetch all BpjsReferralSpecialistModel successfully',
	FETCH_ALL_BPJS_REFERRAL_SPECIALIST_FAIL = '[ENTITY] Fetch all BpjsReferralSpecialistModel failed',

	FETCH_BPJS_REFERRAL_SPECIALIST_WITH_QUERY = '[ENTITY] Fetch BpjsReferralSpecialistModel with query',
	FETCH_BPJS_REFERRAL_SPECIALIST_WITH_QUERY_OK = '[ENTITY] Fetch BpjsReferralSpecialistModel with query successfully',
	FETCH_BPJS_REFERRAL_SPECIALIST_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsReferralSpecialistModel with query failed',

	FETCH_LAST_BPJS_REFERRAL_SPECIALIST_WITH_QUERY = '[ENTITY] Fetch last BpjsReferralSpecialistModel with query',
	FETCH_LAST_BPJS_REFERRAL_SPECIALIST_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsReferralSpecialistModel with query successfully',
	FETCH_LAST_BPJS_REFERRAL_SPECIALIST_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsReferralSpecialistModel with query failed',

	EXPORT_BPJS_REFERRAL_SPECIALIST = '[ENTITY] Export BpjsReferralSpecialistModel',
	EXPORT_BPJS_REFERRAL_SPECIALIST_OK = '[ENTITY] Export BpjsReferralSpecialistModel successfully',
	EXPORT_BPJS_REFERRAL_SPECIALIST_FAIL = '[ENTITY] Export BpjsReferralSpecialistModel failed',

	EXPORT_ALL_BPJS_REFERRAL_SPECIALIST = '[ENTITY] Export All BpjsReferralSpecialistModels',
	EXPORT_ALL_BPJS_REFERRAL_SPECIALIST_OK = '[ENTITY] Export All BpjsReferralSpecialistModels successfully',
	EXPORT_ALL_BPJS_REFERRAL_SPECIALIST_FAIL = '[ENTITY] Export All BpjsReferralSpecialistModels failed',

	EXPORT_BPJS_REFERRAL_SPECIALIST_EXCLUDING_IDS = '[ENTITY] Export BpjsReferralSpecialistModels excluding Ids',
	EXPORT_BPJS_REFERRAL_SPECIALIST_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsReferralSpecialistModel excluding Ids successfully',
	EXPORT_BPJS_REFERRAL_SPECIALIST_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsReferralSpecialistModel excluding Ids failed',

	COUNT_BPJS_REFERRAL_SPECIALISTS = '[ENTITY] Fetch number of BpjsReferralSpecialistModel records',
	COUNT_BPJS_REFERRAL_SPECIALISTS_OK = '[ENTITY] Fetch number of BpjsReferralSpecialistModel records successfully ',
	COUNT_BPJS_REFERRAL_SPECIALISTS_FAIL = '[ENTITY] Fetch number of BpjsReferralSpecialistModel records failed',

	IMPORT_BPJS_REFERRAL_SPECIALISTS = '[ENTITY] Import BpjsReferralSpecialistModels',
	IMPORT_BPJS_REFERRAL_SPECIALISTS_OK = '[ENTITY] Import BpjsReferralSpecialistModels successfully',
	IMPORT_BPJS_REFERRAL_SPECIALISTS_FAIL = '[ENTITY] Import BpjsReferralSpecialistModels fail',


	INITIALISE_BPJS_REFERRAL_SPECIALIST_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsReferralSpecialistModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsReferralSpecialistAction implements Action {
	readonly className: string = 'BpjsReferralSpecialistModel';

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

export class BpjsReferralSpecialistAction extends BaseBpjsReferralSpecialistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsReferralSpecialistAction here] off begin
	// % protected region % [Add any additional class fields for BpjsReferralSpecialistAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsReferralSpecialistModel>,
		// % protected region % [Add any additional constructor parameters for BpjsReferralSpecialistAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsReferralSpecialistAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsReferralSpecialistAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsReferralSpecialistAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsReferralSpecialistAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsReferralSpecialistAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsReferralSpecialistAction here] off begin
	// % protected region % [Add any additional class methods for BpjsReferralSpecialistAction here] end
}

export class BpjsReferralSpecialistActionOK extends BaseBpjsReferralSpecialistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsReferralSpecialistActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsReferralSpecialistActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsReferralSpecialistModel>,
		// % protected region % [Add any additional constructor parameters for BpjsReferralSpecialistActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsReferralSpecialistActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsReferralSpecialistModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsReferralSpecialistActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsReferralSpecialistActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsReferralSpecialistActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsReferralSpecialistActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsReferralSpecialistActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsReferralSpecialistActionOK here] end
}

export class BpjsReferralSpecialistActionFail extends BaseBpjsReferralSpecialistAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsReferralSpecialistActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsReferralSpecialistActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsReferralSpecialistModel>,
		// % protected region % [Add any additional constructor parameters for BpjsReferralSpecialistActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsReferralSpecialistActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsReferralSpecialistActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsReferralSpecialistActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsReferralSpecialistActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsReferralSpecialistActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsReferralSpecialistActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsReferralSpecialistActionFail here] end
}

export function isBpjsReferralSpecialistModelAction(e: any): e is BaseBpjsReferralSpecialistAction {
	return Object.values(BpjsReferralSpecialistModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
