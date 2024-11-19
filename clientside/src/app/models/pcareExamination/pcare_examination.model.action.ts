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
import {PcareExaminationModel} from './pcare_examination.model';
import {PcareExaminationModelAudit} from './pcare_examination.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare Examination model actions to be dispatched by NgRx.
 */
export enum PcareExaminationModelActionTypes {
	CREATE_PCARE_EXAMINATION = '[ENTITY] Create PcareExaminationModel',
	CREATE_PCARE_EXAMINATION_OK = '[ENTITY] Create PcareExaminationModel successfully',
	CREATE_PCARE_EXAMINATION_FAIL = '[ENTITY] Create PcareExaminationModel failed',

	CREATE_ALL_PCARE_EXAMINATION = '[ENTITY] Create All PcareExaminationModel',
	CREATE_ALL_PCARE_EXAMINATION_OK = '[ENTITY] Create All PcareExaminationModel successfully',
	CREATE_ALL_PCARE_EXAMINATION_FAIL = '[ENTITY] Create All PcareExaminationModel failed',

	DELETE_PCARE_EXAMINATION = '[ENTITY] Delete PcareExaminationModel',
	DELETE_PCARE_EXAMINATION_OK = '[ENTITY] Delete PcareExaminationModel successfully',
	DELETE_PCARE_EXAMINATION_FAIL = '[ENTITY] Delete PcareExaminationModel failed',


	DELETE_PCARE_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Delete PcareExaminationModels Excluding Ids',
	DELETE_PCARE_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareExaminationModels Excluding Ids successfully',
	DELETE_PCARE_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareExaminationModels Excluding Ids failed',

	DELETE_ALL_PCARE_EXAMINATION = '[ENTITY] Delete all PcareExaminationModels',
	DELETE_ALL_PCARE_EXAMINATION_OK = '[ENTITY] Delete all PcareExaminationModels successfully',
	DELETE_ALL_PCARE_EXAMINATION_FAIL = '[ENTITY] Delete all PcareExaminationModels failed',

	UPDATE_PCARE_EXAMINATION = '[ENTITY] Update PcareExaminationModel',
	UPDATE_PCARE_EXAMINATION_OK = '[ENTITY] Update PcareExaminationModel successfully',
	UPDATE_PCARE_EXAMINATION_FAIL = '[ENTITY] Update PcareExaminationModel failed',

	UPDATE_ALL_PCARE_EXAMINATION = '[ENTITY] Update all PcareExaminationModel',
	UPDATE_ALL_PCARE_EXAMINATION_OK = '[ENTITY] Update all PcareExaminationModel successfully',
	UPDATE_ALL_PCARE_EXAMINATION_FAIL = '[ENTITY] Update all PcareExaminationModel failed',

	FETCH_PCARE_EXAMINATION= '[ENTITY] Fetch PcareExaminationModel',
	FETCH_PCARE_EXAMINATION_OK = '[ENTITY] Fetch PcareExaminationModel successfully',
	FETCH_PCARE_EXAMINATION_FAIL = '[ENTITY] Fetch PcareExaminationModel failed',

	FETCH_PCARE_EXAMINATION_AUDIT= '[ENTITY] Fetch PcareExaminationModel audit',
	FETCH_PCARE_EXAMINATION_AUDIT_OK = '[ENTITY] Fetch PcareExaminationModel audit successfully',
	FETCH_PCARE_EXAMINATION_AUDIT_FAIL = '[ENTITY] Fetch PcareExaminationModel audit failed',

	FETCH_PCARE_EXAMINATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareExaminationModel audits by entity id',
	FETCH_PCARE_EXAMINATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareExaminationModel audits by entity id successfully',
	FETCH_PCARE_EXAMINATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareExaminationModel audits by entity id failed',

	FETCH_ALL_PCARE_EXAMINATION = '[ENTITY] Fetch all PcareExaminationModel',
	FETCH_ALL_PCARE_EXAMINATION_OK = '[ENTITY] Fetch all PcareExaminationModel successfully',
	FETCH_ALL_PCARE_EXAMINATION_FAIL = '[ENTITY] Fetch all PcareExaminationModel failed',

	FETCH_PCARE_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch PcareExaminationModel with query',
	FETCH_PCARE_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch PcareExaminationModel with query successfully',
	FETCH_PCARE_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareExaminationModel with query failed',

	FETCH_LAST_PCARE_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch last PcareExaminationModel with query',
	FETCH_LAST_PCARE_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch last PcareExaminationModel with query successfully',
	FETCH_LAST_PCARE_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareExaminationModel with query failed',

	EXPORT_PCARE_EXAMINATION = '[ENTITY] Export PcareExaminationModel',
	EXPORT_PCARE_EXAMINATION_OK = '[ENTITY] Export PcareExaminationModel successfully',
	EXPORT_PCARE_EXAMINATION_FAIL = '[ENTITY] Export PcareExaminationModel failed',

	EXPORT_ALL_PCARE_EXAMINATION = '[ENTITY] Export All PcareExaminationModels',
	EXPORT_ALL_PCARE_EXAMINATION_OK = '[ENTITY] Export All PcareExaminationModels successfully',
	EXPORT_ALL_PCARE_EXAMINATION_FAIL = '[ENTITY] Export All PcareExaminationModels failed',

	EXPORT_PCARE_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Export PcareExaminationModels excluding Ids',
	EXPORT_PCARE_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Export PcareExaminationModel excluding Ids successfully',
	EXPORT_PCARE_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareExaminationModel excluding Ids failed',

	COUNT_PCARE_EXAMINATIONS = '[ENTITY] Fetch number of PcareExaminationModel records',
	COUNT_PCARE_EXAMINATIONS_OK = '[ENTITY] Fetch number of PcareExaminationModel records successfully ',
	COUNT_PCARE_EXAMINATIONS_FAIL = '[ENTITY] Fetch number of PcareExaminationModel records failed',

	IMPORT_PCARE_EXAMINATIONS = '[ENTITY] Import PcareExaminationModels',
	IMPORT_PCARE_EXAMINATIONS_OK = '[ENTITY] Import PcareExaminationModels successfully',
	IMPORT_PCARE_EXAMINATIONS_FAIL = '[ENTITY] Import PcareExaminationModels fail',


	INITIALISE_PCARE_EXAMINATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareExaminationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareExaminationAction implements Action {
	readonly className: string = 'PcareExaminationModel';

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

export class PcareExaminationAction extends BasePcareExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareExaminationAction here] off begin
	// % protected region % [Add any additional class fields for PcareExaminationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareExaminationModel>,
		// % protected region % [Add any additional constructor parameters for PcareExaminationAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareExaminationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareExaminationAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareExaminationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareExaminationAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareExaminationAction here] end
	}

	// % protected region % [Add any additional class methods for PcareExaminationAction here] off begin
	// % protected region % [Add any additional class methods for PcareExaminationAction here] end
}

export class PcareExaminationActionOK extends BasePcareExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareExaminationActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareExaminationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareExaminationModel>,
		// % protected region % [Add any additional constructor parameters for PcareExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareExaminationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareExaminationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareExaminationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareExaminationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareExaminationActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareExaminationActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareExaminationActionOK here] end
}

export class PcareExaminationActionFail extends BasePcareExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareExaminationActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareExaminationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareExaminationModel>,
		// % protected region % [Add any additional constructor parameters for PcareExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareExaminationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareExaminationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareExaminationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareExaminationActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareExaminationActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareExaminationActionFail here] end
}

export function isPcareExaminationModelAction(e: any): e is BasePcareExaminationAction {
	return Object.values(PcareExaminationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
