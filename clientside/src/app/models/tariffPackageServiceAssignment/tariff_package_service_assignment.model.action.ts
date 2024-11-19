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
import {TariffPackageServiceAssignmentModel} from './tariff_package_service_assignment.model';
import {TariffPackageServiceAssignmentModelAudit} from './tariff_package_service_assignment.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Tariff Package Service Assignment model actions to be dispatched by NgRx.
 */
export enum TariffPackageServiceAssignmentModelActionTypes {
	CREATE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT = '[ENTITY] Create TariffPackageServiceAssignmentModel',
	CREATE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_OK = '[ENTITY] Create TariffPackageServiceAssignmentModel successfully',
	CREATE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_FAIL = '[ENTITY] Create TariffPackageServiceAssignmentModel failed',

	CREATE_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT = '[ENTITY] Create All TariffPackageServiceAssignmentModel',
	CREATE_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_OK = '[ENTITY] Create All TariffPackageServiceAssignmentModel successfully',
	CREATE_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_FAIL = '[ENTITY] Create All TariffPackageServiceAssignmentModel failed',

	DELETE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT = '[ENTITY] Delete TariffPackageServiceAssignmentModel',
	DELETE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_OK = '[ENTITY] Delete TariffPackageServiceAssignmentModel successfully',
	DELETE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_FAIL = '[ENTITY] Delete TariffPackageServiceAssignmentModel failed',


	DELETE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_EXCLUDING_IDS = '[ENTITY] Delete TariffPackageServiceAssignmentModels Excluding Ids',
	DELETE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_EXCLUDING_IDS_OK = '[ENTITY] Delete TariffPackageServiceAssignmentModels Excluding Ids successfully',
	DELETE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TariffPackageServiceAssignmentModels Excluding Ids failed',

	DELETE_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT = '[ENTITY] Delete all TariffPackageServiceAssignmentModels',
	DELETE_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_OK = '[ENTITY] Delete all TariffPackageServiceAssignmentModels successfully',
	DELETE_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_FAIL = '[ENTITY] Delete all TariffPackageServiceAssignmentModels failed',

	UPDATE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT = '[ENTITY] Update TariffPackageServiceAssignmentModel',
	UPDATE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_OK = '[ENTITY] Update TariffPackageServiceAssignmentModel successfully',
	UPDATE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_FAIL = '[ENTITY] Update TariffPackageServiceAssignmentModel failed',

	UPDATE_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT = '[ENTITY] Update all TariffPackageServiceAssignmentModel',
	UPDATE_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_OK = '[ENTITY] Update all TariffPackageServiceAssignmentModel successfully',
	UPDATE_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_FAIL = '[ENTITY] Update all TariffPackageServiceAssignmentModel failed',

	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT= '[ENTITY] Fetch TariffPackageServiceAssignmentModel',
	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_OK = '[ENTITY] Fetch TariffPackageServiceAssignmentModel successfully',
	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_FAIL = '[ENTITY] Fetch TariffPackageServiceAssignmentModel failed',

	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_AUDIT= '[ENTITY] Fetch TariffPackageServiceAssignmentModel audit',
	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_AUDIT_OK = '[ENTITY] Fetch TariffPackageServiceAssignmentModel audit successfully',
	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_AUDIT_FAIL = '[ENTITY] Fetch TariffPackageServiceAssignmentModel audit failed',

	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TariffPackageServiceAssignmentModel audits by entity id',
	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TariffPackageServiceAssignmentModel audits by entity id successfully',
	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TariffPackageServiceAssignmentModel audits by entity id failed',

	FETCH_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT = '[ENTITY] Fetch all TariffPackageServiceAssignmentModel',
	FETCH_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_OK = '[ENTITY] Fetch all TariffPackageServiceAssignmentModel successfully',
	FETCH_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_FAIL = '[ENTITY] Fetch all TariffPackageServiceAssignmentModel failed',

	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_WITH_QUERY = '[ENTITY] Fetch TariffPackageServiceAssignmentModel with query',
	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_WITH_QUERY_OK = '[ENTITY] Fetch TariffPackageServiceAssignmentModel with query successfully',
	FETCH_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch TariffPackageServiceAssignmentModel with query failed',

	FETCH_LAST_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_WITH_QUERY = '[ENTITY] Fetch last TariffPackageServiceAssignmentModel with query',
	FETCH_LAST_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_WITH_QUERY_OK = '[ENTITY] Fetch last TariffPackageServiceAssignmentModel with query successfully',
	FETCH_LAST_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last TariffPackageServiceAssignmentModel with query failed',

	EXPORT_TARIFF_PACKAGE_SERVICE_ASSIGNMENT = '[ENTITY] Export TariffPackageServiceAssignmentModel',
	EXPORT_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_OK = '[ENTITY] Export TariffPackageServiceAssignmentModel successfully',
	EXPORT_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_FAIL = '[ENTITY] Export TariffPackageServiceAssignmentModel failed',

	EXPORT_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT = '[ENTITY] Export All TariffPackageServiceAssignmentModels',
	EXPORT_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_OK = '[ENTITY] Export All TariffPackageServiceAssignmentModels successfully',
	EXPORT_ALL_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_FAIL = '[ENTITY] Export All TariffPackageServiceAssignmentModels failed',

	EXPORT_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_EXCLUDING_IDS = '[ENTITY] Export TariffPackageServiceAssignmentModels excluding Ids',
	EXPORT_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_EXCLUDING_IDS_OK = '[ENTITY] Export TariffPackageServiceAssignmentModel excluding Ids successfully',
	EXPORT_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export TariffPackageServiceAssignmentModel excluding Ids failed',

	COUNT_TARIFF_PACKAGE_SERVICE_ASSIGNMENTS = '[ENTITY] Fetch number of TariffPackageServiceAssignmentModel records',
	COUNT_TARIFF_PACKAGE_SERVICE_ASSIGNMENTS_OK = '[ENTITY] Fetch number of TariffPackageServiceAssignmentModel records successfully ',
	COUNT_TARIFF_PACKAGE_SERVICE_ASSIGNMENTS_FAIL = '[ENTITY] Fetch number of TariffPackageServiceAssignmentModel records failed',

	IMPORT_TARIFF_PACKAGE_SERVICE_ASSIGNMENTS = '[ENTITY] Import TariffPackageServiceAssignmentModels',
	IMPORT_TARIFF_PACKAGE_SERVICE_ASSIGNMENTS_OK = '[ENTITY] Import TariffPackageServiceAssignmentModels successfully',
	IMPORT_TARIFF_PACKAGE_SERVICE_ASSIGNMENTS_FAIL = '[ENTITY] Import TariffPackageServiceAssignmentModels fail',


	INITIALISE_TARIFF_PACKAGE_SERVICE_ASSIGNMENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TariffPackageServiceAssignmentModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTariffPackageServiceAssignmentAction implements Action {
	readonly className: string = 'TariffPackageServiceAssignmentModel';

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

export class TariffPackageServiceAssignmentAction extends BaseTariffPackageServiceAssignmentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffPackageServiceAssignmentAction here] off begin
	// % protected region % [Add any additional class fields for TariffPackageServiceAssignmentAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffPackageServiceAssignmentModel>,
		// % protected region % [Add any additional constructor parameters for TariffPackageServiceAssignmentAction here] off begin
		// % protected region % [Add any additional constructor parameters for TariffPackageServiceAssignmentAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffPackageServiceAssignmentAction here] off begin
			// % protected region % [Add any additional constructor arguments for TariffPackageServiceAssignmentAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffPackageServiceAssignmentAction here] off begin
		// % protected region % [Add any additional constructor logic for TariffPackageServiceAssignmentAction here] end
	}

	// % protected region % [Add any additional class methods for TariffPackageServiceAssignmentAction here] off begin
	// % protected region % [Add any additional class methods for TariffPackageServiceAssignmentAction here] end
}

export class TariffPackageServiceAssignmentActionOK extends BaseTariffPackageServiceAssignmentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffPackageServiceAssignmentActionOK here] off begin
	// % protected region % [Add any additional class fields for TariffPackageServiceAssignmentActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffPackageServiceAssignmentModel>,
		// % protected region % [Add any additional constructor parameters for TariffPackageServiceAssignmentActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TariffPackageServiceAssignmentActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TariffPackageServiceAssignmentModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffPackageServiceAssignmentActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TariffPackageServiceAssignmentActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffPackageServiceAssignmentActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TariffPackageServiceAssignmentActionOK here] end
	}

	// % protected region % [Add any additional class methods for TariffPackageServiceAssignmentActionOK here] off begin
	// % protected region % [Add any additional class methods for TariffPackageServiceAssignmentActionOK here] end
}

export class TariffPackageServiceAssignmentActionFail extends BaseTariffPackageServiceAssignmentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffPackageServiceAssignmentActionFail here] off begin
	// % protected region % [Add any additional class fields for TariffPackageServiceAssignmentActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TariffPackageServiceAssignmentModel>,
		// % protected region % [Add any additional constructor parameters for TariffPackageServiceAssignmentActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TariffPackageServiceAssignmentActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffPackageServiceAssignmentActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TariffPackageServiceAssignmentActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffPackageServiceAssignmentActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TariffPackageServiceAssignmentActionFail here] end
	}

	// % protected region % [Add any additional class methods for TariffPackageServiceAssignmentActionFail here] off begin
	// % protected region % [Add any additional class methods for TariffPackageServiceAssignmentActionFail here] end
}

export function isTariffPackageServiceAssignmentModelAction(e: any): e is BaseTariffPackageServiceAssignmentAction {
	return Object.values(TariffPackageServiceAssignmentModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
