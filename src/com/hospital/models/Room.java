package com.hospital.models;

import com.hospital.enumerations.RoomLocation;

public class Room {

	private int number;
	private RoomLocation stage;
	
	public Room(int number,RoomLocation stage) {
		this.number = number;
		this.stage = stage;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public RoomLocation getStage() {
		return stage;
	}

	public void setStage(RoomLocation stage) {
		this.stage = stage;
	}

	@Override
	public String toString() {
		return "Room [number=" + number + ", stage=" + stage + "]";
	}
}
