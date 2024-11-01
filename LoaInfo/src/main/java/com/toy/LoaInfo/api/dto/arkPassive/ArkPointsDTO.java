package com.toy.LoaInfo.api.dto.arkPassive;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class ArkPointsDTO {
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Value")
	private Integer value;
	
	@JsonProperty("Tooltip")
	private String tooltip;
}
