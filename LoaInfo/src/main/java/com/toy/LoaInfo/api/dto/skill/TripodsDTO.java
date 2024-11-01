package com.toy.LoaInfo.api.dto.skill;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class TripodsDTO {
	@JsonProperty("Tier")
	private Integer tier;
	
	@JsonProperty("Slot")
	private Integer slot;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Icon")
	private String icon;
	
	@JsonProperty("Level")
	private Integer level;
	
	@JsonProperty("IsSelected")
	private boolean isSelected;
	
	@JsonProperty("Tooltip")
	private String tooltip;
}