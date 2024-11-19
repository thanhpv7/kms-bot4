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
import {PcareMCUModel} from './pcare_mcu.model';
import {PcareMCUModelAudit} from './pcare_mcu.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare MCU model actions to be dispatched by NgRx.
 */
export enum PcareMCUModelActionTypes {
	CREATE_PCARE_MCU = '[ENTITY] Create PcareMCUModel',
	CREATE_PCARE_MCU_OK = '[ENTITY] Create PcareMCUModel successfully',
	CREATE_PCARE_MCU_FAIL = '[ENTITY] Create PcareMCUModel failed',

	CREATE_ALL_PCARE_MCU = '[ENTITY] Create All PcareMCUModel',
	CREATE_ALL_PCARE_MCU_OK = '[ENTITY] Create All PcareMCUModel successfully',
	CREATE_ALL_PCARE_MCU_FAIL = '[ENTITY] Create All PcareMCUModel failed',

	DELETE_PCARE_MCU = '[ENTITY] Delete PcareMCUModel',
	DELETE_PCARE_MCU_OK = '[ENTITY] Delete PcareMCUModel successfully',
	DELETE_PCARE_MCU_FAIL = '[ENTITY] Delete PcareMCUModel failed',


	DELETE_PCARE_MCU_EXCLUDING_IDS = '[ENTITY] Delete PcareMCUModels Excluding Ids',
	DELETE_PCARE_MCU_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareMCUModels Excluding Ids successfully',
	DELETE_PCARE_MCU_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareMCUModels Excluding Ids failed',

	DELETE_ALL_PCARE_MCU = '[ENTITY] Delete all PcareMCUModels',
	DELETE_ALL_PCARE_MCU_OK = '[ENTITY] Delete all PcareMCUModels successfully',
	DELETE_ALL_PCARE_MCU_FAIL = '[ENTITY] Delete all PcareMCUModels failed',

	UPDATE_PCARE_MCU = '[ENTITY] Update PcareMCUModel',
	UPDATE_PCARE_MCU_OK = '[ENTITY] Update PcareMCUModel successfully',
	UPDATE_PCARE_MCU_FAIL = '[ENTITY] Update PcareMCUModel failed',

	UPDATE_ALL_PCARE_MCU = '[ENTITY] Update all PcareMCUModel',
	UPDATE_ALL_PCARE_MCU_OK = '[ENTITY] Update all PcareMCUModel successfully',
	UPDATE_ALL_PCARE_MCU_FAIL = '[ENTITY] Update all PcareMCUModel failed',

	FETCH_PCARE_MCU= '[ENTITY] Fetch PcareMCUModel',
	FETCH_PCARE_MCU_OK = '[ENTITY] Fetch PcareMCUModel successfully',
	FETCH_PCARE_MCU_FAIL = '[ENTITY] Fetch PcareMCUModel failed',

	FETCH_PCARE_MCU_AUDIT= '[ENTITY] Fetch PcareMCUModel audit',
	FETCH_PCARE_MCU_AUDIT_OK = '[ENTITY] Fetch PcareMCUModel audit successfully',
	FETCH_PCARE_MCU_AUDIT_FAIL = '[ENTITY] Fetch PcareMCUModel audit failed',

	FETCH_PCARE_MCU_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareMCUModel audits by entity id',
	FETCH_PCARE_MCU_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareMCUModel audits by entity id successfully',
	FETCH_PCARE_MCU_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareMCUModel audits by entity id failed',

	FETCH_ALL_PCARE_MCU = '[ENTITY] Fetch all PcareMCUModel',
	FETCH_ALL_PCARE_MCU_OK = '[ENTITY] Fetch all PcareMCUModel successfully',
	FETCH_ALL_PCARE_MCU_FAIL = '[ENTITY] Fetch all PcareMCUModel failed',

	FETCH_PCARE_MCU_WITH_QUERY = '[ENTITY] Fetch PcareMCUModel with query',
	FETCH_PCARE_MCU_WITH_QUERY_OK = '[ENTITY] Fetch PcareMCUModel with query successfully',
	FETCH_PCARE_MCU_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareMCUModel with query failed',

	FETCH_LAST_PCARE_MCU_WITH_QUERY = '[ENTITY] Fetch last PcareMCUModel with query',
	FETCH_LAST_PCARE_MCU_WITH_QUERY_OK = '[ENTITY] Fetch last PcareMCUModel with query successfully',
	FETCH_LAST_PCARE_MCU_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareMCUModel with query failed',

	EXPORT_PCARE_MCU = '[ENTITY] Export PcareMCUModel',
	EXPORT_PCARE_MCU_OK = '[ENTITY] Export PcareMCUModel successfully',
	EXPORT_PCARE_MCU_FAIL = '[ENTITY] Export PcareMCUModel failed',

	EXPORT_ALL_PCARE_MCU = '[ENTITY] Export All PcareMCUModels',
	EXPORT_ALL_PCARE_MCU_OK = '[ENTITY] Export All PcareMCUModels successfully',
	EXPORT_ALL_PCARE_MCU_FAIL = '[ENTITY] Export All PcareMCUModels failed',

	EXPORT_PCARE_MCU_EXCLUDING_IDS = '[ENTITY] Export PcareMCUModels excluding Ids',
	EXPORT_PCARE_MCU_EXCLUDING_IDS_OK = '[ENTITY] Export PcareMCUModel excluding Ids successfully',
	EXPORT_PCARE_MCU_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareMCUModel excluding Ids failed',

	COUNT_PCARE_MCUS = '[ENTITY] Fetch number of PcareMCUModel records',
	COUNT_PCARE_MCUS_OK = '[ENTITY] Fetch number of PcareMCUModel records successfully ',
	COUNT_PCARE_MCUS_FAIL = '[ENTITY] Fetch number of PcareMCUModel records failed',

	IMPORT_PCARE_MCUS = '[ENTITY] Import PcareMCUModels',
	IMPORT_PCARE_MCUS_OK = '[ENTITY] Import PcareMCUModels successfully',
	IMPORT_PCARE_MCUS_FAIL = '[ENTITY] Import PcareMCUModels fail',


	INITIALISE_PCARE_MCU_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareMCUModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareMCUAction implements Action {
	readonly className: string = 'PcareMCUModel';

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

export class PcareMCUAction extends BasePcareMCUAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareMCUAction here] off begin
	// % protected region % [Add any additional class fields for PcareMCUAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareMCUModel>,
		// % protected region % [Add any additional constructor parameters for PcareMCUAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareMCUAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareMCUAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareMCUAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareMCUAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareMCUAction here] end
	}

	// % protected region % [Add any additional class methods for PcareMCUAction here] off begin
	// % protected region % [Add any additional class methods for PcareMCUAction here] end
}

export class PcareMCUActionOK extends BasePcareMCUAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareMCUActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareMCUActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareMCUModel>,
		// % protected region % [Add any additional constructor parameters for PcareMCUActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareMCUActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareMCUModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareMCUActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareMCUActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareMCUActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareMCUActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareMCUActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareMCUActionOK here] end
}

export class PcareMCUActionFail extends BasePcareMCUAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareMCUActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareMCUActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareMCUModel>,
		// % protected region % [Add any additional constructor parameters for PcareMCUActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareMCUActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareMCUActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareMCUActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareMCUActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareMCUActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareMCUActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareMCUActionFail here] end
}

export function isPcareMCUModelAction(e: any): e is BasePcareMCUAction {
	return Object.values(PcareMCUModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
