package com.toy.LoaInfo.api.dto.skill;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class SkillDTO {
	@JsonProperty("Name")
	private String name;

	@JsonProperty("Icon")
	private String icon;
	
	@JsonProperty("Level")
	private Integer level;
	
	@JsonProperty("Type")
	private String type;
	
	@JsonProperty("SkillType")
	private Integer skillType;
	
	@JsonProperty("Tooltip")
	private String tooltip;
	
	@JsonProperty("Tripods")
	private List<TripodsDTO> tripods;
	
	@JsonProperty("Rune")
	private RuneDTO rune;
}