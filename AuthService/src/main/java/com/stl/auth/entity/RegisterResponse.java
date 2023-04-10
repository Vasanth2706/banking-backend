package com.stl.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {

	private String customerId;
	private String firstName;
	private String lastName;
	private String token;
}
