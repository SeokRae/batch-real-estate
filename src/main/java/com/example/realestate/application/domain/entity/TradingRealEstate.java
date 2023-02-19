package com.example.realestate.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "TB_TRADE_REAL_ESTATE", indexes = {
	@Index(name = "idx_trading_unq", columnList = "TRADING__ID", unique = true),
	@Index(name = "idx_contract", columnList = "RECEIPT_YEAR, CONTRACT_DATE")
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TradingRealEstate {
	
	@Id
	@Column(name = "TRADING__ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "RECEIPT_YEAR") @Comment("접수연도")
	private String receiptYear;
	@Column(name = "CONTRACT_DATE") @Comment("계약일")
	private LocalDate contractDate;
	@Column(name = "CANCEL_DATE") @Comment("취소일")
	private LocalDate cancelDate;
	@Column(name = "PRICE") @Comment("거래금액")
	private BigDecimal realEstatePrice;
	@Column(name = "REPORT_TYPE") @Comment("신고구분")
	private String reportType;
	@Column(name = "REPORT_AGENT") @Comment("공인중개사 시군구명")
	private String reportAgent;
}
