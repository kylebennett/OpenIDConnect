/**
 * 
 */
package com.kb.openidconnect.authorize.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.kb.openidconnect.authorize.request.AuthorizeRequest;
import com.kb.openidconnect.authorize.validator.Validator;

/**
 * @author kylebennett
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AuthorizeControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@MockBean
	private Validator<AuthorizeRequest> validator;

	@Test
	public void whenAuthorizeCalledWIthValidParameters_ThenReturnAuthTokenAndState() {

		String responseType = "code";
		String scope = "openid";
		String client_id = "client_id";
		String redirectUri = "https%253A%252F%252Fclient.example.org%252Fcb";
		String state = "state";

		AuthorizeRequest request = new AuthorizeRequest(responseType, scope, client_id, redirectUri, state);

		when(validator.isValid(request)).thenReturn(true);

		String queryFormat = "?response_type=%s&scope=%s&client_id=%s&redirect_uri=%s&state=%s";

		String url = "/authorize" + String.format(queryFormat, responseType, scope, client_id, redirectUri, state);

		String response = this.restTemplate.getForObject(url, String.class);

		System.out.println(response);

		assertThat(response).contains("code=");
		assertThat(response).contains("&state=state");

	}
}
