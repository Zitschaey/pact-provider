package de.pact.provider.providerisbn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.StateChangeAction;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = App.class)
@Provider("bookservice")
@PactFolder("pacts")
public class ProviderTest {

	@LocalServerPort
	public int port;

	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	public void pactVerificationTest(PactVerificationContext context) {
		context.verifyInteraction();
	}

	@BeforeEach
	public void setup(PactVerificationContext context) {
		context.setTarget(new HttpTestTarget("localhost", port));
	}

	@State(value = "book with id 1 exists", action = StateChangeAction.SETUP)
	public void courseExist() {
	}

	@State(value = "book with id 1 exists", action = StateChangeAction.TEARDOWN)
	public void courseExistTeardown() {
	}

}
