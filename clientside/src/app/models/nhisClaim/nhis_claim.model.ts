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
import {FormGroup, Validators} from '@angular/forms';
import {Group, AbstractModel, ModelProperty, ModelPropertyType, ModelRelation, ModelRelationType} from '../../lib/models/abstract.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class NhisClaimModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'systemClaimID',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'NhisClaimModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return NhisClaimModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * .
	 */
	systemClaimID: string;

	/**
	 * .
	 */
	refInvoiceNo: string;

	/**
	 * .
	 */
	formNo: string;

	/**
	 * .
	 */
	claimID: string;

	/**
	 * .
	 */
	claimCheckCode: string;

	/**
	 * .
	 */
	batchNumber: string;

	/**
	 * .
	 */
	surname: string;

	/**
	 * .
	 */
	otherNames: string;

	/**
	 * .
	 */
	gender: string;

	/**
	 * .
	 */
	dateOfBirth: Date;

	/**
	 * .
	 */
	memberNo: string;

	/**
	 * .
	 */
	hospitalRecordNo: string;

	/**
	 * .
	 */
	cardSerialNumber: string;

	/**
	 * .
	 */
	dependant: boolean = false;

	/**
	 * .
	 */
	unbundled: boolean = false;

	/**
	 * .
	 */
	includesPharmacy: boolean = false;

	/**
	 * .
	 */
	typeOfAttendance: string;

	/**
	 * .
	 */
	firstVisitAdmission: Date;

	/**
	 * .
	 */
	secondVisitDischarge: Date;

	/**
	 * .
	 */
	thirdVisit: Date;

	/**
	 * .
	 */
	fourthVisit: Date;

	/**
	 * .
	 */
	physicianName: string;

	/**
	 * .
	 */
	physicianCode: string;



	modelPropGroups: { [s: string]: Group } = NhisClaimModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'systemClaimID',
				// % protected region % [Set displayName for System Claim ID here] off begin
				displayName: 'System Claim ID',
				// % protected region % [Set displayName for System Claim ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for System Claim ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for System Claim ID here] end
				// % protected region % [Set isSensitive for System Claim ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for System Claim ID here] end
				// % protected region % [Set readonly for System Claim ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for System Claim ID here] end
				validators: [
					// % protected region % [Add other validators for System Claim ID here] off begin
					// % protected region % [Add other validators for System Claim ID here] end
				],
				// % protected region % [Add any additional model attribute properties for System Claim ID here] off begin
				// % protected region % [Add any additional model attribute properties for System Claim ID here] end
			},
			{
				name: 'refInvoiceNo',
				// % protected region % [Set displayName for Ref Invoice No here] off begin
				displayName: 'Ref Invoice No',
				// % protected region % [Set displayName for Ref Invoice No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Ref Invoice No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Ref Invoice No here] end
				// % protected region % [Set isSensitive for Ref Invoice No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Ref Invoice No here] end
				// % protected region % [Set readonly for Ref Invoice No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Ref Invoice No here] end
				validators: [
					// % protected region % [Add other validators for Ref Invoice No here] off begin
					// % protected region % [Add other validators for Ref Invoice No here] end
				],
				// % protected region % [Add any additional model attribute properties for Ref Invoice No here] off begin
				// % protected region % [Add any additional model attribute properties for Ref Invoice No here] end
			},
			{
				name: 'formNo',
				// % protected region % [Set displayName for Form No here] off begin
				displayName: 'Form No',
				// % protected region % [Set displayName for Form No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Form No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Form No here] end
				// % protected region % [Set isSensitive for Form No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Form No here] end
				// % protected region % [Set readonly for Form No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Form No here] end
				validators: [
					// % protected region % [Add other validators for Form No here] off begin
					// % protected region % [Add other validators for Form No here] end
				],
				// % protected region % [Add any additional model attribute properties for Form No here] off begin
				// % protected region % [Add any additional model attribute properties for Form No here] end
			},
			{
				name: 'claimID',
				// % protected region % [Set displayName for Claim ID here] off begin
				displayName: 'Claim ID',
				// % protected region % [Set displayName for Claim ID here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Claim ID here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Claim ID here] end
				// % protected region % [Set isSensitive for Claim ID here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Claim ID here] end
				// % protected region % [Set readonly for Claim ID here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Claim ID here] end
				validators: [
					// % protected region % [Add other validators for Claim ID here] off begin
					// % protected region % [Add other validators for Claim ID here] end
				],
				// % protected region % [Add any additional model attribute properties for Claim ID here] off begin
				// % protected region % [Add any additional model attribute properties for Claim ID here] end
			},
			{
				name: 'claimCheckCode',
				// % protected region % [Set displayName for Claim Check Code here] off begin
				displayName: 'Claim Check Code',
				// % protected region % [Set displayName for Claim Check Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Claim Check Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Claim Check Code here] end
				// % protected region % [Set isSensitive for Claim Check Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Claim Check Code here] end
				// % protected region % [Set readonly for Claim Check Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Claim Check Code here] end
				validators: [
					// % protected region % [Add other validators for Claim Check Code here] off begin
					// % protected region % [Add other validators for Claim Check Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Claim Check Code here] off begin
				// % protected region % [Add any additional model attribute properties for Claim Check Code here] end
			},
			{
				name: 'batchNumber',
				// % protected region % [Set displayName for Batch Number here] off begin
				displayName: 'Batch Number',
				// % protected region % [Set displayName for Batch Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Batch Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Batch Number here] end
				// % protected region % [Set isSensitive for Batch Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Batch Number here] end
				// % protected region % [Set readonly for Batch Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Batch Number here] end
				validators: [
					// % protected region % [Add other validators for Batch Number here] off begin
					// % protected region % [Add other validators for Batch Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Batch Number here] off begin
				// % protected region % [Add any additional model attribute properties for Batch Number here] end
			},
			{
				name: 'surname',
				// % protected region % [Set displayName for Surname here] off begin
				displayName: 'Surname',
				// % protected region % [Set displayName for Surname here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Surname here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Surname here] end
				// % protected region % [Set isSensitive for Surname here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Surname here] end
				// % protected region % [Set readonly for Surname here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Surname here] end
				validators: [
					// % protected region % [Add other validators for Surname here] off begin
					// % protected region % [Add other validators for Surname here] end
				],
				// % protected region % [Add any additional model attribute properties for Surname here] off begin
				// % protected region % [Add any additional model attribute properties for Surname here] end
			},
			{
				name: 'otherNames',
				// % protected region % [Set displayName for Other Names here] off begin
				displayName: 'Other Names',
				// % protected region % [Set displayName for Other Names here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Other Names here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Other Names here] end
				// % protected region % [Set isSensitive for Other Names here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Names here] end
				// % protected region % [Set readonly for Other Names here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Names here] end
				validators: [
					// % protected region % [Add other validators for Other Names here] off begin
					// % protected region % [Add other validators for Other Names here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Names here] off begin
				// % protected region % [Add any additional model attribute properties for Other Names here] end
			},
			{
				name: 'gender',
				// % protected region % [Set displayName for Gender here] off begin
				displayName: 'Gender',
				// % protected region % [Set displayName for Gender here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Gender here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Gender here] end
				// % protected region % [Set isSensitive for Gender here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Gender here] end
				// % protected region % [Set readonly for Gender here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Gender here] end
				validators: [
					// % protected region % [Add other validators for Gender here] off begin
					// % protected region % [Add other validators for Gender here] end
				],
				// % protected region % [Add any additional model attribute properties for Gender here] off begin
				// % protected region % [Add any additional model attribute properties for Gender here] end
			},
			{
				name: 'dateOfBirth',
				// % protected region % [Set displayName for Date Of Birth here] off begin
				displayName: 'Date Of Birth',
				// % protected region % [Set displayName for Date Of Birth here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Date Of Birth here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Date Of Birth here] end
				// % protected region % [Set isSensitive for Date Of Birth here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date Of Birth here] end
				// % protected region % [Set readonly for Date Of Birth here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date Of Birth here] end
				validators: [
					// % protected region % [Add other validators for Date Of Birth here] off begin
					// % protected region % [Add other validators for Date Of Birth here] end
				],
				// % protected region % [Add any additional model attribute properties for Date Of Birth here] off begin
				// % protected region % [Add any additional model attribute properties for Date Of Birth here] end
			},
			{
				name: 'memberNo',
				// % protected region % [Set displayName for Member No here] off begin
				displayName: 'Member No',
				// % protected region % [Set displayName for Member No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Member No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Member No here] end
				// % protected region % [Set isSensitive for Member No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Member No here] end
				// % protected region % [Set readonly for Member No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Member No here] end
				validators: [
					// % protected region % [Add other validators for Member No here] off begin
					// % protected region % [Add other validators for Member No here] end
				],
				// % protected region % [Add any additional model attribute properties for Member No here] off begin
				// % protected region % [Add any additional model attribute properties for Member No here] end
			},
			{
				name: 'hospitalRecordNo',
				// % protected region % [Set displayName for Hospital Record No here] off begin
				displayName: 'Hospital Record No',
				// % protected region % [Set displayName for Hospital Record No here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Record No here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Record No here] end
				// % protected region % [Set isSensitive for Hospital Record No here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Record No here] end
				// % protected region % [Set readonly for Hospital Record No here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Record No here] end
				validators: [
					// % protected region % [Add other validators for Hospital Record No here] off begin
					// % protected region % [Add other validators for Hospital Record No here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Record No here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Record No here] end
			},
			{
				name: 'cardSerialNumber',
				// % protected region % [Set displayName for Card Serial Number here] off begin
				displayName: 'Card Serial Number',
				// % protected region % [Set displayName for Card Serial Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Card Serial Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Card Serial Number here] end
				// % protected region % [Set isSensitive for Card Serial Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Card Serial Number here] end
				// % protected region % [Set readonly for Card Serial Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Card Serial Number here] end
				validators: [
					// % protected region % [Add other validators for Card Serial Number here] off begin
					// % protected region % [Add other validators for Card Serial Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Card Serial Number here] off begin
				// % protected region % [Add any additional model attribute properties for Card Serial Number here] end
			},
			{
				name: 'dependant',
				// % protected region % [Set displayName for Dependant here] off begin
				displayName: 'Dependant',
				// % protected region % [Set displayName for Dependant here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Dependant here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Dependant here] end
				// % protected region % [Set isSensitive for Dependant here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dependant here] end
				// % protected region % [Set readonly for Dependant here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dependant here] end
				validators: [
					// % protected region % [Add other validators for Dependant here] off begin
					// % protected region % [Add other validators for Dependant here] end
				],
				// % protected region % [Add any additional model attribute properties for Dependant here] off begin
				// % protected region % [Add any additional model attribute properties for Dependant here] end
			},
			{
				name: 'unbundled',
				// % protected region % [Set displayName for Unbundled here] off begin
				displayName: 'Unbundled',
				// % protected region % [Set displayName for Unbundled here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Unbundled here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Unbundled here] end
				// % protected region % [Set isSensitive for Unbundled here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Unbundled here] end
				// % protected region % [Set readonly for Unbundled here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Unbundled here] end
				validators: [
					// % protected region % [Add other validators for Unbundled here] off begin
					// % protected region % [Add other validators for Unbundled here] end
				],
				// % protected region % [Add any additional model attribute properties for Unbundled here] off begin
				// % protected region % [Add any additional model attribute properties for Unbundled here] end
			},
			{
				name: 'includesPharmacy',
				// % protected region % [Set displayName for Includes Pharmacy here] off begin
				displayName: 'Includes Pharmacy',
				// % protected region % [Set displayName for Includes Pharmacy here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Includes Pharmacy here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Includes Pharmacy here] end
				// % protected region % [Set isSensitive for Includes Pharmacy here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Includes Pharmacy here] end
				// % protected region % [Set readonly for Includes Pharmacy here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Includes Pharmacy here] end
				validators: [
					// % protected region % [Add other validators for Includes Pharmacy here] off begin
					// % protected region % [Add other validators for Includes Pharmacy here] end
				],
				// % protected region % [Add any additional model attribute properties for Includes Pharmacy here] off begin
				// % protected region % [Add any additional model attribute properties for Includes Pharmacy here] end
			},
			{
				name: 'typeOfAttendance',
				// % protected region % [Set displayName for Type Of Attendance here] off begin
				displayName: 'Type Of Attendance',
				// % protected region % [Set displayName for Type Of Attendance here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Type Of Attendance here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Type Of Attendance here] end
				// % protected region % [Set isSensitive for Type Of Attendance here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Type Of Attendance here] end
				// % protected region % [Set readonly for Type Of Attendance here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Type Of Attendance here] end
				validators: [
					// % protected region % [Add other validators for Type Of Attendance here] off begin
					// % protected region % [Add other validators for Type Of Attendance here] end
				],
				// % protected region % [Add any additional model attribute properties for Type Of Attendance here] off begin
				// % protected region % [Add any additional model attribute properties for Type Of Attendance here] end
			},
			{
				name: 'firstVisitAdmission',
				// % protected region % [Set displayName for First Visit Admission here] off begin
				displayName: 'First Visit Admission',
				// % protected region % [Set displayName for First Visit Admission here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for First Visit Admission here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for First Visit Admission here] end
				// % protected region % [Set isSensitive for First Visit Admission here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for First Visit Admission here] end
				// % protected region % [Set readonly for First Visit Admission here] off begin
				readOnly: false,
				// % protected region % [Set readonly for First Visit Admission here] end
				validators: [
					// % protected region % [Add other validators for First Visit Admission here] off begin
					// % protected region % [Add other validators for First Visit Admission here] end
				],
				// % protected region % [Add any additional model attribute properties for First Visit Admission here] off begin
				// % protected region % [Add any additional model attribute properties for First Visit Admission here] end
			},
			{
				name: 'secondVisitDischarge',
				// % protected region % [Set displayName for Second Visit Discharge here] off begin
				displayName: 'Second Visit Discharge',
				// % protected region % [Set displayName for Second Visit Discharge here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Second Visit Discharge here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Second Visit Discharge here] end
				// % protected region % [Set isSensitive for Second Visit Discharge here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Second Visit Discharge here] end
				// % protected region % [Set readonly for Second Visit Discharge here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Second Visit Discharge here] end
				validators: [
					// % protected region % [Add other validators for Second Visit Discharge here] off begin
					// % protected region % [Add other validators for Second Visit Discharge here] end
				],
				// % protected region % [Add any additional model attribute properties for Second Visit Discharge here] off begin
				// % protected region % [Add any additional model attribute properties for Second Visit Discharge here] end
			},
			{
				name: 'thirdVisit',
				// % protected region % [Set displayName for Third Visit here] off begin
				displayName: 'Third Visit',
				// % protected region % [Set displayName for Third Visit here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Third Visit here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Third Visit here] end
				// % protected region % [Set isSensitive for Third Visit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Third Visit here] end
				// % protected region % [Set readonly for Third Visit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Third Visit here] end
				validators: [
					// % protected region % [Add other validators for Third Visit here] off begin
					// % protected region % [Add other validators for Third Visit here] end
				],
				// % protected region % [Add any additional model attribute properties for Third Visit here] off begin
				// % protected region % [Add any additional model attribute properties for Third Visit here] end
			},
			{
				name: 'fourthVisit',
				// % protected region % [Set displayName for Fourth Visit here] off begin
				displayName: 'Fourth Visit',
				// % protected region % [Set displayName for Fourth Visit here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Fourth Visit here] off begin
				elementType: ElementType.DATETIME,
				// % protected region % [Set display element type for Fourth Visit here] end
				// % protected region % [Set isSensitive for Fourth Visit here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Fourth Visit here] end
				// % protected region % [Set readonly for Fourth Visit here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Fourth Visit here] end
				validators: [
					// % protected region % [Add other validators for Fourth Visit here] off begin
					// % protected region % [Add other validators for Fourth Visit here] end
				],
				// % protected region % [Add any additional model attribute properties for Fourth Visit here] off begin
				// % protected region % [Add any additional model attribute properties for Fourth Visit here] end
			},
			{
				name: 'physicianName',
				// % protected region % [Set displayName for Physician Name here] off begin
				displayName: 'Physician Name',
				// % protected region % [Set displayName for Physician Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Physician Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Physician Name here] end
				// % protected region % [Set isSensitive for Physician Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Physician Name here] end
				// % protected region % [Set readonly for Physician Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Physician Name here] end
				validators: [
					// % protected region % [Add other validators for Physician Name here] off begin
					// % protected region % [Add other validators for Physician Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Physician Name here] off begin
				// % protected region % [Add any additional model attribute properties for Physician Name here] end
			},
			{
				name: 'physicianCode',
				// % protected region % [Set displayName for Physician Code here] off begin
				displayName: 'Physician Code',
				// % protected region % [Set displayName for Physician Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Physician Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Physician Code here] end
				// % protected region % [Set isSensitive for Physician Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Physician Code here] end
				// % protected region % [Set readonly for Physician Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Physician Code here] end
				validators: [
					// % protected region % [Add other validators for Physician Code here] off begin
					// % protected region % [Add other validators for Physician Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Physician Code here] off begin
				// % protected region % [Add any additional model attribute properties for Physician Code here] end
			},
			// % protected region % [Add any additional class field names here] off begin
			// % protected region % [Add any additional class field names here] end
		]);
	}

	/**
	 * The relations of the entity
	 */
	static getRelations(): ModelRelation[] {
		return super.getRelations().concat([
		]);
	}

	/**
	 * Convert the form group to the query conditions
	 */
	static convertFilterToCondition(formGroup: FormGroup): Where[][] {
		let conditions: Where[][] = [];

		// % protected region % [Overide the default convertFilterToCondition here] off begin
		Object.keys(formGroup.value).forEach((key) => {
			switch (key) {
				case 'created':
					const created = formGroup.value[key];
					// is the range of date
					if (created instanceof Array) {
						conditions.push([
							{
								path: key,
								operation: QueryOperation.GREATER_THAN_OR_EQUAL,
								value: created[0]
							}
						]);
						conditions.push([
							{
								path: key,
								operation: QueryOperation.LESS_THAN_OR_EQUAL,
								value: created[1]
							}
						]);
					}
			}
		});
		// % protected region % [Overide the default convertFilterToCondition here] end


		return conditions;
	}

	/**
	 * Convert a nested JSON object into an array of flatten objects.
	 */
	static deepParse(data: string | { [K in keyof NhisClaimModel]?: NhisClaimModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new NhisClaimModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let nhisClaimModel = new NhisClaimModel(data);`
	 *
	 * @param data The input data to be initialised as the NhisClaimModel,
	 *    it is expected as a JSON string or as a nullable NhisClaimModel.
	 */
	constructor(data?: string | Partial<NhisClaimModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<NhisClaimModel>
				: data;

			this.systemClaimID = json.systemClaimID;
			this.refInvoiceNo = json.refInvoiceNo;
			this.formNo = json.formNo;
			this.claimID = json.claimID;
			this.claimCheckCode = json.claimCheckCode;
			this.batchNumber = json.batchNumber;
			this.surname = json.surname;
			this.otherNames = json.otherNames;
			this.gender = json.gender;
			if (json.dateOfBirth) {
				this.dateOfBirth = new Date(json.dateOfBirth);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dateOfBirth = json.dateOfBirth;
			}
			this.memberNo = json.memberNo;
			this.hospitalRecordNo = json.hospitalRecordNo;
			this.cardSerialNumber = json.cardSerialNumber;
			this.dependant = json.dependant;
			this.unbundled = json.unbundled;
			this.includesPharmacy = json.includesPharmacy;
			this.typeOfAttendance = json.typeOfAttendance;
			if (json.firstVisitAdmission) {
				this.firstVisitAdmission = new Date(json.firstVisitAdmission);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.firstVisitAdmission = json.firstVisitAdmission;
			}
			if (json.secondVisitDischarge) {
				this.secondVisitDischarge = new Date(json.secondVisitDischarge);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.secondVisitDischarge = json.secondVisitDischarge;
			}
			if (json.thirdVisit) {
				this.thirdVisit = new Date(json.thirdVisit);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.thirdVisit = json.thirdVisit;
			}
			if (json.fourthVisit) {
				this.fourthVisit = new Date(json.fourthVisit);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.fourthVisit = json.fourthVisit;
			}
			this.physicianName = json.physicianName;
			this.physicianCode = json.physicianCode;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			systemClaimID: this.systemClaimID,
			refInvoiceNo: this.refInvoiceNo,
			formNo: this.formNo,
			claimID: this.claimID,
			claimCheckCode: this.claimCheckCode,
			batchNumber: this.batchNumber,
			surname: this.surname,
			otherNames: this.otherNames,
			gender: this.gender,
			dateOfBirth: this.dateOfBirth,
			memberNo: this.memberNo,
			hospitalRecordNo: this.hospitalRecordNo,
			cardSerialNumber: this.cardSerialNumber,
			dependant: this.dependant,
			unbundled: this.unbundled,
			includesPharmacy: this.includesPharmacy,
			typeOfAttendance: this.typeOfAttendance,
			firstVisitAdmission: this.firstVisitAdmission,
			secondVisitDischarge: this.secondVisitDischarge,
			thirdVisit: this.thirdVisit,
			fourthVisit: this.fourthVisit,
			physicianName: this.physicianName,
			physicianCode: this.physicianCode,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		NhisClaimModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): NhisClaimModel {
		let newModelJson = this.toJSON();

		if (updates.systemClaimID) {
			newModelJson.systemClaimID = updates.systemClaimID;
		}

		if (updates.refInvoiceNo) {
			newModelJson.refInvoiceNo = updates.refInvoiceNo;
		}

		if (updates.formNo) {
			newModelJson.formNo = updates.formNo;
		}

		if (updates.claimID) {
			newModelJson.claimID = updates.claimID;
		}

		if (updates.claimCheckCode) {
			newModelJson.claimCheckCode = updates.claimCheckCode;
		}

		if (updates.batchNumber) {
			newModelJson.batchNumber = updates.batchNumber;
		}

		if (updates.surname) {
			newModelJson.surname = updates.surname;
		}

		if (updates.otherNames) {
			newModelJson.otherNames = updates.otherNames;
		}

		if (updates.gender) {
			newModelJson.gender = updates.gender;
		}

		if (updates.dateOfBirth) {
			newModelJson.dateOfBirth = updates.dateOfBirth;
		}

		if (updates.memberNo) {
			newModelJson.memberNo = updates.memberNo;
		}

		if (updates.hospitalRecordNo) {
			newModelJson.hospitalRecordNo = updates.hospitalRecordNo;
		}

		if (updates.cardSerialNumber) {
			newModelJson.cardSerialNumber = updates.cardSerialNumber;
		}

		if (updates.dependant) {
			newModelJson.dependant = updates.dependant;
		}

		if (updates.unbundled) {
			newModelJson.unbundled = updates.unbundled;
		}

		if (updates.includesPharmacy) {
			newModelJson.includesPharmacy = updates.includesPharmacy;
		}

		if (updates.typeOfAttendance) {
			newModelJson.typeOfAttendance = updates.typeOfAttendance;
		}

		if (updates.firstVisitAdmission) {
			newModelJson.firstVisitAdmission = updates.firstVisitAdmission;
		}

		if (updates.secondVisitDischarge) {
			newModelJson.secondVisitDischarge = updates.secondVisitDischarge;
		}

		if (updates.thirdVisit) {
			newModelJson.thirdVisit = updates.thirdVisit;
		}

		if (updates.fourthVisit) {
			newModelJson.fourthVisit = updates.fourthVisit;
		}

		if (updates.physicianName) {
			newModelJson.physicianName = updates.physicianName;
		}

		if (updates.physicianCode) {
			newModelJson.physicianCode = updates.physicianCode;
		}

		return new NhisClaimModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof NhisClaimModel)) {
			return {};
		}

		const diff = {};

		for (const key of _.keys(this)) {
			const thisValue = this[key];
			const otherValue = other[key];

			// Handle dates differently
			if (thisValue instanceof Date) {
				let thisDate = (thisValue) ? thisValue.getTime() : null;
				let otherDate = (otherValue) ? otherValue.getTime() : null;

				if (thisDate !== otherDate) {
					diff[key] = thisValue;
				}
			} else if (thisValue !== otherValue) {
				diff[key] = thisValue;
			}
		}

		return _.omit(diff, [
			'created',
			'modified',
			// % protected region % [Add any other fields to omit here] off begin
			// % protected region % [Add any other fields to omit here] end
		]);
	}

	/**
	 * Sets the relation ID parameters to be based on the ID's of the associated entities.
	 * 
	 * Fetching entities is based on the object, but updating relations is based on the id, so we need to
	 * make sure that they match
	 */
	syncRelations() {
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
