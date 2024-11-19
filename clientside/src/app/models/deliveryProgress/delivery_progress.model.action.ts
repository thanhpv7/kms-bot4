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
import {DeliveryProgressModel} from './delivery_progress.model';
import {DeliveryProgressModelAudit} from './delivery_progress.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Delivery Progress model actions to be dispatched by NgRx.
 */
export enum DeliveryProgressModelActionTypes {
	CREATE_DELIVERY_PROGRESS = '[ENTITY] Create DeliveryProgressModel',
	CREATE_DELIVERY_PROGRESS_OK = '[ENTITY] Create DeliveryProgressModel successfully',
	CREATE_DELIVERY_PROGRESS_FAIL = '[ENTITY] Create DeliveryProgressModel failed',

	CREATE_ALL_DELIVERY_PROGRESS = '[ENTITY] Create All DeliveryProgressModel',
	CREATE_ALL_DELIVERY_PROGRESS_OK = '[ENTITY] Create All DeliveryProgressModel successfully',
	CREATE_ALL_DELIVERY_PROGRESS_FAIL = '[ENTITY] Create All DeliveryProgressModel failed',

	DELETE_DELIVERY_PROGRESS = '[ENTITY] Delete DeliveryProgressModel',
	DELETE_DELIVERY_PROGRESS_OK = '[ENTITY] Delete DeliveryProgressModel successfully',
	DELETE_DELIVERY_PROGRESS_FAIL = '[ENTITY] Delete DeliveryProgressModel failed',


	DELETE_DELIVERY_PROGRESS_EXCLUDING_IDS = '[ENTITY] Delete DeliveryProgressModels Excluding Ids',
	DELETE_DELIVERY_PROGRESS_EXCLUDING_IDS_OK = '[ENTITY] Delete DeliveryProgressModels Excluding Ids successfully',
	DELETE_DELIVERY_PROGRESS_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DeliveryProgressModels Excluding Ids failed',

	DELETE_ALL_DELIVERY_PROGRESS = '[ENTITY] Delete all DeliveryProgressModels',
	DELETE_ALL_DELIVERY_PROGRESS_OK = '[ENTITY] Delete all DeliveryProgressModels successfully',
	DELETE_ALL_DELIVERY_PROGRESS_FAIL = '[ENTITY] Delete all DeliveryProgressModels failed',

	UPDATE_DELIVERY_PROGRESS = '[ENTITY] Update DeliveryProgressModel',
	UPDATE_DELIVERY_PROGRESS_OK = '[ENTITY] Update DeliveryProgressModel successfully',
	UPDATE_DELIVERY_PROGRESS_FAIL = '[ENTITY] Update DeliveryProgressModel failed',

	UPDATE_ALL_DELIVERY_PROGRESS = '[ENTITY] Update all DeliveryProgressModel',
	UPDATE_ALL_DELIVERY_PROGRESS_OK = '[ENTITY] Update all DeliveryProgressModel successfully',
	UPDATE_ALL_DELIVERY_PROGRESS_FAIL = '[ENTITY] Update all DeliveryProgressModel failed',

	FETCH_DELIVERY_PROGRESS= '[ENTITY] Fetch DeliveryProgressModel',
	FETCH_DELIVERY_PROGRESS_OK = '[ENTITY] Fetch DeliveryProgressModel successfully',
	FETCH_DELIVERY_PROGRESS_FAIL = '[ENTITY] Fetch DeliveryProgressModel failed',

	FETCH_DELIVERY_PROGRESS_AUDIT= '[ENTITY] Fetch DeliveryProgressModel audit',
	FETCH_DELIVERY_PROGRESS_AUDIT_OK = '[ENTITY] Fetch DeliveryProgressModel audit successfully',
	FETCH_DELIVERY_PROGRESS_AUDIT_FAIL = '[ENTITY] Fetch DeliveryProgressModel audit failed',

	FETCH_DELIVERY_PROGRESS_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DeliveryProgressModel audits by entity id',
	FETCH_DELIVERY_PROGRESS_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DeliveryProgressModel audits by entity id successfully',
	FETCH_DELIVERY_PROGRESS_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DeliveryProgressModel audits by entity id failed',

	FETCH_ALL_DELIVERY_PROGRESS = '[ENTITY] Fetch all DeliveryProgressModel',
	FETCH_ALL_DELIVERY_PROGRESS_OK = '[ENTITY] Fetch all DeliveryProgressModel successfully',
	FETCH_ALL_DELIVERY_PROGRESS_FAIL = '[ENTITY] Fetch all DeliveryProgressModel failed',

	FETCH_DELIVERY_PROGRESS_WITH_QUERY = '[ENTITY] Fetch DeliveryProgressModel with query',
	FETCH_DELIVERY_PROGRESS_WITH_QUERY_OK = '[ENTITY] Fetch DeliveryProgressModel with query successfully',
	FETCH_DELIVERY_PROGRESS_WITH_QUERY_FAIL = '[ENTITY] Fetch DeliveryProgressModel with query failed',

	FETCH_LAST_DELIVERY_PROGRESS_WITH_QUERY = '[ENTITY] Fetch last DeliveryProgressModel with query',
	FETCH_LAST_DELIVERY_PROGRESS_WITH_QUERY_OK = '[ENTITY] Fetch last DeliveryProgressModel with query successfully',
	FETCH_LAST_DELIVERY_PROGRESS_WITH_QUERY_FAIL = '[ENTITY] Fetch last DeliveryProgressModel with query failed',

	EXPORT_DELIVERY_PROGRESS = '[ENTITY] Export DeliveryProgressModel',
	EXPORT_DELIVERY_PROGRESS_OK = '[ENTITY] Export DeliveryProgressModel successfully',
	EXPORT_DELIVERY_PROGRESS_FAIL = '[ENTITY] Export DeliveryProgressModel failed',

	EXPORT_ALL_DELIVERY_PROGRESS = '[ENTITY] Export All DeliveryProgressModels',
	EXPORT_ALL_DELIVERY_PROGRESS_OK = '[ENTITY] Export All DeliveryProgressModels successfully',
	EXPORT_ALL_DELIVERY_PROGRESS_FAIL = '[ENTITY] Export All DeliveryProgressModels failed',

	EXPORT_DELIVERY_PROGRESS_EXCLUDING_IDS = '[ENTITY] Export DeliveryProgressModels excluding Ids',
	EXPORT_DELIVERY_PROGRESS_EXCLUDING_IDS_OK = '[ENTITY] Export DeliveryProgressModel excluding Ids successfully',
	EXPORT_DELIVERY_PROGRESS_EXCLUDING_IDS_FAIL = '[ENTITY] Export DeliveryProgressModel excluding Ids failed',

	COUNT_DELIVERY_PROGRESSS = '[ENTITY] Fetch number of DeliveryProgressModel records',
	COUNT_DELIVERY_PROGRESSS_OK = '[ENTITY] Fetch number of DeliveryProgressModel records successfully ',
	COUNT_DELIVERY_PROGRESSS_FAIL = '[ENTITY] Fetch number of DeliveryProgressModel records failed',

	IMPORT_DELIVERY_PROGRESSS = '[ENTITY] Import DeliveryProgressModels',
	IMPORT_DELIVERY_PROGRESSS_OK = '[ENTITY] Import DeliveryProgressModels successfully',
	IMPORT_DELIVERY_PROGRESSS_FAIL = '[ENTITY] Import DeliveryProgressModels fail',


	INITIALISE_DELIVERY_PROGRESS_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DeliveryProgressModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDeliveryProgressAction implements Action {
	readonly className: string = 'DeliveryProgressModel';

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

export class DeliveryProgressAction extends BaseDeliveryProgressAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DeliveryProgressAction here] off begin
	// % protected region % [Add any additional class fields for DeliveryProgressAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DeliveryProgressModel>,
		// % protected region % [Add any additional constructor parameters for DeliveryProgressAction here] off begin
		// % protected region % [Add any additional constructor parameters for DeliveryProgressAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DeliveryProgressAction here] off begin
			// % protected region % [Add any additional constructor arguments for DeliveryProgressAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DeliveryProgressAction here] off begin
		// % protected region % [Add any additional constructor logic for DeliveryProgressAction here] end
	}

	// % protected region % [Add any additional class methods for DeliveryProgressAction here] off begin
	// % protected region % [Add any additional class methods for DeliveryProgressAction here] end
}

export class DeliveryProgressActionOK extends BaseDeliveryProgressAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DeliveryProgressActionOK here] off begin
	// % protected region % [Add any additional class fields for DeliveryProgressActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DeliveryProgressModel>,
		// % protected region % [Add any additional constructor parameters for DeliveryProgressActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DeliveryProgressActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DeliveryProgressModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DeliveryProgressActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DeliveryProgressActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DeliveryProgressActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DeliveryProgressActionOK here] end
	}

	// % protected region % [Add any additional class methods for DeliveryProgressActionOK here] off begin
	// % protected region % [Add any additional class methods for DeliveryProgressActionOK here] end
}

export class DeliveryProgressActionFail extends BaseDeliveryProgressAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DeliveryProgressActionFail here] off begin
	// % protected region % [Add any additional class fields for DeliveryProgressActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DeliveryProgressModel>,
		// % protected region % [Add any additional constructor parameters for DeliveryProgressActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DeliveryProgressActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DeliveryProgressActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DeliveryProgressActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DeliveryProgressActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DeliveryProgressActionFail here] end
	}

	// % protected region % [Add any additional class methods for DeliveryProgressActionFail here] off begin
	// % protected region % [Add any additional class methods for DeliveryProgressActionFail here] end
}

export function isDeliveryProgressModelAction(e: any): e is BaseDeliveryProgressAction {
	return Object.values(DeliveryProgressModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
