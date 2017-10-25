package com.shop.web.dto;

public class OrdersDTO {
	
	private String firstName;
	private String lastName;
	private String orderDate;
	private String productName;
	private Long amount;
	private Double price;
	
	public OrdersDTO() {
		
	}

	public OrdersDTO(String firstName, String lastName, String orderDate, String productName, Long amount,
			Double price) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.orderDate = orderDate;
		this.productName = productName;
		this.amount = amount;
		this.price = price;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
