package com.toy.LoaInfo.api.characters;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.toy.LoaInfo.api.controller.APIController;
import com.toy.LoaInfo.api.dto.Siblings;

public class Characters extends APIController {
	// 캐릭터명으로 검색하여 원정대 내 캐릭터 정보 확인
		public List<Siblings> characters(String _charName) throws ParseException {
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
					// JSONArray를 JSONObject로 변환
					JSONObject apiResultObj = (JSONObject) apiResult.get(i);

					Siblings siblingsDTO = new Siblings();

					// DTO 값 세팅
					siblingsDTO.setServerName(apiResultObj.get("ServerName").toString());
					siblingsDTO.setCharacterName(apiResultObj.get("CharacterName").toString());
					siblingsDTO.setCharacterLevel(Integer.parseInt(apiResultObj.get("CharacterLevel").toString()));
					siblingsDTO.setCharacterClassName(apiResultObj.get("CharacterClassName").toString());
					siblingsDTO.setItemMaxLevel(apiResultObj.get("ItemAvgLevel").toString());
					siblingsDTO.setItemAvgLevel(apiResultObj.get("ItemMaxLevel").toString());
					
					siblingsList.add(siblingsDTO);
				}
			} else { // API 호출 후 검색 결과가 없는 경우
				System.out.println("검색결과가 없습니다.");
				return null;
			}
			return siblingsList;
		}
}