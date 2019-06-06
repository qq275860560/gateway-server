package com.github.qq275860560.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenProviderChain;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeAccessTokenProvider;

@Configuration
public class OAuth2RestTemplateConfig {

	@Bean
	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext context, OAuth2ProtectedResourceDetails details) {
		OAuth2RestTemplate template = new OAuth2RestTemplate(details, context);

		AuthorizationCodeAccessTokenProvider authCodeProvider = new AuthorizationCodeAccessTokenProvider();
		authCodeProvider.setStateMandatory(false);// 或者配置server.servlet.session.cookie.name=OAUTH2SESSION
		AccessTokenProviderChain provider = new AccessTokenProviderChain(Arrays.asList(authCodeProvider));
		template.setAccessTokenProvider(provider);
		return template;
	}
}
