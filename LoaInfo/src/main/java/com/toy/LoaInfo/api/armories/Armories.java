package com.toy.LoaInfo.api.armories;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.toy.LoaInfo.api.controller.APIController;

public class Armories extends APIController {
	// Armories 전체 API 검색
	public void armories(String _charName) throws ParseException {
		String charName = _charName;
		String category = "armories/characters";
		String cateDetail = "";

		String apiData = callInfoAPI(category, charName, cateDetail);

		if (!apiData.contentEquals("[]")) {
			// JSONObject로 변환
			JSONObject apiResult = (JSONObject) new JSONParser().parse(apiData);
			JSONObject armoryProfile = (JSONObject) apiResult.get("ArmoryProfile");
			JSONObject test = (JSONObject) new JSONParser().parse(armoryProfile.toJSONString());
			
			armoryProfile(armoryProfile);
			
		
//			System.out.println("aromotyProfile = " + apiResult.get("CharacterImage").toString());
		}
	}
	
	// ArmoryProfile 프로필 부분
	public void armoryProfile(JSONObject _armoryProfile) throws ParseException {
		JSONObject armoryProfile = _armoryProfile;
		JSONObject test = (JSONObject) new JSONParser().parse(armoryProfile.toJSONString());
		
		System.out.println(test.get("TownName"));
	}
	// ArmoryEquipment 장착 아이템
	// ArmoryAvatars 장착 아바타
	// ArmorySkills 스킬 정보
	// ArmoryEngraving 각인
	// ArmoryCard 카드
	// ArmoryGem 장착한 보석
	// ArkPassive 아크패시브
	// ColosseumInfo 증명의 전장
	// Collectibles 내실
}