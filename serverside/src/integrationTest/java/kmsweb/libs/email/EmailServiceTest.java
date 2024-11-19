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
package kmsweb.libs.email;

import kmsweb.SpringTestConfiguration;
import kmsweb.lib.services.email.Email;
import kmsweb.lib.services.email.EmailService;
import kmsweb.utils.SmtpServerRule;
import freemarker.core.InvalidReferenceException;
import freemarker.template.TemplateNotFoundException;
import org.apache.groovy.util.Maps;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Set;

// % protected region % [Add any additional imports for setup before the main body here] off begin
// % protected region % [Add any additional imports for setup before the main body here] end

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = SpringTestConfiguration.class)
@ActiveProfiles("test")
public class EmailServiceTest {

	@Autowired
	EmailService emailService;

	public SmtpServerRule smtpServerRule = new SmtpServerRule();

	// % protected region % [Add any additional fields for here] off begin
	// % protected region % [Add any additional fields for here] end

	@BeforeEach
	public void setup() {
		// % protected region % [Add any additional logic for setup before the main body here] off begin
		// % protected region % [Add any additional logic for setup before the main body here] end

		smtpServerRule.beforeEach();

		// % protected region % [Add any additional logic for setup after the main body here] off begin
		// % protected region % [Add any additional logic for setup after the main body here] end
	}

	@AfterEach
	public void teardown() {

		// % protected region % [Add any additional logic for teardown before the main body here] off begin
		// % protected region % [Add any additional logic for teardown before the main body here] end

		smtpServerRule.afterEach();

		// % protected region % [Add any additional logic for teardown after the main body here] off begin
		// % protected region % [Add any additional logic for teardown after the main body here] end
	}

	@Test
	public void testSendEmailWithValidTemplateString() throws Exception{

		Email email = createFakeEmail();

		String testingEmailTemplate = "<h1>${test}</h1>";
		String renderedContent = "<h1>testing value</h1>";

		// Test
		this.emailService.sendEmailWithTemplateString(email, testingEmailTemplate);

		// Check the content of email is updated
		Assertions.assertEquals(email.getContent(), renderedContent);

		// % protected region % [Add any additional logic here for testSendEmailWithValidTemplateString] off begin
		// % protected region % [Add any additional logic here for testSendEmailWithValidTemplateString] end
	}

	@Test
	public void testSendEmailWithMissingVariable() {
		Email email = createFakeEmail();

		String testingEmailTemplate = "<h1>${missing}</h1>";

		// Test
		Assertions.assertThrows(InvalidReferenceException.class, () -> {
			this.emailService.sendEmailWithTemplateString(email, testingEmailTemplate);
		});

		// % protected region % [Add any additional logic here for InvalidReferenceException] off begin
		// % protected region % [Add any additional logic here for InvalidReferenceException] end
	}

	@Test
	public void testSendEmailWithValidTemplateFileName() throws Exception {
		Email email = createFakeEmail();
		email.setTemplateName("Test.template.html");
		this.emailService.sendEmailWithTemplateName(email);

		// % protected region % [Add any additional logic here for testSendEmailWithValidTemplateFileName] off begin
		// % protected region % [Add any additional logic here for testSendEmailWithValidTemplateFileName] end
	}

	@Test
	public void testSendEmailWithInValidTemplateFileName() {
		Email email = createFakeEmail();
		email.setTemplateName("InvalidNameTest.template.html");

		Assertions.assertThrows(TemplateNotFoundException.class, () -> {
			this.emailService.sendEmailWithTemplateName(email);
		});

		// % protected region % [Add any additional logic here for testSendEmailWithInValidTemplateFileNamme] off begin
		// % protected region % [Add any additional logic here for testSendEmailWithInValidTemplateFileNamme] end
	}

	private Email createFakeEmail() {
		Email email = new Email();
		email.setSubject("Testing Email");
		email.setReceiptEmailAddresses(Set.of("test@example.com"));
		email.setSenderEmailAddress("test@example.com");
		email.setEmailVariables(Maps.of(
				"test", "testing value"
		));

		// % protected region % [Add any additional logic here for createFakeEmail] off begin
		// % protected region % [Add any additional logic here for createFakeEmail] end

		return email;
	}

	// % protected region % [Add any additional test cases here] off begin
	// % protected region % [Add any additional test cases here] end
}