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
import {PcareReferensiSaranaModel} from './pcare_referensi_sarana.model';
import {PcareReferensiSaranaModelAudit} from './pcare_referensi_sarana.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare Referensi Sarana model actions to be dispatched by NgRx.
 */
export enum PcareReferensiSaranaModelActionTypes {
	CREATE_PCARE_REFERENSI_SARANA = '[ENTITY] Create PcareReferensiSaranaModel',
	CREATE_PCARE_REFERENSI_SARANA_OK = '[ENTITY] Create PcareReferensiSaranaModel successfully',
	CREATE_PCARE_REFERENSI_SARANA_FAIL = '[ENTITY] Create PcareReferensiSaranaModel failed',

	CREATE_ALL_PCARE_REFERENSI_SARANA = '[ENTITY] Create All PcareReferensiSaranaModel',
	CREATE_ALL_PCARE_REFERENSI_SARANA_OK = '[ENTITY] Create All PcareReferensiSaranaModel successfully',
	CREATE_ALL_PCARE_REFERENSI_SARANA_FAIL = '[ENTITY] Create All PcareReferensiSaranaModel failed',

	DELETE_PCARE_REFERENSI_SARANA = '[ENTITY] Delete PcareReferensiSaranaModel',
	DELETE_PCARE_REFERENSI_SARANA_OK = '[ENTITY] Delete PcareReferensiSaranaModel successfully',
	DELETE_PCARE_REFERENSI_SARANA_FAIL = '[ENTITY] Delete PcareReferensiSaranaModel failed',


	DELETE_PCARE_REFERENSI_SARANA_EXCLUDING_IDS = '[ENTITY] Delete PcareReferensiSaranaModels Excluding Ids',
	DELETE_PCARE_REFERENSI_SARANA_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareReferensiSaranaModels Excluding Ids successfully',
	DELETE_PCARE_REFERENSI_SARANA_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareReferensiSaranaModels Excluding Ids failed',

	DELETE_ALL_PCARE_REFERENSI_SARANA = '[ENTITY] Delete all PcareReferensiSaranaModels',
	DELETE_ALL_PCARE_REFERENSI_SARANA_OK = '[ENTITY] Delete all PcareReferensiSaranaModels successfully',
	DELETE_ALL_PCARE_REFERENSI_SARANA_FAIL = '[ENTITY] Delete all PcareReferensiSaranaModels failed',

	UPDATE_PCARE_REFERENSI_SARANA = '[ENTITY] Update PcareReferensiSaranaModel',
	UPDATE_PCARE_REFERENSI_SARANA_OK = '[ENTITY] Update PcareReferensiSaranaModel successfully',
	UPDATE_PCARE_REFERENSI_SARANA_FAIL = '[ENTITY] Update PcareReferensiSaranaModel failed',

	UPDATE_ALL_PCARE_REFERENSI_SARANA = '[ENTITY] Update all PcareReferensiSaranaModel',
	UPDATE_ALL_PCARE_REFERENSI_SARANA_OK = '[ENTITY] Update all PcareReferensiSaranaModel successfully',
	UPDATE_ALL_PCARE_REFERENSI_SARANA_FAIL = '[ENTITY] Update all PcareReferensiSaranaModel failed',

	FETCH_PCARE_REFERENSI_SARANA= '[ENTITY] Fetch PcareReferensiSaranaModel',
	FETCH_PCARE_REFERENSI_SARANA_OK = '[ENTITY] Fetch PcareReferensiSaranaModel successfully',
	FETCH_PCARE_REFERENSI_SARANA_FAIL = '[ENTITY] Fetch PcareReferensiSaranaModel failed',

	FETCH_PCARE_REFERENSI_SARANA_AUDIT= '[ENTITY] Fetch PcareReferensiSaranaModel audit',
	FETCH_PCARE_REFERENSI_SARANA_AUDIT_OK = '[ENTITY] Fetch PcareReferensiSaranaModel audit successfully',
	FETCH_PCARE_REFERENSI_SARANA_AUDIT_FAIL = '[ENTITY] Fetch PcareReferensiSaranaModel audit failed',

	FETCH_PCARE_REFERENSI_SARANA_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareReferensiSaranaModel audits by entity id',
	FETCH_PCARE_REFERENSI_SARANA_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareReferensiSaranaModel audits by entity id successfully',
	FETCH_PCARE_REFERENSI_SARANA_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareReferensiSaranaModel audits by entity id failed',

	FETCH_ALL_PCARE_REFERENSI_SARANA = '[ENTITY] Fetch all PcareReferensiSaranaModel',
	FETCH_ALL_PCARE_REFERENSI_SARANA_OK = '[ENTITY] Fetch all PcareReferensiSaranaModel successfully',
	FETCH_ALL_PCARE_REFERENSI_SARANA_FAIL = '[ENTITY] Fetch all PcareReferensiSaranaModel failed',

	FETCH_PCARE_REFERENSI_SARANA_WITH_QUERY = '[ENTITY] Fetch PcareReferensiSaranaModel with query',
	FETCH_PCARE_REFERENSI_SARANA_WITH_QUERY_OK = '[ENTITY] Fetch PcareReferensiSaranaModel with query successfully',
	FETCH_PCARE_REFERENSI_SARANA_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareReferensiSaranaModel with query failed',

	FETCH_LAST_PCARE_REFERENSI_SARANA_WITH_QUERY = '[ENTITY] Fetch last PcareReferensiSaranaModel with query',
	FETCH_LAST_PCARE_REFERENSI_SARANA_WITH_QUERY_OK = '[ENTITY] Fetch last PcareReferensiSaranaModel with query successfully',
	FETCH_LAST_PCARE_REFERENSI_SARANA_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareReferensiSaranaModel with query failed',

	EXPORT_PCARE_REFERENSI_SARANA = '[ENTITY] Export PcareReferensiSaranaModel',
	EXPORT_PCARE_REFERENSI_SARANA_OK = '[ENTITY] Export PcareReferensiSaranaModel successfully',
	EXPORT_PCARE_REFERENSI_SARANA_FAIL = '[ENTITY] Export PcareReferensiSaranaModel failed',

	EXPORT_ALL_PCARE_REFERENSI_SARANA = '[ENTITY] Export All PcareReferensiSaranaModels',
	EXPORT_ALL_PCARE_REFERENSI_SARANA_OK = '[ENTITY] Export All PcareReferensiSaranaModels successfully',
	EXPORT_ALL_PCARE_REFERENSI_SARANA_FAIL = '[ENTITY] Export All PcareReferensiSaranaModels failed',

	EXPORT_PCARE_REFERENSI_SARANA_EXCLUDING_IDS = '[ENTITY] Export PcareReferensiSaranaModels excluding Ids',
	EXPORT_PCARE_REFERENSI_SARANA_EXCLUDING_IDS_OK = '[ENTITY] Export PcareReferensiSaranaModel excluding Ids successfully',
	EXPORT_PCARE_REFERENSI_SARANA_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareReferensiSaranaModel excluding Ids failed',

	COUNT_PCARE_REFERENSI_SARANAS = '[ENTITY] Fetch number of PcareReferensiSaranaModel records',
	COUNT_PCARE_REFERENSI_SARANAS_OK = '[ENTITY] Fetch number of PcareReferensiSaranaModel records successfully ',
	COUNT_PCARE_REFERENSI_SARANAS_FAIL = '[ENTITY] Fetch number of PcareReferensiSaranaModel records failed',

	IMPORT_PCARE_REFERENSI_SARANAS = '[ENTITY] Import PcareReferensiSaranaModels',
	IMPORT_PCARE_REFERENSI_SARANAS_OK = '[ENTITY] Import PcareReferensiSaranaModels successfully',
	IMPORT_PCARE_REFERENSI_SARANAS_FAIL = '[ENTITY] Import PcareReferensiSaranaModels fail',


	INITIALISE_PCARE_REFERENSI_SARANA_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareReferensiSaranaModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareReferensiSaranaAction implements Action {
	readonly className: string = 'PcareReferensiSaranaModel';

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

export class PcareReferensiSaranaAction extends BasePcareReferensiSaranaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareReferensiSaranaAction here] off begin
	// % protected region % [Add any additional class fields for PcareReferensiSaranaAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareReferensiSaranaModel>,
		// % protected region % [Add any additional constructor parameters for PcareReferensiSaranaAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareReferensiSaranaAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareReferensiSaranaAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareReferensiSaranaAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareReferensiSaranaAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareReferensiSaranaAction here] end
	}

	// % protected region % [Add any additional class methods for PcareReferensiSaranaAction here] off begin
	// % protected region % [Add any additional class methods for PcareReferensiSaranaAction here] end
}

export class PcareReferensiSaranaActionOK extends BasePcareReferensiSaranaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareReferensiSaranaActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareReferensiSaranaActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareReferensiSaranaModel>,
		// % protected region % [Add any additional constructor parameters for PcareReferensiSaranaActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareReferensiSaranaActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareReferensiSaranaModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareReferensiSaranaActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareReferensiSaranaActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareReferensiSaranaActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareReferensiSaranaActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareReferensiSaranaActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareReferensiSaranaActionOK here] end
}

export class PcareReferensiSaranaActionFail extends BasePcareReferensiSaranaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareReferensiSaranaActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareReferensiSaranaActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareReferensiSaranaModel>,
		// % protected region % [Add any additional constructor parameters for PcareReferensiSaranaActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareReferensiSaranaActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareReferensiSaranaActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareReferensiSaranaActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareReferensiSaranaActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareReferensiSaranaActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareReferensiSaranaActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareReferensiSaranaActionFail here] end
}

export function isPcareReferensiSaranaModelAction(e: any): e is BasePcareReferensiSaranaAction {
	return Object.values(PcareReferensiSaranaModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
