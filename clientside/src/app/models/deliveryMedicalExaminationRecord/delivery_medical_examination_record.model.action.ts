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
import {DeliveryMedicalExaminationRecordModel} from './delivery_medical_examination_record.model';
import {DeliveryMedicalExaminationRecordModelAudit} from './delivery_medical_examination_record.model.state';
import {PassableStateConfig} from '../../lib/services/http/interfaces';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * List of Delivery Medical Examination Record model actions to be dispatched by NgRx.
 */
export enum DeliveryMedicalExaminationRecordModelActionTypes {
	CREATE_DELIVERY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Create DeliveryMedicalExaminationRecordModel',
	CREATE_DELIVERY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Create DeliveryMedicalExaminationRecordModel successfully',
	CREATE_DELIVERY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Create DeliveryMedicalExaminationRecordModel failed',

	CREATE_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Create All DeliveryMedicalExaminationRecordModel',
	CREATE_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Create All DeliveryMedicalExaminationRecordModel successfully',
	CREATE_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Create All DeliveryMedicalExaminationRecordModel failed',

	DELETE_DELIVERY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Delete DeliveryMedicalExaminationRecordModel',
	DELETE_DELIVERY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Delete DeliveryMedicalExaminationRecordModel successfully',
	DELETE_DELIVERY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete DeliveryMedicalExaminationRecordModel failed',


	DELETE_DELIVERY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Delete DeliveryMedicalExaminationRecordModels Excluding Ids',
	DELETE_DELIVERY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Delete DeliveryMedicalExaminationRecordModels Excluding Ids successfully',
	DELETE_DELIVERY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Delete DeliveryMedicalExaminationRecordModels Excluding Ids failed',

	DELETE_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Delete all DeliveryMedicalExaminationRecordModels',
	DELETE_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Delete all DeliveryMedicalExaminationRecordModels successfully',
	DELETE_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Delete all DeliveryMedicalExaminationRecordModels failed',

	UPDATE_DELIVERY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Update DeliveryMedicalExaminationRecordModel',
	UPDATE_DELIVERY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Update DeliveryMedicalExaminationRecordModel successfully',
	UPDATE_DELIVERY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Update DeliveryMedicalExaminationRecordModel failed',

	UPDATE_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Update all DeliveryMedicalExaminationRecordModel',
	UPDATE_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Update all DeliveryMedicalExaminationRecordModel successfully',
	UPDATE_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Update all DeliveryMedicalExaminationRecordModel failed',

	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD= '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel',
	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel successfully',
	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel failed',

	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_AUDIT= '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel audit',
	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_AUDIT_OK = '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel audit successfully',
	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_AUDIT_FAIL = '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel audit failed',

	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID= '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel audits by entity id',
	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_OK = '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel audits by entity id successfully',
	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_AUDITS_BY_ENTITY_ID_FAIL = '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel audits by entity id failed',

	FETCH_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Fetch all DeliveryMedicalExaminationRecordModel',
	FETCH_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Fetch all DeliveryMedicalExaminationRecordModel successfully',
	FETCH_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Fetch all DeliveryMedicalExaminationRecordModel failed',

	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel with query',
	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel with query successfully',
	FETCH_DELIVERY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch DeliveryMedicalExaminationRecordModel with query failed',

	FETCH_LAST_DELIVERY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY = '[ENTITY] Fetch last DeliveryMedicalExaminationRecordModel with query',
	FETCH_LAST_DELIVERY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_OK = '[ENTITY] Fetch last DeliveryMedicalExaminationRecordModel with query successfully',
	FETCH_LAST_DELIVERY_MEDICAL_EXAMINATION_RECORD_WITH_QUERY_FAIL = '[ENTITY] Fetch last DeliveryMedicalExaminationRecordModel with query failed',

	EXPORT_DELIVERY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Export DeliveryMedicalExaminationRecordModel',
	EXPORT_DELIVERY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Export DeliveryMedicalExaminationRecordModel successfully',
	EXPORT_DELIVERY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Export DeliveryMedicalExaminationRecordModel failed',

	EXPORT_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD = '[ENTITY] Export All DeliveryMedicalExaminationRecordModels',
	EXPORT_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD_OK = '[ENTITY] Export All DeliveryMedicalExaminationRecordModels successfully',
	EXPORT_ALL_DELIVERY_MEDICAL_EXAMINATION_RECORD_FAIL = '[ENTITY] Export All DeliveryMedicalExaminationRecordModels failed',

	EXPORT_DELIVERY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS = '[ENTITY] Export DeliveryMedicalExaminationRecordModels excluding Ids',
	EXPORT_DELIVERY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_OK = '[ENTITY] Export DeliveryMedicalExaminationRecordModel excluding Ids successfully',
	EXPORT_DELIVERY_MEDICAL_EXAMINATION_RECORD_EXCLUDING_IDS_FAIL = '[ENTITY] Export DeliveryMedicalExaminationRecordModel excluding Ids failed',

	COUNT_DELIVERY_MEDICAL_EXAMINATION_RECORDS = '[ENTITY] Fetch number of DeliveryMedicalExaminationRecordModel records',
	COUNT_DELIVERY_MEDICAL_EXAMINATION_RECORDS_OK = '[ENTITY] Fetch number of DeliveryMedicalExaminationRecordModel records successfully ',
	COUNT_DELIVERY_MEDICAL_EXAMINATION_RECORDS_FAIL = '[ENTITY] Fetch number of DeliveryMedicalExaminationRecordModel records failed',

	IMPORT_DELIVERY_MEDICAL_EXAMINATION_RECORDS = '[ENTITY] Import DeliveryMedicalExaminationRecordModels',
	IMPORT_DELIVERY_MEDICAL_EXAMINATION_RECORDS_OK = '[ENTITY] Import DeliveryMedicalExaminationRecordModels successfully',
	IMPORT_DELIVERY_MEDICAL_EXAMINATION_RECORDS_FAIL = '[ENTITY] Import DeliveryMedicalExaminationRecordModels fail',


	INITIALISE_DELIVERY_MEDICAL_EXAMINATION_RECORD_COLLECTION_STATE = '[ENTITY] Initialize the CollectionState of DeliveryMedicalExaminationRecordModel',
	// % protected region % [Add any additional model actions here] off begin
	// % protected region % [Add any additional model actions here] end
}

export abstract class BaseDeliveryMedicalExaminationRecordAction implements Action {
	readonly className: string = 'DeliveryMedicalExaminationRecordModel';

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

export class DeliveryMedicalExaminationRecordAction extends BaseDeliveryMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DeliveryMedicalExaminationRecordAction here] off begin
	// % protected region % [Add any additional class fields for DeliveryMedicalExaminationRecordAction here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DeliveryMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for DeliveryMedicalExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor parameters for DeliveryMedicalExaminationRecordAction here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DeliveryMedicalExaminationRecordAction here] off begin
			// % protected region % [Add any additional constructor arguments for DeliveryMedicalExaminationRecordAction here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DeliveryMedicalExaminationRecordAction here] off begin
		// % protected region % [Add any additional constructor logic for DeliveryMedicalExaminationRecordAction here] end
	}

	// % protected region % [Add any additional class methods for DeliveryMedicalExaminationRecordAction here] off begin
	// % protected region % [Add any additional class methods for DeliveryMedicalExaminationRecordAction here] end
}

export class DeliveryMedicalExaminationRecordActionOK extends BaseDeliveryMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DeliveryMedicalExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class fields for DeliveryMedicalExaminationRecordActionOK here] end

	public constructor(
		public typeInput: string,
		public readonly stateConfig: PassableStateConfig<DeliveryMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for DeliveryMedicalExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor parameters for DeliveryMedicalExaminationRecordActionOK here] end
		afterwardActions: Action[] = [],
		public audits?: DeliveryMedicalExaminationRecordModelAudit[],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DeliveryMedicalExaminationRecordActionOK here] off begin
			// % protected region % [Add any additional constructor arguments for DeliveryMedicalExaminationRecordActionOK here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DeliveryMedicalExaminationRecordActionOK here] off begin
		// % protected region % [Add any additional constructor logic for DeliveryMedicalExaminationRecordActionOK here] end
	}

	// % protected region % [Add any additional class methods for DeliveryMedicalExaminationRecordActionOK here] off begin
	// % protected region % [Add any additional class methods for DeliveryMedicalExaminationRecordActionOK here] end
}

export class DeliveryMedicalExaminationRecordActionFail extends BaseDeliveryMedicalExaminationRecordAction {

	readonly type: string;

	// % protected region % [Add any additional class fields for DeliveryMedicalExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class fields for DeliveryMedicalExaminationRecordActionFail here] end

	public constructor(
		public typeInput: string,
		public readonly error?: any,
		public stateConfig?: PassableStateConfig<DeliveryMedicalExaminationRecordModel>,
		// % protected region % [Add any additional constructor parameters for DeliveryMedicalExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor parameters for DeliveryMedicalExaminationRecordActionFail here] end
		afterwardActions: Action[] = [],
	) {
		super(
			// % protected region % [Add any additional constructor arguments for DeliveryMedicalExaminationRecordActionFail here] off begin
			// % protected region % [Add any additional constructor arguments for DeliveryMedicalExaminationRecordActionFail here] end
			afterwardActions
		);
		this.type = typeInput;
		// % protected region % [Add any additional constructor logic for DeliveryMedicalExaminationRecordActionFail here] off begin
		// % protected region % [Add any additional constructor logic for DeliveryMedicalExaminationRecordActionFail here] end
	}

	// % protected region % [Add any additional class methods for DeliveryMedicalExaminationRecordActionFail here] off begin
	// % protected region % [Add any additional class methods for DeliveryMedicalExaminationRecordActionFail here] end
}

export function isDeliveryMedicalExaminationRecordModelAction(e: any): e is BaseDeliveryMedicalExaminationRecordAction {
	return Object.values(DeliveryMedicalExaminationRecordModelActionTypes).includes(e);
}

// % protected region % [Add any additional actions here] off begin
// % protected region % [Add any additional actions here] end
