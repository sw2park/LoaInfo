package com.toy.LoaInfo.api.dto.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class ItemsDTO {
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Description")
	private String description;
}
