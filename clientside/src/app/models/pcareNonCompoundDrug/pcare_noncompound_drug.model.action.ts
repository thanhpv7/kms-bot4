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
import {PcareNonCompoundDrugModel} from './pcare_noncompound_drug.model';
import {PcareNonCompoundDrugModelAudit} from './pcare_noncompound_drug.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of PCare NonCompound Drug model actions to be dispatched by NgRx.
 */
export enum PcareNonCompoundDrugModelActionTypes {
	CREATE_PCARE_NONCOMPOUND_DRUG = '[ENTITY] Create PcareNonCompoundDrugModel',
	CREATE_PCARE_NONCOMPOUND_DRUG_OK = '[ENTITY] Create PcareNonCompoundDrugModel successfully',
	CREATE_PCARE_NONCOMPOUND_DRUG_FAIL = '[ENTITY] Create PcareNonCompoundDrugModel failed',

	CREATE_ALL_PCARE_NONCOMPOUND_DRUG = '[ENTITY] Create All PcareNonCompoundDrugModel',
	CREATE_ALL_PCARE_NONCOMPOUND_DRUG_OK = '[ENTITY] Create All PcareNonCompoundDrugModel successfully',
	CREATE_ALL_PCARE_NONCOMPOUND_DRUG_FAIL = '[ENTITY] Create All PcareNonCompoundDrugModel failed',

	DELETE_PCARE_NONCOMPOUND_DRUG = '[ENTITY] Delete PcareNonCompoundDrugModel',
	DELETE_PCARE_NONCOMPOUND_DRUG_OK = '[ENTITY] Delete PcareNonCompoundDrugModel successfully',
	DELETE_PCARE_NONCOMPOUND_DRUG_FAIL = '[ENTITY] Delete PcareNonCompoundDrugModel failed',


	DELETE_PCARE_NONCOMPOUND_DRUG_EXCLUDING_IDS = '[ENTITY] Delete PcareNonCompoundDrugModels Excluding Ids',
	DELETE_PCARE_NONCOMPOUND_DRUG_EXCLUDING_IDS_OK = '[ENTITY] Delete PcareNonCompoundDrugModels Excluding Ids successfully',
	DELETE_PCARE_NONCOMPOUND_DRUG_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PcareNonCompoundDrugModels Excluding Ids failed',

	DELETE_ALL_PCARE_NONCOMPOUND_DRUG = '[ENTITY] Delete all PcareNonCompoundDrugModels',
	DELETE_ALL_PCARE_NONCOMPOUND_DRUG_OK = '[ENTITY] Delete all PcareNonCompoundDrugModels successfully',
	DELETE_ALL_PCARE_NONCOMPOUND_DRUG_FAIL = '[ENTITY] Delete all PcareNonCompoundDrugModels failed',

	UPDATE_PCARE_NONCOMPOUND_DRUG = '[ENTITY] Update PcareNonCompoundDrugModel',
	UPDATE_PCARE_NONCOMPOUND_DRUG_OK = '[ENTITY] Update PcareNonCompoundDrugModel successfully',
	UPDATE_PCARE_NONCOMPOUND_DRUG_FAIL = '[ENTITY] Update PcareNonCompoundDrugModel failed',

	UPDATE_ALL_PCARE_NONCOMPOUND_DRUG = '[ENTITY] Update all PcareNonCompoundDrugModel',
	UPDATE_ALL_PCARE_NONCOMPOUND_DRUG_OK = '[ENTITY] Update all PcareNonCompoundDrugModel successfully',
	UPDATE_ALL_PCARE_NONCOMPOUND_DRUG_FAIL = '[ENTITY] Update all PcareNonCompoundDrugModel failed',

	FETCH_PCARE_NONCOMPOUND_DRUG= '[ENTITY] Fetch PcareNonCompoundDrugModel',
	FETCH_PCARE_NONCOMPOUND_DRUG_OK = '[ENTITY] Fetch PcareNonCompoundDrugModel successfully',
	FETCH_PCARE_NONCOMPOUND_DRUG_FAIL = '[ENTITY] Fetch PcareNonCompoundDrugModel failed',

	FETCH_PCARE_NONCOMPOUND_DRUG_AUDIT= '[ENTITY] Fetch PcareNonCompoundDrugModel audit',
	FETCH_PCARE_NONCOMPOUND_DRUG_AUDIT_OK = '[ENTITY] Fetch PcareNonCompoundDrugModel audit successfully',
	FETCH_PCARE_NONCOMPOUND_DRUG_AUDIT_FAIL = '[ENTITY] Fetch PcareNonCompoundDrugModel audit failed',

	FETCH_PCARE_NONCOMPOUND_DRUG_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PcareNonCompoundDrugModel audits by entity id',
	FETCH_PCARE_NONCOMPOUND_DRUG_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PcareNonCompoundDrugModel audits by entity id successfully',
	FETCH_PCARE_NONCOMPOUND_DRUG_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PcareNonCompoundDrugModel audits by entity id failed',

	FETCH_ALL_PCARE_NONCOMPOUND_DRUG = '[ENTITY] Fetch all PcareNonCompoundDrugModel',
	FETCH_ALL_PCARE_NONCOMPOUND_DRUG_OK = '[ENTITY] Fetch all PcareNonCompoundDrugModel successfully',
	FETCH_ALL_PCARE_NONCOMPOUND_DRUG_FAIL = '[ENTITY] Fetch all PcareNonCompoundDrugModel failed',

	FETCH_PCARE_NONCOMPOUND_DRUG_WITH_QUERY = '[ENTITY] Fetch PcareNonCompoundDrugModel with query',
	FETCH_PCARE_NONCOMPOUND_DRUG_WITH_QUERY_OK = '[ENTITY] Fetch PcareNonCompoundDrugModel with query successfully',
	FETCH_PCARE_NONCOMPOUND_DRUG_WITH_QUERY_FAIL = '[ENTITY] Fetch PcareNonCompoundDrugModel with query failed',

	FETCH_LAST_PCARE_NONCOMPOUND_DRUG_WITH_QUERY = '[ENTITY] Fetch last PcareNonCompoundDrugModel with query',
	FETCH_LAST_PCARE_NONCOMPOUND_DRUG_WITH_QUERY_OK = '[ENTITY] Fetch last PcareNonCompoundDrugModel with query successfully',
	FETCH_LAST_PCARE_NONCOMPOUND_DRUG_WITH_QUERY_FAIL = '[ENTITY] Fetch last PcareNonCompoundDrugModel with query failed',

	EXPORT_PCARE_NONCOMPOUND_DRUG = '[ENTITY] Export PcareNonCompoundDrugModel',
	EXPORT_PCARE_NONCOMPOUND_DRUG_OK = '[ENTITY] Export PcareNonCompoundDrugModel successfully',
	EXPORT_PCARE_NONCOMPOUND_DRUG_FAIL = '[ENTITY] Export PcareNonCompoundDrugModel failed',

	EXPORT_ALL_PCARE_NONCOMPOUND_DRUG = '[ENTITY] Export All PcareNonCompoundDrugModels',
	EXPORT_ALL_PCARE_NONCOMPOUND_DRUG_OK = '[ENTITY] Export All PcareNonCompoundDrugModels successfully',
	EXPORT_ALL_PCARE_NONCOMPOUND_DRUG_FAIL = '[ENTITY] Export All PcareNonCompoundDrugModels failed',

	EXPORT_PCARE_NONCOMPOUND_DRUG_EXCLUDING_IDS = '[ENTITY] Export PcareNonCompoundDrugModels excluding Ids',
	EXPORT_PCARE_NONCOMPOUND_DRUG_EXCLUDING_IDS_OK = '[ENTITY] Export PcareNonCompoundDrugModel excluding Ids successfully',
	EXPORT_PCARE_NONCOMPOUND_DRUG_EXCLUDING_IDS_FAIL = '[ENTITY] Export PcareNonCompoundDrugModel excluding Ids failed',

	COUNT_PCARE_NONCOMPOUND_DRUGS = '[ENTITY] Fetch number of PcareNonCompoundDrugModel records',
	COUNT_PCARE_NONCOMPOUND_DRUGS_OK = '[ENTITY] Fetch number of PcareNonCompoundDrugModel records successfully ',
	COUNT_PCARE_NONCOMPOUND_DRUGS_FAIL = '[ENTITY] Fetch number of PcareNonCompoundDrugModel records failed',

	IMPORT_PCARE_NONCOMPOUND_DRUGS = '[ENTITY] Import PcareNonCompoundDrugModels',
	IMPORT_PCARE_NONCOMPOUND_DRUGS_OK = '[ENTITY] Import PcareNonCompoundDrugModels successfully',
	IMPORT_PCARE_NONCOMPOUND_DRUGS_FAIL = '[ENTITY] Import PcareNonCompoundDrugModels fail',


	INITIALISE_PCARE_NONCOMPOUND_DRUG_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PcareNonCompoundDrugModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePcareNonCompoundDrugAction implements Action {
	readonly className: string = 'PcareNonCompoundDrugModel';

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

export class PcareNonCompoundDrugAction extends BasePcareNonCompoundDrugAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareNonCompoundDrugAction here] off begin
	// % protected region % [Add any additional class fields for PcareNonCompoundDrugAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareNonCompoundDrugModel>,
		// % protected region % [Add any additional constructor parameters for PcareNonCompoundDrugAction here] off begin
		// % protected region % [Add any additional constructor parameters for PcareNonCompoundDrugAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareNonCompoundDrugAction here] off begin
			// % protected region % [Add any additional constructor arguments for PcareNonCompoundDrugAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareNonCompoundDrugAction here] off begin
		// % protected region % [Add any additional constructor logic for PcareNonCompoundDrugAction here] end
	}

	// % protected region % [Add any additional class methods for PcareNonCompoundDrugAction here] off begin
	// % protected region % [Add any additional class methods for PcareNonCompoundDrugAction here] end
}

export class PcareNonCompoundDrugActionOK extends BasePcareNonCompoundDrugAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareNonCompoundDrugActionOK here] off begin
	// % protected region % [Add any additional class fields for PcareNonCompoundDrugActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PcareNonCompoundDrugModel>,
		// % protected region % [Add any additional constructor parameters for PcareNonCompoundDrugActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PcareNonCompoundDrugActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PcareNonCompoundDrugModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareNonCompoundDrugActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PcareNonCompoundDrugActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareNonCompoundDrugActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PcareNonCompoundDrugActionOK here] end
	}

	// % protected region % [Add any additional class methods for PcareNonCompoundDrugActionOK here] off begin
	// % protected region % [Add any additional class methods for PcareNonCompoundDrugActionOK here] end
}

export class PcareNonCompoundDrugActionFail extends BasePcareNonCompoundDrugAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PcareNonCompoundDrugActionFail here] off begin
	// % protected region % [Add any additional class fields for PcareNonCompoundDrugActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PcareNonCompoundDrugModel>,
		// % protected region % [Add any additional constructor parameters for PcareNonCompoundDrugActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PcareNonCompoundDrugActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PcareNonCompoundDrugActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PcareNonCompoundDrugActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PcareNonCompoundDrugActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PcareNonCompoundDrugActionFail here] end
	}

	// % protected region % [Add any additional class methods for PcareNonCompoundDrugActionFail here] off begin
	// % protected region % [Add any additional class methods for PcareNonCompoundDrugActionFail here] end
}

export function isPcareNonCompoundDrugModelAction(e: any): e is BasePcareNonCompoundDrugAction {
	return Object.values(PcareNonCompoundDrugModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
