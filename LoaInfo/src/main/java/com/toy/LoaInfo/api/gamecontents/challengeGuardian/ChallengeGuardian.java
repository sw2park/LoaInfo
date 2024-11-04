package com.toy.LoaInfo.api.gamecontents.challengeGuardian;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toy.LoaInfo.api.controller.APIController;

public class ChallengeGuardian extends APIController {
	public GuardianRaidDTO ChallengeGuardian() throws JsonMappingException, JsonProcessingException {
		// 값전달용 객체 선언
		GuardianRaidDTO aDto = new GuardianRaidDTO();

		String category = "gamecontents";
		String cateDetail = "challenge-guardian-raids";

		// api 호출
		String apiData = callContentsAPI(category, cateDetail);
		if (!apiData.contentEquals("[]")) { // API 호출 후 검색결과가 있는 경우
			ObjectMapper objMapper = new ObjectMapper();

			// 오토 매핑
			aDto = objMapper.readValue(apiData, GuardianRaidDTO.class);

			// 테스트용 출력
			System.out.println("Raids:");
			for (RaidsDTO aa : aDto.getRaids()) {
				System.out.println("Name : " + aa.getName());
				System.out.println("Description : " + aa.getDescription());
				System.out.println("MinCharacterLevel : " + aa.getMinCharacterLevel());
				System.out.println("MinItemLevel : " + aa.getMinItemLevel());
				System.out.println("StartTime : " + aa.getStartTime());
				System.out.println("EndTime : " + aa.getEndTime());
				System.out.println("Image : " + aa.getImage());
			}

			System.out.println("-------------------------");
			System.out.println("RewardItems:");
			for (GuardianRewardDTO cDto : aDto.getRewardItems()) {
				System.out.println("ItemLevel : " + cDto.getItemLevel());
				
				for (GuardanItemDTO ii : cDto.getItems()) {
					System.out.println("Name : " + ii.getName());
					System.out.println("Icon : " + ii.getIcon());
					System.out.println("Grade : " + ii.getGrade());
					
					// StartTime이 null로만 떨어지기때문에 바꿀예정
//					System.out.println("StartTimes : ");
//					if(ii.getStartTimes().equals(null)) {
//						System.out.println("StartTimes is Null");
//					} else {
//						for (String str : ii.getStartTimes()) {
//							System.out.println("    -   " + str);
//						}
//					}
				}
				System.out.println("-------------------------");
			}
		}
		return aDto;
	}
}