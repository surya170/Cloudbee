package com.cloubee.Model;

import lombok.Data;

@Data
public class User {

	private String name;
	private int seat;
	private String section;

	public User() {
		super();
	}

	public User(String name, int seat, String section) {
		super();
		this.name = name;
		this.seat = seat;
		this.section = section;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
