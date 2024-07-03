package com.app.dto;

import com.app.entity.RoomType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomDTO {
	
	
	private Long id;
	
	private int roomNo;
		
	private RoomType type;
	
	private double price;
	
	private boolean availability;

}
