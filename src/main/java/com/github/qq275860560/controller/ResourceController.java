package com.github.qq275860560.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class ResourceController {

	@Autowired
	OAuth2RestTemplate oAuth2RestTemplate;

	@Value("${resourceUrl}")
	String resourceUrl;

	@RequestMapping(value = "/api/github/qq275860560/resource/getResource")
	public Map<String, Object> getResource() {
		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext()
				.getAuthentication();
		String username = oAuth2Authentication.getUserAuthentication() == null ? null
				: oAuth2Authentication.getUserAuthentication().getName();
		String clientId = oAuth2Authentication.getOAuth2Request().getClientId();
		log.info("资源用户名称=" + username + ",客户端id=" + clientId);
		return oAuth2RestTemplate.getForObject(resourceUrl + "/api/github/qq275860560/resource/getResource?id="
				+ clientId + "_" + username + "_resource", Map.class);
	}

	@RequestMapping(value = "/api/github/qq275860560/resource/saveResource")
	public Map<String, Object> saveResource() {
		OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) SecurityContextHolder.getContext()
				.getAuthentication();
		String username = oAuth2Authentication.getUserAuthentication() == null ? null
				: oAuth2Authentication.getUserAuthentication().getName();
		String clientId = oAuth2Authentication.getOAuth2Request().getClientId();
		log.info("资源用户名称=" + username + ",客户端id=" + clientId);
		return oAuth2RestTemplate.getForObject(resourceUrl + "/api/github/qq275860560/resource/saveResource",
				Map.class);
	}
}
