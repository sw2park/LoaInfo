package com.toy.LoaInfo.api.dto.card;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class CardsDTO {
	@JsonProperty("Slot")
	private Integer slot;
	
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Icon")
	private String icon;
	
	@JsonProperty("AwakeCount")
	private Integer awakeCount;
	
	@JsonProperty("AwakeTotal")
	private Integer awakeTotal;
	
	@JsonProperty("Grade")
	private String grade;
	
	@JsonProperty("Tooltip")
	private String tooltip;
}
