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
import {PrescriptionCompoundModel} from './prescription_compound.model';
import {PrescriptionCompoundModelAudit} from './prescription_compound.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Prescription Compound model actions to be dispatched by NgRx.
 */
export enum PrescriptionCompoundModelActionTypes {
	CREATE_PRESCRIPTION_COMPOUND = '[ENTITY] Create PrescriptionCompoundModel',
	CREATE_PRESCRIPTION_COMPOUND_OK = '[ENTITY] Create PrescriptionCompoundModel successfully',
	CREATE_PRESCRIPTION_COMPOUND_FAIL = '[ENTITY] Create PrescriptionCompoundModel failed',

	CREATE_ALL_PRESCRIPTION_COMPOUND = '[ENTITY] Create All PrescriptionCompoundModel',
	CREATE_ALL_PRESCRIPTION_COMPOUND_OK = '[ENTITY] Create All PrescriptionCompoundModel successfully',
	CREATE_ALL_PRESCRIPTION_COMPOUND_FAIL = '[ENTITY] Create All PrescriptionCompoundModel failed',

	DELETE_PRESCRIPTION_COMPOUND = '[ENTITY] Delete PrescriptionCompoundModel',
	DELETE_PRESCRIPTION_COMPOUND_OK = '[ENTITY] Delete PrescriptionCompoundModel successfully',
	DELETE_PRESCRIPTION_COMPOUND_FAIL = '[ENTITY] Delete PrescriptionCompoundModel failed',


	DELETE_PRESCRIPTION_COMPOUND_EXCLUDING_IDS = '[ENTITY] Delete PrescriptionCompoundModels Excluding Ids',
	DELETE_PRESCRIPTION_COMPOUND_EXCLUDING_IDS_OK = '[ENTITY] Delete PrescriptionCompoundModels Excluding Ids successfully',
	DELETE_PRESCRIPTION_COMPOUND_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PrescriptionCompoundModels Excluding Ids failed',

	DELETE_ALL_PRESCRIPTION_COMPOUND = '[ENTITY] Delete all PrescriptionCompoundModels',
	DELETE_ALL_PRESCRIPTION_COMPOUND_OK = '[ENTITY] Delete all PrescriptionCompoundModels successfully',
	DELETE_ALL_PRESCRIPTION_COMPOUND_FAIL = '[ENTITY] Delete all PrescriptionCompoundModels failed',

	UPDATE_PRESCRIPTION_COMPOUND = '[ENTITY] Update PrescriptionCompoundModel',
	UPDATE_PRESCRIPTION_COMPOUND_OK = '[ENTITY] Update PrescriptionCompoundModel successfully',
	UPDATE_PRESCRIPTION_COMPOUND_FAIL = '[ENTITY] Update PrescriptionCompoundModel failed',

	UPDATE_ALL_PRESCRIPTION_COMPOUND = '[ENTITY] Update all PrescriptionCompoundModel',
	UPDATE_ALL_PRESCRIPTION_COMPOUND_OK = '[ENTITY] Update all PrescriptionCompoundModel successfully',
	UPDATE_ALL_PRESCRIPTION_COMPOUND_FAIL = '[ENTITY] Update all PrescriptionCompoundModel failed',

	FETCH_PRESCRIPTION_COMPOUND= '[ENTITY] Fetch PrescriptionCompoundModel',
	FETCH_PRESCRIPTION_COMPOUND_OK = '[ENTITY] Fetch PrescriptionCompoundModel successfully',
	FETCH_PRESCRIPTION_COMPOUND_FAIL = '[ENTITY] Fetch PrescriptionCompoundModel failed',

	FETCH_PRESCRIPTION_COMPOUND_AUDIT= '[ENTITY] Fetch PrescriptionCompoundModel audit',
	FETCH_PRESCRIPTION_COMPOUND_AUDIT_OK = '[ENTITY] Fetch PrescriptionCompoundModel audit successfully',
	FETCH_PRESCRIPTION_COMPOUND_AUDIT_FAIL = '[ENTITY] Fetch PrescriptionCompoundModel audit failed',

	FETCH_PRESCRIPTION_COMPOUND_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PrescriptionCompoundModel audits by entity id',
	FETCH_PRESCRIPTION_COMPOUND_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PrescriptionCompoundModel audits by entity id successfully',
	FETCH_PRESCRIPTION_COMPOUND_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PrescriptionCompoundModel audits by entity id failed',

	FETCH_ALL_PRESCRIPTION_COMPOUND = '[ENTITY] Fetch all PrescriptionCompoundModel',
	FETCH_ALL_PRESCRIPTION_COMPOUND_OK = '[ENTITY] Fetch all PrescriptionCompoundModel successfully',
	FETCH_ALL_PRESCRIPTION_COMPOUND_FAIL = '[ENTITY] Fetch all PrescriptionCompoundModel failed',

	FETCH_PRESCRIPTION_COMPOUND_WITH_QUERY = '[ENTITY] Fetch PrescriptionCompoundModel with query',
	FETCH_PRESCRIPTION_COMPOUND_WITH_QUERY_OK = '[ENTITY] Fetch PrescriptionCompoundModel with query successfully',
	FETCH_PRESCRIPTION_COMPOUND_WITH_QUERY_FAIL = '[ENTITY] Fetch PrescriptionCompoundModel with query failed',

	FETCH_LAST_PRESCRIPTION_COMPOUND_WITH_QUERY = '[ENTITY] Fetch last PrescriptionCompoundModel with query',
	FETCH_LAST_PRESCRIPTION_COMPOUND_WITH_QUERY_OK = '[ENTITY] Fetch last PrescriptionCompoundModel with query successfully',
	FETCH_LAST_PRESCRIPTION_COMPOUND_WITH_QUERY_FAIL = '[ENTITY] Fetch last PrescriptionCompoundModel with query failed',

	EXPORT_PRESCRIPTION_COMPOUND = '[ENTITY] Export PrescriptionCompoundModel',
	EXPORT_PRESCRIPTION_COMPOUND_OK = '[ENTITY] Export PrescriptionCompoundModel successfully',
	EXPORT_PRESCRIPTION_COMPOUND_FAIL = '[ENTITY] Export PrescriptionCompoundModel failed',

	EXPORT_ALL_PRESCRIPTION_COMPOUND = '[ENTITY] Export All PrescriptionCompoundModels',
	EXPORT_ALL_PRESCRIPTION_COMPOUND_OK = '[ENTITY] Export All PrescriptionCompoundModels successfully',
	EXPORT_ALL_PRESCRIPTION_COMPOUND_FAIL = '[ENTITY] Export All PrescriptionCompoundModels failed',

	EXPORT_PRESCRIPTION_COMPOUND_EXCLUDING_IDS = '[ENTITY] Export PrescriptionCompoundModels excluding Ids',
	EXPORT_PRESCRIPTION_COMPOUND_EXCLUDING_IDS_OK = '[ENTITY] Export PrescriptionCompoundModel excluding Ids successfully',
	EXPORT_PRESCRIPTION_COMPOUND_EXCLUDING_IDS_FAIL = '[ENTITY] Export PrescriptionCompoundModel excluding Ids failed',

	COUNT_PRESCRIPTION_COMPOUNDS = '[ENTITY] Fetch number of PrescriptionCompoundModel records',
	COUNT_PRESCRIPTION_COMPOUNDS_OK = '[ENTITY] Fetch number of PrescriptionCompoundModel records successfully ',
	COUNT_PRESCRIPTION_COMPOUNDS_FAIL = '[ENTITY] Fetch number of PrescriptionCompoundModel records failed',

	IMPORT_PRESCRIPTION_COMPOUNDS = '[ENTITY] Import PrescriptionCompoundModels',
	IMPORT_PRESCRIPTION_COMPOUNDS_OK = '[ENTITY] Import PrescriptionCompoundModels successfully',
	IMPORT_PRESCRIPTION_COMPOUNDS_FAIL = '[ENTITY] Import PrescriptionCompoundModels fail',


	INITIALISE_PRESCRIPTION_COMPOUND_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PrescriptionCompoundModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePrescriptionCompoundAction implements Action {
	readonly className: string = 'PrescriptionCompoundModel';

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

export class PrescriptionCompoundAction extends BasePrescriptionCompoundAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrescriptionCompoundAction here] off begin
	// % protected region % [Add any additional class fields for PrescriptionCompoundAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PrescriptionCompoundModel>,
		// % protected region % [Add any additional constructor parameters for PrescriptionCompoundAction here] off begin
		// % protected region % [Add any additional constructor parameters for PrescriptionCompoundAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrescriptionCompoundAction here] off begin
			// % protected region % [Add any additional constructor arguments for PrescriptionCompoundAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrescriptionCompoundAction here] off begin
		// % protected region % [Add any additional constructor logic for PrescriptionCompoundAction here] end
	}

	// % protected region % [Add any additional class methods for PrescriptionCompoundAction here] off begin
	// % protected region % [Add any additional class methods for PrescriptionCompoundAction here] end
}

export class PrescriptionCompoundActionOK extends BasePrescriptionCompoundAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrescriptionCompoundActionOK here] off begin
	// % protected region % [Add any additional class fields for PrescriptionCompoundActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PrescriptionCompoundModel>,
		// % protected region % [Add any additional constructor parameters for PrescriptionCompoundActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PrescriptionCompoundActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PrescriptionCompoundModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrescriptionCompoundActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PrescriptionCompoundActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrescriptionCompoundActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PrescriptionCompoundActionOK here] end
	}

	// % protected region % [Add any additional class methods for PrescriptionCompoundActionOK here] off begin
	// % protected region % [Add any additional class methods for PrescriptionCompoundActionOK here] end
}

export class PrescriptionCompoundActionFail extends BasePrescriptionCompoundAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrescriptionCompoundActionFail here] off begin
	// % protected region % [Add any additional class fields for PrescriptionCompoundActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PrescriptionCompoundModel>,
		// % protected region % [Add any additional constructor parameters for PrescriptionCompoundActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PrescriptionCompoundActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrescriptionCompoundActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PrescriptionCompoundActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrescriptionCompoundActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PrescriptionCompoundActionFail here] end
	}

	// % protected region % [Add any additional class methods for PrescriptionCompoundActionFail here] off begin
	// % protected region % [Add any additional class methods for PrescriptionCompoundActionFail here] end
}

export function isPrescriptionCompoundModelAction(e: any): e is BasePrescriptionCompoundAction {
	return Object.values(PrescriptionCompoundModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
