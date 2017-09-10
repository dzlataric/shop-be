package com.shop.web.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Wither;

@Getter
@Setter
@Wither
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CUSTOMER")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USERNAME", unique = true, nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Column(name = "FIRST_NAME", unique = false, nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", unique = false, nullable = false)
	private String lastName;

	@Column(name = "EMAIL", unique = false, nullable = false)
	private String email;

	@Column(name = "ADDRESS", unique = false, nullable = true)
	private String address;

	@Column(name = "CITY", unique = false, nullable = true)
	private String city;

	@Column(name = "COUNTRY", unique = false, nullable = true)
	private String country;

	@Column(name = "ENABLED")
	private Boolean enabled;

	@Column(name = "LASTPASSWORDRESETDATE")
	private Date lastPasswordResetDate;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_AUTHORITY", joinColumns = {
			@JoinColumn(name = "USER_ID", referencedColumnName = "ID") }, inverseJoinColumns = {
					@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID") })
	private List<Authority> authorities;

}
