/**
 * 
 */
package com.kb.openidconnect.authorize.token;

import org.springframework.stereotype.Component;

/**
 * @author kylebennett
 *
 */
@Component
public class AuthorizationTokenBuilder implements TokenBuilder {

	@Override
	public String buildToken() {

		return "ThisIsAnAuthToken";
	}

}
