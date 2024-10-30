package com.toy.LoaInfo.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class TendenciesDTO {
	@JsonProperty("Type")
	private String type;
	
	@JsonProperty("Point")
	private Integer point;
	
	@JsonProperty("MaxPoint")
	private Integer maxPoint;
}