package com.toy.LoaInfo.api.armories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.toy.LoaInfo.api.controller.APIController;
import com.toy.LoaInfo.api.dto.AvatarsDTO;
import com.toy.LoaInfo.api.dto.EquipmentDTO;
import com.toy.LoaInfo.api.dto.ProfileDTO;
import com.toy.LoaInfo.api.dto.RuneDTO;
import com.toy.LoaInfo.api.dto.SkillDTO;
import com.toy.LoaInfo.api.dto.StatsDTO;
import com.toy.LoaInfo.api.dto.TendenciesDTO;
import com.toy.LoaInfo.api.dto.TripodsDTO;

public class Armories extends APIController {
	// Armories 전체 API 검색
	public void armories(String _charName) throws ParseException, JsonMappingException, JsonProcessingException {
		String charName = _charName;
		String category = "armories/characters";
		String cateDetail = "";

		String apiData = callInfoAPI(category, charName, cateDetail);
		
		if (!apiData.contentEquals("[]")) {
			// JSONObject로 변환
			JSONObject apiResult = (JSONObject) new JSONParser().parse(apiData);
			
			// JSONObject로 메소드 전달용 각각 변환
			JSONObject profileObj = (JSONObject) apiResult.get("ArmoryProfile");
			JSONArray equipObj = (JSONArray) apiResult.get("ArmoryEquipment");
			JSONArray avatarObj = (JSONArray) apiResult.get("ArmoryAvatars");
			JSONArray skillObj = (JSONArray) apiResult.get("ArmorySkills");
//			JSONObject engravingObj = (JSONObject) apiResult.get("ArmoryEngraving");
//			JSONObject cardObj = (JSONObject) apiResult.get("ArmoryCard");
//			JSONObject gemObj = (JSONObject) apiResult.get("ArmoryGem");
//			JSONObject arkPassiveObj = (JSONObject) apiResult.get("ArkPassive");
//			JSONObject colosseumObj = (JSONObject) apiResult.get("ColosseumInfo");
//			JSONObject collectObj = (JSONObject) apiResult.get("Collectibles");
			
			// 각 메소드로 JSONObject를 넘겨준 후 DTO로 변환한다.
//			profile(profileObj); // 완성
//			equipment(equipObj); // 완성
//			avatars(avatarObj); // 완성
//			skill(skillObj); // 완성
//			engraving(engravingObj);
//			card(cardObj);
//			gem(gemObj);
//			arkPassive(arkPassiveObj);
//			colosseum(colosseumObj);
//			collect(collectObj);
			
//			System.out.println("aromotyProfile = " + apiResult.get("CharacterImage").toString());
		}
	}
	
	// DTO로 변환하여 return 시킨다.
	public ProfileDTO profile(JSONObject profileObj) throws JsonMappingException, JsonProcessingException {
		ProfileDTO pDto = new ProfileDTO();		// DTO 객체 선언
		ObjectMapper objMapper = new ObjectMapper();	// JSON DTO 오토 매핑용 객체 선언
		
		// ObjectMapper 사용해서 DTO 오토 매핑시작 
		pDto = objMapper.readValue(profileObj.toString(), ProfileDTO.class);
		
		// 테스트용 출력
		System.out.println("캐릭터 이름 : " + pDto.getCharacterName());
		
		List<StatsDTO> statsList = pDto.getStats();
		for(StatsDTO stat : statsList) {
			System.out.println("Type: " + stat.getType());
            System.out.println("Value: " + stat.getValue());
            System.out.println("Tooltip:");
            for (String tooltip : stat.getToolTip()) {
                System.out.println("  - " + tooltip);
            }
		}
		
		 // Tendencies 데이터 출력
        List<TendenciesDTO> tendenciesList = pDto.getTendencies();
        System.out.println("\nTendencies:");
        for (TendenciesDTO tendency : tendenciesList) {
            System.out.println("Type: " + tendency.getType());
            System.out.println("Point: " + tendency.getPoint());
            System.out.println("MaxPoint: " + tendency.getMaxPoint());
        }
		return pDto;
	}
	
	// ArmoryEquipment 장착 아이템
	public List<EquipmentDTO> equipment(JSONArray equipObj) throws JsonMappingException, JsonProcessingException, ParseException {
		List<EquipmentDTO> equipList = new ArrayList<>();
		ObjectMapper objMapper = new ObjectMapper();
		
		equipList = objMapper.readValue(equipObj.toJSONString(), new TypeReference<List<EquipmentDTO>>(){});
		
		// 테스트 출력
		for(EquipmentDTO eDto : equipList) {
			System.out.println("Type: " + eDto.getType());
            System.out.println("Name: " + eDto.getName());
            System.out.println("Icon: " + eDto.getIcon());
            System.out.println("Grade: " + eDto.getGrade());
            System.out.println("Tooltip: " + eDto.getTooltip());
            System.out.println("-------------------------");
		}
		
		return equipList;
	}
	
	// ArmoryAvatars 장착 아바타
	public List<AvatarsDTO> avatars(JSONArray avatarObj) throws JsonMappingException, JsonProcessingException {
		List<AvatarsDTO> avatarList = new ArrayList<>();
		ObjectMapper objMapper = new ObjectMapper();
		
		avatarList = objMapper.readValue(avatarObj.toJSONString(), new TypeReference<List<AvatarsDTO>>(){});
		
		for(AvatarsDTO aDto : avatarList) {
			System.out.println("Type : " + aDto.getType());
			System.out.println("Name : " + aDto.getName());
			System.out.println("Icon : " + aDto.getIcon());
			System.out.println("Grade : " + aDto.getGrade());
			System.out.println("IsSet : " + aDto.isSet());
			System.out.println("IsInner : " + aDto.isInner());
			System.out.println("Tooltip : " + aDto.getTooltip());
		}
		
		return avatarList;
	}
	
	// ArmorySkills 스킬 정보
	public List<SkillDTO> skill(JSONArray skillObj) throws JsonMappingException, JsonProcessingException {
		List<SkillDTO> skillList = new ArrayList<>();
		ObjectMapper objMapper = new ObjectMapper();
		
		skillList = objMapper.readValue(skillObj.toJSONString(), new TypeReference<List<SkillDTO>>() {});
		
		// 테스트 출력
		for(SkillDTO sDto : skillList) {
			System.out.println("Name : " + sDto.getName());
			System.out.println("Icon : " + sDto.getIcon());
			System.out.println("Level : " + sDto.getLevel());
			System.out.println("Type : " + sDto.getType());
			System.out.println("SkillType : " + sDto.getSkillType());
			System.out.println("Tooltip : " + sDto.getTooltip());
			
			System.out.println("-- Tripods");
			List<TripodsDTO> tripodsList = sDto.getTripods();
			for(TripodsDTO tDto : tripodsList) {
				System.out.println("Tier : " + tDto.getTier());
				System.out.println("Slot : " + tDto.getSlot());
				System.out.println("Name : " + tDto.getName());
				System.out.println("Icon : " + tDto.getIcon());
				System.out.println("Level : " + tDto.getLevel());
				System.out.println("IsSelected : " + tDto.isSelected());
				System.out.println("Tooltip : " + tDto.getTooltip());
				System.out.println();
			}
			
			System.out.println("-- Runes");
			RuneDTO rune = sDto.getRune();
			if(rune != null) {
				System.out.println("Name : " + rune.getName());
				System.out.println("Icon : " + rune.getIcon());
				System.out.println("Grade : " + rune.getGrade());
				System.out.println("Tooltip : " + rune.getTooltip());
			} else {
				System.out.println("Rune is Null");
			}
		}
		return skillList;
	}
	
	// ArmoryEngraving 각인
	public void engraving(JSONObject engravingObj) {
	}
	
	// ArmoryCard 카드
	public void card(JSONObject cardObj) {
	}
	
	// ArmoryGem 장착한 보석
	public void gem(JSONObject gemObj) {
	}
	
	// ArkPassive 아크패시브
	public void arkPassive(JSONObject arkPassiveObj) {
	}
	
	// ColosseumInfo 증명의 전장
	public void colosseum(JSONObject colosseumObj) {
	}
	
	// Collectibles 내실
	public void collect(JSONObject collectObj) {
	}
}