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
import {TariffFormulaModel} from './tariff_formula.model';
import {TariffFormulaModelAudit} from './tariff_formula.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Tariff Formula model actions to be dispatched by NgRx.
 */
export enum TariffFormulaModelActionTypes {
	CREATE_TARIFF_FORMULA = '[ENTITY] Create TariffFormulaModel',
	CREATE_TARIFF_FORMULA_OK = '[ENTITY] Create TariffFormulaModel successfully',
	CREATE_TARIFF_FORMULA_FAIL = '[ENTITY] Create TariffFormulaModel failed',

	CREATE_ALL_TARIFF_FORMULA = '[ENTITY] Create All TariffFormulaModel',
	CREATE_ALL_TARIFF_FORMULA_OK = '[ENTITY] Create All TariffFormulaModel successfully',
	CREATE_ALL_TARIFF_FORMULA_FAIL = '[ENTITY] Create All TariffFormulaModel failed',

	DELETE_TARIFF_FORMULA = '[ENTITY] Delete TariffFormulaModel',
	DELETE_TARIFF_FORMULA_OK = '[ENTITY] Delete TariffFormulaModel successfully',
	DELETE_TARIFF_FORMULA_FAIL = '[ENTITY] Delete TariffFormulaModel failed',


	DELETE_TARIFF_FORMULA_EXCLUDING_IDS = '[ENTITY] Delete TariffFormulaModels Excluding Ids',
	DELETE_TARIFF_FORMULA_EXCLUDING_IDS_OK = '[ENTITY] Delete TariffFormulaModels Excluding Ids successfully',
	DELETE_TARIFF_FORMULA_EXCLUDING_IDS_FAIL = '[ENTITY] Delete TariffFormulaModels Excluding Ids failed',

	DELETE_ALL_TARIFF_FORMULA = '[ENTITY] Delete all TariffFormulaModels',
	DELETE_ALL_TARIFF_FORMULA_OK = '[ENTITY] Delete all TariffFormulaModels successfully',
	DELETE_ALL_TARIFF_FORMULA_FAIL = '[ENTITY] Delete all TariffFormulaModels failed',

	UPDATE_TARIFF_FORMULA = '[ENTITY] Update TariffFormulaModel',
	UPDATE_TARIFF_FORMULA_OK = '[ENTITY] Update TariffFormulaModel successfully',
	UPDATE_TARIFF_FORMULA_FAIL = '[ENTITY] Update TariffFormulaModel failed',

	UPDATE_ALL_TARIFF_FORMULA = '[ENTITY] Update all TariffFormulaModel',
	UPDATE_ALL_TARIFF_FORMULA_OK = '[ENTITY] Update all TariffFormulaModel successfully',
	UPDATE_ALL_TARIFF_FORMULA_FAIL = '[ENTITY] Update all TariffFormulaModel failed',

	FETCH_TARIFF_FORMULA= '[ENTITY] Fetch TariffFormulaModel',
	FETCH_TARIFF_FORMULA_OK = '[ENTITY] Fetch TariffFormulaModel successfully',
	FETCH_TARIFF_FORMULA_FAIL = '[ENTITY] Fetch TariffFormulaModel failed',

	FETCH_TARIFF_FORMULA_AUDIT= '[ENTITY] Fetch TariffFormulaModel audit',
	FETCH_TARIFF_FORMULA_AUDIT_OK = '[ENTITY] Fetch TariffFormulaModel audit successfully',
	FETCH_TARIFF_FORMULA_AUDIT_FAIL = '[ENTITY] Fetch TariffFormulaModel audit failed',

	FETCH_TARIFF_FORMULA_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch TariffFormulaModel audits by entity id',
	FETCH_TARIFF_FORMULA_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch TariffFormulaModel audits by entity id successfully',
	FETCH_TARIFF_FORMULA_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch TariffFormulaModel audits by entity id failed',

	FETCH_ALL_TARIFF_FORMULA = '[ENTITY] Fetch all TariffFormulaModel',
	FETCH_ALL_TARIFF_FORMULA_OK = '[ENTITY] Fetch all TariffFormulaModel successfully',
	FETCH_ALL_TARIFF_FORMULA_FAIL = '[ENTITY] Fetch all TariffFormulaModel failed',

	FETCH_TARIFF_FORMULA_WITH_QUERY = '[ENTITY] Fetch TariffFormulaModel with query',
	FETCH_TARIFF_FORMULA_WITH_QUERY_OK = '[ENTITY] Fetch TariffFormulaModel with query successfully',
	FETCH_TARIFF_FORMULA_WITH_QUERY_FAIL = '[ENTITY] Fetch TariffFormulaModel with query failed',

	FETCH_LAST_TARIFF_FORMULA_WITH_QUERY = '[ENTITY] Fetch last TariffFormulaModel with query',
	FETCH_LAST_TARIFF_FORMULA_WITH_QUERY_OK = '[ENTITY] Fetch last TariffFormulaModel with query successfully',
	FETCH_LAST_TARIFF_FORMULA_WITH_QUERY_FAIL = '[ENTITY] Fetch last TariffFormulaModel with query failed',

	EXPORT_TARIFF_FORMULA = '[ENTITY] Export TariffFormulaModel',
	EXPORT_TARIFF_FORMULA_OK = '[ENTITY] Export TariffFormulaModel successfully',
	EXPORT_TARIFF_FORMULA_FAIL = '[ENTITY] Export TariffFormulaModel failed',

	EXPORT_ALL_TARIFF_FORMULA = '[ENTITY] Export All TariffFormulaModels',
	EXPORT_ALL_TARIFF_FORMULA_OK = '[ENTITY] Export All TariffFormulaModels successfully',
	EXPORT_ALL_TARIFF_FORMULA_FAIL = '[ENTITY] Export All TariffFormulaModels failed',

	EXPORT_TARIFF_FORMULA_EXCLUDING_IDS = '[ENTITY] Export TariffFormulaModels excluding Ids',
	EXPORT_TARIFF_FORMULA_EXCLUDING_IDS_OK = '[ENTITY] Export TariffFormulaModel excluding Ids successfully',
	EXPORT_TARIFF_FORMULA_EXCLUDING_IDS_FAIL = '[ENTITY] Export TariffFormulaModel excluding Ids failed',

	COUNT_TARIFF_FORMULAS = '[ENTITY] Fetch number of TariffFormulaModel records',
	COUNT_TARIFF_FORMULAS_OK = '[ENTITY] Fetch number of TariffFormulaModel records successfully ',
	COUNT_TARIFF_FORMULAS_FAIL = '[ENTITY] Fetch number of TariffFormulaModel records failed',

	IMPORT_TARIFF_FORMULAS = '[ENTITY] Import TariffFormulaModels',
	IMPORT_TARIFF_FORMULAS_OK = '[ENTITY] Import TariffFormulaModels successfully',
	IMPORT_TARIFF_FORMULAS_FAIL = '[ENTITY] Import TariffFormulaModels fail',


	INITIALISE_TARIFF_FORMULA_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of TariffFormulaModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseTariffFormulaAction implements Action {
	readonly className: string = 'TariffFormulaModel';

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

export class TariffFormulaAction extends BaseTariffFormulaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffFormulaAction here] off begin
	// % protected region % [Add any additional class fields for TariffFormulaAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffFormulaModel>,
		// % protected region % [Add any additional constructor parameters for TariffFormulaAction here] off begin
		// % protected region % [Add any additional constructor parameters for TariffFormulaAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffFormulaAction here] off begin
			// % protected region % [Add any additional constructor arguments for TariffFormulaAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffFormulaAction here] off begin
		// % protected region % [Add any additional constructor logic for TariffFormulaAction here] end
	}

	// % protected region % [Add any additional class methods for TariffFormulaAction here] off begin
	// % protected region % [Add any additional class methods for TariffFormulaAction here] end
}

export class TariffFormulaActionOK extends BaseTariffFormulaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffFormulaActionOK here] off begin
	// % protected region % [Add any additional class fields for TariffFormulaActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<TariffFormulaModel>,
		// % protected region % [Add any additional constructor parameters for TariffFormulaActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for TariffFormulaActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: TariffFormulaModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffFormulaActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for TariffFormulaActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffFormulaActionOK here] off begin
		// % protected region % [Add any additional constructor logic for TariffFormulaActionOK here] end
	}

	// % protected region % [Add any additional class methods for TariffFormulaActionOK here] off begin
	// % protected region % [Add any additional class methods for TariffFormulaActionOK here] end
}

export class TariffFormulaActionFail extends BaseTariffFormulaAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for TariffFormulaActionFail here] off begin
	// % protected region % [Add any additional class fields for TariffFormulaActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<TariffFormulaModel>,
		// % protected region % [Add any additional constructor parameters for TariffFormulaActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for TariffFormulaActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for TariffFormulaActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for TariffFormulaActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for TariffFormulaActionFail here] off begin
		// % protected region % [Add any additional constructor logic for TariffFormulaActionFail here] end
	}

	// % protected region % [Add any additional class methods for TariffFormulaActionFail here] off begin
	// % protected region % [Add any additional class methods for TariffFormulaActionFail here] end
}

export function isTariffFormulaModelAction(e: any): e is BaseTariffFormulaAction {
	return Object.values(TariffFormulaModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
