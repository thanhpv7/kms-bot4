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
import {PcareClubProlanisModel} from './pcare_club_prolanis.model';
import {PcareClubProlanisModelAudit} from './pcare_club_prolanis.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare Club Prolanis model actions to be dispatched by NgRx.
 */
export enum PcareClubProlanisModelActionTypes {
	CREATE_PCARE_CLUB_PROLANIS = '[ENTITY] Create PcareClubProlanisModel',
	CREATE_PCARE_CLUB_PROLANIS_OK = '[ENTITY] Create PcareClubProlanisModel successfully',
	CREATE_PCARE_CLUB_PROLANIS_FAIL = '[ENTITY] Create PcareClubProlanisModel failed',

	CREATE_ALL_PCARE_CLUB_PROLANIS = '[ENTITY] Create All PcareClubProlanisModel',
	CREATE_ALL_PCARE_CLUB_PROLANIS_OK = '[ENTITY] Create All PcareClubProlanisModel successfully',
	CREATE_ALL_PCARE_CLUB_PROLANIS_FAIL = '[ENTITY] Create All PcareClubProlanisModel failed',

	DELETE_PCARE_CLUB_PROLANIS = '[ENTITY] Delete PcareClubProlanisModel',
	DELETE_PCARE_CLUB_PROLANIS_OK = '[ENTITY] Delete PcareClubProlanisModel successfully',
	DELETE_PCARE_CLUB_PROLANIS_FAIL = '[ENTITY] Delete PcareClubProlanisModel failed',


	DELETE_PCARE_CLUB_PROLANIS_EXCLUDING_IDS = '[ENTITY] Delete PcareClubProlanisModels Excluding Ids',
	DELETE_PCARE_CLUB_PROLANIS_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareClubProlanisModels Excluding Ids successfully',
	DELETE_PCARE_CLUB_PROLANIS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareClubProlanisModels Excluding Ids failed',

	DELETE_ALL_PCARE_CLUB_PROLANIS = '[ENTITY] Delete all PcareClubProlanisModels',
	DELETE_ALL_PCARE_CLUB_PROLANIS_OK = '[ENTITY] Delete all PcareClubProlanisModels successfully',
	DELETE_ALL_PCARE_CLUB_PROLANIS_FAIL = '[ENTITY] Delete all PcareClubProlanisModels failed',

	UPDATE_PCARE_CLUB_PROLANIS = '[ENTITY] Update PcareClubProlanisModel',
	UPDATE_PCARE_CLUB_PROLANIS_OK = '[ENTITY] Update PcareClubProlanisModel successfully',
	UPDATE_PCARE_CLUB_PROLANIS_FAIL = '[ENTITY] Update PcareClubProlanisModel failed',

	UPDATE_ALL_PCARE_CLUB_PROLANIS = '[ENTITY] Update all PcareClubProlanisModel',
	UPDATE_ALL_PCARE_CLUB_PROLANIS_OK = '[ENTITY] Update all PcareClubProlanisModel successfully',
	UPDATE_ALL_PCARE_CLUB_PROLANIS_FAIL = '[ENTITY] Update all PcareClubProlanisModel failed',

	FETCH_PCARE_CLUB_PROLANIS= '[ENTITY] Fetch PcareClubProlanisModel',
	FETCH_PCARE_CLUB_PROLANIS_OK = '[ENTITY] Fetch PcareClubProlanisModel successfully',
	FETCH_PCARE_CLUB_PROLANIS_FAIL = '[ENTITY] Fetch PcareClubProlanisModel failed',

	FETCH_PCARE_CLUB_PROLANIS_AUDIT= '[ENTITY] Fetch PcareClubProlanisModel audit',
	FETCH_PCARE_CLUB_PROLANIS_AUDIT_OK = '[ENTITY] Fetch PcareClubProlanisModel audit successfully',
	FETCH_PCARE_CLUB_PROLANIS_AUDIT_FAIL = '[ENTITY] Fetch PcareClubProlanisModel audit failed',

	FETCH_PCARE_CLUB_PROLANIS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareClubProlanisModel audits by entity id',
	FETCH_PCARE_CLUB_PROLANIS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareClubProlanisModel audits by entity id successfully',
	FETCH_PCARE_CLUB_PROLANIS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareClubProlanisModel audits by entity id failed',

	FETCH_ALL_PCARE_CLUB_PROLANIS = '[ENTITY] Fetch all PcareClubProlanisModel',
	FETCH_ALL_PCARE_CLUB_PROLANIS_OK = '[ENTITY] Fetch all PcareClubProlanisModel successfully',
	FETCH_ALL_PCARE_CLUB_PROLANIS_FAIL = '[ENTITY] Fetch all PcareClubProlanisModel failed',

	FETCH_PCARE_CLUB_PROLANIS_WITH_QUERY = '[ENTITY] Fetch PcareClubProlanisModel with query',
	FETCH_PCARE_CLUB_PROLANIS_WITH_QUERY_OK = '[ENTITY] Fetch PcareClubProlanisModel with query successfully',
	FETCH_PCARE_CLUB_PROLANIS_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareClubProlanisModel with query failed',

	FETCH_LAST_PCARE_CLUB_PROLANIS_WITH_QUERY = '[ENTITY] Fetch last PcareClubProlanisModel with query',
	FETCH_LAST_PCARE_CLUB_PROLANIS_WITH_QUERY_OK = '[ENTITY] Fetch last PcareClubProlanisModel with query successfully',
	FETCH_LAST_PCARE_CLUB_PROLANIS_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareClubProlanisModel with query failed',

	EXPORT_PCARE_CLUB_PROLANIS = '[ENTITY] Export PcareClubProlanisModel',
	EXPORT_PCARE_CLUB_PROLANIS_OK = '[ENTITY] Export PcareClubProlanisModel successfully',
	EXPORT_PCARE_CLUB_PROLANIS_FAIL = '[ENTITY] Export PcareClubProlanisModel failed',

	EXPORT_ALL_PCARE_CLUB_PROLANIS = '[ENTITY] Export All PcareClubProlanisModels',
	EXPORT_ALL_PCARE_CLUB_PROLANIS_OK = '[ENTITY] Export All PcareClubProlanisModels successfully',
	EXPORT_ALL_PCARE_CLUB_PROLANIS_FAIL = '[ENTITY] Export All PcareClubProlanisModels failed',

	EXPORT_PCARE_CLUB_PROLANIS_EXCLUDING_IDS = '[ENTITY] Export PcareClubProlanisModels excluding Ids',
	EXPORT_PCARE_CLUB_PROLANIS_EXCLUDING_IDS_OK = '[ENTITY] Export PcareClubProlanisModel excluding Ids successfully',
	EXPORT_PCARE_CLUB_PROLANIS_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareClubProlanisModel excluding Ids failed',

	COUNT_PCARE_CLUB_PROLANISS = '[ENTITY] Fetch number of PcareClubProlanisModel records',
	COUNT_PCARE_CLUB_PROLANISS_OK = '[ENTITY] Fetch number of PcareClubProlanisModel records successfully ',
	COUNT_PCARE_CLUB_PROLANISS_FAIL = '[ENTITY] Fetch number of PcareClubProlanisModel records failed',

	IMPORT_PCARE_CLUB_PROLANISS = '[ENTITY] Import PcareClubProlanisModels',
	IMPORT_PCARE_CLUB_PROLANISS_OK = '[ENTITY] Import PcareClubProlanisModels successfully',
	IMPORT_PCARE_CLUB_PROLANISS_FAIL = '[ENTITY] Import PcareClubProlanisModels fail',


	INITIALISE_PCARE_CLUB_PROLANIS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareClubProlanisModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareClubProlanisAction implements Action {
	readonly className: string = 'PcareClubProlanisModel';

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

export class PcareClubProlanisAction extends BasePcareClubProlanisAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareClubProlanisAction here] off begin
	// % protected region % [Add any additional class fields for PcareClubProlanisAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareClubProlanisModel>,
		// % protected region % [Add any additional constructor parameters for PcareClubProlanisAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareClubProlanisAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareClubProlanisAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareClubProlanisAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareClubProlanisAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareClubProlanisAction here] end
	}

	// % protected region % [Add any additional class methods for PcareClubProlanisAction here] off begin
	// % protected region % [Add any additional class methods for PcareClubProlanisAction here] end
}

export class PcareClubProlanisActionOK extends BasePcareClubProlanisAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareClubProlanisActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareClubProlanisActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareClubProlanisModel>,
		// % protected region % [Add any additional constructor parameters for PcareClubProlanisActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareClubProlanisActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareClubProlanisModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareClubProlanisActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareClubProlanisActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareClubProlanisActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareClubProlanisActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareClubProlanisActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareClubProlanisActionOK here] end
}

export class PcareClubProlanisActionFail extends BasePcareClubProlanisAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareClubProlanisActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareClubProlanisActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareClubProlanisModel>,
		// % protected region % [Add any additional constructor parameters for PcareClubProlanisActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareClubProlanisActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareClubProlanisActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareClubProlanisActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareClubProlanisActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareClubProlanisActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareClubProlanisActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareClubProlanisActionFail here] end
}

export function isPcareClubProlanisModelAction(e: any): e is BasePcareClubProlanisAction {
	return Object.values(PcareClubProlanisModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
