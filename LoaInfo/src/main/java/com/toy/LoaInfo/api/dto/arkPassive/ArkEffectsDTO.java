package com.toy.LoaInfo.api.dto.arkPassive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class ArkEffectsDTO {
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Icon")
	private String icon;
	
	@JsonProperty("ToolTip")
	private String toolTip;
}
