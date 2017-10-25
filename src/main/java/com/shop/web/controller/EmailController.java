package com.shop.web.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shop.web.dto.BasicEmailRequestDTO;
import com.shop.web.exception.ServiceCommunicationException;
import com.shop.web.service.EmailService;

@RestController
@RequestMapping("/email")
public class EmailController {

	@Inject
	private EmailService emailService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<String> forwardEmail(final BasicEmailRequestDTO request)
			throws ServiceCommunicationException {
		emailService.sendEmail(request);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ResponseEntity<String> generateAndSendReport() throws ServiceCommunicationException {
		emailService.generateAndSendReport();
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
