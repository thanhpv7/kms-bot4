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
import {InvoiceSummaryModel} from './invoice_summary.model';
import {InvoiceSummaryModelAudit} from './invoice_summary.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Invoice Summary model actions to be dispatched by NgRx.
 */
export enum InvoiceSummaryModelActionTypes {
	CREATE_INVOICE_SUMMARY = '[ENTITY] Create InvoiceSummaryModel',
	CREATE_INVOICE_SUMMARY_OK = '[ENTITY] Create InvoiceSummaryModel successfully',
	CREATE_INVOICE_SUMMARY_FAIL = '[ENTITY] Create InvoiceSummaryModel failed',

	CREATE_ALL_INVOICE_SUMMARY = '[ENTITY] Create All InvoiceSummaryModel',
	CREATE_ALL_INVOICE_SUMMARY_OK = '[ENTITY] Create All InvoiceSummaryModel successfully',
	CREATE_ALL_INVOICE_SUMMARY_FAIL = '[ENTITY] Create All InvoiceSummaryModel failed',

	DELETE_INVOICE_SUMMARY = '[ENTITY] Delete InvoiceSummaryModel',
	DELETE_INVOICE_SUMMARY_OK = '[ENTITY] Delete InvoiceSummaryModel successfully',
	DELETE_INVOICE_SUMMARY_FAIL = '[ENTITY] Delete InvoiceSummaryModel failed',


	DELETE_INVOICE_SUMMARY_EXCLUDING_IDS = '[ENTITY] Delete InvoiceSummaryModels Excluding Ids',
	DELETE_INVOICE_SUMMARY_EXCLUDING_IDS_OK = '[ENTITY] Delete InvoiceSummaryModels Excluding Ids successfully',
	DELETE_INVOICE_SUMMARY_EXCLUDING_IDS_FAIL = '[ENTITY] Delete InvoiceSummaryModels Excluding Ids failed',

	DELETE_ALL_INVOICE_SUMMARY = '[ENTITY] Delete all InvoiceSummaryModels',
	DELETE_ALL_INVOICE_SUMMARY_OK = '[ENTITY] Delete all InvoiceSummaryModels successfully',
	DELETE_ALL_INVOICE_SUMMARY_FAIL = '[ENTITY] Delete all InvoiceSummaryModels failed',

	UPDATE_INVOICE_SUMMARY = '[ENTITY] Update InvoiceSummaryModel',
	UPDATE_INVOICE_SUMMARY_OK = '[ENTITY] Update InvoiceSummaryModel successfully',
	UPDATE_INVOICE_SUMMARY_FAIL = '[ENTITY] Update InvoiceSummaryModel failed',

	UPDATE_ALL_INVOICE_SUMMARY = '[ENTITY] Update all InvoiceSummaryModel',
	UPDATE_ALL_INVOICE_SUMMARY_OK = '[ENTITY] Update all InvoiceSummaryModel successfully',
	UPDATE_ALL_INVOICE_SUMMARY_FAIL = '[ENTITY] Update all InvoiceSummaryModel failed',

	FETCH_INVOICE_SUMMARY= '[ENTITY] Fetch InvoiceSummaryModel',
	FETCH_INVOICE_SUMMARY_OK = '[ENTITY] Fetch InvoiceSummaryModel successfully',
	FETCH_INVOICE_SUMMARY_FAIL = '[ENTITY] Fetch InvoiceSummaryModel failed',

	FETCH_INVOICE_SUMMARY_AUDIT= '[ENTITY] Fetch InvoiceSummaryModel audit',
	FETCH_INVOICE_SUMMARY_AUDIT_OK = '[ENTITY] Fetch InvoiceSummaryModel audit successfully',
	FETCH_INVOICE_SUMMARY_AUDIT_FAIL = '[ENTITY] Fetch InvoiceSummaryModel audit failed',

	FETCH_INVOICE_SUMMARY_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch InvoiceSummaryModel audits by entity id',
	FETCH_INVOICE_SUMMARY_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch InvoiceSummaryModel audits by entity id successfully',
	FETCH_INVOICE_SUMMARY_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch InvoiceSummaryModel audits by entity id failed',

	FETCH_ALL_INVOICE_SUMMARY = '[ENTITY] Fetch all InvoiceSummaryModel',
	FETCH_ALL_INVOICE_SUMMARY_OK = '[ENTITY] Fetch all InvoiceSummaryModel successfully',
	FETCH_ALL_INVOICE_SUMMARY_FAIL = '[ENTITY] Fetch all InvoiceSummaryModel failed',

	FETCH_INVOICE_SUMMARY_WITH_QUERY = '[ENTITY] Fetch InvoiceSummaryModel with query',
	FETCH_INVOICE_SUMMARY_WITH_QUERY_OK = '[ENTITY] Fetch InvoiceSummaryModel with query successfully',
	FETCH_INVOICE_SUMMARY_WITH_QUERY_FAIL = '[ENTITY] Fetch InvoiceSummaryModel with query failed',

	FETCH_LAST_INVOICE_SUMMARY_WITH_QUERY = '[ENTITY] Fetch last InvoiceSummaryModel with query',
	FETCH_LAST_INVOICE_SUMMARY_WITH_QUERY_OK = '[ENTITY] Fetch last InvoiceSummaryModel with query successfully',
	FETCH_LAST_INVOICE_SUMMARY_WITH_QUERY_FAIL = '[ENTITY] Fetch last InvoiceSummaryModel with query failed',

	EXPORT_INVOICE_SUMMARY = '[ENTITY] Export InvoiceSummaryModel',
	EXPORT_INVOICE_SUMMARY_OK = '[ENTITY] Export InvoiceSummaryModel successfully',
	EXPORT_INVOICE_SUMMARY_FAIL = '[ENTITY] Export InvoiceSummaryModel failed',

	EXPORT_ALL_INVOICE_SUMMARY = '[ENTITY] Export All InvoiceSummaryModels',
	EXPORT_ALL_INVOICE_SUMMARY_OK = '[ENTITY] Export All InvoiceSummaryModels successfully',
	EXPORT_ALL_INVOICE_SUMMARY_FAIL = '[ENTITY] Export All InvoiceSummaryModels failed',

	EXPORT_INVOICE_SUMMARY_EXCLUDING_IDS = '[ENTITY] Export InvoiceSummaryModels excluding Ids',
	EXPORT_INVOICE_SUMMARY_EXCLUDING_IDS_OK = '[ENTITY] Export InvoiceSummaryModel excluding Ids successfully',
	EXPORT_INVOICE_SUMMARY_EXCLUDING_IDS_FAIL = '[ENTITY] Export InvoiceSummaryModel excluding Ids failed',

	COUNT_INVOICE_SUMMARYS = '[ENTITY] Fetch number of InvoiceSummaryModel records',
	COUNT_INVOICE_SUMMARYS_OK = '[ENTITY] Fetch number of InvoiceSummaryModel records successfully ',
	COUNT_INVOICE_SUMMARYS_FAIL = '[ENTITY] Fetch number of InvoiceSummaryModel records failed',

	IMPORT_INVOICE_SUMMARYS = '[ENTITY] Import InvoiceSummaryModels',
	IMPORT_INVOICE_SUMMARYS_OK = '[ENTITY] Import InvoiceSummaryModels successfully',
	IMPORT_INVOICE_SUMMARYS_FAIL = '[ENTITY] Import InvoiceSummaryModels fail',


	INITIALISE_INVOICE_SUMMARY_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of InvoiceSummaryModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseInvoiceSummaryAction implements Action {
	readonly className: string = 'InvoiceSummaryModel';

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

export class InvoiceSummaryAction extends BaseInvoiceSummaryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceSummaryAction here] off begin
	// % protected region % [Add any additional class fields for InvoiceSummaryAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoiceSummaryModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceSummaryAction here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceSummaryAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceSummaryAction here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceSummaryAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceSummaryAction here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceSummaryAction here] end
	}

	// % protected region % [Add any additional class methods for InvoiceSummaryAction here] off begin
	// % protected region % [Add any additional class methods for InvoiceSummaryAction here] end
}

export class InvoiceSummaryActionOK extends BaseInvoiceSummaryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceSummaryActionOK here] off begin
	// % protected region % [Add any additional class fields for InvoiceSummaryActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<InvoiceSummaryModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceSummaryActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceSummaryActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: InvoiceSummaryModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceSummaryActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceSummaryActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceSummaryActionOK here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceSummaryActionOK here] end
	}

	// % protected region % [Add any additional class methods for InvoiceSummaryActionOK here] off begin
	// % protected region % [Add any additional class methods for InvoiceSummaryActionOK here] end
}

export class InvoiceSummaryActionFail extends BaseInvoiceSummaryAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for InvoiceSummaryActionFail here] off begin
	// % protected region % [Add any additional class fields for InvoiceSummaryActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<InvoiceSummaryModel>,
		// % protected region % [Add any additional constructor parameters for InvoiceSummaryActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for InvoiceSummaryActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for InvoiceSummaryActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for InvoiceSummaryActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for InvoiceSummaryActionFail here] off begin
		// % protected region % [Add any additional constructor logic for InvoiceSummaryActionFail here] end
	}

	// % protected region % [Add any additional class methods for InvoiceSummaryActionFail here] off begin
	// % protected region % [Add any additional class methods for InvoiceSummaryActionFail here] end
}

export function isInvoiceSummaryModelAction(e: any): e is BaseInvoiceSummaryAction {
	return Object.values(InvoiceSummaryModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
