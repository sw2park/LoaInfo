package com.toy.LoaInfo.api.gamecontents;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toy.LoaInfo.api.controller.APIController;
import com.toy.LoaInfo.api.dto.AbyssRewardDTO;
import com.toy.LoaInfo.api.gamecontents.challengeAbyss.AbyssDTO;

public class GameContents extends APIController {
	public List<AbyssDTO> ChallengeAbyss() throws ParseException, JsonMappingException, JsonProcessingException {
		// 값전달용 객체 선언
		List<AbyssDTO> aDto = new ArrayList<>();
		
		String category = "gamecontents";
		String cateDetail = "challenge-abyss-dungeons";

		// api 호출
		String apiData = callContentsAPI(category, cateDetail);
		if (!apiData.contentEquals("[]")) { // API 호출 후 검색결과가 있는 경우
			ObjectMapper objMapper = new ObjectMapper();
			
			// 오토 매핑
			aDto = objMapper.readValue(apiData, new TypeReference<List<AbyssDTO>>() {});
			
			// 테스트용 출력
			for(AbyssDTO aa : aDto) {
				System.out.println("Name : " + aa.getName());
				System.out.println("Description : " + aa.getDescription());
				System.out.println("MinCharacterLevel : " + aa.getMinCharacterLevel());
				System.out.println("MinItemLevel : " + aa.getMinItemLevel());
				System.out.println("AreaName : " + aa.getAreaName());
				System.out.println("StartTime : " + aa.getStartTime());
				System.out.println("EndTime : " + aa.getEndTime());
				System.out.println("Image : " + aa.getImage());
				
				List<AbyssRewardDTO> bb = aa.getRewardItems();
				for(AbyssRewardDTO cc : bb) {
					System.out.println("Name : " + cc.getName());
					System.out.println("Icon : " + cc.getIcon());
					System.out.println("Grade : " + cc.getGrade());
					System.out.println("StartTimes : " + cc.getStartTimes());
				}
			}
		}
		return aDto;
	}
}