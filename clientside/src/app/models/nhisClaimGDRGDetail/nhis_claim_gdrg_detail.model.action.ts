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
import {NhisClaimGDRGDetailModel} from './nhis_claim_gdrg_detail.model';
import {NhisClaimGDRGDetailModelAudit} from './nhis_claim_gdrg_detail.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of NHIS Claim GDRG Detail model actions to be dispatched by NgRx.
 */
export enum NhisClaimGDRGDetailModelActionTypes {
	CREATE_NHIS_CLAIM_GDRG_DETAIL = '[ENTITY] Create NhisClaimGDRGDetailModel',
	CREATE_NHIS_CLAIM_GDRG_DETAIL_OK = '[ENTITY] Create NhisClaimGDRGDetailModel successfully',
	CREATE_NHIS_CLAIM_GDRG_DETAIL_FAIL = '[ENTITY] Create NhisClaimGDRGDetailModel failed',

	CREATE_ALL_NHIS_CLAIM_GDRG_DETAIL = '[ENTITY] Create All NhisClaimGDRGDetailModel',
	CREATE_ALL_NHIS_CLAIM_GDRG_DETAIL_OK = '[ENTITY] Create All NhisClaimGDRGDetailModel successfully',
	CREATE_ALL_NHIS_CLAIM_GDRG_DETAIL_FAIL = '[ENTITY] Create All NhisClaimGDRGDetailModel failed',

	DELETE_NHIS_CLAIM_GDRG_DETAIL = '[ENTITY] Delete NhisClaimGDRGDetailModel',
	DELETE_NHIS_CLAIM_GDRG_DETAIL_OK = '[ENTITY] Delete NhisClaimGDRGDetailModel successfully',
	DELETE_NHIS_CLAIM_GDRG_DETAIL_FAIL = '[ENTITY] Delete NhisClaimGDRGDetailModel failed',


	DELETE_NHIS_CLAIM_GDRG_DETAIL_EXCLUDING_IDS = '[ENTITY] Delete NhisClaimGDRGDetailModels Excluding Ids',
	DELETE_NHIS_CLAIM_GDRG_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Delete NhisClaimGDRGDetailModels Excluding Ids successfully',
	DELETE_NHIS_CLAIM_GDRG_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NhisClaimGDRGDetailModels Excluding Ids failed',

	DELETE_ALL_NHIS_CLAIM_GDRG_DETAIL = '[ENTITY] Delete all NhisClaimGDRGDetailModels',
	DELETE_ALL_NHIS_CLAIM_GDRG_DETAIL_OK = '[ENTITY] Delete all NhisClaimGDRGDetailModels successfully',
	DELETE_ALL_NHIS_CLAIM_GDRG_DETAIL_FAIL = '[ENTITY] Delete all NhisClaimGDRGDetailModels failed',

	UPDATE_NHIS_CLAIM_GDRG_DETAIL = '[ENTITY] Update NhisClaimGDRGDetailModel',
	UPDATE_NHIS_CLAIM_GDRG_DETAIL_OK = '[ENTITY] Update NhisClaimGDRGDetailModel successfully',
	UPDATE_NHIS_CLAIM_GDRG_DETAIL_FAIL = '[ENTITY] Update NhisClaimGDRGDetailModel failed',

	UPDATE_ALL_NHIS_CLAIM_GDRG_DETAIL = '[ENTITY] Update all NhisClaimGDRGDetailModel',
	UPDATE_ALL_NHIS_CLAIM_GDRG_DETAIL_OK = '[ENTITY] Update all NhisClaimGDRGDetailModel successfully',
	UPDATE_ALL_NHIS_CLAIM_GDRG_DETAIL_FAIL = '[ENTITY] Update all NhisClaimGDRGDetailModel failed',

	FETCH_NHIS_CLAIM_GDRG_DETAIL= '[ENTITY] Fetch NhisClaimGDRGDetailModel',
	FETCH_NHIS_CLAIM_GDRG_DETAIL_OK = '[ENTITY] Fetch NhisClaimGDRGDetailModel successfully',
	FETCH_NHIS_CLAIM_GDRG_DETAIL_FAIL = '[ENTITY] Fetch NhisClaimGDRGDetailModel failed',

	FETCH_NHIS_CLAIM_GDRG_DETAIL_AUDIT= '[ENTITY] Fetch NhisClaimGDRGDetailModel audit',
	FETCH_NHIS_CLAIM_GDRG_DETAIL_AUDIT_OK = '[ENTITY] Fetch NhisClaimGDRGDetailModel audit successfully',
	FETCH_NHIS_CLAIM_GDRG_DETAIL_AUDIT_FAIL = '[ENTITY] Fetch NhisClaimGDRGDetailModel audit failed',

	FETCH_NHIS_CLAIM_GDRG_DETAIL_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NhisClaimGDRGDetailModel audits by entity id',
	FETCH_NHIS_CLAIM_GDRG_DETAIL_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NhisClaimGDRGDetailModel audits by entity id successfully',
	FETCH_NHIS_CLAIM_GDRG_DETAIL_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NhisClaimGDRGDetailModel audits by entity id failed',

	FETCH_ALL_NHIS_CLAIM_GDRG_DETAIL = '[ENTITY] Fetch all NhisClaimGDRGDetailModel',
	FETCH_ALL_NHIS_CLAIM_GDRG_DETAIL_OK = '[ENTITY] Fetch all NhisClaimGDRGDetailModel successfully',
	FETCH_ALL_NHIS_CLAIM_GDRG_DETAIL_FAIL = '[ENTITY] Fetch all NhisClaimGDRGDetailModel failed',

	FETCH_NHIS_CLAIM_GDRG_DETAIL_WITH_QUERY = '[ENTITY] Fetch NhisClaimGDRGDetailModel with query',
	FETCH_NHIS_CLAIM_GDRG_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch NhisClaimGDRGDetailModel with query successfully',
	FETCH_NHIS_CLAIM_GDRG_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch NhisClaimGDRGDetailModel with query failed',

	FETCH_LAST_NHIS_CLAIM_GDRG_DETAIL_WITH_QUERY = '[ENTITY] Fetch last NhisClaimGDRGDetailModel with query',
	FETCH_LAST_NHIS_CLAIM_GDRG_DETAIL_WITH_QUERY_OK = '[ENTITY] Fetch last NhisClaimGDRGDetailModel with query successfully',
	FETCH_LAST_NHIS_CLAIM_GDRG_DETAIL_WITH_QUERY_FAIL = '[ENTITY] Fetch last NhisClaimGDRGDetailModel with query failed',

	EXPORT_NHIS_CLAIM_GDRG_DETAIL = '[ENTITY] Export NhisClaimGDRGDetailModel',
	EXPORT_NHIS_CLAIM_GDRG_DETAIL_OK = '[ENTITY] Export NhisClaimGDRGDetailModel successfully',
	EXPORT_NHIS_CLAIM_GDRG_DETAIL_FAIL = '[ENTITY] Export NhisClaimGDRGDetailModel failed',

	EXPORT_ALL_NHIS_CLAIM_GDRG_DETAIL = '[ENTITY] Export All NhisClaimGDRGDetailModels',
	EXPORT_ALL_NHIS_CLAIM_GDRG_DETAIL_OK = '[ENTITY] Export All NhisClaimGDRGDetailModels successfully',
	EXPORT_ALL_NHIS_CLAIM_GDRG_DETAIL_FAIL = '[ENTITY] Export All NhisClaimGDRGDetailModels failed',

	EXPORT_NHIS_CLAIM_GDRG_DETAIL_EXCLUDING_IDS = '[ENTITY] Export NhisClaimGDRGDetailModels excluding Ids',
	EXPORT_NHIS_CLAIM_GDRG_DETAIL_EXCLUDING_IDS_OK = '[ENTITY] Export NhisClaimGDRGDetailModel excluding Ids successfully',
	EXPORT_NHIS_CLAIM_GDRG_DETAIL_EXCLUDING_IDS_FAIL = '[ENTITY] Export NhisClaimGDRGDetailModel excluding Ids failed',

	COUNT_NHIS_CLAIM_GDRG_DETAILS = '[ENTITY] Fetch number of NhisClaimGDRGDetailModel records',
	COUNT_NHIS_CLAIM_GDRG_DETAILS_OK = '[ENTITY] Fetch number of NhisClaimGDRGDetailModel records successfully ',
	COUNT_NHIS_CLAIM_GDRG_DETAILS_FAIL = '[ENTITY] Fetch number of NhisClaimGDRGDetailModel records failed',

	IMPORT_NHIS_CLAIM_GDRG_DETAILS = '[ENTITY] Import NhisClaimGDRGDetailModels',
	IMPORT_NHIS_CLAIM_GDRG_DETAILS_OK = '[ENTITY] Import NhisClaimGDRGDetailModels successfully',
	IMPORT_NHIS_CLAIM_GDRG_DETAILS_FAIL = '[ENTITY] Import NhisClaimGDRGDetailModels fail',


	INITIALISE_NHIS_CLAIM_GDRG_DETAIL_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NhisClaimGDRGDetailModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNhisClaimGDRGDetailAction implements Action {
	readonly className: string = 'NhisClaimGDRGDetailModel';

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

export class NhisClaimGDRGDetailAction extends BaseNhisClaimGDRGDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisClaimGDRGDetailAction here] off begin
	// % protected region % [Add any additional class fields for NhisClaimGDRGDetailAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisClaimGDRGDetailModel>,
		// % protected region % [Add any additional constructor parameters for NhisClaimGDRGDetailAction here] off begin
		// % protected region % [Add any additional constructor parameters for NhisClaimGDRGDetailAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisClaimGDRGDetailAction here] off begin
			// % protected region % [Add any additional constructor arguments for NhisClaimGDRGDetailAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisClaimGDRGDetailAction here] off begin
		// % protected region % [Add any additional constructor logic for NhisClaimGDRGDetailAction here] end
	}

	// % protected region % [Add any additional class methods for NhisClaimGDRGDetailAction here] off begin
	// % protected region % [Add any additional class methods for NhisClaimGDRGDetailAction here] end
}

export class NhisClaimGDRGDetailActionOK extends BaseNhisClaimGDRGDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisClaimGDRGDetailActionOK here] off begin
	// % protected region % [Add any additional class fields for NhisClaimGDRGDetailActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisClaimGDRGDetailModel>,
		// % protected region % [Add any additional constructor parameters for NhisClaimGDRGDetailActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NhisClaimGDRGDetailActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NhisClaimGDRGDetailModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisClaimGDRGDetailActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NhisClaimGDRGDetailActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisClaimGDRGDetailActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NhisClaimGDRGDetailActionOK here] end
	}

	// % protected region % [Add any additional class methods for NhisClaimGDRGDetailActionOK here] off begin
	// % protected region % [Add any additional class methods for NhisClaimGDRGDetailActionOK here] end
}

export class NhisClaimGDRGDetailActionFail extends BaseNhisClaimGDRGDetailAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisClaimGDRGDetailActionFail here] off begin
	// % protected region % [Add any additional class fields for NhisClaimGDRGDetailActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NhisClaimGDRGDetailModel>,
		// % protected region % [Add any additional constructor parameters for NhisClaimGDRGDetailActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NhisClaimGDRGDetailActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisClaimGDRGDetailActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NhisClaimGDRGDetailActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisClaimGDRGDetailActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NhisClaimGDRGDetailActionFail here] end
	}

	// % protected region % [Add any additional class methods for NhisClaimGDRGDetailActionFail here] off begin
	// % protected region % [Add any additional class methods for NhisClaimGDRGDetailActionFail here] end
}

export function isNhisClaimGDRGDetailModelAction(e: any): e is BaseNhisClaimGDRGDetailAction {
	return Object.values(NhisClaimGDRGDetailModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
