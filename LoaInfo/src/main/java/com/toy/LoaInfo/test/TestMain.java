package com.toy.LoaInfo.test;

import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.toy.LoaInfo.api.armories.Armories;
import com.toy.LoaInfo.api.characters.Characters;
import com.toy.LoaInfo.api.controller.LostarkApi;
import com.toy.LoaInfo.api.gamecontents.GameContents;
import com.toy.LoaInfo.api.gamecontents.challengeAbyss.ChallengeAbyss;
import com.toy.LoaInfo.api.gamecontents.challengeGuardian.ChallengeGuardian;

public class TestMain {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException, ParseException {
		LostarkApi loaApi = new LostarkApi();
		String charName = "드미이잉";
		// List<SiblingsDTO> testData = loaApi.siblings(charName);
		//
		// for(SiblingsDTO m : testData) {
		// System.out.println(m.getCharacterName().toString());
		// }
		
//		Characters charApi = new Characters();
//		charApi.characters(charName);
		
		//loaApi.armories(charName);
//		Armories a = new Armories();
//		try {
//			a.armories(charName);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		ChallengeAbyss c = new ChallengeAbyss();
//		c.ChallengeAbyss();
		
		ChallengeGuardian d = new ChallengeGuardian();
		d.ChallengeGuardian();
	}
}
