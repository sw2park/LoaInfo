package com.toy.LoaInfo.api.dto.engraving;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class EngravingDTO {
	@JsonProperty("Slot")
	private Integer slot;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Icon")
	private String icon;
	
	@JsonProperty("Tooltip")
	private String tooltip;
}
