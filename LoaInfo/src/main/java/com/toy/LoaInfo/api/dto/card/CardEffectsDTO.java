package com.toy.LoaInfo.api.dto.card;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class CardEffectsDTO {
	@JsonProperty("Index")
	private String index;
	
	@JsonProperty("CardSlots")
	private List<Integer> cardSlots;
	
	@JsonProperty("Items")
	private List<ItemsDTO> items;
}
