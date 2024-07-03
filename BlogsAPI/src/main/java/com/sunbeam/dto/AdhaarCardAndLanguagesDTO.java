package com.sunbeam.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdhaarCardAndLanguagesDTO {

	private Long UserId;
	private String cardNumber;
	private String location;
	private List<String> languages;
}
