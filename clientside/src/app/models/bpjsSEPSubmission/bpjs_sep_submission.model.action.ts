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
import {BpjsSEPSubmissionModel} from './bpjs_sep_submission.model';
import {BpjsSEPSubmissionModelAudit} from './bpjs_sep_submission.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS SEP Submission model actions to be dispatched by NgRx.
 */
export enum BpjsSEPSubmissionModelActionTypes {
	CREATE_BPJS_SEP_SUBMISSION = '[ENTITY] Create BpjsSEPSubmissionModel',
	CREATE_BPJS_SEP_SUBMISSION_OK = '[ENTITY] Create BpjsSEPSubmissionModel successfully',
	CREATE_BPJS_SEP_SUBMISSION_FAIL = '[ENTITY] Create BpjsSEPSubmissionModel failed',

	CREATE_ALL_BPJS_SEP_SUBMISSION = '[ENTITY] Create All BpjsSEPSubmissionModel',
	CREATE_ALL_BPJS_SEP_SUBMISSION_OK = '[ENTITY] Create All BpjsSEPSubmissionModel successfully',
	CREATE_ALL_BPJS_SEP_SUBMISSION_FAIL = '[ENTITY] Create All BpjsSEPSubmissionModel failed',

	DELETE_BPJS_SEP_SUBMISSION = '[ENTITY] Delete BpjsSEPSubmissionModel',
	DELETE_BPJS_SEP_SUBMISSION_OK = '[ENTITY] Delete BpjsSEPSubmissionModel successfully',
	DELETE_BPJS_SEP_SUBMISSION_FAIL = '[ENTITY] Delete BpjsSEPSubmissionModel failed',


	DELETE_BPJS_SEP_SUBMISSION_EXCLUDING_IDS = '[ENTITY] Delete BpjsSEPSubmissionModels Excluding Ids',
	DELETE_BPJS_SEP_SUBMISSION_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsSEPSubmissionModels Excluding Ids successfully',
	DELETE_BPJS_SEP_SUBMISSION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsSEPSubmissionModels Excluding Ids failed',

	DELETE_ALL_BPJS_SEP_SUBMISSION = '[ENTITY] Delete all BpjsSEPSubmissionModels',
	DELETE_ALL_BPJS_SEP_SUBMISSION_OK = '[ENTITY] Delete all BpjsSEPSubmissionModels successfully',
	DELETE_ALL_BPJS_SEP_SUBMISSION_FAIL = '[ENTITY] Delete all BpjsSEPSubmissionModels failed',

	UPDATE_BPJS_SEP_SUBMISSION = '[ENTITY] Update BpjsSEPSubmissionModel',
	UPDATE_BPJS_SEP_SUBMISSION_OK = '[ENTITY] Update BpjsSEPSubmissionModel successfully',
	UPDATE_BPJS_SEP_SUBMISSION_FAIL = '[ENTITY] Update BpjsSEPSubmissionModel failed',

	UPDATE_ALL_BPJS_SEP_SUBMISSION = '[ENTITY] Update all BpjsSEPSubmissionModel',
	UPDATE_ALL_BPJS_SEP_SUBMISSION_OK = '[ENTITY] Update all BpjsSEPSubmissionModel successfully',
	UPDATE_ALL_BPJS_SEP_SUBMISSION_FAIL = '[ENTITY] Update all BpjsSEPSubmissionModel failed',

	FETCH_BPJS_SEP_SUBMISSION= '[ENTITY] Fetch BpjsSEPSubmissionModel',
	FETCH_BPJS_SEP_SUBMISSION_OK = '[ENTITY] Fetch BpjsSEPSubmissionModel successfully',
	FETCH_BPJS_SEP_SUBMISSION_FAIL = '[ENTITY] Fetch BpjsSEPSubmissionModel failed',

	FETCH_BPJS_SEP_SUBMISSION_AUDIT= '[ENTITY] Fetch BpjsSEPSubmissionModel audit',
	FETCH_BPJS_SEP_SUBMISSION_AUDIT_OK = '[ENTITY] Fetch BpjsSEPSubmissionModel audit successfully',
	FETCH_BPJS_SEP_SUBMISSION_AUDIT_FAIL = '[ENTITY] Fetch BpjsSEPSubmissionModel audit failed',

	FETCH_BPJS_SEP_SUBMISSION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsSEPSubmissionModel audits by entity id',
	FETCH_BPJS_SEP_SUBMISSION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsSEPSubmissionModel audits by entity id successfully',
	FETCH_BPJS_SEP_SUBMISSION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsSEPSubmissionModel audits by entity id failed',

	FETCH_ALL_BPJS_SEP_SUBMISSION = '[ENTITY] Fetch all BpjsSEPSubmissionModel',
	FETCH_ALL_BPJS_SEP_SUBMISSION_OK = '[ENTITY] Fetch all BpjsSEPSubmissionModel successfully',
	FETCH_ALL_BPJS_SEP_SUBMISSION_FAIL = '[ENTITY] Fetch all BpjsSEPSubmissionModel failed',

	FETCH_BPJS_SEP_SUBMISSION_WITH_QUERY = '[ENTITY] Fetch BpjsSEPSubmissionModel with query',
	FETCH_BPJS_SEP_SUBMISSION_WITH_QUERY_OK = '[ENTITY] Fetch BpjsSEPSubmissionModel with query successfully',
	FETCH_BPJS_SEP_SUBMISSION_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsSEPSubmissionModel with query failed',

	FETCH_LAST_BPJS_SEP_SUBMISSION_WITH_QUERY = '[ENTITY] Fetch last BpjsSEPSubmissionModel with query',
	FETCH_LAST_BPJS_SEP_SUBMISSION_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsSEPSubmissionModel with query successfully',
	FETCH_LAST_BPJS_SEP_SUBMISSION_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsSEPSubmissionModel with query failed',

	EXPORT_BPJS_SEP_SUBMISSION = '[ENTITY] Export BpjsSEPSubmissionModel',
	EXPORT_BPJS_SEP_SUBMISSION_OK = '[ENTITY] Export BpjsSEPSubmissionModel successfully',
	EXPORT_BPJS_SEP_SUBMISSION_FAIL = '[ENTITY] Export BpjsSEPSubmissionModel failed',

	EXPORT_ALL_BPJS_SEP_SUBMISSION = '[ENTITY] Export All BpjsSEPSubmissionModels',
	EXPORT_ALL_BPJS_SEP_SUBMISSION_OK = '[ENTITY] Export All BpjsSEPSubmissionModels successfully',
	EXPORT_ALL_BPJS_SEP_SUBMISSION_FAIL = '[ENTITY] Export All BpjsSEPSubmissionModels failed',

	EXPORT_BPJS_SEP_SUBMISSION_EXCLUDING_IDS = '[ENTITY] Export BpjsSEPSubmissionModels excluding Ids',
	EXPORT_BPJS_SEP_SUBMISSION_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsSEPSubmissionModel excluding Ids successfully',
	EXPORT_BPJS_SEP_SUBMISSION_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsSEPSubmissionModel excluding Ids failed',

	COUNT_BPJS_SEP_SUBMISSIONS = '[ENTITY] Fetch number of BpjsSEPSubmissionModel records',
	COUNT_BPJS_SEP_SUBMISSIONS_OK = '[ENTITY] Fetch number of BpjsSEPSubmissionModel records successfully ',
	COUNT_BPJS_SEP_SUBMISSIONS_FAIL = '[ENTITY] Fetch number of BpjsSEPSubmissionModel records failed',

	IMPORT_BPJS_SEP_SUBMISSIONS = '[ENTITY] Import BpjsSEPSubmissionModels',
	IMPORT_BPJS_SEP_SUBMISSIONS_OK = '[ENTITY] Import BpjsSEPSubmissionModels successfully',
	IMPORT_BPJS_SEP_SUBMISSIONS_FAIL = '[ENTITY] Import BpjsSEPSubmissionModels fail',


	INITIALISE_BPJS_SEP_SUBMISSION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsSEPSubmissionModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsSEPSubmissionAction implements Action {
	readonly className: string = 'BpjsSEPSubmissionModel';

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

export class BpjsSEPSubmissionAction extends BaseBpjsSEPSubmissionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPSubmissionAction here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPSubmissionAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSEPSubmissionModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPSubmissionAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPSubmissionAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPSubmissionAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPSubmissionAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPSubmissionAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPSubmissionAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPSubmissionAction here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPSubmissionAction here] end
}

export class BpjsSEPSubmissionActionOK extends BaseBpjsSEPSubmissionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPSubmissionActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPSubmissionActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsSEPSubmissionModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPSubmissionActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPSubmissionActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsSEPSubmissionModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPSubmissionActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPSubmissionActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPSubmissionActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPSubmissionActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPSubmissionActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPSubmissionActionOK here] end
}

export class BpjsSEPSubmissionActionFail extends BaseBpjsSEPSubmissionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsSEPSubmissionActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsSEPSubmissionActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsSEPSubmissionModel>,
		// % protected region % [Add any additional constructor parameters for BpjsSEPSubmissionActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsSEPSubmissionActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsSEPSubmissionActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsSEPSubmissionActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsSEPSubmissionActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsSEPSubmissionActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsSEPSubmissionActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsSEPSubmissionActionFail here] end
}

export function isBpjsSEPSubmissionModelAction(e: any): e is BaseBpjsSEPSubmissionAction {
	return Object.values(BpjsSEPSubmissionModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
