package com.toy.LoaInfo.api.armories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			
			// JSONObject로 메소드 전달용 각각 변환
			JSONObject profileObj = (JSONObject) apiResult.get("ArmoryProfile");
//			JSONObject equipObj = (JSONObject) apiResult.get("ArmoryEquipment");
//			JSONObject avatarObj = (JSONObject) apiResult.get("ArmoryAvatars");
//			JSONObject skillObj = (JSONObject) apiResult.get("ArmorySkills");
//			JSONObject engravingObj = (JSONObject) apiResult.get("ArmoryEngraving");
//			JSONObject cardObj = (JSONObject) apiResult.get("ArmoryCard");
//			JSONObject gemObj = (JSONObject) apiResult.get("ArmoryGem");
//			JSONObject arkPassiveObj = (JSONObject) apiResult.get("ArkPassive");
//			JSONObject colosseumObj = (JSONObject) apiResult.get("ColosseumInfo");
//			JSONObject collectObj = (JSONObject) apiResult.get("Collectibles");
			
			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
			// 각 메소드로 JSONObject를 넘겨준 후 DTO로 변환한다.
			profile(profileObj);
//			equipment(equipObj);
//			avatars(avatarObj);
//			skill(skillObj);
//			engraving(engravingObj);
//			card(cardObj);
//			gem(gemObj);
//			arkPassive(arkPassiveObj);
//			colosseum(colosseumObj);
//			collect(collectObj);
			
		
//			System.out.println("aromotyProfile = " + apiResult.get("CharacterImage").toString());
		}
	}
	
	// ArmoryProfile 프로필 부분
	public void profile(JSONObject profileObj) throws ParseException {
		JSONObject profile = profileObj;
		
		// key profile 세팅
		List<String> keyList = new ArrayList<>();
		keyList.add("CharacterImage");
		keyList.add("ExpeditionLevel");
		keyList.add("PvpGradeName");
		keyList.add("TownLevel");
		keyList.add("TownName");
		keyList.add("Title");
		keyList.add("GuildMemberGrade");
		keyList.add("GuildName");
		keyList.add("UsingSkillPoint");
		keyList.add("TotalSkillPoint");
		keyList.add("Stats");
		keyList.add("Tendencies");
		keyList.add("ServerName");
		keyList.add("CharacterName");
		keyList.add("CharacterLevel");
		keyList.add("CharacterClassName");
		keyList.add("ItemAvgLevel");
		keyList.add("ItemMaxLevel");
		
//		profileMap.put("CharacterImage", profile.get("CharacterImage"));
		
		for(int i=0; i<18; i++) {
			// 이걸 어케해야할까
			System.out.println(profile.get(keyList.get(i)).equals(profileObj).toString());
		}
	}
	
	// ArmoryEquipment 장착 아이템
	public void equipment(JSONObject equipObj) {
		JSONObject equipment = equipObj;
	}
	
	// ArmoryAvatars 장착 아바타
	public void avatars(JSONObject avatarObj) {
		JSONObject avatars = avatarObj;
	}
	
	// ArmorySkills 스킬 정보
	public void skill(JSONObject skillObj) {
		JSONObject skill = skillObj;
	}
	
	// ArmoryEngraving 각인
	public void engraving(JSONObject engravingObj) {
		JSONObject engraving = engravingObj;
	}
	
	// ArmoryCard 카드
	public void card(JSONObject cardObj) {
		JSONObject card = cardObj;
	}
	
	// ArmoryGem 장착한 보석
	public void gem(JSONObject gemObj) {
		JSONObject gem = gemObj;
	}
	
	// ArkPassive 아크패시브
	public void arkPassive(JSONObject arkPassiveObj) {
		JSONObject arkPassive = arkPassiveObj;
	}
	
	// ColosseumInfo 증명의 전장
	public void colosseum(JSONObject colosseumObj) {
		JSONObject colosseum = colosseumObj;
	}
	
	// Collectibles 내실
	public void collect(JSONObject collectObj) {
		JSONObject collect = collectObj;
	}
}