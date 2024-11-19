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
import {PrescriptionHeaderModel} from './prescription_header.model';
import {PrescriptionHeaderModelAudit} from './prescription_header.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Prescription Header model actions to be dispatched by NgRx.
 */
export enum PrescriptionHeaderModelActionTypes {
	CREATE_PRESCRIPTION_HEADER = '[ENTITY] Create PrescriptionHeaderModel',
	CREATE_PRESCRIPTION_HEADER_OK = '[ENTITY] Create PrescriptionHeaderModel successfully',
	CREATE_PRESCRIPTION_HEADER_FAIL = '[ENTITY] Create PrescriptionHeaderModel failed',

	CREATE_ALL_PRESCRIPTION_HEADER = '[ENTITY] Create All PrescriptionHeaderModel',
	CREATE_ALL_PRESCRIPTION_HEADER_OK = '[ENTITY] Create All PrescriptionHeaderModel successfully',
	CREATE_ALL_PRESCRIPTION_HEADER_FAIL = '[ENTITY] Create All PrescriptionHeaderModel failed',

	DELETE_PRESCRIPTION_HEADER = '[ENTITY] Delete PrescriptionHeaderModel',
	DELETE_PRESCRIPTION_HEADER_OK = '[ENTITY] Delete PrescriptionHeaderModel successfully',
	DELETE_PRESCRIPTION_HEADER_FAIL = '[ENTITY] Delete PrescriptionHeaderModel failed',


	DELETE_PRESCRIPTION_HEADER_EXCLUDING_IDS = '[ENTITY] Delete PrescriptionHeaderModels Excluding Ids',
	DELETE_PRESCRIPTION_HEADER_EXCLUDING_IDS_OK = '[ENTITY] Delete PrescriptionHeaderModels Excluding Ids successfully',
	DELETE_PRESCRIPTION_HEADER_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PrescriptionHeaderModels Excluding Ids failed',

	DELETE_ALL_PRESCRIPTION_HEADER = '[ENTITY] Delete all PrescriptionHeaderModels',
	DELETE_ALL_PRESCRIPTION_HEADER_OK = '[ENTITY] Delete all PrescriptionHeaderModels successfully',
	DELETE_ALL_PRESCRIPTION_HEADER_FAIL = '[ENTITY] Delete all PrescriptionHeaderModels failed',

	UPDATE_PRESCRIPTION_HEADER = '[ENTITY] Update PrescriptionHeaderModel',
	UPDATE_PRESCRIPTION_HEADER_OK = '[ENTITY] Update PrescriptionHeaderModel successfully',
	UPDATE_PRESCRIPTION_HEADER_FAIL = '[ENTITY] Update PrescriptionHeaderModel failed',

	UPDATE_ALL_PRESCRIPTION_HEADER = '[ENTITY] Update all PrescriptionHeaderModel',
	UPDATE_ALL_PRESCRIPTION_HEADER_OK = '[ENTITY] Update all PrescriptionHeaderModel successfully',
	UPDATE_ALL_PRESCRIPTION_HEADER_FAIL = '[ENTITY] Update all PrescriptionHeaderModel failed',

	FETCH_PRESCRIPTION_HEADER= '[ENTITY] Fetch PrescriptionHeaderModel',
	FETCH_PRESCRIPTION_HEADER_OK = '[ENTITY] Fetch PrescriptionHeaderModel successfully',
	FETCH_PRESCRIPTION_HEADER_FAIL = '[ENTITY] Fetch PrescriptionHeaderModel failed',

	FETCH_PRESCRIPTION_HEADER_AUDIT= '[ENTITY] Fetch PrescriptionHeaderModel audit',
	FETCH_PRESCRIPTION_HEADER_AUDIT_OK = '[ENTITY] Fetch PrescriptionHeaderModel audit successfully',
	FETCH_PRESCRIPTION_HEADER_AUDIT_FAIL = '[ENTITY] Fetch PrescriptionHeaderModel audit failed',

	FETCH_PRESCRIPTION_HEADER_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PrescriptionHeaderModel audits by entity id',
	FETCH_PRESCRIPTION_HEADER_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PrescriptionHeaderModel audits by entity id successfully',
	FETCH_PRESCRIPTION_HEADER_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PrescriptionHeaderModel audits by entity id failed',

	FETCH_ALL_PRESCRIPTION_HEADER = '[ENTITY] Fetch all PrescriptionHeaderModel',
	FETCH_ALL_PRESCRIPTION_HEADER_OK = '[ENTITY] Fetch all PrescriptionHeaderModel successfully',
	FETCH_ALL_PRESCRIPTION_HEADER_FAIL = '[ENTITY] Fetch all PrescriptionHeaderModel failed',

	FETCH_PRESCRIPTION_HEADER_WITH_QUERY = '[ENTITY] Fetch PrescriptionHeaderModel with query',
	FETCH_PRESCRIPTION_HEADER_WITH_QUERY_OK = '[ENTITY] Fetch PrescriptionHeaderModel with query successfully',
	FETCH_PRESCRIPTION_HEADER_WITH_QUERY_FAIL = '[ENTITY] Fetch PrescriptionHeaderModel with query failed',

	FETCH_LAST_PRESCRIPTION_HEADER_WITH_QUERY = '[ENTITY] Fetch last PrescriptionHeaderModel with query',
	FETCH_LAST_PRESCRIPTION_HEADER_WITH_QUERY_OK = '[ENTITY] Fetch last PrescriptionHeaderModel with query successfully',
	FETCH_LAST_PRESCRIPTION_HEADER_WITH_QUERY_FAIL = '[ENTITY] Fetch last PrescriptionHeaderModel with query failed',

	EXPORT_PRESCRIPTION_HEADER = '[ENTITY] Export PrescriptionHeaderModel',
	EXPORT_PRESCRIPTION_HEADER_OK = '[ENTITY] Export PrescriptionHeaderModel successfully',
	EXPORT_PRESCRIPTION_HEADER_FAIL = '[ENTITY] Export PrescriptionHeaderModel failed',

	EXPORT_ALL_PRESCRIPTION_HEADER = '[ENTITY] Export All PrescriptionHeaderModels',
	EXPORT_ALL_PRESCRIPTION_HEADER_OK = '[ENTITY] Export All PrescriptionHeaderModels successfully',
	EXPORT_ALL_PRESCRIPTION_HEADER_FAIL = '[ENTITY] Export All PrescriptionHeaderModels failed',

	EXPORT_PRESCRIPTION_HEADER_EXCLUDING_IDS = '[ENTITY] Export PrescriptionHeaderModels excluding Ids',
	EXPORT_PRESCRIPTION_HEADER_EXCLUDING_IDS_OK = '[ENTITY] Export PrescriptionHeaderModel excluding Ids successfully',
	EXPORT_PRESCRIPTION_HEADER_EXCLUDING_IDS_FAIL = '[ENTITY] Export PrescriptionHeaderModel excluding Ids failed',

	COUNT_PRESCRIPTION_HEADERS = '[ENTITY] Fetch number of PrescriptionHeaderModel records',
	COUNT_PRESCRIPTION_HEADERS_OK = '[ENTITY] Fetch number of PrescriptionHeaderModel records successfully ',
	COUNT_PRESCRIPTION_HEADERS_FAIL = '[ENTITY] Fetch number of PrescriptionHeaderModel records failed',

	IMPORT_PRESCRIPTION_HEADERS = '[ENTITY] Import PrescriptionHeaderModels',
	IMPORT_PRESCRIPTION_HEADERS_OK = '[ENTITY] Import PrescriptionHeaderModels successfully',
	IMPORT_PRESCRIPTION_HEADERS_FAIL = '[ENTITY] Import PrescriptionHeaderModels fail',


	INITIALISE_PRESCRIPTION_HEADER_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PrescriptionHeaderModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePrescriptionHeaderAction implements Action {
	readonly className: string = 'PrescriptionHeaderModel';

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

export class PrescriptionHeaderAction extends BasePrescriptionHeaderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrescriptionHeaderAction here] off begin
	// % protected region % [Add any additional class fields for PrescriptionHeaderAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PrescriptionHeaderModel>,
		// % protected region % [Add any additional constructor parameters for PrescriptionHeaderAction here] off begin
		// % protected region % [Add any additional constructor parameters for PrescriptionHeaderAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrescriptionHeaderAction here] off begin
			// % protected region % [Add any additional constructor arguments for PrescriptionHeaderAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrescriptionHeaderAction here] off begin
		// % protected region % [Add any additional constructor logic for PrescriptionHeaderAction here] end
	}

	// % protected region % [Add any additional class methods for PrescriptionHeaderAction here] off begin
	// % protected region % [Add any additional class methods for PrescriptionHeaderAction here] end
}

export class PrescriptionHeaderActionOK extends BasePrescriptionHeaderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrescriptionHeaderActionOK here] off begin
	// % protected region % [Add any additional class fields for PrescriptionHeaderActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PrescriptionHeaderModel>,
		// % protected region % [Add any additional constructor parameters for PrescriptionHeaderActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PrescriptionHeaderActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PrescriptionHeaderModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrescriptionHeaderActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PrescriptionHeaderActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrescriptionHeaderActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PrescriptionHeaderActionOK here] end
	}

	// % protected region % [Add any additional class methods for PrescriptionHeaderActionOK here] off begin
	// % protected region % [Add any additional class methods for PrescriptionHeaderActionOK here] end
}

export class PrescriptionHeaderActionFail extends BasePrescriptionHeaderAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PrescriptionHeaderActionFail here] off begin
	// % protected region % [Add any additional class fields for PrescriptionHeaderActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PrescriptionHeaderModel>,
		// % protected region % [Add any additional constructor parameters for PrescriptionHeaderActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PrescriptionHeaderActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PrescriptionHeaderActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PrescriptionHeaderActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PrescriptionHeaderActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PrescriptionHeaderActionFail here] end
	}

	// % protected region % [Add any additional class methods for PrescriptionHeaderActionFail here] off begin
	// % protected region % [Add any additional class methods for PrescriptionHeaderActionFail here] end
}

export function isPrescriptionHeaderModelAction(e: any): e is BasePrescriptionHeaderAction {
	return Object.values(PrescriptionHeaderModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
