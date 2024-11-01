package com.toy.LoaInfo.api.dto.engraving;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class EngravingsDTO {
	@JsonProperty("Engravings")
	private List<EngravingDTO> Engravings;
	
	@JsonProperty("Effects")
	private List<EffectsDTO> Effects;
	
	@JsonProperty("ArkPassiveEffects")
	private List<ArkPassiveEffectsDTO> ArkPassiveEffects;
}