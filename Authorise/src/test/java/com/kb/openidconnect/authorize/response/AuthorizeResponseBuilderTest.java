/**
 * 
 */
package com.kb.openidconnect.authorize.response;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author kylebennett
 *
 */
public class AuthorizeResponseBuilderTest {

	private AuthorizeResponseBuilder builder = new AuthorizeResponseBuilder();

	private String redirectURI = "redirectURI";
	private String token = "token";
	private String state = "state";
	private String error = "error";
	private String description = "description";

	@Test
	public void testBuildSuccessResponse() throws Exception {

		String expectedResult = "redirectURI?code=token&state=state";

		String response = builder.buildSuccessResponse(redirectURI, token, state);

		assertThat(response).isEqualTo(expectedResult);
	}

	@Test
	public void testBuildErrorResponse() throws Exception {

		String expectedResult = "redirectURI?error=error&error_description=description&state=state";

		String response = builder.buildErrorResponse(redirectURI, error, description, state);

		assertThat(response).isEqualTo(expectedResult);
	}

}
