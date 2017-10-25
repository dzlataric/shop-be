package com.shop.web.service;

import com.shop.web.dto.PaymentDetailsDTO;
import com.shop.web.exception.ServiceCommunicationException;

public interface PaymentValidatorService {

	void validate(PaymentDetailsDTO request) throws ServiceCommunicationException;
	
}
