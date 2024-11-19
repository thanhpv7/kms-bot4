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
package kmsweb.controllers;

import kmsweb.SpringTestConfiguration;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestConfiguration.class)
@ActiveProfiles("test")
public class CoTreatingDoctorControllerTest {

	// % protected region % [Add additional schema name constants here] off begin
	// % protected region % [Add additional schema name constants here] end

	@Autowired
	private WebApplicationContext context;

	@Before
	public void setup() {
		RestAssuredMockMvc.webAppContextSetup(context);

		// % protected region % [Add any additional setup here] off begin
		// % protected region % [Add any additional setup here] end
	}


	/**
	 * Test the non-authenticated access for the Visitors Group for GET all REST endpoint.
	 *
	 */
	@Test
	public void checkAuthorisationForVisitorsGetAll() {
		// % protected region % [Customise setup for GET all here] off begin
		// % protected region % [Customise setup for GET all here] end

		RestAssuredMockMvc
				.given()
				.when()
				.get("/api/cotreatingdoctor")
				.then()
				// % protected region % [Customise your GET all validation here] off begin
				.statusCode(401);
				// % protected region % [Customise your GET all validation here] end
	}

	/**
	 * Test the non-authenticated access for the Visitors Group for GET REST endpoint.
	 */
	@Test
	public void checkAuthorisationForVisitorsGet() {
		// % protected region % [Customise setup for GET here] off begin
		// % protected region % [Customise setup for GET here] end

		RestAssuredMockMvc
				.given()
				.when()
				/* Use a random UUID to test security */
				.get("/api/cotreatingdoctor/ec8d16d0-484b-405b-b024-977161a9faee")
				.then()
				// % protected region % [Customise your GET validation here] off begin
				.statusCode(401);
				// % protected region % [Customise your GET validation here] end
	}

	/**
	 * Test the non-authenticated access for the Visitors Group for the POST REST endpoint.
	 */
	@Test
	public void checkAuthorisationForVisitorsPost() {
		// % protected region % [Customise setup for POST here] off begin
		// % protected region % [Customise setup for POST here] end

		RestAssuredMockMvc
				.given()
				.when()
				.post("/api/cotreatingdoctor")
				.then()
				// % protected region % [Customise your POST validation here] off begin
				.statusCode(401);
				// % protected region % [Customise your POST validation here] end
	}

	/**
	 * Test the non-authenticated access for the Visitors Group for the PUT REST endpoint.
	 *
	 */
	@Test
	public void checkAuthorisationForVisitorsPut() {
		// % protected region % [Customise setup for PUT here] off begin
		// % protected region % [Customise setup for PUT here] end

		RestAssuredMockMvc
				.given()
				.when()
				.put("/api/cotreatingdoctor")
				.then()
				// % protected region % [Customise your PUT validation here] off begin
				.statusCode(401);
			// % protected region % [Customise your PUT validation here] end
	}

	/**
	 * Test the non-authenticated access for the Visitors Group for the DELETE REST endpoint.
	 *
	 */
	@Test
	public void checkAuthorisationForVisitorsDelete() {
		// % protected region % [Customise setup for DELETE here] off begin
		// % protected region % [Customise setup for DELETE here] end

		RestAssuredMockMvc
				.given()
				.when()
				/* Use a random UUID to test security */
				.delete("/api/cotreatingdoctor/ec8d16d0-484b-405b-b024-977161a9faee")
				.then()
				// % protected region % [Customise your DELETE validation here] off begin
				.statusCode(401);
			// % protected region % [Customise your DELETE validation here] end
	}

	// % protected region % [Add custom tests here] off begin
	// % protected region % [Add custom tests here] end

}