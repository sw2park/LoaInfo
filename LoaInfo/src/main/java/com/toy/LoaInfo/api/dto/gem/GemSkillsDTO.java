package com.toy.LoaInfo.api.dto.gem;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class GemSkillsDTO {
	@JsonProperty("GemSlot")
	private Integer gemSlot;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Description")
	private List<String> description;
	
	@JsonProperty("Option")
	private String option;
	
	@JsonProperty("Icon")
	private String icon;
	
	@JsonProperty("Tooltip")
	private String tooltip;
}