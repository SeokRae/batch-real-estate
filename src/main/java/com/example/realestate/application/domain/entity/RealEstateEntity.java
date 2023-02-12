package com.example.realestate.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Table(name = "TB_REAL_ESTATE")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealEstateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "receipt_year")
	private String receiptYear;
	@Column(name = "district_code")
	private String districtCode;
	@Column(name = "district_name")
	private String districtName;
	@Column(name = "legal_dong_code")
	private String legalDongCode;
	@Column(name = "legal_dong_name")
	private String legalDongName;
	@Column(name = "lot_number_type")
	private String lotNumberType;
	@Column(name = "lot_number_type_name")
	private String lotNumberTypeName;
	@Column(name = "main_number")
	private String mainNumber;
	@Column(name = "sub_number")
	private String subNumber;
	@Column(name = "building_name")
	private String buildingName;
	@Column(name = "contract_date")
	private String contractDate;
	@Column(name = "real_estate_price")
	private String realEstatePrice;
	@Column(name = "building_area")
	private String buildingArea;
	@Column(name = "land_area")
	private String landArea;
	@Column(name = "floor")
	private String floor;
	@Column(name = "right_type")
	private String rightType;
	@Column(name = "cancel_date")
	private String cancelDate;
	@Column(name = "building_year")
	private String buildingYear;
	@Column(name = "building_type")
	private String buildingPurpose;
	@Column(name = "report_type")
	private String reportType;
	@Column(name = "report_agent")
	private String reportAgentDistrictName;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof RealEstateEntity)) return false;
		RealEstateEntity that = (RealEstateEntity) o;
		return Objects.equals(id, that.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return "RealEstateEntity{" +
			"id=" + id +
			", receiptYear='" + receiptYear + '\'' +
			", districtCode='" + districtCode + '\'' +
			", districtName='" + districtName + '\'' +
			", legalDongCode='" + legalDongCode + '\'' +
			", legalDongName='" + legalDongName + '\'' +
			", lotNumberType='" + lotNumberType + '\'' +
			", lotNumberTypeName='" + lotNumberTypeName + '\'' +
			", mainNumber='" + mainNumber + '\'' +
			", subNumber='" + subNumber + '\'' +
			", buildingName='" + buildingName + '\'' +
			", contractDate='" + contractDate + '\'' +
			", realEstatePrice='" + realEstatePrice + '\'' +
			", buildingArea='" + buildingArea + '\'' +
			", landArea='" + landArea + '\'' +
			", floor='" + floor + '\'' +
			", rightType='" + rightType + '\'' +
			", cancelDate='" + cancelDate + '\'' +
			", buildingYear='" + buildingYear + '\'' +
			", buildingPurpose='" + buildingPurpose + '\'' +
			", reportType='" + reportType + '\'' +
			", reportAgentDistrictName='" + reportAgentDistrictName + '\'' +
			'}';
	}
}