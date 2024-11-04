package com.toy.LoaInfo.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class Siblings {
	@JsonProperty("ServerName")
	private String serverName;
	
	@JsonProperty("CharacterName")
	private String characterName;
	
	@JsonProperty("CharacterLevel")
	private Integer characterLevel;
	
	@JsonProperty("CharacterClassName")
	private String characterClassName;
	
	@JsonProperty("ItemAvgLevel")
	private String itemAvgLevel;
	
	@JsonProperty("ItemMaxLevel")
	private String itemMaxLevel;
}
