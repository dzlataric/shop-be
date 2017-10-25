package com.shop.web.service;

import com.shop.web.dto.BasicEmailRequestDTO;
import com.shop.web.exception.ServiceCommunicationException;

public interface EmailService {

	void sendEmail(BasicEmailRequestDTO request) throws ServiceCommunicationException;
	
	void generateAndSendReport() throws ServiceCommunicationException;
}
