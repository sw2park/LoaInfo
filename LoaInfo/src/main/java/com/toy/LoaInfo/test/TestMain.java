package com.toy.LoaInfo.test;

import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.toy.LoaInfo.api.armories.Armories;
import com.toy.LoaInfo.api.controller.LostarkApi;

public class TestMain {
	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		LostarkApi loaApi = new LostarkApi();
		String charName = "하린슬레";
		// List<SiblingsDTO> testData = loaApi.siblings(charName);
		//
		// for(SiblingsDTO m : testData) {
		// System.out.println(m.getCharacterName().toString());
		// }
		
		//loaApi.armories(charName);
		Armories a = new Armories();
		try {
			a.armories(charName);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
