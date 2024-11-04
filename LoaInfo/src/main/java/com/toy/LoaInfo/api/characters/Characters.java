package com.toy.LoaInfo.api.characters;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toy.LoaInfo.api.controller.APIController;
import com.toy.LoaInfo.api.dto.Siblings;
import com.toy.LoaInfo.api.gamecontents.challengeAbyss.AbyssDTO;

public class Characters extends APIController {
	// 캐릭터명으로 검색하여 원정대 내 캐릭터 정보 확인
		public List<Siblings> characters(String _charName) throws ParseException, JsonMappingException, JsonProcessingException {
			// 값전달용 리스트 선언
			List<Siblings> siblingsList = new ArrayList<>();

			String charName = _charName;
			String category = "characters";
			String cateDetail = "siblings";

			// api 호출
			String apiData = callInfoAPI(category, charName, cateDetail);

			if (!apiData.contentEquals("[]")) { // API 호출 후 검색결과가 있는 경우
				// JSONArray로 변환
				JSONArray apiResult = (JSONArray) new JSONParser().parse(apiData);

				for (int i = 0; i < apiResult.size(); i++) {
					ObjectMapper objMapper = new ObjectMapper();
					
					// 오토 매핑
					siblingsList = objMapper.readValue(apiData, new TypeReference<List<Siblings>>() {});
					
					// 테스트 출력
					for(Siblings aa : siblingsList) {
						System.out.println("ServerName : " + aa.getServerName());
						System.out.println("CharacterName : " + aa.getCharacterName());
						System.out.println("CharacterLevel : " + aa.getCharacterLevel());
						System.out.println("CharacterClassName : " + aa.getCharacterClassName());
						System.out.println("ItemAvgLevel : " + aa.getItemAvgLevel());
						System.out.println("ItemMaxLevel : " + aa.getItemMaxLevel());
						System.out.println();
					}

				}
			} else { // API 호출 후 검색 결과가 없는 경우
				System.out.println("검색결과가 없습니다.");
				return null;
			}
			return siblingsList;
		}
}