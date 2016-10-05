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
public interface TokenBuilder {

	public String buildToken();
}
