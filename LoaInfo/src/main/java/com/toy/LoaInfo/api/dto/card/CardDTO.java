package com.toy.LoaInfo.api.dto.card;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class CardDTO {
	@JsonProperty("Cards")
	private List<CardsDTO> cards;
	
	@JsonProperty("Effects")
	private List<CardEffectsDTO> effects;
}
