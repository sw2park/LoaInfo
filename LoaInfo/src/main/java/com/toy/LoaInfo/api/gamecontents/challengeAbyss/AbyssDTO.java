package com.toy.LoaInfo.api.gamecontents.challengeAbyss;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.toy.LoaInfo.api.dto.AbyssRewardDTO;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class AbyssDTO {
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("MinCharacterLevel")
	private Integer minCharacterLevel;
	
	@JsonProperty("MinItemLevel")
	private Integer minItemLevel;
	
	@JsonProperty("AreaName")
	private String areaName;
	
	@JsonProperty("StartTime")
	private String startTime;
	
	@JsonProperty("EndTime")
	private String endTime;
	
	@JsonProperty("Image")
	private String image;
	
	@JsonProperty("RewardItems")
	private List<AbyssRewardDTO> rewardItems;
}