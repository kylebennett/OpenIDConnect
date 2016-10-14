/**
 * 
 */
package com.kb.openidconnect.authorize.request;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 * @author kylebennett
 *
 */
public class AuthorizeRequestTest {

	String thisResponseType = "thisResponseType";
	String thatResponseType = "thatResponseType";
	String thisScope = "thisScope";
	String thatScope = "thatScope";
	String thisClientId = "thisClientId";
	String thatClientId = "thatClientId";
	String thisRedirectUri = "thisRedirectUri";
	String thatRedirectUri = "thatRedirectUri";
	String thisState = "thisState";
	String thatState = "thatState";

	AuthorizeRequest thisRequest = new AuthorizeRequest(thisResponseType, thisScope, thisClientId, thisRedirectUri,
			thisState);

	AuthorizeRequest thatRequest = new AuthorizeRequest(thatResponseType, thatScope, thatClientId, thatRedirectUri,
			thatState);

	@Test
	public void test_WhenEqual_EqualsReturnsTrue() {

		assertThat(thisRequest).isEqualTo(thisRequest);
	}

	@Test
	public void test_WhenNotEqual_EqualsReturnsFalse() {

		assertThat(thisRequest).isNotEqualTo(thatRequest);
	}

	@Test
	public void test_EqualToNull_EqualsReturnsFalse() {

		assertThat(thisRequest).isNotEqualTo(null);
	}

	@Test
	public void test_EqualToObject_EqualsReturnsFalse() {

		assertThat(thisRequest).isNotEqualTo(new Object());
	}
}
