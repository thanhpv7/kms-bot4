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
import {BpjsClaimSubmissionModel} from './bpjs_claim_submission.model';
import {BpjsClaimSubmissionModelAudit} from './bpjs_claim_submission.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of BPJS Claim Submission model actions to be dispatched by NgRx.
 */
export enum BpjsClaimSubmissionModelActionTypes {
	CREATE_BPJS_CLAIM_SUBMISSION = '[ENTITY] Create BpjsClaimSubmissionModel',
	CREATE_BPJS_CLAIM_SUBMISSION_OK = '[ENTITY] Create BpjsClaimSubmissionModel successfully',
	CREATE_BPJS_CLAIM_SUBMISSION_FAIL = '[ENTITY] Create BpjsClaimSubmissionModel failed',

	CREATE_ALL_BPJS_CLAIM_SUBMISSION = '[ENTITY] Create All BpjsClaimSubmissionModel',
	CREATE_ALL_BPJS_CLAIM_SUBMISSION_OK = '[ENTITY] Create All BpjsClaimSubmissionModel successfully',
	CREATE_ALL_BPJS_CLAIM_SUBMISSION_FAIL = '[ENTITY] Create All BpjsClaimSubmissionModel failed',

	DELETE_BPJS_CLAIM_SUBMISSION = '[ENTITY] Delete BpjsClaimSubmissionModel',
	DELETE_BPJS_CLAIM_SUBMISSION_OK = '[ENTITY] Delete BpjsClaimSubmissionModel successfully',
	DELETE_BPJS_CLAIM_SUBMISSION_FAIL = '[ENTITY] Delete BpjsClaimSubmissionModel failed',


	DELETE_BPJS_CLAIM_SUBMISSION_EXCLUDING_IDS = '[ENTITY] Delete BpjsClaimSubmissionModels Excluding Ids',
	DELETE_BPJS_CLAIM_SUBMISSION_EXCLUDING_IDS_OK = '[ENTITY] Delete BpjsClaimSubmissionModels Excluding Ids successfully',
	DELETE_BPJS_CLAIM_SUBMISSION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BpjsClaimSubmissionModels Excluding Ids failed',

	DELETE_ALL_BPJS_CLAIM_SUBMISSION = '[ENTITY] Delete all BpjsClaimSubmissionModels',
	DELETE_ALL_BPJS_CLAIM_SUBMISSION_OK = '[ENTITY] Delete all BpjsClaimSubmissionModels successfully',
	DELETE_ALL_BPJS_CLAIM_SUBMISSION_FAIL = '[ENTITY] Delete all BpjsClaimSubmissionModels failed',

	UPDATE_BPJS_CLAIM_SUBMISSION = '[ENTITY] Update BpjsClaimSubmissionModel',
	UPDATE_BPJS_CLAIM_SUBMISSION_OK = '[ENTITY] Update BpjsClaimSubmissionModel successfully',
	UPDATE_BPJS_CLAIM_SUBMISSION_FAIL = '[ENTITY] Update BpjsClaimSubmissionModel failed',

	UPDATE_ALL_BPJS_CLAIM_SUBMISSION = '[ENTITY] Update all BpjsClaimSubmissionModel',
	UPDATE_ALL_BPJS_CLAIM_SUBMISSION_OK = '[ENTITY] Update all BpjsClaimSubmissionModel successfully',
	UPDATE_ALL_BPJS_CLAIM_SUBMISSION_FAIL = '[ENTITY] Update all BpjsClaimSubmissionModel failed',

	FETCH_BPJS_CLAIM_SUBMISSION= '[ENTITY] Fetch BpjsClaimSubmissionModel',
	FETCH_BPJS_CLAIM_SUBMISSION_OK = '[ENTITY] Fetch BpjsClaimSubmissionModel successfully',
	FETCH_BPJS_CLAIM_SUBMISSION_FAIL = '[ENTITY] Fetch BpjsClaimSubmissionModel failed',

	FETCH_BPJS_CLAIM_SUBMISSION_AUDIT= '[ENTITY] Fetch BpjsClaimSubmissionModel audit',
	FETCH_BPJS_CLAIM_SUBMISSION_AUDIT_OK = '[ENTITY] Fetch BpjsClaimSubmissionModel audit successfully',
	FETCH_BPJS_CLAIM_SUBMISSION_AUDIT_FAIL = '[ENTITY] Fetch BpjsClaimSubmissionModel audit failed',

	FETCH_BPJS_CLAIM_SUBMISSION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BpjsClaimSubmissionModel audits by entity id',
	FETCH_BPJS_CLAIM_SUBMISSION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BpjsClaimSubmissionModel audits by entity id successfully',
	FETCH_BPJS_CLAIM_SUBMISSION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BpjsClaimSubmissionModel audits by entity id failed',

	FETCH_ALL_BPJS_CLAIM_SUBMISSION = '[ENTITY] Fetch all BpjsClaimSubmissionModel',
	FETCH_ALL_BPJS_CLAIM_SUBMISSION_OK = '[ENTITY] Fetch all BpjsClaimSubmissionModel successfully',
	FETCH_ALL_BPJS_CLAIM_SUBMISSION_FAIL = '[ENTITY] Fetch all BpjsClaimSubmissionModel failed',

	FETCH_BPJS_CLAIM_SUBMISSION_WITH_QUERY = '[ENTITY] Fetch BpjsClaimSubmissionModel with query',
	FETCH_BPJS_CLAIM_SUBMISSION_WITH_QUERY_OK = '[ENTITY] Fetch BpjsClaimSubmissionModel with query successfully',
	FETCH_BPJS_CLAIM_SUBMISSION_WITH_QUERY_FAIL = '[ENTITY] Fetch BpjsClaimSubmissionModel with query failed',

	FETCH_LAST_BPJS_CLAIM_SUBMISSION_WITH_QUERY = '[ENTITY] Fetch last BpjsClaimSubmissionModel with query',
	FETCH_LAST_BPJS_CLAIM_SUBMISSION_WITH_QUERY_OK = '[ENTITY] Fetch last BpjsClaimSubmissionModel with query successfully',
	FETCH_LAST_BPJS_CLAIM_SUBMISSION_WITH_QUERY_FAIL = '[ENTITY] Fetch last BpjsClaimSubmissionModel with query failed',

	EXPORT_BPJS_CLAIM_SUBMISSION = '[ENTITY] Export BpjsClaimSubmissionModel',
	EXPORT_BPJS_CLAIM_SUBMISSION_OK = '[ENTITY] Export BpjsClaimSubmissionModel successfully',
	EXPORT_BPJS_CLAIM_SUBMISSION_FAIL = '[ENTITY] Export BpjsClaimSubmissionModel failed',

	EXPORT_ALL_BPJS_CLAIM_SUBMISSION = '[ENTITY] Export All BpjsClaimSubmissionModels',
	EXPORT_ALL_BPJS_CLAIM_SUBMISSION_OK = '[ENTITY] Export All BpjsClaimSubmissionModels successfully',
	EXPORT_ALL_BPJS_CLAIM_SUBMISSION_FAIL = '[ENTITY] Export All BpjsClaimSubmissionModels failed',

	EXPORT_BPJS_CLAIM_SUBMISSION_EXCLUDING_IDS = '[ENTITY] Export BpjsClaimSubmissionModels excluding Ids',
	EXPORT_BPJS_CLAIM_SUBMISSION_EXCLUDING_IDS_OK = '[ENTITY] Export BpjsClaimSubmissionModel excluding Ids successfully',
	EXPORT_BPJS_CLAIM_SUBMISSION_EXCLUDING_IDS_FAIL = '[ENTITY] Export BpjsClaimSubmissionModel excluding Ids failed',

	COUNT_BPJS_CLAIM_SUBMISSIONS = '[ENTITY] Fetch number of BpjsClaimSubmissionModel records',
	COUNT_BPJS_CLAIM_SUBMISSIONS_OK = '[ENTITY] Fetch number of BpjsClaimSubmissionModel records successfully ',
	COUNT_BPJS_CLAIM_SUBMISSIONS_FAIL = '[ENTITY] Fetch number of BpjsClaimSubmissionModel records failed',

	IMPORT_BPJS_CLAIM_SUBMISSIONS = '[ENTITY] Import BpjsClaimSubmissionModels',
	IMPORT_BPJS_CLAIM_SUBMISSIONS_OK = '[ENTITY] Import BpjsClaimSubmissionModels successfully',
	IMPORT_BPJS_CLAIM_SUBMISSIONS_FAIL = '[ENTITY] Import BpjsClaimSubmissionModels fail',


	INITIALISE_BPJS_CLAIM_SUBMISSION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BpjsClaimSubmissionModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBpjsClaimSubmissionAction implements Action {
	readonly className: string = 'BpjsClaimSubmissionModel';

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

export class BpjsClaimSubmissionAction extends BaseBpjsClaimSubmissionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsClaimSubmissionAction here] off begin
	// % protected region % [Add any additional class fields for BpjsClaimSubmissionAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsClaimSubmissionModel>,
		// % protected region % [Add any additional constructor parameters for BpjsClaimSubmissionAction here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsClaimSubmissionAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsClaimSubmissionAction here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsClaimSubmissionAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsClaimSubmissionAction here] off begin
		// % protected region % [Add any additional constructor logic for BpjsClaimSubmissionAction here] end
	}

	// % protected region % [Add any additional class methods for BpjsClaimSubmissionAction here] off begin
	// % protected region % [Add any additional class methods for BpjsClaimSubmissionAction here] end
}

export class BpjsClaimSubmissionActionOK extends BaseBpjsClaimSubmissionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsClaimSubmissionActionOK here] off begin
	// % protected region % [Add any additional class fields for BpjsClaimSubmissionActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BpjsClaimSubmissionModel>,
		// % protected region % [Add any additional constructor parameters for BpjsClaimSubmissionActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsClaimSubmissionActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BpjsClaimSubmissionModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsClaimSubmissionActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsClaimSubmissionActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsClaimSubmissionActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BpjsClaimSubmissionActionOK here] end
	}

	// % protected region % [Add any additional class methods for BpjsClaimSubmissionActionOK here] off begin
	// % protected region % [Add any additional class methods for BpjsClaimSubmissionActionOK here] end
}

export class BpjsClaimSubmissionActionFail extends BaseBpjsClaimSubmissionAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BpjsClaimSubmissionActionFail here] off begin
	// % protected region % [Add any additional class fields for BpjsClaimSubmissionActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BpjsClaimSubmissionModel>,
		// % protected region % [Add any additional constructor parameters for BpjsClaimSubmissionActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BpjsClaimSubmissionActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BpjsClaimSubmissionActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BpjsClaimSubmissionActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BpjsClaimSubmissionActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BpjsClaimSubmissionActionFail here] end
	}

	// % protected region % [Add any additional class methods for BpjsClaimSubmissionActionFail here] off begin
	// % protected region % [Add any additional class methods for BpjsClaimSubmissionActionFail here] end
}

export function isBpjsClaimSubmissionModelAction(e: any): e is BaseBpjsClaimSubmissionAction {
	return Object.values(BpjsClaimSubmissionModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
