/**
 *
 */
package com.kb.controllers;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kb.requests.AuthorizeRequest;
import com.kb.validators.AuthorizeRequestValidator;

/**
 * @author Kyle
 *
 */
@RestController
public class AuthoriseController {

    private static final Logger                               LOG       = Logger.getLogger(AuthoriseController.class);

    private final AuthorizeRequestValidator<AuthorizeRequest> validator = new AuthorizeRequestValidator<>();

    @RequestMapping("/authorize")
    public String authorize(@RequestParam(value = "response_type", required = true) final String responseType,
            @RequestParam(value = "scope", required = true) final String scope,
            @RequestParam(value = "client_id", required = true) final String clientId,
            @RequestParam(value = "redirect_uri", required = true) final String redirectURI,
            @RequestParam(value = "state", required = false) final String state) {

        LOG.debug(String
                .format("Authorise Request Received: response_type [%s] - scope [%s] - client_id [%s] - redirect_uri [%s], state [%s]",
                        responseType, scope, clientId, redirectURI, state));

        // create object
        final AuthorizeRequest request = new AuthorizeRequest();

        // validate request

        final boolean valid = validator.isValid(request);

        if (valid) {

            // authenticate user

            // get user consent

            // return success response
            return "Success";
        }
        else {

            // return error response
            return "Error";
        }

    }
}
