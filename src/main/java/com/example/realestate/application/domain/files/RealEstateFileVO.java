package com.example.realestate.application.domain.files;

import com.example.realestate.application.domain.entity.RealEstateEntity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RealEstateFileVO {
	private String 접수연도;
	private String 자치구코드;
	private String 자치구명;
	private String 법정동코드;
	private String 법정동명;
	private String 지번구분;
	private String 지번구분명;
	private String 본번;
	private String 부번;
	private String 건물명;
	private String 계약일;
	private String 물건금액;
	private String 건물면적;
	private String 토지면적;
	private String 층;
	private String 권리구분;
	private String 취소일;
	private String 건축년도;
	private String 건물용도;
	private String 신고구분;
	private String 신고한_개업공인중개사_시군구명;
	
	public static RealEstateEntity toEntity(RealEstateFileVO fileVO) {
		return RealEstateEntity.builder()
			.receiptYear(fileVO.get접수연도())
			.districtCode(fileVO.get자치구코드())
			.districtName(fileVO.get자치구명())
			.legalDongCode(fileVO.get법정동코드())
			.legalDongName(fileVO.get법정동명())
			.lotNumberType(fileVO.get지번구분())
			.lotNumberTypeName(fileVO.get지번구분명())
			.mainNumber(fileVO.get본번())
			.subNumber(fileVO.get부번())
			.buildingName(fileVO.get건물명())
			.contractDate(fileVO.get계약일())
			.realEstatePrice(fileVO.get물건금액())
			.buildingArea(fileVO.get건물면적())
			.landArea(fileVO.get토지면적())
			.floor(fileVO.get층())
			.rightType(fileVO.get권리구분())
			.cancelDate(fileVO.get취소일())
			.buildingYear(fileVO.get건축년도())
			.buildingPurpose(fileVO.get건물용도())
			.reportType(fileVO.get신고구분())
			.reportAgentDistrictName(fileVO.get신고한_개업공인중개사_시군구명())
			.build();
	}
	
	@Override
	public String toString() {
		return "RealEstateVO{" +
			"접수연도='" + 접수연도 + '\'' +
			", 자치구코드='" + 자치구코드 + '\'' +
			", 자치구명='" + 자치구명 + '\'' +
			", 법정동코드='" + 법정동코드 + '\'' +
			", 법정동명='" + 법정동명 + '\'' +
			", 지번구분='" + 지번구분 + '\'' +
			", 지번구분명='" + 지번구분명 + '\'' +
			", 본번='" + 본번 + '\'' +
			", 부번='" + 부번 + '\'' +
			", 건물명='" + 건물명 + '\'' +
			", 계약일='" + 계약일 + '\'' +
			", 물건금액='" + 물건금액 + '\'' +
			", 건물면적='" + 건물면적 + '\'' +
			", 토지면적='" + 토지면적 + '\'' +
			", 층='" + 층 + '\'' +
			", 권리구분='" + 권리구분 + '\'' +
			", 취소일='" + 취소일 + '\'' +
			", 건축년도='" + 건축년도 + '\'' +
			", 건물용도='" + 건물용도 + '\'' +
			", 신고구분='" + 신고구분 + '\'' +
			", 신고한_개업공인중개사_시군구명='" + 신고한_개업공인중개사_시군구명 + '\'' +
			'}';
	}
}