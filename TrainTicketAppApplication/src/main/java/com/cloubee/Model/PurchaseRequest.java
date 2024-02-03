package com.cloubee.Model;

public class PurchaseRequest {

	private String from;
	private String to;
	private String userName;
	private String email;
	private int pricePaid;

	public PurchaseRequest() {
		super();
	}

	public PurchaseRequest(String from, String to, String userName, String email, int pricePaid) {
		super();
		this.from = from;
		this.to = to;
		this.userName = userName;
		this.email = email;
		this.pricePaid = pricePaid;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	@Override
	public String toString() {
		return "PurchaseRequest [from=" + from + ", to=" + to + ", userName=" + userName + ", email=" + email
				+ ", pricePaid=" + pricePaid + "]";
	}

}
