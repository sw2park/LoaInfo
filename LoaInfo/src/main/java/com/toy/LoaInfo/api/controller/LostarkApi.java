package com.toy.LoaInfo.api.controller;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;


@Controller
public class LostarkApi extends APIController {
	
	/*
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
				
				// JSONObject -> HashMap으로 변환
			    Map<String, String> searchMap = new HashMap<>();
			    searchMap.put("CharacterImage", searchResult.get("CharacterImage").toString());
			    searchMap.put("ExpeditionLevel", searchResult.get("ExpeditionLevel").toString());
			    searchMap.put("PvpGradeName", searchResult.get("PvpGradeName").toString());
			    searchMap.put("TownLevel", searchResult.get("TownLevel").toString());
			    searchMap.put("TownName", searchResult.get("TownName").toString());
			    searchMap.put("Title", searchResult.get("Title").toString());
			    searchMap.put("GuildMemberGrade", searchResult.get("GuildMemberGrade").toString());
			    searchMap.put("GuildName", searchResult.get("GuildName").toString());
			    searchMap.put("UsingSkillPoint", searchResult.get("UsingSkillPoint").toString());
			    searchMap.put("TotalSkillPoint", searchResult.get("TotalSkillPoint").toString());
			    searchMap.put("ServerName", searchResult.get("ServerName").toString());
			    searchMap.put("CharacterName", searchResult.get("CharacterName").toString());
			    searchMap.put("CharacterLevel", searchResult.get("CharacterLevel").toString());
			    searchMap.put("CharacterClassName", searchResult.get("CharacterClassName").toString());
			    searchMap.put("ItemAvgLevel", searchResult.get("ItemAvgLevel").toString());
			    searchMap.put("ItemMaxLevel", searchResult.get("ItemMaxLevel").toString());

			    // DTO 값 세팅
			    charInfoDTO.setCharacterImage(searchMap.get("CharacterImage"));
			    charInfoDTO.setExpeditionLevel(Integer.parseInt(searchMap.get("ExpeditionLevel")));
			    charInfoDTO.setPvpGradeName(searchMap.get("PvpGradeName"));
			    charInfoDTO.setTownLevel(Integer.parseInt(searchMap.get("TownLevel")));
			    charInfoDTO.setTownName(searchMap.get("TownName"));
			    charInfoDTO.setTitle(searchMap.get("Title"));
			    charInfoDTO.setGuildMemberGrade(searchMap.get("GuildMemberGrade"));
			    charInfoDTO.setGuildName(searchMap.get("GuildName"));
			    charInfoDTO.setUsingSkillPoint(Integer.parseInt(searchMap.get("UsingSkillPoint")));
			    charInfoDTO.setTotalSkillPoint(Integer.parseInt(searchMap.get("TotalSkillPoint")));
			    charInfoDTO.setServerName(searchMap.get("ServerName"));
			    charInfoDTO.setCharacterName(searchMap.get("CharacterName"));
			    charInfoDTO.setCharacterLevel(Integer.parseInt(searchMap.get("CharacterLevel")));
			    charInfoDTO.setCharacterClassName(searchMap.get("CharacterClassName"));
			    charInfoDTO.setItemAvgLevel(searchMap.get("ItemAvgLevel"));
			    charInfoDTO.setItemMaxLevel(searchMap.get("ItemMaxLevel"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else { // API 호출 후 검색 결과가 없는 경우
			System.out.println("검색결과가 없습니다.");
			return null;
		}
		return charInfoDTO;
	}
	*/
}