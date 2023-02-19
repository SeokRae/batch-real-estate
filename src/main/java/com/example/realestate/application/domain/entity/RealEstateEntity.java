package com.example.realestate.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Table(name = "TB_REAL_ESTATE", indexes = {
	@Index(name = "idx_id_unq", columnList = "id", unique = true),
	@Index(name = "idx_local_area", columnList = "id, district_code, legal_dong_code")
})
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealEstateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "receipt_year") @Comment("접수연도")
	private String receiptYear;
	@Column(name = "district_code") @Comment("자치구코드")
	private String districtCode;
	@Column(name = "district_name") @Comment("자치구명")
	private String districtName;
	@Comment("법정동코드")
	@Column(name = "legal_dong_code")
	private String legalDongCode;
	@Comment("법정동명")
	@Column(name = "legal_dong_name")
	private String legalDongName;
	@Comment("지번구분")
	@Column(name = "lot_number_type")
	private String lotNumberType;
	@Comment("지번구분명")
	@Column(name = "lot_number_type_name")
	private String lotNumberTypeName;
	@Comment("본번")
	@Column(name = "main_number")
	private String mainNumber;
	@Comment("부번")
	@Column(name = "sub_number")
	private String subNumber;
	@Comment("건물명")
	@Column(name = "building_name")
	private String buildingName;
	@Comment("계약일")
	@Column(name = "contract_date")
	private String contractDate;
	@Comment("물건금액")
	@Column(name = "real_estate_price")
	private String realEstatePrice;
	@Comment("건물면적")
	@Column(name = "building_area")
	private String buildingArea;
	@Comment("토지면적")
	@Column(name = "land_area")
	private String landArea;
	@Comment("층")
	@Column(name = "floor")
	private String floor;
	@Comment("권리구분")
	@Column(name = "right_type")
	private String rightType;
	@Comment("취소일")
	@Column(name = "cancel_date")
	private String cancelDate;
	@Comment("건축년도")
	@Column(name = "building_year")
	private String buildingYear;
	@Comment("건물용도")
	@Column(name = "building_type")
	private String buildingPurpose;
	@Comment("신고구분")
	@Column(name = "report_type")
	private String reportType;
	@Comment("신고한 개업공인중개사 시군구명")
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