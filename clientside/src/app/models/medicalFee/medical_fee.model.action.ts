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
import {MedicalFeeModel} from './medical_fee.model';
import {MedicalFeeModelAudit} from './medical_fee.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Fee model actions to be dispatched by NgRx.
 */
export enum MedicalFeeModelActionTypes {
	CREATE_MEDICAL_FEE = '[ENTITY] Create MedicalFeeModel',
	CREATE_MEDICAL_FEE_OK = '[ENTITY] Create MedicalFeeModel successfully',
	CREATE_MEDICAL_FEE_FAIL = '[ENTITY] Create MedicalFeeModel failed',

	CREATE_ALL_MEDICAL_FEE = '[ENTITY] Create All MedicalFeeModel',
	CREATE_ALL_MEDICAL_FEE_OK = '[ENTITY] Create All MedicalFeeModel successfully',
	CREATE_ALL_MEDICAL_FEE_FAIL = '[ENTITY] Create All MedicalFeeModel failed',

	DELETE_MEDICAL_FEE = '[ENTITY] Delete MedicalFeeModel',
	DELETE_MEDICAL_FEE_OK = '[ENTITY] Delete MedicalFeeModel successfully',
	DELETE_MEDICAL_FEE_FAIL = '[ENTITY] Delete MedicalFeeModel failed',


	DELETE_MEDICAL_FEE_EXCLUDING_IDS = '[ENTITY] Delete MedicalFeeModels Excluding Ids',
	DELETE_MEDICAL_FEE_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalFeeModels Excluding Ids successfully',
	DELETE_MEDICAL_FEE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalFeeModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_FEE = '[ENTITY] Delete all MedicalFeeModels',
	DELETE_ALL_MEDICAL_FEE_OK = '[ENTITY] Delete all MedicalFeeModels successfully',
	DELETE_ALL_MEDICAL_FEE_FAIL = '[ENTITY] Delete all MedicalFeeModels failed',

	UPDATE_MEDICAL_FEE = '[ENTITY] Update MedicalFeeModel',
	UPDATE_MEDICAL_FEE_OK = '[ENTITY] Update MedicalFeeModel successfully',
	UPDATE_MEDICAL_FEE_FAIL = '[ENTITY] Update MedicalFeeModel failed',

	UPDATE_ALL_MEDICAL_FEE = '[ENTITY] Update all MedicalFeeModel',
	UPDATE_ALL_MEDICAL_FEE_OK = '[ENTITY] Update all MedicalFeeModel successfully',
	UPDATE_ALL_MEDICAL_FEE_FAIL = '[ENTITY] Update all MedicalFeeModel failed',

	FETCH_MEDICAL_FEE= '[ENTITY] Fetch MedicalFeeModel',
	FETCH_MEDICAL_FEE_OK = '[ENTITY] Fetch MedicalFeeModel successfully',
	FETCH_MEDICAL_FEE_FAIL = '[ENTITY] Fetch MedicalFeeModel failed',

	FETCH_MEDICAL_FEE_AUDIT= '[ENTITY] Fetch MedicalFeeModel audit',
	FETCH_MEDICAL_FEE_AUDIT_OK = '[ENTITY] Fetch MedicalFeeModel audit successfully',
	FETCH_MEDICAL_FEE_AUDIT_FAIL = '[ENTITY] Fetch MedicalFeeModel audit failed',

	FETCH_MEDICAL_FEE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalFeeModel audits by entity id',
	FETCH_MEDICAL_FEE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalFeeModel audits by entity id successfully',
	FETCH_MEDICAL_FEE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalFeeModel audits by entity id failed',

	FETCH_ALL_MEDICAL_FEE = '[ENTITY] Fetch all MedicalFeeModel',
	FETCH_ALL_MEDICAL_FEE_OK = '[ENTITY] Fetch all MedicalFeeModel successfully',
	FETCH_ALL_MEDICAL_FEE_FAIL = '[ENTITY] Fetch all MedicalFeeModel failed',

	FETCH_MEDICAL_FEE_WITH_QUERY = '[ENTITY] Fetch MedicalFeeModel with query',
	FETCH_MEDICAL_FEE_WITH_QUERY_OK = '[ENTITY] Fetch MedicalFeeModel with query successfully',
	FETCH_MEDICAL_FEE_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalFeeModel with query failed',

	FETCH_LAST_MEDICAL_FEE_WITH_QUERY = '[ENTITY] Fetch last MedicalFeeModel with query',
	FETCH_LAST_MEDICAL_FEE_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalFeeModel with query successfully',
	FETCH_LAST_MEDICAL_FEE_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalFeeModel with query failed',

	EXPORT_MEDICAL_FEE = '[ENTITY] Export MedicalFeeModel',
	EXPORT_MEDICAL_FEE_OK = '[ENTITY] Export MedicalFeeModel successfully',
	EXPORT_MEDICAL_FEE_FAIL = '[ENTITY] Export MedicalFeeModel failed',

	EXPORT_ALL_MEDICAL_FEE = '[ENTITY] Export All MedicalFeeModels',
	EXPORT_ALL_MEDICAL_FEE_OK = '[ENTITY] Export All MedicalFeeModels successfully',
	EXPORT_ALL_MEDICAL_FEE_FAIL = '[ENTITY] Export All MedicalFeeModels failed',

	EXPORT_MEDICAL_FEE_EXCLUDING_IDS = '[ENTITY] Export MedicalFeeModels excluding Ids',
	EXPORT_MEDICAL_FEE_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalFeeModel excluding Ids successfully',
	EXPORT_MEDICAL_FEE_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalFeeModel excluding Ids failed',

	COUNT_MEDICAL_FEES = '[ENTITY] Fetch number of MedicalFeeModel records',
	COUNT_MEDICAL_FEES_OK = '[ENTITY] Fetch number of MedicalFeeModel records successfully ',
	COUNT_MEDICAL_FEES_FAIL = '[ENTITY] Fetch number of MedicalFeeModel records failed',

	IMPORT_MEDICAL_FEES = '[ENTITY] Import MedicalFeeModels',
	IMPORT_MEDICAL_FEES_OK = '[ENTITY] Import MedicalFeeModels successfully',
	IMPORT_MEDICAL_FEES_FAIL = '[ENTITY] Import MedicalFeeModels fail',


	INITIALISE_MEDICAL_FEE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalFeeModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalFeeAction implements Action {
	readonly className: string = 'MedicalFeeModel';

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

export class MedicalFeeAction extends BaseMedicalFeeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalFeeAction here] off begin
	// % protected region % [Add any additional class fields for MedicalFeeAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalFeeModel>,
		// % protected region % [Add any additional constructor parameters for MedicalFeeAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalFeeAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalFeeAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalFeeAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalFeeAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalFeeAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalFeeAction here] off begin
	// % protected region % [Add any additional class methods for MedicalFeeAction here] end
}

export class MedicalFeeActionOK extends BaseMedicalFeeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalFeeActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalFeeActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalFeeModel>,
		// % protected region % [Add any additional constructor parameters for MedicalFeeActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalFeeActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalFeeModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalFeeActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalFeeActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalFeeActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalFeeActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalFeeActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalFeeActionOK here] end
}

export class MedicalFeeActionFail extends BaseMedicalFeeAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalFeeActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalFeeActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalFeeModel>,
		// % protected region % [Add any additional constructor parameters for MedicalFeeActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalFeeActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalFeeActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalFeeActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalFeeActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalFeeActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalFeeActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalFeeActionFail here] end
}

export function isMedicalFeeModelAction(e: any): e is BaseMedicalFeeAction {
	return Object.values(MedicalFeeModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
