package com.example.realestate.application.domain.files;

import java.util.Arrays;

public enum RealEstateType {
	접수연도("접수연도"),
	자치구코드("자치구코드"),
	자치구명("자치구명"),
	법정동코드("법정동코드"),
	법정동명("법정동명"),
	지번구분("지번구분"),
	지번구분명("지번구분명"),
	본번("본번"),
	부번("부번"),
	건물명("건물명"),
	계약일("계약일"),
	물건금액("물건금액"),
	건물면적("건물면적"),
	토지면적("토지면적"),
	층("층"),
	권리구분("권리구분"),
	취소일("취소일"),
	건축년도("건축년도"),
	건물용도("건물용도"),
	신고구분("신고구분"),
	신고한_개업공인중개사_시군구명("신고한_개업공인중개사_시군구명");
	private final String fieldName;
	
	RealEstateType(String fieldName) {
		this.fieldName = fieldName;
	}
	
	public static String[] fieldNames() {
		return Arrays.stream(RealEstateType.values())
			.map(realEstateType -> realEstateType.fieldName)
			.toArray(String[]::new);
	}
}