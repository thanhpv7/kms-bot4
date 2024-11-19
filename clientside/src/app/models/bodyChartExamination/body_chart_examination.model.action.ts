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
import {BodyChartExaminationModel} from './body_chart_examination.model';
import {BodyChartExaminationModelAudit} from './body_chart_examination.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Body Chart Examination model actions to be dispatched by NgRx.
 */
export enum BodyChartExaminationModelActionTypes {
	CREATE_BODY_CHART_EXAMINATION = '[ENTITY] Create BodyChartExaminationModel',
	CREATE_BODY_CHART_EXAMINATION_OK = '[ENTITY] Create BodyChartExaminationModel successfully',
	CREATE_BODY_CHART_EXAMINATION_FAIL = '[ENTITY] Create BodyChartExaminationModel failed',

	CREATE_ALL_BODY_CHART_EXAMINATION = '[ENTITY] Create All BodyChartExaminationModel',
	CREATE_ALL_BODY_CHART_EXAMINATION_OK = '[ENTITY] Create All BodyChartExaminationModel successfully',
	CREATE_ALL_BODY_CHART_EXAMINATION_FAIL = '[ENTITY] Create All BodyChartExaminationModel failed',

	DELETE_BODY_CHART_EXAMINATION = '[ENTITY] Delete BodyChartExaminationModel',
	DELETE_BODY_CHART_EXAMINATION_OK = '[ENTITY] Delete BodyChartExaminationModel successfully',
	DELETE_BODY_CHART_EXAMINATION_FAIL = '[ENTITY] Delete BodyChartExaminationModel failed',


	DELETE_BODY_CHART_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Delete BodyChartExaminationModels Excluding Ids',
	DELETE_BODY_CHART_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Delete BodyChartExaminationModels Excluding Ids successfully',
	DELETE_BODY_CHART_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete BodyChartExaminationModels Excluding Ids failed',

	DELETE_ALL_BODY_CHART_EXAMINATION = '[ENTITY] Delete all BodyChartExaminationModels',
	DELETE_ALL_BODY_CHART_EXAMINATION_OK = '[ENTITY] Delete all BodyChartExaminationModels successfully',
	DELETE_ALL_BODY_CHART_EXAMINATION_FAIL = '[ENTITY] Delete all BodyChartExaminationModels failed',

	UPDATE_BODY_CHART_EXAMINATION = '[ENTITY] Update BodyChartExaminationModel',
	UPDATE_BODY_CHART_EXAMINATION_OK = '[ENTITY] Update BodyChartExaminationModel successfully',
	UPDATE_BODY_CHART_EXAMINATION_FAIL = '[ENTITY] Update BodyChartExaminationModel failed',

	UPDATE_ALL_BODY_CHART_EXAMINATION = '[ENTITY] Update all BodyChartExaminationModel',
	UPDATE_ALL_BODY_CHART_EXAMINATION_OK = '[ENTITY] Update all BodyChartExaminationModel successfully',
	UPDATE_ALL_BODY_CHART_EXAMINATION_FAIL = '[ENTITY] Update all BodyChartExaminationModel failed',

	FETCH_BODY_CHART_EXAMINATION= '[ENTITY] Fetch BodyChartExaminationModel',
	FETCH_BODY_CHART_EXAMINATION_OK = '[ENTITY] Fetch BodyChartExaminationModel successfully',
	FETCH_BODY_CHART_EXAMINATION_FAIL = '[ENTITY] Fetch BodyChartExaminationModel failed',

	FETCH_BODY_CHART_EXAMINATION_AUDIT= '[ENTITY] Fetch BodyChartExaminationModel audit',
	FETCH_BODY_CHART_EXAMINATION_AUDIT_OK = '[ENTITY] Fetch BodyChartExaminationModel audit successfully',
	FETCH_BODY_CHART_EXAMINATION_AUDIT_FAIL = '[ENTITY] Fetch BodyChartExaminationModel audit failed',

	FETCH_BODY_CHART_EXAMINATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch BodyChartExaminationModel audits by entity id',
	FETCH_BODY_CHART_EXAMINATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch BodyChartExaminationModel audits by entity id successfully',
	FETCH_BODY_CHART_EXAMINATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch BodyChartExaminationModel audits by entity id failed',

	FETCH_ALL_BODY_CHART_EXAMINATION = '[ENTITY] Fetch all BodyChartExaminationModel',
	FETCH_ALL_BODY_CHART_EXAMINATION_OK = '[ENTITY] Fetch all BodyChartExaminationModel successfully',
	FETCH_ALL_BODY_CHART_EXAMINATION_FAIL = '[ENTITY] Fetch all BodyChartExaminationModel failed',

	FETCH_BODY_CHART_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch BodyChartExaminationModel with query',
	FETCH_BODY_CHART_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch BodyChartExaminationModel with query successfully',
	FETCH_BODY_CHART_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch BodyChartExaminationModel with query failed',

	FETCH_LAST_BODY_CHART_EXAMINATION_WITH_QUERY = '[ENTITY] Fetch last BodyChartExaminationModel with query',
	FETCH_LAST_BODY_CHART_EXAMINATION_WITH_QUERY_OK = '[ENTITY] Fetch last BodyChartExaminationModel with query successfully',
	FETCH_LAST_BODY_CHART_EXAMINATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last BodyChartExaminationModel with query failed',

	EXPORT_BODY_CHART_EXAMINATION = '[ENTITY] Export BodyChartExaminationModel',
	EXPORT_BODY_CHART_EXAMINATION_OK = '[ENTITY] Export BodyChartExaminationModel successfully',
	EXPORT_BODY_CHART_EXAMINATION_FAIL = '[ENTITY] Export BodyChartExaminationModel failed',

	EXPORT_ALL_BODY_CHART_EXAMINATION = '[ENTITY] Export All BodyChartExaminationModels',
	EXPORT_ALL_BODY_CHART_EXAMINATION_OK = '[ENTITY] Export All BodyChartExaminationModels successfully',
	EXPORT_ALL_BODY_CHART_EXAMINATION_FAIL = '[ENTITY] Export All BodyChartExaminationModels failed',

	EXPORT_BODY_CHART_EXAMINATION_EXCLUDING_IDS = '[ENTITY] Export BodyChartExaminationModels excluding Ids',
	EXPORT_BODY_CHART_EXAMINATION_EXCLUDING_IDS_OK = '[ENTITY] Export BodyChartExaminationModel excluding Ids successfully',
	EXPORT_BODY_CHART_EXAMINATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export BodyChartExaminationModel excluding Ids failed',

	COUNT_BODY_CHART_EXAMINATIONS = '[ENTITY] Fetch number of BodyChartExaminationModel records',
	COUNT_BODY_CHART_EXAMINATIONS_OK = '[ENTITY] Fetch number of BodyChartExaminationModel records successfully ',
	COUNT_BODY_CHART_EXAMINATIONS_FAIL = '[ENTITY] Fetch number of BodyChartExaminationModel records failed',

	IMPORT_BODY_CHART_EXAMINATIONS = '[ENTITY] Import BodyChartExaminationModels',
	IMPORT_BODY_CHART_EXAMINATIONS_OK = '[ENTITY] Import BodyChartExaminationModels successfully',
	IMPORT_BODY_CHART_EXAMINATIONS_FAIL = '[ENTITY] Import BodyChartExaminationModels fail',


	INITIALISE_BODY_CHART_EXAMINATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of BodyChartExaminationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseBodyChartExaminationAction implements Action {
	readonly className: string = 'BodyChartExaminationModel';

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

export class BodyChartExaminationAction extends BaseBodyChartExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BodyChartExaminationAction here] off begin
	// % protected region % [Add any additional class fields for BodyChartExaminationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BodyChartExaminationModel>,
		// % protected region % [Add any additional constructor parameters for BodyChartExaminationAction here] off begin
		// % protected region % [Add any additional constructor parameters for BodyChartExaminationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BodyChartExaminationAction here] off begin
			// % protected region % [Add any additional constructor arguments for BodyChartExaminationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BodyChartExaminationAction here] off begin
		// % protected region % [Add any additional constructor logic for BodyChartExaminationAction here] end
	}

	// % protected region % [Add any additional class methods for BodyChartExaminationAction here] off begin
	// % protected region % [Add any additional class methods for BodyChartExaminationAction here] end
}

export class BodyChartExaminationActionOK extends BaseBodyChartExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BodyChartExaminationActionOK here] off begin
	// % protected region % [Add any additional class fields for BodyChartExaminationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<BodyChartExaminationModel>,
		// % protected region % [Add any additional constructor parameters for BodyChartExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for BodyChartExaminationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: BodyChartExaminationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BodyChartExaminationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for BodyChartExaminationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BodyChartExaminationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for BodyChartExaminationActionOK here] end
	}

	// % protected region % [Add any additional class methods for BodyChartExaminationActionOK here] off begin
	// % protected region % [Add any additional class methods for BodyChartExaminationActionOK here] end
}

export class BodyChartExaminationActionFail extends BaseBodyChartExaminationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for BodyChartExaminationActionFail here] off begin
	// % protected region % [Add any additional class fields for BodyChartExaminationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<BodyChartExaminationModel>,
		// % protected region % [Add any additional constructor parameters for BodyChartExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for BodyChartExaminationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for BodyChartExaminationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for BodyChartExaminationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for BodyChartExaminationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for BodyChartExaminationActionFail here] end
	}

	// % protected region % [Add any additional class methods for BodyChartExaminationActionFail here] off begin
	// % protected region % [Add any additional class methods for BodyChartExaminationActionFail here] end
}

export function isBodyChartExaminationModelAction(e: any): e is BaseBodyChartExaminationAction {
	return Object.values(BodyChartExaminationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
