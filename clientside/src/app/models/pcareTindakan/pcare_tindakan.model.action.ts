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
import {PcareTindakanModel} from './pcare_tindakan.model';
import {PcareTindakanModelAudit} from './pcare_tindakan.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare Tindakan model actions to be dispatched by NgRx.
 */
export enum PcareTindakanModelActionTypes {
	CREATE_PCARE_TINDAKAN = '[ENTITY] Create PcareTindakanModel',
	CREATE_PCARE_TINDAKAN_OK = '[ENTITY] Create PcareTindakanModel successfully',
	CREATE_PCARE_TINDAKAN_FAIL = '[ENTITY] Create PcareTindakanModel failed',

	CREATE_ALL_PCARE_TINDAKAN = '[ENTITY] Create All PcareTindakanModel',
	CREATE_ALL_PCARE_TINDAKAN_OK = '[ENTITY] Create All PcareTindakanModel successfully',
	CREATE_ALL_PCARE_TINDAKAN_FAIL = '[ENTITY] Create All PcareTindakanModel failed',

	DELETE_PCARE_TINDAKAN = '[ENTITY] Delete PcareTindakanModel',
	DELETE_PCARE_TINDAKAN_OK = '[ENTITY] Delete PcareTindakanModel successfully',
	DELETE_PCARE_TINDAKAN_FAIL = '[ENTITY] Delete PcareTindakanModel failed',


	DELETE_PCARE_TINDAKAN_EXCLUDING_IDS = '[ENTITY] Delete PcareTindakanModels Excluding Ids',
	DELETE_PCARE_TINDAKAN_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareTindakanModels Excluding Ids successfully',
	DELETE_PCARE_TINDAKAN_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareTindakanModels Excluding Ids failed',

	DELETE_ALL_PCARE_TINDAKAN = '[ENTITY] Delete all PcareTindakanModels',
	DELETE_ALL_PCARE_TINDAKAN_OK = '[ENTITY] Delete all PcareTindakanModels successfully',
	DELETE_ALL_PCARE_TINDAKAN_FAIL = '[ENTITY] Delete all PcareTindakanModels failed',

	UPDATE_PCARE_TINDAKAN = '[ENTITY] Update PcareTindakanModel',
	UPDATE_PCARE_TINDAKAN_OK = '[ENTITY] Update PcareTindakanModel successfully',
	UPDATE_PCARE_TINDAKAN_FAIL = '[ENTITY] Update PcareTindakanModel failed',

	UPDATE_ALL_PCARE_TINDAKAN = '[ENTITY] Update all PcareTindakanModel',
	UPDATE_ALL_PCARE_TINDAKAN_OK = '[ENTITY] Update all PcareTindakanModel successfully',
	UPDATE_ALL_PCARE_TINDAKAN_FAIL = '[ENTITY] Update all PcareTindakanModel failed',

	FETCH_PCARE_TINDAKAN= '[ENTITY] Fetch PcareTindakanModel',
	FETCH_PCARE_TINDAKAN_OK = '[ENTITY] Fetch PcareTindakanModel successfully',
	FETCH_PCARE_TINDAKAN_FAIL = '[ENTITY] Fetch PcareTindakanModel failed',

	FETCH_PCARE_TINDAKAN_AUDIT= '[ENTITY] Fetch PcareTindakanModel audit',
	FETCH_PCARE_TINDAKAN_AUDIT_OK = '[ENTITY] Fetch PcareTindakanModel audit successfully',
	FETCH_PCARE_TINDAKAN_AUDIT_FAIL = '[ENTITY] Fetch PcareTindakanModel audit failed',

	FETCH_PCARE_TINDAKAN_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareTindakanModel audits by entity id',
	FETCH_PCARE_TINDAKAN_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareTindakanModel audits by entity id successfully',
	FETCH_PCARE_TINDAKAN_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareTindakanModel audits by entity id failed',

	FETCH_ALL_PCARE_TINDAKAN = '[ENTITY] Fetch all PcareTindakanModel',
	FETCH_ALL_PCARE_TINDAKAN_OK = '[ENTITY] Fetch all PcareTindakanModel successfully',
	FETCH_ALL_PCARE_TINDAKAN_FAIL = '[ENTITY] Fetch all PcareTindakanModel failed',

	FETCH_PCARE_TINDAKAN_WITH_QUERY = '[ENTITY] Fetch PcareTindakanModel with query',
	FETCH_PCARE_TINDAKAN_WITH_QUERY_OK = '[ENTITY] Fetch PcareTindakanModel with query successfully',
	FETCH_PCARE_TINDAKAN_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareTindakanModel with query failed',

	FETCH_LAST_PCARE_TINDAKAN_WITH_QUERY = '[ENTITY] Fetch last PcareTindakanModel with query',
	FETCH_LAST_PCARE_TINDAKAN_WITH_QUERY_OK = '[ENTITY] Fetch last PcareTindakanModel with query successfully',
	FETCH_LAST_PCARE_TINDAKAN_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareTindakanModel with query failed',

	EXPORT_PCARE_TINDAKAN = '[ENTITY] Export PcareTindakanModel',
	EXPORT_PCARE_TINDAKAN_OK = '[ENTITY] Export PcareTindakanModel successfully',
	EXPORT_PCARE_TINDAKAN_FAIL = '[ENTITY] Export PcareTindakanModel failed',

	EXPORT_ALL_PCARE_TINDAKAN = '[ENTITY] Export All PcareTindakanModels',
	EXPORT_ALL_PCARE_TINDAKAN_OK = '[ENTITY] Export All PcareTindakanModels successfully',
	EXPORT_ALL_PCARE_TINDAKAN_FAIL = '[ENTITY] Export All PcareTindakanModels failed',

	EXPORT_PCARE_TINDAKAN_EXCLUDING_IDS = '[ENTITY] Export PcareTindakanModels excluding Ids',
	EXPORT_PCARE_TINDAKAN_EXCLUDING_IDS_OK = '[ENTITY] Export PcareTindakanModel excluding Ids successfully',
	EXPORT_PCARE_TINDAKAN_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareTindakanModel excluding Ids failed',

	COUNT_PCARE_TINDAKANS = '[ENTITY] Fetch number of PcareTindakanModel records',
	COUNT_PCARE_TINDAKANS_OK = '[ENTITY] Fetch number of PcareTindakanModel records successfully ',
	COUNT_PCARE_TINDAKANS_FAIL = '[ENTITY] Fetch number of PcareTindakanModel records failed',

	IMPORT_PCARE_TINDAKANS = '[ENTITY] Import PcareTindakanModels',
	IMPORT_PCARE_TINDAKANS_OK = '[ENTITY] Import PcareTindakanModels successfully',
	IMPORT_PCARE_TINDAKANS_FAIL = '[ENTITY] Import PcareTindakanModels fail',


	INITIALISE_PCARE_TINDAKAN_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareTindakanModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareTindakanAction implements Action {
	readonly className: string = 'PcareTindakanModel';

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

export class PcareTindakanAction extends BasePcareTindakanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareTindakanAction here] off begin
	// % protected region % [Add any additional class fields for PcareTindakanAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareTindakanModel>,
		// % protected region % [Add any additional constructor parameters for PcareTindakanAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareTindakanAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareTindakanAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareTindakanAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareTindakanAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareTindakanAction here] end
	}

	// % protected region % [Add any additional class methods for PcareTindakanAction here] off begin
	// % protected region % [Add any additional class methods for PcareTindakanAction here] end
}

export class PcareTindakanActionOK extends BasePcareTindakanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareTindakanActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareTindakanActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareTindakanModel>,
		// % protected region % [Add any additional constructor parameters for PcareTindakanActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareTindakanActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareTindakanModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareTindakanActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareTindakanActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareTindakanActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareTindakanActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareTindakanActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareTindakanActionOK here] end
}

export class PcareTindakanActionFail extends BasePcareTindakanAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareTindakanActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareTindakanActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareTindakanModel>,
		// % protected region % [Add any additional constructor parameters for PcareTindakanActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareTindakanActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareTindakanActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareTindakanActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareTindakanActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareTindakanActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareTindakanActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareTindakanActionFail here] end
}

export function isPcareTindakanModelAction(e: any): e is BasePcareTindakanAction {
	return Object.values(PcareTindakanModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
