package com.toy.LoaInfo.api.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.toy.LoaInfo.api.charInfo.CharInfoDTO;
import com.toy.LoaInfo.api.siblings.SiblingsDTO;

@Controller
public class LostarkApi extends APIController {
	// 캐릭터명으로 검색하여 원정대 내 캐릭터 정보 확인
	public List<SiblingsDTO> siblings(String _charName) throws ParseException {
		// 값전달용 리스트 선언
		List<SiblingsDTO> siblingsList = new ArrayList<>();

		String charName = _charName;
		String category = "characters";
		String cateDetail = "siblings";

		// api 호출
		String searchData = callInfoAPI(category, charName, cateDetail);

		if (!searchData.contentEquals("[]")) { // API 호출 후 검색결과가 있는 경우
			try {
				// JSONArray로 변환
				JSONArray searchResult = (JSONArray) new JSONParser().parse(searchData);

				for (int i = 0; i < searchResult.size(); i++) {
					// JSONArray를 JSONObject로 변환
					JSONObject searchResultObj = (JSONObject) searchResult.get(i);

					SiblingsDTO siblingsDTO = new SiblingsDTO();

					// DTO 값 세팅
					siblingsDTO.setServerName(searchResultObj.get("ServerName").toString());
					siblingsDTO.setCharacterName(searchResultObj.get("CharacterName").toString());
					siblingsDTO.setCharacterLevel(Integer.parseInt(searchResultObj.get("CharacterLevel").toString()));
					siblingsDTO.setCharacterClassName(searchResultObj.get("CharacterClassName").toString());
					siblingsDTO.setItemMaxLevel(searchResultObj.get("ItemAvgLevel").toString());
					siblingsDTO.setItemAvgLevel(searchResultObj.get("ItemMaxLevel").toString());

					siblingsList.add(siblingsDTO);
				}
			} catch (org.json.simple.parser.ParseException e) {
				e.printStackTrace();
			}
		} else { // API 호출 후 검색 결과가 없는 경우
			System.out.println("검색결과가 없습니다.");
			return null;
		}
		return siblingsList;
	}

	// 캐릭터명으로 검색하여 기본적인 정보 확인
	public CharInfoDTO charBasicInfo(String _charName) {
		// 값 전달용 DTO 객체 선언
		CharInfoDTO charInfoDTO = new CharInfoDTO();
		
		String charName = _charName;
		String category = "armories/characters";
		String cateDetail = "profiles";

		// api 호출
		String searchData = callInfoAPI(category, charName, cateDetail);

		if (!searchData.contentEquals("[]")) {
			try {
				// JSONObject로 변환
				JSONObject searchResult = (JSONObject) new JSONParser().parse(searchData);

				// DTO 값 세팅
				charInfoDTO.setCharacterImage(searchResult.get("CharacterImage").toString());
				charInfoDTO.setExpedtionLevel(Integer.parseInt(searchResult.get("ExpeditionLevel").toString()));
				charInfoDTO.setPvpGradeName(searchResult.get("PvpGradeName").toString());
				charInfoDTO.setTownLevel(searchResult.get("TownLevel").toString());
				charInfoDTO.setTownName(searchResult.get("TownName").toString());
				charInfoDTO.setTitle(searchResult.get("Title").toString());
				charInfoDTO.setGuildMemberGrade(searchResult.get("GuildMemberGrade").toString());
				charInfoDTO.setGuildName(searchResult.get("GuildName").toString());
				charInfoDTO
						.setUsingSkillPoint(Integer.parseInt(searchResult.get("UsingSkillPoint").toString()));
				charInfoDTO
						.setTotalSkillPoint(Integer.parseInt(searchResult.get("TotalSkillPoint").toString()));
				charInfoDTO.setServerName(searchResult.get("ServerName").toString());
				charInfoDTO.setCharacterName(searchResult.get("CharacterName").toString());
				charInfoDTO.setCharacterLevel(Integer.parseInt(searchResult.get("CharacterLevel").toString()));
				charInfoDTO.setCharacterClassName(searchResult.get("CharacterClassName").toString());
				charInfoDTO.setItemAvgLevel(searchResult.get("ItemAvgLevel").toString());
				charInfoDTO.setItemMaxLevel(searchResult.get("ItemMaxLevel").toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else { // API 호출 후 검색 결과가 없는 경우
			System.out.println("검색결과가 없습니다.");
			return null;
		}
		return charInfoDTO;
	}
}