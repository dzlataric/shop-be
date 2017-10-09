package com.shop.web.controller;

import java.net.URI;

import javax.inject.Inject;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.shop.web.dto.BasicEmailRequestDTO;

@RestController
@RequestMapping("/email")
public class EmailController {

	private static final String EMAIL_SERVICE = "email-service";
	private static final String BASIC_EMAIL_ENDPOINT = "/send-email/basic";

	@Inject
	private RestTemplate restTemplate;

	@Inject
	private DiscoveryClient discoveryClient;

	@RequestMapping(value = "/forward", method = RequestMethod.POST)
	public ResponseEntity<String> forwardEmail(final BasicEmailRequestDTO request) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BasicEmailRequestDTO> body = new HttpEntity<>(request, headers);
		try {
			URI uri = new URI(discoveryClient.getInstances(EMAIL_SERVICE).get(0).getUri() + BASIC_EMAIL_ENDPOINT);
			restTemplate.exchange(uri, HttpMethod.POST, body, ResponseEntity.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
