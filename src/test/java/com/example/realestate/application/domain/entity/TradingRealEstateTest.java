package com.example.realestate.application.domain.entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

class TradingRealEstateTest {
	
	@Test
	void testCase1() {
		LocalDate parse = LocalDate.parse("20230207", DateTimeFormatter.BASIC_ISO_DATE);
		System.out.println("parse = " + parse);
	}
	
	@Test
	void testCase2() {
		LocalDate date = LocalDate.parse("2023", DateTimeFormatter.ofPattern("yyyy"));
		System.out.println("date = " + date);
	}
}