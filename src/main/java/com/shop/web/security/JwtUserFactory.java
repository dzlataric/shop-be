package com.shop.web.security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.shop.web.entity.Authority;
import com.shop.web.entity.Customer;

public final class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(Customer customer) {
		return new JwtUser(customer.getId(), customer.getUsername(), customer.getPassword(), customer.getFirstName(),
				customer.getLastName(), customer.getEmail(), customer.getAddress(), customer.getCity(),
				customer.getCountry(), customer.getEnabled(), customer.getLastPasswordResetDate(),
				mapToGrantedAuthorities(customer.getAuthorities()));
	}

	private static List<GrantedAuthority> mapToGrantedAuthorities(List<Authority> authorities) {
		return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority.getName().name()))
				.collect(Collectors.toList());
	}
}
