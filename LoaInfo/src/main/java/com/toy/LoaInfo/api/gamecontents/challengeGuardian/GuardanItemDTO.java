package com.toy.LoaInfo.api.gamecontents.challengeGuardian;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter @Setter
public class GuardanItemDTO {
	@JsonProperty("Name")
	private String name;
	
	@JsonProperty("Icon")
	private String icon;
	
	@JsonProperty("Grade")
	private String grade;
}
