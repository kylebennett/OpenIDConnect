/**
 *
 */
package com.kb.openidconnect.authorize.controller;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kb.openidconnect.authorize.request.AuthorizeRequest;
import com.kb.openidconnect.authorize.response.ResponseBuilder;
import com.kb.openidconnect.authorize.token.TokenBuilder;
import com.kb.openidconnect.authorize.validator.Validator;

/**
 * @author Kyle
 *
 */
@RestController
public class AuthorizeController {

	private static final Logger LOG = Logger.getLogger(AuthorizeController.class);

	@Autowired
	private Validator<AuthorizeRequest> validator;

	@Autowired
	private TokenBuilder tokenBuilder;

	@Autowired
	private ResponseBuilder responseBuilder;

	private static final String SECRET = "SECRET";

	@RequestMapping("/authorize")
	public String authorize(@RequestParam(value = "response_type", required = true) final String responseType,
			@RequestParam(value = "scope", required = true) final String scope,
			@RequestParam(value = "client_id", required = true) final String clientId,
			@RequestParam(value = "redirect_uri", required = true) final String redirectURI,
			@RequestParam(value = "state", required = false) final String state) {

		LOG.debug("Authorise Request Received");

		// create object
		final AuthorizeRequest request = new AuthorizeRequest(responseType, scope, clientId, redirectURI, state);

		LOG.debug(request);

		// validate request

		final boolean valid = validator.isValid(request);

		if (valid) {

			// authenticate user

			// get user consent

			// build token
			String authToken = tokenBuilder.buildToken(SECRET);

			// return success response
			return responseBuilder.buildSuccessResponse(request.getRedirectURI(), authToken, request.getState());

		} else {

			String responseUrl = responseBuilder.buildErrorResponse(request.getRedirectURI(), "error", "description",
					request.getState());

			// return error response
			return "redirect:" + responseUrl;
		}

	}
}
