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
import {PcareDiagnosaModel} from './pcare_diagnosa.model';
import {PcareDiagnosaModelAudit} from './pcare_diagnosa.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare Diagnosa model actions to be dispatched by NgRx.
 */
export enum PcareDiagnosaModelActionTypes {
	CREATE_PCARE_DIAGNOSA = '[ENTITY] Create PcareDiagnosaModel',
	CREATE_PCARE_DIAGNOSA_OK = '[ENTITY] Create PcareDiagnosaModel successfully',
	CREATE_PCARE_DIAGNOSA_FAIL = '[ENTITY] Create PcareDiagnosaModel failed',

	CREATE_ALL_PCARE_DIAGNOSA = '[ENTITY] Create All PcareDiagnosaModel',
	CREATE_ALL_PCARE_DIAGNOSA_OK = '[ENTITY] Create All PcareDiagnosaModel successfully',
	CREATE_ALL_PCARE_DIAGNOSA_FAIL = '[ENTITY] Create All PcareDiagnosaModel failed',

	DELETE_PCARE_DIAGNOSA = '[ENTITY] Delete PcareDiagnosaModel',
	DELETE_PCARE_DIAGNOSA_OK = '[ENTITY] Delete PcareDiagnosaModel successfully',
	DELETE_PCARE_DIAGNOSA_FAIL = '[ENTITY] Delete PcareDiagnosaModel failed',


	DELETE_PCARE_DIAGNOSA_EXCLUDING_IDS = '[ENTITY] Delete PcareDiagnosaModels Excluding Ids',
	DELETE_PCARE_DIAGNOSA_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareDiagnosaModels Excluding Ids successfully',
	DELETE_PCARE_DIAGNOSA_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareDiagnosaModels Excluding Ids failed',

	DELETE_ALL_PCARE_DIAGNOSA = '[ENTITY] Delete all PcareDiagnosaModels',
	DELETE_ALL_PCARE_DIAGNOSA_OK = '[ENTITY] Delete all PcareDiagnosaModels successfully',
	DELETE_ALL_PCARE_DIAGNOSA_FAIL = '[ENTITY] Delete all PcareDiagnosaModels failed',

	UPDATE_PCARE_DIAGNOSA = '[ENTITY] Update PcareDiagnosaModel',
	UPDATE_PCARE_DIAGNOSA_OK = '[ENTITY] Update PcareDiagnosaModel successfully',
	UPDATE_PCARE_DIAGNOSA_FAIL = '[ENTITY] Update PcareDiagnosaModel failed',

	UPDATE_ALL_PCARE_DIAGNOSA = '[ENTITY] Update all PcareDiagnosaModel',
	UPDATE_ALL_PCARE_DIAGNOSA_OK = '[ENTITY] Update all PcareDiagnosaModel successfully',
	UPDATE_ALL_PCARE_DIAGNOSA_FAIL = '[ENTITY] Update all PcareDiagnosaModel failed',

	FETCH_PCARE_DIAGNOSA= '[ENTITY] Fetch PcareDiagnosaModel',
	FETCH_PCARE_DIAGNOSA_OK = '[ENTITY] Fetch PcareDiagnosaModel successfully',
	FETCH_PCARE_DIAGNOSA_FAIL = '[ENTITY] Fetch PcareDiagnosaModel failed',

	FETCH_PCARE_DIAGNOSA_AUDIT= '[ENTITY] Fetch PcareDiagnosaModel audit',
	FETCH_PCARE_DIAGNOSA_AUDIT_OK = '[ENTITY] Fetch PcareDiagnosaModel audit successfully',
	FETCH_PCARE_DIAGNOSA_AUDIT_FAIL = '[ENTITY] Fetch PcareDiagnosaModel audit failed',

	FETCH_PCARE_DIAGNOSA_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareDiagnosaModel audits by entity id',
	FETCH_PCARE_DIAGNOSA_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareDiagnosaModel audits by entity id successfully',
	FETCH_PCARE_DIAGNOSA_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareDiagnosaModel audits by entity id failed',

	FETCH_ALL_PCARE_DIAGNOSA = '[ENTITY] Fetch all PcareDiagnosaModel',
	FETCH_ALL_PCARE_DIAGNOSA_OK = '[ENTITY] Fetch all PcareDiagnosaModel successfully',
	FETCH_ALL_PCARE_DIAGNOSA_FAIL = '[ENTITY] Fetch all PcareDiagnosaModel failed',

	FETCH_PCARE_DIAGNOSA_WITH_QUERY = '[ENTITY] Fetch PcareDiagnosaModel with query',
	FETCH_PCARE_DIAGNOSA_WITH_QUERY_OK = '[ENTITY] Fetch PcareDiagnosaModel with query successfully',
	FETCH_PCARE_DIAGNOSA_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareDiagnosaModel with query failed',

	FETCH_LAST_PCARE_DIAGNOSA_WITH_QUERY = '[ENTITY] Fetch last PcareDiagnosaModel with query',
	FETCH_LAST_PCARE_DIAGNOSA_WITH_QUERY_OK = '[ENTITY] Fetch last PcareDiagnosaModel with query successfully',
	FETCH_LAST_PCARE_DIAGNOSA_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareDiagnosaModel with query failed',

	EXPORT_PCARE_DIAGNOSA = '[ENTITY] Export PcareDiagnosaModel',
	EXPORT_PCARE_DIAGNOSA_OK = '[ENTITY] Export PcareDiagnosaModel successfully',
	EXPORT_PCARE_DIAGNOSA_FAIL = '[ENTITY] Export PcareDiagnosaModel failed',

	EXPORT_ALL_PCARE_DIAGNOSA = '[ENTITY] Export All PcareDiagnosaModels',
	EXPORT_ALL_PCARE_DIAGNOSA_OK = '[ENTITY] Export All PcareDiagnosaModels successfully',
	EXPORT_ALL_PCARE_DIAGNOSA_FAIL = '[ENTITY] Export All PcareDiagnosaModels failed',

	EXPORT_PCARE_DIAGNOSA_EXCLUDING_IDS = '[ENTITY] Export PcareDiagnosaModels excluding Ids',
	EXPORT_PCARE_DIAGNOSA_EXCLUDING_IDS_OK = '[ENTITY] Export PcareDiagnosaModel excluding Ids successfully',
	EXPORT_PCARE_DIAGNOSA_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareDiagnosaModel excluding Ids failed',

	COUNT_PCARE_DIAGNOSAS = '[ENTITY] Fetch number of PcareDiagnosaModel records',
	COUNT_PCARE_DIAGNOSAS_OK = '[ENTITY] Fetch number of PcareDiagnosaModel records successfully ',
	COUNT_PCARE_DIAGNOSAS_FAIL = '[ENTITY] Fetch number of PcareDiagnosaModel records failed',

	IMPORT_PCARE_DIAGNOSAS = '[ENTITY] Import PcareDiagnosaModels',
	IMPORT_PCARE_DIAGNOSAS_OK = '[ENTITY] Import PcareDiagnosaModels successfully',
	IMPORT_PCARE_DIAGNOSAS_FAIL = '[ENTITY] Import PcareDiagnosaModels fail',


	INITIALISE_PCARE_DIAGNOSA_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareDiagnosaModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareDiagnosaAction implements Action {
	readonly className: string = 'PcareDiagnosaModel';

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

export class PcareDiagnosaAction extends BasePcareDiagnosaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareDiagnosaAction here] off begin
	// % protected region % [Add any additional class fields for PcareDiagnosaAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareDiagnosaModel>,
		// % protected region % [Add any additional constructor parameters for PcareDiagnosaAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareDiagnosaAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareDiagnosaAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareDiagnosaAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareDiagnosaAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareDiagnosaAction here] end
	}

	// % protected region % [Add any additional class methods for PcareDiagnosaAction here] off begin
	// % protected region % [Add any additional class methods for PcareDiagnosaAction here] end
}

export class PcareDiagnosaActionOK extends BasePcareDiagnosaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareDiagnosaActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareDiagnosaActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareDiagnosaModel>,
		// % protected region % [Add any additional constructor parameters for PcareDiagnosaActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareDiagnosaActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareDiagnosaModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareDiagnosaActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareDiagnosaActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareDiagnosaActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareDiagnosaActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareDiagnosaActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareDiagnosaActionOK here] end
}

export class PcareDiagnosaActionFail extends BasePcareDiagnosaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareDiagnosaActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareDiagnosaActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareDiagnosaModel>,
		// % protected region % [Add any additional constructor parameters for PcareDiagnosaActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareDiagnosaActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareDiagnosaActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareDiagnosaActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareDiagnosaActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareDiagnosaActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareDiagnosaActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareDiagnosaActionFail here] end
}

export function isPcareDiagnosaModelAction(e: any): e is BasePcareDiagnosaAction {
	return Object.values(PcareDiagnosaModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
