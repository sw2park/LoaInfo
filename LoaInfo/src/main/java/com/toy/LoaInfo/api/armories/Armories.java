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
import com.toy.LoaInfo.api.dto.arkPassive.ArkEffectsDTO;
import com.toy.LoaInfo.api.dto.arkPassive.ArkPassiveDTO;
import com.toy.LoaInfo.api.dto.arkPassive.ArkPointsDTO;
import com.toy.LoaInfo.api.dto.card.CardDTO;
import com.toy.LoaInfo.api.dto.card.CardEffectsDTO;
import com.toy.LoaInfo.api.dto.card.CardsDTO;
import com.toy.LoaInfo.api.dto.card.ItemsDTO;
import com.toy.LoaInfo.api.dto.collect.CollectDTO;
import com.toy.LoaInfo.api.dto.collect.CollectPtDTO;
import com.toy.LoaInfo.api.dto.engraving.ArkPassiveEffectsDTO;
import com.toy.LoaInfo.api.dto.engraving.EffectsDTO;
import com.toy.LoaInfo.api.dto.engraving.EngravingDTO;
import com.toy.LoaInfo.api.dto.engraving.EngravingsDTO;
import com.toy.LoaInfo.api.dto.gem.GemDTO;
import com.toy.LoaInfo.api.dto.gem.GemDataDTO;
import com.toy.LoaInfo.api.dto.gem.GemEffectsDTO;
import com.toy.LoaInfo.api.dto.gem.GemSkillsDTO;
import com.toy.LoaInfo.api.dto.profile.ProfileDTO;
import com.toy.LoaInfo.api.dto.profile.StatsDTO;
import com.toy.LoaInfo.api.dto.profile.TendenciesDTO;
import com.toy.LoaInfo.api.dto.skill.RuneDTO;
import com.toy.LoaInfo.api.dto.skill.SkillDTO;
import com.toy.LoaInfo.api.dto.skill.TripodsDTO;

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
			JSONObject engravingObj = (JSONObject) apiResult.get("ArmoryEngraving");
			JSONObject cardObj = (JSONObject) apiResult.get("ArmoryCard");
			JSONObject gemObj = (JSONObject) apiResult.get("ArmoryGem");
			JSONObject arkPassiveObj = (JSONObject) apiResult.get("ArkPassive");
			JSONArray collectObj = (JSONArray) apiResult.get("Collectibles");
//			JSONObject colosseumObj = (JSONObject) apiResult.get("ColosseumInfo");
			
			// 각 메소드로 JSONObject를 넘겨준 후 DTO로 변환한다.
			profile(profileObj); // 완성
			equipment(equipObj); // 완성
			avatars(avatarObj); // 완성
			skill(skillObj); // 완성
			engraving(engravingObj); // 완성
			card(cardObj); // 완성
			gem(gemObj); // 완성
			arkPassive(arkPassiveObj); // 완성
			collect(collectObj); // 완성
//			colosseum(colosseumObj); // 미완성
			
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
	public EngravingsDTO engraving(JSONObject engravingObj) throws JsonMappingException, JsonProcessingException {
		EngravingsDTO eDto = new EngravingsDTO();
		ObjectMapper objMapper = new ObjectMapper();
		
		eDto = objMapper.readValue(engravingObj.toJSONString(), EngravingsDTO.class);
		
		// 테스트 출력
		System.out.println("Engraving : " + eDto.getEngravings());
		System.out.println("Effects : " + eDto.getEffects());
		System.out.println("ArkPassiveEffects : " + eDto.getArkPassiveEffects());
		
//		System.out.println("-- Engraving");
//		List<EngravingDTO> egDto = eDto.getEngravings();
//		for(EngravingDTO eng : egDto) {
//			System.out.println("Slot : " + eng.getSlot());
//			System.out.println("Name : " + eng.getName());
//			System.out.println("Icon : " + eng.getIcon());
//			System.out.println("Tooltip : " + eng.getTooltip());
//		}
//		
//		System.out.println("-- Effects");
//		List<EffectsDTO> efDto = eDto.getEffects();
//		for(EffectsDTO eff : efDto) {
//			System.out.println("Icon : " + eff.getIcon());
//			System.out.println("Name : " + eff.getName());
//			System.out.println("Description : " + eff.getDescription());
//		}
//		
//		System.out.println("-- ArkPassiveEffects");
//		List<ArkPassiveEffectsDTO> aDto = eDto.getArkPassiveEffects();
//		for(ArkPassiveEffectsDTO apDto : aDto) {
//			System.out.println("AbilityStoneLevel : " + apDto.getAbilityStoneLevel());
//			System.out.println("Grade : " + apDto.getGrade());
//			System.out.println("Level : " + apDto.getLevel());
//			System.out.println("Name : " + apDto.getName());
//			System.out.println("Description : " + apDto.getDescription());
//		}
		return eDto;
	}
	
	// ArmoryCard 카드
	public CardDTO card(JSONObject cardObj) throws JsonMappingException, JsonProcessingException {
		CardDTO cDto = new CardDTO();
		ObjectMapper objMapper = new ObjectMapper();
		
		cDto = objMapper.readValue(cardObj.toJSONString(), CardDTO.class);
		
		// 테스트 출력
		// Cards 배열 출력
        System.out.println("Cards:");
        for (CardsDTO card : cDto.getCards()) {
            System.out.println("Slot: " + card.getSlot());
            System.out.println("Name: " + card.getName());
            System.out.println("Icon: " + card.getIcon());
            System.out.println("AwakeCount: " + card.getAwakeCount());
            System.out.println("AwakeTotal: " + card.getAwakeTotal());
            System.out.println("Grade: " + card.getGrade());
            System.out.println("Tooltip: " + card.getTooltip());
            System.out.println("-------------------------");
        }

        // Effects 배열 출력
        System.out.println("Effects:");
        for (CardEffectsDTO effect : cDto.getEffects()) {
            System.out.println("Index: " + effect.getIndex());
            System.out.println("CardSlots: " + effect.getCardSlots());

            System.out.println("Items:");
            for (ItemsDTO item : effect.getItems()) {
                System.out.println("  - Name: " + item.getName());
                System.out.println("    Description: " + item.getDescription());
            }
            System.out.println("-------------------------");
        }
		
		return cDto;
	}
	
	// ArmoryGem 장착한 보석
	public GemDataDTO gem(JSONObject gemObj) throws JsonMappingException, JsonProcessingException {
		GemDataDTO gDto = new GemDataDTO();
		ObjectMapper objMapper = new ObjectMapper();
		
		gDto = objMapper.readValue(gemObj.toJSONString(), GemDataDTO.class);
		
		// 테스트 출력
		 // Gems 배열 출력
        System.out.println("Gems:");
        for (GemDTO gem : gDto.getGems()) {
            System.out.println("Slot: " + gem.getSlot());
            System.out.println("Name: " + gem.getName());
            System.out.println("Icon: " + gem.getIcon());
            System.out.println("Level: " + gem.getLevel());
            System.out.println("Grade: " + gem.getGrade());
            System.out.println("Tooltip: " + gem.getTooltip());
            System.out.println("-------------------------");
        }

        // Effects 정보 출력
        GemEffectsDTO effects = gDto.getEffects();
        System.out.println("Effects Description: " + effects.getDescription());

        System.out.println("Skills:");
        for (GemSkillsDTO skill : effects.getSkills()) {
            System.out.println("  GemSlot: " + skill.getGemSlot());
            System.out.println("  Name: " + skill.getName());
            System.out.println("  Icon: " + skill.getIcon());
            System.out.println("  Option: " + skill.getOption());
            System.out.println("  Tooltip: " + skill.getTooltip());
            System.out.println("  Description:");
            for (String desc : skill.getDescription()) {
                System.out.println("    - " + desc);
            }
            System.out.println("-------------------------");
        }
        return gDto;
	}
	
	// ArkPassive 아크패시브
	public ArkPassiveDTO arkPassive(JSONObject arkPassiveObj) throws JsonMappingException, JsonProcessingException {
		ArkPassiveDTO aDto = new ArkPassiveDTO();
		ObjectMapper objMapper = new ObjectMapper();
		
		aDto = objMapper.readValue(arkPassiveObj.toJSONString(), ArkPassiveDTO.class);
		
		// 테스트 출력
		// IsArkPassive 값 출력
        System.out.println("IsArkPassive: " + aDto.isArkPassive());

        // Points 배열 출력
        System.out.println("Points:");
        for (ArkPointsDTO point : aDto.getPoints()) {
            System.out.println("  Name: " + point.getName());
            System.out.println("  Value: " + point.getValue());
            System.out.println("  Tooltip: " + point.getTooltip());
        }

        // Effects 배열 출력
        System.out.println("Effects:");
        for (ArkEffectsDTO effect : aDto.getEffects()) {
            System.out.println("  Name: " + effect.getName());
            System.out.println("  Description: " + effect.getDescription());
            System.out.println("  Icon: " + effect.getIcon());
            System.out.println("  Tooltip: " + effect.getToolTip());
        }
        return aDto;
	}
	
	// ColosseumInfo 증명의 전장
	public void colosseum(JSONObject colosseumObj) {
	}
	
	// Collectibles 내실
	public void collect(JSONArray collectObj) throws JsonMappingException, JsonProcessingException {
		List<CollectDTO> cDto = new ArrayList<>();
		ObjectMapper objMapper = new ObjectMapper();
		
		cDto = objMapper.readValue(collectObj.toJSONString(), new TypeReference<List<CollectDTO>>() {});
		
		// 테스트 출력
		// 각 CollectibleDTO의 필드 값을 출력
        for (CollectDTO collectible : cDto) {
            System.out.println("Type: " + collectible.getType());
            System.out.println("Icon: " + collectible.getIcon());
            System.out.println("Point: " + collectible.getPoint());
            System.out.println("MaxPoint: " + collectible.getMaxPoint());

            // CollectiblePoints 배열 출력
            System.out.println("Collectible Points:");
            for (CollectPtDTO point : collectible.getCollectiblePoints()) {
                System.out.println("  - PointName: " + point.getPointName());
                System.out.println("    Point: " + point.getPoint());
                System.out.println("    MaxPoint: " + point.getMaxPoint());
            }
            System.out.println("-------------------------");
        }
	}
}