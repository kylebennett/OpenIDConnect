/**
 * 
 */
package com.kb.openidconnect.authorize.validator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import com.kb.openidconnect.authorize.request.AuthorizeRequest;

/**
 * @author kylebennett
 *
 */
public class AuthorizeRequestValidatorTest {

	private String scope = "openid";
	private String responseType = "response_type";
	private String clientId = "client_id";
	private String redirectURI = "redirect_uri";
	private String state = "state";

	AuthorizeRequestValidator<AuthorizeRequest> validator = new AuthorizeRequestValidator<>();

	@Test
	public void test_isValid_ValidRequest_willReturnTrue() {

		AuthorizeRequest request = new AuthorizeRequest(responseType, scope, clientId, redirectURI, state);

		assertThat(validator.isValid(request)).isTrue();
	}

	@Test
	public void test_isValid_RequestWithNullResponseType_willReturnFalse() {

		AuthorizeRequest request = new AuthorizeRequest(null, scope, clientId, redirectURI, state);

		assertThat(validator.isValid(request)).isFalse();
	}

	@Test
	public void test_isValid_RequestWithEmptyResponseType_willReturnFalse() {

		AuthorizeRequest request = new AuthorizeRequest("", scope, clientId, redirectURI, state);

		assertThat(validator.isValid(request)).isFalse();
	}

	@Test
	public void test_isValid_RequestWithNullScope_willReturnFalse() {

		AuthorizeRequest request = new AuthorizeRequest(responseType, null, clientId, redirectURI, state);

		assertThat(validator.isValid(request)).isFalse();
	}

	@Test
	public void test_isValid_RequestWithScopeNotOpenID_WillReturnFalse() {

		AuthorizeRequest request = new AuthorizeRequest(responseType, "notOpenID", clientId, redirectURI, state);

		assertThat(validator.isValid(request)).isFalse();
	}

	@Test
	public void test_isValid_RequestWithEmptyScope_willReturnFalse() {

		AuthorizeRequest request = new AuthorizeRequest(responseType, "", clientId, redirectURI, state);

		assertThat(validator.isValid(request)).isFalse();
	}

	@Test
	public void test_isValid_RequestWithNullClientId_WillReturnFalse() {

		AuthorizeRequest request = new AuthorizeRequest(responseType, scope, null, redirectURI, state);

		assertThat(validator.isValid(request)).isFalse();
	}

	@Test
	public void test_isValid_RequestWithEmptyClientId_WillReturnFalse() {

		AuthorizeRequest request = new AuthorizeRequest(responseType, scope, "", redirectURI, state);

		assertThat(validator.isValid(request)).isFalse();
	}

	@Test
	public void test_isValid_RequestWithNullRedirectURI_WillReturnFalse() {

		AuthorizeRequest request = new AuthorizeRequest(responseType, scope, clientId, null, state);

		assertThat(validator.isValid(request)).isFalse();
	}

	@Test
	public void test_isValid_RequestWithEmptyRedirectURI_WillReturnFalse() {

		AuthorizeRequest request = new AuthorizeRequest(responseType, scope, clientId, "", state);

		assertThat(validator.isValid(request)).isFalse();
	}
}
