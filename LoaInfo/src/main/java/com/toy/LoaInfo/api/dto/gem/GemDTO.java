package com.toy.LoaInfo.api.dto.gem;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class GemDTO {
	@JsonProperty("Slot")
	private Integer slot;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Icon")
	private String icon;
	
	@JsonProperty("Level")
	private Integer level;
	
	@JsonProperty("Grade")
	private String grade;
	
	@JsonProperty("Tooltip")
	private String tooltip;
}