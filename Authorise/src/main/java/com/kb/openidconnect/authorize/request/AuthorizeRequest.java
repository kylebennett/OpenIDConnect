/**
 *
 */
package com.kb.openidconnect.authorize.request;

/**
 * @author Kyle
 *
 */
public class AuthorizeRequest {

	private String responseType;
	private String scope;
	private String clientId;
	private String redirectURI;
	private String state;

	public AuthorizeRequest(String responseType, String scope, String clientId, String redirectURI, String state) {

		this.responseType = responseType;
		this.scope = scope;
		this.clientId = clientId;
		this.redirectURI = redirectURI;
		this.state = state;
	}

	/**
	 * @return the responseType
	 */
	public String getResponseType() {
		return responseType;
	}

	/**
	 * @param responseType
	 *            the responseType to set
	 */
	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	/**
	 * @return the scope
	 */
	public String getScope() {
		return scope;
	}

	/**
	 * @param scope
	 *            the scope to set
	 */
	public void setScope(String scope) {
		this.scope = scope;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the redirectURI
	 */
	public String getRedirectURI() {
		return redirectURI;
	}

	/**
	 * @param redirectURI
	 *            the redirectURI to set
	 */
	public void setRedirectURI(String redirectURI) {
		this.redirectURI = redirectURI;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AuthorizeRequest [responseType=").append(responseType).append(", scope=").append(scope)
				.append(", clientId=").append(clientId).append(", redirectURI=").append(redirectURI).append(", state=")
				.append(state).append("]");
		return builder.toString();
	}
}
