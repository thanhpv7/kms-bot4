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
import {PatientSupportingDocumentModel} from './patient_supporting_document.model';
import {PatientSupportingDocumentModelAudit} from './patient_supporting_document.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Patient Supporting Document model actions to be dispatched by NgRx.
 */
export enum PatientSupportingDocumentModelActionTypes {
	CREATE_PATIENT_SUPPORTING_DOCUMENT = '[ENTITY] Create PatientSupportingDocumentModel',
	CREATE_PATIENT_SUPPORTING_DOCUMENT_OK = '[ENTITY] Create PatientSupportingDocumentModel successfully',
	CREATE_PATIENT_SUPPORTING_DOCUMENT_FAIL = '[ENTITY] Create PatientSupportingDocumentModel failed',

	CREATE_ALL_PATIENT_SUPPORTING_DOCUMENT = '[ENTITY] Create All PatientSupportingDocumentModel',
	CREATE_ALL_PATIENT_SUPPORTING_DOCUMENT_OK = '[ENTITY] Create All PatientSupportingDocumentModel successfully',
	CREATE_ALL_PATIENT_SUPPORTING_DOCUMENT_FAIL = '[ENTITY] Create All PatientSupportingDocumentModel failed',

	DELETE_PATIENT_SUPPORTING_DOCUMENT = '[ENTITY] Delete PatientSupportingDocumentModel',
	DELETE_PATIENT_SUPPORTING_DOCUMENT_OK = '[ENTITY] Delete PatientSupportingDocumentModel successfully',
	DELETE_PATIENT_SUPPORTING_DOCUMENT_FAIL = '[ENTITY] Delete PatientSupportingDocumentModel failed',


	DELETE_PATIENT_SUPPORTING_DOCUMENT_EXCLUDING_IDS = '[ENTITY] Delete PatientSupportingDocumentModels Excluding Ids',
	DELETE_PATIENT_SUPPORTING_DOCUMENT_EXCLUDING_IDS_OK = '[ENTITY] Delete PatientSupportingDocumentModels Excluding Ids successfully',
	DELETE_PATIENT_SUPPORTING_DOCUMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Delete PatientSupportingDocumentModels Excluding Ids failed',

	DELETE_ALL_PATIENT_SUPPORTING_DOCUMENT = '[ENTITY] Delete all PatientSupportingDocumentModels',
	DELETE_ALL_PATIENT_SUPPORTING_DOCUMENT_OK = '[ENTITY] Delete all PatientSupportingDocumentModels successfully',
	DELETE_ALL_PATIENT_SUPPORTING_DOCUMENT_FAIL = '[ENTITY] Delete all PatientSupportingDocumentModels failed',

	UPDATE_PATIENT_SUPPORTING_DOCUMENT = '[ENTITY] Update PatientSupportingDocumentModel',
	UPDATE_PATIENT_SUPPORTING_DOCUMENT_OK = '[ENTITY] Update PatientSupportingDocumentModel successfully',
	UPDATE_PATIENT_SUPPORTING_DOCUMENT_FAIL = '[ENTITY] Update PatientSupportingDocumentModel failed',

	UPDATE_ALL_PATIENT_SUPPORTING_DOCUMENT = '[ENTITY] Update all PatientSupportingDocumentModel',
	UPDATE_ALL_PATIENT_SUPPORTING_DOCUMENT_OK = '[ENTITY] Update all PatientSupportingDocumentModel successfully',
	UPDATE_ALL_PATIENT_SUPPORTING_DOCUMENT_FAIL = '[ENTITY] Update all PatientSupportingDocumentModel failed',

	FETCH_PATIENT_SUPPORTING_DOCUMENT= '[ENTITY] Fetch PatientSupportingDocumentModel',
	FETCH_PATIENT_SUPPORTING_DOCUMENT_OK = '[ENTITY] Fetch PatientSupportingDocumentModel successfully',
	FETCH_PATIENT_SUPPORTING_DOCUMENT_FAIL = '[ENTITY] Fetch PatientSupportingDocumentModel failed',

	FETCH_PATIENT_SUPPORTING_DOCUMENT_AUDIT= '[ENTITY] Fetch PatientSupportingDocumentModel audit',
	FETCH_PATIENT_SUPPORTING_DOCUMENT_AUDIT_OK = '[ENTITY] Fetch PatientSupportingDocumentModel audit successfully',
	FETCH_PATIENT_SUPPORTING_DOCUMENT_AUDIT_FAIL = '[ENTITY] Fetch PatientSupportingDocumentModel audit failed',

	FETCH_PATIENT_SUPPORTING_DOCUMENT_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch PatientSupportingDocumentModel audits by entity id',
	FETCH_PATIENT_SUPPORTING_DOCUMENT_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch PatientSupportingDocumentModel audits by entity id successfully',
	FETCH_PATIENT_SUPPORTING_DOCUMENT_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch PatientSupportingDocumentModel audits by entity id failed',

	FETCH_ALL_PATIENT_SUPPORTING_DOCUMENT = '[ENTITY] Fetch all PatientSupportingDocumentModel',
	FETCH_ALL_PATIENT_SUPPORTING_DOCUMENT_OK = '[ENTITY] Fetch all PatientSupportingDocumentModel successfully',
	FETCH_ALL_PATIENT_SUPPORTING_DOCUMENT_FAIL = '[ENTITY] Fetch all PatientSupportingDocumentModel failed',

	FETCH_PATIENT_SUPPORTING_DOCUMENT_WITH_QUERY = '[ENTITY] Fetch PatientSupportingDocumentModel with query',
	FETCH_PATIENT_SUPPORTING_DOCUMENT_WITH_QUERY_OK = '[ENTITY] Fetch PatientSupportingDocumentModel with query successfully',
	FETCH_PATIENT_SUPPORTING_DOCUMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch PatientSupportingDocumentModel with query failed',

	FETCH_LAST_PATIENT_SUPPORTING_DOCUMENT_WITH_QUERY = '[ENTITY] Fetch last PatientSupportingDocumentModel with query',
	FETCH_LAST_PATIENT_SUPPORTING_DOCUMENT_WITH_QUERY_OK = '[ENTITY] Fetch last PatientSupportingDocumentModel with query successfully',
	FETCH_LAST_PATIENT_SUPPORTING_DOCUMENT_WITH_QUERY_FAIL = '[ENTITY] Fetch last PatientSupportingDocumentModel with query failed',

	EXPORT_PATIENT_SUPPORTING_DOCUMENT = '[ENTITY] Export PatientSupportingDocumentModel',
	EXPORT_PATIENT_SUPPORTING_DOCUMENT_OK = '[ENTITY] Export PatientSupportingDocumentModel successfully',
	EXPORT_PATIENT_SUPPORTING_DOCUMENT_FAIL = '[ENTITY] Export PatientSupportingDocumentModel failed',

	EXPORT_ALL_PATIENT_SUPPORTING_DOCUMENT = '[ENTITY] Export All PatientSupportingDocumentModels',
	EXPORT_ALL_PATIENT_SUPPORTING_DOCUMENT_OK = '[ENTITY] Export All PatientSupportingDocumentModels successfully',
	EXPORT_ALL_PATIENT_SUPPORTING_DOCUMENT_FAIL = '[ENTITY] Export All PatientSupportingDocumentModels failed',

	EXPORT_PATIENT_SUPPORTING_DOCUMENT_EXCLUDING_IDS = '[ENTITY] Export PatientSupportingDocumentModels excluding Ids',
	EXPORT_PATIENT_SUPPORTING_DOCUMENT_EXCLUDING_IDS_OK = '[ENTITY] Export PatientSupportingDocumentModel excluding Ids successfully',
	EXPORT_PATIENT_SUPPORTING_DOCUMENT_EXCLUDING_IDS_FAIL = '[ENTITY] Export PatientSupportingDocumentModel excluding Ids failed',

	COUNT_PATIENT_SUPPORTING_DOCUMENTS = '[ENTITY] Fetch number of PatientSupportingDocumentModel records',
	COUNT_PATIENT_SUPPORTING_DOCUMENTS_OK = '[ENTITY] Fetch number of PatientSupportingDocumentModel records successfully ',
	COUNT_PATIENT_SUPPORTING_DOCUMENTS_FAIL = '[ENTITY] Fetch number of PatientSupportingDocumentModel records failed',

	IMPORT_PATIENT_SUPPORTING_DOCUMENTS = '[ENTITY] Import PatientSupportingDocumentModels',
	IMPORT_PATIENT_SUPPORTING_DOCUMENTS_OK = '[ENTITY] Import PatientSupportingDocumentModels successfully',
	IMPORT_PATIENT_SUPPORTING_DOCUMENTS_FAIL = '[ENTITY] Import PatientSupportingDocumentModels fail',


	INITIALISE_PATIENT_SUPPORTING_DOCUMENT_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of PatientSupportingDocumentModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BasePatientSupportingDocumentAction implements Action {
	readonly className: string = 'PatientSupportingDocumentModel';

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

export class PatientSupportingDocumentAction extends BasePatientSupportingDocumentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientSupportingDocumentAction here] off begin
	// % protected region % [Add any additional class fields for PatientSupportingDocumentAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientSupportingDocumentModel>,
		// % protected region % [Add any additional constructor parameters for PatientSupportingDocumentAction here] off begin
		// % protected region % [Add any additional constructor parameters for PatientSupportingDocumentAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientSupportingDocumentAction here] off begin
			// % protected region % [Add any additional constructor arguments for PatientSupportingDocumentAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientSupportingDocumentAction here] off begin
		// % protected region % [Add any additional constructor logic for PatientSupportingDocumentAction here] end
	}

	// % protected region % [Add any additional class methods for PatientSupportingDocumentAction here] off begin
	// % protected region % [Add any additional class methods for PatientSupportingDocumentAction here] end
}

export class PatientSupportingDocumentActionOK extends BasePatientSupportingDocumentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientSupportingDocumentActionOK here] off begin
	// % protected region % [Add any additional class fields for PatientSupportingDocumentActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<PatientSupportingDocumentModel>,
		// % protected region % [Add any additional constructor parameters for PatientSupportingDocumentActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for PatientSupportingDocumentActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: PatientSupportingDocumentModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientSupportingDocumentActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for PatientSupportingDocumentActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientSupportingDocumentActionOK here] off begin
		// % protected region % [Add any additional constructor logic for PatientSupportingDocumentActionOK here] end
	}

	// % protected region % [Add any additional class methods for PatientSupportingDocumentActionOK here] off begin
	// % protected region % [Add any additional class methods for PatientSupportingDocumentActionOK here] end
}

export class PatientSupportingDocumentActionFail extends BasePatientSupportingDocumentAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for PatientSupportingDocumentActionFail here] off begin
	// % protected region % [Add any additional class fields for PatientSupportingDocumentActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<PatientSupportingDocumentModel>,
		// % protected region % [Add any additional constructor parameters for PatientSupportingDocumentActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for PatientSupportingDocumentActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for PatientSupportingDocumentActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for PatientSupportingDocumentActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for PatientSupportingDocumentActionFail here] off begin
		// % protected region % [Add any additional constructor logic for PatientSupportingDocumentActionFail here] end
	}

	// % protected region % [Add any additional class methods for PatientSupportingDocumentActionFail here] off begin
	// % protected region % [Add any additional class methods for PatientSupportingDocumentActionFail here] end
}

export function isPatientSupportingDocumentModelAction(e: any): e is BasePatientSupportingDocumentAction {
	return Object.values(PatientSupportingDocumentModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
