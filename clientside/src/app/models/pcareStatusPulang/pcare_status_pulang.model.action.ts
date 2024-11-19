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
import {PcareStatusPulangModel} from './pcare_status_pulang.model';
import {PcareStatusPulangModelAudit} from './pcare_status_pulang.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare Status Pulang model actions to be dispatched by NgRx.
 */
export enum PcareStatusPulangModelActionTypes {
	CREATE_PCARE_STATUS_PULANG = '[ENTITY] Create PcareStatusPulangModel',
	CREATE_PCARE_STATUS_PULANG_OK = '[ENTITY] Create PcareStatusPulangModel successfully',
	CREATE_PCARE_STATUS_PULANG_FAIL = '[ENTITY] Create PcareStatusPulangModel failed',

	CREATE_ALL_PCARE_STATUS_PULANG = '[ENTITY] Create All PcareStatusPulangModel',
	CREATE_ALL_PCARE_STATUS_PULANG_OK = '[ENTITY] Create All PcareStatusPulangModel successfully',
	CREATE_ALL_PCARE_STATUS_PULANG_FAIL = '[ENTITY] Create All PcareStatusPulangModel failed',

	DELETE_PCARE_STATUS_PULANG = '[ENTITY] Delete PcareStatusPulangModel',
	DELETE_PCARE_STATUS_PULANG_OK = '[ENTITY] Delete PcareStatusPulangModel successfully',
	DELETE_PCARE_STATUS_PULANG_FAIL = '[ENTITY] Delete PcareStatusPulangModel failed',


	DELETE_PCARE_STATUS_PULANG_EXCLUDING_IDS = '[ENTITY] Delete PcareStatusPulangModels Excluding Ids',
	DELETE_PCARE_STATUS_PULANG_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareStatusPulangModels Excluding Ids successfully',
	DELETE_PCARE_STATUS_PULANG_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareStatusPulangModels Excluding Ids failed',

	DELETE_ALL_PCARE_STATUS_PULANG = '[ENTITY] Delete all PcareStatusPulangModels',
	DELETE_ALL_PCARE_STATUS_PULANG_OK = '[ENTITY] Delete all PcareStatusPulangModels successfully',
	DELETE_ALL_PCARE_STATUS_PULANG_FAIL = '[ENTITY] Delete all PcareStatusPulangModels failed',

	UPDATE_PCARE_STATUS_PULANG = '[ENTITY] Update PcareStatusPulangModel',
	UPDATE_PCARE_STATUS_PULANG_OK = '[ENTITY] Update PcareStatusPulangModel successfully',
	UPDATE_PCARE_STATUS_PULANG_FAIL = '[ENTITY] Update PcareStatusPulangModel failed',

	UPDATE_ALL_PCARE_STATUS_PULANG = '[ENTITY] Update all PcareStatusPulangModel',
	UPDATE_ALL_PCARE_STATUS_PULANG_OK = '[ENTITY] Update all PcareStatusPulangModel successfully',
	UPDATE_ALL_PCARE_STATUS_PULANG_FAIL = '[ENTITY] Update all PcareStatusPulangModel failed',

	FETCH_PCARE_STATUS_PULANG= '[ENTITY] Fetch PcareStatusPulangModel',
	FETCH_PCARE_STATUS_PULANG_OK = '[ENTITY] Fetch PcareStatusPulangModel successfully',
	FETCH_PCARE_STATUS_PULANG_FAIL = '[ENTITY] Fetch PcareStatusPulangModel failed',

	FETCH_PCARE_STATUS_PULANG_AUDIT= '[ENTITY] Fetch PcareStatusPulangModel audit',
	FETCH_PCARE_STATUS_PULANG_AUDIT_OK = '[ENTITY] Fetch PcareStatusPulangModel audit successfully',
	FETCH_PCARE_STATUS_PULANG_AUDIT_FAIL = '[ENTITY] Fetch PcareStatusPulangModel audit failed',

	FETCH_PCARE_STATUS_PULANG_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareStatusPulangModel audits by entity id',
	FETCH_PCARE_STATUS_PULANG_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareStatusPulangModel audits by entity id successfully',
	FETCH_PCARE_STATUS_PULANG_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareStatusPulangModel audits by entity id failed',

	FETCH_ALL_PCARE_STATUS_PULANG = '[ENTITY] Fetch all PcareStatusPulangModel',
	FETCH_ALL_PCARE_STATUS_PULANG_OK = '[ENTITY] Fetch all PcareStatusPulangModel successfully',
	FETCH_ALL_PCARE_STATUS_PULANG_FAIL = '[ENTITY] Fetch all PcareStatusPulangModel failed',

	FETCH_PCARE_STATUS_PULANG_WITH_QUERY = '[ENTITY] Fetch PcareStatusPulangModel with query',
	FETCH_PCARE_STATUS_PULANG_WITH_QUERY_OK = '[ENTITY] Fetch PcareStatusPulangModel with query successfully',
	FETCH_PCARE_STATUS_PULANG_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareStatusPulangModel with query failed',

	FETCH_LAST_PCARE_STATUS_PULANG_WITH_QUERY = '[ENTITY] Fetch last PcareStatusPulangModel with query',
	FETCH_LAST_PCARE_STATUS_PULANG_WITH_QUERY_OK = '[ENTITY] Fetch last PcareStatusPulangModel with query successfully',
	FETCH_LAST_PCARE_STATUS_PULANG_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareStatusPulangModel with query failed',

	EXPORT_PCARE_STATUS_PULANG = '[ENTITY] Export PcareStatusPulangModel',
	EXPORT_PCARE_STATUS_PULANG_OK = '[ENTITY] Export PcareStatusPulangModel successfully',
	EXPORT_PCARE_STATUS_PULANG_FAIL = '[ENTITY] Export PcareStatusPulangModel failed',

	EXPORT_ALL_PCARE_STATUS_PULANG = '[ENTITY] Export All PcareStatusPulangModels',
	EXPORT_ALL_PCARE_STATUS_PULANG_OK = '[ENTITY] Export All PcareStatusPulangModels successfully',
	EXPORT_ALL_PCARE_STATUS_PULANG_FAIL = '[ENTITY] Export All PcareStatusPulangModels failed',

	EXPORT_PCARE_STATUS_PULANG_EXCLUDING_IDS = '[ENTITY] Export PcareStatusPulangModels excluding Ids',
	EXPORT_PCARE_STATUS_PULANG_EXCLUDING_IDS_OK = '[ENTITY] Export PcareStatusPulangModel excluding Ids successfully',
	EXPORT_PCARE_STATUS_PULANG_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareStatusPulangModel excluding Ids failed',

	COUNT_PCARE_STATUS_PULANGS = '[ENTITY] Fetch number of PcareStatusPulangModel records',
	COUNT_PCARE_STATUS_PULANGS_OK = '[ENTITY] Fetch number of PcareStatusPulangModel records successfully ',
	COUNT_PCARE_STATUS_PULANGS_FAIL = '[ENTITY] Fetch number of PcareStatusPulangModel records failed',

	IMPORT_PCARE_STATUS_PULANGS = '[ENTITY] Import PcareStatusPulangModels',
	IMPORT_PCARE_STATUS_PULANGS_OK = '[ENTITY] Import PcareStatusPulangModels successfully',
	IMPORT_PCARE_STATUS_PULANGS_FAIL = '[ENTITY] Import PcareStatusPulangModels fail',


	INITIALISE_PCARE_STATUS_PULANG_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareStatusPulangModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareStatusPulangAction implements Action {
	readonly className: string = 'PcareStatusPulangModel';

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

export class PcareStatusPulangAction extends BasePcareStatusPulangAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareStatusPulangAction here] off begin
	// % protected region % [Add any additional class fields for PcareStatusPulangAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareStatusPulangModel>,
		// % protected region % [Add any additional constructor parameters for PcareStatusPulangAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareStatusPulangAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareStatusPulangAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareStatusPulangAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareStatusPulangAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareStatusPulangAction here] end
	}

	// % protected region % [Add any additional class methods for PcareStatusPulangAction here] off begin
	// % protected region % [Add any additional class methods for PcareStatusPulangAction here] end
}

export class PcareStatusPulangActionOK extends BasePcareStatusPulangAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareStatusPulangActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareStatusPulangActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareStatusPulangModel>,
		// % protected region % [Add any additional constructor parameters for PcareStatusPulangActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareStatusPulangActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareStatusPulangModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareStatusPulangActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareStatusPulangActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareStatusPulangActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareStatusPulangActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareStatusPulangActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareStatusPulangActionOK here] end
}

export class PcareStatusPulangActionFail extends BasePcareStatusPulangAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareStatusPulangActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareStatusPulangActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareStatusPulangModel>,
		// % protected region % [Add any additional constructor parameters for PcareStatusPulangActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareStatusPulangActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareStatusPulangActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareStatusPulangActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareStatusPulangActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareStatusPulangActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareStatusPulangActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareStatusPulangActionFail here] end
}

export function isPcareStatusPulangModelAction(e: any): e is BasePcareStatusPulangAction {
	return Object.values(PcareStatusPulangModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
