/**
 * 
 */
package com.kb.openidconnect.authorize.token;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kb.openidconnect.authorize.utils.Clock;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * @author kylebennett
 *
 */
@Component
public class AuthorizationTokenBuilder implements TokenBuilder {

	@Autowired
	Clock clock;

	@Override
	public String buildToken(String secret) {

		DateTime iat = clock.getCurrentTime();
		DateTime exp = iat.plusHours(12);

		String token = Jwts.builder().setSubject("User").setIssuedAt(iat.toDate()).setExpiration(exp.toDate())
				.signWith(SignatureAlgorithm.HS512, secret).compact();

		return token;
	}
}
