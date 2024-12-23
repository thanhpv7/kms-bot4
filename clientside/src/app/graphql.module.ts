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

import {APOLLO_OPTIONS} from 'apollo-angular';
import {ApolloLink, InMemoryCache} from '@apollo/client/core';
import {HttpLink} from 'apollo-angular/http';
import {onError} from '@apollo/client/link/error';
import {NgModule} from '@angular/core';
import {ToastrService} from 'ngx-toastr';
import {environment} from '../environments/environment';

const uri = environment.API_URL + '/graphql';

/**
 * Function returning an error handler for Apollo. Require to be in function form since we need Toastr for notification
 * display.
 */
const errorLink = (toastrService: ToastrService) => onError(({operation: {operationName}, graphQLErrors, networkError}) => {
	let title: string = '';

	switch (operationName) {
		case 'Count':
			title = 'Unable to count the entities';
			break;
		case 'Get':
			title = 'Unable to fetch the entities';
			break;
		case 'GetWithQuery':
			title = 'Unable to fetch the entities';
			break;
		case 'GetLastWithQuery':
			title = 'Unable to fetch the entities';
			break;
		case 'Create':
			title = 'Unable to create the entity';
			break;
		case 'Update':
			title = 'Unable to update the entity';
			break;
		case 'Delete':
			title = 'Unable to delete the entity';
			break;
		case 'GetAudits':
			title = 'Unable to fetch the entity audits';
			break;
		// % protected region % [Add additional operation cases here] off begin
		// % protected region % [Add additional operation cases here] end
		default:
			title = 'Unknown query found';
			break;
	}

	// % protected region % [Add additional error handling here] off begin
	// % protected region % [Add additional error handling here] end

	if (graphQLErrors) {
		graphQLErrors.forEach(({message}) => {
			toastrService.error(`${message}`, title);
		});
	} else {
		toastrService.error(title);
	}

	// % protected region % [Add post toaster graphQL error handling here] off begin
	// % protected region % [Add post toaster graphQL error handling here] end

});

const cleanTypeName = new ApolloLink((operation, forward) => {
	if (operation.variables) {
		const omitTypename = (key, value) => (key === '__typename' ? undefined : value);
		operation.variables = JSON.parse(JSON.stringify(operation.variables), omitTypename);
	}
	return forward(operation).map((data) => {
		return data;
	});
});

export function createApollo(httpLink: HttpLink, toastrService) {
	return {
		link: ApolloLink.from([
			cleanTypeName,
			errorLink(toastrService),
			httpLink.create({
				uri: uri,
				withCredentials: true
			})
		]),
		cache: new InMemoryCache(),
		defaultOptions: {
			query: {
				fetchPolicy: 'no-cache'
			}
		}
	};
}

@NgModule({
	providers: [
		{
			provide: APOLLO_OPTIONS,
			useFactory: createApollo,
			deps: [HttpLink, ToastrService]
		},
	],
})
export class GraphQLModule {
}
