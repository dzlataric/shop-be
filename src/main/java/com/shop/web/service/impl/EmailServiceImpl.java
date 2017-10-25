package com.shop.web.service.impl;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.shop.web.dto.BasicEmailRequestDTO;
import com.shop.web.dto.OrdersDTO;
import com.shop.web.exception.ServiceCommunicationException;
import com.shop.web.service.EmailService;
import com.shop.web.service.OrderService;

@Service
public class EmailServiceImpl implements EmailService {

	private static final String EMAIL_SERVICE = "report-service";
	private static final String BASIC_EMAIL_ENDPOINT = "/send-email/basic";
	private static final String REPORT_EMAIL_ENDPOINT = "/send-email/report";

	@Inject
	private RestTemplate restTemplate;

	@Inject
	private DiscoveryClient discoveryClient;

	@Inject
	private OrderService orderService;

	@Override
	public void sendEmail(BasicEmailRequestDTO request) throws ServiceCommunicationException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<BasicEmailRequestDTO> body = new HttpEntity<>(request, headers);
		try {
			URI uri = new URI(discoveryClient.getInstances(EMAIL_SERVICE).get(0).getUri() + BASIC_EMAIL_ENDPOINT);
			restTemplate.exchange(uri, HttpMethod.POST, body, ResponseEntity.class);
		} catch (Exception e) {
			throw new ServiceCommunicationException("Communication with report-service failed", e.getMessage());
		}
	}

	@Override
	public void generateAndSendReport() throws ServiceCommunicationException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<List<OrdersDTO>> body = new HttpEntity<>(orderService.forReport(), headers);
		try {
			URI uri = new URI(discoveryClient.getInstances(EMAIL_SERVICE).get(0).getUri() + REPORT_EMAIL_ENDPOINT);
			restTemplate.exchange(uri, HttpMethod.POST, body, ResponseEntity.class);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceCommunicationException("Communication with report-service failed", e.getMessage());
		}
	}

}
