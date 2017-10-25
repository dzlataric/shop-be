package com.shop.web.dto;

public class PaymentDetailsDTO {

	private String accountNumber;
	private Long key;
	private Double toPay;
	
	public PaymentDetailsDTO(final String accountNumber, final Long key, final Double toPay) {
		this.accountNumber = accountNumber;
		this.key = key;
		this.toPay = toPay;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(final String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public Long getKey() {
		return key;
	}
	public void setKey(final Long key) {
		this.key = key;
	}
	public Double getToPay() {
		return toPay;
	}
	public void setToPay(Double toPay) {
		this.toPay = toPay;
	}
	
}
