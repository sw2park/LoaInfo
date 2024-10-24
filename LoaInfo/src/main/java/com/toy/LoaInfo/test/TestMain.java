package com.toy.LoaInfo.test;

import java.text.ParseException;
import java.util.List;

import com.toy.LoaInfo.api.charInfo.CharInfoDTO;
import com.toy.LoaInfo.api.controller.LostarkApi;
import com.toy.LoaInfo.api.siblings.SiblingsDTO;

public class TestMain {
	public static void main(String[] args) {
		LostarkApi loaApi = new LostarkApi();
		String charName = "하린슬레";
		// List<SiblingsDTO> testData = loaApi.siblings(charName);
		//
		// for(SiblingsDTO m : testData) {
		// System.out.println(m.getCharacterName().toString());
		// }
		CharInfoDTO d = loaApi.charBasicInfo(charName);
		
		System.out.println("image = " + d.getCharacterImage().toString());
		System.out.println("원정대 레벨 = " + d.getExpedtionLevel().toString());
		System.out.println("pvp 등급 = " + d.getPvpGradeName().toString());
		System.out.println("영지 레벨 = " + d.getTownLevel().toString());
		System.out.println("영지 이름 = " + d.getTownName().toString());
		System.out.println("칭호 = " + d.getTitle().toString());
		System.out.println("길드 등급 = " + d.getGuildMemberGrade().toString());
		System.out.println("길드명 = " + d.getGuildName().toString());
		System.out.println("사용한 스킬 포인트 = " + d.getUsingSkillPoint().toString());
		System.out.println("전체 스킬 포인트 = " + d.getTotalSkillPoint().toString());
		System.out.println("서버명 = " + d.getServerName().toString());
		System.out.println("캐릭터 이름 = " + d.getCharacterName().toString());
		System.out.println("캐릭터 전투 레벨 = " + d.getCharacterLevel().toString());
		System.out.println("캐릭터 직업 = " + d.getCharacterClassName().toString());
		System.out.println("아이템 레벨 = " + d.getItemAvgLevel().toString());
		System.out.println("최대 레벨 = " + d.getItemMaxLevel().toString());
	}
}
