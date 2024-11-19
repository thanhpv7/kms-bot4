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
import {BpjsDrugGenericPRBModel} from './bpjs_drug_generic_prb.model';
import {BpjsDrugGenericPRBModelAudit} from './bpjs_drug_generic_prb.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Drug Generic PRB model actions to be dispatched by NgRx.
 */
export enum BpjsDrugGenericPRBModelActionTypes {
	CREATE_BPJS_DRUG_GENERIC_PRB = '[ENTITY] Create BpjsDrugGenericPRBModel',
	CREATE_BPJS_DRUG_GENERIC_PRB_OK = '[ENTITY] Create BpjsDrugGenericPRBModel successfully',
	CREATE_BPJS_DRUG_GENERIC_PRB_FAIL = '[ENTITY] Create BpjsDrugGenericPRBModel failed',

	CREATE_ALL_BPJS_DRUG_GENERIC_PRB = '[ENTITY] Create All BpjsDrugGenericPRBModel',
	CREATE_ALL_BPJS_DRUG_GENERIC_PRB_OK = '[ENTITY] Create All BpjsDrugGenericPRBModel successfully',
	CREATE_ALL_BPJS_DRUG_GENERIC_PRB_FAIL = '[ENTITY] Create All BpjsDrugGenericPRBModel failed',

	DELETE_BPJS_DRUG_GENERIC_PRB = '[ENTITY] Delete BpjsDrugGenericPRBModel',
	DELETE_BPJS_DRUG_GENERIC_PRB_OK = '[ENTITY] Delete BpjsDrugGenericPRBModel successfully',
	DELETE_BPJS_DRUG_GENERIC_PRB_FAIL = '[ENTITY] Delete BpjsDrugGenericPRBModel failed',


	DELETE_BPJS_DRUG_GENERIC_PRB_EXCLUDING_IDS = '[ENTITY] Delete BpjsDrugGenericPRBModels Excluding Ids',
	DELETE_BPJS_DRUG_GENERIC_PRB_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsDrugGenericPRBModels Excluding Ids successfully',
	DELETE_BPJS_DRUG_GENERIC_PRB_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsDrugGenericPRBModels Excluding Ids failed',

	DELETE_ALL_BPJS_DRUG_GENERIC_PRB = '[ENTITY] Delete all BpjsDrugGenericPRBModels',
	DELETE_ALL_BPJS_DRUG_GENERIC_PRB_OK = '[ENTITY] Delete all BpjsDrugGenericPRBModels successfully',
	DELETE_ALL_BPJS_DRUG_GENERIC_PRB_FAIL = '[ENTITY] Delete all BpjsDrugGenericPRBModels failed',

	UPDATE_BPJS_DRUG_GENERIC_PRB = '[ENTITY] Update BpjsDrugGenericPRBModel',
	UPDATE_BPJS_DRUG_GENERIC_PRB_OK = '[ENTITY] Update BpjsDrugGenericPRBModel successfully',
	UPDATE_BPJS_DRUG_GENERIC_PRB_FAIL = '[ENTITY] Update BpjsDrugGenericPRBModel failed',

	UPDATE_ALL_BPJS_DRUG_GENERIC_PRB = '[ENTITY] Update all BpjsDrugGenericPRBModel',
	UPDATE_ALL_BPJS_DRUG_GENERIC_PRB_OK = '[ENTITY] Update all BpjsDrugGenericPRBModel successfully',
	UPDATE_ALL_BPJS_DRUG_GENERIC_PRB_FAIL = '[ENTITY] Update all BpjsDrugGenericPRBModel failed',

	FETCH_BPJS_DRUG_GENERIC_PRB= '[ENTITY] Fetch BpjsDrugGenericPRBModel',
	FETCH_BPJS_DRUG_GENERIC_PRB_OK = '[ENTITY] Fetch BpjsDrugGenericPRBModel successfully',
	FETCH_BPJS_DRUG_GENERIC_PRB_FAIL = '[ENTITY] Fetch BpjsDrugGenericPRBModel failed',

	FETCH_BPJS_DRUG_GENERIC_PRB_AUDIT= '[ENTITY] Fetch BpjsDrugGenericPRBModel audit',
	FETCH_BPJS_DRUG_GENERIC_PRB_AUDIT_OK = '[ENTITY] Fetch BpjsDrugGenericPRBModel audit successfully',
	FETCH_BPJS_DRUG_GENERIC_PRB_AUDIT_FAIL = '[ENTITY] Fetch BpjsDrugGenericPRBModel audit failed',

	FETCH_BPJS_DRUG_GENERIC_PRB_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsDrugGenericPRBModel audits by entity id',
	FETCH_BPJS_DRUG_GENERIC_PRB_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsDrugGenericPRBModel audits by entity id successfully',
	FETCH_BPJS_DRUG_GENERIC_PRB_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsDrugGenericPRBModel audits by entity id failed',

	FETCH_ALL_BPJS_DRUG_GENERIC_PRB = '[ENTITY] Fetch all BpjsDrugGenericPRBModel',
	FETCH_ALL_BPJS_DRUG_GENERIC_PRB_OK = '[ENTITY] Fetch all BpjsDrugGenericPRBModel successfully',
	FETCH_ALL_BPJS_DRUG_GENERIC_PRB_FAIL = '[ENTITY] Fetch all BpjsDrugGenericPRBModel failed',

	FETCH_BPJS_DRUG_GENERIC_PRB_WITH_QUERY = '[ENTITY] Fetch BpjsDrugGenericPRBModel with query',
	FETCH_BPJS_DRUG_GENERIC_PRB_WITH_QUERY_OK = '[ENTITY] Fetch BpjsDrugGenericPRBModel with query successfully',
	FETCH_BPJS_DRUG_GENERIC_PRB_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsDrugGenericPRBModel with query failed',

	FETCH_LAST_BPJS_DRUG_GENERIC_PRB_WITH_QUERY = '[ENTITY] Fetch last BpjsDrugGenericPRBModel with query',
	FETCH_LAST_BPJS_DRUG_GENERIC_PRB_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsDrugGenericPRBModel with query successfully',
	FETCH_LAST_BPJS_DRUG_GENERIC_PRB_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsDrugGenericPRBModel with query failed',

	EXPORT_BPJS_DRUG_GENERIC_PRB = '[ENTITY] Export BpjsDrugGenericPRBModel',
	EXPORT_BPJS_DRUG_GENERIC_PRB_OK = '[ENTITY] Export BpjsDrugGenericPRBModel successfully',
	EXPORT_BPJS_DRUG_GENERIC_PRB_FAIL = '[ENTITY] Export BpjsDrugGenericPRBModel failed',

	EXPORT_ALL_BPJS_DRUG_GENERIC_PRB = '[ENTITY] Export All BpjsDrugGenericPRBModels',
	EXPORT_ALL_BPJS_DRUG_GENERIC_PRB_OK = '[ENTITY] Export All BpjsDrugGenericPRBModels successfully',
	EXPORT_ALL_BPJS_DRUG_GENERIC_PRB_FAIL = '[ENTITY] Export All BpjsDrugGenericPRBModels failed',

	EXPORT_BPJS_DRUG_GENERIC_PRB_EXCLUDING_IDS = '[ENTITY] Export BpjsDrugGenericPRBModels excluding Ids',
	EXPORT_BPJS_DRUG_GENERIC_PRB_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsDrugGenericPRBModel excluding Ids successfully',
	EXPORT_BPJS_DRUG_GENERIC_PRB_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsDrugGenericPRBModel excluding Ids failed',

	COUNT_BPJS_DRUG_GENERIC_PRBS = '[ENTITY] Fetch number of BpjsDrugGenericPRBModel records',
	COUNT_BPJS_DRUG_GENERIC_PRBS_OK = '[ENTITY] Fetch number of BpjsDrugGenericPRBModel records successfully ',
	COUNT_BPJS_DRUG_GENERIC_PRBS_FAIL = '[ENTITY] Fetch number of BpjsDrugGenericPRBModel records failed',

	IMPORT_BPJS_DRUG_GENERIC_PRBS = '[ENTITY] Import BpjsDrugGenericPRBModels',
	IMPORT_BPJS_DRUG_GENERIC_PRBS_OK = '[ENTITY] Import BpjsDrugGenericPRBModels successfully',
	IMPORT_BPJS_DRUG_GENERIC_PRBS_FAIL = '[ENTITY] Import BpjsDrugGenericPRBModels fail',


	INITIALISE_BPJS_DRUG_GENERIC_PRB_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsDrugGenericPRBModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsDrugGenericPRBAction implements Action {
	readonly className: string = 'BpjsDrugGenericPRBModel';

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

export class BpjsDrugGenericPRBAction extends BaseBpjsDrugGenericPRBAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDrugGenericPRBAction here] off begin
	// % protected region % [Add any additional class fields for BpjsDrugGenericPRBAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDrugGenericPRBModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDrugGenericPRBAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDrugGenericPRBAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDrugGenericPRBAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDrugGenericPRBAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDrugGenericPRBAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDrugGenericPRBAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsDrugGenericPRBAction here] off begin
	// % protected region % [Add any additional class methods for BpjsDrugGenericPRBAction here] end
}

export class BpjsDrugGenericPRBActionOK extends BaseBpjsDrugGenericPRBAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDrugGenericPRBActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsDrugGenericPRBActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsDrugGenericPRBModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDrugGenericPRBActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDrugGenericPRBActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsDrugGenericPRBModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDrugGenericPRBActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDrugGenericPRBActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDrugGenericPRBActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDrugGenericPRBActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsDrugGenericPRBActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsDrugGenericPRBActionOK here] end
}

export class BpjsDrugGenericPRBActionFail extends BaseBpjsDrugGenericPRBAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsDrugGenericPRBActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsDrugGenericPRBActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsDrugGenericPRBModel>,
		// % protected region % [Add any additional constructor parameters for BpjsDrugGenericPRBActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsDrugGenericPRBActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsDrugGenericPRBActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsDrugGenericPRBActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsDrugGenericPRBActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsDrugGenericPRBActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsDrugGenericPRBActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsDrugGenericPRBActionFail here] end
}

export function isBpjsDrugGenericPRBModelAction(e: any): e is BaseBpjsDrugGenericPRBAction {
	return Object.values(BpjsDrugGenericPRBModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
