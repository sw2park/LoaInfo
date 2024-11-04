package com.toy.LoaInfo.api.gamecontents.challengeGuardian;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class RaidsDTO {
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("MinCharacterLevel")
	private Integer minCharacterLevel;
	
	@JsonProperty("MinItemLevel")
	private Integer minItemLevel;
	
	@JsonProperty("StartTime")
	private String startTime;
	
	@JsonProperty("EndTime")
	private String endTime;
	
	@JsonProperty("Image")
	private String image;
}