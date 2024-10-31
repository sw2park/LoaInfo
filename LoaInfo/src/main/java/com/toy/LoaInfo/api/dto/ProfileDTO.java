package com.toy.LoaInfo.api.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class ProfileDTO {
	@JsonProperty("CharacterImage")
	private String characterImage;
	
	@JsonProperty("ExpeditionLevel")
	private Integer expeditionLevel;
	
	@JsonProperty("PvpGradeName")
	private String pvpGradeName;
	
	@JsonProperty("TownLevel")
	private Integer townLevel;
	
	@JsonProperty("TownName")
	private String townName;
	
	@JsonProperty("Title")
	private String title;
	
	@JsonProperty("GuildMemberGrade")
	private String guildMemberGrade;
	
	@JsonProperty("GuildName")
	private String guildName;
	
	@JsonProperty("UsingSkillPoint")
	private Integer usingSkillPoint;
	
	@JsonProperty("TotalSkillPoint")
	private Integer totalSkillPoint;
	
	@JsonProperty("ServerName")
	private String serverName;
	
	@JsonProperty("CharacterName")
	private String characterName;
	
	@JsonProperty("CharacterLevel")
	private Integer characterLevel;
	
	@JsonProperty("CharacterClassName")
	private String characterClassName;
	
	@JsonProperty("ItemAvgLevel")
	private String itemAvgLevel;
	
	@JsonProperty("ItemMaxLevel")
	private String itemMaxLevel;
	
	@JsonProperty("Stats")
	private List<StatsDTO> stats;
	
	@JsonProperty("Tendencies")
	private List<TendenciesDTO> tendencies;
}