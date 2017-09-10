package com.shop.web.util;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class JwtAuthenticationResponse implements Serializable {

	private static final long serialVersionUID = 512111873786850533L;
	
	private final String token;

}
