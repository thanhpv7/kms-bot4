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
import {DiagnosesAndProceduresModel} from './diagnoses_and_procedures.model';
import {DiagnosesAndProceduresModelAudit} from './diagnoses_and_procedures.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Diagnoses and Procedures model actions to be dispatched by NgRx.
 */
export enum DiagnosesAndProceduresModelActionTypes {
	CREATE_DIAGNOSES_AND_PROCEDURES = '[ENTITY] Create DiagnosesAndProceduresModel',
	CREATE_DIAGNOSES_AND_PROCEDURES_OK = '[ENTITY] Create DiagnosesAndProceduresModel successfully',
	CREATE_DIAGNOSES_AND_PROCEDURES_FAIL = '[ENTITY] Create DiagnosesAndProceduresModel failed',

	CREATE_ALL_DIAGNOSES_AND_PROCEDURES = '[ENTITY] Create All DiagnosesAndProceduresModel',
	CREATE_ALL_DIAGNOSES_AND_PROCEDURES_OK = '[ENTITY] Create All DiagnosesAndProceduresModel successfully',
	CREATE_ALL_DIAGNOSES_AND_PROCEDURES_FAIL = '[ENTITY] Create All DiagnosesAndProceduresModel failed',

	DELETE_DIAGNOSES_AND_PROCEDURES = '[ENTITY] Delete DiagnosesAndProceduresModel',
	DELETE_DIAGNOSES_AND_PROCEDURES_OK = '[ENTITY] Delete DiagnosesAndProceduresModel successfully',
	DELETE_DIAGNOSES_AND_PROCEDURES_FAIL = '[ENTITY] Delete DiagnosesAndProceduresModel failed',


	DELETE_DIAGNOSES_AND_PROCEDURES_EXCLUDING_IDS = '[ENTITY] Delete DiagnosesAndProceduresModels Excluding Ids',
	DELETE_DIAGNOSES_AND_PROCEDURES_EXCLUDING_IDS_OK = '[ENTITY] Delete DiagnosesAndProceduresModels Excluding Ids successfully',
	DELETE_DIAGNOSES_AND_PROCEDURES_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DiagnosesAndProceduresModels Excluding Ids failed',

	DELETE_ALL_DIAGNOSES_AND_PROCEDURES = '[ENTITY] Delete all DiagnosesAndProceduresModels',
	DELETE_ALL_DIAGNOSES_AND_PROCEDURES_OK = '[ENTITY] Delete all DiagnosesAndProceduresModels successfully',
	DELETE_ALL_DIAGNOSES_AND_PROCEDURES_FAIL = '[ENTITY] Delete all DiagnosesAndProceduresModels failed',

	UPDATE_DIAGNOSES_AND_PROCEDURES = '[ENTITY] Update DiagnosesAndProceduresModel',
	UPDATE_DIAGNOSES_AND_PROCEDURES_OK = '[ENTITY] Update DiagnosesAndProceduresModel successfully',
	UPDATE_DIAGNOSES_AND_PROCEDURES_FAIL = '[ENTITY] Update DiagnosesAndProceduresModel failed',

	UPDATE_ALL_DIAGNOSES_AND_PROCEDURES = '[ENTITY] Update all DiagnosesAndProceduresModel',
	UPDATE_ALL_DIAGNOSES_AND_PROCEDURES_OK = '[ENTITY] Update all DiagnosesAndProceduresModel successfully',
	UPDATE_ALL_DIAGNOSES_AND_PROCEDURES_FAIL = '[ENTITY] Update all DiagnosesAndProceduresModel failed',

	FETCH_DIAGNOSES_AND_PROCEDURES= '[ENTITY] Fetch DiagnosesAndProceduresModel',
	FETCH_DIAGNOSES_AND_PROCEDURES_OK = '[ENTITY] Fetch DiagnosesAndProceduresModel successfully',
	FETCH_DIAGNOSES_AND_PROCEDURES_FAIL = '[ENTITY] Fetch DiagnosesAndProceduresModel failed',

	FETCH_DIAGNOSES_AND_PROCEDURES_AUDIT= '[ENTITY] Fetch DiagnosesAndProceduresModel audit',
	FETCH_DIAGNOSES_AND_PROCEDURES_AUDIT_OK = '[ENTITY] Fetch DiagnosesAndProceduresModel audit successfully',
	FETCH_DIAGNOSES_AND_PROCEDURES_AUDIT_FAIL = '[ENTITY] Fetch DiagnosesAndProceduresModel audit failed',

	FETCH_DIAGNOSES_AND_PROCEDURES_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DiagnosesAndProceduresModel audits by entity id',
	FETCH_DIAGNOSES_AND_PROCEDURES_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DiagnosesAndProceduresModel audits by entity id successfully',
	FETCH_DIAGNOSES_AND_PROCEDURES_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DiagnosesAndProceduresModel audits by entity id failed',

	FETCH_ALL_DIAGNOSES_AND_PROCEDURES = '[ENTITY] Fetch all DiagnosesAndProceduresModel',
	FETCH_ALL_DIAGNOSES_AND_PROCEDURES_OK = '[ENTITY] Fetch all DiagnosesAndProceduresModel successfully',
	FETCH_ALL_DIAGNOSES_AND_PROCEDURES_FAIL = '[ENTITY] Fetch all DiagnosesAndProceduresModel failed',

	FETCH_DIAGNOSES_AND_PROCEDURES_WITH_QUERY = '[ENTITY] Fetch DiagnosesAndProceduresModel with query',
	FETCH_DIAGNOSES_AND_PROCEDURES_WITH_QUERY_OK = '[ENTITY] Fetch DiagnosesAndProceduresModel with query successfully',
	FETCH_DIAGNOSES_AND_PROCEDURES_WITH_QUERY_FAIL = '[ENTITY] Fetch DiagnosesAndProceduresModel with query failed',

	FETCH_LAST_DIAGNOSES_AND_PROCEDURES_WITH_QUERY = '[ENTITY] Fetch last DiagnosesAndProceduresModel with query',
	FETCH_LAST_DIAGNOSES_AND_PROCEDURES_WITH_QUERY_OK = '[ENTITY] Fetch last DiagnosesAndProceduresModel with query successfully',
	FETCH_LAST_DIAGNOSES_AND_PROCEDURES_WITH_QUERY_FAIL = '[ENTITY] Fetch last DiagnosesAndProceduresModel with query failed',

	EXPORT_DIAGNOSES_AND_PROCEDURES = '[ENTITY] Export DiagnosesAndProceduresModel',
	EXPORT_DIAGNOSES_AND_PROCEDURES_OK = '[ENTITY] Export DiagnosesAndProceduresModel successfully',
	EXPORT_DIAGNOSES_AND_PROCEDURES_FAIL = '[ENTITY] Export DiagnosesAndProceduresModel failed',

	EXPORT_ALL_DIAGNOSES_AND_PROCEDURES = '[ENTITY] Export All DiagnosesAndProceduresModels',
	EXPORT_ALL_DIAGNOSES_AND_PROCEDURES_OK = '[ENTITY] Export All DiagnosesAndProceduresModels successfully',
	EXPORT_ALL_DIAGNOSES_AND_PROCEDURES_FAIL = '[ENTITY] Export All DiagnosesAndProceduresModels failed',

	EXPORT_DIAGNOSES_AND_PROCEDURES_EXCLUDING_IDS = '[ENTITY] Export DiagnosesAndProceduresModels excluding Ids',
	EXPORT_DIAGNOSES_AND_PROCEDURES_EXCLUDING_IDS_OK = '[ENTITY] Export DiagnosesAndProceduresModel excluding Ids successfully',
	EXPORT_DIAGNOSES_AND_PROCEDURES_EXCLUDING_IDS_FAIL = '[ENTITY] Export DiagnosesAndProceduresModel excluding Ids failed',

	COUNT_DIAGNOSES_AND_PROCEDURESS = '[ENTITY] Fetch number of DiagnosesAndProceduresModel records',
	COUNT_DIAGNOSES_AND_PROCEDURESS_OK = '[ENTITY] Fetch number of DiagnosesAndProceduresModel records successfully ',
	COUNT_DIAGNOSES_AND_PROCEDURESS_FAIL = '[ENTITY] Fetch number of DiagnosesAndProceduresModel records failed',

	IMPORT_DIAGNOSES_AND_PROCEDURESS = '[ENTITY] Import DiagnosesAndProceduresModels',
	IMPORT_DIAGNOSES_AND_PROCEDURESS_OK = '[ENTITY] Import DiagnosesAndProceduresModels successfully',
	IMPORT_DIAGNOSES_AND_PROCEDURESS_FAIL = '[ENTITY] Import DiagnosesAndProceduresModels fail',


	INITIALISE_DIAGNOSES_AND_PROCEDURES_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DiagnosesAndProceduresModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDiagnosesAndProceduresAction implements Action {
	readonly className: string = 'DiagnosesAndProceduresModel';

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

export class DiagnosesAndProceduresAction extends BaseDiagnosesAndProceduresAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosesAndProceduresAction here] off begin
	// % protected region % [Add any additional class fields for DiagnosesAndProceduresAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosesAndProceduresModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosesAndProceduresAction here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosesAndProceduresAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosesAndProceduresAction here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosesAndProceduresAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosesAndProceduresAction here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosesAndProceduresAction here] end
	}

	// % protected region % [Add any additional class methods for DiagnosesAndProceduresAction here] off begin
	// % protected region % [Add any additional class methods for DiagnosesAndProceduresAction here] end
}

export class DiagnosesAndProceduresActionOK extends BaseDiagnosesAndProceduresAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosesAndProceduresActionOK here] off begin
	// % protected region % [Add any additional class fields for DiagnosesAndProceduresActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DiagnosesAndProceduresModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosesAndProceduresActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosesAndProceduresActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DiagnosesAndProceduresModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosesAndProceduresActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosesAndProceduresActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosesAndProceduresActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosesAndProceduresActionOK here] end
	}

	// % protected region % [Add any additional class methods for DiagnosesAndProceduresActionOK here] off begin
	// % protected region % [Add any additional class methods for DiagnosesAndProceduresActionOK here] end
}

export class DiagnosesAndProceduresActionFail extends BaseDiagnosesAndProceduresAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DiagnosesAndProceduresActionFail here] off begin
	// % protected region % [Add any additional class fields for DiagnosesAndProceduresActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DiagnosesAndProceduresModel>,
		// % protected region % [Add any additional constructor parameters for DiagnosesAndProceduresActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DiagnosesAndProceduresActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DiagnosesAndProceduresActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DiagnosesAndProceduresActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DiagnosesAndProceduresActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DiagnosesAndProceduresActionFail here] end
	}

	// % protected region % [Add any additional class methods for DiagnosesAndProceduresActionFail here] off begin
	// % protected region % [Add any additional class methods for DiagnosesAndProceduresActionFail here] end
}

export function isDiagnosesAndProceduresModelAction(e: any): e is BaseDiagnosesAndProceduresAction {
	return Object.values(DiagnosesAndProceduresModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
