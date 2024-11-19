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
import {SampleCollectionInformationModel} from './sample_collection_information.model';
import {SampleCollectionInformationModelAudit} from './sample_collection_information.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Sample Collection Information model actions to be dispatched by NgRx.
 */
export enum SampleCollectionInformationModelActionTypes {
	CREATE_SAMPLE_COLLECTION_INFORMATION = '[ENTITY] Create SampleCollectionInformationModel',
	CREATE_SAMPLE_COLLECTION_INFORMATION_OK = '[ENTITY] Create SampleCollectionInformationModel successfully',
	CREATE_SAMPLE_COLLECTION_INFORMATION_FAIL = '[ENTITY] Create SampleCollectionInformationModel failed',

	CREATE_ALL_SAMPLE_COLLECTION_INFORMATION = '[ENTITY] Create All SampleCollectionInformationModel',
	CREATE_ALL_SAMPLE_COLLECTION_INFORMATION_OK = '[ENTITY] Create All SampleCollectionInformationModel successfully',
	CREATE_ALL_SAMPLE_COLLECTION_INFORMATION_FAIL = '[ENTITY] Create All SampleCollectionInformationModel failed',

	DELETE_SAMPLE_COLLECTION_INFORMATION = '[ENTITY] Delete SampleCollectionInformationModel',
	DELETE_SAMPLE_COLLECTION_INFORMATION_OK = '[ENTITY] Delete SampleCollectionInformationModel successfully',
	DELETE_SAMPLE_COLLECTION_INFORMATION_FAIL = '[ENTITY] Delete SampleCollectionInformationModel failed',


	DELETE_SAMPLE_COLLECTION_INFORMATION_EXCLUDING_IDS = '[ENTITY] Delete SampleCollectionInformationModels Excluding Ids',
	DELETE_SAMPLE_COLLECTION_INFORMATION_EXCLUDING_IDS_OK = '[ENTITY] Delete SampleCollectionInformationModels Excluding Ids successfully',
	DELETE_SAMPLE_COLLECTION_INFORMATION_EXCLUDING_IDS_FAIL = '[ENTITY] Delete SampleCollectionInformationModels Excluding Ids failed',

	DELETE_ALL_SAMPLE_COLLECTION_INFORMATION = '[ENTITY] Delete all SampleCollectionInformationModels',
	DELETE_ALL_SAMPLE_COLLECTION_INFORMATION_OK = '[ENTITY] Delete all SampleCollectionInformationModels successfully',
	DELETE_ALL_SAMPLE_COLLECTION_INFORMATION_FAIL = '[ENTITY] Delete all SampleCollectionInformationModels failed',

	UPDATE_SAMPLE_COLLECTION_INFORMATION = '[ENTITY] Update SampleCollectionInformationModel',
	UPDATE_SAMPLE_COLLECTION_INFORMATION_OK = '[ENTITY] Update SampleCollectionInformationModel successfully',
	UPDATE_SAMPLE_COLLECTION_INFORMATION_FAIL = '[ENTITY] Update SampleCollectionInformationModel failed',

	UPDATE_ALL_SAMPLE_COLLECTION_INFORMATION = '[ENTITY] Update all SampleCollectionInformationModel',
	UPDATE_ALL_SAMPLE_COLLECTION_INFORMATION_OK = '[ENTITY] Update all SampleCollectionInformationModel successfully',
	UPDATE_ALL_SAMPLE_COLLECTION_INFORMATION_FAIL = '[ENTITY] Update all SampleCollectionInformationModel failed',

	FETCH_SAMPLE_COLLECTION_INFORMATION= '[ENTITY] Fetch SampleCollectionInformationModel',
	FETCH_SAMPLE_COLLECTION_INFORMATION_OK = '[ENTITY] Fetch SampleCollectionInformationModel successfully',
	FETCH_SAMPLE_COLLECTION_INFORMATION_FAIL = '[ENTITY] Fetch SampleCollectionInformationModel failed',

	FETCH_SAMPLE_COLLECTION_INFORMATION_AUDIT= '[ENTITY] Fetch SampleCollectionInformationModel audit',
	FETCH_SAMPLE_COLLECTION_INFORMATION_AUDIT_OK = '[ENTITY] Fetch SampleCollectionInformationModel audit successfully',
	FETCH_SAMPLE_COLLECTION_INFORMATION_AUDIT_FAIL = '[ENTITY] Fetch SampleCollectionInformationModel audit failed',

	FETCH_SAMPLE_COLLECTION_INFORMATION_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch SampleCollectionInformationModel audits by entity id',
	FETCH_SAMPLE_COLLECTION_INFORMATION_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch SampleCollectionInformationModel audits by entity id successfully',
	FETCH_SAMPLE_COLLECTION_INFORMATION_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch SampleCollectionInformationModel audits by entity id failed',

	FETCH_ALL_SAMPLE_COLLECTION_INFORMATION = '[ENTITY] Fetch all SampleCollectionInformationModel',
	FETCH_ALL_SAMPLE_COLLECTION_INFORMATION_OK = '[ENTITY] Fetch all SampleCollectionInformationModel successfully',
	FETCH_ALL_SAMPLE_COLLECTION_INFORMATION_FAIL = '[ENTITY] Fetch all SampleCollectionInformationModel failed',

	FETCH_SAMPLE_COLLECTION_INFORMATION_WITH_QUERY = '[ENTITY] Fetch SampleCollectionInformationModel with query',
	FETCH_SAMPLE_COLLECTION_INFORMATION_WITH_QUERY_OK = '[ENTITY] Fetch SampleCollectionInformationModel with query successfully',
	FETCH_SAMPLE_COLLECTION_INFORMATION_WITH_QUERY_FAIL = '[ENTITY] Fetch SampleCollectionInformationModel with query failed',

	FETCH_LAST_SAMPLE_COLLECTION_INFORMATION_WITH_QUERY = '[ENTITY] Fetch last SampleCollectionInformationModel with query',
	FETCH_LAST_SAMPLE_COLLECTION_INFORMATION_WITH_QUERY_OK = '[ENTITY] Fetch last SampleCollectionInformationModel with query successfully',
	FETCH_LAST_SAMPLE_COLLECTION_INFORMATION_WITH_QUERY_FAIL = '[ENTITY] Fetch last SampleCollectionInformationModel with query failed',

	EXPORT_SAMPLE_COLLECTION_INFORMATION = '[ENTITY] Export SampleCollectionInformationModel',
	EXPORT_SAMPLE_COLLECTION_INFORMATION_OK = '[ENTITY] Export SampleCollectionInformationModel successfully',
	EXPORT_SAMPLE_COLLECTION_INFORMATION_FAIL = '[ENTITY] Export SampleCollectionInformationModel failed',

	EXPORT_ALL_SAMPLE_COLLECTION_INFORMATION = '[ENTITY] Export All SampleCollectionInformationModels',
	EXPORT_ALL_SAMPLE_COLLECTION_INFORMATION_OK = '[ENTITY] Export All SampleCollectionInformationModels successfully',
	EXPORT_ALL_SAMPLE_COLLECTION_INFORMATION_FAIL = '[ENTITY] Export All SampleCollectionInformationModels failed',

	EXPORT_SAMPLE_COLLECTION_INFORMATION_EXCLUDING_IDS = '[ENTITY] Export SampleCollectionInformationModels excluding Ids',
	EXPORT_SAMPLE_COLLECTION_INFORMATION_EXCLUDING_IDS_OK = '[ENTITY] Export SampleCollectionInformationModel excluding Ids successfully',
	EXPORT_SAMPLE_COLLECTION_INFORMATION_EXCLUDING_IDS_FAIL = '[ENTITY] Export SampleCollectionInformationModel excluding Ids failed',

	COUNT_SAMPLE_COLLECTION_INFORMATIONS = '[ENTITY] Fetch number of SampleCollectionInformationModel records',
	COUNT_SAMPLE_COLLECTION_INFORMATIONS_OK = '[ENTITY] Fetch number of SampleCollectionInformationModel records successfully ',
	COUNT_SAMPLE_COLLECTION_INFORMATIONS_FAIL = '[ENTITY] Fetch number of SampleCollectionInformationModel records failed',

	IMPORT_SAMPLE_COLLECTION_INFORMATIONS = '[ENTITY] Import SampleCollectionInformationModels',
	IMPORT_SAMPLE_COLLECTION_INFORMATIONS_OK = '[ENTITY] Import SampleCollectionInformationModels successfully',
	IMPORT_SAMPLE_COLLECTION_INFORMATIONS_FAIL = '[ENTITY] Import SampleCollectionInformationModels fail',


	INITIALISE_SAMPLE_COLLECTION_INFORMATION_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of SampleCollectionInformationModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseSampleCollectionInformationAction implements Action {
	readonly className: string = 'SampleCollectionInformationModel';

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

export class SampleCollectionInformationAction extends BaseSampleCollectionInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SampleCollectionInformationAction here] off begin
	// % protected region % [Add any additional class fields for SampleCollectionInformationAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SampleCollectionInformationModel>,
		// % protected region % [Add any additional constructor parameters for SampleCollectionInformationAction here] off begin
		// % protected region % [Add any additional constructor parameters for SampleCollectionInformationAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SampleCollectionInformationAction here] off begin
			// % protected region % [Add any additional constructor arguments for SampleCollectionInformationAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SampleCollectionInformationAction here] off begin
		// % protected region % [Add any additional constructor logic for SampleCollectionInformationAction here] end
	}

	// % protected region % [Add any additional class methods for SampleCollectionInformationAction here] off begin
	// % protected region % [Add any additional class methods for SampleCollectionInformationAction here] end
}

export class SampleCollectionInformationActionOK extends BaseSampleCollectionInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SampleCollectionInformationActionOK here] off begin
	// % protected region % [Add any additional class fields for SampleCollectionInformationActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<SampleCollectionInformationModel>,
		// % protected region % [Add any additional constructor parameters for SampleCollectionInformationActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for SampleCollectionInformationActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: SampleCollectionInformationModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SampleCollectionInformationActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for SampleCollectionInformationActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SampleCollectionInformationActionOK here] off begin
		// % protected region % [Add any additional constructor logic for SampleCollectionInformationActionOK here] end
	}

	// % protected region % [Add any additional class methods for SampleCollectionInformationActionOK here] off begin
	// % protected region % [Add any additional class methods for SampleCollectionInformationActionOK here] end
}

export class SampleCollectionInformationActionFail extends BaseSampleCollectionInformationAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for SampleCollectionInformationActionFail here] off begin
	// % protected region % [Add any additional class fields for SampleCollectionInformationActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<SampleCollectionInformationModel>,
		// % protected region % [Add any additional constructor parameters for SampleCollectionInformationActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for SampleCollectionInformationActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for SampleCollectionInformationActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for SampleCollectionInformationActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for SampleCollectionInformationActionFail here] off begin
		// % protected region % [Add any additional constructor logic for SampleCollectionInformationActionFail here] end
	}

	// % protected region % [Add any additional class methods for SampleCollectionInformationActionFail here] off begin
	// % protected region % [Add any additional class methods for SampleCollectionInformationActionFail here] end
}

export function isSampleCollectionInformationModelAction(e: any): e is BaseSampleCollectionInformationAction {
	return Object.values(SampleCollectionInformationModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
