package com.toy.LoaInfo.api.dto.collect;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class CollectDTO {
	@JsonProperty("Type")
	private String type;
	
	@JsonProperty("Icon")
	private String icon;
	
	@JsonProperty("Point")
	private Integer point;
	
	@JsonProperty("MaxPoint")
	private Integer maxPoint;
	
	@JsonProperty("CollectiblePoints")
	private List<CollectPtDTO> collectiblePoints;
}
