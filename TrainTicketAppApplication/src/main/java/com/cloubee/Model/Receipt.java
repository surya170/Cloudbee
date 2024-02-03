package com.cloubee.Model;

public class Receipt {

	private String from;
	private String to;
	private String user;
	private String email;
	private int pricePaid;
	private int seat;

	// 0-arg Constructor
	public Receipt() {
		super();
	}

	public Receipt(String from, String to, String user, String email, int pricePaid, int seat) {
		super();
		this.from = from;
		this.to = to;
		this.user = user;
		this.email = email;
		this.pricePaid = pricePaid;
		this.seat = seat;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPricePaid() {
		return pricePaid;
	}

	public void setPricePaid(int pricePaid) {
		this.pricePaid = pricePaid;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

    // Additional method to get the section based on the seats
	 public String getSection() {
	        return (seat <= 10) ? "A" : "B";
	    }
	 
	@Override
	public String toString() {
		return "Receipt [from=" + from + ", to=" + to + ", user=" + user + ", email=" + email + ", pricePaid="
				+ pricePaid + ", seat=" + seat + "]";
	}

}