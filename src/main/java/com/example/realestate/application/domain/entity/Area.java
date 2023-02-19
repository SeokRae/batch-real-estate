package com.example.realestate.application.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Area {
	
	@Id
	@Column(name = "AREA_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "DISTRICT_CD") @Comment("자치구 코드")
	private String districtCode;
	@Column(name = "DISTRICT_NM") @Comment("자치구 명")
	private String districtName;
	@Column(name = "LEGAL_DONG_CD") @Comment("법정동 코드")
	private String legalDongCode;
	@Column(name = "LEGAL_DONG_NM") @Comment("법정동 명")
	private String legalDongName;
	@Column(name = "LOT_NUMBER_TYPE") @Comment("지번 구분")
	private String lotNumberType;
	@Column(name = "LOT_NUMBER_TYPE_NM") @Comment("지번 구분명")
	private String lotNumberTypeName;
	@Column(name = "MAIN_NUMBER") @Comment("본번")
	private String mainNumber;
	@Column(name = "SUB_NUMBER") @Comment("부번")
	private String subNumber;
	@Column(name = "BUILDING_YEAR") @Comment("건축 년도")
	private String buildingYear;
	@Column(name = "BUILDING_TYPE") @Comment("건물 용도")
	private String buildingType;
	@Column(name = "BUILDING_NAME") @Comment("건물 명")
	private String buildingName;
	@Column(name = "BUILDING_AREA") @Comment("건물 면적")
	private String buildingArea;
	@Column(name = "LAND_AREA") @Comment("토지 면적")
	private Long landArea;
	@Column(name = "FLOOR") @Comment("층")
	private String floor;
	@Column(name = "RIGHT_TYPE") @Comment("권리 구분")
	private String rightType;

}
