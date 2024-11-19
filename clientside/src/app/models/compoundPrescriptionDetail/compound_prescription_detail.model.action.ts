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
import {CompoundPrescriptionDetailModel} from './compound_prescription_detail.model';
import {CompoundPrescriptionDetailModelAudit} from './compound_prescription_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Compound Prescription Detail model actions to be dispatched by NgRx.
 */
export enum CompoundPrescriptionDetailModelActionTypes {
	CREATE_COMPOUND_PRESCRIPTION_DETAIL = '[ENTITY] Create CompoundPrescriptionDetailModel',
	CREATE_COMPOUND_PRESCRIPTION_DETAIL_OK = '[ENTITY] Create CompoundPrescriptionDetailModel successfully',
	CREATE_COMPOUND_PRESCRIPTION_DETAIL_FAIL = '[ENTITY] Create CompoundPrescriptionDetailModel failed',

	CREATE_ALL_COMPOUND_PRESCRIPTION_DETAIL = '[ENTITY] Create All CompoundPrescriptionDetailModel',
	CREATE_ALL_COMPOUND_PRESCRIPTION_DETAIL_OK = '[ENTITY] Create All CompoundPrescriptionDetailModel successfully',
	CREATE_ALL_COMPOUND_PRESCRIPTION_DETAIL_FAIL = '[ENTITY] Create All CompoundPrescriptionDetailModel failed',

	DELETE_COMPOUND_PRESCRIPTION_DETAIL = '[ENTITY] Delete CompoundPrescriptionDetailModel',
	DELETE_COMPOUND_PRESCRIPTION_DETAIL_OK = '[ENTITY] Delete CompoundPrescriptionDetailModel successfully',
	DELETE_COMPOUND_PRESCRIPTION_DETAIL_FAIL = '[ENTITY] Delete CompoundPrescriptionDetailModel failed',


	DELETE_COMPOUND_PRESCRIPTION_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete CompoundPrescriptionDetailModels Excluding Ids',
	DELETE_COMPOUND_PRESCRIPTION_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete CompoundPrescriptionDetailModels Excluding Ids successfully',
	DELETE_COMPOUND_PRESCRIPTION_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete CompoundPrescriptionDetailModels Excluding Ids failed',

	DELETE_ALL_COMPOUND_PRESCRIPTION_DETAIL = '[ENTITY] Delete all CompoundPrescriptionDetailModels',
	DELETE_ALL_COMPOUND_PRESCRIPTION_DETAIL_OK = '[ENTITY] Delete all CompoundPrescriptionDetailModels successfully',
	DELETE_ALL_COMPOUND_PRESCRIPTION_DETAIL_FAIL = '[ENTITY] Delete all CompoundPrescriptionDetailModels failed',

	UPDATE_COMPOUND_PRESCRIPTION_DETAIL = '[ENTITY] Update CompoundPrescriptionDetailModel',
	UPDATE_COMPOUND_PRESCRIPTION_DETAIL_OK = '[ENTITY] Update CompoundPrescriptionDetailModel successfully',
	UPDATE_COMPOUND_PRESCRIPTION_DETAIL_FAIL = '[ENTITY] Update CompoundPrescriptionDetailModel failed',

	UPDATE_ALL_COMPOUND_PRESCRIPTION_DETAIL = '[ENTITY] Update all CompoundPrescriptionDetailModel',
	UPDATE_ALL_COMPOUND_PRESCRIPTION_DETAIL_OK = '[ENTITY] Update all CompoundPrescriptionDetailModel successfully',
	UPDATE_ALL_COMPOUND_PRESCRIPTION_DETAIL_FAIL = '[ENTITY] Update all CompoundPrescriptionDetailModel failed',

	FETCH_COMPOUND_PRESCRIPTION_DETAIL= '[ENTITY] Fetch CompoundPrescriptionDetailModel',
	FETCH_COMPOUND_PRESCRIPTION_DETAIL_OK = '[ENTITY] Fetch CompoundPrescriptionDetailModel successfully',
	FETCH_COMPOUND_PRESCRIPTION_DETAIL_FAIL = '[ENTITY] Fetch CompoundPrescriptionDetailModel failed',

	FETCH_COMPOUND_PRESCRIPTION_DETAIL_AUDIT= '[ENTITY] Fetch CompoundPrescriptionDetailModel audit',
	FETCH_COMPOUND_PRESCRIPTION_DETAIL_AUDIT_OK = '[ENTITY] Fetch CompoundPrescriptionDetailModel audit successfully',
	FETCH_COMPOUND_PRESCRIPTION_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch CompoundPrescriptionDetailModel audit failed',

	FETCH_COMPOUND_PRESCRIPTION_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch CompoundPrescriptionDetailModel audits by entity id',
	FETCH_COMPOUND_PRESCRIPTION_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch CompoundPrescriptionDetailModel audits by entity id successfully',
	FETCH_COMPOUND_PRESCRIPTION_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch CompoundPrescriptionDetailModel audits by entity id failed',

	FETCH_ALL_COMPOUND_PRESCRIPTION_DETAIL = '[ENTITY] Fetch all CompoundPrescriptionDetailModel',
	FETCH_ALL_COMPOUND_PRESCRIPTION_DETAIL_OK = '[ENTITY] Fetch all CompoundPrescriptionDetailModel successfully',
	FETCH_ALL_COMPOUND_PRESCRIPTION_DETAIL_FAIL = '[ENTITY] Fetch all CompoundPrescriptionDetailModel failed',

	FETCH_COMPOUND_PRESCRIPTION_DETAIL_WITH_QUERY = '[ENTITY] Fetch CompoundPrescriptionDetailModel with query',
	FETCH_COMPOUND_PRESCRIPTION_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch CompoundPrescriptionDetailModel with query successfully',
	FETCH_COMPOUND_PRESCRIPTION_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch CompoundPrescriptionDetailModel with query failed',

	FETCH_LAST_COMPOUND_PRESCRIPTION_DETAIL_WITH_QUERY = '[ENTITY] Fetch last CompoundPrescriptionDetailModel with query',
	FETCH_LAST_COMPOUND_PRESCRIPTION_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last CompoundPrescriptionDetailModel with query successfully',
	FETCH_LAST_COMPOUND_PRESCRIPTION_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last CompoundPrescriptionDetailModel with query failed',

	EXPORT_COMPOUND_PRESCRIPTION_DETAIL = '[ENTITY] Export CompoundPrescriptionDetailModel',
	EXPORT_COMPOUND_PRESCRIPTION_DETAIL_OK = '[ENTITY] Export CompoundPrescriptionDetailModel successfully',
	EXPORT_COMPOUND_PRESCRIPTION_DETAIL_FAIL = '[ENTITY] Export CompoundPrescriptionDetailModel failed',

	EXPORT_ALL_COMPOUND_PRESCRIPTION_DETAIL = '[ENTITY] Export All CompoundPrescriptionDetailModels',
	EXPORT_ALL_COMPOUND_PRESCRIPTION_DETAIL_OK = '[ENTITY] Export All CompoundPrescriptionDetailModels successfully',
	EXPORT_ALL_COMPOUND_PRESCRIPTION_DETAIL_FAIL = '[ENTITY] Export All CompoundPrescriptionDetailModels failed',

	EXPORT_COMPOUND_PRESCRIPTION_DETAIL_EXCLUDING_IDS = '[ENTITY] Export CompoundPrescriptionDetailModels excluding Ids',
	EXPORT_COMPOUND_PRESCRIPTION_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export CompoundPrescriptionDetailModel excluding Ids successfully',
	EXPORT_COMPOUND_PRESCRIPTION_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export CompoundPrescriptionDetailModel excluding Ids failed',

	COUNT_COMPOUND_PRESCRIPTION_DETAILS = '[ENTITY] Fetch number of CompoundPrescriptionDetailModel records',
	COUNT_COMPOUND_PRESCRIPTION_DETAILS_OK = '[ENTITY] Fetch number of CompoundPrescriptionDetailModel records successfully ',
	COUNT_COMPOUND_PRESCRIPTION_DETAILS_FAIL = '[ENTITY] Fetch number of CompoundPrescriptionDetailModel records failed',

	IMPORT_COMPOUND_PRESCRIPTION_DETAILS = '[ENTITY] Import CompoundPrescriptionDetailModels',
	IMPORT_COMPOUND_PRESCRIPTION_DETAILS_OK = '[ENTITY] Import CompoundPrescriptionDetailModels successfully',
	IMPORT_COMPOUND_PRESCRIPTION_DETAILS_FAIL = '[ENTITY] Import CompoundPrescriptionDetailModels fail',


	INITIALISE_COMPOUND_PRESCRIPTION_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of CompoundPrescriptionDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseCompoundPrescriptionDetailAction implements Action {
	readonly className: string = 'CompoundPrescriptionDetailModel';

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

export class CompoundPrescriptionDetailAction extends BaseCompoundPrescriptionDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CompoundPrescriptionDetailAction here] off begin
	// % protected region % [Add any additional class fields for CompoundPrescriptionDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CompoundPrescriptionDetailModel>,
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionDetailAction here] end
	}

	// % protected region % [Add any additional class methods for CompoundPrescriptionDetailAction here] off begin
	// % protected region % [Add any additional class methods for CompoundPrescriptionDetailAction here] end
}

export class CompoundPrescriptionDetailActionOK extends BaseCompoundPrescriptionDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CompoundPrescriptionDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for CompoundPrescriptionDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<CompoundPrescriptionDetailModel>,
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: CompoundPrescriptionDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for CompoundPrescriptionDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for CompoundPrescriptionDetailActionOK here] end
}

export class CompoundPrescriptionDetailActionFail extends BaseCompoundPrescriptionDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for CompoundPrescriptionDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for CompoundPrescriptionDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<CompoundPrescriptionDetailModel>,
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for CompoundPrescriptionDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for CompoundPrescriptionDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for CompoundPrescriptionDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for CompoundPrescriptionDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for CompoundPrescriptionDetailActionFail here] end
}

export function isCompoundPrescriptionDetailModelAction(e: any): e is BaseCompoundPrescriptionDetailAction {
	return Object.values(CompoundPrescriptionDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
