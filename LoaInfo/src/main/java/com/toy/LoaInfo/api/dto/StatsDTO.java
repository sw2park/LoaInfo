package com.toy.LoaInfo.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class StatsDTO {
	@JsonProperty("Type")
	private String type;
	@JsonProperty("Value")
	private String value;
	// 툴팁 배열이네;; 어카지?
}
