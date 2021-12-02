package com.hospital.models;

public class TimeSlot {

	private double startTime;
	private double endTime;
	
	public TimeSlot(double startTime,double endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public double getStartTime() {
		return startTime;
	}

	public void setStartTime(double startTime) {
		this.startTime = startTime;
	}

	public double getEndTime() {
		return endTime;
	}

	public void setEndTime(double endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "TimeSlot [startTime=" + startTime + ", endTime=" + endTime + "]";
	}
}
