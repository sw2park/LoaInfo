package com.toy.LoaInfo.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class AvatarsDTO {
	@JsonProperty("Type")
	private String type;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Icon")
	private String icon;
	
	@JsonProperty("Grade")
	private String grade;
	
	@JsonProperty("IsSet")
	private boolean isSet;
	
	@JsonProperty("IsInner")
	private boolean isInner;
	
	@JsonProperty("Tooltip")
	private String tooltip;
}