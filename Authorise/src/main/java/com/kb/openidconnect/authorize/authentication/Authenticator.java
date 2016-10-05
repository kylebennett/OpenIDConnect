/**
 * 
 */
package com.kb.openidconnect.authorize.authentication;

import org.springframework.stereotype.Component;

/**
 * @author kylebennett
 *
 */
@Component
public interface Authenticator {

	public boolean authenticate(String userId);
}
