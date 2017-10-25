package com.shop.web.service.impl;

import java.net.URI;

import javax.inject.Inject;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shop.web.dto.PaymentDetailsDTO;
import com.shop.web.exception.ServiceCommunicationException;
import com.shop.web.service.PaymentValidatorService;

@Service
public class PaymentValidatorServiceImpl implements PaymentValidatorService {

	private static final String VALIDATOR_SERVICE = "payment-validation-service";
	private static final String ENDPOINT = "/validate";

	@Inject
	private RestTemplate restTemplate;

	@Inject
	private DiscoveryClient discoveryClient;
	
	@Override
	public void validate(PaymentDetailsDTO request) throws ServiceCommunicationException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<PaymentDetailsDTO> body = new HttpEntity<>(request, headers);
		try {
			URI uri = new URI(discoveryClient.getInstances(VALIDATOR_SERVICE).get(0).getUri() + ENDPOINT);
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, body, String.class);
			System.out.println("***" + response + "***");
		} catch (Exception e) {
			throw new ServiceCommunicationException("Communication with report-service failed", e.getMessage());
		}
	}

	
}
