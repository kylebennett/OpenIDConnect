/**
 * 
 */
package com.kb.openidconnect.authorize.token;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.kb.openidconnect.authorize.utils.Clock;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

/**
 * @author kylebennett
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorizationTokenBuilderTest {

	private String correctSecret = "ThisIsASecret";
	private String incorrectSecret = "ThisIsNotASecret";

	private String expectedSubject = "User";

	private DateTime expectedIat = new DateTime();
	private DateTime expectedExp = expectedIat.plusHours(12);

	@MockBean
	private Clock clock;

	@Autowired
	private AuthorizationTokenBuilder tokenBuilder = new AuthorizationTokenBuilder();

	@Test
	public void test_WhenBuildToken_VerifiedWithCorrectSecret() throws Exception {

		when(clock.getCurrentTime()).thenReturn(expectedIat);

		String token = tokenBuilder.buildToken(correctSecret);

		try {
			Claims claims = Jwts.parser().setSigningKey(correctSecret).parseClaimsJws(token).getBody();

			assertThat(claims.getSubject()).isEqualTo(expectedSubject);
			assertThat(claims.getExpiration()).isCloseTo(expectedExp.toDate(), 1000);
			assertThat(claims.getIssuedAt()).isCloseTo(expectedIat.toDate(), 1000);

		} catch (SignatureException se) {
			fail(se.getMessage());
		}
	}

	@Test(expected = SignatureException.class)
	public void test_WhenBuildToken_VerifiedWithIncorrectSecret() throws Exception {

		when(clock.getCurrentTime()).thenReturn(expectedIat);

		String token = tokenBuilder.buildToken(correctSecret);

		System.out.println(token);

		Claims claims = Jwts.parser().setSigningKey(incorrectSecret).parseClaimsJws(token).getBody();
		assertThat(claims.getSubject()).isEqualTo(expectedSubject);
	}

}
