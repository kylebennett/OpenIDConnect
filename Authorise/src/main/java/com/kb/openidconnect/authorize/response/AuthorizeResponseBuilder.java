/**
 * 
 */
package com.kb.openidconnect.authorize.response;

import org.springframework.stereotype.Component;

/**
 * @author kylebennett
 *
 */
@Component
public class AuthorizeResponseBuilder implements ResponseBuilder {

	@Override
	public String buildSuccessResponse(String redirectURI, String token, String state) {

		return String.format("%s?code=%s&state=%s", redirectURI, token, state);
	}

	@Override
	public String buildErrorResponse(String redirectURI, String error, String description, String state) {

		return String.format("%s?error=%s&error_description=%s&state=%s", redirectURI, error, description, state);
	}

}
