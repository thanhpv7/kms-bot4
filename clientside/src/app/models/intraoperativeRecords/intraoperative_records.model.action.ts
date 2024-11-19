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
import {IntraoperativeRecordsModel} from './intraoperative_records.model';
import {IntraoperativeRecordsModelAudit} from './intraoperative_records.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Intraoperative Records model actions to be dispatched by NgRx.
 */
export enum IntraoperativeRecordsModelActionTypes {
	CREATE_INTRAOPERATIVE_RECORDS = '[ENTITY] Create IntraoperativeRecordsModel',
	CREATE_INTRAOPERATIVE_RECORDS_OK = '[ENTITY] Create IntraoperativeRecordsModel successfully',
	CREATE_INTRAOPERATIVE_RECORDS_FAIL = '[ENTITY] Create IntraoperativeRecordsModel failed',

	CREATE_ALL_INTRAOPERATIVE_RECORDS = '[ENTITY] Create All IntraoperativeRecordsModel',
	CREATE_ALL_INTRAOPERATIVE_RECORDS_OK = '[ENTITY] Create All IntraoperativeRecordsModel successfully',
	CREATE_ALL_INTRAOPERATIVE_RECORDS_FAIL = '[ENTITY] Create All IntraoperativeRecordsModel failed',

	DELETE_INTRAOPERATIVE_RECORDS = '[ENTITY] Delete IntraoperativeRecordsModel',
	DELETE_INTRAOPERATIVE_RECORDS_OK = '[ENTITY] Delete IntraoperativeRecordsModel successfully',
	DELETE_INTRAOPERATIVE_RECORDS_FAIL = '[ENTITY] Delete IntraoperativeRecordsModel failed',


	DELETE_INTRAOPERATIVE_RECORDS_EXCLUDING_IDS = '[ENTITY] Delete IntraoperativeRecordsModels Excluding Ids',
	DELETE_INTRAOPERATIVE_RECORDS_EXCLUDING_IDS_OK = '[ENTITY] Delete IntraoperativeRecordsModels Excluding Ids successfully',
	DELETE_INTRAOPERATIVE_RECORDS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete IntraoperativeRecordsModels Excluding Ids failed',

	DELETE_ALL_INTRAOPERATIVE_RECORDS = '[ENTITY] Delete all IntraoperativeRecordsModels',
	DELETE_ALL_INTRAOPERATIVE_RECORDS_OK = '[ENTITY] Delete all IntraoperativeRecordsModels successfully',
	DELETE_ALL_INTRAOPERATIVE_RECORDS_FAIL = '[ENTITY] Delete all IntraoperativeRecordsModels failed',

	UPDATE_INTRAOPERATIVE_RECORDS = '[ENTITY] Update IntraoperativeRecordsModel',
	UPDATE_INTRAOPERATIVE_RECORDS_OK = '[ENTITY] Update IntraoperativeRecordsModel successfully',
	UPDATE_INTRAOPERATIVE_RECORDS_FAIL = '[ENTITY] Update IntraoperativeRecordsModel failed',

	UPDATE_ALL_INTRAOPERATIVE_RECORDS = '[ENTITY] Update all IntraoperativeRecordsModel',
	UPDATE_ALL_INTRAOPERATIVE_RECORDS_OK = '[ENTITY] Update all IntraoperativeRecordsModel successfully',
	UPDATE_ALL_INTRAOPERATIVE_RECORDS_FAIL = '[ENTITY] Update all IntraoperativeRecordsModel failed',

	FETCH_INTRAOPERATIVE_RECORDS= '[ENTITY] Fetch IntraoperativeRecordsModel',
	FETCH_INTRAOPERATIVE_RECORDS_OK = '[ENTITY] Fetch IntraoperativeRecordsModel successfully',
	FETCH_INTRAOPERATIVE_RECORDS_FAIL = '[ENTITY] Fetch IntraoperativeRecordsModel failed',

	FETCH_INTRAOPERATIVE_RECORDS_AUDIT= '[ENTITY] Fetch IntraoperativeRecordsModel audit',
	FETCH_INTRAOPERATIVE_RECORDS_AUDIT_OK = '[ENTITY] Fetch IntraoperativeRecordsModel audit successfully',
	FETCH_INTRAOPERATIVE_RECORDS_AUDIT_FAIL = '[ENTITY] Fetch IntraoperativeRecordsModel audit failed',

	FETCH_INTRAOPERATIVE_RECORDS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch IntraoperativeRecordsModel audits by entity id',
	FETCH_INTRAOPERATIVE_RECORDS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch IntraoperativeRecordsModel audits by entity id successfully',
	FETCH_INTRAOPERATIVE_RECORDS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch IntraoperativeRecordsModel audits by entity id failed',

	FETCH_ALL_INTRAOPERATIVE_RECORDS = '[ENTITY] Fetch all IntraoperativeRecordsModel',
	FETCH_ALL_INTRAOPERATIVE_RECORDS_OK = '[ENTITY] Fetch all IntraoperativeRecordsModel successfully',
	FETCH_ALL_INTRAOPERATIVE_RECORDS_FAIL = '[ENTITY] Fetch all IntraoperativeRecordsModel failed',

	FETCH_INTRAOPERATIVE_RECORDS_WITH_QUERY = '[ENTITY] Fetch IntraoperativeRecordsModel with query',
	FETCH_INTRAOPERATIVE_RECORDS_WITH_QUERY_OK = '[ENTITY] Fetch IntraoperativeRecordsModel with query successfully',
	FETCH_INTRAOPERATIVE_RECORDS_WITH_QUERY_FAIL = '[ENTITY] Fetch IntraoperativeRecordsModel with query failed',

	FETCH_LAST_INTRAOPERATIVE_RECORDS_WITH_QUERY = '[ENTITY] Fetch last IntraoperativeRecordsModel with query',
	FETCH_LAST_INTRAOPERATIVE_RECORDS_WITH_QUERY_OK = '[ENTITY] Fetch last IntraoperativeRecordsModel with query successfully',
	FETCH_LAST_INTRAOPERATIVE_RECORDS_WITH_QUERY_FAIL = '[ENTITY] Fetch last IntraoperativeRecordsModel with query failed',

	EXPORT_INTRAOPERATIVE_RECORDS = '[ENTITY] Export IntraoperativeRecordsModel',
	EXPORT_INTRAOPERATIVE_RECORDS_OK = '[ENTITY] Export IntraoperativeRecordsModel successfully',
	EXPORT_INTRAOPERATIVE_RECORDS_FAIL = '[ENTITY] Export IntraoperativeRecordsModel failed',

	EXPORT_ALL_INTRAOPERATIVE_RECORDS = '[ENTITY] Export All IntraoperativeRecordsModels',
	EXPORT_ALL_INTRAOPERATIVE_RECORDS_OK = '[ENTITY] Export All IntraoperativeRecordsModels successfully',
	EXPORT_ALL_INTRAOPERATIVE_RECORDS_FAIL = '[ENTITY] Export All IntraoperativeRecordsModels failed',

	EXPORT_INTRAOPERATIVE_RECORDS_EXCLUDING_IDS = '[ENTITY] Export IntraoperativeRecordsModels excluding Ids',
	EXPORT_INTRAOPERATIVE_RECORDS_EXCLUDING_IDS_OK = '[ENTITY] Export IntraoperativeRecordsModel excluding Ids successfully',
	EXPORT_INTRAOPERATIVE_RECORDS_EXCLUDING_IDS_FAIL = '[ENTITY] Export IntraoperativeRecordsModel excluding Ids failed',

	COUNT_INTRAOPERATIVE_RECORDSS = '[ENTITY] Fetch number of IntraoperativeRecordsModel records',
	COUNT_INTRAOPERATIVE_RECORDSS_OK = '[ENTITY] Fetch number of IntraoperativeRecordsModel records successfully ',
	COUNT_INTRAOPERATIVE_RECORDSS_FAIL = '[ENTITY] Fetch number of IntraoperativeRecordsModel records failed',

	IMPORT_INTRAOPERATIVE_RECORDSS = '[ENTITY] Import IntraoperativeRecordsModels',
	IMPORT_INTRAOPERATIVE_RECORDSS_OK = '[ENTITY] Import IntraoperativeRecordsModels successfully',
	IMPORT_INTRAOPERATIVE_RECORDSS_FAIL = '[ENTITY] Import IntraoperativeRecordsModels fail',


	INITIALISE_INTRAOPERATIVE_RECORDS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of IntraoperativeRecordsModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseIntraoperativeRecordsAction implements Action {
	readonly className: string = 'IntraoperativeRecordsModel';

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

export class IntraoperativeRecordsAction extends BaseIntraoperativeRecordsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for IntraoperativeRecordsAction here] off begin
	// % protected region % [Add any additional class fields for IntraoperativeRecordsAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<IntraoperativeRecordsModel>,
		// % protected region % [Add any additional constructor parameters for IntraoperativeRecordsAction here] off begin
		// % protected region % [Add any additional constructor parameters for IntraoperativeRecordsAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for IntraoperativeRecordsAction here] off begin
			// % protected region % [Add any additional constructor arguments for IntraoperativeRecordsAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for IntraoperativeRecordsAction here] off begin
		// % protected region % [Add any additional constructor logic for IntraoperativeRecordsAction here] end
	}

	// % protected region % [Add any additional class methods for IntraoperativeRecordsAction here] off begin
	// % protected region % [Add any additional class methods for IntraoperativeRecordsAction here] end
}

export class IntraoperativeRecordsActionOK extends BaseIntraoperativeRecordsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for IntraoperativeRecordsActionOK here] off begin
	// % protected region % [Add any additional class fields for IntraoperativeRecordsActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<IntraoperativeRecordsModel>,
		// % protected region % [Add any additional constructor parameters for IntraoperativeRecordsActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for IntraoperativeRecordsActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: IntraoperativeRecordsModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for IntraoperativeRecordsActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for IntraoperativeRecordsActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for IntraoperativeRecordsActionOK here] off begin
		// % protected region % [Add any additional constructor logic for IntraoperativeRecordsActionOK here] end
	}

	// % protected region % [Add any additional class methods for IntraoperativeRecordsActionOK here] off begin
	// % protected region % [Add any additional class methods for IntraoperativeRecordsActionOK here] end
}

export class IntraoperativeRecordsActionFail extends BaseIntraoperativeRecordsAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for IntraoperativeRecordsActionFail here] off begin
	// % protected region % [Add any additional class fields for IntraoperativeRecordsActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<IntraoperativeRecordsModel>,
		// % protected region % [Add any additional constructor parameters for IntraoperativeRecordsActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for IntraoperativeRecordsActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for IntraoperativeRecordsActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for IntraoperativeRecordsActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for IntraoperativeRecordsActionFail here] off begin
		// % protected region % [Add any additional constructor logic for IntraoperativeRecordsActionFail here] end
	}

	// % protected region % [Add any additional class methods for IntraoperativeRecordsActionFail here] off begin
	// % protected region % [Add any additional class methods for IntraoperativeRecordsActionFail here] end
}

export function isIntraoperativeRecordsModelAction(e: any): e is BaseIntraoperativeRecordsAction {
	return Object.values(IntraoperativeRecordsModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
