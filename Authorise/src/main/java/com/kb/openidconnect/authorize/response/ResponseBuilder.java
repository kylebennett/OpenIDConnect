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
public interface ResponseBuilder {

	String buildSuccessResponse(String redirectURI, String token, String state);

	String buildErrorResponse(String redirectURI, String error, String description, String state);
}
