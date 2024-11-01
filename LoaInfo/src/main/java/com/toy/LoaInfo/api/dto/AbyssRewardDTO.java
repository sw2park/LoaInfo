package com.toy.LoaInfo.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class AbyssRewardDTO {
	@JsonProperty("Name")
	private String Name;
	
	@JsonProperty("Icon")
	private String Icon;
	
	@JsonProperty("Grade")
	private String Grade;
	
	@JsonProperty("StartTimes")
	private String StartTimes;
}
