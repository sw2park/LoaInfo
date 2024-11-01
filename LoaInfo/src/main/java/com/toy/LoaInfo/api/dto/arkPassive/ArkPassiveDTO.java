package com.toy.LoaInfo.api.dto.arkPassive;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class ArkPassiveDTO {
	@JsonProperty("IsArkPassive")
	private boolean isArkPassive;
	
	@JsonProperty("Points")
	private List<ArkPointsDTO> points;
	
	@JsonProperty("Effects")
	private List<ArkEffectsDTO> effects;
}