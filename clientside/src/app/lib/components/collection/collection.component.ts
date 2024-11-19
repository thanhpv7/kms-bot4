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

import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormGroup} from '@angular/forms';
import * as moment from 'moment';
import {AbstractComponent} from '../abstract.component';
import {AbstractModel, ModelPropertyType, ModelProperty} from '../../models/abstract.model';
import {ButtonAccentColour, ButtonStyle, IconPosition} from '../button/button.component';
import {FilterQuestion} from './collection-filter.component';
import {InputComponentDisplayType} from '../abstract.input.component';
import {Observable} from 'rxjs';

// % protected region % [Add any additional imports here] off begin
// % protected region % [Add any additional imports here] end

/**
 * Interface to define the options from which the headers of the collection will be displayed.
 */
export interface HeaderOption {
	name: string;
	displayName: string;
	sortable: boolean;
	sourceDirectFromModel: boolean;
	valueSource?: string | (() => string);
	valueFunction?: (() => string) | ((model: any) => Observable<any>);
	// Type of the field. Used in the date/datetime/time
	type?: ModelPropertyType;
	doHide?: boolean;

	// % protected region % [Add additional properties to our header option here] off begin
	// % protected region % [Add additional properties to our header option here] end
}

/**
 * Enumeration used to configure the collection component's pagination settings.
 */
export enum LoadingType {
	PAGINATION,
	CONTINUOUS
}

/**
 * Interface to declare a custom action to include into the collection.
 */
export interface Action {
	label: string;
	icon: string;
	iconPos: IconPosition;
	showIcon: boolean;
	// Show this action in a combobox menu
	isAdditional: boolean;
	buttonStyle?: string;
	group?: string;
	template?: string;
	buttonColour?: string;
	// disable clicking this item action given an anonymous function
	disableOption?: (option: any) => boolean;

	// % protected region % [Add additional properties to our action interface here] off begin
	// % protected region % [Add additional properties to our action interface here] end
}

@Component({
	// % protected region % [Modify the existing component configurations here] off begin
	selector: 'cb-collection',
	templateUrl: './collection.component.html',
	// % protected region % [Modify the existing component configurations here] end
	styleUrls: [
		'./collection.component.scss',
		// % protected region % [Add any additional SCSS imports here] off begin
		// % protected region % [Add any additional SCSS imports here] end
	],
	// % protected region % [Add any additional component configurations here] off begin
	// % protected region % [Add any additional component configurations here] end
})
export class CollectionComponent<E extends AbstractModel> extends AbstractComponent implements OnInit {

	// Enum refs to be used in the template
	buttonAccentColour = ButtonAccentColour;
	buttonStyle = ButtonStyle;
	iconPos = IconPosition;
	loadingType = LoadingType;
	modelPropertyType = ModelPropertyType;
	inputComponentDisplayType = InputComponentDisplayType;

	actionTemplate: string = null;

	/**
	 * List of models that will be managed by this CRUD tile. Note that this may just be a slice of the complete list.
	 */
	@Input()
	models: E[] = [];

	/**
	 * List of all the models of the type managed by this CRUD tile.  While models may just be a slice of the list, this 
	 * will contain all of the entities of the given type
	 */
	@Input()
	modelCount: number = 0;

	/**
	 * List of header options to be used to configure the collection.
	 */
	@Input()
	headerOptions: HeaderOption[] = [];

	/**
	 * List of options used to display information in the expand accordion.  Default input from crud lists will include all header options with ID as well
	 */
	@Input()
	expandOptions: HeaderOption[] = [];

	/**
	 * Determines whether the expand accordion should be available in the DOM.  If false, the expand button and the accordions will not be rendered.
	 */
	@Input()
	enableExpands: boolean = true;

	/**
	 * List of additional actions that can be added to the collection against each item.
	 */
	@Input()
	itemActions: Action[] = [];

	/**
	 * List of additional actions that can be added to the collection against the collection itself.
	 */
	@Input()
	collectionActions: Action[] = [];

	/**
	 * List of additional actions that can be added to the collection against a selection of items.
	 */
	@Input()
	multipleItemsActions: Action[] = [];

	/**
	 * Flag to check if the collection is currently being displayed as a grid or a list.
	 */
	@Input()
	isGrid = false;

	/**
	 * Pagination settings
	 */
	@Input('loadingType')
	paginationType: LoadingType | string = LoadingType.PAGINATION;

	/**
	 * Flag to check whether to display the filter forms
	 */
	displayFilter = false;

	/**
	 * Whether the user can toggle between the views.
	 */
	@Input()
	allowViewToggle = true;

	/**
	 * Questions to be displayed in the filter
	 */
	@Input()
	filterQuestions: FilterQuestion[] = [];

	/**
	 * Page index used to display the current page the collection is displaying. Start with 0.
	 */
	@Input()
	pageIndex: number = 0;

	/**
	 * Whether the current page is the last page.
	 */
	@Input()
	isLastPage: boolean = false;

	/**
	 * Whether 'Load More' should be used instead of pagination buttons.
	 */
	@Input()
	isContinuousLoading: boolean = false;

	/**
	 * Whether the search bar should be hidden in the component.  
	 * Should generally be set when the entity has no searchable attributes
	 */
	@Input()
	hideSearchBar: boolean = false;

	/**
	 * The file types which can be accepted when importing a file.  Defaults to CSV because csv is only file type accepted for imports
	 * Can be overwritten to accept imports in other formats 
	 */
	@Input()
	importAcceptedFileTypes = '.csv';

	/**
	 * Event emitter for each action against an item.
	 */
	@Output('itemActionClick')
	itemActionEventEmitter: EventEmitter<{ actionName: string, payload?: any }> = new EventEmitter();

	/**
	 * Event emitter for each action against an item.
	 */
	@Output('collectionActionClick')
	collectionActionEventEmitter: EventEmitter<{ actionName: string, payload?: any }> = new EventEmitter();

	/**
	 * Event emitter for each action against an item.
	 */
	@Output('multipleItemsActionClick')
	multipleItemsActionEventEmitter: EventEmitter<{ actionName: string, payload?: any }> = new EventEmitter();

	/**
	 * Event emitter for the sorting
	 */
	@Output('sort')
	sortEmitter: EventEmitter<{ path: string, descending: boolean }[]> = new EventEmitter();

	/**
	 * Event emitter for first page pagination requests.
	 */
	@Output('first')
	firstPageEmitter: EventEmitter<any> = new EventEmitter();

	/**
	 * Event emitter for previous page pagination requests.
	 */
	@Output('prev')
	prevPageEmitter: EventEmitter<any> = new EventEmitter();

	/**
	 * Event emitter for next page pagination requests.
	 */
	@Output('next')
	nextPageEmitter: EventEmitter<any> = new EventEmitter();

	/**
	 * Event emitter for last page pagination requests.
	 */
	@Output('last')
	lastPageEmitter: EventEmitter<any> = new EventEmitter();

	/**
	 * Event emitter for the searching
	 */
	@Output('search')
	searchEmitter: EventEmitter<string> = new EventEmitter();

	/**
	 * Event emitter for the filtering
	 */
	@Output('filter')
	filterEmitter: EventEmitter<{ isClean?: boolean, filterFormGroup: FormGroup }> = new EventEmitter();

	/**
	 * Option to not display the top menu
	 */
	@Input('hideMenu')
	hideMenu: boolean;

	/**
	 * Option to not display the select boxes
	 */
	@Input('hideCheckbox')
	hideCheckbox: boolean;

	/**
	 * The index of the entity which is expanded in the accordion.  Set to null if no entities are currently expanded
	 */
	expandedIndex: number = null;

	/**
	 * List of selected models in the collection.
	 */
	selectedModels: Set<E> = new Set();

	/**
	 * List of deselected models in the collection
	 * Only used when this.usingSelected is false
	 */
	deselectedModels: Set<E> = new Set();

	/**
	 * Boolean representing whether selectedModels or deselectedModels is currently being used to check for selection
	 * Set to false when the user selects all entities, and is true otherwise
	 */
	usingSelected: boolean = true;

	/**
	 * A map to keep record of how the models are currently being sorted and what headers are currently used to sort the
	 * models.
	 */
	areItemsSortedAscending: { [s: string]: boolean } = {};

	// % protected region % [Add any additional class fields here] off begin
	// % protected region % [Add any additional class fields here] end

	constructor(
		// % protected region % [Add any additional constructor parameters here] off begin
		// % protected region % [Add any additional constructor parameters here] end
	) {
		super(
			// % protected region % [Add any additional constructor arguments here] off begin
			// % protected region % [Add any additional constructor arguments here] end
		);

		// % protected region % [Add any additional constructor logic here] off begin
		// % protected region % [Add any additional constructor logic here] end
	}

	ngOnInit(): void {
		// % protected region % [Add any additional ngOnInit logic before the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic before the main body here] end

		this.headerOptions.forEach(opt => this.areItemsSortedAscending[opt.name] = false);
		this.areItemsSortedAscending['id'] = true;

		// % protected region % [Add any additional ngOnInit logic after the main body here] off begin
		// % protected region % [Add any additional ngOnInit logic after the main body here] end
	}

	/**
	 * Triggered when the 'Select All' checkbox is checked or unchecked.
	 *
	 * @param newValue whether the checkbox is currently being checked or not
	 */
	onSelectAllChange(newValue: boolean) {
		// % protected region % [Add any additional onSelectAllChange logic before updating the value here] off begin
		// % protected region % [Add any additional onSelectAllChange logic before updating the value here] end
		let modelIds;

		// If selected, select all other checkboxes. Otherwise, clear them out.
		if (newValue) {
			if (this.usingSelected) {
				this.models.forEach(model => this.selectedModels.add(model));
			} else {
				modelIds = this.models.map(model => model.id);
				this.deselectedModels.forEach( model => {
					if (modelIds.includes(model.id)) {
						this.deselectedModels.delete(model);
					}
				});
			}
		} else {
			if (this.usingSelected) {
				modelIds = this.models.map(model => model.id);
				this.selectedModels.forEach( model => {
					if (modelIds.includes(model.id)) {
						this.selectedModels.delete(model);
					}
				});
			} else {
				this.models.forEach(model => this.deselectedModels.add(model));
			}
		}
		// % protected region % [Add any additional onSelectAllChange logic after updated the value here] off begin
		// % protected region % [Add any additional onSelectAllChange logic after updated the value here] end
	}

	/**
	 * Triggered when the 'Cancel' button is clicked.
	 */
	@Output()
	onSelectAllCancel() {
		// % protected region % [Add any additional onSelectAllCancel logic before the main logic here] off begin
		// % protected region % [Add any additional onSelectAllCancel logic before the main logic here] end

		this.usingSelected = true;
		this.selectedModels.clear();
		this.deselectedModels.clear();
		this.actionTemplate = null;

		// % protected region % [Add any additional onSelectAllCancel logic after the main logic here] off begin
		// % protected region % [Add any additional onSelectAllCancel logic after the main logic here] end
	}

	/**
	 * Triggered when a row's checkbox is selected.
	 *
	 * @param model the model that is currently being selected
	 */
	onModelSelected(model: E) {
		// % protected region % [Add any additional onModelSelected logic before the main logic here] off begin
		// % protected region % [Add any additional onModelSelected logic before the main logic here] end

		if (this.usingSelected) {
			this.selectedModels.add(model);
		} else {
			this.deselectedModels.delete(model);
		}

		// % protected region % [Add any additional onModelSelected logic after the main logic here] off begin
		// % protected region % [Add any additional onModelSelected logic after the main logic here] end
	}

	/**
	 * Triggered when a row's checkbox is deselected.
	 *
	 * @param model the model that is currently being deselected
	 */
	onModelDeselected(model: E) {
		// % protected region % [Add any additional onModelDeselected logic before the main logic here] off begin
		// % protected region % [Add any additional onModelDeselected logic before the main logic here] end

		if (this.usingSelected) {
			this.selectedModels.delete(model);
		} else {
			this.deselectedModels.add(model);
		}

		// % protected region % [Add any additional onModelDeselected logic after the main logic here] off begin
		// % protected region % [Add any additional onModelDeselected logic after the main logic here] end
	}

	/**
	 * Triggered when an action against an item is clicked.
	 */
	onItemActionClicked(actionName: string, model: E) {
		// % protected region % [Add any additional onItemActionClicked logic before the main body here] off begin
		// % protected region % [Add any additional onItemActionClicked logic before the main body here] end

		this.itemActionEventEmitter.emit({
			actionName: actionName,
			payload: {
				model: model,
				// % protected region % [Add any additional payload for onItemActionClicked here] off begin
				// % protected region % [Add any additional payload for onItemActionClicked here] end
			}
		});

		// % protected region % [Add any additional onItemActionClicked logic after the main body here] off begin
		// % protected region % [Add any additional onItemActionClicked logic after the main body here] end
	}

	/**
	 * Triggered when an action against the collection is clicked.
	 */
	onCollectionActionClicked(action: Action) {
		// % protected region % [Add any additional onCollectionActionClicked logic before the main body here] off begin
		// % protected region % [Add any additional onCollectionActionClicked logic before the main body here] end

		if (action.template) {
			if (this.actionTemplate === action.template) {
				this.actionTemplate = null;
			} else {
				this.actionTemplate = action.template;
			}
			return;
		}

		this.collectionActionEventEmitter.emit({
			actionName: action.label,
			// % protected region % [Add any additional payload for onCollectionActionClicked here] off begin
			// % protected region % [Add any additional payload for onCollectionActionClicked here] end
		});

		// % protected region % [Add any additional onCollectionActionClicked logic after the main body here] off begin
		// % protected region % [Add any additional onCollectionActionClicked logic after the main body here] end
	}

	/**
	 * Triggered when an action against a selection of items is clicked.
	 */
	onMultipleItemsActionClicked(actionName: string) {
		// % protected region % [Add any additional onMultipleItemsActionClicked logic before the main body here] off begin
		// % protected region % [Add any additional onMultipleItemsActionClicked logic before the main body here] end

		let models;
		if (this.usingSelected) {
			models = Array.from(this.selectedModels);
		} else {
			models = Array.from(this.deselectedModels);
		}

		this.multipleItemsActionEventEmitter.emit({
			actionName: actionName,
			payload: {
				usingSelected: this.usingSelected,
				models: models,
				modelCount: this.modelCount
				// % protected region % [Add any additional payload here] off begin
				// % protected region % [Add any additional payload here] end
			}
		});

		// % protected region % [Add any additional onMultipleItemsActionClicked logic after the main body here] off begin
		// % protected region % [Add any additional onMultipleItemsActionClicked logic after the main body here] end
	}

	/**
	 * Triggered when a header is clicked to sort the current models accordingly to the header.
	 *
	 * @param opt the current header to be sorted against the array
	 */
	onHeaderClicked(opt: HeaderOption) {
		// % protected region % [Add any additional onHeaderClicked logic before the main logic here] off begin
		// % protected region % [Add any additional onHeaderClicked logic before the main logic here] end

		// Clear out everything and make sure that make sure that only the current header is flipped.
		const oldValue = this.areItemsSortedAscending[opt.name];
		Object.keys(this.areItemsSortedAscending).forEach(key => this.areItemsSortedAscending[key] = false);
		this.areItemsSortedAscending[opt.name] = !oldValue;

		// Pass to the parent component to sort the items
		// % protected region % [Customise the sortEmitter logic here] off begin
		this.sortEmitter.emit([
			{
				path: opt.name,
				descending: !this.areItemsSortedAscending[opt.name]
			}
		]);
		// % protected region % [Customise the sortEmitter logic here] end

		// % protected region % [Add any additional onHeaderClicked logic after the main logic here] off begin
		// % protected region % [Add any additional onHeaderClicked logic after the main logic here] end
	}

	/**
	 * Runs when the user clicks the 'Select all Entities' button.  Adds every entity from the full model list
	 * into the selected models
	 */
	onClickSelectAll() {
		this.usingSelected = false;
		this.deselectedModels.clear();
		this.selectedModels.clear();
	}

	/**
	 * Listen to the event when the filter button is clicked
	 */
	onFilter(event: { filterFormGroup: FormGroup }) {
		// % protected region % [Add any additional onFilter logic before the main logic here] off begin
		// % protected region % [Add any additional onFilter logic before the main logic here] end

		// need to reset expanded index as leaving it at the same number can cause accordion to be wrongfully opened on new page
		this.expandedIndex = null;
		this.filterEmitter.emit(event);

		// % protected region % [Add any additional onFilter logic after the main logic here] off begin
		// % protected region % [Add any additional onFilter logic after the main logic here] end
	}

	onSearch(value: string) {
		// % protected region % [Add any additional onSearch logic before the main logic here] off begin
		// % protected region % [Add any additional onSearch logic before the main logic here] end

		// need to reset expanded index as leaving it at the same number can cause accordion to be wrongfully opened on new page
		// Search generally handles returning to the previous state upon clearing (like restoring the page) but closing the accordion
		// seems like the better option here as it's very easy to reopen
		this.expandedIndex = null;
		this.searchEmitter.emit(value);

		// % protected region % [Add any additional onSearch logic after the main logic here] off begin
		// % protected region % [Add any additional onSearch logic after the main logic here] end
	}

	/**
	 * Given a header option and a model, determine and return the value to be displayed in the actual collection.
	 *
	 * @param opt the header option which determines how to read the model
	 * @param model the model that contains the information in some form
	 */
	getValue(opt: HeaderOption, model: E): string | Observable<any> {
		// % protected region % [Override the default display value mapping here] off begin
		if (opt.valueSource) {
			if (opt.sourceDirectFromModel && typeof opt.valueSource === 'string') {
				const value = model[opt.valueSource];
				if (value instanceof Date) {
					if (opt.type === ModelPropertyType.DATETIME) {
						return moment(value).format('DD MMM YYYY HH:mm');
					} else if (opt.type === ModelPropertyType.DATE) {
						return moment(value).format('DD MMM YYYY');
					} else if (opt.type === ModelPropertyType.TIME) {
						return moment(value).format('HH:mm:ss');
					}
					console.error(`Not supported date type be passed into ${opt.name}`);
					return moment(value).format('DD MMM YYYY HH:mm');
				} else if (opt.type === ModelPropertyType.ENUM) {
					const result = (value) ? (opt as ModelProperty).enumLiterals.find(item => item.value === value) : null;
					return (result && result.value) ? result.value : '';
				} else {
					return value;
				}
			} else if (typeof opt.valueSource === 'function') {
				return opt.valueSource();
			} else {
				return opt.valueSource;
			}
		} else if (opt.valueFunction) {
			return opt.valueFunction(model);
		} else {
			console.error('Error getting the value from thea HeaderOption');
			return '';
		}
		// % protected region % [Override the default display value mapping here] end
	}

	/**
	 * Triggered when the user requests the first page of the collection.
	 */
	onFirstPage() {
		// % protected region % [Add any additional onFirstPage logic before the main body here] off begin
		// % protected region % [Add any additional onFirstPage logic before the main body here] end

		// need to reset expanded index as leaving it at the same number can cause accordion to be wrongfully opened on new page
		this.expandedIndex = null;
		this.firstPageEmitter.emit(null);

		// % protected region % [Add any additional onFirstPage logic after the main body here] off begin
		// % protected region % [Add any additional onFirstPage logic after the main body here] end
	}

	/**
	 * Triggered when the user requests the previous page of the collection.
	 */
	onPreviousPage() {
		// % protected region % [Add any additional onPreviousPage logic before the main body here] off begin
		// % protected region % [Add any additional onPreviousPage logic before the main body here] end

		// need to reset expanded index as leaving it at the same number can cause accordion to be wrongfully opened on new page
		this.expandedIndex = null;
		this.prevPageEmitter.emit(null);

		// % protected region % [Add any additional onPreviousPage logic after the main body here] off begin
		// % protected region % [Add any additional onPreviousPage logic after the main body here] end
	}

	/**
	 * Triggered when the user requests the next page of the collection.
	 */
	onNextPage() {
		// % protected region % [Add any additional onNextPage logic before the main body here] off begin
		// % protected region % [Add any additional onNextPage logic before the main body here] end

		// need to reset expanded index as leaving it at the same number can cause accordion to be wrongfully opened on new page
		this.expandedIndex = null;
		this.nextPageEmitter.emit(null);

		// % protected region % [Add any additional onNextPage logic after the main body here] off begin
		// % protected region % [Add any additional onNextPage logic after the main body here] end
	}

	/**
	 * Triggered when the user requests the last page of the collection.
	 */
	onLastPage() {
		// % protected region % [Add any additional onLastPage logic before the main body here] off begin
		// % protected region % [Add any additional onLastPage logic before the main body here] end

		// need to reset expanded index as leaving it at the same number can cause accordion to be wrongfully opened on new page
		this.expandedIndex = null;
		this.lastPageEmitter.emit(null);

		// % protected region % [Add any additional onLastPage logic after the main body here] off begin
		// % protected region % [Add any additional onLastPage logic after the main body here] end
	}

	/**
	 * Used to determine whether an individual checkbox for an entity should be shown as selected or not
	 * @param modelId the id of the entity that we are checking for selection.  Selection is done by storing the id
	 * 					of selected/deselected entities so we can just check for whether the model id is present in the relevant array
	 * @returns true if the model is selected, false otherwise
	 */
	isCheckboxActive(modelId: string) {
		if (this.usingSelected) {
			return Array.from(this.selectedModels).map(selectedModel => selectedModel.id).includes(modelId);
		}

		return !Array.from(this.deselectedModels).map(deselectedModel => deselectedModel.id).includes(modelId);
	}

	/**
	 * Determines the number of entities which are currently selected.
	 * This number is displayed on the page when selecting entities, as selection persists through page changes.
	 */
	selectedModelCount(): number {
		if (this.usingSelected) {
			return this.selectedModels.size;
		}

		return this.modelCount - this.deselectedModels.size;
	}

	/**
	 * Determines the number of entities which are currently selected on the current page.
	 * This number is used for determining some logic regarding the select all checkbox, as this should be shown as checked when every entity on
	 * 			the page is selected, and false otherwise
	 * Also requires different logic based on whether we are tracking selected entities or entities excluded from selection, as
	 * there are different arrays which might need to be checked.
	 *
	 * @returns The number of entities currently selected in the component
	 */
	currentPageSelectedCount() {
		const modelIds = Array.from(this.models).map(model => model.id);

		// logic for both is the same, just using different arrays, as each array is only used when the relevant selection mode is active
		if (this.usingSelected) {
			const selectedIds = Array.from(this.selectedModels).map(selectedModel => selectedModel.id);
			return modelIds.filter(id => selectedIds.includes(id)).length;
		}

		const deselectedIds = Array.from(this.deselectedModels).map(deselectedModel => deselectedModel.id);
		return modelIds.length - modelIds.filter(id => deselectedIds.includes(id)).length;
	}

	/**
	 * Emit the event for importing a CSV file.  Also resets the state of the page to accomodate the changes caused by adding new entities in bulk
	 * 
	 * @param $event The file which has been selected by the user to upload.
	 * 					All input checking is done on the serverside so at this point this file just needs to be passed along
	 */
	emitImportAction($event) {
		this.collectionActionEventEmitter.emit({
			actionName: 'Import',
			payload: {
				file: $event.target.files[0]
			}
		});
		this.onSelectAllCancel(); // New entities are added by this action, so we reset the state of the current page
	}

	/**
	 * Emits the action to the wrapping crud list tile to download an example CSV for the entity type.
	 * 
	 * In the serverside import and example download are two different actions, so at this stage we differentiate them by not
	 * supplying a file if we want an example CSV
	 */
	emitDownloadCsvExample() {
		this.collectionActionEventEmitter.emit({
			actionName: 'Import',
		});
	}

	/**
	 * Changes the index of the currently active expand accordion.  As only one can be active at a time, if the 
	 * currently expanded index is passed in, then we reset the expanded index to null
	 * 
	 * @param index the index of the expand button which has just been clicked.  Either expands it or closes it,
	 * 				depending on whether that index is currently expanded
	 */
	toggleExpandedEntity(index: number) {
		if (index === this.expandedIndex) {
			this.expandedIndex = null;
			return;
		}

		this.expandedIndex = index;
	}

	/**
	 * Groups the attributes in an expand accordion into columns
	 *
	 * This is done so that the spacing between columns looks better, as wrapping the elements when they reach the bottom of the accordion
	 * leads to very unaesthetic spacing of columns. This also allows the accordion to scroll vertically.
	 *
	 * @param attributesPerColumn The number of attributes to put in each column.  Defaults to 3 in the bot written code
	 * @returns a 2d array of the elements in the expand options which groups them into arrays of the specified column length
	 */
	groupEntityExpands(attributesPerColumn: number): HeaderOption[][] {
		let currentIndex: number = 0;
		let groupedOptions: HeaderOption[][] = [];

		while (currentIndex < this.expandOptions.length) {
			let optionsColumn: HeaderOption[] = [];

			// When we get close to the end of the list of options, we need to be able to break the loop if
			// we get to the end, as we don't want undefined elements
			for (let i = 0; i < attributesPerColumn && currentIndex < this.expandOptions.length; i++) {
				optionsColumn.push(this.expandOptions[currentIndex]);
				currentIndex++;
			}
			groupedOptions.push(optionsColumn);
		}

		return groupedOptions;
	}

	// % protected region % [Add any additional class methods here] off begin
	// % protected region % [Add any additional class methods here] end
}
