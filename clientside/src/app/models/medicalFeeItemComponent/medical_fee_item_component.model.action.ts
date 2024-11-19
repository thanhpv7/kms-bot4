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
import {MedicalFeeItemComponentModel} from './medical_fee_item_component.model';
import {MedicalFeeItemComponentModelAudit} from './medical_fee_item_component.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Medical Fee Item Component model actions to be dispatched by NgRx.
 */
export enum MedicalFeeItemComponentModelActionTypes {
	CREATE_MEDICAL_FEE_ITEM_COMPONENT = '[ENTITY] Create MedicalFeeItemComponentModel',
	CREATE_MEDICAL_FEE_ITEM_COMPONENT_OK = '[ENTITY] Create MedicalFeeItemComponentModel successfully',
	CREATE_MEDICAL_FEE_ITEM_COMPONENT_FAIL = '[ENTITY] Create MedicalFeeItemComponentModel failed',

	CREATE_ALL_MEDICAL_FEE_ITEM_COMPONENT = '[ENTITY] Create All MedicalFeeItemComponentModel',
	CREATE_ALL_MEDICAL_FEE_ITEM_COMPONENT_OK = '[ENTITY] Create All MedicalFeeItemComponentModel successfully',
	CREATE_ALL_MEDICAL_FEE_ITEM_COMPONENT_FAIL = '[ENTITY] Create All MedicalFeeItemComponentModel failed',

	DELETE_MEDICAL_FEE_ITEM_COMPONENT = '[ENTITY] Delete MedicalFeeItemComponentModel',
	DELETE_MEDICAL_FEE_ITEM_COMPONENT_OK = '[ENTITY] Delete MedicalFeeItemComponentModel successfully',
	DELETE_MEDICAL_FEE_ITEM_COMPONENT_FAIL = '[ENTITY] Delete MedicalFeeItemComponentModel failed',


	DELETE_MEDICAL_FEE_ITEM_COMPONENT_EXCLUDING_IDS = '[ENTITY] Delete MedicalFeeItemComponentModels Excluding Ids',
	DELETE_MEDICAL_FEE_ITEM_COMPONENT_EXCLUDING_IDS_OK = '[ENTITY] Delete MedicalFeeItemComponentModels Excluding Ids successfully',
	DELETE_MEDICAL_FEE_ITEM_COMPONENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete MedicalFeeItemComponentModels Excluding Ids failed',

	DELETE_ALL_MEDICAL_FEE_ITEM_COMPONENT = '[ENTITY] Delete all MedicalFeeItemComponentModels',
	DELETE_ALL_MEDICAL_FEE_ITEM_COMPONENT_OK = '[ENTITY] Delete all MedicalFeeItemComponentModels successfully',
	DELETE_ALL_MEDICAL_FEE_ITEM_COMPONENT_FAIL = '[ENTITY] Delete all MedicalFeeItemComponentModels failed',

	UPDATE_MEDICAL_FEE_ITEM_COMPONENT = '[ENTITY] Update MedicalFeeItemComponentModel',
	UPDATE_MEDICAL_FEE_ITEM_COMPONENT_OK = '[ENTITY] Update MedicalFeeItemComponentModel successfully',
	UPDATE_MEDICAL_FEE_ITEM_COMPONENT_FAIL = '[ENTITY] Update MedicalFeeItemComponentModel failed',

	UPDATE_ALL_MEDICAL_FEE_ITEM_COMPONENT = '[ENTITY] Update all MedicalFeeItemComponentModel',
	UPDATE_ALL_MEDICAL_FEE_ITEM_COMPONENT_OK = '[ENTITY] Update all MedicalFeeItemComponentModel successfully',
	UPDATE_ALL_MEDICAL_FEE_ITEM_COMPONENT_FAIL = '[ENTITY] Update all MedicalFeeItemComponentModel failed',

	FETCH_MEDICAL_FEE_ITEM_COMPONENT= '[ENTITY] Fetch MedicalFeeItemComponentModel',
	FETCH_MEDICAL_FEE_ITEM_COMPONENT_OK = '[ENTITY] Fetch MedicalFeeItemComponentModel successfully',
	FETCH_MEDICAL_FEE_ITEM_COMPONENT_FAIL = '[ENTITY] Fetch MedicalFeeItemComponentModel failed',

	FETCH_MEDICAL_FEE_ITEM_COMPONENT_AUDIT= '[ENTITY] Fetch MedicalFeeItemComponentModel audit',
	FETCH_MEDICAL_FEE_ITEM_COMPONENT_AUDIT_OK = '[ENTITY] Fetch MedicalFeeItemComponentModel audit successfully',
	FETCH_MEDICAL_FEE_ITEM_COMPONENT_AUDIT_FAIL = '[ENTITY] Fetch MedicalFeeItemComponentModel audit failed',

	FETCH_MEDICAL_FEE_ITEM_COMPONENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch MedicalFeeItemComponentModel audits by entity id',
	FETCH_MEDICAL_FEE_ITEM_COMPONENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch MedicalFeeItemComponentModel audits by entity id successfully',
	FETCH_MEDICAL_FEE_ITEM_COMPONENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch MedicalFeeItemComponentModel audits by entity id failed',

	FETCH_ALL_MEDICAL_FEE_ITEM_COMPONENT = '[ENTITY] Fetch all MedicalFeeItemComponentModel',
	FETCH_ALL_MEDICAL_FEE_ITEM_COMPONENT_OK = '[ENTITY] Fetch all MedicalFeeItemComponentModel successfully',
	FETCH_ALL_MEDICAL_FEE_ITEM_COMPONENT_FAIL = '[ENTITY] Fetch all MedicalFeeItemComponentModel failed',

	FETCH_MEDICAL_FEE_ITEM_COMPONENT_WITH_QUERY = '[ENTITY] Fetch MedicalFeeItemComponentModel with query',
	FETCH_MEDICAL_FEE_ITEM_COMPONENT_WITH_QUERY_OK = '[ENTITY] Fetch MedicalFeeItemComponentModel with query successfully',
	FETCH_MEDICAL_FEE_ITEM_COMPONENT_WITH_QUERY_FAIL = '[ENTITY] Fetch MedicalFeeItemComponentModel with query failed',

	FETCH_LAST_MEDICAL_FEE_ITEM_COMPONENT_WITH_QUERY = '[ENTITY] Fetch last MedicalFeeItemComponentModel with query',
	FETCH_LAST_MEDICAL_FEE_ITEM_COMPONENT_WITH_QUERY_OK = '[ENTITY] Fetch last MedicalFeeItemComponentModel with query successfully',
	FETCH_LAST_MEDICAL_FEE_ITEM_COMPONENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last MedicalFeeItemComponentModel with query failed',

	EXPORT_MEDICAL_FEE_ITEM_COMPONENT = '[ENTITY] Export MedicalFeeItemComponentModel',
	EXPORT_MEDICAL_FEE_ITEM_COMPONENT_OK = '[ENTITY] Export MedicalFeeItemComponentModel successfully',
	EXPORT_MEDICAL_FEE_ITEM_COMPONENT_FAIL = '[ENTITY] Export MedicalFeeItemComponentModel failed',

	EXPORT_ALL_MEDICAL_FEE_ITEM_COMPONENT = '[ENTITY] Export All MedicalFeeItemComponentModels',
	EXPORT_ALL_MEDICAL_FEE_ITEM_COMPONENT_OK = '[ENTITY] Export All MedicalFeeItemComponentModels successfully',
	EXPORT_ALL_MEDICAL_FEE_ITEM_COMPONENT_FAIL = '[ENTITY] Export All MedicalFeeItemComponentModels failed',

	EXPORT_MEDICAL_FEE_ITEM_COMPONENT_EXCLUDING_IDS = '[ENTITY] Export MedicalFeeItemComponentModels excluding Ids',
	EXPORT_MEDICAL_FEE_ITEM_COMPONENT_EXCLUDING_IDS_OK = '[ENTITY] Export MedicalFeeItemComponentModel excluding Ids successfully',
	EXPORT_MEDICAL_FEE_ITEM_COMPONENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export MedicalFeeItemComponentModel excluding Ids failed',

	COUNT_MEDICAL_FEE_ITEM_COMPONENTS = '[ENTITY] Fetch number of MedicalFeeItemComponentModel records',
	COUNT_MEDICAL_FEE_ITEM_COMPONENTS_OK = '[ENTITY] Fetch number of MedicalFeeItemComponentModel records successfully ',
	COUNT_MEDICAL_FEE_ITEM_COMPONENTS_FAIL = '[ENTITY] Fetch number of MedicalFeeItemComponentModel records failed',

	IMPORT_MEDICAL_FEE_ITEM_COMPONENTS = '[ENTITY] Import MedicalFeeItemComponentModels',
	IMPORT_MEDICAL_FEE_ITEM_COMPONENTS_OK = '[ENTITY] Import MedicalFeeItemComponentModels successfully',
	IMPORT_MEDICAL_FEE_ITEM_COMPONENTS_FAIL = '[ENTITY] Import MedicalFeeItemComponentModels fail',


	INITIALISE_MEDICAL_FEE_ITEM_COMPONENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of MedicalFeeItemComponentModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseMedicalFeeItemComponentAction implements Action {
	readonly className: string = 'MedicalFeeItemComponentModel';

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

export class MedicalFeeItemComponentAction extends BaseMedicalFeeItemComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalFeeItemComponentAction here] off begin
	// % protected region % [Add any additional class fields for MedicalFeeItemComponentAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalFeeItemComponentModel>,
		// % protected region % [Add any additional constructor parameters for MedicalFeeItemComponentAction here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalFeeItemComponentAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalFeeItemComponentAction here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalFeeItemComponentAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalFeeItemComponentAction here] off begin
		// % protected region % [Add any additional constructor logic for MedicalFeeItemComponentAction here] end
	}

	// % protected region % [Add any additional class methods for MedicalFeeItemComponentAction here] off begin
	// % protected region % [Add any additional class methods for MedicalFeeItemComponentAction here] end
}

export class MedicalFeeItemComponentActionOK extends BaseMedicalFeeItemComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalFeeItemComponentActionOK here] off begin
	// % protected region % [Add any additional class fields for MedicalFeeItemComponentActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<MedicalFeeItemComponentModel>,
		// % protected region % [Add any additional constructor parameters for MedicalFeeItemComponentActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalFeeItemComponentActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: MedicalFeeItemComponentModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalFeeItemComponentActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalFeeItemComponentActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalFeeItemComponentActionOK here] off begin
		// % protected region % [Add any additional constructor logic for MedicalFeeItemComponentActionOK here] end
	}

	// % protected region % [Add any additional class methods for MedicalFeeItemComponentActionOK here] off begin
	// % protected region % [Add any additional class methods for MedicalFeeItemComponentActionOK here] end
}

export class MedicalFeeItemComponentActionFail extends BaseMedicalFeeItemComponentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for MedicalFeeItemComponentActionFail here] off begin
	// % protected region % [Add any additional class fields for MedicalFeeItemComponentActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<MedicalFeeItemComponentModel>,
		// % protected region % [Add any additional constructor parameters for MedicalFeeItemComponentActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for MedicalFeeItemComponentActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for MedicalFeeItemComponentActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for MedicalFeeItemComponentActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for MedicalFeeItemComponentActionFail here] off begin
		// % protected region % [Add any additional constructor logic for MedicalFeeItemComponentActionFail here] end
	}

	// % protected region % [Add any additional class methods for MedicalFeeItemComponentActionFail here] off begin
	// % protected region % [Add any additional class methods for MedicalFeeItemComponentActionFail here] end
}

export function isMedicalFeeItemComponentModelAction(e: any): e is BaseMedicalFeeItemComponentAction {
	return Object.values(MedicalFeeItemComponentModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
