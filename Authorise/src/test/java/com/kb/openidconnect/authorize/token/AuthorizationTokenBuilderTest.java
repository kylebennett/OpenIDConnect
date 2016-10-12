/**
 * 
 */
package com.kb.openidconnect.authorize.token;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author kylebennett
 *
 */
public class AuthorizationTokenBuilderTest {

	private AuthorizationTokenBuilder tokenBuilder = new AuthorizationTokenBuilder();

	@Test
	public void testBuildToken() throws Exception {

		assertThat(tokenBuilder.buildToken()).isEqualTo("ThisIsAnAuthToken");
	}

}
