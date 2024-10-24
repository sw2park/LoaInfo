package com.toy.LoaInfo.api.charInfo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
// 캐릭터 기본 DTO
public class CharInfoDTO {
	// 캐릭터 프로필 사진
	private String characterImage;
	// 원정대 레벨
	private Integer expedtionLevel;
	// pvp 등급
	private String pvpGradeName;
	// 영지 레벨
	private String townLevel;
	// 영지 이름
	private String townName;
	// 칭호
	private String title;
	// 길드 등급
	private String guildMemberGrade;
	// 길드명
	private String guildName;
	// 사용한 스킬 포인트
	private Integer usingSkillPoint;
	// 전체 스킬 포인트
	private Integer totalSkillPoint;
	// 서버명
	private String serverName;
	// 캐릭터 이름
	private String characterName;
	// 캐릭터 전투 레벨
	private Integer characterLevel;
	// 캐릭터 직업명
	private String characterClassName;
	// 장착한 아이템 평균 레벨 
	private String itemAvgLevel;
	// 업적용 아이템 최대 레벨
	private String itemMaxLevel;
}