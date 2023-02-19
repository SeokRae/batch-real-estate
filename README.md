# 샘플 데이터

- [서울특별시_부동산 실거래가 정보](https://www.data.go.kr/data/15052419/fileData.do)
- [서울시 부동산 실거래가 정보](https://data.seoul.go.kr/dataList/OA-21275/S/1/datasetView.do)

| 자치구 | 법정동 | 신고년도 | 업무구분 | 물건구분 | 대지권면적 | 관리구분 | 건물면적  | 건물주용도 | 물건금액  |   건물명    | 건축년도 |
|:---:|:---:|:----:|:----:|:----:|:-----:|:----:|:-----:|:-----:|:-----:|:--------:|:----:|
| 강남구 | 개포동 | 2017 |  매매  | 아파트  |   0   |  일반  | 84.99 |  주거용  | 80000 | 개포주공 1단지 | 1988 |



## 데이터 메타정보

| No  |       필드명       |       필드 설정       |   타입   |          값 설명           |
|:---:|:---------------:|:-----------------:|:------:|:-----------------------:|
|  1  |    ACC_YEAR     |       접수연도        | STRING |          YYYY           |
|  2  |     SGG_CD      |      	자치구코드       | STRING |         5자리 정수          |
|  3  |     	SGG_NM     |       	자치구명       | STRING |           문자열           |
|  4  |   	BJDONG_CD    |      	법정동코드       | STRING |         5자리 정수          |
|  5  |   	BJDONG_NM    |       	법정동명       | STRING |           문자열           |
|  6  |    	LAND_GBN    |       	지번구분       | STRING |     1:대지, 2:산, 3:블럭     |
|  7  |  	LAND_GBN_NM   |      	지번구분명       | STRING |           문자열           | 
|  8  |    	BONBEON     |        	본번        | STRING |         4자리 정수          | 
|  9  |     	BUBEON     |        	부번        | STRING |         4자리 정수          | 
| 10  |    	BLDG_NM     |       	건물명        | STRING |           문자열           |
| 11  |    	DEAL_YMD    |       	계약일        | STRING |        YYYYMMDD         | 
| 12  |    	OBJ_AMT     |     	물건금액(만원)     | STRING |            -            |
| 13  |   	BLDG_AREA    |     	건물면적(㎡)      | STRING |            -            |
| 14  |    	TOT_AREA    |     	토지면적(㎡)      | STRING |            -            |
| 15  |     	FLOOR      |        	층         | STRING |            -            |
| 16  |   	RIGHT_GBN    |       	권리구분       | STRING |            -            |
| 17  |    	CNTL_YMD    |       	취소일        | STRING |            -            |
| 18  |   	BUILD_YEAR   |       	건축년도       | STRING |            -            |
| 19  |   	HOUSE_TYPE   |       	건물용도       | STRING | 오피스텔, 아파트, 연립다세대, 단독다가구 |
| 20  |    	REQ_GBN     |       	신고구분       | STRING |        직거래, 중고거래        |
| 21  | 	RDEALER_LAWMAN | 	신고한 개업공인중개사 시군구명 | STRING |            -            |