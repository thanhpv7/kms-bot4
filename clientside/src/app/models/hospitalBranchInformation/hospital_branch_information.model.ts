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
import {HospitalGroupInformationModel} from '../hospitalGroupInformation/hospital_group_information.model';
import {StaffModel} from '../staff/staff.model';
import * as _ from 'lodash';
import {QueryOperation, Where} from '../../lib/services/http/interfaces';
import {ElementType} from '../../lib/components/abstract.input.component';
import {FileModel} from '../../lib/models/file.model';
import { CustomValidators } from 'src/app/lib/utils/validators/custom-validators';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * POJO model class used to store information related to the entity.
 */
export class HospitalBranchInformationModel extends AbstractModel {
	/**
	 * The fields which are set as searchable in the entity model
	 * The fields could be used in search in the server side
	 * The fields would be by default used as search in the crud tile.
	 * You could also use this in other tiles for searching.
	 */
	static searchFields: string[] = [
		'hospitalCode',
		'hospitalName',
		'hospitalType',
		'isBPJSFacility',
		'taxIdentification',
		// % protected region % [Add any additional searchable field names here] off begin
		// % protected region % [Add any additional searchable field names here] end
	];

	/**
	 * Attributes to be shown in value to display
	 */
	static displayAttributes: string[] = [
		// % protected region % [Change displayAttributes here if needed] off begin
		'hospitalCode',
		// % protected region % [Change displayAttributes here if needed] end
	];

	static modelPropGroups: { [s: string]: Group } = {
		// % protected region % [Add groups for the entity here] off begin
		// % protected region % [Add groups for the entity here] end
	};

	readonly className = 'HospitalBranchInformationModel';

	/**
	 * Default value to be displayed in dropdown etc
	 */
	get valueToDisplay(): string {
		// % protected region % [Change displayName here if needed] off begin
		return HospitalBranchInformationModel.displayAttributes.map((attr) => this[attr]).join(' ');
		// % protected region % [Change displayName here if needed] end
	}

	/**
	 * Hospital Code (Max Length: 50).
	 */
	hospitalCode: string;

	/**
	 * Hospital Name (Max Length: 250).
	 */
	hospitalName: string;

	/**
	 * Hospital Type, get from Reference Type: HOSP_TYPE (Max Length: 20).
	 */
	hospitalType: string;

	/**
	 * Hospital Class, get from Reference Type: HOSP_CLASS (Max Length: 20).
	 */
	hospitalClass: string;

	/**
	 * Hospital Director Name (Max Length: 250).
	 */
	hospitalDirectorName: string;

	/**
	 * Date of Registration.
	 */
	dateOfRegistration: Date;

	/**
	 * Hospital Corporation Name (Max Length: 250).
	 */
	hospitalCorporationName: string;

	/**
	 * Indicator whether using BPJS facility or not.
	 */
	isBPJSFacility: boolean = false;

	/**
	 * Address (Max Length: 500).
	 */
	address: string;

	/**
	 * Region or City (Max Length: 250).
	 */
	city: string;

	/**
	 * Postcode (Max Length: 50).
	 */
	postcode: string;

	/**
	 * Phone Number (Max Length: 50).
	 */
	phoneNumber: string;

	/**
	 * Fax (Max Length: 50).
	 */
	fax: string;

	/**
	 * Email (Max Length: 250).
	 */
	email: string;

	/**
	 * Website (Max Length: 250).
	 */
	website: string;

	/**
	 * Contact Person (Max Length: 250).
	 */
	contactPerson: string;

	/**
	 * Contact Person Phone Number (Max Length: 50).
	 */
	contactPersonPhoneNumber: string;

	/**
	 * Contact Person Email (Max Length: 250).
	 */
	contactPersonEmail: string;

	/**
	 * Land Size (Max Length: 50).
	 */
	landSize: string;

	/**
	 * Building Size (Max Length: 50).
	 */
	buildingSize: string;

	/**
	 * Permit Number (Max Length: 50).
	 */
	permitNumber: string;

	/**
	 * Permit Date.
	 */
	permitDate: Date;

	/**
	 * Authorized By (Max Length: 250).
	 */
	authorizedBy: string;

	/**
	 * Type (Max Length: 50).
	 */
	permitType: string;

	/**
	 * Valid Until.
	 */
	validUntil: Date;

	/**
	 * Branch Name (Max Length: 250).
	 */
	hospitalBranchCorporationName: string;

	/**
	 * Hospital Branch Corporation Status, get from Reference Type: HOSP_GRP_TYPE (Max Length: 20).
	 */
	hospitalBranchCorporationStatus: string;

	/**
	 * Accreditation Type (Max Length: 250).
	 */
	accreditationType: string;

	/**
	 * Accreditation Level (Max Length: 50).
	 */
	accreditationLevel: string;

	/**
	 * Accreditation Date.
	 */
	accreditationDate: Date;

	/**
	 * Bed Perinatology (Max Length: 50).
	 */
	bedPerinatology: string;

	/**
	 * Suite Class (Max Length: 50).
	 */
	suiteClass: string;

	/**
	 * VVIP Class (Max Length: 50).
	 */
	vvipClass: string;

	/**
	 * VIP A Class.
	 */
	vipAClass: string;

	/**
	 * VIP B Class (Max Length: 50).
	 */
	vipBClass: string;

	/**
	 * VIP C Class (Max Length: 50).
	 */
	vipCClass: string;

	/**
	 * Main Class (Max Length: 50).
	 */
	mainClass: string;

	/**
	 * Class I  (Max Length: 50).
	 */
	classI: string;

	/**
	 * II Class (Max Length: 50).
	 */
	iiClass: string;

	/**
	 * III A Class (Max Length: 50).
	 */
	iiiAClass: string;

	/**
	 * III B Class (Max Length: 50).
	 */
	iiiBClass: string;

	/**
	 * Special Class (Max Length: 50).
	 */
	specialClass: string;

	/**
	 * ICU (Max Length: 50).
	 */
	icu: string;

	/**
	 * PICU (Max Length: 50).
	 */
	picu: string;

	/**
	 * NICU (Max Length: 50).
	 */
	nicu: string;

	/**
	 * HCU (Max Length: 50).
	 */
	hcu: string;

	/**
	 * ICCU (Max Length: 50).
	 */
	iccu: string;

	/**
	 * Isolation Room (Max Length: 50).
	 */
	isolationRoom: string;

	/**
	 * Emergency Room (Max Length: 50).
	 */
	emergencyRoom: string;

	/**
	 * Maternity Room (Max Length: 50).
	 */
	maternityRoom: string;

	/**
	 * Operating Room (Max Length: 50).
	 */
	operatingRoom: string;

	/**
	 * Doctor SpA (Max Length: 250).
	 */
	doctorSpA: string;

	/**
	 * Doctor SpOG (Max Length: 250).
	 */
	doctorSpOG: string;

	/**
	 * Doctor SpPD (Max Length: 250).
	 */
	doctorSpPD: string;

	/**
	 * Doctor SpB (Max Length: 250).
	 */
	doctorSpB: string;

	/**
	 * Doctor SpRad (Max Length: 250).
	 */
	doctorSpRad: string;

	/**
	 * Doctor SpRm (Max Length: 250).
	 */
	doctorSpRm: string;

	/**
	 * Doctor SpAn (Max Length: 250).
	 */
	doctorSpAn: string;

	/**
	 * Doctor SpJp.
	 */
	doctorSpJp: string;

	/**
	 * Doctor SpM (Max Length: 250).
	 */
	doctorSpM: string;

	/**
	 * Doctor SpTHT (Max Length: 250).
	 */
	doctorSpTHT: string;

	/**
	 * Doctor SpKj (Max Length: 250).
	 */
	doctorSpKj: string;

	/**
	 * Doctor SpP (Max Length: 250).
	 */
	doctorSpP: string;

	/**
	 * Doctor SpPK (Max Length: 250).
	 */
	doctorSpPK: string;

	/**
	 * Doctor SpS (Max Length: 250).
	 */
	doctorSpS: string;

	/**
	 * Sub Specialist Doctor (Max Length: 250).
	 */
	subSpecialistDoctor: string;

	/**
	 * Other Specialist Doctor (Max Length: 250).
	 */
	otherSpecialistDoctor: string;

	/**
	 * General Practice (Max Length: 250).
	 */
	generalPractice: string;

	/**
	 * Dentist (Max Length: 250).
	 */
	dentist: string;

	/**
	 * Specialist Dentist (Max Length: 250).
	 */
	specialistDentist: string;

	/**
	 * Nurse (Max Length: 250).
	 */
	nurse: string;

	/**
	 * Midwife (Max Length: 250).
	 */
	midwife: string;

	/**
	 * Pharmacist (Max Length: 250).
	 */
	pharmacist: string;

	/**
	 * Other Medical Staff (Max Length: 250).
	 */
	otherMedicalStaff: string;

	/**
	 * Non Medical Staff (Max Length: 250).
	 */
	nonMedicalStaff: string;

	/**
	 * Left Header Logo.
	 */
	leftLogo: FileModel[];

	/**
	 * Right Header Logo.
	 */
	rightLogo: FileModel[];

	/**
	 * .
	 */
	timezone: string;

	/**
	 * Option to use PCare or VClaim.
	 */
	healthFacilityLevel: string;

	/**
	 * Satu Sehat Flag.
	 */
	satuSehatIntegration: boolean = false;

	/**
	 * Tax Number.
	 */
	taxIdentification: string;

	hospitalGroupId: string;

	hospitalGroup: HospitalGroupInformationModel;

	staffId: string;

	staff: StaffModel;

	modelPropGroups: { [s: string]: Group } = HospitalBranchInformationModel.modelPropGroups;

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	static getProps(): ModelProperty[] {
		return super.getProps().concat([
			{
				name: 'hospitalCode',
				// % protected region % [Set displayName for Hospital Code here] off begin
				displayName: 'Hospital Code',
				// % protected region % [Set displayName for Hospital Code here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Code here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Code here] end
				// % protected region % [Set isSensitive for Hospital Code here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Code here] end
				// % protected region % [Set readonly for Hospital Code here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Code here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Hospital Code here] off begin
					// % protected region % [Add other validators for Hospital Code here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Code here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Code here] end
			},
			{
				name: 'hospitalName',
				// % protected region % [Set displayName for Hospital Name here] off begin
				displayName: 'Hospital Name',
				// % protected region % [Set displayName for Hospital Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Name here] end
				// % protected region % [Set isSensitive for Hospital Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Name here] end
				// % protected region % [Set readonly for Hospital Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Hospital Name here] off begin
					// % protected region % [Add other validators for Hospital Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Name here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Name here] end
			},
			{
				name: 'hospitalType',
				// % protected region % [Set displayName for Hospital Type here] off begin
				displayName: 'Hospital Type',
				// % protected region % [Set displayName for Hospital Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Type here] end
				// % protected region % [Set isSensitive for Hospital Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Type here] end
				// % protected region % [Set readonly for Hospital Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Type here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Hospital Type here] off begin
					// % protected region % [Add other validators for Hospital Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Type here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Type here] end
			},
			{
				name: 'hospitalClass',
				// % protected region % [Set displayName for Hospital Class here] off begin
				displayName: 'Hospital Class',
				// % protected region % [Set displayName for Hospital Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Class here] end
				// % protected region % [Set isSensitive for Hospital Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Class here] end
				// % protected region % [Set readonly for Hospital Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Class here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Hospital Class here] off begin
					// % protected region % [Add other validators for Hospital Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Class here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Class here] end
			},
			{
				name: 'hospitalDirectorName',
				// % protected region % [Set displayName for Hospital Director Name here] off begin
				displayName: 'Hospital Director Name',
				// % protected region % [Set displayName for Hospital Director Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Director Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Director Name here] end
				// % protected region % [Set isSensitive for Hospital Director Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Director Name here] end
				// % protected region % [Set readonly for Hospital Director Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Director Name here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Hospital Director Name here] off begin
					// % protected region % [Add other validators for Hospital Director Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Director Name here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Director Name here] end
			},
			{
				name: 'dateOfRegistration',
				// % protected region % [Set displayName for Date of Registration here] off begin
				displayName: 'Date of Registration',
				// % protected region % [Set displayName for Date of Registration here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Date of Registration here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Date of Registration here] end
				// % protected region % [Set isSensitive for Date of Registration here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Date of Registration here] end
				// % protected region % [Set readonly for Date of Registration here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Date of Registration here] end
				validators: [
					// % protected region % [Add other validators for Date of Registration here] off begin
					// % protected region % [Add other validators for Date of Registration here] end
				],
				// % protected region % [Add any additional model attribute properties for Date of Registration here] off begin
				// % protected region % [Add any additional model attribute properties for Date of Registration here] end
			},
			{
				name: 'hospitalCorporationName',
				// % protected region % [Set displayName for Hospital Corporation Name here] off begin
				displayName: 'Hospital Corporation Name',
				// % protected region % [Set displayName for Hospital Corporation Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Corporation Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Corporation Name here] end
				// % protected region % [Set isSensitive for Hospital Corporation Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Corporation Name here] end
				// % protected region % [Set readonly for Hospital Corporation Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Corporation Name here] end
				validators: [
					// % protected region % [Add other validators for Hospital Corporation Name here] off begin
					// % protected region % [Add other validators for Hospital Corporation Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Corporation Name here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Corporation Name here] end
			},
			{
				name: 'isBPJSFacility',
				// % protected region % [Set displayName for Is BPJS Facility here] off begin
				displayName: 'Is BPJS Facility',
				// % protected region % [Set displayName for Is BPJS Facility here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Is BPJS Facility here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Is BPJS Facility here] end
				// % protected region % [Set isSensitive for Is BPJS Facility here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Is BPJS Facility here] end
				// % protected region % [Set readonly for Is BPJS Facility here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Is BPJS Facility here] end
				validators: [
					// % protected region % [Add other validators for Is BPJS Facility here] off begin
					// % protected region % [Add other validators for Is BPJS Facility here] end
				],
				// % protected region % [Add any additional model attribute properties for Is BPJS Facility here] off begin
				// % protected region % [Add any additional model attribute properties for Is BPJS Facility here] end
			},
			{
				name: 'address',
				// % protected region % [Set displayName for Address here] off begin
				displayName: 'Address',
				// % protected region % [Set displayName for Address here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Address here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Address here] end
				// % protected region % [Set isSensitive for Address here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Address here] end
				// % protected region % [Set readonly for Address here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Address here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for Address here] off begin
					// % protected region % [Add other validators for Address here] end
				],
				// % protected region % [Add any additional model attribute properties for Address here] off begin
				// % protected region % [Add any additional model attribute properties for Address here] end
			},
			{
				name: 'city',
				// % protected region % [Set displayName for City here] off begin
				displayName: 'City',
				// % protected region % [Set displayName for City here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for City here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for City here] end
				// % protected region % [Set isSensitive for City here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for City here] end
				// % protected region % [Set readonly for City here] off begin
				readOnly: false,
				// % protected region % [Set readonly for City here] end
				validators: [
					Validators.required,
					CustomValidators.nonEmptyString(),
					// % protected region % [Add other validators for City here] off begin
					// % protected region % [Add other validators for City here] end
				],
				// % protected region % [Add any additional model attribute properties for City here] off begin
				// % protected region % [Add any additional model attribute properties for City here] end
			},
			{
				name: 'postcode',
				// % protected region % [Set displayName for Postcode here] off begin
				displayName: 'Postcode',
				// % protected region % [Set displayName for Postcode here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Postcode here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Postcode here] end
				// % protected region % [Set isSensitive for Postcode here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Postcode here] end
				// % protected region % [Set readonly for Postcode here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Postcode here] end
				validators: [
					// % protected region % [Add other validators for Postcode here] off begin
					// % protected region % [Add other validators for Postcode here] end
				],
				// % protected region % [Add any additional model attribute properties for Postcode here] off begin
				// % protected region % [Add any additional model attribute properties for Postcode here] end
			},
			{
				name: 'phoneNumber',
				// % protected region % [Set displayName for Phone Number here] off begin
				displayName: 'Phone Number',
				// % protected region % [Set displayName for Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Phone Number here] end
				// % protected region % [Set isSensitive for Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Phone Number here] end
				// % protected region % [Set readonly for Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Phone Number here] end
				validators: [
					// % protected region % [Add other validators for Phone Number here] off begin
					// % protected region % [Add other validators for Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Phone Number here] end
			},
			{
				name: 'fax',
				// % protected region % [Set displayName for Fax here] off begin
				displayName: 'Fax',
				// % protected region % [Set displayName for Fax here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Fax here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Fax here] end
				// % protected region % [Set isSensitive for Fax here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Fax here] end
				// % protected region % [Set readonly for Fax here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Fax here] end
				validators: [
					// % protected region % [Add other validators for Fax here] off begin
					// % protected region % [Add other validators for Fax here] end
				],
				// % protected region % [Add any additional model attribute properties for Fax here] off begin
				// % protected region % [Add any additional model attribute properties for Fax here] end
			},
			{
				name: 'email',
				// % protected region % [Set displayName for Email here] off begin
				displayName: 'Email',
				// % protected region % [Set displayName for Email here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Email here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Email here] end
				// % protected region % [Set isSensitive for Email here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Email here] end
				// % protected region % [Set readonly for Email here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Email here] end
				validators: [
					// % protected region % [Add other validators for Email here] off begin
					// % protected region % [Add other validators for Email here] end
				],
				// % protected region % [Add any additional model attribute properties for Email here] off begin
				// % protected region % [Add any additional model attribute properties for Email here] end
			},
			{
				name: 'website',
				// % protected region % [Set displayName for Website here] off begin
				displayName: 'Website',
				// % protected region % [Set displayName for Website here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Website here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Website here] end
				// % protected region % [Set isSensitive for Website here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Website here] end
				// % protected region % [Set readonly for Website here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Website here] end
				validators: [
					// % protected region % [Add other validators for Website here] off begin
					// % protected region % [Add other validators for Website here] end
				],
				// % protected region % [Add any additional model attribute properties for Website here] off begin
				// % protected region % [Add any additional model attribute properties for Website here] end
			},
			{
				name: 'contactPerson',
				// % protected region % [Set displayName for Contact Person here] off begin
				displayName: 'Contact Person',
				// % protected region % [Set displayName for Contact Person here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Contact Person here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Contact Person here] end
				// % protected region % [Set isSensitive for Contact Person here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Contact Person here] end
				// % protected region % [Set readonly for Contact Person here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Contact Person here] end
				validators: [
					// % protected region % [Add other validators for Contact Person here] off begin
					// % protected region % [Add other validators for Contact Person here] end
				],
				// % protected region % [Add any additional model attribute properties for Contact Person here] off begin
				// % protected region % [Add any additional model attribute properties for Contact Person here] end
			},
			{
				name: 'contactPersonPhoneNumber',
				// % protected region % [Set displayName for Contact Person Phone Number here] off begin
				displayName: 'Contact Person Phone Number',
				// % protected region % [Set displayName for Contact Person Phone Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Contact Person Phone Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Contact Person Phone Number here] end
				// % protected region % [Set isSensitive for Contact Person Phone Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Contact Person Phone Number here] end
				// % protected region % [Set readonly for Contact Person Phone Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Contact Person Phone Number here] end
				validators: [
					// % protected region % [Add other validators for Contact Person Phone Number here] off begin
					// % protected region % [Add other validators for Contact Person Phone Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Contact Person Phone Number here] off begin
				// % protected region % [Add any additional model attribute properties for Contact Person Phone Number here] end
			},
			{
				name: 'contactPersonEmail',
				// % protected region % [Set displayName for Contact Person Email here] off begin
				displayName: 'Contact Person Email',
				// % protected region % [Set displayName for Contact Person Email here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Contact Person Email here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Contact Person Email here] end
				// % protected region % [Set isSensitive for Contact Person Email here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Contact Person Email here] end
				// % protected region % [Set readonly for Contact Person Email here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Contact Person Email here] end
				validators: [
					// % protected region % [Add other validators for Contact Person Email here] off begin
					// % protected region % [Add other validators for Contact Person Email here] end
				],
				// % protected region % [Add any additional model attribute properties for Contact Person Email here] off begin
				// % protected region % [Add any additional model attribute properties for Contact Person Email here] end
			},
			{
				name: 'landSize',
				// % protected region % [Set displayName for Land Size here] off begin
				displayName: 'Land Size',
				// % protected region % [Set displayName for Land Size here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Land Size here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Land Size here] end
				// % protected region % [Set isSensitive for Land Size here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Land Size here] end
				// % protected region % [Set readonly for Land Size here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Land Size here] end
				validators: [
					// % protected region % [Add other validators for Land Size here] off begin
					// % protected region % [Add other validators for Land Size here] end
				],
				// % protected region % [Add any additional model attribute properties for Land Size here] off begin
				// % protected region % [Add any additional model attribute properties for Land Size here] end
			},
			{
				name: 'buildingSize',
				// % protected region % [Set displayName for Building Size here] off begin
				displayName: 'Building Size',
				// % protected region % [Set displayName for Building Size here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Building Size here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Building Size here] end
				// % protected region % [Set isSensitive for Building Size here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Building Size here] end
				// % protected region % [Set readonly for Building Size here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Building Size here] end
				validators: [
					// % protected region % [Add other validators for Building Size here] off begin
					// % protected region % [Add other validators for Building Size here] end
				],
				// % protected region % [Add any additional model attribute properties for Building Size here] off begin
				// % protected region % [Add any additional model attribute properties for Building Size here] end
			},
			{
				name: 'permitNumber',
				// % protected region % [Set displayName for Permit Number here] off begin
				displayName: 'Permit Number',
				// % protected region % [Set displayName for Permit Number here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Permit Number here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Permit Number here] end
				// % protected region % [Set isSensitive for Permit Number here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Permit Number here] end
				// % protected region % [Set readonly for Permit Number here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Permit Number here] end
				validators: [
					// % protected region % [Add other validators for Permit Number here] off begin
					// % protected region % [Add other validators for Permit Number here] end
				],
				// % protected region % [Add any additional model attribute properties for Permit Number here] off begin
				// % protected region % [Add any additional model attribute properties for Permit Number here] end
			},
			{
				name: 'permitDate',
				// % protected region % [Set displayName for Permit Date here] off begin
				displayName: 'Permit Date',
				// % protected region % [Set displayName for Permit Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Permit Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Permit Date here] end
				// % protected region % [Set isSensitive for Permit Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Permit Date here] end
				// % protected region % [Set readonly for Permit Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Permit Date here] end
				validators: [
					// % protected region % [Add other validators for Permit Date here] off begin
					// % protected region % [Add other validators for Permit Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Permit Date here] off begin
				// % protected region % [Add any additional model attribute properties for Permit Date here] end
			},
			{
				name: 'authorizedBy',
				// % protected region % [Set displayName for Authorized By here] off begin
				displayName: 'Authorized By',
				// % protected region % [Set displayName for Authorized By here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Authorized By here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Authorized By here] end
				// % protected region % [Set isSensitive for Authorized By here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Authorized By here] end
				// % protected region % [Set readonly for Authorized By here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Authorized By here] end
				validators: [
					// % protected region % [Add other validators for Authorized By here] off begin
					// % protected region % [Add other validators for Authorized By here] end
				],
				// % protected region % [Add any additional model attribute properties for Authorized By here] off begin
				// % protected region % [Add any additional model attribute properties for Authorized By here] end
			},
			{
				name: 'permitType',
				// % protected region % [Set displayName for Permit Type here] off begin
				displayName: 'Permit Type',
				// % protected region % [Set displayName for Permit Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Permit Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Permit Type here] end
				// % protected region % [Set isSensitive for Permit Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Permit Type here] end
				// % protected region % [Set readonly for Permit Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Permit Type here] end
				validators: [
					// % protected region % [Add other validators for Permit Type here] off begin
					// % protected region % [Add other validators for Permit Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Permit Type here] off begin
				// % protected region % [Add any additional model attribute properties for Permit Type here] end
			},
			{
				name: 'validUntil',
				// % protected region % [Set displayName for Valid Until here] off begin
				displayName: 'Valid Until',
				// % protected region % [Set displayName for Valid Until here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Valid Until here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Valid Until here] end
				// % protected region % [Set isSensitive for Valid Until here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Valid Until here] end
				// % protected region % [Set readonly for Valid Until here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Valid Until here] end
				validators: [
					// % protected region % [Add other validators for Valid Until here] off begin
					// % protected region % [Add other validators for Valid Until here] end
				],
				// % protected region % [Add any additional model attribute properties for Valid Until here] off begin
				// % protected region % [Add any additional model attribute properties for Valid Until here] end
			},
			{
				name: 'hospitalBranchCorporationName',
				// % protected region % [Set displayName for Hospital Branch Corporation Name here] off begin
				displayName: 'Hospital Branch Corporation Name',
				// % protected region % [Set displayName for Hospital Branch Corporation Name here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Branch Corporation Name here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Branch Corporation Name here] end
				// % protected region % [Set isSensitive for Hospital Branch Corporation Name here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Branch Corporation Name here] end
				// % protected region % [Set readonly for Hospital Branch Corporation Name here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Branch Corporation Name here] end
				validators: [
					// % protected region % [Add other validators for Hospital Branch Corporation Name here] off begin
					// % protected region % [Add other validators for Hospital Branch Corporation Name here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Branch Corporation Name here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Branch Corporation Name here] end
			},
			{
				name: 'hospitalBranchCorporationStatus',
				// % protected region % [Set displayName for Hospital Branch Corporation Status here] off begin
				displayName: 'Hospital Branch Corporation Status',
				// % protected region % [Set displayName for Hospital Branch Corporation Status here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Hospital Branch Corporation Status here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Hospital Branch Corporation Status here] end
				// % protected region % [Set isSensitive for Hospital Branch Corporation Status here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Hospital Branch Corporation Status here] end
				// % protected region % [Set readonly for Hospital Branch Corporation Status here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Hospital Branch Corporation Status here] end
				validators: [
					// % protected region % [Add other validators for Hospital Branch Corporation Status here] off begin
					// % protected region % [Add other validators for Hospital Branch Corporation Status here] end
				],
				// % protected region % [Add any additional model attribute properties for Hospital Branch Corporation Status here] off begin
				// % protected region % [Add any additional model attribute properties for Hospital Branch Corporation Status here] end
			},
			{
				name: 'accreditationType',
				// % protected region % [Set displayName for Accreditation Type here] off begin
				displayName: 'Accreditation Type',
				// % protected region % [Set displayName for Accreditation Type here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Accreditation Type here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Accreditation Type here] end
				// % protected region % [Set isSensitive for Accreditation Type here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Accreditation Type here] end
				// % protected region % [Set readonly for Accreditation Type here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Accreditation Type here] end
				validators: [
					// % protected region % [Add other validators for Accreditation Type here] off begin
					// % protected region % [Add other validators for Accreditation Type here] end
				],
				// % protected region % [Add any additional model attribute properties for Accreditation Type here] off begin
				// % protected region % [Add any additional model attribute properties for Accreditation Type here] end
			},
			{
				name: 'accreditationLevel',
				// % protected region % [Set displayName for Accreditation Level here] off begin
				displayName: 'Accreditation Level',
				// % protected region % [Set displayName for Accreditation Level here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Accreditation Level here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Accreditation Level here] end
				// % protected region % [Set isSensitive for Accreditation Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Accreditation Level here] end
				// % protected region % [Set readonly for Accreditation Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Accreditation Level here] end
				validators: [
					// % protected region % [Add other validators for Accreditation Level here] off begin
					// % protected region % [Add other validators for Accreditation Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Accreditation Level here] off begin
				// % protected region % [Add any additional model attribute properties for Accreditation Level here] end
			},
			{
				name: 'accreditationDate',
				// % protected region % [Set displayName for Accreditation Date here] off begin
				displayName: 'Accreditation Date',
				// % protected region % [Set displayName for Accreditation Date here] end
				type: ModelPropertyType.DATE,
				// % protected region % [Set display element type for Accreditation Date here] off begin
				elementType: ElementType.DATE,
				// % protected region % [Set display element type for Accreditation Date here] end
				// % protected region % [Set isSensitive for Accreditation Date here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Accreditation Date here] end
				// % protected region % [Set readonly for Accreditation Date here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Accreditation Date here] end
				validators: [
					// % protected region % [Add other validators for Accreditation Date here] off begin
					// % protected region % [Add other validators for Accreditation Date here] end
				],
				// % protected region % [Add any additional model attribute properties for Accreditation Date here] off begin
				// % protected region % [Add any additional model attribute properties for Accreditation Date here] end
			},
			{
				name: 'bedPerinatology',
				// % protected region % [Set displayName for Bed Perinatology here] off begin
				displayName: 'Bed Perinatology',
				// % protected region % [Set displayName for Bed Perinatology here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Bed Perinatology here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Bed Perinatology here] end
				// % protected region % [Set isSensitive for Bed Perinatology here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Bed Perinatology here] end
				// % protected region % [Set readonly for Bed Perinatology here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Bed Perinatology here] end
				validators: [
					// % protected region % [Add other validators for Bed Perinatology here] off begin
					// % protected region % [Add other validators for Bed Perinatology here] end
				],
				// % protected region % [Add any additional model attribute properties for Bed Perinatology here] off begin
				// % protected region % [Add any additional model attribute properties for Bed Perinatology here] end
			},
			{
				name: 'suiteClass',
				// % protected region % [Set displayName for Suite Class here] off begin
				displayName: 'Suite Class',
				// % protected region % [Set displayName for Suite Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Suite Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Suite Class here] end
				// % protected region % [Set isSensitive for Suite Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Suite Class here] end
				// % protected region % [Set readonly for Suite Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Suite Class here] end
				validators: [
					// % protected region % [Add other validators for Suite Class here] off begin
					// % protected region % [Add other validators for Suite Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Suite Class here] off begin
				// % protected region % [Add any additional model attribute properties for Suite Class here] end
			},
			{
				name: 'vvipClass',
				// % protected region % [Set displayName for VVIP Class here] off begin
				displayName: 'VVIP Class',
				// % protected region % [Set displayName for VVIP Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for VVIP Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for VVIP Class here] end
				// % protected region % [Set isSensitive for VVIP Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for VVIP Class here] end
				// % protected region % [Set readonly for VVIP Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for VVIP Class here] end
				validators: [
					// % protected region % [Add other validators for VVIP Class here] off begin
					// % protected region % [Add other validators for VVIP Class here] end
				],
				// % protected region % [Add any additional model attribute properties for VVIP Class here] off begin
				// % protected region % [Add any additional model attribute properties for VVIP Class here] end
			},
			{
				name: 'vipAClass',
				// % protected region % [Set displayName for VIP A Class here] off begin
				displayName: 'VIP A Class',
				// % protected region % [Set displayName for VIP A Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for VIP A Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for VIP A Class here] end
				// % protected region % [Set isSensitive for VIP A Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for VIP A Class here] end
				// % protected region % [Set readonly for VIP A Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for VIP A Class here] end
				validators: [
					// % protected region % [Add other validators for VIP A Class here] off begin
					// % protected region % [Add other validators for VIP A Class here] end
				],
				// % protected region % [Add any additional model attribute properties for VIP A Class here] off begin
				// % protected region % [Add any additional model attribute properties for VIP A Class here] end
			},
			{
				name: 'vipBClass',
				// % protected region % [Set displayName for VIP B Class here] off begin
				displayName: 'VIP B Class',
				// % protected region % [Set displayName for VIP B Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for VIP B Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for VIP B Class here] end
				// % protected region % [Set isSensitive for VIP B Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for VIP B Class here] end
				// % protected region % [Set readonly for VIP B Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for VIP B Class here] end
				validators: [
					// % protected region % [Add other validators for VIP B Class here] off begin
					// % protected region % [Add other validators for VIP B Class here] end
				],
				// % protected region % [Add any additional model attribute properties for VIP B Class here] off begin
				// % protected region % [Add any additional model attribute properties for VIP B Class here] end
			},
			{
				name: 'vipCClass',
				// % protected region % [Set displayName for VIP C Class here] off begin
				displayName: 'VIP C Class',
				// % protected region % [Set displayName for VIP C Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for VIP C Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for VIP C Class here] end
				// % protected region % [Set isSensitive for VIP C Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for VIP C Class here] end
				// % protected region % [Set readonly for VIP C Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for VIP C Class here] end
				validators: [
					// % protected region % [Add other validators for VIP C Class here] off begin
					// % protected region % [Add other validators for VIP C Class here] end
				],
				// % protected region % [Add any additional model attribute properties for VIP C Class here] off begin
				// % protected region % [Add any additional model attribute properties for VIP C Class here] end
			},
			{
				name: 'mainClass',
				// % protected region % [Set displayName for Main Class here] off begin
				displayName: 'Main Class',
				// % protected region % [Set displayName for Main Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Main Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Main Class here] end
				// % protected region % [Set isSensitive for Main Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Main Class here] end
				// % protected region % [Set readonly for Main Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Main Class here] end
				validators: [
					// % protected region % [Add other validators for Main Class here] off begin
					// % protected region % [Add other validators for Main Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Main Class here] off begin
				// % protected region % [Add any additional model attribute properties for Main Class here] end
			},
			{
				name: 'classI',
				// % protected region % [Set displayName for Class I here] off begin
				displayName: 'Class I',
				// % protected region % [Set displayName for Class I here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Class I here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Class I here] end
				// % protected region % [Set isSensitive for Class I here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Class I here] end
				// % protected region % [Set readonly for Class I here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Class I here] end
				validators: [
					// % protected region % [Add other validators for Class I here] off begin
					// % protected region % [Add other validators for Class I here] end
				],
				// % protected region % [Add any additional model attribute properties for Class I here] off begin
				// % protected region % [Add any additional model attribute properties for Class I here] end
			},
			{
				name: 'iiClass',
				// % protected region % [Set displayName for II Class here] off begin
				displayName: 'II Class',
				// % protected region % [Set displayName for II Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for II Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for II Class here] end
				// % protected region % [Set isSensitive for II Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for II Class here] end
				// % protected region % [Set readonly for II Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for II Class here] end
				validators: [
					// % protected region % [Add other validators for II Class here] off begin
					// % protected region % [Add other validators for II Class here] end
				],
				// % protected region % [Add any additional model attribute properties for II Class here] off begin
				// % protected region % [Add any additional model attribute properties for II Class here] end
			},
			{
				name: 'iiiAClass',
				// % protected region % [Set displayName for III A Class here] off begin
				displayName: 'III A Class',
				// % protected region % [Set displayName for III A Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for III A Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for III A Class here] end
				// % protected region % [Set isSensitive for III A Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for III A Class here] end
				// % protected region % [Set readonly for III A Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for III A Class here] end
				validators: [
					// % protected region % [Add other validators for III A Class here] off begin
					// % protected region % [Add other validators for III A Class here] end
				],
				// % protected region % [Add any additional model attribute properties for III A Class here] off begin
				// % protected region % [Add any additional model attribute properties for III A Class here] end
			},
			{
				name: 'iiiBClass',
				// % protected region % [Set displayName for III B Class here] off begin
				displayName: 'III B Class',
				// % protected region % [Set displayName for III B Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for III B Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for III B Class here] end
				// % protected region % [Set isSensitive for III B Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for III B Class here] end
				// % protected region % [Set readonly for III B Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for III B Class here] end
				validators: [
					// % protected region % [Add other validators for III B Class here] off begin
					// % protected region % [Add other validators for III B Class here] end
				],
				// % protected region % [Add any additional model attribute properties for III B Class here] off begin
				// % protected region % [Add any additional model attribute properties for III B Class here] end
			},
			{
				name: 'specialClass',
				// % protected region % [Set displayName for Special Class here] off begin
				displayName: 'Special Class',
				// % protected region % [Set displayName for Special Class here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Special Class here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Special Class here] end
				// % protected region % [Set isSensitive for Special Class here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Special Class here] end
				// % protected region % [Set readonly for Special Class here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Special Class here] end
				validators: [
					// % protected region % [Add other validators for Special Class here] off begin
					// % protected region % [Add other validators for Special Class here] end
				],
				// % protected region % [Add any additional model attribute properties for Special Class here] off begin
				// % protected region % [Add any additional model attribute properties for Special Class here] end
			},
			{
				name: 'icu',
				// % protected region % [Set displayName for ICU here] off begin
				displayName: 'ICU',
				// % protected region % [Set displayName for ICU here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ICU here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ICU here] end
				// % protected region % [Set isSensitive for ICU here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ICU here] end
				// % protected region % [Set readonly for ICU here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ICU here] end
				validators: [
					// % protected region % [Add other validators for ICU here] off begin
					// % protected region % [Add other validators for ICU here] end
				],
				// % protected region % [Add any additional model attribute properties for ICU here] off begin
				// % protected region % [Add any additional model attribute properties for ICU here] end
			},
			{
				name: 'picu',
				// % protected region % [Set displayName for PICU here] off begin
				displayName: 'PICU',
				// % protected region % [Set displayName for PICU here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for PICU here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for PICU here] end
				// % protected region % [Set isSensitive for PICU here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for PICU here] end
				// % protected region % [Set readonly for PICU here] off begin
				readOnly: false,
				// % protected region % [Set readonly for PICU here] end
				validators: [
					// % protected region % [Add other validators for PICU here] off begin
					// % protected region % [Add other validators for PICU here] end
				],
				// % protected region % [Add any additional model attribute properties for PICU here] off begin
				// % protected region % [Add any additional model attribute properties for PICU here] end
			},
			{
				name: 'nicu',
				// % protected region % [Set displayName for NICU here] off begin
				displayName: 'NICU',
				// % protected region % [Set displayName for NICU here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for NICU here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for NICU here] end
				// % protected region % [Set isSensitive for NICU here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for NICU here] end
				// % protected region % [Set readonly for NICU here] off begin
				readOnly: false,
				// % protected region % [Set readonly for NICU here] end
				validators: [
					// % protected region % [Add other validators for NICU here] off begin
					// % protected region % [Add other validators for NICU here] end
				],
				// % protected region % [Add any additional model attribute properties for NICU here] off begin
				// % protected region % [Add any additional model attribute properties for NICU here] end
			},
			{
				name: 'hcu',
				// % protected region % [Set displayName for HCU here] off begin
				displayName: 'HCU',
				// % protected region % [Set displayName for HCU here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for HCU here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for HCU here] end
				// % protected region % [Set isSensitive for HCU here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for HCU here] end
				// % protected region % [Set readonly for HCU here] off begin
				readOnly: false,
				// % protected region % [Set readonly for HCU here] end
				validators: [
					// % protected region % [Add other validators for HCU here] off begin
					// % protected region % [Add other validators for HCU here] end
				],
				// % protected region % [Add any additional model attribute properties for HCU here] off begin
				// % protected region % [Add any additional model attribute properties for HCU here] end
			},
			{
				name: 'iccu',
				// % protected region % [Set displayName for ICCU here] off begin
				displayName: 'ICCU',
				// % protected region % [Set displayName for ICCU here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for ICCU here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for ICCU here] end
				// % protected region % [Set isSensitive for ICCU here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for ICCU here] end
				// % protected region % [Set readonly for ICCU here] off begin
				readOnly: false,
				// % protected region % [Set readonly for ICCU here] end
				validators: [
					// % protected region % [Add other validators for ICCU here] off begin
					// % protected region % [Add other validators for ICCU here] end
				],
				// % protected region % [Add any additional model attribute properties for ICCU here] off begin
				// % protected region % [Add any additional model attribute properties for ICCU here] end
			},
			{
				name: 'isolationRoom',
				// % protected region % [Set displayName for Isolation Room here] off begin
				displayName: 'Isolation Room',
				// % protected region % [Set displayName for Isolation Room here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Isolation Room here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Isolation Room here] end
				// % protected region % [Set isSensitive for Isolation Room here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Isolation Room here] end
				// % protected region % [Set readonly for Isolation Room here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Isolation Room here] end
				validators: [
					// % protected region % [Add other validators for Isolation Room here] off begin
					// % protected region % [Add other validators for Isolation Room here] end
				],
				// % protected region % [Add any additional model attribute properties for Isolation Room here] off begin
				// % protected region % [Add any additional model attribute properties for Isolation Room here] end
			},
			{
				name: 'emergencyRoom',
				// % protected region % [Set displayName for Emergency Room here] off begin
				displayName: 'Emergency Room',
				// % protected region % [Set displayName for Emergency Room here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Emergency Room here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Emergency Room here] end
				// % protected region % [Set isSensitive for Emergency Room here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Emergency Room here] end
				// % protected region % [Set readonly for Emergency Room here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Emergency Room here] end
				validators: [
					// % protected region % [Add other validators for Emergency Room here] off begin
					// % protected region % [Add other validators for Emergency Room here] end
				],
				// % protected region % [Add any additional model attribute properties for Emergency Room here] off begin
				// % protected region % [Add any additional model attribute properties for Emergency Room here] end
			},
			{
				name: 'maternityRoom',
				// % protected region % [Set displayName for Maternity Room here] off begin
				displayName: 'Maternity Room',
				// % protected region % [Set displayName for Maternity Room here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Maternity Room here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Maternity Room here] end
				// % protected region % [Set isSensitive for Maternity Room here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Maternity Room here] end
				// % protected region % [Set readonly for Maternity Room here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Maternity Room here] end
				validators: [
					// % protected region % [Add other validators for Maternity Room here] off begin
					// % protected region % [Add other validators for Maternity Room here] end
				],
				// % protected region % [Add any additional model attribute properties for Maternity Room here] off begin
				// % protected region % [Add any additional model attribute properties for Maternity Room here] end
			},
			{
				name: 'operatingRoom',
				// % protected region % [Set displayName for Operating Room here] off begin
				displayName: 'Operating Room',
				// % protected region % [Set displayName for Operating Room here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Operating Room here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Operating Room here] end
				// % protected region % [Set isSensitive for Operating Room here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Operating Room here] end
				// % protected region % [Set readonly for Operating Room here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Operating Room here] end
				validators: [
					// % protected region % [Add other validators for Operating Room here] off begin
					// % protected region % [Add other validators for Operating Room here] end
				],
				// % protected region % [Add any additional model attribute properties for Operating Room here] off begin
				// % protected region % [Add any additional model attribute properties for Operating Room here] end
			},
			{
				name: 'doctorSpA',
				// % protected region % [Set displayName for Doctor SpA here] off begin
				displayName: 'Doctor SpA',
				// % protected region % [Set displayName for Doctor SpA here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpA here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpA here] end
				// % protected region % [Set isSensitive for Doctor SpA here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpA here] end
				// % protected region % [Set readonly for Doctor SpA here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpA here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpA here] off begin
					// % protected region % [Add other validators for Doctor SpA here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpA here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpA here] end
			},
			{
				name: 'doctorSpOG',
				// % protected region % [Set displayName for Doctor SpOG here] off begin
				displayName: 'Doctor SpOG',
				// % protected region % [Set displayName for Doctor SpOG here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpOG here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpOG here] end
				// % protected region % [Set isSensitive for Doctor SpOG here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpOG here] end
				// % protected region % [Set readonly for Doctor SpOG here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpOG here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpOG here] off begin
					// % protected region % [Add other validators for Doctor SpOG here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpOG here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpOG here] end
			},
			{
				name: 'doctorSpPD',
				// % protected region % [Set displayName for Doctor SpPD here] off begin
				displayName: 'Doctor SpPD',
				// % protected region % [Set displayName for Doctor SpPD here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpPD here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpPD here] end
				// % protected region % [Set isSensitive for Doctor SpPD here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpPD here] end
				// % protected region % [Set readonly for Doctor SpPD here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpPD here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpPD here] off begin
					// % protected region % [Add other validators for Doctor SpPD here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpPD here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpPD here] end
			},
			{
				name: 'doctorSpB',
				// % protected region % [Set displayName for Doctor SpB here] off begin
				displayName: 'Doctor SpB',
				// % protected region % [Set displayName for Doctor SpB here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpB here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpB here] end
				// % protected region % [Set isSensitive for Doctor SpB here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpB here] end
				// % protected region % [Set readonly for Doctor SpB here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpB here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpB here] off begin
					// % protected region % [Add other validators for Doctor SpB here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpB here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpB here] end
			},
			{
				name: 'doctorSpRad',
				// % protected region % [Set displayName for Doctor SpRad here] off begin
				displayName: 'Doctor SpRad',
				// % protected region % [Set displayName for Doctor SpRad here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpRad here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpRad here] end
				// % protected region % [Set isSensitive for Doctor SpRad here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpRad here] end
				// % protected region % [Set readonly for Doctor SpRad here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpRad here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpRad here] off begin
					// % protected region % [Add other validators for Doctor SpRad here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpRad here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpRad here] end
			},
			{
				name: 'doctorSpRm',
				// % protected region % [Set displayName for Doctor SpRm here] off begin
				displayName: 'Doctor SpRm',
				// % protected region % [Set displayName for Doctor SpRm here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpRm here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpRm here] end
				// % protected region % [Set isSensitive for Doctor SpRm here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpRm here] end
				// % protected region % [Set readonly for Doctor SpRm here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpRm here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpRm here] off begin
					// % protected region % [Add other validators for Doctor SpRm here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpRm here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpRm here] end
			},
			{
				name: 'doctorSpAn',
				// % protected region % [Set displayName for Doctor SpAn here] off begin
				displayName: 'Doctor SpAn',
				// % protected region % [Set displayName for Doctor SpAn here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpAn here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpAn here] end
				// % protected region % [Set isSensitive for Doctor SpAn here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpAn here] end
				// % protected region % [Set readonly for Doctor SpAn here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpAn here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpAn here] off begin
					// % protected region % [Add other validators for Doctor SpAn here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpAn here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpAn here] end
			},
			{
				name: 'doctorSpJp',
				// % protected region % [Set displayName for Doctor SpJp here] off begin
				displayName: 'Doctor SpJp',
				// % protected region % [Set displayName for Doctor SpJp here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpJp here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpJp here] end
				// % protected region % [Set isSensitive for Doctor SpJp here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpJp here] end
				// % protected region % [Set readonly for Doctor SpJp here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpJp here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpJp here] off begin
					// % protected region % [Add other validators for Doctor SpJp here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpJp here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpJp here] end
			},
			{
				name: 'doctorSpM',
				// % protected region % [Set displayName for Doctor SpM here] off begin
				displayName: 'Doctor SpM',
				// % protected region % [Set displayName for Doctor SpM here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpM here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpM here] end
				// % protected region % [Set isSensitive for Doctor SpM here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpM here] end
				// % protected region % [Set readonly for Doctor SpM here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpM here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpM here] off begin
					// % protected region % [Add other validators for Doctor SpM here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpM here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpM here] end
			},
			{
				name: 'doctorSpTHT',
				// % protected region % [Set displayName for Doctor SpTHT here] off begin
				displayName: 'Doctor SpTHT',
				// % protected region % [Set displayName for Doctor SpTHT here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpTHT here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpTHT here] end
				// % protected region % [Set isSensitive for Doctor SpTHT here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpTHT here] end
				// % protected region % [Set readonly for Doctor SpTHT here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpTHT here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpTHT here] off begin
					// % protected region % [Add other validators for Doctor SpTHT here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpTHT here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpTHT here] end
			},
			{
				name: 'doctorSpKj',
				// % protected region % [Set displayName for Doctor SpKj here] off begin
				displayName: 'Doctor SpKj',
				// % protected region % [Set displayName for Doctor SpKj here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpKj here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpKj here] end
				// % protected region % [Set isSensitive for Doctor SpKj here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpKj here] end
				// % protected region % [Set readonly for Doctor SpKj here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpKj here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpKj here] off begin
					// % protected region % [Add other validators for Doctor SpKj here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpKj here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpKj here] end
			},
			{
				name: 'doctorSpP',
				// % protected region % [Set displayName for Doctor SpP here] off begin
				displayName: 'Doctor SpP',
				// % protected region % [Set displayName for Doctor SpP here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpP here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpP here] end
				// % protected region % [Set isSensitive for Doctor SpP here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpP here] end
				// % protected region % [Set readonly for Doctor SpP here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpP here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpP here] off begin
					// % protected region % [Add other validators for Doctor SpP here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpP here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpP here] end
			},
			{
				name: 'doctorSpPK',
				// % protected region % [Set displayName for Doctor SpPK here] off begin
				displayName: 'Doctor SpPK',
				// % protected region % [Set displayName for Doctor SpPK here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpPK here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpPK here] end
				// % protected region % [Set isSensitive for Doctor SpPK here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpPK here] end
				// % protected region % [Set readonly for Doctor SpPK here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpPK here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpPK here] off begin
					// % protected region % [Add other validators for Doctor SpPK here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpPK here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpPK here] end
			},
			{
				name: 'doctorSpS',
				// % protected region % [Set displayName for Doctor SpS here] off begin
				displayName: 'Doctor SpS',
				// % protected region % [Set displayName for Doctor SpS here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Doctor SpS here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Doctor SpS here] end
				// % protected region % [Set isSensitive for Doctor SpS here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Doctor SpS here] end
				// % protected region % [Set readonly for Doctor SpS here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Doctor SpS here] end
				validators: [
					// % protected region % [Add other validators for Doctor SpS here] off begin
					// % protected region % [Add other validators for Doctor SpS here] end
				],
				// % protected region % [Add any additional model attribute properties for Doctor SpS here] off begin
				// % protected region % [Add any additional model attribute properties for Doctor SpS here] end
			},
			{
				name: 'subSpecialistDoctor',
				// % protected region % [Set displayName for Sub Specialist Doctor here] off begin
				displayName: 'Sub Specialist Doctor',
				// % protected region % [Set displayName for Sub Specialist Doctor here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Sub Specialist Doctor here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Sub Specialist Doctor here] end
				// % protected region % [Set isSensitive for Sub Specialist Doctor here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Sub Specialist Doctor here] end
				// % protected region % [Set readonly for Sub Specialist Doctor here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Sub Specialist Doctor here] end
				validators: [
					// % protected region % [Add other validators for Sub Specialist Doctor here] off begin
					// % protected region % [Add other validators for Sub Specialist Doctor here] end
				],
				// % protected region % [Add any additional model attribute properties for Sub Specialist Doctor here] off begin
				// % protected region % [Add any additional model attribute properties for Sub Specialist Doctor here] end
			},
			{
				name: 'otherSpecialistDoctor',
				// % protected region % [Set displayName for Other Specialist Doctor here] off begin
				displayName: 'Other Specialist Doctor',
				// % protected region % [Set displayName for Other Specialist Doctor here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Other Specialist Doctor here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Other Specialist Doctor here] end
				// % protected region % [Set isSensitive for Other Specialist Doctor here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Specialist Doctor here] end
				// % protected region % [Set readonly for Other Specialist Doctor here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Specialist Doctor here] end
				validators: [
					// % protected region % [Add other validators for Other Specialist Doctor here] off begin
					// % protected region % [Add other validators for Other Specialist Doctor here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Specialist Doctor here] off begin
				// % protected region % [Add any additional model attribute properties for Other Specialist Doctor here] end
			},
			{
				name: 'generalPractice',
				// % protected region % [Set displayName for General Practice here] off begin
				displayName: 'General Practice',
				// % protected region % [Set displayName for General Practice here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for General Practice here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for General Practice here] end
				// % protected region % [Set isSensitive for General Practice here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for General Practice here] end
				// % protected region % [Set readonly for General Practice here] off begin
				readOnly: false,
				// % protected region % [Set readonly for General Practice here] end
				validators: [
					// % protected region % [Add other validators for General Practice here] off begin
					// % protected region % [Add other validators for General Practice here] end
				],
				// % protected region % [Add any additional model attribute properties for General Practice here] off begin
				// % protected region % [Add any additional model attribute properties for General Practice here] end
			},
			{
				name: 'dentist',
				// % protected region % [Set displayName for Dentist here] off begin
				displayName: 'Dentist',
				// % protected region % [Set displayName for Dentist here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Dentist here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Dentist here] end
				// % protected region % [Set isSensitive for Dentist here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Dentist here] end
				// % protected region % [Set readonly for Dentist here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Dentist here] end
				validators: [
					// % protected region % [Add other validators for Dentist here] off begin
					// % protected region % [Add other validators for Dentist here] end
				],
				// % protected region % [Add any additional model attribute properties for Dentist here] off begin
				// % protected region % [Add any additional model attribute properties for Dentist here] end
			},
			{
				name: 'specialistDentist',
				// % protected region % [Set displayName for Specialist Dentist here] off begin
				displayName: 'Specialist Dentist',
				// % protected region % [Set displayName for Specialist Dentist here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Specialist Dentist here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Specialist Dentist here] end
				// % protected region % [Set isSensitive for Specialist Dentist here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Specialist Dentist here] end
				// % protected region % [Set readonly for Specialist Dentist here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Specialist Dentist here] end
				validators: [
					// % protected region % [Add other validators for Specialist Dentist here] off begin
					// % protected region % [Add other validators for Specialist Dentist here] end
				],
				// % protected region % [Add any additional model attribute properties for Specialist Dentist here] off begin
				// % protected region % [Add any additional model attribute properties for Specialist Dentist here] end
			},
			{
				name: 'nurse',
				// % protected region % [Set displayName for Nurse here] off begin
				displayName: 'Nurse',
				// % protected region % [Set displayName for Nurse here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Nurse here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Nurse here] end
				// % protected region % [Set isSensitive for Nurse here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Nurse here] end
				// % protected region % [Set readonly for Nurse here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Nurse here] end
				validators: [
					// % protected region % [Add other validators for Nurse here] off begin
					// % protected region % [Add other validators for Nurse here] end
				],
				// % protected region % [Add any additional model attribute properties for Nurse here] off begin
				// % protected region % [Add any additional model attribute properties for Nurse here] end
			},
			{
				name: 'midwife',
				// % protected region % [Set displayName for Midwife here] off begin
				displayName: 'Midwife',
				// % protected region % [Set displayName for Midwife here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Midwife here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Midwife here] end
				// % protected region % [Set isSensitive for Midwife here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Midwife here] end
				// % protected region % [Set readonly for Midwife here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Midwife here] end
				validators: [
					// % protected region % [Add other validators for Midwife here] off begin
					// % protected region % [Add other validators for Midwife here] end
				],
				// % protected region % [Add any additional model attribute properties for Midwife here] off begin
				// % protected region % [Add any additional model attribute properties for Midwife here] end
			},
			{
				name: 'pharmacist',
				// % protected region % [Set displayName for Pharmacist here] off begin
				displayName: 'Pharmacist',
				// % protected region % [Set displayName for Pharmacist here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Pharmacist here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Pharmacist here] end
				// % protected region % [Set isSensitive for Pharmacist here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Pharmacist here] end
				// % protected region % [Set readonly for Pharmacist here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Pharmacist here] end
				validators: [
					// % protected region % [Add other validators for Pharmacist here] off begin
					// % protected region % [Add other validators for Pharmacist here] end
				],
				// % protected region % [Add any additional model attribute properties for Pharmacist here] off begin
				// % protected region % [Add any additional model attribute properties for Pharmacist here] end
			},
			{
				name: 'otherMedicalStaff',
				// % protected region % [Set displayName for Other Medical Staff here] off begin
				displayName: 'Other Medical Staff',
				// % protected region % [Set displayName for Other Medical Staff here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Other Medical Staff here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Other Medical Staff here] end
				// % protected region % [Set isSensitive for Other Medical Staff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Other Medical Staff here] end
				// % protected region % [Set readonly for Other Medical Staff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Other Medical Staff here] end
				validators: [
					// % protected region % [Add other validators for Other Medical Staff here] off begin
					// % protected region % [Add other validators for Other Medical Staff here] end
				],
				// % protected region % [Add any additional model attribute properties for Other Medical Staff here] off begin
				// % protected region % [Add any additional model attribute properties for Other Medical Staff here] end
			},
			{
				name: 'nonMedicalStaff',
				// % protected region % [Set displayName for Non Medical Staff here] off begin
				displayName: 'Non Medical Staff',
				// % protected region % [Set displayName for Non Medical Staff here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Non Medical Staff here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Non Medical Staff here] end
				// % protected region % [Set isSensitive for Non Medical Staff here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Non Medical Staff here] end
				// % protected region % [Set readonly for Non Medical Staff here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Non Medical Staff here] end
				validators: [
					// % protected region % [Add other validators for Non Medical Staff here] off begin
					// % protected region % [Add other validators for Non Medical Staff here] end
				],
				// % protected region % [Add any additional model attribute properties for Non Medical Staff here] off begin
				// % protected region % [Add any additional model attribute properties for Non Medical Staff here] end
			},
			{
				name: 'leftLogo',
				// % protected region % [Set displayName for Left Logo here] off begin
				displayName: 'Left Logo',
				// % protected region % [Set displayName for Left Logo here] end
				type: ModelPropertyType.FILE,
				// % protected region % [Set display element type for Left Logo here] off begin
				elementType: ElementType.FILE,
				// % protected region % [Set display element type for Left Logo here] end
				// % protected region % [Set isSensitive for Left Logo here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Left Logo here] end
				// % protected region % [Set readonly for Left Logo here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Left Logo here] end
				validators: [
					// % protected region % [Add other validators for Left Logo here] off begin
					// % protected region % [Add other validators for Left Logo here] end
				],
				// % protected region % [Add any additional model attribute properties for Left Logo here] off begin
				// % protected region % [Add any additional model attribute properties for Left Logo here] end
			},
			{
				name: 'rightLogo',
				// % protected region % [Set displayName for Right Logo here] off begin
				displayName: 'Right Logo',
				// % protected region % [Set displayName for Right Logo here] end
				type: ModelPropertyType.FILE,
				// % protected region % [Set display element type for Right Logo here] off begin
				elementType: ElementType.FILE,
				// % protected region % [Set display element type for Right Logo here] end
				// % protected region % [Set isSensitive for Right Logo here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Right Logo here] end
				// % protected region % [Set readonly for Right Logo here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Right Logo here] end
				validators: [
					// % protected region % [Add other validators for Right Logo here] off begin
					// % protected region % [Add other validators for Right Logo here] end
				],
				// % protected region % [Add any additional model attribute properties for Right Logo here] off begin
				// % protected region % [Add any additional model attribute properties for Right Logo here] end
			},
			{
				name: 'timezone',
				// % protected region % [Set displayName for Timezone here] off begin
				displayName: 'Timezone',
				// % protected region % [Set displayName for Timezone here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Timezone here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Timezone here] end
				// % protected region % [Set isSensitive for Timezone here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Timezone here] end
				// % protected region % [Set readonly for Timezone here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Timezone here] end
				validators: [
					// % protected region % [Add other validators for Timezone here] off begin
					// % protected region % [Add other validators for Timezone here] end
				],
				// % protected region % [Add any additional model attribute properties for Timezone here] off begin
				// % protected region % [Add any additional model attribute properties for Timezone here] end
			},
			{
				name: 'healthFacilityLevel',
				// % protected region % [Set displayName for Health Facility Level here] off begin
				displayName: 'Health Facility Level',
				// % protected region % [Set displayName for Health Facility Level here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Health Facility Level here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Health Facility Level here] end
				// % protected region % [Set isSensitive for Health Facility Level here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Health Facility Level here] end
				// % protected region % [Set readonly for Health Facility Level here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Health Facility Level here] end
				validators: [
					// % protected region % [Add other validators for Health Facility Level here] off begin
					// % protected region % [Add other validators for Health Facility Level here] end
				],
				// % protected region % [Add any additional model attribute properties for Health Facility Level here] off begin
				// % protected region % [Add any additional model attribute properties for Health Facility Level here] end
			},
			{
				name: 'satuSehatIntegration',
				// % protected region % [Set displayName for Satu Sehat Integration here] off begin
				displayName: 'Satu Sehat Integration',
				// % protected region % [Set displayName for Satu Sehat Integration here] end
				type: ModelPropertyType.BOOLEAN,
				// % protected region % [Set display element type for Satu Sehat Integration here] off begin
				elementType: ElementType.CHECKBOX,
				// % protected region % [Set display element type for Satu Sehat Integration here] end
				// % protected region % [Set isSensitive for Satu Sehat Integration here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Satu Sehat Integration here] end
				// % protected region % [Set readonly for Satu Sehat Integration here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Satu Sehat Integration here] end
				validators: [
					// % protected region % [Add other validators for Satu Sehat Integration here] off begin
					// % protected region % [Add other validators for Satu Sehat Integration here] end
				],
				// % protected region % [Add any additional model attribute properties for Satu Sehat Integration here] off begin
				// % protected region % [Add any additional model attribute properties for Satu Sehat Integration here] end
			},
			{
				name: 'taxIdentification',
				// % protected region % [Set displayName for Tax Identification here] off begin
				displayName: 'Tax Identification',
				// % protected region % [Set displayName for Tax Identification here] end
				type: ModelPropertyType.STRING,
				// % protected region % [Set display element type for Tax Identification here] off begin
				elementType: ElementType.INPUT,
				// % protected region % [Set display element type for Tax Identification here] end
				// % protected region % [Set isSensitive for Tax Identification here] off begin
				isSensitive: false,
				// % protected region % [Set isSensitive for Tax Identification here] end
				// % protected region % [Set readonly for Tax Identification here] off begin
				readOnly: false,
				// % protected region % [Set readonly for Tax Identification here] end
				validators: [
					// % protected region % [Add other validators for Tax Identification here] off begin
					// % protected region % [Add other validators for Tax Identification here] end
				],
				// % protected region % [Add any additional model attribute properties for Tax Identification here] off begin
				// % protected region % [Add any additional model attribute properties for Tax Identification here] end
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
			{
				id: 'hospitalGroup',
				type: ModelRelationType.ONE,
				name: 'hospitalGroupId',
				// % protected region % [Customise your label for Hospital Group here] off begin
				label: 'Hospital Group',
				// % protected region % [Customise your label for Hospital Group here] end
				entityName: 'HospitalGroupInformationModel',
				// % protected region % [Customise your display name for Hospital Group here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'hospitalGroupCode',
				// % protected region % [Customise your display name for Hospital Group here] end
				validators: [
					// % protected region % [Add other validators for Hospital Group here] off begin
					// % protected region % [Add other validators for Hospital Group here] end
				],
				// % protected region % [Add any additional field for relation Hospital Group here] off begin
				// % protected region % [Add any additional field for relation Hospital Group here] end
			},
			{
				id: 'staff',
				type: ModelRelationType.ONE,
				name: 'staffId',
				// % protected region % [Customise your label for Staff here] off begin
				label: 'Staff',
				// % protected region % [Customise your label for Staff here] end
				entityName: 'StaffModel',
				// % protected region % [Customise your display name for Staff here] off begin
				// TODO change implementation to use OrderBy or create new metamodel property DisplayBy
				displayName: 'staffNumber',
				// % protected region % [Customise your display name for Staff here] end
				validators: [
					// % protected region % [Add other validators for Staff here] off begin
					// % protected region % [Add other validators for Staff here] end
				],
				// % protected region % [Add any additional field for relation Staff here] off begin
				// % protected region % [Add any additional field for relation Staff here] end
			},
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
				case 'hospitalCode':
					break;
				case 'hospitalName':
					break;
				case 'hospitalType':
					break;
				case 'isBPJSFacility':
					break;
				case 'taxIdentification':
					break;
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
	static deepParse(data: string | { [K in keyof HospitalBranchInformationModel]?: HospitalBranchInformationModel[K] }, currentModel?): AbstractModel[] {
		if (currentModel == null) {
			currentModel = new HospitalBranchInformationModel(data);
		}

		let returned: AbstractModel[] = [currentModel];
		const json = typeof data === 'string' ? JSON.parse(data) : data;

		// Incoming one to many
		if (json.hospitalGroup) {
			currentModel.hospitalGroupId = json.hospitalGroup.id;
			returned = _.union(returned, HospitalGroupInformationModel.deepParse(json.hospitalGroup));
		}

		// Incoming one to many
		if (json.staff) {
			currentModel.staffId = json.staff.id;
			returned = _.union(returned, StaffModel.deepParse(json.staff));
		}


		// % protected region % [Customise your deep parse before return here] off begin
		// % protected region % [Customise your deep parse before return here] end

		return returned;
	}

	/**
	 * @example
	 *
	 * `let hospitalBranchInformationModel = new HospitalBranchInformationModel(data);`
	 *
	 * @param data The input data to be initialised as the HospitalBranchInformationModel,
	 *    it is expected as a JSON string or as a nullable HospitalBranchInformationModel.
	 */
	constructor(data?: string | Partial<HospitalBranchInformationModel>) {
		super(data);

		if (data) {
			const json = typeof data === 'string'
				? JSON.parse(data) as Partial<HospitalBranchInformationModel>
				: data;

			this.hospitalCode = json.hospitalCode;
			this.hospitalName = json.hospitalName;
			this.hospitalType = json.hospitalType;
			this.hospitalClass = json.hospitalClass;
			this.hospitalDirectorName = json.hospitalDirectorName;
			if (json.dateOfRegistration) {
				this.dateOfRegistration = new Date(json.dateOfRegistration);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.dateOfRegistration = json.dateOfRegistration;
			}
			this.hospitalCorporationName = json.hospitalCorporationName;
			this.isBPJSFacility = json.isBPJSFacility;
			this.address = json.address;
			this.city = json.city;
			this.postcode = json.postcode;
			this.phoneNumber = json.phoneNumber;
			this.fax = json.fax;
			this.email = json.email;
			this.website = json.website;
			this.contactPerson = json.contactPerson;
			this.contactPersonPhoneNumber = json.contactPersonPhoneNumber;
			this.contactPersonEmail = json.contactPersonEmail;
			this.landSize = json.landSize;
			this.buildingSize = json.buildingSize;
			this.permitNumber = json.permitNumber;
			if (json.permitDate) {
				this.permitDate = new Date(json.permitDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.permitDate = json.permitDate;
			}
			this.authorizedBy = json.authorizedBy;
			this.permitType = json.permitType;
			if (json.validUntil) {
				this.validUntil = new Date(json.validUntil);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.validUntil = json.validUntil;
			}
			this.hospitalBranchCorporationName = json.hospitalBranchCorporationName;
			this.hospitalBranchCorporationStatus = json.hospitalBranchCorporationStatus;
			this.accreditationType = json.accreditationType;
			this.accreditationLevel = json.accreditationLevel;
			if (json.accreditationDate) {
				this.accreditationDate = new Date(json.accreditationDate);
			} else {
				// If no value is present, it can both be partial model or empty value. Regardless simply reassigned it
				// with the original empty value (null) or lack thereof (undefined).
				this.accreditationDate = json.accreditationDate;
			}
			this.bedPerinatology = json.bedPerinatology;
			this.suiteClass = json.suiteClass;
			this.vvipClass = json.vvipClass;
			this.vipAClass = json.vipAClass;
			this.vipBClass = json.vipBClass;
			this.vipCClass = json.vipCClass;
			this.mainClass = json.mainClass;
			this.classI = json.classI;
			this.iiClass = json.iiClass;
			this.iiiAClass = json.iiiAClass;
			this.iiiBClass = json.iiiBClass;
			this.specialClass = json.specialClass;
			this.icu = json.icu;
			this.picu = json.picu;
			this.nicu = json.nicu;
			this.hcu = json.hcu;
			this.iccu = json.iccu;
			this.isolationRoom = json.isolationRoom;
			this.emergencyRoom = json.emergencyRoom;
			this.maternityRoom = json.maternityRoom;
			this.operatingRoom = json.operatingRoom;
			this.doctorSpA = json.doctorSpA;
			this.doctorSpOG = json.doctorSpOG;
			this.doctorSpPD = json.doctorSpPD;
			this.doctorSpB = json.doctorSpB;
			this.doctorSpRad = json.doctorSpRad;
			this.doctorSpRm = json.doctorSpRm;
			this.doctorSpAn = json.doctorSpAn;
			this.doctorSpJp = json.doctorSpJp;
			this.doctorSpM = json.doctorSpM;
			this.doctorSpTHT = json.doctorSpTHT;
			this.doctorSpKj = json.doctorSpKj;
			this.doctorSpP = json.doctorSpP;
			this.doctorSpPK = json.doctorSpPK;
			this.doctorSpS = json.doctorSpS;
			this.subSpecialistDoctor = json.subSpecialistDoctor;
			this.otherSpecialistDoctor = json.otherSpecialistDoctor;
			this.generalPractice = json.generalPractice;
			this.dentist = json.dentist;
			this.specialistDentist = json.specialistDentist;
			this.nurse = json.nurse;
			this.midwife = json.midwife;
			this.pharmacist = json.pharmacist;
			this.otherMedicalStaff = json.otherMedicalStaff;
			this.nonMedicalStaff = json.nonMedicalStaff;
			this.leftLogo = json.leftLogo?.map(item => new FileModel(item));
			this.rightLogo = json.rightLogo?.map(item => new FileModel(item));
			this.timezone = json.timezone;
			this.healthFacilityLevel = json.healthFacilityLevel;
			this.satuSehatIntegration = json.satuSehatIntegration;
			this.taxIdentification = json.taxIdentification;
			this.hospitalGroupId = json.hospitalGroupId;
			this.hospitalGroup = json.hospitalGroup;
			this.staffId = json.staffId;
			this.staff = json.staff;
			// % protected region % [Add any additional logic here after set the data] off begin
			// % protected region % [Add any additional logic here after set the data] end
		}

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	toJSON() {
		return {
			...super.toJSON(),
			hospitalCode: this.hospitalCode,
			hospitalName: this.hospitalName,
			hospitalType: this.hospitalType,
			hospitalClass: this.hospitalClass,
			hospitalDirectorName: this.hospitalDirectorName,
			dateOfRegistration: this.dateOfRegistration,
			hospitalCorporationName: this.hospitalCorporationName,
			isBPJSFacility: this.isBPJSFacility,
			address: this.address,
			city: this.city,
			postcode: this.postcode,
			phoneNumber: this.phoneNumber,
			fax: this.fax,
			email: this.email,
			website: this.website,
			contactPerson: this.contactPerson,
			contactPersonPhoneNumber: this.contactPersonPhoneNumber,
			contactPersonEmail: this.contactPersonEmail,
			landSize: this.landSize,
			buildingSize: this.buildingSize,
			permitNumber: this.permitNumber,
			permitDate: this.permitDate,
			authorizedBy: this.authorizedBy,
			permitType: this.permitType,
			validUntil: this.validUntil,
			hospitalBranchCorporationName: this.hospitalBranchCorporationName,
			hospitalBranchCorporationStatus: this.hospitalBranchCorporationStatus,
			accreditationType: this.accreditationType,
			accreditationLevel: this.accreditationLevel,
			accreditationDate: this.accreditationDate,
			bedPerinatology: this.bedPerinatology,
			suiteClass: this.suiteClass,
			vvipClass: this.vvipClass,
			vipAClass: this.vipAClass,
			vipBClass: this.vipBClass,
			vipCClass: this.vipCClass,
			mainClass: this.mainClass,
			classI: this.classI,
			iiClass: this.iiClass,
			iiiAClass: this.iiiAClass,
			iiiBClass: this.iiiBClass,
			specialClass: this.specialClass,
			icu: this.icu,
			picu: this.picu,
			nicu: this.nicu,
			hcu: this.hcu,
			iccu: this.iccu,
			isolationRoom: this.isolationRoom,
			emergencyRoom: this.emergencyRoom,
			maternityRoom: this.maternityRoom,
			operatingRoom: this.operatingRoom,
			doctorSpA: this.doctorSpA,
			doctorSpOG: this.doctorSpOG,
			doctorSpPD: this.doctorSpPD,
			doctorSpB: this.doctorSpB,
			doctorSpRad: this.doctorSpRad,
			doctorSpRm: this.doctorSpRm,
			doctorSpAn: this.doctorSpAn,
			doctorSpJp: this.doctorSpJp,
			doctorSpM: this.doctorSpM,
			doctorSpTHT: this.doctorSpTHT,
			doctorSpKj: this.doctorSpKj,
			doctorSpP: this.doctorSpP,
			doctorSpPK: this.doctorSpPK,
			doctorSpS: this.doctorSpS,
			subSpecialistDoctor: this.subSpecialistDoctor,
			otherSpecialistDoctor: this.otherSpecialistDoctor,
			generalPractice: this.generalPractice,
			dentist: this.dentist,
			specialistDentist: this.specialistDentist,
			nurse: this.nurse,
			midwife: this.midwife,
			pharmacist: this.pharmacist,
			otherMedicalStaff: this.otherMedicalStaff,
			nonMedicalStaff: this.nonMedicalStaff,
			leftLogo: this.leftLogo,
			rightLogo: this.rightLogo,
			timezone: this.timezone,
			healthFacilityLevel: this.healthFacilityLevel,
			satuSehatIntegration: this.satuSehatIntegration,
			taxIdentification: this.taxIdentification,
			hospitalGroupId: this.hospitalGroupId,
			staffId: this.staffId,
			// % protected region % [Add any additional logic here to json] off begin
			// % protected region % [Add any additional logic here to json] end
		};
	}

	getPropDisplayNames(): { [s: string]: ModelProperty } {
		const returned = {};
		HospitalBranchInformationModel.getProps().map(prop => returned[prop.name] = prop);
		return returned;
	}

	applyUpdates(updates: any): HospitalBranchInformationModel {
		let newModelJson = this.toJSON();

		if (updates.hospitalCode) {
			newModelJson.hospitalCode = updates.hospitalCode;
		}

		if (updates.hospitalName) {
			newModelJson.hospitalName = updates.hospitalName;
		}

		if (updates.hospitalType) {
			newModelJson.hospitalType = updates.hospitalType;
		}

		if (updates.hospitalClass) {
			newModelJson.hospitalClass = updates.hospitalClass;
		}

		if (updates.hospitalDirectorName) {
			newModelJson.hospitalDirectorName = updates.hospitalDirectorName;
		}

		if (updates.dateOfRegistration) {
			newModelJson.dateOfRegistration = updates.dateOfRegistration;
		}

		if (updates.hospitalCorporationName) {
			newModelJson.hospitalCorporationName = updates.hospitalCorporationName;
		}

		if (updates.isBPJSFacility) {
			newModelJson.isBPJSFacility = updates.isBPJSFacility;
		}

		if (updates.address) {
			newModelJson.address = updates.address;
		}

		if (updates.city) {
			newModelJson.city = updates.city;
		}

		if (updates.postcode) {
			newModelJson.postcode = updates.postcode;
		}

		if (updates.phoneNumber) {
			newModelJson.phoneNumber = updates.phoneNumber;
		}

		if (updates.fax) {
			newModelJson.fax = updates.fax;
		}

		if (updates.email) {
			newModelJson.email = updates.email;
		}

		if (updates.website) {
			newModelJson.website = updates.website;
		}

		if (updates.contactPerson) {
			newModelJson.contactPerson = updates.contactPerson;
		}

		if (updates.contactPersonPhoneNumber) {
			newModelJson.contactPersonPhoneNumber = updates.contactPersonPhoneNumber;
		}

		if (updates.contactPersonEmail) {
			newModelJson.contactPersonEmail = updates.contactPersonEmail;
		}

		if (updates.landSize) {
			newModelJson.landSize = updates.landSize;
		}

		if (updates.buildingSize) {
			newModelJson.buildingSize = updates.buildingSize;
		}

		if (updates.permitNumber) {
			newModelJson.permitNumber = updates.permitNumber;
		}

		if (updates.permitDate) {
			newModelJson.permitDate = updates.permitDate;
		}

		if (updates.authorizedBy) {
			newModelJson.authorizedBy = updates.authorizedBy;
		}

		if (updates.permitType) {
			newModelJson.permitType = updates.permitType;
		}

		if (updates.validUntil) {
			newModelJson.validUntil = updates.validUntil;
		}

		if (updates.hospitalBranchCorporationName) {
			newModelJson.hospitalBranchCorporationName = updates.hospitalBranchCorporationName;
		}

		if (updates.hospitalBranchCorporationStatus) {
			newModelJson.hospitalBranchCorporationStatus = updates.hospitalBranchCorporationStatus;
		}

		if (updates.accreditationType) {
			newModelJson.accreditationType = updates.accreditationType;
		}

		if (updates.accreditationLevel) {
			newModelJson.accreditationLevel = updates.accreditationLevel;
		}

		if (updates.accreditationDate) {
			newModelJson.accreditationDate = updates.accreditationDate;
		}

		if (updates.bedPerinatology) {
			newModelJson.bedPerinatology = updates.bedPerinatology;
		}

		if (updates.suiteClass) {
			newModelJson.suiteClass = updates.suiteClass;
		}

		if (updates.vvipClass) {
			newModelJson.vvipClass = updates.vvipClass;
		}

		if (updates.vipAClass) {
			newModelJson.vipAClass = updates.vipAClass;
		}

		if (updates.vipBClass) {
			newModelJson.vipBClass = updates.vipBClass;
		}

		if (updates.vipCClass) {
			newModelJson.vipCClass = updates.vipCClass;
		}

		if (updates.mainClass) {
			newModelJson.mainClass = updates.mainClass;
		}

		if (updates.classI) {
			newModelJson.classI = updates.classI;
		}

		if (updates.iiClass) {
			newModelJson.iiClass = updates.iiClass;
		}

		if (updates.iiiAClass) {
			newModelJson.iiiAClass = updates.iiiAClass;
		}

		if (updates.iiiBClass) {
			newModelJson.iiiBClass = updates.iiiBClass;
		}

		if (updates.specialClass) {
			newModelJson.specialClass = updates.specialClass;
		}

		if (updates.icu) {
			newModelJson.icu = updates.icu;
		}

		if (updates.picu) {
			newModelJson.picu = updates.picu;
		}

		if (updates.nicu) {
			newModelJson.nicu = updates.nicu;
		}

		if (updates.hcu) {
			newModelJson.hcu = updates.hcu;
		}

		if (updates.iccu) {
			newModelJson.iccu = updates.iccu;
		}

		if (updates.isolationRoom) {
			newModelJson.isolationRoom = updates.isolationRoom;
		}

		if (updates.emergencyRoom) {
			newModelJson.emergencyRoom = updates.emergencyRoom;
		}

		if (updates.maternityRoom) {
			newModelJson.maternityRoom = updates.maternityRoom;
		}

		if (updates.operatingRoom) {
			newModelJson.operatingRoom = updates.operatingRoom;
		}

		if (updates.doctorSpA) {
			newModelJson.doctorSpA = updates.doctorSpA;
		}

		if (updates.doctorSpOG) {
			newModelJson.doctorSpOG = updates.doctorSpOG;
		}

		if (updates.doctorSpPD) {
			newModelJson.doctorSpPD = updates.doctorSpPD;
		}

		if (updates.doctorSpB) {
			newModelJson.doctorSpB = updates.doctorSpB;
		}

		if (updates.doctorSpRad) {
			newModelJson.doctorSpRad = updates.doctorSpRad;
		}

		if (updates.doctorSpRm) {
			newModelJson.doctorSpRm = updates.doctorSpRm;
		}

		if (updates.doctorSpAn) {
			newModelJson.doctorSpAn = updates.doctorSpAn;
		}

		if (updates.doctorSpJp) {
			newModelJson.doctorSpJp = updates.doctorSpJp;
		}

		if (updates.doctorSpM) {
			newModelJson.doctorSpM = updates.doctorSpM;
		}

		if (updates.doctorSpTHT) {
			newModelJson.doctorSpTHT = updates.doctorSpTHT;
		}

		if (updates.doctorSpKj) {
			newModelJson.doctorSpKj = updates.doctorSpKj;
		}

		if (updates.doctorSpP) {
			newModelJson.doctorSpP = updates.doctorSpP;
		}

		if (updates.doctorSpPK) {
			newModelJson.doctorSpPK = updates.doctorSpPK;
		}

		if (updates.doctorSpS) {
			newModelJson.doctorSpS = updates.doctorSpS;
		}

		if (updates.subSpecialistDoctor) {
			newModelJson.subSpecialistDoctor = updates.subSpecialistDoctor;
		}

		if (updates.otherSpecialistDoctor) {
			newModelJson.otherSpecialistDoctor = updates.otherSpecialistDoctor;
		}

		if (updates.generalPractice) {
			newModelJson.generalPractice = updates.generalPractice;
		}

		if (updates.dentist) {
			newModelJson.dentist = updates.dentist;
		}

		if (updates.specialistDentist) {
			newModelJson.specialistDentist = updates.specialistDentist;
		}

		if (updates.nurse) {
			newModelJson.nurse = updates.nurse;
		}

		if (updates.midwife) {
			newModelJson.midwife = updates.midwife;
		}

		if (updates.pharmacist) {
			newModelJson.pharmacist = updates.pharmacist;
		}

		if (updates.otherMedicalStaff) {
			newModelJson.otherMedicalStaff = updates.otherMedicalStaff;
		}

		if (updates.nonMedicalStaff) {
			newModelJson.nonMedicalStaff = updates.nonMedicalStaff;
		}

		if (updates.leftLogo) {
			newModelJson.leftLogo = updates.leftLogo;
		}

		if (updates.rightLogo) {
			newModelJson.rightLogo = updates.rightLogo;
		}

		if (updates.timezone) {
			newModelJson.timezone = updates.timezone;
		}

		if (updates.healthFacilityLevel) {
			newModelJson.healthFacilityLevel = updates.healthFacilityLevel;
		}

		if (updates.satuSehatIntegration) {
			newModelJson.satuSehatIntegration = updates.satuSehatIntegration;
		}

		if (updates.taxIdentification) {
			newModelJson.taxIdentification = updates.taxIdentification;
		}

		if (updates.hospitalGroupId) {
			newModelJson.hospitalGroupId = updates.hospitalGroupId;
		}

		if (updates.staffId) {
			newModelJson.staffId = updates.staffId;
		}

		return new HospitalBranchInformationModel(newModelJson);
	}

	/**
	 * @inheritDoc
	 */
	difference(other: AbstractModel): any {
		if (!(other instanceof HospitalBranchInformationModel)) {
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
			} else if (['leftLogo', 'rightLogo'].includes(key)) {;
				const thisFiles = JSON.stringify(thisValue);
				const otherFiles = JSON.stringify(otherValue);

				if (thisFiles !== otherFiles) {
					diff[key] = thisValue;
				}
			} else if (thisValue !== otherValue) {
				diff[key] = thisValue;
			}
		}

		return _.omit(diff, [
			'created',
			'modified',
			'hospitalGroupId',
			'hospitalGroup',
			'staffId',
			'staff',
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
		if (!this.hospitalGroup) {
			this.hospitalGroupId = null;
		} else {
			this.hospitalGroupId = this.hospitalGroup.id;
		}

		if (!this.staff) {
			this.staffId = null;
		} else {
			this.staffId = this.staff.id;
		}

	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
