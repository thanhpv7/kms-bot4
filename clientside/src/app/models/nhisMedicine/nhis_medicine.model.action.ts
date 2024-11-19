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
import {NhisMedicineModel} from './nhis_medicine.model';
import {NhisMedicineModelAudit} from './nhis_medicine.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of NHIS Medicine model actions to be dispatched by NgRx.
 */
export enum NhisMedicineModelActionTypes {
	CREATE_NHIS_MEDICINE = '[ENTITY] Create NhisMedicineModel',
	CREATE_NHIS_MEDICINE_OK = '[ENTITY] Create NhisMedicineModel successfully',
	CREATE_NHIS_MEDICINE_FAIL = '[ENTITY] Create NhisMedicineModel failed',

	CREATE_ALL_NHIS_MEDICINE = '[ENTITY] Create All NhisMedicineModel',
	CREATE_ALL_NHIS_MEDICINE_OK = '[ENTITY] Create All NhisMedicineModel successfully',
	CREATE_ALL_NHIS_MEDICINE_FAIL = '[ENTITY] Create All NhisMedicineModel failed',

	DELETE_NHIS_MEDICINE = '[ENTITY] Delete NhisMedicineModel',
	DELETE_NHIS_MEDICINE_OK = '[ENTITY] Delete NhisMedicineModel successfully',
	DELETE_NHIS_MEDICINE_FAIL = '[ENTITY] Delete NhisMedicineModel failed',


	DELETE_NHIS_MEDICINE_EXCLUDING_IDS = '[ENTITY] Delete NhisMedicineModels Excluding Ids',
	DELETE_NHIS_MEDICINE_EXCLUDING_IDS_OK = '[ENTITY] Delete NhisMedicineModels Excluding Ids successfully',
	DELETE_NHIS_MEDICINE_EXCLUDING_IDS_FAIL = '[ENTITY] Delete NhisMedicineModels Excluding Ids failed',

	DELETE_ALL_NHIS_MEDICINE = '[ENTITY] Delete all NhisMedicineModels',
	DELETE_ALL_NHIS_MEDICINE_OK = '[ENTITY] Delete all NhisMedicineModels successfully',
	DELETE_ALL_NHIS_MEDICINE_FAIL = '[ENTITY] Delete all NhisMedicineModels failed',

	UPDATE_NHIS_MEDICINE = '[ENTITY] Update NhisMedicineModel',
	UPDATE_NHIS_MEDICINE_OK = '[ENTITY] Update NhisMedicineModel successfully',
	UPDATE_NHIS_MEDICINE_FAIL = '[ENTITY] Update NhisMedicineModel failed',

	UPDATE_ALL_NHIS_MEDICINE = '[ENTITY] Update all NhisMedicineModel',
	UPDATE_ALL_NHIS_MEDICINE_OK = '[ENTITY] Update all NhisMedicineModel successfully',
	UPDATE_ALL_NHIS_MEDICINE_FAIL = '[ENTITY] Update all NhisMedicineModel failed',

	FETCH_NHIS_MEDICINE= '[ENTITY] Fetch NhisMedicineModel',
	FETCH_NHIS_MEDICINE_OK = '[ENTITY] Fetch NhisMedicineModel successfully',
	FETCH_NHIS_MEDICINE_FAIL = '[ENTITY] Fetch NhisMedicineModel failed',

	FETCH_NHIS_MEDICINE_AUDIT= '[ENTITY] Fetch NhisMedicineModel audit',
	FETCH_NHIS_MEDICINE_AUDIT_OK = '[ENTITY] Fetch NhisMedicineModel audit successfully',
	FETCH_NHIS_MEDICINE_AUDIT_FAIL = '[ENTITY] Fetch NhisMedicineModel audit failed',

	FETCH_NHIS_MEDICINE_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch NhisMedicineModel audits by entity id',
	FETCH_NHIS_MEDICINE_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch NhisMedicineModel audits by entity id successfully',
	FETCH_NHIS_MEDICINE_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch NhisMedicineModel audits by entity id failed',

	FETCH_ALL_NHIS_MEDICINE = '[ENTITY] Fetch all NhisMedicineModel',
	FETCH_ALL_NHIS_MEDICINE_OK = '[ENTITY] Fetch all NhisMedicineModel successfully',
	FETCH_ALL_NHIS_MEDICINE_FAIL = '[ENTITY] Fetch all NhisMedicineModel failed',

	FETCH_NHIS_MEDICINE_WITH_QUERY = '[ENTITY] Fetch NhisMedicineModel with query',
	FETCH_NHIS_MEDICINE_WITH_QUERY_OK = '[ENTITY] Fetch NhisMedicineModel with query successfully',
	FETCH_NHIS_MEDICINE_WITH_QUERY_FAIL = '[ENTITY] Fetch NhisMedicineModel with query failed',

	FETCH_LAST_NHIS_MEDICINE_WITH_QUERY = '[ENTITY] Fetch last NhisMedicineModel with query',
	FETCH_LAST_NHIS_MEDICINE_WITH_QUERY_OK = '[ENTITY] Fetch last NhisMedicineModel with query successfully',
	FETCH_LAST_NHIS_MEDICINE_WITH_QUERY_FAIL = '[ENTITY] Fetch last NhisMedicineModel with query failed',

	EXPORT_NHIS_MEDICINE = '[ENTITY] Export NhisMedicineModel',
	EXPORT_NHIS_MEDICINE_OK = '[ENTITY] Export NhisMedicineModel successfully',
	EXPORT_NHIS_MEDICINE_FAIL = '[ENTITY] Export NhisMedicineModel failed',

	EXPORT_ALL_NHIS_MEDICINE = '[ENTITY] Export All NhisMedicineModels',
	EXPORT_ALL_NHIS_MEDICINE_OK = '[ENTITY] Export All NhisMedicineModels successfully',
	EXPORT_ALL_NHIS_MEDICINE_FAIL = '[ENTITY] Export All NhisMedicineModels failed',

	EXPORT_NHIS_MEDICINE_EXCLUDING_IDS = '[ENTITY] Export NhisMedicineModels excluding Ids',
	EXPORT_NHIS_MEDICINE_EXCLUDING_IDS_OK = '[ENTITY] Export NhisMedicineModel excluding Ids successfully',
	EXPORT_NHIS_MEDICINE_EXCLUDING_IDS_FAIL = '[ENTITY] Export NhisMedicineModel excluding Ids failed',

	COUNT_NHIS_MEDICINES = '[ENTITY] Fetch number of NhisMedicineModel records',
	COUNT_NHIS_MEDICINES_OK = '[ENTITY] Fetch number of NhisMedicineModel records successfully ',
	COUNT_NHIS_MEDICINES_FAIL = '[ENTITY] Fetch number of NhisMedicineModel records failed',

	IMPORT_NHIS_MEDICINES = '[ENTITY] Import NhisMedicineModels',
	IMPORT_NHIS_MEDICINES_OK = '[ENTITY] Import NhisMedicineModels successfully',
	IMPORT_NHIS_MEDICINES_FAIL = '[ENTITY] Import NhisMedicineModels fail',


	INITIALISE_NHIS_MEDICINE_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of NhisMedicineModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseNhisMedicineAction implements Action {
	readonly className: string = 'NhisMedicineModel';

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

export class NhisMedicineAction extends BaseNhisMedicineAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisMedicineAction here] off begin
	// % protected region % [Add any additional class fields for NhisMedicineAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisMedicineModel>,
		// % protected region % [Add any additional constructor parameters for NhisMedicineAction here] off begin
		// % protected region % [Add any additional constructor parameters for NhisMedicineAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisMedicineAction here] off begin
			// % protected region % [Add any additional constructor arguments for NhisMedicineAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisMedicineAction here] off begin
		// % protected region % [Add any additional constructor logic for NhisMedicineAction here] end
	}

	// % protected region % [Add any additional class methods for NhisMedicineAction here] off begin
	// % protected region % [Add any additional class methods for NhisMedicineAction here] end
}

export class NhisMedicineActionOK extends BaseNhisMedicineAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisMedicineActionOK here] off begin
	// % protected region % [Add any additional class fields for NhisMedicineActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<NhisMedicineModel>,
		// % protected region % [Add any additional constructor parameters for NhisMedicineActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for NhisMedicineActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: NhisMedicineModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisMedicineActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for NhisMedicineActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisMedicineActionOK here] off begin
		// % protected region % [Add any additional constructor logic for NhisMedicineActionOK here] end
	}

	// % protected region % [Add any additional class methods for NhisMedicineActionOK here] off begin
	// % protected region % [Add any additional class methods for NhisMedicineActionOK here] end
}

export class NhisMedicineActionFail extends BaseNhisMedicineAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for NhisMedicineActionFail here] off begin
	// % protected region % [Add any additional class fields for NhisMedicineActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<NhisMedicineModel>,
		// % protected region % [Add any additional constructor parameters for NhisMedicineActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for NhisMedicineActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for NhisMedicineActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for NhisMedicineActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for NhisMedicineActionFail here] off begin
		// % protected region % [Add any additional constructor logic for NhisMedicineActionFail here] end
	}

	// % protected region % [Add any additional class methods for NhisMedicineActionFail here] off begin
	// % protected region % [Add any additional class methods for NhisMedicineActionFail here] end
}

export function isNhisMedicineModelAction(e: any): e is BaseNhisMedicineAction {
	return Object.values(NhisMedicineModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
