package com.toy.LoaInfo.api.dto.engraving;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class ArkPassiveEffectsDTO {
	@JsonProperty("AbilityStoneLevel")
	private Integer AbilityStoneLevel;
	
	@JsonProperty("Grade")
	private String Grade;
	
	@JsonProperty("Level")
	private Integer Level;
	
	@JsonProperty("Name")
	private String Name;
	
	@JsonProperty("Description")
	private String Description;
}
