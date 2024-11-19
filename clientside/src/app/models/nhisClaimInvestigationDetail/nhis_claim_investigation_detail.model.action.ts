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
import {NhisClaimInvestigationDetailModel} from './nhis_claim_investigation_detail.model';
import {NhisClaimInvestigationDetailModelAudit} from './nhis_claim_investigation_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of NHIS Claim Investigation Detail model actions to be dispatched by NgRx.
 */
export enum NhisClaimInvestigationDetailModelActionTypes {
	CREATE_NHIS_CLAIM_INVESTIGATION_DETAIL = '[ENTITY] Create NhisClaimInvestigationDetailModel',
	CREATE_NHIS_CLAIM_INVESTIGATION_DETAIL_OK = '[ENTITY] Create NhisClaimInvestigationDetailModel successfully',
	CREATE_NHIS_CLAIM_INVESTIGATION_DETAIL_FAIL = '[ENTITY] Create NhisClaimInvestigationDetailModel failed',

	CREATE_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL = '[ENTITY] Create All NhisClaimInvestigationDetailModel',
	CREATE_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL_OK = '[ENTITY] Create All NhisClaimInvestigationDetailModel successfully',
	CREATE_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL_FAIL = '[ENTITY] Create All NhisClaimInvestigationDetailModel failed',

	DELETE_NHIS_CLAIM_INVESTIGATION_DETAIL = '[ENTITY] Delete NhisClaimInvestigationDetailModel',
	DELETE_NHIS_CLAIM_INVESTIGATION_DETAIL_OK = '[ENTITY] Delete NhisClaimInvestigationDetailModel successfully',
	DELETE_NHIS_CLAIM_INVESTIGATION_DETAIL_FAIL = '[ENTITY] Delete NhisClaimInvestigationDetailModel failed',


	DELETE_NHIS_CLAIM_INVESTIGATION_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete NhisClaimInvestigationDetailModels Excluding Ids',
	DELETE_NHIS_CLAIM_INVESTIGATION_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete NhisClaimInvestigationDetailModels Excluding Ids successfully',
	DELETE_NHIS_CLAIM_INVESTIGATION_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NhisClaimInvestigationDetailModels Excluding Ids failed',

	DELETE_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL = '[ENTITY] Delete all NhisClaimInvestigationDetailModels',
	DELETE_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL_OK = '[ENTITY] Delete all NhisClaimInvestigationDetailModels successfully',
	DELETE_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL_FAIL = '[ENTITY] Delete all NhisClaimInvestigationDetailModels failed',

	UPDATE_NHIS_CLAIM_INVESTIGATION_DETAIL = '[ENTITY] Update NhisClaimInvestigationDetailModel',
	UPDATE_NHIS_CLAIM_INVESTIGATION_DETAIL_OK = '[ENTITY] Update NhisClaimInvestigationDetailModel successfully',
	UPDATE_NHIS_CLAIM_INVESTIGATION_DETAIL_FAIL = '[ENTITY] Update NhisClaimInvestigationDetailModel failed',

	UPDATE_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL = '[ENTITY] Update all NhisClaimInvestigationDetailModel',
	UPDATE_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL_OK = '[ENTITY] Update all NhisClaimInvestigationDetailModel successfully',
	UPDATE_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL_FAIL = '[ENTITY] Update all NhisClaimInvestigationDetailModel failed',

	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL= '[ENTITY] Fetch NhisClaimInvestigationDetailModel',
	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_OK = '[ENTITY] Fetch NhisClaimInvestigationDetailModel successfully',
	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_FAIL = '[ENTITY] Fetch NhisClaimInvestigationDetailModel failed',

	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_AUDIT= '[ENTITY] Fetch NhisClaimInvestigationDetailModel audit',
	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_AUDIT_OK = '[ENTITY] Fetch NhisClaimInvestigationDetailModel audit successfully',
	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch NhisClaimInvestigationDetailModel audit failed',

	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NhisClaimInvestigationDetailModel audits by entity id',
	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NhisClaimInvestigationDetailModel audits by entity id successfully',
	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NhisClaimInvestigationDetailModel audits by entity id failed',

	FETCH_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL = '[ENTITY] Fetch all NhisClaimInvestigationDetailModel',
	FETCH_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL_OK = '[ENTITY] Fetch all NhisClaimInvestigationDetailModel successfully',
	FETCH_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL_FAIL = '[ENTITY] Fetch all NhisClaimInvestigationDetailModel failed',

	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_WITH_QUERY = '[ENTITY] Fetch NhisClaimInvestigationDetailModel with query',
	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch NhisClaimInvestigationDetailModel with query successfully',
	FETCH_NHIS_CLAIM_INVESTIGATION_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch NhisClaimInvestigationDetailModel with query failed',

	FETCH_LAST_NHIS_CLAIM_INVESTIGATION_DETAIL_WITH_QUERY = '[ENTITY] Fetch last NhisClaimInvestigationDetailModel with query',
	FETCH_LAST_NHIS_CLAIM_INVESTIGATION_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last NhisClaimInvestigationDetailModel with query successfully',
	FETCH_LAST_NHIS_CLAIM_INVESTIGATION_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last NhisClaimInvestigationDetailModel with query failed',

	EXPORT_NHIS_CLAIM_INVESTIGATION_DETAIL = '[ENTITY] Export NhisClaimInvestigationDetailModel',
	EXPORT_NHIS_CLAIM_INVESTIGATION_DETAIL_OK = '[ENTITY] Export NhisClaimInvestigationDetailModel successfully',
	EXPORT_NHIS_CLAIM_INVESTIGATION_DETAIL_FAIL = '[ENTITY] Export NhisClaimInvestigationDetailModel failed',

	EXPORT_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL = '[ENTITY] Export All NhisClaimInvestigationDetailModels',
	EXPORT_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL_OK = '[ENTITY] Export All NhisClaimInvestigationDetailModels successfully',
	EXPORT_ALL_NHIS_CLAIM_INVESTIGATION_DETAIL_FAIL = '[ENTITY] Export All NhisClaimInvestigationDetailModels failed',

	EXPORT_NHIS_CLAIM_INVESTIGATION_DETAIL_EXCLUDING_IDS = '[ENTITY] Export NhisClaimInvestigationDetailModels excluding Ids',
	EXPORT_NHIS_CLAIM_INVESTIGATION_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export NhisClaimInvestigationDetailModel excluding Ids successfully',
	EXPORT_NHIS_CLAIM_INVESTIGATION_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export NhisClaimInvestigationDetailModel excluding Ids failed',

	COUNT_NHIS_CLAIM_INVESTIGATION_DETAILS = '[ENTITY] Fetch number of NhisClaimInvestigationDetailModel records',
	COUNT_NHIS_CLAIM_INVESTIGATION_DETAILS_OK = '[ENTITY] Fetch number of NhisClaimInvestigationDetailModel records successfully ',
	COUNT_NHIS_CLAIM_INVESTIGATION_DETAILS_FAIL = '[ENTITY] Fetch number of NhisClaimInvestigationDetailModel records failed',

	IMPORT_NHIS_CLAIM_INVESTIGATION_DETAILS = '[ENTITY] Import NhisClaimInvestigationDetailModels',
	IMPORT_NHIS_CLAIM_INVESTIGATION_DETAILS_OK = '[ENTITY] Import NhisClaimInvestigationDetailModels successfully',
	IMPORT_NHIS_CLAIM_INVESTIGATION_DETAILS_FAIL = '[ENTITY] Import NhisClaimInvestigationDetailModels fail',


	INITIALISE_NHIS_CLAIM_INVESTIGATION_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NhisClaimInvestigationDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNhisClaimInvestigationDetailAction implements Action {
	readonly className: string = 'NhisClaimInvestigationDetailModel';

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

export class NhisClaimInvestigationDetailAction extends BaseNhisClaimInvestigationDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisClaimInvestigationDetailAction here] off begin
	// % protected region % [Add any additional class fields for NhisClaimInvestigationDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisClaimInvestigationDetailModel>,
		// % protected region % [Add any additional constructor parameters for NhisClaimInvestigationDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for NhisClaimInvestigationDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisClaimInvestigationDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for NhisClaimInvestigationDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisClaimInvestigationDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for NhisClaimInvestigationDetailAction here] end
	}

	// % protected region % [Add any additional class methods for NhisClaimInvestigationDetailAction here] off begin
	// % protected region % [Add any additional class methods for NhisClaimInvestigationDetailAction here] end
}

export class NhisClaimInvestigationDetailActionOK extends BaseNhisClaimInvestigationDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisClaimInvestigationDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for NhisClaimInvestigationDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisClaimInvestigationDetailModel>,
		// % protected region % [Add any additional constructor parameters for NhisClaimInvestigationDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NhisClaimInvestigationDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NhisClaimInvestigationDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisClaimInvestigationDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NhisClaimInvestigationDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisClaimInvestigationDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NhisClaimInvestigationDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for NhisClaimInvestigationDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for NhisClaimInvestigationDetailActionOK here] end
}

export class NhisClaimInvestigationDetailActionFail extends BaseNhisClaimInvestigationDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisClaimInvestigationDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for NhisClaimInvestigationDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NhisClaimInvestigationDetailModel>,
		// % protected region % [Add any additional constructor parameters for NhisClaimInvestigationDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NhisClaimInvestigationDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisClaimInvestigationDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NhisClaimInvestigationDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisClaimInvestigationDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NhisClaimInvestigationDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for NhisClaimInvestigationDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for NhisClaimInvestigationDetailActionFail here] end
}

export function isNhisClaimInvestigationDetailModelAction(e: any): e is BaseNhisClaimInvestigationDetailAction {
	return Object.values(NhisClaimInvestigationDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
