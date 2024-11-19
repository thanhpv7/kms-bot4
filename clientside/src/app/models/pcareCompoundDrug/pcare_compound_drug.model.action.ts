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
import {PcareCompoundDrugModel} from './pcare_compound_drug.model';
import {PcareCompoundDrugModelAudit} from './pcare_compound_drug.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare Compound Drug model actions to be dispatched by NgRx.
 */
export enum PcareCompoundDrugModelActionTypes {
	CREATE_PCARE_COMPOUND_DRUG = '[ENTITY] Create PcareCompoundDrugModel',
	CREATE_PCARE_COMPOUND_DRUG_OK = '[ENTITY] Create PcareCompoundDrugModel successfully',
	CREATE_PCARE_COMPOUND_DRUG_FAIL = '[ENTITY] Create PcareCompoundDrugModel failed',

	CREATE_ALL_PCARE_COMPOUND_DRUG = '[ENTITY] Create All PcareCompoundDrugModel',
	CREATE_ALL_PCARE_COMPOUND_DRUG_OK = '[ENTITY] Create All PcareCompoundDrugModel successfully',
	CREATE_ALL_PCARE_COMPOUND_DRUG_FAIL = '[ENTITY] Create All PcareCompoundDrugModel failed',

	DELETE_PCARE_COMPOUND_DRUG = '[ENTITY] Delete PcareCompoundDrugModel',
	DELETE_PCARE_COMPOUND_DRUG_OK = '[ENTITY] Delete PcareCompoundDrugModel successfully',
	DELETE_PCARE_COMPOUND_DRUG_FAIL = '[ENTITY] Delete PcareCompoundDrugModel failed',


	DELETE_PCARE_COMPOUND_DRUG_EXCLUDING_IDS = '[ENTITY] Delete PcareCompoundDrugModels Excluding Ids',
	DELETE_PCARE_COMPOUND_DRUG_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareCompoundDrugModels Excluding Ids successfully',
	DELETE_PCARE_COMPOUND_DRUG_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareCompoundDrugModels Excluding Ids failed',

	DELETE_ALL_PCARE_COMPOUND_DRUG = '[ENTITY] Delete all PcareCompoundDrugModels',
	DELETE_ALL_PCARE_COMPOUND_DRUG_OK = '[ENTITY] Delete all PcareCompoundDrugModels successfully',
	DELETE_ALL_PCARE_COMPOUND_DRUG_FAIL = '[ENTITY] Delete all PcareCompoundDrugModels failed',

	UPDATE_PCARE_COMPOUND_DRUG = '[ENTITY] Update PcareCompoundDrugModel',
	UPDATE_PCARE_COMPOUND_DRUG_OK = '[ENTITY] Update PcareCompoundDrugModel successfully',
	UPDATE_PCARE_COMPOUND_DRUG_FAIL = '[ENTITY] Update PcareCompoundDrugModel failed',

	UPDATE_ALL_PCARE_COMPOUND_DRUG = '[ENTITY] Update all PcareCompoundDrugModel',
	UPDATE_ALL_PCARE_COMPOUND_DRUG_OK = '[ENTITY] Update all PcareCompoundDrugModel successfully',
	UPDATE_ALL_PCARE_COMPOUND_DRUG_FAIL = '[ENTITY] Update all PcareCompoundDrugModel failed',

	FETCH_PCARE_COMPOUND_DRUG= '[ENTITY] Fetch PcareCompoundDrugModel',
	FETCH_PCARE_COMPOUND_DRUG_OK = '[ENTITY] Fetch PcareCompoundDrugModel successfully',
	FETCH_PCARE_COMPOUND_DRUG_FAIL = '[ENTITY] Fetch PcareCompoundDrugModel failed',

	FETCH_PCARE_COMPOUND_DRUG_AUDIT= '[ENTITY] Fetch PcareCompoundDrugModel audit',
	FETCH_PCARE_COMPOUND_DRUG_AUDIT_OK = '[ENTITY] Fetch PcareCompoundDrugModel audit successfully',
	FETCH_PCARE_COMPOUND_DRUG_AUDIT_FAIL = '[ENTITY] Fetch PcareCompoundDrugModel audit failed',

	FETCH_PCARE_COMPOUND_DRUG_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareCompoundDrugModel audits by entity id',
	FETCH_PCARE_COMPOUND_DRUG_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareCompoundDrugModel audits by entity id successfully',
	FETCH_PCARE_COMPOUND_DRUG_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareCompoundDrugModel audits by entity id failed',

	FETCH_ALL_PCARE_COMPOUND_DRUG = '[ENTITY] Fetch all PcareCompoundDrugModel',
	FETCH_ALL_PCARE_COMPOUND_DRUG_OK = '[ENTITY] Fetch all PcareCompoundDrugModel successfully',
	FETCH_ALL_PCARE_COMPOUND_DRUG_FAIL = '[ENTITY] Fetch all PcareCompoundDrugModel failed',

	FETCH_PCARE_COMPOUND_DRUG_WITH_QUERY = '[ENTITY] Fetch PcareCompoundDrugModel with query',
	FETCH_PCARE_COMPOUND_DRUG_WITH_QUERY_OK = '[ENTITY] Fetch PcareCompoundDrugModel with query successfully',
	FETCH_PCARE_COMPOUND_DRUG_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareCompoundDrugModel with query failed',

	FETCH_LAST_PCARE_COMPOUND_DRUG_WITH_QUERY = '[ENTITY] Fetch last PcareCompoundDrugModel with query',
	FETCH_LAST_PCARE_COMPOUND_DRUG_WITH_QUERY_OK = '[ENTITY] Fetch last PcareCompoundDrugModel with query successfully',
	FETCH_LAST_PCARE_COMPOUND_DRUG_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareCompoundDrugModel with query failed',

	EXPORT_PCARE_COMPOUND_DRUG = '[ENTITY] Export PcareCompoundDrugModel',
	EXPORT_PCARE_COMPOUND_DRUG_OK = '[ENTITY] Export PcareCompoundDrugModel successfully',
	EXPORT_PCARE_COMPOUND_DRUG_FAIL = '[ENTITY] Export PcareCompoundDrugModel failed',

	EXPORT_ALL_PCARE_COMPOUND_DRUG = '[ENTITY] Export All PcareCompoundDrugModels',
	EXPORT_ALL_PCARE_COMPOUND_DRUG_OK = '[ENTITY] Export All PcareCompoundDrugModels successfully',
	EXPORT_ALL_PCARE_COMPOUND_DRUG_FAIL = '[ENTITY] Export All PcareCompoundDrugModels failed',

	EXPORT_PCARE_COMPOUND_DRUG_EXCLUDING_IDS = '[ENTITY] Export PcareCompoundDrugModels excluding Ids',
	EXPORT_PCARE_COMPOUND_DRUG_EXCLUDING_IDS_OK = '[ENTITY] Export PcareCompoundDrugModel excluding Ids successfully',
	EXPORT_PCARE_COMPOUND_DRUG_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareCompoundDrugModel excluding Ids failed',

	COUNT_PCARE_COMPOUND_DRUGS = '[ENTITY] Fetch number of PcareCompoundDrugModel records',
	COUNT_PCARE_COMPOUND_DRUGS_OK = '[ENTITY] Fetch number of PcareCompoundDrugModel records successfully ',
	COUNT_PCARE_COMPOUND_DRUGS_FAIL = '[ENTITY] Fetch number of PcareCompoundDrugModel records failed',

	IMPORT_PCARE_COMPOUND_DRUGS = '[ENTITY] Import PcareCompoundDrugModels',
	IMPORT_PCARE_COMPOUND_DRUGS_OK = '[ENTITY] Import PcareCompoundDrugModels successfully',
	IMPORT_PCARE_COMPOUND_DRUGS_FAIL = '[ENTITY] Import PcareCompoundDrugModels fail',


	INITIALISE_PCARE_COMPOUND_DRUG_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareCompoundDrugModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareCompoundDrugAction implements Action {
	readonly className: string = 'PcareCompoundDrugModel';

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

export class PcareCompoundDrugAction extends BasePcareCompoundDrugAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareCompoundDrugAction here] off begin
	// % protected region % [Add any additional class fields for PcareCompoundDrugAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareCompoundDrugModel>,
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugAction here] end
	}

	// % protected region % [Add any additional class methods for PcareCompoundDrugAction here] off begin
	// % protected region % [Add any additional class methods for PcareCompoundDrugAction here] end
}

export class PcareCompoundDrugActionOK extends BasePcareCompoundDrugAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareCompoundDrugActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareCompoundDrugActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareCompoundDrugModel>,
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareCompoundDrugModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareCompoundDrugActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareCompoundDrugActionOK here] end
}

export class PcareCompoundDrugActionFail extends BasePcareCompoundDrugAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareCompoundDrugActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareCompoundDrugActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareCompoundDrugModel>,
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareCompoundDrugActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareCompoundDrugActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareCompoundDrugActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareCompoundDrugActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareCompoundDrugActionFail here] end
}

export function isPcareCompoundDrugModelAction(e: any): e is BasePcareCompoundDrugAction {
	return Object.values(PcareCompoundDrugModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
