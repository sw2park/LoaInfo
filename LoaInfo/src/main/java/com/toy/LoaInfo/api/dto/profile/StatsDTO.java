package com.toy.LoaInfo.api.dto.profile;

import java.util.List;

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
	
	@JsonProperty("Tooltip")
	private List<String> toolTip;
}
