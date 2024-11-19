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

import { Component, EventEmitter, Input, OnChanges, OnInit, Output, SimpleChanges } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { Store } from '@ngrx/store';
import { tap } from 'rxjs/operators';
import { AbstractModelAudit, RouterState } from 'src/app/models/model.state';
import { getRouterState } from 'src/app/models/model.selector';
import { FileModel } from 'src/app/lib/models/file.model';
import { AbstractComponent } from 'src/app/lib/components/abstract.component';
import { ButtonStyle, ButtonAccentColour, ButtonSize, IconPosition } from 'src/app/lib/components/button/button.component';
import { TextfieldType } from 'src/app/lib/components/textfield/textfield.component';
import { AbstractModel, ModelProperty, ModelRelation, ModelRelationType, ModelPropertyType } from 'src/app/lib/models/abstract.model';
import { ElementType } from 'src/app/lib/components/abstract.input.component';
import { camelCase } from 'lodash';


// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

export interface ActionButtonGroup {
	elements: BottomActionButtonElement[];
}

/**
 * An object used to configure an element within a group.
 */
export interface BottomActionButtonElement {
	className?: string;
	label?: string;
	iconClasses?: string;
	iconPos?: IconPosition;
	buttonStyle?: ButtonStyle;
	buttonAccentColour?: ButtonAccentColour;
	buttonSize?: ButtonSize;
	callback?: ($event: any) => void;
	doHide?: boolean | (() => boolean);
	[s: string]: any;
}

/**
 * An object used for grouping attributes together within the crud edit page
 * 
 * The model and form attributes are optional because they are only required when trying to add additional entities to the crud page, so
 * if you are only grouping attributes of the same entity then do not set them as it can cause unexpected issues.  At the same time, make sure
 * both of them are set, as only setting one will potentially cause issues.
 *
 * The attribute groups are populated through inputting model relations/properties from crud edit components, within this component these are built
 * in separateForm()
 */
export interface AttributeGroup {
	id: string; // The id of the group, needed in the template to determine which group should be removed when removing additional entities in multi crud many relations
	displayName: string; // The name of the group, shown on the page to differentiate the groups, does not need to be unique in multi crud mode with a many relation
	model?: any; // The entity which is being modified in the group, only used in multi crud pages
	form?: FormGroup; // The form group which stores the changes to be made to the model, again only used in multi crud pages
	manyRelation: boolean; // Whether this group represents an additional entity in a many relation
	props: ModelProperty[]; // The properties belonging to this group, only used for populating the combined array
	relations: ModelRelation[]; // The Relations belonging to this group, only used for populating the combined array
	combined: any[]; // The combined props and relations for this group, used for display in the template, and done like this so that order can be mixed up with props and relations in any order
}

@Component({
	// % protected region % [Modify the existing component configurations here] off begin
	selector: 'cb-crud-create-edit',
	templateUrl: './crud.create.edit.component.html',
	// % protected region % [Modify the existing component configurations here] end
	styleUrls: [
		'./crud.create.edit.component.scss',
		// % protected region % [Add any additional SCSS imports here] off begin
		// % protected region % [Add any additional SCSS imports here] end
	],
	// % protected region % [Add any additional component configurations here] off begin
	// % protected region % [Add any additional component configurations here] end
})
export class CrudCreateEditComponent<E extends AbstractModel, T extends AbstractModelAudit<E>> extends AbstractComponent implements OnInit, OnChanges {
	buttonStyle = ButtonStyle;
	buttonAccentColour = ButtonAccentColour;
	buttonSize = ButtonSize;
	iconPos = IconPosition;
	modelRelationType = ModelRelationType;
	elementType = ElementType;
	textFieldType = TextfieldType;

	/**
	 * Element groups to be displayed in the bottom of the action button groups.
	 */
	actionButtonGroups: ActionButtonGroup[];

	/**
	 * Additional Element groups passed in to display unique crud page actions
	 */
	@Input()
	customGroups: ActionButtonGroup[] = [];

	/**
	 * Model to be edited if this component is opened in edit mode.
	 * The value of the model would be applied to the form group
	 */
	@Input()
	model: E;

	/**
	 * Form group to display. This is required to passed in
	 */
	@Input()
	modelFormGroup: FormGroup;

	/**
	 * Event emitter used to trigger events whenever the user clicks on the `Create` or `Save` button.
	 */
	@Output('createOrSaveClick')
	createOrSaveEventEmitter: EventEmitter<{ isCreate: boolean, payload?: { [key in keyof E]?: any }, additionalEntities?: any }> = new EventEmitter();

	/**
	 * Event emitter used to to trigger events when the user wants to switch from the view mode to edit mode.
	 */
	@Output('switchEdit')
	switchEditEventEmitter: EventEmitter<null> = new EventEmitter();

	/**
	 * Event emitter used to trigger events whenever the user clicks on the `Cancel` button.
	 */
	@Output('cancelClick')
	cancelEventEmitter: EventEmitter<null> = new EventEmitter();

	/**
	 * Event emitter used to trigger events whenever the user clicks on the `View History` button.
	 */
	@Output('viewHistory')
	viewHistoryEventEmitter: EventEmitter<null> = new EventEmitter();

	/**
	 * Event emitter used for triggering changes to the displayed list of additional entities (if any) when
	 * using the crud tile in multi entity mode with a 1:M relation
	 */
	@Output('multiEntity')
	multiEntityEventEmitter: EventEmitter<{ groupId: string, entityName: string, payload?: { [key: string]: any } }> = new EventEmitter();

	/**
	 * List of properties/attributes of the model class managed by this create CRUD component.
	 */
	@Input()
	modelProperties: ModelProperty[] = [];

	/**
	 * List of relations of the model class managed by this create CRUD component.
	 */
	@Input()
	modelRelations: ModelRelation[] = [];

	/**
	 * Whether the info sidebar is current displayed.
	 */
	@Input()
	displayViewHistory: boolean = false;

	@Input()
	showHeader: boolean = true;

	@Input()
	showActionButtons: boolean = true;

	/**
	 * Whether to hide the edit button in the view mode
	 */
	@Input()
	hideEditButton: boolean = false;

	/**
	 * When set to true, the create-edit would scroll to invalid input when try to submit
	 */
	@Input()
	scrollToInvalidInput: boolean = true;

	/**
	 * The audits for this model. Only applicable when in edit mode.
	 */
	@Input()
	audits: T[] = [];

	/**
	 * Changes to be made to the original model.
	 */
	pendingChanges: { [key in keyof E]?: any } = {};

	/**
	 * Whether the current page is displayed in admin/backend mode or not.
	 */
	isAdminMode: boolean = false;

	/**
	 * The names of the buttons used to add an additional instance of an entity type to the list of entities in multi crud mode
	 * Each string in this array will create a button that calls the multi entity event emitter to add another entity.
	 */
	addMultiEntityButtonNames: {name: string, many: boolean}[] = [];

	/**
	 * The default multi entity buttons which should be added to the page.  These are added into addMultiEntityButtonNames during initialisation,
	 * and are present so that the buttons are shown when creating a new entity, as the button names are otherwise based on the entity groups present in
	 * the model props and relations.
	 */
	@Input()
	defaultMultiEntityButtons: {name: string, many: boolean}[] = [];

	// % protected region % [Override the default model Properties attributes here] off begin
	/**
	 * A collection of all of the model properties which do not have an assigned group. This list is populated initially in separateForms()
	 */
	modelPropertiesWithNoGroup: { props: ModelProperty[], relations: ModelRelation[], combined: any[]};

	/**
	 * Used to store model properties in groups defined by the user. This list is populated initially in separateForms()
	 */
	modelPropertiesWithGroup: { [s: string]: AttributeGroup } = {};
	// % protected region % [Override the default model Properties attributes here] end

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		private store: Store<{ router: RouterState }>,
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		super(
			// % protected region % [Add any additional constructor arguments here] off begin
			// % protected region % [Add any additional constructor arguments here] end
		);

		this.store.select(getRouterState).subscribe(
			routerState => {
				if (routerState && routerState.url) {
					this.isAdminMode = routerState.url.startsWith('/admin');
				}
			}
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnInit() {
		// % protected region % [Add any additional ngOnInit logic before the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic before the main body here] end

		this.actionButtonGroups = [
			// % protected region % [Add any additional element groups before the main ones here] off begin
			// % protected region % [Add any additional element groups before the main ones here] end
			{
				elements: [
					// % protected region % [Add any additional elements before the main ones here] off begin
					// % protected region % [Add any additional elements before the main ones here] end

					// % protected region % [Override the default buttons here] off begin
					{
						label: 'Cancel',
						buttonStyle: ButtonStyle.OUTLINE,
						buttonAccentColour: ButtonAccentColour.PRIMARY,
						iconPos: IconPosition.LEFT,
						callback: this.onCancelClicked.bind(this)
					},
					{
						label: 'Edit',
						buttonStyle: ButtonStyle.SOLID,
						buttonAccentColour: ButtonAccentColour.PRIMARY,
						iconPos: IconPosition.LEFT,
						callback: this.onEditClicked.bind(this),
						doHide: () => !this.isDisabled || this.hideEditButton
					},
					{
						label: 'Save',
						buttonStyle: ButtonStyle.SOLID,
						buttonAccentColour: ButtonAccentColour.PRIMARY,
						iconPos: IconPosition.LEFT,
						callback: this.model.id ? this.onSaveClicked.bind(this) : this.onCreateClicked.bind(this),
						doHide: () => this.isDisabled
					},
					// % protected region % [Override the default buttons here] end

					// % protected region % [Add any additional elements after the main ones here] off begin
					// % protected region % [Add any additional elements after the main ones here] end
				]
			},
			...this.customGroups,
			// % protected region % [Add any additional element groups after the main ones here] off begin
			// % protected region % [Add any additional element groups after the main ones here] end
		];

		/**
		 * Calling separateForm is necessary for setting up the data structures used in the create edit page
		 * it will usually always be called as part of ngOnChanges, but also calling it here guarantees it will
		 * be called on startup and allows us to leave the method as private, as we would otherwise need to call it
		 * whenever we instantiate an instance of this class for testing
		 */
		this.separateForm();

		// % protected region % [Add any additional ngOnInit logic after the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic after the main body here] end
	}

	/**
	 * @inheritDoc
	 */
	ngOnChanges(changes: SimpleChanges): void {
		if (changes.hasOwnProperty('modelProperties') || changes.hasOwnProperty('modelRelations')) {
			this.separateForm();
		}
	}

	/**
	 * Triggered when the user clicks on the `Create` button.
	 */
	onCreateClicked() {
		// % protected region % [Add any additional onCreateClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCreateClicked logic before the main body here] end

		if (this.getChangedValuesAndValidate()) {
			this.createOrSaveEventEmitter.emit({
				isCreate: true,
				additionalEntities: this.populateAdditionalEntities(this.model.className)
			});
		}

		// % protected region % [Add any additional onCreateClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCreateClicked logic after the main body here] end
	}

	/**
	 * Triggered when the user clicks on the `Save` button.
	 */
	onSaveClicked() {
		// % protected region % [Add any additional onSaveClicked logic before the main body here] off begin
		// % protected region % [Add any additional onSaveClicked logic before the main body here] end

		if (this.getChangedValuesAndValidate()) {
			this.createOrSaveEventEmitter.emit({
				isCreate: false,
				payload: this.pendingChanges,
				additionalEntities: this.populateAdditionalEntities(this.model.className)
			});
		}

		// % protected region % [Add any additional onSaveClicked logic after the main body here] off begin
		// % protected region % [Add any additional onSaveClicked logic after the main body here] end
	}

	/**
	 * Triggered when the user clicks on the `Edit` button.
	 */
	onEditClicked() {
		// % protected region % [Add any additional onEditClicked logic before the main body here] off begin
		// % protected region % [Add any additional onEditClicked logic before the main body here] end

		this.switchEditEventEmitter.emit(null);

		// % protected region % [Add any additional onEditClicked logic after the main body here] off begin
		// % protected region % [Add any additional onEditClicked logic after the main body here] end
	}

	/**
	 * Triggered when the user clicks on the `Cancel` button.
	 */
	onCancelClicked() {
		// % protected region % [Add any additional onCancelClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic before the main body here] end

		this.cancelEventEmitter.emit(null);

		// % protected region % [Add any additional onCancelClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCancelClicked logic after the main body here] end
	}

	/**
	 * Triggered when the user clicks on the `View History` button.
	 */
	onViewHistory() {
		// % protected region % [Add any additional onViewHistory logic before the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic before the main body here] end

		this.displayViewHistory = true;
		this.viewHistoryEventEmitter.emit(null);

		// % protected region % [Add any additional onViewHistory logic after the main body here] off begin
		// % protected region % [Add any additional onViewHistory logic after the main body here] end
	}

	/**
	 * Triggered when the user clicks the 'Remove `entity` from Model' or 'Add new `entity` to Model' buttons.  Used during
	 * multi crud mode when a many relation is present to communicate the desired changes in the list of models (Adding a new one/removing an existing one)
	 * to the crud edit component so that it can make the changes to the properties present in this component
	 *
	 * @param entityName The name of the entity which is being added/removed.  Only strictly necessary when adding a new object, as in the use
	 * 						case where multiple many relations are present in the crud edit page, the component will need to be able to determine which
	 * 						entity should be added
	 * @param groupId The id of the group which is to be removed
	 */
	onMultiEntityAction(entityName: string, groupId?: string) {
		// % protected region % [Add any additional onMultiEntityAction logic before the main body here] off begin
		// % protected region % [Add any additional onMultiEntityAction logic before the main body here] end

		this.multiEntityEventEmitter.emit({
			groupId: groupId ? groupId : null,
			entityName: entityName,
		});

		// % protected region % [Add any additional onMultiEntityAction logic after the main body here] off begin
		// % protected region % [Add any additional onMultiEntityAction logic after the main body here] end
	}

	/**
	 * Given the JS type of a property in the current model type, return the appropriate textfield type.
	 *
	 * @returns the appropriate input type
	 */
	getInputType(elementType: string): TextfieldType {
		if (elementType === ElementType.NUMBER) {
			return TextfieldType.NUMBER;
		} else if (elementType === ElementType.PASSWORD) {
			return TextfieldType.PASSWORD;
		} else {
			return TextfieldType.TEXT;
		}
	}

	/**
	 * Get the changed values from the modelFormGroup and update to the pendingChanges
	 */
	private getChangedValuesAndValidate(): boolean {
		// % protected region % [Add any additional getChangedValuesAndValidate logic before the main body here] off begin
		// % protected region % [Add any additional getChangedValuesAndValidate logic before the main body here] end

		// Validates all the inputs
		Object.values(this.modelFormGroup.controls)
			.filter(control => !control.disabled)
			.forEach(formControl => {

				/*
					A form control value which is an empty string means that a value has been added in, and then removed
					If this is the case, we need to treat the state of the form control to match the format of other untouched controls
					Untouched controls have an undefined value, so making the value of this one undefined will simulate an untouched control
				 */
				if (formControl.value === '') {
					formControl.setValue(undefined);
				}
				formControl.updateValueAndValidity({emitEvent: true})
			});

		if (this.modelFormGroup.invalid || !this.validateAdditionalEntities()) {
			if (this.scrollToInvalidInput) {
				this.scrollToError();
			}
			return false;
		}

		if (this.model.id) {
			this.pendingChanges = {};
			Object.entries(this.modelFormGroup.controls)
				.filter(([key, formControl]) => formControl.dirty)
				.forEach(([key, formControl]) => this.pendingChanges[key] = formControl.value);
		} else {
			delete this.modelFormGroup.value.id;
			Object.assign(this.model, this.modelFormGroup.value);
		}

		// % protected region % [Add any additional getChangedValuesAndValidate logic after the main body here] off begin
		// % protected region % [Add any additional getChangedValuesAndValidate logic after the main body here] end

		return true;
	}

	/**
	 * Separate properties and relations into their respective groups.
	 */
	private separateForm() {
		// % protected region % [Add any additional separateForm logic before the main body here] off begin
		// % protected region % [Add any additional separateForm logic before the main body here] end

		// As the button names are otherwise populated from the names of the groups passed in, we need to
		// populate the list with the buttons we know we need, as in a entity create situation, no additional groups will be present
		this.addMultiEntityButtonNames = [];
		this.addMultiEntityButtonNames.push(...this.defaultMultiEntityButtons);

		this.modelPropertiesWithGroup = {}; // This is a dictionary which will be added to later in this method
		this.modelPropertiesWithNoGroup = { // This is a similar object to the values of the previous dictionary.  Doesn't have display name as non grouped attributes do not need one
			props: [],
			relations: [],
			combined: []
		};

		// First we separate all model props into different arrays for attributes with no groups, and then a dictionary which contains an array for
		// each group ID.  This ensures that if we have a mix of grouped and ungrouped entities in the component, then they will all be shown
		this.modelProperties.forEach(prop => {
			if (!prop.group) {
				this.modelPropertiesWithNoGroup.props.push(prop);
			} else {
				// If we haven't come across this group before, then we need to add it to the dictionary
				// Otherwise we just add the current prop to the relevant entry
				if (!this.modelPropertiesWithGroup[prop.group.id]) {
					// Each entry in the dictionary contains all the attributes on the page for that group, so we need to initialise it empty and then add the relevant info
					this.modelPropertiesWithGroup[prop.group.id] = this.getDefaultGroup(prop);
				}
				this.modelPropertiesWithGroup[prop.group.id].props.push(prop);
			}
		});

		// Works the same as for props, but handling relations instead
		Object.values(this.modelRelations).forEach(prop => {
			if (!prop.group) {
				this.modelPropertiesWithNoGroup.relations.push(prop);
			} else {
				// Still need to do this to handle edge case where a group only contains relations, as that group wouldn't exist at this point
				if (!this.modelPropertiesWithGroup[prop.group.id]) {
					this.modelPropertiesWithGroup[prop.group.id] = this.getDefaultGroup(prop);
				}
				this.modelPropertiesWithGroup[prop.group.id].relations.push(prop);
			}
		});

		this.modelPropertiesWithNoGroup.combined = [
			...this.modelPropertiesWithNoGroup.props
				.filter(item => item.name !== 'id' && item.name !== 'created' && item.name !== 'modified')
				.map(prop => {
					return {...prop, isProp: true};
				}),
			...this.modelPropertiesWithNoGroup.relations.map(ref => {
				return {...ref, isProp: false};
			}),
		].sort((a, b) => a.index - b.index); // we only sort once the lists are combined, as sorting prior to this would cause the lists to be sorted separately, so the desired order might not occur

		// We want to combine the props and relations together into a list sorted by their indexes (if they exist)
		// Combining the lists allows for sorting all attributes together, instead of just sorting props, and then sorting relations
		Object.values(this.modelPropertiesWithGroup).forEach(val => {
			val.combined = [
				...val.props
					.filter(item => item.name !== 'id' && item.name !== 'created' && item.name !== 'modified')
					.map(prop => {
						return {...prop, isProp: true};
					}),
				...val.relations.map(ref => {
					return {...ref, isProp: false};
				}),
			].sort((a, b) => a.index - b.index); // we only sort once the lists are combined, as sorting prior to this would cause the lists to be sorted separately, so the desired order might not occur
		});

		// % protected region % [Add any additional separateForm logic after the main body here] off begin
		// % protected region % [Add any additional separateForm logic after the main body here] end
	}

	/**
	 * Scroll to the element in the dom
	 */
	scrollTo(el: Element) {
		if (el) {
			el.scrollIntoView({ behavior: 'smooth' });
		}
	}

	/**
	 * Find the error message and scroll to it
	 */
	scrollToError() {
		const firstElementWithError = document.querySelector('.ng-invalid');
		this.scrollTo(firstElementWithError);
	}

	/**
	 * Return the default group used to begin grouping together model properties and relations
	 * @param prop a model property or model relation which has a group
	 * @returns the default group object used to store all information in the groups dictionary
	 */
	getDefaultGroup(prop: ModelProperty | ModelRelation): AttributeGroup {
		// % protected region % [Modify the default group attributes here] off begin
		return {
			id: prop.group.id,
			displayName: prop.group.displayName,
			model: prop.group.model ? prop.group.model : undefined,
			form: prop.group.form ? prop.group.form : undefined,
			manyRelation: prop.group.manyRelation ? prop.group.manyRelation : false,
			props: [],
			relations: [],
			combined: [],
		};
		// % protected region % [Modify the default group attributes here] end
	}

	/**
	 * Takes the group containing a FormGroup and a model, and assigns the changed values in the FormGroup to the Model
	 *
	 * The main use for this method is in configuring the crud edit page to create/update multiple related entities at once. It is recommended to
	 * use this method to build the related entity with the changes from the form
	 */
	assignRelationValueChanges(group: AttributeGroup) {
		let refModel = {...group.model};
		Object.assign(refModel, group.form.value);
		return refModel;
	}

	/**
	 * Checks that all additional entities which have been added to this crud page are valid before proceeding with the creation/update
	 * We only check groups that have an associated form, as any attributes without an associated form are assumed to be part of the primary model for this page
	 *
	 * @returns true if all additional entities pass validation, false if there is a validation error
	 */
	validateAdditionalEntities(): boolean {
		// Returning false within forEach doesn't return false for the whole function, so we need to track the status and return it after the iterations are complete
		let valid = true; // Default to true, we can then set valid to false if we come across any validation issues

		// As all attributes in the base ModelFormGroup are checked for validity regardless of grouping, we do not need to check groups that
		// do not have an associated form group, as these groups do not represent additional entities
		Object.values(this.modelPropertiesWithGroup).filter( group => group.form).forEach(group => {
			Object.values(group.form.controls)
				.filter(control => !control.disabled)
				.forEach(formControl => {
					// Reasoning for this if statement is explained in `getChangedValuesAndValidate()`, as the circumstances are the same
					if (formControl.value === '') {
						formControl.setValue(undefined);
					}

					formControl.updateValueAndValidity({emitEvent: true})
				});

			if (group.form.invalid) {
				if (this.scrollToInvalidInput) {
					this.scrollToError();
				}
				valid = false;
			}
		});

		return valid;
	}

	/**
	 * Creates a list of entities which will be returned in addition to the default event payload.  This allows for configuring different crud edit pages
	 * to return different additional entities.
	 *
	 * @param modelName the name of the model to return additional entities for.  This is entity specific, but will account for whether multi entity has
	 * 			has been turned on for any specific relation
	 * @returns a data structure with all of the additional entities added to this crud edit page
	 */
	populateAdditionalEntities(modelName: string) {
		switch (modelName) {
			case 'AdministrationUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'AdministratorModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'AmendmentDetailModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'BpjsAccidentMasterModel':
				return {
					patientPaymentBPJS: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))])
							: undefined,
				};

			case 'BpjsBedAvailabilityModel':
				return {
				};

			case 'BpjsClaimDataModel':
				return {
				};

			case 'BpjsClaimSubmissionModel':
				let bpjsClaimSubmissionBpjsDismissalConditionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsDismissalConditions_')).forEach(key => {
					bpjsClaimSubmissionBpjsDismissalConditionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsClaimSubmissionBpjsDismissalMappingsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsDismissalMappings_')).forEach(key => {
					bpjsClaimSubmissionBpjsDismissalMappingsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsClaimSubmissionBpjsTreatmentRoomsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsTreatmentRooms_')).forEach(key => {
					bpjsClaimSubmissionBpjsTreatmentRoomsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					bpjsDiagnose: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDiagnose_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDiagnose_'))])
							: undefined,
					bpjsDoctorMapping: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDoctorMapping_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDoctorMapping_'))])
							: undefined,
					bpjsHealthFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsHealthFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsHealthFacility_'))])
							: undefined,
					bpjsProcedure: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsProcedure_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsProcedure_'))])
							: undefined,
					bpjsServiceMapping: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsServiceMapping_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsServiceMapping_'))])
							: undefined,
					patientGeneralInfo: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))])
							: undefined,
					patientPaymentBPJS: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))])
							: undefined,
					bpjsDismissalConditions: bpjsClaimSubmissionBpjsDismissalConditionsModels.length > 0
							? bpjsClaimSubmissionBpjsDismissalConditionsModels
							: undefined,
					bpjsDismissalMappings: bpjsClaimSubmissionBpjsDismissalMappingsModels.length > 0
							? bpjsClaimSubmissionBpjsDismissalMappingsModels
							: undefined,
					bpjsTreatmentRooms: bpjsClaimSubmissionBpjsTreatmentRoomsModels.length > 0
							? bpjsClaimSubmissionBpjsTreatmentRoomsModels
							: undefined,
				};

			case 'BpjsControlPlanModel':
				return {
					bpjsDoctorMapping: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDoctorMapping_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDoctorMapping_'))])
							: undefined,
					bpjsServiceMapping: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsServiceMapping_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsServiceMapping_'))])
							: undefined,
				};

			case 'BpjsControlSpecialistModel':
				return {
				};

			case 'BpjsDiagnoseModel':
				let additionalDiagnoseAdditionalDiagnoseModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('additionalDiagnose_')).forEach(key => {
					additionalDiagnoseAdditionalDiagnoseModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsDiagnoseBpjsClaimSubmissionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsClaimSubmissions_')).forEach(key => {
					bpjsDiagnoseBpjsClaimSubmissionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsDiagnoseBpjsPatientReferralsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsPatientReferrals_')).forEach(key => {
					bpjsDiagnoseBpjsPatientReferralsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let primaryDiagnosePrimaryDiagnoseModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('primaryDiagnose_')).forEach(key => {
					primaryDiagnosePrimaryDiagnoseModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					diagnosesAndProcedures: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosesAndProcedures_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosesAndProcedures_'))])
							: undefined,
					additionalDiagnose: additionalDiagnoseAdditionalDiagnoseModels.length > 0
							? additionalDiagnoseAdditionalDiagnoseModels
							: undefined,
					bpjsClaimSubmissions: bpjsDiagnoseBpjsClaimSubmissionsModels.length > 0
							? bpjsDiagnoseBpjsClaimSubmissionsModels
							: undefined,
					bpjsPatientReferrals: bpjsDiagnoseBpjsPatientReferralsModels.length > 0
							? bpjsDiagnoseBpjsPatientReferralsModels
							: undefined,
					primaryDiagnose: primaryDiagnosePrimaryDiagnoseModels.length > 0
							? primaryDiagnosePrimaryDiagnoseModels
							: undefined,
				};

			case 'BpjsDiagnosePRBModel':
				let bpjsDiagnosePRBBpjsPRBsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsPRBs_')).forEach(key => {
					bpjsDiagnosePRBBpjsPRBsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					diagnosesAndProcedures: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosesAndProcedures_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosesAndProcedures_'))])
							: undefined,
					bpjsPRBs: bpjsDiagnosePRBBpjsPRBsModels.length > 0
							? bpjsDiagnosePRBBpjsPRBsModels
							: undefined,
				};

			case 'BpjsDismissalConditionModel':
				return {
					bpjsClaimSubmission: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsClaimSubmission_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsClaimSubmission_'))])
							: undefined,
				};

			case 'BpjsDismissalMappingModel':
				return {
					bpjsClaimSubmission: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsClaimSubmission_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsClaimSubmission_'))])
							: undefined,
				};

			case 'BpjsDoctorMappingModel':
				let bpjsDoctorMappingBpjsClaimSubmissionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsClaimSubmissions_')).forEach(key => {
					bpjsDoctorMappingBpjsClaimSubmissionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsDoctorMappingBpjsControlPlansModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsControlPlans_')).forEach(key => {
					bpjsDoctorMappingBpjsControlPlansModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsDoctorMappingBpjsPRBsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsPRBs_')).forEach(key => {
					bpjsDoctorMappingBpjsPRBsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsDoctorMappingKodedokterModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('kodedokter_')).forEach(key => {
					bpjsDoctorMappingKodedokterModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
					bpjsClaimSubmissions: bpjsDoctorMappingBpjsClaimSubmissionsModels.length > 0
							? bpjsDoctorMappingBpjsClaimSubmissionsModels
							: undefined,
					bpjsControlPlans: bpjsDoctorMappingBpjsControlPlansModels.length > 0
							? bpjsDoctorMappingBpjsControlPlansModels
							: undefined,
					bpjsPRBs: bpjsDoctorMappingBpjsPRBsModels.length > 0
							? bpjsDoctorMappingBpjsPRBsModels
							: undefined,
					kodedokter: bpjsDoctorMappingKodedokterModels.length > 0
							? bpjsDoctorMappingKodedokterModels
							: undefined,
				};

			case 'BpjsDoctorScheduleModel':
				return {
				};

			case 'BpjsDrugGenericPRBModel':
				let bpjsDrugGenericPRBBpjsPRBDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsPRBDetails_')).forEach(key => {
					bpjsDrugGenericPRBBpjsPRBDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					bpjsPRBDetails: bpjsDrugGenericPRBBpjsPRBDetailsModels.length > 0
							? bpjsDrugGenericPRBBpjsPRBDetailsModels
							: undefined,
				};

			case 'BpjsFacilityListModel':
				return {
					bpjsHealthFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsHealthFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsHealthFacility_'))])
							: undefined,
				};

			case 'BpjsFingerPrintModel':
				return {
				};

			case 'BpjsGeneralModel':
				return {
				};

			case 'BpjsHealthFacilityModel':
				let bpjsHealthFacilityBpjsClaimSubmissionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsClaimSubmissions_')).forEach(key => {
					bpjsHealthFacilityBpjsClaimSubmissionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsHealthFacilityBpjsFacilityListsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsFacilityLists_')).forEach(key => {
					bpjsHealthFacilityBpjsFacilityListsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsHealthFacilityBpjsPatientReferralsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsPatientReferrals_')).forEach(key => {
					bpjsHealthFacilityBpjsPatientReferralsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsHealthFacilityBpjsReferralSpecialistsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsReferralSpecialists_')).forEach(key => {
					bpjsHealthFacilityBpjsReferralSpecialistsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					bpjsClaimSubmissions: bpjsHealthFacilityBpjsClaimSubmissionsModels.length > 0
							? bpjsHealthFacilityBpjsClaimSubmissionsModels
							: undefined,
					bpjsFacilityLists: bpjsHealthFacilityBpjsFacilityListsModels.length > 0
							? bpjsHealthFacilityBpjsFacilityListsModels
							: undefined,
					bpjsPatientReferrals: bpjsHealthFacilityBpjsPatientReferralsModels.length > 0
							? bpjsHealthFacilityBpjsPatientReferralsModels
							: undefined,
					bpjsReferralSpecialists: bpjsHealthFacilityBpjsReferralSpecialistsModels.length > 0
							? bpjsHealthFacilityBpjsReferralSpecialistsModels
							: undefined,
				};

			case 'BpjsHospitalizationPlanModel':
				return {
					patientPaymentBPJS: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))])
							: undefined,
					bpjsDoctorMapping: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDoctorMapping_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDoctorMapping_'))])
							: undefined,
					bpjsServiceMapping: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsServiceMapping_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsServiceMapping_'))])
							: undefined,
				};

			case 'BpjsINACBGModel':
				return {
				};

			case 'BpjsINACBGClaimModel':
				return {
				};

			case 'BpjsINACBGVariableModel':
				return {
				};

			case 'BpjsJasaRaharjaModel':
				return {
					patientPaymentBPJS: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))])
							: undefined,
				};

			case 'BpjsJasaRaharjaClaimModel':
				return {
				};

			case 'BpjsListFingerPrintModel':
				return {
				};

			case 'BpjsListTaskModel':
				return {
				};

			case 'BpjsOutsideFacilityReferralModel':
				return {
				};

			case 'BpjsPRBModel':
				return {
					bpjsDiagnosePRB: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDiagnosePRB_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDiagnosePRB_'))])
							: undefined,
					bpjsDoctorMapping: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDoctorMapping_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDoctorMapping_'))])
							: undefined,
				};

			case 'BpjsPRBDetailModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					bpjsDrugGenericPRB: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDrugGenericPRB_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDrugGenericPRB_'))])
							: undefined,
				};

			case 'BpjsPatientReferralModel':
				return {
					bpjsDiagnose: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDiagnose_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDiagnose_'))])
							: undefined,
					bpjsHealthFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsHealthFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsHealthFacility_'))])
							: undefined,
					bpjsServiceMapping: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsServiceMapping_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsServiceMapping_'))])
							: undefined,
					patientPaymentBPJS: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))])
							: undefined,
				};

			case 'BpjsPcareDPHOModel':
				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
				};

			case 'BpjsPcareKegiatanKelompokModel':
				return {
				};

			case 'BpjsPcareKesadaranModel':
				return {
				};

			case 'BpjsPcarePesertaKegiatanKelompokModel':
				return {
				};

			case 'BpjsPcarePoliModel':
				return {
					service: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))])
							: undefined,
				};

			case 'BpjsPcareProviderRayonisasiModel':
				return {
				};

			case 'BpjsPcareRegistrationsModel':
				return {
					patientVisit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))])
							: undefined,
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
				};

			case 'BpjsProcedureModel':
				let additionalProcedureAdditionalProcedureModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('additionalProcedure_')).forEach(key => {
					additionalProcedureAdditionalProcedureModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsProcedureBpjsClaimSubmissionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsClaimSubmissions_')).forEach(key => {
					bpjsProcedureBpjsClaimSubmissionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let primaryProcedurePrimaryProcedureModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('primaryProcedure_')).forEach(key => {
					primaryProcedurePrimaryProcedureModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					additionalProcedure: additionalProcedureAdditionalProcedureModels.length > 0
							? additionalProcedureAdditionalProcedureModels
							: undefined,
					bpjsClaimSubmissions: bpjsProcedureBpjsClaimSubmissionsModels.length > 0
							? bpjsProcedureBpjsClaimSubmissionsModels
							: undefined,
					primaryProcedure: primaryProcedurePrimaryProcedureModels.length > 0
							? primaryProcedurePrimaryProcedureModels
							: undefined,
				};

			case 'BpjsReferralSpecialistModel':
				return {
					bpjsHealthFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsHealthFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsHealthFacility_'))])
							: undefined,
				};

			case 'BpjsSEPModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					patientPaymentBPJS: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))])
							: undefined,
				};

			case 'BpjsSEPINACBGIntegrationModel':
				return {
				};

			case 'BpjsSEPInternalDataModel':
				return {
				};

			case 'BpjsSEPSubmissionModel':
				return {
					patientPaymentBPJS: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))])
							: undefined,
				};

			case 'BpjsSearchControlLetterModel':
				return {
				};

			case 'BpjsSearchSEPModel':
				return {
				};

			case 'BpjsServiceMappingModel':
				let bpjsServiceMappingBpjsClaimSubmissionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsClaimSubmissions_')).forEach(key => {
					bpjsServiceMappingBpjsClaimSubmissionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsServiceMappingBpjsControlPlansModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsControlPlans_')).forEach(key => {
					bpjsServiceMappingBpjsControlPlansModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsServiceMappingBpjsPatientReferralsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsPatientReferrals_')).forEach(key => {
					bpjsServiceMappingBpjsPatientReferralsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bpjsServiceMappingPolikontrolModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('polikontrol_')).forEach(key => {
					bpjsServiceMappingPolikontrolModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					service: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))])
							: undefined,
					bpjsClaimSubmissions: bpjsServiceMappingBpjsClaimSubmissionsModels.length > 0
							? bpjsServiceMappingBpjsClaimSubmissionsModels
							: undefined,
					bpjsControlPlans: bpjsServiceMappingBpjsControlPlansModels.length > 0
							? bpjsServiceMappingBpjsControlPlansModels
							: undefined,
					bpjsPatientReferrals: bpjsServiceMappingBpjsPatientReferralsModels.length > 0
							? bpjsServiceMappingBpjsPatientReferralsModels
							: undefined,
					polikontrol: bpjsServiceMappingPolikontrolModels.length > 0
							? bpjsServiceMappingPolikontrolModels
							: undefined,
				};

			case 'BpjsSpecialReferralModel':
				return {
					additionalDiagnose: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('additionalDiagnose_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('additionalDiagnose_'))])
							: undefined,
					additionalProcedure: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('additionalProcedure_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('additionalProcedure_'))])
							: undefined,
					primaryDiagnose: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('primaryDiagnose_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('primaryDiagnose_'))])
							: undefined,
					primaryProcedure: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('primaryProcedure_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('primaryProcedure_'))])
							: undefined,
				};

			case 'BpjsTotalReferralSEPModel':
				return {
				};

			case 'BpjsTreatmentClassMappingModel':
				return {
				};

			case 'BpjsTreatmentHistoryModel':
				return {
				};

			case 'BpjsTreatmentRoomModel':
				return {
					bpjsClaimSubmission: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsClaimSubmission_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsClaimSubmission_'))])
							: undefined,
				};

			case 'BpjsUpdateDismissalDateModel':
				return {
				};

			case 'BpjsVisitDataModel':
				return {
					patientVisit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))])
							: undefined,
				};

			case 'BatchStockBalanceModel':
				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'BatchStockBalancePerDateModel':
				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'BatchStockTransactionDetailModel':
				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'BedFacilityModel':
				let bedFacilityBedReservesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bedReserves_')).forEach(key => {
					bedFacilityBedReservesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bedFacilityInpatientMedicalExaminationRecordsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('inpatientMedicalExaminationRecords_')).forEach(key => {
					bedFacilityInpatientMedicalExaminationRecordsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bedFacilityInvoicesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoices_')).forEach(key => {
					bedFacilityInvoicesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bedFacilityRegistrationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('registrations_')).forEach(key => {
					bedFacilityRegistrationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let bedFacilityRoomTransfersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('roomTransfers_')).forEach(key => {
					bedFacilityRoomTransfersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					intraoperativeRecords: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('intraoperativeRecords_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('intraoperativeRecords_'))])
							: undefined,
					postOperativeDetails: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('postOperativeDetails_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('postOperativeDetails_'))])
							: undefined,
					preoperativeRecords: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('preoperativeRecords_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('preoperativeRecords_'))])
							: undefined,
					roomFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('roomFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('roomFacility_'))])
							: undefined,
					bedReserves: bedFacilityBedReservesModels.length > 0
							? bedFacilityBedReservesModels
							: undefined,
					inpatientMedicalExaminationRecords: bedFacilityInpatientMedicalExaminationRecordsModels.length > 0
							? bedFacilityInpatientMedicalExaminationRecordsModels
							: undefined,
					invoices: bedFacilityInvoicesModels.length > 0
							? bedFacilityInvoicesModels
							: undefined,
					registrations: bedFacilityRegistrationsModels.length > 0
							? bedFacilityRegistrationsModels
							: undefined,
					roomTransfers: bedFacilityRoomTransfersModels.length > 0
							? bedFacilityRoomTransfersModels
							: undefined,
				};

			case 'BedReserveModel':
				return {
					bedFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bedFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bedFacility_'))])
							: undefined,
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
				};

			case 'BirthHistoryModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'BodyChartExaminationModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'BpjsPcareKunjunganRujukanModel':
				return {
				};

			case 'BpjsPcarePendaftaranModel':
				return {
					patientVisit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))])
							: undefined,
				};

			case 'BpjsPcareRiwayatKunjunganModel':
				return {
				};

			case 'CashAllocationModel':
				return {
				};

			case 'CashReceiptModel':
				return {
					merchant: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('merchant_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('merchant_'))])
							: undefined,
					retailPharmacyInvoice: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('retailPharmacyInvoice_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('retailPharmacyInvoice_'))])
							: undefined,
					cashierStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('cashierStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('cashierStaff_'))])
							: undefined,
					patient: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patient_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patient_'))])
							: undefined,
				};

			case 'CashRefundModel':
				return {
					patientGeneralInfo: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))])
							: undefined,
				};

			case 'CashierUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'CatalogueMedicalModel':
				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
				};

			case 'CatalogueNonMedicalModel':
				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
				};

			case 'CatalogueUOMModel':
				return {
					unitOfMeasurement: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unitOfMeasurement_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unitOfMeasurement_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
				};

			case 'ChartOfAccountModel':
				let chartOfAccountChartOfAccountMappingsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('chartOfAccountMappings_')).forEach(key => {
					chartOfAccountChartOfAccountMappingsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					chartOfAccountMappings: chartOfAccountChartOfAccountMappingsModels.length > 0
							? chartOfAccountChartOfAccountMappingsModels
							: undefined,
				};

			case 'ChartOfAccountMappingModel':
				return {
					chartOfAccount: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('chartOfAccount_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('chartOfAccount_'))])
							: undefined,
				};

			case 'ClaimUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'CoTreatingDoctorModel':
				return {
					additionalAnesthesiologist: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('additionalAnesthesiologist_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('additionalAnesthesiologist_'))])
							: undefined,
					additionalMidwife: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('additionalMidwife_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('additionalMidwife_'))])
							: undefined,
					additionalSurgeryNurse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('additionalSurgeryNurse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('additionalSurgeryNurse_'))])
							: undefined,
					coTreatingAnesthesiologist: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('coTreatingAnesthesiologist_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('coTreatingAnesthesiologist_'))])
							: undefined,
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
					coTreatingSurgeon: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('coTreatingSurgeon_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('coTreatingSurgeon_'))])
							: undefined,
				};

			case 'CompoundPrescriptionDetailModel':
				let compoundPrescriptionDetailCompoundPrescriptionItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('compoundPrescriptionItems_')).forEach(key => {
					compoundPrescriptionDetailCompoundPrescriptionItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					consumptionUnit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('consumptionUnit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('consumptionUnit_'))])
							: undefined,
					compoundPrescriptionItems: compoundPrescriptionDetailCompoundPrescriptionItemsModels.length > 0
							? compoundPrescriptionDetailCompoundPrescriptionItemsModels
							: undefined,
				};

			case 'CompoundPrescriptionItemModel':
				return {
					compoundPrescriptionDetail: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('compoundPrescriptionDetail_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('compoundPrescriptionDetail_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					unit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unit_'))])
							: undefined,
				};

			case 'DailyCareCPPTModel':
				return {
					icd10: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd10_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd10_'))])
							: undefined,
					icd9CM: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd9CM_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd9CM_'))])
							: undefined,
					createdByStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('createdByStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('createdByStaff_'))])
							: undefined,
					doctorInCharge: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('doctorInCharge_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('doctorInCharge_'))])
							: undefined,
					medicalTranscriber: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalTranscriber_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalTranscriber_'))])
							: undefined,
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'DeliveryMedicalExaminationRecordModel':
				let additionalMidwifeAdditionalMidwivesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('additionalMidwives_')).forEach(key => {
					additionalMidwifeAdditionalMidwivesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let deliveryMedicalExaminationRecordDeliveryProgressesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('deliveryProgresses_')).forEach(key => {
					deliveryMedicalExaminationRecordDeliveryProgressesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let deliveryMedicalExaminationRecordNewbornDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('newbornDetails_')).forEach(key => {
					deliveryMedicalExaminationRecordNewbornDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
					midwife: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('midwife_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('midwife_'))])
							: undefined,
					additionalMidwives: additionalMidwifeAdditionalMidwivesModels.length > 0
							? additionalMidwifeAdditionalMidwivesModels
							: undefined,
					deliveryProgresses: deliveryMedicalExaminationRecordDeliveryProgressesModels.length > 0
							? deliveryMedicalExaminationRecordDeliveryProgressesModels
							: undefined,
					newbornDetails: deliveryMedicalExaminationRecordNewbornDetailsModels.length > 0
							? deliveryMedicalExaminationRecordNewbornDetailsModels
							: undefined,
				};

			case 'DeliveryProgressModel':
				return {
					deliveryMedicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('deliveryMedicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('deliveryMedicalExaminationRecord_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'DiagnosesAndProceduresModel':
				let admissionICD10AdmissionICD10Models = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('admissionICD10_')).forEach(key => {
					admissionICD10AdmissionICD10Models.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let admissionICD9CMAdmissionICD9CMModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('admissionICD9CM_')).forEach(key => {
					admissionICD9CMAdmissionICD9CMModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let icd10CpptICD10Models = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('cpptICD10_')).forEach(key => {
					icd10CpptICD10Models.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let icd9CMCpptICD9CMModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('cpptICD9CM_')).forEach(key => {
					icd9CMCpptICD9CMModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let dischargeICD10DischargeICD10Models = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('dischargeICD10_')).forEach(key => {
					dischargeICD10DischargeICD10Models.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let dischargeICD9CMDischargeICD9CMModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('dischargeICD9CM_')).forEach(key => {
					dischargeICD9CMDischargeICD9CMModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let icd10Icd10Models = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('icd10_')).forEach(key => {
					icd10Icd10Models.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let icd9CMIcd9CMModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('icd9CM_')).forEach(key => {
					icd9CMIcd9CMModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let icd10InvoicesICD10Models = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoicesICD10_')).forEach(key => {
					icd10InvoicesICD10Models.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let icd9CMInvoicesICD9CMModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoicesICD9CM_')).forEach(key => {
					icd9CMInvoicesICD9CMModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let postOperativeICD10PostOperativeICD10Models = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('postOperativeICD10_')).forEach(key => {
					postOperativeICD10PostOperativeICD10Models.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let postOperativeICD9CMPostOperativeICD9CMModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('postOperativeICD9CM_')).forEach(key => {
					postOperativeICD9CMPostOperativeICD9CMModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let preSurgeryICD10PreSurgeryICD10Models = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('preSurgeryICD10_')).forEach(key => {
					preSurgeryICD10PreSurgeryICD10Models.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let preSurgeryICD9CMPreSurgeryICD9CMModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('preSurgeryICD9CM_')).forEach(key => {
					preSurgeryICD9CMPreSurgeryICD9CMModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let nursingDiagnosisNandasModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('diagnosisNandas_')).forEach(key => {
					nursingDiagnosisNandasModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					bpjsDiagnose: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDiagnose_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDiagnose_'))])
							: undefined,
					bpjsDiagnosePRB: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDiagnosePRB_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDiagnosePRB_'))])
							: undefined,
					masterICD10: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('masterICD10_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('masterICD10_'))])
							: undefined,
					masterICD9CM: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('masterICD9CM_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('masterICD9CM_'))])
							: undefined,
					admissionICD10: admissionICD10AdmissionICD10Models.length > 0
							? admissionICD10AdmissionICD10Models
							: undefined,
					admissionICD9CM: admissionICD9CMAdmissionICD9CMModels.length > 0
							? admissionICD9CMAdmissionICD9CMModels
							: undefined,
					cpptICD10: icd10CpptICD10Models.length > 0
							? icd10CpptICD10Models
							: undefined,
					cpptICD9CM: icd9CMCpptICD9CMModels.length > 0
							? icd9CMCpptICD9CMModels
							: undefined,
					dischargeICD10: dischargeICD10DischargeICD10Models.length > 0
							? dischargeICD10DischargeICD10Models
							: undefined,
					dischargeICD9CM: dischargeICD9CMDischargeICD9CMModels.length > 0
							? dischargeICD9CMDischargeICD9CMModels
							: undefined,
					icd10: icd10Icd10Models.length > 0
							? icd10Icd10Models
							: undefined,
					icd9CM: icd9CMIcd9CMModels.length > 0
							? icd9CMIcd9CMModels
							: undefined,
					invoicesICD10: icd10InvoicesICD10Models.length > 0
							? icd10InvoicesICD10Models
							: undefined,
					invoicesICD9CM: icd9CMInvoicesICD9CMModels.length > 0
							? icd9CMInvoicesICD9CMModels
							: undefined,
					postOperativeICD10: postOperativeICD10PostOperativeICD10Models.length > 0
							? postOperativeICD10PostOperativeICD10Models
							: undefined,
					postOperativeICD9CM: postOperativeICD9CMPostOperativeICD9CMModels.length > 0
							? postOperativeICD9CMPostOperativeICD9CMModels
							: undefined,
					preSurgeryICD10: preSurgeryICD10PreSurgeryICD10Models.length > 0
							? preSurgeryICD10PreSurgeryICD10Models
							: undefined,
					preSurgeryICD9CM: preSurgeryICD9CMPreSurgeryICD9CMModels.length > 0
							? preSurgeryICD9CMPreSurgeryICD9CMModels
							: undefined,
					diagnosisNandas: nursingDiagnosisNandasModels.length > 0
							? nursingDiagnosisNandasModels
							: undefined,
				};

			case 'DiagnosisExaminationRecordModel':
				return {
					diagnosticStaffExaminationSummary: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosticStaffExaminationSummary_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosticStaffExaminationSummary_'))])
							: undefined,
					sampleCollectionInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sampleCollectionInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sampleCollectionInformation_'))])
							: undefined,
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
					medicalExaminationRecordDischargeSummary: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecordDischargeSummary_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecordDischargeSummary_'))])
							: undefined,
					icd10: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd10_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd10_'))])
							: undefined,
					icd9CM: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd9CM_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd9CM_'))])
							: undefined,
				};

			case 'DiagnosisNandaModel':
				let nursingAnesthesiaDetailNursingAnesthesiaDetailModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('nursingAnesthesiaDetail_')).forEach(key => {
					nursingAnesthesiaDetailNursingAnesthesiaDetailModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let nursingSurgicalDetailNursingSurgicalDetailModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('nursingSurgicalDetail_')).forEach(key => {
					nursingSurgicalDetailNursingSurgicalDetailModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let diagnosisNandasNursingModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('nursing_')).forEach(key => {
					diagnosisNandasNursingModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
					nursingAnesthesiaDetail: nursingAnesthesiaDetailNursingAnesthesiaDetailModels.length > 0
							? nursingAnesthesiaDetailNursingAnesthesiaDetailModels
							: undefined,
					nursingSurgicalDetail: nursingSurgicalDetailNursingSurgicalDetailModels.length > 0
							? nursingSurgicalDetailNursingSurgicalDetailModels
							: undefined,
					nursing: diagnosisNandasNursingModels.length > 0
							? diagnosisNandasNursingModels
							: undefined,
				};

			case 'DiagnosticExaminationResultsModel':
				return {
					examinationItem: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('examinationItem_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('examinationItem_'))])
							: undefined,
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
				};

			case 'DiagnosticStaffExaminationSummaryModel':
				return {
					diagnosisExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosisExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosisExaminationRecord_'))])
							: undefined,
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'DiagnosticSupportGeneralConfigurationModel':
				return {
				};

			case 'DiagnosticSupportUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'DoctorScheduleModel':
				return {
					service: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'DoctorUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'EntExaminationModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'EmergencyMedicalExaminationRecordModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'ExaminationGroupModel':
				let examinationGroupExaminationItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('examinationItems_')).forEach(key => {
					examinationGroupExaminationItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					service: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))])
							: undefined,
					examinationItems: examinationGroupExaminationItemsModels.length > 0
							? examinationGroupExaminationItemsModels
							: undefined,
				};

			case 'ExaminationItemModel':
				let examinationItemDiagnosticExaminationResultsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('diagnosticExaminationResults_')).forEach(key => {
					examinationItemDiagnosticExaminationResultsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let examinationItemExaminationItemDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('examinationItemDetails_')).forEach(key => {
					examinationItemExaminationItemDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let examinationItemsExaminationItemOfMCUItemModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('examinationItemOfMCUItem_')).forEach(key => {
					examinationItemsExaminationItemOfMCUItemModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let examinationItemsRegistrationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('registrations_')).forEach(key => {
					examinationItemsRegistrationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					examinationGroup: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('examinationGroup_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('examinationGroup_'))])
							: undefined,
					serviceItem: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('serviceItem_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('serviceItem_'))])
							: undefined,
					diagnosticExaminationResults: examinationItemDiagnosticExaminationResultsModels.length > 0
							? examinationItemDiagnosticExaminationResultsModels
							: undefined,
					examinationItemDetails: examinationItemExaminationItemDetailsModels.length > 0
							? examinationItemExaminationItemDetailsModels
							: undefined,
					examinationItemOfMCUItem: examinationItemsExaminationItemOfMCUItemModels.length > 0
							? examinationItemsExaminationItemOfMCUItemModels
							: undefined,
					registrations: examinationItemsRegistrationsModels.length > 0
							? examinationItemsRegistrationsModels
							: undefined,
				};

			case 'ExaminationItemDetailModel':
				return {
					examinationItem: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('examinationItem_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('examinationItem_'))])
							: undefined,
				};

			case 'FacilityHistoryModel':
				return {
				};

			case 'FacilityUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'FluidBalanceDetailModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'FormulirKonselingTesHivModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'GoodsReceiveNoteModel':
				let goodsReceiveNoteGoodsReceiveNoteItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('goodsReceiveNoteItems_')).forEach(key => {
					goodsReceiveNoteGoodsReceiveNoteItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let goodsReceiveNotePurchaseOrdersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('purchaseOrders_')).forEach(key => {
					goodsReceiveNotePurchaseOrdersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					supplier: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					goodsReceiveNoteItems: goodsReceiveNoteGoodsReceiveNoteItemsModels.length > 0
							? goodsReceiveNoteGoodsReceiveNoteItemsModels
							: undefined,
					purchaseOrders: goodsReceiveNotePurchaseOrdersModels.length > 0
							? goodsReceiveNotePurchaseOrdersModels
							: undefined,
				};

			case 'GoodsReceiveNoteBatchModel':
				return {
					goodsReceiveNoteItem: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('goodsReceiveNoteItem_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('goodsReceiveNoteItem_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'GoodsReceiveNoteItemModel':
				let goodsReceiveNoteItemGoodsReceiveNoteBatchsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('goodsReceiveNoteBatchs_')).forEach(key => {
					goodsReceiveNoteItemGoodsReceiveNoteBatchsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					goodsReceiveNote: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('goodsReceiveNote_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('goodsReceiveNote_'))])
							: undefined,
					purchaseOrderStockDetail: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseOrderStockDetail_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseOrderStockDetail_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					goodsReceiveNoteBatchs: goodsReceiveNoteItemGoodsReceiveNoteBatchsModels.length > 0
							? goodsReceiveNoteItemGoodsReceiveNoteBatchsModels
							: undefined,
				};

			case 'HealthFacilityModel':
				let dismissalReferringFacilityDismissalReferringFacilityModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('dismissalReferringFacility_')).forEach(key => {
					dismissalReferringFacilityDismissalReferringFacilityModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let referringFacilityReferringFacilityModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('referringFacility_')).forEach(key => {
					referringFacilityReferringFacilityModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					dismissalReferringFacility: dismissalReferringFacilityDismissalReferringFacilityModels.length > 0
							? dismissalReferringFacilityDismissalReferringFacilityModels
							: undefined,
					referringFacility: referringFacilityReferringFacilityModels.length > 0
							? referringFacilityReferringFacilityModels
							: undefined,
				};

			case 'HemodialysisExaminationModel':
				let hemodialysisExaminationHemodialysisMonitoringsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('hemodialysisMonitorings_')).forEach(key => {
					hemodialysisExaminationHemodialysisMonitoringsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
					hemodialysisMonitorings: hemodialysisExaminationHemodialysisMonitoringsModels.length > 0
							? hemodialysisExaminationHemodialysisMonitoringsModels
							: undefined,
				};

			case 'HemodialysisMonitoringModel':
				return {
					hemodialysisExamination: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('hemodialysisExamination_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('hemodialysisExamination_'))])
							: undefined,
					medicalStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))])
							: undefined,
				};

			case 'HospitalBranchInformationModel':
				return {
					hospitalGroup: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('hospitalGroup_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('hospitalGroup_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'HospitalGroupInformationModel':
				let hospitalGroupHospitalBranchInformationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('hospitalBranchInformations_')).forEach(key => {
					hospitalGroupHospitalBranchInformationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					hospitalBranchInformations: hospitalGroupHospitalBranchInformationsModels.length > 0
							? hospitalGroupHospitalBranchInformationsModels
							: undefined,
				};

			case 'Icd10Model':
				return {
					diagnosesAndProcedures: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosesAndProcedures_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosesAndProcedures_'))])
							: undefined,
				};

			case 'Icd9CMModel':
				return {
					diagnosesAndProcedures: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosesAndProcedures_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosesAndProcedures_'))])
							: undefined,
				};

			case 'InformedConsentModel':
				return {
					accompanyingStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('accompanyingStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('accompanyingStaff_'))])
							: undefined,
					patientGeneralInfo: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))])
							: undefined,
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					informingStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('informingStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('informingStaff_'))])
							: undefined,
				};

			case 'InpatientMedicalExaminationRecordModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
					bedFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bedFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bedFacility_'))])
							: undefined,
				};

			case 'InsuranceBenefitPlanModel':
				let insuranceBenefitPlanInvoicePaymentInsurancesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoicePaymentInsurances_')).forEach(key => {
					insuranceBenefitPlanInvoicePaymentInsurancesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let insuranceBenefitPlanPatientPaymentInsurancesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('patientPaymentInsurances_')).forEach(key => {
					insuranceBenefitPlanPatientPaymentInsurancesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let insuranceBenefitPlanPatientVisitPatientPaymentInsurancesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('patientVisitPatientPaymentInsurances_')).forEach(key => {
					insuranceBenefitPlanPatientVisitPatientPaymentInsurancesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					insuranceProvider: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('insuranceProvider_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('insuranceProvider_'))])
							: undefined,
					invoicePaymentInsurances: insuranceBenefitPlanInvoicePaymentInsurancesModels.length > 0
							? insuranceBenefitPlanInvoicePaymentInsurancesModels
							: undefined,
					patientPaymentInsurances: insuranceBenefitPlanPatientPaymentInsurancesModels.length > 0
							? insuranceBenefitPlanPatientPaymentInsurancesModels
							: undefined,
					patientVisitPatientPaymentInsurances: insuranceBenefitPlanPatientVisitPatientPaymentInsurancesModels.length > 0
							? insuranceBenefitPlanPatientVisitPatientPaymentInsurancesModels
							: undefined,
				};

			case 'InsuranceProviderModel':
				let insuranceProviderInsuranceBenefitPlansModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('insuranceBenefitPlans_')).forEach(key => {
					insuranceProviderInsuranceBenefitPlansModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					insuranceBenefitPlans: insuranceProviderInsuranceBenefitPlansModels.length > 0
							? insuranceProviderInsuranceBenefitPlansModels
							: undefined,
				};

			case 'InternalOrderModel':
				let internalOrderInternalOrderStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('internalOrderStockDetails_')).forEach(key => {
					internalOrderInternalOrderStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					internalOrderStockDetails: internalOrderInternalOrderStockDetailsModels.length > 0
							? internalOrderInternalOrderStockDetailsModels
							: undefined,
				};

			case 'InternalOrderStockDetailModel':
				return {
					internalOrder: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('internalOrder_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('internalOrder_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
				};

			case 'IntraoperativeRecordsModel':
				let intraoperativeRecordsBedFacilitiesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bedFacilities_')).forEach(key => {
					intraoperativeRecordsBedFacilitiesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					operatingTheaterMedicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('operatingTheaterMedicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('operatingTheaterMedicalExaminationRecord_'))])
							: undefined,
					operatingRoom: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('operatingRoom_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('operatingRoom_'))])
							: undefined,
					bedFacilities: intraoperativeRecordsBedFacilitiesModels.length > 0
							? intraoperativeRecordsBedFacilitiesModels
							: undefined,
				};

			case 'InventoryAdjusmentBatchModel':
				return {
					inventoryAdjustmentItem: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('inventoryAdjustmentItem_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('inventoryAdjustmentItem_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'InventoryAdjustmentModel':
				let inventoryAdjustmentInventoryAdjustmentItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('inventoryAdjustmentItems_')).forEach(key => {
					inventoryAdjustmentInventoryAdjustmentItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					transactionDetailType: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transactionDetailType_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transactionDetailType_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					inventoryAdjustmentItems: inventoryAdjustmentInventoryAdjustmentItemsModels.length > 0
							? inventoryAdjustmentInventoryAdjustmentItemsModels
							: undefined,
				};

			case 'InventoryAdjustmentItemModel':
				let inventoryAdjustmentItemInventoryAdjusmentBatchsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('inventoryAdjusmentBatchs_')).forEach(key => {
					inventoryAdjustmentItemInventoryAdjusmentBatchsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					inventoryAdjustment: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('inventoryAdjustment_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('inventoryAdjustment_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					inventoryAdjusmentBatchs: inventoryAdjustmentItemInventoryAdjusmentBatchsModels.length > 0
							? inventoryAdjustmentItemInventoryAdjusmentBatchsModels
							: undefined,
				};

			case 'InventoryBatchCorrectionModel':
				let inventoryBatchCorrectionInventoryBatchCorrectionItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('inventoryBatchCorrectionItems_')).forEach(key => {
					inventoryBatchCorrectionInventoryBatchCorrectionItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					inventoryBatchCorrectionItems: inventoryBatchCorrectionInventoryBatchCorrectionItemsModels.length > 0
							? inventoryBatchCorrectionInventoryBatchCorrectionItemsModels
							: undefined,
				};

			case 'InventoryBatchCorrectionItemModel':
				return {
					inventoryBatchCorrection: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('inventoryBatchCorrection_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('inventoryBatchCorrection_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
				};

			case 'InvoiceModel':
				let invoiceInvoiceItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoiceItems_')).forEach(key => {
					invoiceInvoiceItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let invoiceInvoicePaymentInsurancesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoicePaymentInsurances_')).forEach(key => {
					invoiceInvoicePaymentInsurancesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					medicationHeader: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationHeader_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationHeader_'))])
							: undefined,
					invoicePaymentOther: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoicePaymentOther_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoicePaymentOther_'))])
							: undefined,
					invoicePaymentSelfPaying: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoicePaymentSelfPaying_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoicePaymentSelfPaying_'))])
							: undefined,
					invoiceSummary: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoiceSummary_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoiceSummary_'))])
							: undefined,
					prescriptionHeader: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('prescriptionHeader_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('prescriptionHeader_'))])
							: undefined,
					icd10: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd10_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd10_'))])
							: undefined,
					icd9CM: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd9CM_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('icd9CM_'))])
							: undefined,
					bedFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bedFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bedFacility_'))])
							: undefined,
					patientVisit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))])
							: undefined,
					tariffSchema: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffSchema_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffSchema_'))])
							: undefined,
					verifiedBy: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('verifiedBy_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('verifiedBy_'))])
							: undefined,
					invoiceItems: invoiceInvoiceItemsModels.length > 0
							? invoiceInvoiceItemsModels
							: undefined,
					invoicePaymentInsurances: invoiceInvoicePaymentInsurancesModels.length > 0
							? invoiceInvoicePaymentInsurancesModels
							: undefined,
				};

			case 'InvoiceItemModel':
				let invoiceItemInvoiceItemComponentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoiceItemComponents_')).forEach(key => {
					invoiceItemInvoiceItemComponentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					invoice: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))])
							: undefined,
					medicalFee: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalFee_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalFee_'))])
							: undefined,
					medicationHeader: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationHeader_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationHeader_'))])
							: undefined,
					prescription: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('prescription_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('prescription_'))])
							: undefined,
					retailPharmacyInvoice: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('retailPharmacyInvoice_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('retailPharmacyInvoice_'))])
							: undefined,
					serviceNumber: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('serviceNumber_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('serviceNumber_'))])
							: undefined,
					tariffSchema: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffSchema_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffSchema_'))])
							: undefined,
					invoiceItemComponents: invoiceItemInvoiceItemComponentsModels.length > 0
							? invoiceItemInvoiceItemComponentsModels
							: undefined,
				};

			case 'InvoiceItemComponentModel':
				return {
					invoiceItem: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoiceItem_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoiceItem_'))])
							: undefined,
					priceComponent: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('priceComponent_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('priceComponent_'))])
							: undefined,
				};

			case 'InvoicePaymentInsuranceModel':
				return {
					insuranceBenefitPlan: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('insuranceBenefitPlan_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('insuranceBenefitPlan_'))])
							: undefined,
					invoice: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))])
							: undefined,
				};

			case 'InvoicePaymentOtherModel':
				return {
					invoice: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))])
							: undefined,
				};

			case 'InvoicePaymentSelfPayingModel':
				return {
					invoice: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))])
							: undefined,
				};

			case 'InvoiceSummaryModel':
				return {
					invoice: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))])
							: undefined,
					retailPharmacyInvoice: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('retailPharmacyInvoice_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('retailPharmacyInvoice_'))])
							: undefined,
				};

			case 'JournalModel':
				return {
				};

			case 'LibraryModel':
				return {
				};

			case 'LocationModel':
				let locationStockControlsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockControls_')).forEach(key => {
					locationStockControlsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let locationWarehouseInitialStockSModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('warehouseInitialStockS_')).forEach(key => {
					locationWarehouseInitialStockSModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let locationWarehouseInventoriesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('warehouseInventories_')).forEach(key => {
					locationWarehouseInventoriesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					stockControls: locationStockControlsModels.length > 0
							? locationStockControlsModels
							: undefined,
					warehouseInitialStockS: locationWarehouseInitialStockSModels.length > 0
							? locationWarehouseInitialStockSModels
							: undefined,
					warehouseInventories: locationWarehouseInventoriesModels.length > 0
							? locationWarehouseInventoriesModels
							: undefined,
				};

			case 'McuPackageModel':
				let mcuPackageMcuPackageItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('mcuPackageItems_')).forEach(key => {
					mcuPackageMcuPackageItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					mcuPackageItems: mcuPackageMcuPackageItemsModels.length > 0
							? mcuPackageMcuPackageItemsModels
							: undefined,
				};

			case 'McuPackageItemModel':
				let examinationItemOfMCUItemExaminationItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('examinationItems_')).forEach(key => {
					examinationItemOfMCUItemExaminationItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					mcuPackage: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('mcuPackage_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('mcuPackage_'))])
							: undefined,
					service: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
					examinationItems: examinationItemOfMCUItemExaminationItemsModels.length > 0
							? examinationItemOfMCUItemExaminationItemsModels
							: undefined,
				};

			case 'ManagementUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'MedicalCertificateDischargeResumeModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					dischargeICD10: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('dischargeICD10_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('dischargeICD10_'))])
							: undefined,
					dischargeICD9CM: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('dischargeICD9CM_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('dischargeICD9CM_'))])
							: undefined,
					medicalStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))])
							: undefined,
				};

			case 'MedicalCertificateBirthModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					medicalStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))])
							: undefined,
				};

			case 'MedicalCertificateHospitalizationModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					medicalStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))])
							: undefined,
				};

			case 'MedicalCertificateMedicalAttendanceModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					medicalStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))])
							: undefined,
				};

			case 'MedicalCertificateMentalHealthModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					medicalStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))])
							: undefined,
				};

			case 'MedicalCertificatePhysicalHealthModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					medicalStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))])
							: undefined,
				};

			case 'MedicalCertificateRestrictedWorkModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					medicalStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))])
							: undefined,
				};

			case 'MedicalCertificateSickLeaveModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					medicalStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalStaff_'))])
							: undefined,
				};

			case 'MedicalExaminationRecordModel':
				let medicalExaminationRecordAmendmentDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('amendmentDetails_')).forEach(key => {
					medicalExaminationRecordAmendmentDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalExaminationRecordCoTreatingDoctorsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('coTreatingDoctors_')).forEach(key => {
					medicalExaminationRecordCoTreatingDoctorsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalExaminationRecordDailyCareCPPTsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('dailyCareCPPTs_')).forEach(key => {
					medicalExaminationRecordDailyCareCPPTsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalExaminationRecordDiagnosisExaminationRecordsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('diagnosisExaminationRecords_')).forEach(key => {
					medicalExaminationRecordDiagnosisExaminationRecordsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalExaminationRecordDiagnosisNandasModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('diagnosisNandas_')).forEach(key => {
					medicalExaminationRecordDiagnosisNandasModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalExaminationRecordRoomTransfersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('roomTransfers_')).forEach(key => {
					medicalExaminationRecordRoomTransfersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					inpatientMedicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('inpatientMedicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('inpatientMedicalExaminationRecord_'))])
							: undefined,
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					birthHistory: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('birthHistory_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('birthHistory_'))])
							: undefined,
					bodyChartExamination: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bodyChartExamination_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bodyChartExamination_'))])
							: undefined,
					deliveryMedicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('deliveryMedicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('deliveryMedicalExaminationRecord_'))])
							: undefined,
					entExamination: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('entExamination_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('entExamination_'))])
							: undefined,
					emergencyMedicationExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('emergencyMedicationExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('emergencyMedicationExaminationRecord_'))])
							: undefined,
					formulirKonselingTesHiv: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('formulirKonselingTesHiv_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('formulirKonselingTesHiv_'))])
							: undefined,
					hemodialysisExamination: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('hemodialysisExamination_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('hemodialysisExamination_'))])
							: undefined,
					medicalExaminationRecordDischargeSummary: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecordDischargeSummary_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecordDischargeSummary_'))])
							: undefined,
					medicalRecordInitialChecklist: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalRecordInitialChecklist_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalRecordInitialChecklist_'))])
							: undefined,
					medicalRecordNextVerificationChecklist: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalRecordNextVerificationChecklist_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalRecordNextVerificationChecklist_'))])
							: undefined,
					nurseVitalSignMeasurement: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nurseVitalSignMeasurement_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nurseVitalSignMeasurement_'))])
							: undefined,
					obstetricAndGynecologyHistory: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('obstetricAndGynecologyHistory_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('obstetricAndGynecologyHistory_'))])
							: undefined,
					odontogramExamination: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('odontogramExamination_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('odontogramExamination_'))])
							: undefined,
					operatingTheaterMedicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('operatingTheaterMedicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('operatingTheaterMedicalExaminationRecord_'))])
							: undefined,
					ophthalmologyExamination: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('ophthalmologyExamination_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('ophthalmologyExamination_'))])
							: undefined,
					doctor: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('doctor_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('doctor_'))])
							: undefined,
					medicalTranscriber: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalTranscriber_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalTranscriber_'))])
							: undefined,
					nurse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nurse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nurse_'))])
							: undefined,
					amendmentDetails: medicalExaminationRecordAmendmentDetailsModels.length > 0
							? medicalExaminationRecordAmendmentDetailsModels
							: undefined,
					coTreatingDoctors: medicalExaminationRecordCoTreatingDoctorsModels.length > 0
							? medicalExaminationRecordCoTreatingDoctorsModels
							: undefined,
					dailyCareCPPTs: medicalExaminationRecordDailyCareCPPTsModels.length > 0
							? medicalExaminationRecordDailyCareCPPTsModels
							: undefined,
					diagnosisExaminationRecords: medicalExaminationRecordDiagnosisExaminationRecordsModels.length > 0
							? medicalExaminationRecordDiagnosisExaminationRecordsModels
							: undefined,
					diagnosisNandas: medicalExaminationRecordDiagnosisNandasModels.length > 0
							? medicalExaminationRecordDiagnosisNandasModels
							: undefined,
					roomTransfers: medicalExaminationRecordRoomTransfersModels.length > 0
							? medicalExaminationRecordRoomTransfersModels
							: undefined,
				};

			case 'MedicalExaminationRecordDischargeSummaryModel':
				let medicalExaminationRecordDischargeSummaryDiagnosisExaminationRecordsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('diagnosisExaminationRecords_')).forEach(key => {
					medicalExaminationRecordDischargeSummaryDiagnosisExaminationRecordsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
					dischargingDoctor: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('dischargingDoctor_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('dischargingDoctor_'))])
							: undefined,
					diagnosisExaminationRecords: medicalExaminationRecordDischargeSummaryDiagnosisExaminationRecordsModels.length > 0
							? medicalExaminationRecordDischargeSummaryDiagnosisExaminationRecordsModels
							: undefined,
				};

			case 'MedicalFeeModel':
				let medicalFeeInvoiceItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoiceItems_')).forEach(key => {
					medicalFeeInvoiceItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalFeeMedicalFeeItemComponentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalFeeItemComponents_')).forEach(key => {
					medicalFeeMedicalFeeItemComponentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					invoiceItems: medicalFeeInvoiceItemsModels.length > 0
							? medicalFeeInvoiceItemsModels
							: undefined,
					medicalFeeItemComponents: medicalFeeMedicalFeeItemComponentsModels.length > 0
							? medicalFeeMedicalFeeItemComponentsModels
							: undefined,
				};

			case 'MedicalFeeItemComponentModel':
				return {
					medicalFee: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalFee_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalFee_'))])
							: undefined,
					priceComponent: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('priceComponent_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('priceComponent_'))])
							: undefined,
				};

			case 'MedicalRecordInitialChecklistModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'MedicalRecordNextVerificationChecklistModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'MedicalRecordUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'MedicalTranscriberUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'MedicationAdministeredHistoryModel':
				return {
					medicationItem: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationItem_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationItem_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
					medicationCompound: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationCompound_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationCompound_'))])
							: undefined,
				};

			case 'MedicationCompoundModel':
				let medicationCompoundMedicationAdministeredHistoriesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationAdministeredHistories_')).forEach(key => {
					medicationCompoundMedicationAdministeredHistoriesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicationCompoundMedicationItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationItems_')).forEach(key => {
					medicationCompoundMedicationItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					medicationHeader: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationHeader_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationHeader_'))])
							: undefined,
					unitOfMeasurement: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unitOfMeasurement_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unitOfMeasurement_'))])
							: undefined,
					medicationAdministeredHistories: medicationCompoundMedicationAdministeredHistoriesModels.length > 0
							? medicationCompoundMedicationAdministeredHistoriesModels
							: undefined,
					medicationItems: medicationCompoundMedicationItemsModels.length > 0
							? medicationCompoundMedicationItemsModels
							: undefined,
				};

			case 'MedicationHeaderModel':
				let medicationHeaderInvoiceItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoiceItems_')).forEach(key => {
					medicationHeaderInvoiceItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicationHeaderMedicationCompoundsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationCompounds_')).forEach(key => {
					medicationHeaderMedicationCompoundsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicationHeaderMedicationItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationItems_')).forEach(key => {
					medicationHeaderMedicationItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					invoice: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))])
							: undefined,
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					requestedBy: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('requestedBy_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('requestedBy_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					invoiceItems: medicationHeaderInvoiceItemsModels.length > 0
							? medicationHeaderInvoiceItemsModels
							: undefined,
					medicationCompounds: medicationHeaderMedicationCompoundsModels.length > 0
							? medicationHeaderMedicationCompoundsModels
							: undefined,
					medicationItems: medicationHeaderMedicationItemsModels.length > 0
							? medicationHeaderMedicationItemsModels
							: undefined,
				};

			case 'MedicationItemModel':
				let medicationItemMedicationAdministeredHisotriesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationAdministeredHisotries_')).forEach(key => {
					medicationItemMedicationAdministeredHisotriesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					medicationCompound: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationCompound_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationCompound_'))])
							: undefined,
					medicationHeader: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationHeader_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicationHeader_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					unitOfMeasurement: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unitOfMeasurement_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unitOfMeasurement_'))])
							: undefined,
					medicationAdministeredHisotries: medicationItemMedicationAdministeredHisotriesModels.length > 0
							? medicationItemMedicationAdministeredHisotriesModels
							: undefined,
				};

			case 'MerchantModel':
				let merchantCashReceiptsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('cashReceipts_')).forEach(key => {
					merchantCashReceiptsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let merchantMerchantSurchargeAndFeesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('merchantSurchargeAndFees_')).forEach(key => {
					merchantMerchantSurchargeAndFeesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					cashReceipts: merchantCashReceiptsModels.length > 0
							? merchantCashReceiptsModels
							: undefined,
					merchantSurchargeAndFees: merchantMerchantSurchargeAndFeesModels.length > 0
							? merchantMerchantSurchargeAndFeesModels
							: undefined,
				};

			case 'MerchantSurchargeAndFeeModel':
				return {
					merchant: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('merchant_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('merchant_'))])
							: undefined,
				};

			case 'NhisClaimModel':
				return {
				};

			case 'NhisClaimGDRGDetailModel':
				return {
				};

			case 'NhisClaimInvestigationDetailModel':
				return {
				};

			case 'NhisGDRGModel':
				return {
				};

			case 'NhisInvestigationModel':
				return {
				};

			case 'NhisMedicineModel':
				return {
				};

			case 'NhisServiceOutcomeModel':
				return {
				};

			case 'NhisSpecialtyAttendedModel':
				return {
				};

			case 'NhisTypeOfServiceModel':
				return {
				};

			case 'NewbornDetailModel':
				let newbornDetailVitalSignsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('vitalSigns_')).forEach(key => {
					newbornDetailVitalSignsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					deliveryMedicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('deliveryMedicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('deliveryMedicalExaminationRecord_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
					vitalSigns: newbornDetailVitalSignsModels.length > 0
							? newbornDetailVitalSignsModels
							: undefined,
				};

			case 'NumberingSetupModel':
				return {
				};

			case 'NurseUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'NurseVitalSignMeasurementModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'ObstetricAndGynecologyHistoryModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'OdontogramExaminationModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'OperatingTheaterMedicalExaminationRecordModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
					intraoperativeRecords: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('intraoperativeRecords_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('intraoperativeRecords_'))])
							: undefined,
					postOperativeDetails: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('postOperativeDetails_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('postOperativeDetails_'))])
							: undefined,
					preoperativeRecords: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('preoperativeRecords_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('preoperativeRecords_'))])
							: undefined,
					nursingAnesthesiaDetail: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nursingAnesthesiaDetail_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nursingAnesthesiaDetail_'))])
							: undefined,
					nursingDetailSurgicalNursings: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nursingDetailSurgicalNursings_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nursingDetailSurgicalNursings_'))])
							: undefined,
					nursingDetailsAnesthesiaNursings: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nursingDetailsAnesthesiaNursings_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nursingDetailsAnesthesiaNursings_'))])
							: undefined,
					nursingSurgicalDetail: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nursingSurgicalDetail_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nursingSurgicalDetail_'))])
							: undefined,
				};

			case 'OphthalmologyExaminationModel':
				return {
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
				};

			case 'PcareActionExaminationModel':
				return {
					pcareExamination: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareExamination_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareExamination_'))])
							: undefined,
				};

			case 'PcareClubProlanisModel':
				return {
				};

			case 'PcareCompoundDrugModel':
				let pcareCompoundDrugPcareCompoundDrugItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('pcareCompoundDrugItems_')).forEach(key => {
					pcareCompoundDrugPcareCompoundDrugItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					pcareExamination: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareExamination_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareExamination_'))])
							: undefined,
					pcareCompoundDrugItems: pcareCompoundDrugPcareCompoundDrugItemsModels.length > 0
							? pcareCompoundDrugPcareCompoundDrugItemsModels
							: undefined,
				};

			case 'PcareCompoundDrugItemModel':
				return {
					pcareCompoundDrug: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareCompoundDrug_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareCompoundDrug_'))])
							: undefined,
				};

			case 'PcareDiagnosaModel':
				return {
				};

			case 'PcareDokterModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'PcareExaminationModel':
				let pcareExaminationPcareActionExaminationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('pcareActionExaminations_')).forEach(key => {
					pcareExaminationPcareActionExaminationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let pcareExaminationPcareCompoundDrugsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('pcareCompoundDrugs_')).forEach(key => {
					pcareExaminationPcareCompoundDrugsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let pcareExaminationPcareNonCompoundDrugsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('pcareNonCompoundDrugs_')).forEach(key => {
					pcareExaminationPcareNonCompoundDrugsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					pcareActionExaminations: pcareExaminationPcareActionExaminationsModels.length > 0
							? pcareExaminationPcareActionExaminationsModels
							: undefined,
					pcareCompoundDrugs: pcareExaminationPcareCompoundDrugsModels.length > 0
							? pcareExaminationPcareCompoundDrugsModels
							: undefined,
					pcareNonCompoundDrugs: pcareExaminationPcareNonCompoundDrugsModels.length > 0
							? pcareExaminationPcareNonCompoundDrugsModels
							: undefined,
				};

			case 'PcareMCUModel':
				return {
				};

			case 'PcareNonCompoundDrugModel':
				return {
					pcareExamination: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareExamination_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareExamination_'))])
							: undefined,
				};

			case 'PcareReferensiSaranaModel':
				return {
				};

			case 'PcareStatusPulangModel':
				return {
				};

			case 'PcareTindakanModel':
				return {
				};

			case 'PcareUmumModel':
				return {
				};

			case 'PatientCaseHistoryModel':
				return {
					patientGeneralInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))])
							: undefined,
				};

			case 'PatientConsentModel':
				return {
					patientGeneralInfo: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'PatientContactInfoModel':
				return {
					patientGeneralInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))])
							: undefined,
				};

			case 'PatientDetailModel':
				return {
					patientGeneralInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))])
							: undefined,
				};

			case 'PatientDetailAddressModel':
				return {
					patientGeneralInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))])
							: undefined,
				};

			case 'PatientEmergencyContactDetailModel':
				return {
					patientGeneralInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))])
							: undefined,
				};

			case 'PatientEmploymentDetailModel':
				return {
					patientGeneralInfo: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))])
							: undefined,
				};

			case 'PatientGeneralInfoModel':
				let patientGeneralInfoBpjsClaimSubmissionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsClaimSubmissions_')).forEach(key => {
					patientGeneralInfoBpjsClaimSubmissionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientGeneralInfoCashRefundsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('cashRefunds_')).forEach(key => {
					patientGeneralInfoCashRefundsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientGeneralInfoInformedConsentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('informedConsents_')).forEach(key => {
					patientGeneralInfoInformedConsentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientInvoiceReceiptsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoiceReceipts_')).forEach(key => {
					patientInvoiceReceiptsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientGeneralInformationPatientCaseHistoriesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('patientCaseHistories_')).forEach(key => {
					patientGeneralInformationPatientCaseHistoriesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientGeneralInfoPatientConsentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('patientConsents_')).forEach(key => {
					patientGeneralInfoPatientConsentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientGeneralInformationPatientFinalizeProfilesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('patientFinalizeProfiles_')).forEach(key => {
					patientGeneralInformationPatientFinalizeProfilesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientGeneralInfoRetailPharmaciesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('retailPharmacies_')).forEach(key => {
					patientGeneralInfoRetailPharmaciesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientVisitsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('visits_')).forEach(key => {
					patientVisitsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					patientContactInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientContactInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientContactInformation_'))])
							: undefined,
					patientDetailAddress: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientDetailAddress_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientDetailAddress_'))])
							: undefined,
					patientDetail: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientDetail_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientDetail_'))])
							: undefined,
					patientEmergencyContactDetail: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientEmergencyContactDetail_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientEmergencyContactDetail_'))])
							: undefined,
					patientEmploymentDetail: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientEmploymentDetail_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientEmploymentDetail_'))])
							: undefined,
					patientPaymentBPJS: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentBPJS_'))])
							: undefined,
					patientPaymentTypeInsurance: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentTypeInsurance_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentTypeInsurance_'))])
							: undefined,
					patientPaymentTypeOthers: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentTypeOthers_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPaymentTypeOthers_'))])
							: undefined,
					patientPersonalInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPersonalInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientPersonalInformation_'))])
							: undefined,
					patientSelfPaying: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientSelfPaying_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientSelfPaying_'))])
							: undefined,
					bpjsClaimSubmissions: patientGeneralInfoBpjsClaimSubmissionsModels.length > 0
							? patientGeneralInfoBpjsClaimSubmissionsModels
							: undefined,
					cashRefunds: patientGeneralInfoCashRefundsModels.length > 0
							? patientGeneralInfoCashRefundsModels
							: undefined,
					informedConsents: patientGeneralInfoInformedConsentsModels.length > 0
							? patientGeneralInfoInformedConsentsModels
							: undefined,
					invoiceReceipts: patientInvoiceReceiptsModels.length > 0
							? patientInvoiceReceiptsModels
							: undefined,
					patientCaseHistories: patientGeneralInformationPatientCaseHistoriesModels.length > 0
							? patientGeneralInformationPatientCaseHistoriesModels
							: undefined,
					patientConsents: patientGeneralInfoPatientConsentsModels.length > 0
							? patientGeneralInfoPatientConsentsModels
							: undefined,
					patientFinalizeProfiles: patientGeneralInformationPatientFinalizeProfilesModels.length > 0
							? patientGeneralInformationPatientFinalizeProfilesModels
							: undefined,
					retailPharmacies: patientGeneralInfoRetailPharmaciesModels.length > 0
							? patientGeneralInfoRetailPharmaciesModels
							: undefined,
					visits: patientVisitsModels.length > 0
							? patientVisitsModels
							: undefined,
				};

			case 'PatientPaymentSelfPayingModel':
				return {
					patientGeneralInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))])
							: undefined,
				};

			case 'PatientPaymentBPJSModel':
				let patientPaymentBPJSBpjsAccidentMastersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsAccidentMasters_')).forEach(key => {
					patientPaymentBPJSBpjsAccidentMastersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientPaymentBPJSBpjsClaimSubmissionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsClaimSubmissions_')).forEach(key => {
					patientPaymentBPJSBpjsClaimSubmissionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientPaymentBPJSBpjsHospitalizationPlansModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsHospitalizationPlans_')).forEach(key => {
					patientPaymentBPJSBpjsHospitalizationPlansModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientPaymentBPJSBpjsJasaRaharjasModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsJasaRaharjas_')).forEach(key => {
					patientPaymentBPJSBpjsJasaRaharjasModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientPaymentBPJSBpjsPatientReferralsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsPatientReferrals_')).forEach(key => {
					patientPaymentBPJSBpjsPatientReferralsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientPaymentBPJSBpjsSEPSubmissionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsSEPSubmissions_')).forEach(key => {
					patientPaymentBPJSBpjsSEPSubmissionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientPaymentBPJSBpjsSEPsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsSEPs_')).forEach(key => {
					patientPaymentBPJSBpjsSEPsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					patientGeneralInfo: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))])
							: undefined,
					bpjsAccidentMasters: patientPaymentBPJSBpjsAccidentMastersModels.length > 0
							? patientPaymentBPJSBpjsAccidentMastersModels
							: undefined,
					bpjsClaimSubmissions: patientPaymentBPJSBpjsClaimSubmissionsModels.length > 0
							? patientPaymentBPJSBpjsClaimSubmissionsModels
							: undefined,
					bpjsHospitalizationPlans: patientPaymentBPJSBpjsHospitalizationPlansModels.length > 0
							? patientPaymentBPJSBpjsHospitalizationPlansModels
							: undefined,
					bpjsJasaRaharjas: patientPaymentBPJSBpjsJasaRaharjasModels.length > 0
							? patientPaymentBPJSBpjsJasaRaharjasModels
							: undefined,
					bpjsPatientReferrals: patientPaymentBPJSBpjsPatientReferralsModels.length > 0
							? patientPaymentBPJSBpjsPatientReferralsModels
							: undefined,
					bpjsSEPSubmissions: patientPaymentBPJSBpjsSEPSubmissionsModels.length > 0
							? patientPaymentBPJSBpjsSEPSubmissionsModels
							: undefined,
					bpjsSEPs: patientPaymentBPJSBpjsSEPsModels.length > 0
							? patientPaymentBPJSBpjsSEPsModels
							: undefined,
				};

			case 'PatientPaymentInsuranceModel':
				return {
					patientGeneralInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))])
							: undefined,
					insuranceBenefitPlan: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('insuranceBenefitPlan_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('insuranceBenefitPlan_'))])
							: undefined,
				};

			case 'PatientPaymentOthersModel':
				return {
					patientGeneralInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))])
							: undefined,
				};

			case 'PatientPersonalInfoModel':
				return {
					patientGeneralInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))])
							: undefined,
				};

			case 'PatientSupportingDocumentModel':
				return {
					patientGeneralInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInformation_'))])
							: undefined,
				};

			case 'PatientVisitModel':
				let patientVisitBpjsVisitDatasModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsVisitDatas_')).forEach(key => {
					patientVisitBpjsVisitDatasModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientVisitBpjsPcarePendaftaransModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bpjsPcarePendaftarans_')).forEach(key => {
					patientVisitBpjsPcarePendaftaransModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientVisitInvoicesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoices_')).forEach(key => {
					patientVisitInvoicesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let patientVisitRegistrationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('registrations_')).forEach(key => {
					patientVisitRegistrationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					bpjsPcareRegistrations: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsPcareRegistrations_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsPcareRegistrations_'))])
							: undefined,
					patientVisitPatientPaymentInsurance: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisitPatientPaymentInsurance_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisitPatientPaymentInsurance_'))])
							: undefined,
					patientVisitPatientPaymentOthers: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisitPatientPaymentOthers_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisitPatientPaymentOthers_'))])
							: undefined,
					patientVisitPaymentSelfPaying: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisitPaymentSelfPaying_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisitPaymentSelfPaying_'))])
							: undefined,
					patient: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patient_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patient_'))])
							: undefined,
					bpjsVisitDatas: patientVisitBpjsVisitDatasModels.length > 0
							? patientVisitBpjsVisitDatasModels
							: undefined,
					bpjsPcarePendaftarans: patientVisitBpjsPcarePendaftaransModels.length > 0
							? patientVisitBpjsPcarePendaftaransModels
							: undefined,
					invoices: patientVisitInvoicesModels.length > 0
							? patientVisitInvoicesModels
							: undefined,
					registrations: patientVisitRegistrationsModels.length > 0
							? patientVisitRegistrationsModels
							: undefined,
				};

			case 'PatientVisitPatientPaymentInsuranceModel':
				return {
					patientVisit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))])
							: undefined,
					insuranceBenefitPlan: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('insuranceBenefitPlan_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('insuranceBenefitPlan_'))])
							: undefined,
				};

			case 'PatientVisitPatientPaymentOthersModel':
				return {
					patientVisit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))])
							: undefined,
				};

			case 'PatientVisitPaymentSelfPayingModel':
				return {
					patientVisit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))])
							: undefined,
				};

			case 'PatientVitalInformationModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'PharmacySetupModel':
				return {
				};

			case 'PharmacyUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'PostOperativeDetailsModel':
				let postOperativeDetailsBedFacilitiesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bedFacilities_')).forEach(key => {
					postOperativeDetailsBedFacilitiesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					operatingTheaterMedicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('operatingTheaterMedicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('operatingTheaterMedicalExaminationRecord_'))])
							: undefined,
					postOperativeICD10: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('postOperativeICD10_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('postOperativeICD10_'))])
							: undefined,
					postOperativeICD9CM: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('postOperativeICD9CM_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('postOperativeICD9CM_'))])
							: undefined,
					recoveryRooms: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('recoveryRooms_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('recoveryRooms_'))])
							: undefined,
					bedFacilities: postOperativeDetailsBedFacilitiesModels.length > 0
							? postOperativeDetailsBedFacilitiesModels
							: undefined,
				};

			case 'PreoperativeRecordsModel':
				let additionalAnesthesiologistAdditionalAnesthesiologistsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('additionalAnesthesiologists_')).forEach(key => {
					additionalAnesthesiologistAdditionalAnesthesiologistsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let additionalSurgeryNurseAdditionalSurgeryNursesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('additionalSurgeryNurses_')).forEach(key => {
					additionalSurgeryNurseAdditionalSurgeryNursesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let preoperativeRecordsBedFacilitiesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bedFacilities_')).forEach(key => {
					preoperativeRecordsBedFacilitiesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let coTreatingAnesthesiologistCoTreatingAnesthesiologistsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('coTreatingAnesthesiologists_')).forEach(key => {
					coTreatingAnesthesiologistCoTreatingAnesthesiologistsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let coTreatingSurgeonCoTreatingSurgeonsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('coTreatingSurgeons_')).forEach(key => {
					coTreatingSurgeonCoTreatingSurgeonsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					operatingTheaterMedicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('operatingTheaterMedicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('operatingTheaterMedicalExaminationRecord_'))])
							: undefined,
					anesthesiaMedicalTranscriber: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('anesthesiaMedicalTranscriber_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('anesthesiaMedicalTranscriber_'))])
							: undefined,
					anesthesiologist: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('anesthesiologist_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('anesthesiologist_'))])
							: undefined,
					anesthesiologyNurse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('anesthesiologyNurse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('anesthesiologyNurse_'))])
							: undefined,
					preSurgeryICD10: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('preSurgeryICD10_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('preSurgeryICD10_'))])
							: undefined,
					preSurgeryICD9CM: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('preSurgeryICD9CM_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('preSurgeryICD9CM_'))])
							: undefined,
					preoperativeRooms: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('preoperativeRooms_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('preoperativeRooms_'))])
							: undefined,
					surgeon: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('surgeon_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('surgeon_'))])
							: undefined,
					surgicalMedicalTranscriber: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('surgicalMedicalTranscriber_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('surgicalMedicalTranscriber_'))])
							: undefined,
					surgicalNurse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('surgicalNurse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('surgicalNurse_'))])
							: undefined,
					additionalAnesthesiologists: additionalAnesthesiologistAdditionalAnesthesiologistsModels.length > 0
							? additionalAnesthesiologistAdditionalAnesthesiologistsModels
							: undefined,
					additionalSurgeryNurses: additionalSurgeryNurseAdditionalSurgeryNursesModels.length > 0
							? additionalSurgeryNurseAdditionalSurgeryNursesModels
							: undefined,
					bedFacilities: preoperativeRecordsBedFacilitiesModels.length > 0
							? preoperativeRecordsBedFacilitiesModels
							: undefined,
					coTreatingAnesthesiologists: coTreatingAnesthesiologistCoTreatingAnesthesiologistsModels.length > 0
							? coTreatingAnesthesiologistCoTreatingAnesthesiologistsModels
							: undefined,
					coTreatingSurgeons: coTreatingSurgeonCoTreatingSurgeonsModels.length > 0
							? coTreatingSurgeonCoTreatingSurgeonsModels
							: undefined,
				};

			case 'PrescriptionCompoundModel':
				let compoundCompoundItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('compoundItems_')).forEach(key => {
					compoundCompoundItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					unit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unit_'))])
							: undefined,
					prescriptionHeader: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('prescriptionHeader_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('prescriptionHeader_'))])
							: undefined,
					compoundItems: compoundCompoundItemsModels.length > 0
							? compoundCompoundItemsModels
							: undefined,
				};

			case 'PrescriptionHeaderModel':
				let prescriptionInvoiceItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoiceItems_')).forEach(key => {
					prescriptionInvoiceItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let prescriptionHeaderPrescriptionCompoundsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('prescriptionCompounds_')).forEach(key => {
					prescriptionHeaderPrescriptionCompoundsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let prescriptionPrescriptionItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('prescriptionItems_')).forEach(key => {
					prescriptionPrescriptionItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					invoice: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoice_'))])
							: undefined,
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					requestedBy: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('requestedBy_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('requestedBy_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					invoiceItems: prescriptionInvoiceItemsModels.length > 0
							? prescriptionInvoiceItemsModels
							: undefined,
					prescriptionCompounds: prescriptionHeaderPrescriptionCompoundsModels.length > 0
							? prescriptionHeaderPrescriptionCompoundsModels
							: undefined,
					prescriptionItems: prescriptionPrescriptionItemsModels.length > 0
							? prescriptionPrescriptionItemsModels
							: undefined,
				};

			case 'PrescriptionItemModel':
				return {
					compound: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('compound_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('compound_'))])
							: undefined,
					stockCatalogueId: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogueId_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogueId_'))])
							: undefined,
					prescription: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('prescription_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('prescription_'))])
							: undefined,
					unit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('unit_'))])
							: undefined,
				};

			case 'PriceComponentModel':
				let priceComponentInvoiceItemComponentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoiceItemComponents_')).forEach(key => {
					priceComponentInvoiceItemComponentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let priceComponentMedicalFeeItemComponentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalFeeItemComponents_')).forEach(key => {
					priceComponentMedicalFeeItemComponentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let priceComponentTariffDefinitionOtherComponentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('tariffDefinitionOtherComponents_')).forEach(key => {
					priceComponentTariffDefinitionOtherComponentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					invoiceItemComponents: priceComponentInvoiceItemComponentsModels.length > 0
							? priceComponentInvoiceItemComponentsModels
							: undefined,
					medicalFeeItemComponents: priceComponentMedicalFeeItemComponentsModels.length > 0
							? priceComponentMedicalFeeItemComponentsModels
							: undefined,
					tariffDefinitionOtherComponents: priceComponentTariffDefinitionOtherComponentsModels.length > 0
							? priceComponentTariffDefinitionOtherComponentsModels
							: undefined,
				};

			case 'PrivilegeModel':
				let privilegesRolesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('roles_')).forEach(key => {
					privilegesRolesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					roles: privilegesRolesModels.length > 0
							? privilegesRolesModels
							: undefined,
				};

			case 'ProcessWorkflowModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'PurchaseOrderModel':
				let purchaseOrderPurchaseOrderStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('purchaseOrderStockDetails_')).forEach(key => {
					purchaseOrderPurchaseOrderStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let purchaseOrderPurchaseRequisitionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('purchaseRequisitions_')).forEach(key => {
					purchaseOrderPurchaseRequisitionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let purchaseOrderReturnSuppliersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('returnSuppliers_')).forEach(key => {
					purchaseOrderReturnSuppliersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					goodsReceiveNote: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('goodsReceiveNote_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('goodsReceiveNote_'))])
							: undefined,
					supplier: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					purchaseOrderStockDetails: purchaseOrderPurchaseOrderStockDetailsModels.length > 0
							? purchaseOrderPurchaseOrderStockDetailsModels
							: undefined,
					purchaseRequisitions: purchaseOrderPurchaseRequisitionsModels.length > 0
							? purchaseOrderPurchaseRequisitionsModels
							: undefined,
					returnSuppliers: purchaseOrderReturnSuppliersModels.length > 0
							? purchaseOrderReturnSuppliersModels
							: undefined,
				};

			case 'PurchaseOrderStockDetailModel':
				let purchaseOrderStockDetailGoodsReceiveNoteItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('goodsReceiveNoteItems_')).forEach(key => {
					purchaseOrderStockDetailGoodsReceiveNoteItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					purchaseOrder: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseOrder_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseOrder_'))])
							: undefined,
					purchaseRequisitionStockDetail: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseRequisitionStockDetail_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseRequisitionStockDetail_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					goodsReceiveNoteItems: purchaseOrderStockDetailGoodsReceiveNoteItemsModels.length > 0
							? purchaseOrderStockDetailGoodsReceiveNoteItemsModels
							: undefined,
				};

			case 'PurchaseRequisitionModel':
				let purchaseRequisitionPurchaseRequisitionStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('purchaseRequisitionStockDetails_')).forEach(key => {
					purchaseRequisitionPurchaseRequisitionStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					purchaseOrder: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseOrder_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseOrder_'))])
							: undefined,
					supplier: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					purchaseRequisitionStockDetails: purchaseRequisitionPurchaseRequisitionStockDetailsModels.length > 0
							? purchaseRequisitionPurchaseRequisitionStockDetailsModels
							: undefined,
				};

			case 'PurchaseRequisitionStockDetailModel':
				let purchaseRequisitionStockDetailPurchaseOrderStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('purchaseOrderStockDetails_')).forEach(key => {
					purchaseRequisitionStockDetailPurchaseOrderStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					purchaseRequisition: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseRequisition_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseRequisition_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					purchaseOrderStockDetails: purchaseRequisitionStockDetailPurchaseOrderStockDetailsModels.length > 0
							? purchaseRequisitionStockDetailPurchaseOrderStockDetailsModels
							: undefined,
				};

			case 'PurchasingUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'ReferenceDataModel':
				return {
				};

			case 'ReferenceHeaderModel':
				return {
				};

			case 'RegistrationModel':
				let registrationBedReservesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bedReserves_')).forEach(key => {
					registrationBedReservesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let registrationDiagnosticExaminationResultsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('diagnosticExaminationResults_')).forEach(key => {
					registrationDiagnosticExaminationResultsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let registrationFluidBalanceDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('fluidBalanceDetails_')).forEach(key => {
					registrationFluidBalanceDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let registrationInformedConsentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('informedConsents_')).forEach(key => {
					registrationInformedConsentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let serviceNumberInvoiceItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoiceItems_')).forEach(key => {
					serviceNumberInvoiceItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let registrationMedicalFeesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalFees_')).forEach(key => {
					registrationMedicalFeesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let registrationMedicationHeadersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationHeaders_')).forEach(key => {
					registrationMedicationHeadersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let registrationPatientVitalInformationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('patientVitalInformations_')).forEach(key => {
					registrationPatientVitalInformationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let registrationPrescriptionHeadersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('prescriptionHeaders_')).forEach(key => {
					registrationPrescriptionHeadersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let registrationSampleCollectionInformationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('sampleCollectionInformations_')).forEach(key => {
					registrationSampleCollectionInformationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let registrationVaccinationOrdersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('vaccinationOrders_')).forEach(key => {
					registrationVaccinationOrdersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let registrationsExaminationItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('examinationItems_')).forEach(key => {
					registrationsExaminationItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					diagnosticStaffExaminationSummary: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosticStaffExaminationSummary_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosticStaffExaminationSummary_'))])
							: undefined,
					bpjsPRBDetail: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsPRBDetail_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsPRBDetail_'))])
							: undefined,
					bpjsPcareRegistrations: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsPcareRegistrations_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsPcareRegistrations_'))])
							: undefined,
					bpjsSEP: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsSEP_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsSEP_'))])
							: undefined,
					medicalCertificateDischargeResume: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateDischargeResume_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateDischargeResume_'))])
							: undefined,
					medicalCertificateBirth: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateBirth_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateBirth_'))])
							: undefined,
					medicalCertificateHospitalization: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateHospitalization_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateHospitalization_'))])
							: undefined,
					medicalCertificateMedicalAttendance: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateMedicalAttendance_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateMedicalAttendance_'))])
							: undefined,
					medicalCertificateMentalHealth: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateMentalHealth_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateMentalHealth_'))])
							: undefined,
					medicalCertificatePhysicalHealth: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificatePhysicalHealth_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificatePhysicalHealth_'))])
							: undefined,
					medicalCertificateRestrictedWork: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateRestrictedWork_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateRestrictedWork_'))])
							: undefined,
					medicalCertificateSickLeave: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateSickLeave_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalCertificateSickLeave_'))])
							: undefined,
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
					pcareExamination: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareExamination_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareExamination_'))])
							: undefined,
					sep: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sep_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sep_'))])
							: undefined,
					admissionICD10: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('admissionICD10_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('admissionICD10_'))])
							: undefined,
					admissionICD9CM: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('admissionICD9CM_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('admissionICD9CM_'))])
							: undefined,
					dismissalReferringFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('dismissalReferringFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('dismissalReferringFacility_'))])
							: undefined,
					dismissalReferringStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('dismissalReferringStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('dismissalReferringStaff_'))])
							: undefined,
					referringUnit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('referringUnit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('referringUnit_'))])
							: undefined,
					referringFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('referringFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('referringFacility_'))])
							: undefined,
					bedFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bedFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bedFacility_'))])
							: undefined,
					patientVisit: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientVisit_'))])
							: undefined,
					service: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
					requestedBy: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('requestedBy_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('requestedBy_'))])
							: undefined,
					bedReserves: registrationBedReservesModels.length > 0
							? registrationBedReservesModels
							: undefined,
					diagnosticExaminationResults: registrationDiagnosticExaminationResultsModels.length > 0
							? registrationDiagnosticExaminationResultsModels
							: undefined,
					fluidBalanceDetails: registrationFluidBalanceDetailsModels.length > 0
							? registrationFluidBalanceDetailsModels
							: undefined,
					informedConsents: registrationInformedConsentsModels.length > 0
							? registrationInformedConsentsModels
							: undefined,
					invoiceItems: serviceNumberInvoiceItemsModels.length > 0
							? serviceNumberInvoiceItemsModels
							: undefined,
					medicalFees: registrationMedicalFeesModels.length > 0
							? registrationMedicalFeesModels
							: undefined,
					medicationHeaders: registrationMedicationHeadersModels.length > 0
							? registrationMedicationHeadersModels
							: undefined,
					patientVitalInformations: registrationPatientVitalInformationsModels.length > 0
							? registrationPatientVitalInformationsModels
							: undefined,
					prescriptionHeaders: registrationPrescriptionHeadersModels.length > 0
							? registrationPrescriptionHeadersModels
							: undefined,
					sampleCollectionInformations: registrationSampleCollectionInformationsModels.length > 0
							? registrationSampleCollectionInformationsModels
							: undefined,
					vaccinationOrders: registrationVaccinationOrdersModels.length > 0
							? registrationVaccinationOrdersModels
							: undefined,
					examinationItems: registrationsExaminationItemsModels.length > 0
							? registrationsExaminationItemsModels
							: undefined,
				};

			case 'RegistrationUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'RetailPharmacyModel':
				let retailPharmacyRetailPharmacyInvoicesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('retailPharmacyInvoices_')).forEach(key => {
					retailPharmacyRetailPharmacyInvoicesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let retailPharmacyRetailPharmacyStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('retailPharmacyStockDetails_')).forEach(key => {
					retailPharmacyRetailPharmacyStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					patientGeneralInfo: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('patientGeneralInfo_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					retailPharmacyInvoices: retailPharmacyRetailPharmacyInvoicesModels.length > 0
							? retailPharmacyRetailPharmacyInvoicesModels
							: undefined,
					retailPharmacyStockDetails: retailPharmacyRetailPharmacyStockDetailsModels.length > 0
							? retailPharmacyRetailPharmacyStockDetailsModels
							: undefined,
				};

			case 'RetailPharmacyInvoiceModel':
				let retailPharmacyInvoiceCashReceiptsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('cashReceipts_')).forEach(key => {
					retailPharmacyInvoiceCashReceiptsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let retailPharmacyInvoiceInvoiceItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoiceItems_')).forEach(key => {
					retailPharmacyInvoiceInvoiceItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					invoiceSummary: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoiceSummary_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('invoiceSummary_'))])
							: undefined,
					retailPharmacy: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('retailPharmacy_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('retailPharmacy_'))])
							: undefined,
					cashReceipts: retailPharmacyInvoiceCashReceiptsModels.length > 0
							? retailPharmacyInvoiceCashReceiptsModels
							: undefined,
					invoiceItems: retailPharmacyInvoiceInvoiceItemsModels.length > 0
							? retailPharmacyInvoiceInvoiceItemsModels
							: undefined,
				};

			case 'RetailPharmacyStockDetailModel':
				return {
					retailPharmacy: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('retailPharmacy_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('retailPharmacy_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
				};

			case 'ReturnSupplierModel':
				let returnSupplierReturnSupplierStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('returnSupplierStockDetails_')).forEach(key => {
					returnSupplierReturnSupplierStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					purchaseOrder: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseOrder_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchaseOrder_'))])
							: undefined,
					supplier: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					returnSupplierStockDetails: returnSupplierReturnSupplierStockDetailsModels.length > 0
							? returnSupplierReturnSupplierStockDetailsModels
							: undefined,
				};

			case 'ReturnSupplierStockDetailModel':
				return {
					returnSupplier: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('returnSupplier_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('returnSupplier_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
				};

			case 'RoleModel':
				let rolesPrivilegesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('privileges_')).forEach(key => {
					rolesPrivilegesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let rolesUsersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('users_')).forEach(key => {
					rolesUsersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					privileges: rolesPrivilegesModels.length > 0
							? rolesPrivilegesModels
							: undefined,
					users: rolesUsersModels.length > 0
							? rolesUsersModels
							: undefined,
				};

			case 'RoomFacilityModel':
				let roomFacilityBedFacilitiesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('bedFacilities_')).forEach(key => {
					roomFacilityBedFacilitiesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let operatingRoomOperatingRoomModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('operatingRoom_')).forEach(key => {
					operatingRoomOperatingRoomModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let preoperativeRoomsPreoperativeRoomsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('preoperativeRooms_')).forEach(key => {
					preoperativeRoomsPreoperativeRoomsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let recoveryRoomsRecoveryRoomsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('recoveryRooms_')).forEach(key => {
					recoveryRoomsRecoveryRoomsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					bedFacilities: roomFacilityBedFacilitiesModels.length > 0
							? roomFacilityBedFacilitiesModels
							: undefined,
					operatingRoom: operatingRoomOperatingRoomModels.length > 0
							? operatingRoomOperatingRoomModels
							: undefined,
					preoperativeRooms: preoperativeRoomsPreoperativeRoomsModels.length > 0
							? preoperativeRoomsPreoperativeRoomsModels
							: undefined,
					recoveryRooms: recoveryRoomsRecoveryRoomsModels.length > 0
							? recoveryRoomsRecoveryRoomsModels
							: undefined,
				};

			case 'RoomTransferModel':
				return {
					bedFacility: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bedFacility_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bedFacility_'))])
							: undefined,
					medicalExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalExaminationRecord_'))])
							: undefined,
					transferringStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transferringStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transferringStaff_'))])
							: undefined,
				};

			case 'SepModel':
				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
				};

			case 'SampleCollectionInformationModel':
				let sampleCollectionInformationSampleCollectionItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('sampleCollectionItems_')).forEach(key => {
					sampleCollectionInformationSampleCollectionItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					diagnosisExaminationRecord: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosisExaminationRecord_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosisExaminationRecord_'))])
							: undefined,
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					sampleCollectionItems: sampleCollectionInformationSampleCollectionItemsModels.length > 0
							? sampleCollectionInformationSampleCollectionItemsModels
							: undefined,
				};

			case 'SampleCollectionItemsModel':
				return {
					sampleCollectionInformation: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sampleCollectionInformation_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sampleCollectionInformation_'))])
							: undefined,
					sampleCollectionStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sampleCollectionStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sampleCollectionStaff_'))])
							: undefined,
					sampleDeliveryStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sampleDeliveryStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sampleDeliveryStaff_'))])
							: undefined,
					sampleProcessingStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sampleProcessingStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sampleProcessingStaff_'))])
							: undefined,
				};

			case 'SatuSehatConfigurationModel':
				return {
				};

			case 'ServiceModel':
				let serviceDoctorSchedulesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('doctorSchedules_')).forEach(key => {
					serviceDoctorSchedulesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let serviceExaminationGroupsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('examinationGroups_')).forEach(key => {
					serviceExaminationGroupsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let serviceMcuPackageItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('mcuPackageItems_')).forEach(key => {
					serviceMcuPackageItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let referringUnitReferringUnitModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('referringUnit_')).forEach(key => {
					referringUnitReferringUnitModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let serviceRegistrationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('registrations_')).forEach(key => {
					serviceRegistrationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let serviceServiceFacilityCategoriesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('serviceFacilityCategories_')).forEach(key => {
					serviceServiceFacilityCategoriesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let servicesServiceItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('serviceItems_')).forEach(key => {
					servicesServiceItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let servicesAssignedMedicalStaffModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('assignedMedicalStaff_')).forEach(key => {
					servicesAssignedMedicalStaffModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					defaultMedicalStaff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('defaultMedicalStaff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('defaultMedicalStaff_'))])
							: undefined,
					bpjsPcarePoli: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsPcarePoli_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsPcarePoli_'))])
							: undefined,
					bpjsServiceMapping: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsServiceMapping_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsServiceMapping_'))])
							: undefined,
					doctorSchedules: serviceDoctorSchedulesModels.length > 0
							? serviceDoctorSchedulesModels
							: undefined,
					examinationGroups: serviceExaminationGroupsModels.length > 0
							? serviceExaminationGroupsModels
							: undefined,
					mcuPackageItems: serviceMcuPackageItemsModels.length > 0
							? serviceMcuPackageItemsModels
							: undefined,
					referringUnit: referringUnitReferringUnitModels.length > 0
							? referringUnitReferringUnitModels
							: undefined,
					registrations: serviceRegistrationsModels.length > 0
							? serviceRegistrationsModels
							: undefined,
					serviceFacilityCategories: serviceServiceFacilityCategoriesModels.length > 0
							? serviceServiceFacilityCategoriesModels
							: undefined,
					serviceItems: servicesServiceItemsModels.length > 0
							? servicesServiceItemsModels
							: undefined,
					assignedMedicalStaff: servicesAssignedMedicalStaffModels.length > 0
							? servicesAssignedMedicalStaffModels
							: undefined,
				};

			case 'ServiceFacilityCategoryModel':
				return {
					service: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))])
							: undefined,
				};

			case 'ServiceItemModel':
				let serviceItemExaminationItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('examinationItems_')).forEach(key => {
					serviceItemExaminationItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let serviceItemServiceItemAssignmentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('serviceItemAssignments_')).forEach(key => {
					serviceItemServiceItemAssignmentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let serviceItemsServicesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('services_')).forEach(key => {
					serviceItemsServicesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					examinationItems: serviceItemExaminationItemsModels.length > 0
							? serviceItemExaminationItemsModels
							: undefined,
					serviceItemAssignments: serviceItemServiceItemAssignmentsModels.length > 0
							? serviceItemServiceItemAssignmentsModels
							: undefined,
					services: serviceItemsServicesModels.length > 0
							? serviceItemsServicesModels
							: undefined,
				};

			case 'ServiceItemAssignmentModel':
				return {
					serviceItem: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('serviceItem_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('serviceItem_'))])
							: undefined,
					tariffPackage: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffPackage_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffPackage_'))])
							: undefined,
				};

			case 'StaffModel':
				let accompanyingStaffAccompanyingConsentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('accompanyingConsents_')).forEach(key => {
					accompanyingStaffAccompanyingConsentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffAmendmentDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('amendmentDetails_')).forEach(key => {
					staffAmendmentDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let anesthesiaMedicalTranscriberAnesthesiaMedicalTranscriberModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('anesthesiaMedicalTranscriber_')).forEach(key => {
					anesthesiaMedicalTranscriberAnesthesiaMedicalTranscriberModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let anesthesiologistAnesthesiologistModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('anesthesiologist_')).forEach(key => {
					anesthesiologistAnesthesiologistModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let anesthesiologyNurseAnesthesiologyNurseModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('anesthesiologyNurse_')).forEach(key => {
					anesthesiologyNurseAnesthesiologyNurseModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let cashierStaffCashierStaffModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('cashierStaff_')).forEach(key => {
					cashierStaffCashierStaffModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffCoTreatingDoctorsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('coTreatingDoctors_')).forEach(key => {
					staffCoTreatingDoctorsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let createdByStaffDailyCareCPPTsCreatedByStaffModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('dailyCareCPPTsCreatedByStaff_')).forEach(key => {
					createdByStaffDailyCareCPPTsCreatedByStaffModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let doctorInChargeDailyCareCPPTsDoctorInChargeModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('dailyCareCPPTsDoctorInCharge_')).forEach(key => {
					doctorInChargeDailyCareCPPTsDoctorInChargeModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalTranscriberDailyCareCPPTsMedicalTranscriberModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('dailyCareCPPTsMedicalTranscriber_')).forEach(key => {
					medicalTranscriberDailyCareCPPTsMedicalTranscriberModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffDeliveryProgressesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('deliveryProgresses_')).forEach(key => {
					staffDeliveryProgressesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffDiagnosticStaffExaminationSummariesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('diagnosticStaffExaminationSummaries_')).forEach(key => {
					staffDiagnosticStaffExaminationSummariesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let dismissalReferringStaffDismissalReferringStaffModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('dismissalReferringStaff_')).forEach(key => {
					dismissalReferringStaffDismissalReferringStaffModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffDoctorSchedulesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('doctorSchedules_')).forEach(key => {
					staffDoctorSchedulesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let doctorDoctorOnExaminationModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('doctorOnExamination_')).forEach(key => {
					doctorDoctorOnExaminationModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffFluidBalanceDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('fluidBalanceDetails_')).forEach(key => {
					staffFluidBalanceDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalStaffHemodialysisMonitoringsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('hemodialysisMonitorings_')).forEach(key => {
					medicalStaffHemodialysisMonitoringsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffHospitalBranchInformationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('hospitalBranchInformations_')).forEach(key => {
					staffHospitalBranchInformationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let informingStaffInformingConsentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('informingConsents_')).forEach(key => {
					informingStaffInformingConsentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let verifiedByInvoicesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoices_')).forEach(key => {
					verifiedByInvoicesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffMcuPackageItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('mcuPackageItems_')).forEach(key => {
					staffMcuPackageItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalStaffMedicalCertificateDischargeResumesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalCertificateDischargeResumes_')).forEach(key => {
					medicalStaffMedicalCertificateDischargeResumesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalStaffMedicalCertificateBirthsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalCertificateBirths_')).forEach(key => {
					medicalStaffMedicalCertificateBirthsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalStaffMedicalCertificateHospitalizationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalCertificateHospitalizations_')).forEach(key => {
					medicalStaffMedicalCertificateHospitalizationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let dischargingDoctorMedicalExaminationRecordDischargeSummarysModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalExaminationRecordDischargeSummarys_')).forEach(key => {
					dischargingDoctorMedicalExaminationRecordDischargeSummarysModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalTranscriberMedicalRecordTranscriberModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalRecordTranscriber_')).forEach(key => {
					medicalTranscriberMedicalRecordTranscriberModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalStaffMedicalStaffOfMedicalAttendancesCertificateModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalStaffOfMedicalAttendancesCertificate_')).forEach(key => {
					medicalStaffMedicalStaffOfMedicalAttendancesCertificateModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalStaffMedicalStaffOfMentalHealthsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalStaffOfMentalHealths_')).forEach(key => {
					medicalStaffMedicalStaffOfMentalHealthsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalStaffMedicalStaffOfPhysicalHealthsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalStaffOfPhysicalHealths_')).forEach(key => {
					medicalStaffMedicalStaffOfPhysicalHealthsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalStaffMedicalStaffOfRestrictedWorksCertificateModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalStaffOfRestrictedWorksCertificate_')).forEach(key => {
					medicalStaffMedicalStaffOfRestrictedWorksCertificateModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let medicalStaffMedicalStaffOfSickLeavesCertificateModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalStaffOfSickLeavesCertificate_')).forEach(key => {
					medicalStaffMedicalStaffOfSickLeavesCertificateModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffMedicationAdministeredHisotriesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationAdministeredHisotries_')).forEach(key => {
					staffMedicationAdministeredHisotriesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let requestedByMedicationHeadersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationHeaders_')).forEach(key => {
					requestedByMedicationHeadersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let midwifeMidwivesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('midwives_')).forEach(key => {
					midwifeMidwivesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let nurseNurseModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('nurse_')).forEach(key => {
					nurseNurseModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let nursingDetailSurgicalNursingsNursingDetailSurgicalNursingModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('nursingDetailSurgicalNursing_')).forEach(key => {
					nursingDetailSurgicalNursingsNursingDetailSurgicalNursingModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let nursingDetailsAnesthesiaNursingsNursingDetailsAnesthesiaNursingModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('nursingDetailsAnesthesiaNursing_')).forEach(key => {
					nursingDetailsAnesthesiaNursingsNursingDetailsAnesthesiaNursingModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffPatientConsentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('patientConsents_')).forEach(key => {
					staffPatientConsentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffPatientVitalInformationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('patientVitalInformations_')).forEach(key => {
					staffPatientVitalInformationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffPediatricianInChargeModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('pediatricianInCharge_')).forEach(key => {
					staffPediatricianInChargeModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let requestedByPrescriptionHeadersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('prescriptionHeaders_')).forEach(key => {
					requestedByPrescriptionHeadersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffProcessWorkflowLogsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('processWorkflowLogs_')).forEach(key => {
					staffProcessWorkflowLogsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffRegistrationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('registrations_')).forEach(key => {
					staffRegistrationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let requestedByRequestedByModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('requestedBy_')).forEach(key => {
					requestedByRequestedByModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let transferringStaffRoomTransfersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('roomTransfers_')).forEach(key => {
					transferringStaffRoomTransfersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let sampleCollectionStaffSampleCollectionStaffsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('sampleCollectionStaffs_')).forEach(key => {
					sampleCollectionStaffSampleCollectionStaffsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let sampleDeliveryStaffSampleDeliveryStaffsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('sampleDeliveryStaffs_')).forEach(key => {
					sampleDeliveryStaffSampleDeliveryStaffsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let sampleProcessingStaffSampleProcessingStaffsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('sampleProcessingStaffs_')).forEach(key => {
					sampleProcessingStaffSampleProcessingStaffsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let surgeonSurgeonModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('surgeon_')).forEach(key => {
					surgeonSurgeonModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let surgicalMedicalTranscriberSurgicalMedicalTranscriberModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('surgicalMedicalTranscriber_')).forEach(key => {
					surgicalMedicalTranscriberSurgicalMedicalTranscriberModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let surgicalNurseSurgicalNurseModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('surgicalNurse_')).forEach(key => {
					surgicalNurseSurgicalNurseModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffTransferOrderStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('transferOrderStockDetails_')).forEach(key => {
					staffTransferOrderStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let staffVaccinationOrdersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('vaccinationOrders_')).forEach(key => {
					staffVaccinationOrdersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let assignedMedicalStaffServicesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('services_')).forEach(key => {
					assignedMedicalStaffServicesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					administrationUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('administrationUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('administrationUser_'))])
							: undefined,
					cashierUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('cashierUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('cashierUser_'))])
							: undefined,
					claimUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('claimUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('claimUser_'))])
							: undefined,
					diagnosticSupportUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosticSupportUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('diagnosticSupportUser_'))])
							: undefined,
					doctorUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('doctorUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('doctorUser_'))])
							: undefined,
					facilityUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('facilityUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('facilityUser_'))])
							: undefined,
					managementUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('managementUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('managementUser_'))])
							: undefined,
					medicalRecordUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalRecordUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalRecordUser_'))])
							: undefined,
					medicalTranscriberUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalTranscriberUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('medicalTranscriberUser_'))])
							: undefined,
					nurseUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nurseUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('nurseUser_'))])
							: undefined,
					pharmacyUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pharmacyUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pharmacyUser_'))])
							: undefined,
					purchasingUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchasingUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('purchasingUser_'))])
							: undefined,
					registrationUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registrationUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registrationUser_'))])
							: undefined,
					systemAdminUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('systemAdminUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('systemAdminUser_'))])
							: undefined,
					warehouseUser: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouseUser_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouseUser_'))])
							: undefined,
					administrator: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('administrator_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('administrator_'))])
							: undefined,
					bpjsDoctorMapping: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDoctorMapping_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDoctorMapping_'))])
							: undefined,
					pcareDokter: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareDokter_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('pcareDokter_'))])
							: undefined,
					service: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('service_'))])
							: undefined,
					accompanyingConsents: accompanyingStaffAccompanyingConsentsModels.length > 0
							? accompanyingStaffAccompanyingConsentsModels
							: undefined,
					amendmentDetails: staffAmendmentDetailsModels.length > 0
							? staffAmendmentDetailsModels
							: undefined,
					anesthesiaMedicalTranscriber: anesthesiaMedicalTranscriberAnesthesiaMedicalTranscriberModels.length > 0
							? anesthesiaMedicalTranscriberAnesthesiaMedicalTranscriberModels
							: undefined,
					anesthesiologist: anesthesiologistAnesthesiologistModels.length > 0
							? anesthesiologistAnesthesiologistModels
							: undefined,
					anesthesiologyNurse: anesthesiologyNurseAnesthesiologyNurseModels.length > 0
							? anesthesiologyNurseAnesthesiologyNurseModels
							: undefined,
					cashierStaff: cashierStaffCashierStaffModels.length > 0
							? cashierStaffCashierStaffModels
							: undefined,
					coTreatingDoctors: staffCoTreatingDoctorsModels.length > 0
							? staffCoTreatingDoctorsModels
							: undefined,
					dailyCareCPPTsCreatedByStaff: createdByStaffDailyCareCPPTsCreatedByStaffModels.length > 0
							? createdByStaffDailyCareCPPTsCreatedByStaffModels
							: undefined,
					dailyCareCPPTsDoctorInCharge: doctorInChargeDailyCareCPPTsDoctorInChargeModels.length > 0
							? doctorInChargeDailyCareCPPTsDoctorInChargeModels
							: undefined,
					dailyCareCPPTsMedicalTranscriber: medicalTranscriberDailyCareCPPTsMedicalTranscriberModels.length > 0
							? medicalTranscriberDailyCareCPPTsMedicalTranscriberModels
							: undefined,
					deliveryProgresses: staffDeliveryProgressesModels.length > 0
							? staffDeliveryProgressesModels
							: undefined,
					diagnosticStaffExaminationSummaries: staffDiagnosticStaffExaminationSummariesModels.length > 0
							? staffDiagnosticStaffExaminationSummariesModels
							: undefined,
					dismissalReferringStaff: dismissalReferringStaffDismissalReferringStaffModels.length > 0
							? dismissalReferringStaffDismissalReferringStaffModels
							: undefined,
					doctorSchedules: staffDoctorSchedulesModels.length > 0
							? staffDoctorSchedulesModels
							: undefined,
					doctorOnExamination: doctorDoctorOnExaminationModels.length > 0
							? doctorDoctorOnExaminationModels
							: undefined,
					fluidBalanceDetails: staffFluidBalanceDetailsModels.length > 0
							? staffFluidBalanceDetailsModels
							: undefined,
					hemodialysisMonitorings: medicalStaffHemodialysisMonitoringsModels.length > 0
							? medicalStaffHemodialysisMonitoringsModels
							: undefined,
					hospitalBranchInformations: staffHospitalBranchInformationsModels.length > 0
							? staffHospitalBranchInformationsModels
							: undefined,
					informingConsents: informingStaffInformingConsentsModels.length > 0
							? informingStaffInformingConsentsModels
							: undefined,
					invoices: verifiedByInvoicesModels.length > 0
							? verifiedByInvoicesModels
							: undefined,
					mcuPackageItems: staffMcuPackageItemsModels.length > 0
							? staffMcuPackageItemsModels
							: undefined,
					medicalCertificateDischargeResumes: medicalStaffMedicalCertificateDischargeResumesModels.length > 0
							? medicalStaffMedicalCertificateDischargeResumesModels
							: undefined,
					medicalCertificateBirths: medicalStaffMedicalCertificateBirthsModels.length > 0
							? medicalStaffMedicalCertificateBirthsModels
							: undefined,
					medicalCertificateHospitalizations: medicalStaffMedicalCertificateHospitalizationsModels.length > 0
							? medicalStaffMedicalCertificateHospitalizationsModels
							: undefined,
					medicalExaminationRecordDischargeSummarys: dischargingDoctorMedicalExaminationRecordDischargeSummarysModels.length > 0
							? dischargingDoctorMedicalExaminationRecordDischargeSummarysModels
							: undefined,
					medicalRecordTranscriber: medicalTranscriberMedicalRecordTranscriberModels.length > 0
							? medicalTranscriberMedicalRecordTranscriberModels
							: undefined,
					medicalStaffOfMedicalAttendancesCertificate: medicalStaffMedicalStaffOfMedicalAttendancesCertificateModels.length > 0
							? medicalStaffMedicalStaffOfMedicalAttendancesCertificateModels
							: undefined,
					medicalStaffOfMentalHealths: medicalStaffMedicalStaffOfMentalHealthsModels.length > 0
							? medicalStaffMedicalStaffOfMentalHealthsModels
							: undefined,
					medicalStaffOfPhysicalHealths: medicalStaffMedicalStaffOfPhysicalHealthsModels.length > 0
							? medicalStaffMedicalStaffOfPhysicalHealthsModels
							: undefined,
					medicalStaffOfRestrictedWorksCertificate: medicalStaffMedicalStaffOfRestrictedWorksCertificateModels.length > 0
							? medicalStaffMedicalStaffOfRestrictedWorksCertificateModels
							: undefined,
					medicalStaffOfSickLeavesCertificate: medicalStaffMedicalStaffOfSickLeavesCertificateModels.length > 0
							? medicalStaffMedicalStaffOfSickLeavesCertificateModels
							: undefined,
					medicationAdministeredHisotries: staffMedicationAdministeredHisotriesModels.length > 0
							? staffMedicationAdministeredHisotriesModels
							: undefined,
					medicationHeaders: requestedByMedicationHeadersModels.length > 0
							? requestedByMedicationHeadersModels
							: undefined,
					midwives: midwifeMidwivesModels.length > 0
							? midwifeMidwivesModels
							: undefined,
					nurse: nurseNurseModels.length > 0
							? nurseNurseModels
							: undefined,
					nursingDetailSurgicalNursing: nursingDetailSurgicalNursingsNursingDetailSurgicalNursingModels.length > 0
							? nursingDetailSurgicalNursingsNursingDetailSurgicalNursingModels
							: undefined,
					nursingDetailsAnesthesiaNursing: nursingDetailsAnesthesiaNursingsNursingDetailsAnesthesiaNursingModels.length > 0
							? nursingDetailsAnesthesiaNursingsNursingDetailsAnesthesiaNursingModels
							: undefined,
					patientConsents: staffPatientConsentsModels.length > 0
							? staffPatientConsentsModels
							: undefined,
					patientVitalInformations: staffPatientVitalInformationsModels.length > 0
							? staffPatientVitalInformationsModels
							: undefined,
					pediatricianInCharge: staffPediatricianInChargeModels.length > 0
							? staffPediatricianInChargeModels
							: undefined,
					prescriptionHeaders: requestedByPrescriptionHeadersModels.length > 0
							? requestedByPrescriptionHeadersModels
							: undefined,
					processWorkflowLogs: staffProcessWorkflowLogsModels.length > 0
							? staffProcessWorkflowLogsModels
							: undefined,
					registrations: staffRegistrationsModels.length > 0
							? staffRegistrationsModels
							: undefined,
					requestedBy: requestedByRequestedByModels.length > 0
							? requestedByRequestedByModels
							: undefined,
					roomTransfers: transferringStaffRoomTransfersModels.length > 0
							? transferringStaffRoomTransfersModels
							: undefined,
					sampleCollectionStaffs: sampleCollectionStaffSampleCollectionStaffsModels.length > 0
							? sampleCollectionStaffSampleCollectionStaffsModels
							: undefined,
					sampleDeliveryStaffs: sampleDeliveryStaffSampleDeliveryStaffsModels.length > 0
							? sampleDeliveryStaffSampleDeliveryStaffsModels
							: undefined,
					sampleProcessingStaffs: sampleProcessingStaffSampleProcessingStaffsModels.length > 0
							? sampleProcessingStaffSampleProcessingStaffsModels
							: undefined,
					surgeon: surgeonSurgeonModels.length > 0
							? surgeonSurgeonModels
							: undefined,
					surgicalMedicalTranscriber: surgicalMedicalTranscriberSurgicalMedicalTranscriberModels.length > 0
							? surgicalMedicalTranscriberSurgicalMedicalTranscriberModels
							: undefined,
					surgicalNurse: surgicalNurseSurgicalNurseModels.length > 0
							? surgicalNurseSurgicalNurseModels
							: undefined,
					transferOrderStockDetails: staffTransferOrderStockDetailsModels.length > 0
							? staffTransferOrderStockDetailsModels
							: undefined,
					vaccinationOrders: staffVaccinationOrdersModels.length > 0
							? staffVaccinationOrdersModels
							: undefined,
					services: assignedMedicalStaffServicesModels.length > 0
							? assignedMedicalStaffServicesModels
							: undefined,
				};

			case 'StockCatalogueModel':
				let stockCatalogueBatchStockBalancesCatalogueModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('batchStockBalancesCatalogue_')).forEach(key => {
					stockCatalogueBatchStockBalancesCatalogueModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueBatchStockBalancesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('batchStockBalances_')).forEach(key => {
					stockCatalogueBatchStockBalancesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueBatchStockTransactionDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('batchStockTransactionDetails_')).forEach(key => {
					stockCatalogueBatchStockTransactionDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueCatalogueUOMsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('catalogueUOMs_')).forEach(key => {
					stockCatalogueCatalogueUOMsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueCompoundPrescriptionItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('compoundPrescriptionItems_')).forEach(key => {
					stockCatalogueCompoundPrescriptionItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueGoodsReceiveNoteBatchsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('goodsReceiveNoteBatchs_')).forEach(key => {
					stockCatalogueGoodsReceiveNoteBatchsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueGoodsReceiveNoteItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('goodsReceiveNoteItems_')).forEach(key => {
					stockCatalogueGoodsReceiveNoteItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueInternalOrderStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('internalOrderStockDetails_')).forEach(key => {
					stockCatalogueInternalOrderStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueInventoryAdjusmentBatchsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('inventoryAdjusmentBatchs_')).forEach(key => {
					stockCatalogueInventoryAdjusmentBatchsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueInventoryAdjustmentItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('inventoryAdjustmentItems_')).forEach(key => {
					stockCatalogueInventoryAdjustmentItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueInventoryBatchCorrectionItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('inventoryBatchCorrectionItems_')).forEach(key => {
					stockCatalogueInventoryBatchCorrectionItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueMedicationItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationItems_')).forEach(key => {
					stockCatalogueMedicationItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueIdPrescriptionItemModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('prescriptionItem_')).forEach(key => {
					stockCatalogueIdPrescriptionItemModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCataloguePurchaseOrderStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('purchaseOrderStockDetails_')).forEach(key => {
					stockCataloguePurchaseOrderStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCataloguePurchaseRequisitionStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('purchaseRequisitionStockDetails_')).forEach(key => {
					stockCataloguePurchaseRequisitionStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueRetailPharmacyStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('retailPharmacyStockDetails_')).forEach(key => {
					stockCatalogueRetailPharmacyStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueReturnSupplierStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('returnSupplierStockDetails_')).forEach(key => {
					stockCatalogueReturnSupplierStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueStockControlsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockControls_')).forEach(key => {
					stockCatalogueStockControlsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueStockTransactionDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockTransactionDetails_')).forEach(key => {
					stockCatalogueStockTransactionDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueStockTransactionPerDateTypesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockTransactionPerDateTypes_')).forEach(key => {
					stockCatalogueStockTransactionPerDateTypesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueStockTransactionPerDatesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockTransactionPerDates_')).forEach(key => {
					stockCatalogueStockTransactionPerDatesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueSupplierProductDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('supplierProductDetails_')).forEach(key => {
					stockCatalogueSupplierProductDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueTransferOrderStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('transferOrderStockDetails_')).forEach(key => {
					stockCatalogueTransferOrderStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueVaccinationOrderDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('vaccinationOrderDetails_')).forEach(key => {
					stockCatalogueVaccinationOrderDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueWarehouseInitialStockSModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('warehouseInitialStockS_')).forEach(key => {
					stockCatalogueWarehouseInitialStockSModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let stockCatalogueWarehouseInventoriesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('warehouseInventories_')).forEach(key => {
					stockCatalogueWarehouseInventoriesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					bpjsDrugGenericPRB: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDrugGenericPRB_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsDrugGenericPRB_'))])
							: undefined,
					bpjsPcareDPHO: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsPcareDPHO_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('bpjsPcareDPHO_'))])
							: undefined,
					stockCatalogueMedical: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogueMedical_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogueMedical_'))])
							: undefined,
					stockCatalogueNonMedical: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogueNonMedical_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogueNonMedical_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
					batchStockBalancesCatalogue: stockCatalogueBatchStockBalancesCatalogueModels.length > 0
							? stockCatalogueBatchStockBalancesCatalogueModels
							: undefined,
					batchStockBalances: stockCatalogueBatchStockBalancesModels.length > 0
							? stockCatalogueBatchStockBalancesModels
							: undefined,
					batchStockTransactionDetails: stockCatalogueBatchStockTransactionDetailsModels.length > 0
							? stockCatalogueBatchStockTransactionDetailsModels
							: undefined,
					catalogueUOMs: stockCatalogueCatalogueUOMsModels.length > 0
							? stockCatalogueCatalogueUOMsModels
							: undefined,
					compoundPrescriptionItems: stockCatalogueCompoundPrescriptionItemsModels.length > 0
							? stockCatalogueCompoundPrescriptionItemsModels
							: undefined,
					goodsReceiveNoteBatchs: stockCatalogueGoodsReceiveNoteBatchsModels.length > 0
							? stockCatalogueGoodsReceiveNoteBatchsModels
							: undefined,
					goodsReceiveNoteItems: stockCatalogueGoodsReceiveNoteItemsModels.length > 0
							? stockCatalogueGoodsReceiveNoteItemsModels
							: undefined,
					internalOrderStockDetails: stockCatalogueInternalOrderStockDetailsModels.length > 0
							? stockCatalogueInternalOrderStockDetailsModels
							: undefined,
					inventoryAdjusmentBatchs: stockCatalogueInventoryAdjusmentBatchsModels.length > 0
							? stockCatalogueInventoryAdjusmentBatchsModels
							: undefined,
					inventoryAdjustmentItems: stockCatalogueInventoryAdjustmentItemsModels.length > 0
							? stockCatalogueInventoryAdjustmentItemsModels
							: undefined,
					inventoryBatchCorrectionItems: stockCatalogueInventoryBatchCorrectionItemsModels.length > 0
							? stockCatalogueInventoryBatchCorrectionItemsModels
							: undefined,
					medicationItems: stockCatalogueMedicationItemsModels.length > 0
							? stockCatalogueMedicationItemsModels
							: undefined,
					prescriptionItem: stockCatalogueIdPrescriptionItemModels.length > 0
							? stockCatalogueIdPrescriptionItemModels
							: undefined,
					purchaseOrderStockDetails: stockCataloguePurchaseOrderStockDetailsModels.length > 0
							? stockCataloguePurchaseOrderStockDetailsModels
							: undefined,
					purchaseRequisitionStockDetails: stockCataloguePurchaseRequisitionStockDetailsModels.length > 0
							? stockCataloguePurchaseRequisitionStockDetailsModels
							: undefined,
					retailPharmacyStockDetails: stockCatalogueRetailPharmacyStockDetailsModels.length > 0
							? stockCatalogueRetailPharmacyStockDetailsModels
							: undefined,
					returnSupplierStockDetails: stockCatalogueReturnSupplierStockDetailsModels.length > 0
							? stockCatalogueReturnSupplierStockDetailsModels
							: undefined,
					stockControls: stockCatalogueStockControlsModels.length > 0
							? stockCatalogueStockControlsModels
							: undefined,
					stockTransactionDetails: stockCatalogueStockTransactionDetailsModels.length > 0
							? stockCatalogueStockTransactionDetailsModels
							: undefined,
					stockTransactionPerDateTypes: stockCatalogueStockTransactionPerDateTypesModels.length > 0
							? stockCatalogueStockTransactionPerDateTypesModels
							: undefined,
					stockTransactionPerDates: stockCatalogueStockTransactionPerDatesModels.length > 0
							? stockCatalogueStockTransactionPerDatesModels
							: undefined,
					supplierProductDetails: stockCatalogueSupplierProductDetailsModels.length > 0
							? stockCatalogueSupplierProductDetailsModels
							: undefined,
					transferOrderStockDetails: stockCatalogueTransferOrderStockDetailsModels.length > 0
							? stockCatalogueTransferOrderStockDetailsModels
							: undefined,
					vaccinationOrderDetails: stockCatalogueVaccinationOrderDetailsModels.length > 0
							? stockCatalogueVaccinationOrderDetailsModels
							: undefined,
					warehouseInitialStockS: stockCatalogueWarehouseInitialStockSModels.length > 0
							? stockCatalogueWarehouseInitialStockSModels
							: undefined,
					warehouseInventories: stockCatalogueWarehouseInventoriesModels.length > 0
							? stockCatalogueWarehouseInventoriesModels
							: undefined,
				};

			case 'StockControlModel':
				return {
					location: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('location_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('location_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'StockTransactionDetailModel':
				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					transactionDetailType: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transactionDetailType_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transactionDetailType_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'StockTransactionPerDateModel':
				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'StockTransactionPerDateTypeModel':
				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					transactionDetailType: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transactionDetailType_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transactionDetailType_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'SupplierModel':
				let supplierGoodsReceiveNotesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('goodsReceiveNotes_')).forEach(key => {
					supplierGoodsReceiveNotesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let supplierPurchaseOrdersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('purchaseOrders_')).forEach(key => {
					supplierPurchaseOrdersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let supplierPurchaseRequisitionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('purchaseRequisitions_')).forEach(key => {
					supplierPurchaseRequisitionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let supplierReturnSuppliersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('returnSuppliers_')).forEach(key => {
					supplierReturnSuppliersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let supplierSuplierContactDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('suplierContactDetails_')).forEach(key => {
					supplierSuplierContactDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let supplierSupplierBankAccountsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('supplierBankAccounts_')).forEach(key => {
					supplierSupplierBankAccountsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let supplierSupplierProductDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('supplierProductDetails_')).forEach(key => {
					supplierSupplierProductDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					goodsReceiveNotes: supplierGoodsReceiveNotesModels.length > 0
							? supplierGoodsReceiveNotesModels
							: undefined,
					purchaseOrders: supplierPurchaseOrdersModels.length > 0
							? supplierPurchaseOrdersModels
							: undefined,
					purchaseRequisitions: supplierPurchaseRequisitionsModels.length > 0
							? supplierPurchaseRequisitionsModels
							: undefined,
					returnSuppliers: supplierReturnSuppliersModels.length > 0
							? supplierReturnSuppliersModels
							: undefined,
					suplierContactDetails: supplierSuplierContactDetailsModels.length > 0
							? supplierSuplierContactDetailsModels
							: undefined,
					supplierBankAccounts: supplierSupplierBankAccountsModels.length > 0
							? supplierSupplierBankAccountsModels
							: undefined,
					supplierProductDetails: supplierSupplierProductDetailsModels.length > 0
							? supplierSupplierProductDetailsModels
							: undefined,
				};

			case 'SupplierBankAccountModel':
				return {
					supplier: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))])
							: undefined,
				};

			case 'SupplierContactDetailModel':
				return {
					supplier: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))])
							: undefined,
				};

			case 'SupplierProductDetailModel':
				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					supplier: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('supplier_'))])
							: undefined,
				};

			case 'SystemAdminUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			case 'TariffDefinitionModel':
				let priceDefinitionTariffDefinitionOtherComponentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('tariffDefinitionOtherComponents_')).forEach(key => {
					priceDefinitionTariffDefinitionOtherComponentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					priceSchema: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('priceSchema_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('priceSchema_'))])
							: undefined,
					tariffDefinitionOtherComponents: priceDefinitionTariffDefinitionOtherComponentsModels.length > 0
							? priceDefinitionTariffDefinitionOtherComponentsModels
							: undefined,
				};

			case 'TariffDefinitionOtherComponentModel':
				return {
					priceComponent: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('priceComponent_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('priceComponent_'))])
							: undefined,
					priceDefinition: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('priceDefinition_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('priceDefinition_'))])
							: undefined,
				};

			case 'TariffFormulaModel':
				return {
					baseSchema: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('baseSchema_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('baseSchema_'))])
							: undefined,
					tariffSchema: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffSchema_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffSchema_'))])
							: undefined,
				};

			case 'TariffPackageModel':
				let tariffPackageServiceItemAssignmentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('serviceItemAssignments_')).forEach(key => {
					tariffPackageServiceItemAssignmentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let tariffPackageTariffPackageItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('tariffPackageItems_')).forEach(key => {
					tariffPackageTariffPackageItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let tariffPackageTariffPackageServiceAssignmentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('tariffPackageServiceAssignments_')).forEach(key => {
					tariffPackageTariffPackageServiceAssignmentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					serviceItemAssignments: tariffPackageServiceItemAssignmentsModels.length > 0
							? tariffPackageServiceItemAssignmentsModels
							: undefined,
					tariffPackageItems: tariffPackageTariffPackageItemsModels.length > 0
							? tariffPackageTariffPackageItemsModels
							: undefined,
					tariffPackageServiceAssignments: tariffPackageTariffPackageServiceAssignmentsModels.length > 0
							? tariffPackageTariffPackageServiceAssignmentsModels
							: undefined,
				};

			case 'TariffPackageItemModel':
				return {
					tariffPackage: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffPackage_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffPackage_'))])
							: undefined,
				};

			case 'TariffPackageServiceAssignmentModel':
				return {
					tariffPackage: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffPackage_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('tariffPackage_'))])
							: undefined,
				};

			case 'TariffSchemaModel':
				let baseSchemaBaseSchemeModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('baseScheme_')).forEach(key => {
					baseSchemaBaseSchemeModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let tariffSchemaInvoiceItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoiceItems_')).forEach(key => {
					tariffSchemaInvoiceItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let tariffSchemaInvoicesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('invoices_')).forEach(key => {
					tariffSchemaInvoicesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let priceSchemaTariffDefinitionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('tariffDefinitions_')).forEach(key => {
					priceSchemaTariffDefinitionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let tariffSchemaTariffSchemeModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('tariffScheme_')).forEach(key => {
					tariffSchemaTariffSchemeModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					baseScheme: baseSchemaBaseSchemeModels.length > 0
							? baseSchemaBaseSchemeModels
							: undefined,
					invoiceItems: tariffSchemaInvoiceItemsModels.length > 0
							? tariffSchemaInvoiceItemsModels
							: undefined,
					invoices: tariffSchemaInvoicesModels.length > 0
							? tariffSchemaInvoicesModels
							: undefined,
					tariffDefinitions: priceSchemaTariffDefinitionsModels.length > 0
							? priceSchemaTariffDefinitionsModels
							: undefined,
					tariffScheme: tariffSchemaTariffSchemeModels.length > 0
							? tariffSchemaTariffSchemeModels
							: undefined,
				};

			case 'TaskDashboardModel':
				return {
				};

			case 'TransactionDetailTypeModel':
				let transactionDetailTypeInventoryAdjustmentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('inventoryAdjustments_')).forEach(key => {
					transactionDetailTypeInventoryAdjustmentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let transactionDetailTypeStockTransactionDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockTransactionDetails_')).forEach(key => {
					transactionDetailTypeStockTransactionDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let transactionDetailTypeStockTransactionPerDateTypesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockTransactionPerDateTypes_')).forEach(key => {
					transactionDetailTypeStockTransactionPerDateTypesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let transactionDetailTypeTransactionDetailTypeMappingsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('transactionDetailTypeMappings_')).forEach(key => {
					transactionDetailTypeTransactionDetailTypeMappingsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					inventoryAdjustments: transactionDetailTypeInventoryAdjustmentsModels.length > 0
							? transactionDetailTypeInventoryAdjustmentsModels
							: undefined,
					stockTransactionDetails: transactionDetailTypeStockTransactionDetailsModels.length > 0
							? transactionDetailTypeStockTransactionDetailsModels
							: undefined,
					stockTransactionPerDateTypes: transactionDetailTypeStockTransactionPerDateTypesModels.length > 0
							? transactionDetailTypeStockTransactionPerDateTypesModels
							: undefined,
					transactionDetailTypeMappings: transactionDetailTypeTransactionDetailTypeMappingsModels.length > 0
							? transactionDetailTypeTransactionDetailTypeMappingsModels
							: undefined,
				};

			case 'TransactionDetailTypeMappingModel':
				return {
					transactionDetailType: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transactionDetailType_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transactionDetailType_'))])
							: undefined,
				};

			case 'TransferOrderModel':
				let transferOrderTransferOrderStockDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('transferOrderStockDetails_')).forEach(key => {
					transferOrderTransferOrderStockDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					destinationWarehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('destinationWarehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('destinationWarehouse_'))])
							: undefined,
					sourceWarehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sourceWarehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('sourceWarehouse_'))])
							: undefined,
					transferOrderStockDetails: transferOrderTransferOrderStockDetailsModels.length > 0
							? transferOrderTransferOrderStockDetailsModels
							: undefined,
				};

			case 'TransferOrderStockDetailModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					transferOrder: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transferOrder_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('transferOrder_'))])
							: undefined,
				};

			case 'UnitOfMeasurementModel':
				let consumptionUnitCompoundPrescriptionDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('compoundPrescriptionDetails_')).forEach(key => {
					consumptionUnitCompoundPrescriptionDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let unitCompoundPrescriptionItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('compoundPrescriptionItems_')).forEach(key => {
					unitCompoundPrescriptionItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let unitCompoundsUnitModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('compoundsUnit_')).forEach(key => {
					unitCompoundsUnitModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let unitOfMeasurementMedicationCompoundsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationCompounds_')).forEach(key => {
					unitOfMeasurementMedicationCompoundsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let unitOfMeasurementMedicationItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationItems_')).forEach(key => {
					unitOfMeasurementMedicationItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let unitPrescriptionItemsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('prescriptionItems_')).forEach(key => {
					unitPrescriptionItemsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					catalogueUOM: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('catalogueUOM_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('catalogueUOM_'))])
							: undefined,
					compoundPrescriptionDetails: consumptionUnitCompoundPrescriptionDetailsModels.length > 0
							? consumptionUnitCompoundPrescriptionDetailsModels
							: undefined,
					compoundPrescriptionItems: unitCompoundPrescriptionItemsModels.length > 0
							? unitCompoundPrescriptionItemsModels
							: undefined,
					compoundsUnit: unitCompoundsUnitModels.length > 0
							? unitCompoundsUnitModels
							: undefined,
					medicationCompounds: unitOfMeasurementMedicationCompoundsModels.length > 0
							? unitOfMeasurementMedicationCompoundsModels
							: undefined,
					medicationItems: unitOfMeasurementMedicationItemsModels.length > 0
							? unitOfMeasurementMedicationItemsModels
							: undefined,
					prescriptionItems: unitPrescriptionItemsModels.length > 0
							? unitPrescriptionItemsModels
							: undefined,
				};

			case 'UserModel':
				let usersRolesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('roles_')).forEach(key => {
					usersRolesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					roles: usersRolesModels.length > 0
							? usersRolesModels
							: undefined,
				};

			case 'VaccinationOrderModel':
				let vaccinationOrderVaccinationOrderDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('vaccinationOrderDetails_')).forEach(key => {
					vaccinationOrderVaccinationOrderDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					registration: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('registration_'))])
							: undefined,
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
					vaccinationOrderDetails: vaccinationOrderVaccinationOrderDetailsModels.length > 0
							? vaccinationOrderVaccinationOrderDetailsModels
							: undefined,
				};

			case 'VaccinationOrderDetailModel':
				return {
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					vaccinationOrder: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('vaccinationOrder_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('vaccinationOrder_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'VitalSignsModel':
				return {
					newbornDetail: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('newbornDetail_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('newbornDetail_'))])
							: undefined,
				};

			case 'WarehouseModel':
				let warehouseBatchStockBalancesWarehouseModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('batchStockBalancesWarehouse_')).forEach(key => {
					warehouseBatchStockBalancesWarehouseModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseBatchStockBalancesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('batchStockBalances_')).forEach(key => {
					warehouseBatchStockBalancesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseBatchStockTransactionDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('batchStockTransactionDetails_')).forEach(key => {
					warehouseBatchStockTransactionDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let destinationWarehouseDestinationWarehousesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('destinationWarehouses_')).forEach(key => {
					destinationWarehouseDestinationWarehousesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseGoodsReceiveNoteBatchsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('goodsReceiveNoteBatchs_')).forEach(key => {
					warehouseGoodsReceiveNoteBatchsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseGoodsReceiveNotesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('goodsReceiveNotes_')).forEach(key => {
					warehouseGoodsReceiveNotesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseInternalOrdersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('internalOrders_')).forEach(key => {
					warehouseInternalOrdersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseInventoryAdjusmentBatchsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('inventoryAdjusmentBatchs_')).forEach(key => {
					warehouseInventoryAdjusmentBatchsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseInventoryAdjustmentsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('inventoryAdjustments_')).forEach(key => {
					warehouseInventoryAdjustmentsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseInventoryBatchCorrectionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('inventoryBatchCorrections_')).forEach(key => {
					warehouseInventoryBatchCorrectionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseLocationsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('locations_')).forEach(key => {
					warehouseLocationsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseMedicalFeesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicalFees_')).forEach(key => {
					warehouseMedicalFeesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseMedicationHeadersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('medicationHeaders_')).forEach(key => {
					warehouseMedicationHeadersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehousePrescriptionHeadersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('prescriptionHeaders_')).forEach(key => {
					warehousePrescriptionHeadersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehousePurchaseOrdersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('purchaseOrders_')).forEach(key => {
					warehousePurchaseOrdersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehousePurchaseRequisitionsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('purchaseRequisitions_')).forEach(key => {
					warehousePurchaseRequisitionsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseRetailPharmaciesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('retailPharmacies_')).forEach(key => {
					warehouseRetailPharmaciesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseReturnSuppliersModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('returnSuppliers_')).forEach(key => {
					warehouseReturnSuppliersModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let sourceWarehouseSourceWarehousesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('sourceWarehouses_')).forEach(key => {
					sourceWarehouseSourceWarehousesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseStockCataloguesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockCatalogues_')).forEach(key => {
					warehouseStockCataloguesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseStockControlsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockControls_')).forEach(key => {
					warehouseStockControlsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseStockTransactionDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockTransactionDetails_')).forEach(key => {
					warehouseStockTransactionDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseStockTransactionPerDateTypesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockTransactionPerDateTypes_')).forEach(key => {
					warehouseStockTransactionPerDateTypesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseStockTransactionPerDatesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('stockTransactionPerDates_')).forEach(key => {
					warehouseStockTransactionPerDatesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseVaccinationOrderDetailsModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('vaccinationOrderDetails_')).forEach(key => {
					warehouseVaccinationOrderDetailsModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseWarehouseInitialStockSModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('warehouseInitialStockS_')).forEach(key => {
					warehouseWarehouseInitialStockSModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				let warehouseWarehouseInventoriesModels = [];
				Object.keys(this.modelPropertiesWithGroup).filter(key => key.startsWith('warehouseInventories_')).forEach(key => {
					warehouseWarehouseInventoriesModels.push(this.assignRelationValueChanges(this.modelPropertiesWithGroup[key]));
				});

				return {
					batchStockBalancesWarehouse: warehouseBatchStockBalancesWarehouseModels.length > 0
							? warehouseBatchStockBalancesWarehouseModels
							: undefined,
					batchStockBalances: warehouseBatchStockBalancesModels.length > 0
							? warehouseBatchStockBalancesModels
							: undefined,
					batchStockTransactionDetails: warehouseBatchStockTransactionDetailsModels.length > 0
							? warehouseBatchStockTransactionDetailsModels
							: undefined,
					destinationWarehouses: destinationWarehouseDestinationWarehousesModels.length > 0
							? destinationWarehouseDestinationWarehousesModels
							: undefined,
					goodsReceiveNoteBatchs: warehouseGoodsReceiveNoteBatchsModels.length > 0
							? warehouseGoodsReceiveNoteBatchsModels
							: undefined,
					goodsReceiveNotes: warehouseGoodsReceiveNotesModels.length > 0
							? warehouseGoodsReceiveNotesModels
							: undefined,
					internalOrders: warehouseInternalOrdersModels.length > 0
							? warehouseInternalOrdersModels
							: undefined,
					inventoryAdjusmentBatchs: warehouseInventoryAdjusmentBatchsModels.length > 0
							? warehouseInventoryAdjusmentBatchsModels
							: undefined,
					inventoryAdjustments: warehouseInventoryAdjustmentsModels.length > 0
							? warehouseInventoryAdjustmentsModels
							: undefined,
					inventoryBatchCorrections: warehouseInventoryBatchCorrectionsModels.length > 0
							? warehouseInventoryBatchCorrectionsModels
							: undefined,
					locations: warehouseLocationsModels.length > 0
							? warehouseLocationsModels
							: undefined,
					medicalFees: warehouseMedicalFeesModels.length > 0
							? warehouseMedicalFeesModels
							: undefined,
					medicationHeaders: warehouseMedicationHeadersModels.length > 0
							? warehouseMedicationHeadersModels
							: undefined,
					prescriptionHeaders: warehousePrescriptionHeadersModels.length > 0
							? warehousePrescriptionHeadersModels
							: undefined,
					purchaseOrders: warehousePurchaseOrdersModels.length > 0
							? warehousePurchaseOrdersModels
							: undefined,
					purchaseRequisitions: warehousePurchaseRequisitionsModels.length > 0
							? warehousePurchaseRequisitionsModels
							: undefined,
					retailPharmacies: warehouseRetailPharmaciesModels.length > 0
							? warehouseRetailPharmaciesModels
							: undefined,
					returnSuppliers: warehouseReturnSuppliersModels.length > 0
							? warehouseReturnSuppliersModels
							: undefined,
					sourceWarehouses: sourceWarehouseSourceWarehousesModels.length > 0
							? sourceWarehouseSourceWarehousesModels
							: undefined,
					stockCatalogues: warehouseStockCataloguesModels.length > 0
							? warehouseStockCataloguesModels
							: undefined,
					stockControls: warehouseStockControlsModels.length > 0
							? warehouseStockControlsModels
							: undefined,
					stockTransactionDetails: warehouseStockTransactionDetailsModels.length > 0
							? warehouseStockTransactionDetailsModels
							: undefined,
					stockTransactionPerDateTypes: warehouseStockTransactionPerDateTypesModels.length > 0
							? warehouseStockTransactionPerDateTypesModels
							: undefined,
					stockTransactionPerDates: warehouseStockTransactionPerDatesModels.length > 0
							? warehouseStockTransactionPerDatesModels
							: undefined,
					vaccinationOrderDetails: warehouseVaccinationOrderDetailsModels.length > 0
							? warehouseVaccinationOrderDetailsModels
							: undefined,
					warehouseInitialStockS: warehouseWarehouseInitialStockSModels.length > 0
							? warehouseWarehouseInitialStockSModels
							: undefined,
					warehouseInventories: warehouseWarehouseInventoriesModels.length > 0
							? warehouseWarehouseInventoriesModels
							: undefined,
				};

			case 'WarehouseInitialStockModel':
				return {
					location: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('location_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('location_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'WarehouseInventoryModel':
				return {
					location: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('location_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('location_'))])
							: undefined,
					stockCatalogue: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('stockCatalogue_'))])
							: undefined,
					warehouse: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('warehouse_'))])
							: undefined,
				};

			case 'WarehouseUserModel':
				return {
					staff: Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))
							? this.assignRelationValueChanges(this.modelPropertiesWithGroup[Object.keys(this.modelPropertiesWithGroup).find(key => key.startsWith('staff_'))])
							: undefined,
				};

			default:
				return {};
		}
	}

	/**
	 * Check whether the button to add an additional entity of the given type should be disabled
	 *
	 * @param relationName The name of the button.  This is used to check the groups in modelPropertiesWithGroup for any group which has
	 * 							a name starting with the same name.  By default, the button names and the group ids are based on the same
	 * 							attribute in the crud edit page, so if this remains true then this method will work as intended
	 * @param manyRelation Whether the button is associated with a many relation or a ones relation.  We only ever want to disable a ones relation
	 * 							so if this is true we can return false immediately, as the button will never need to be disabled
	 * @returns true if the button should be disabled, and false otherwise.
	 */
	singleEntityRelationAdded(relationName: string, manyRelation: boolean) {
		if (manyRelation) {
			return false;
		}

		// the ids of the groups are based on the display name of the relation.  The group ID's are also camel cased, so we need to
		// camel case the relation name too, otherwise this operation wouldn't work for relation names which contain more than one word
		let camelCasedRelationName = camelCase(relationName);
		return Object.keys(this.modelPropertiesWithGroup).filter(groupId => groupId.startsWith(camelCasedRelationName + '_')).length > 0;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
