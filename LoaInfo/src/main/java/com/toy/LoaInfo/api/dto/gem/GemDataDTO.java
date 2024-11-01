package com.toy.LoaInfo.api.dto.gem;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class GemDataDTO {
	@JsonProperty("Gems")
	private List<GemDTO> gems;
	
	@JsonProperty("Effects")
	private GemEffectsDTO effects;
}