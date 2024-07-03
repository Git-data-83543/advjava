package com.sunbeam.dto;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AddressDTO {
	@JsonProperty(access = Access.WRITE_ONLY)
	private Long userId;
	private String adrLine1;
	private String adrLine2;
	private String city;
	private String state;
	private String country;
	private String zipCode;
	private String phoneNo;
}
