package com.toy.LoaInfo.api.dto.collect;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class CollectPtDTO {
	@JsonProperty("PointName")
	private String pointName;
	
	@JsonProperty("Point")
	private Integer point;
	
	@JsonProperty("MaxPoint")
	private Integer maxPoint;
}