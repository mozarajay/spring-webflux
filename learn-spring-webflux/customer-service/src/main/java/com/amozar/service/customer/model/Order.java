package com.amozar.service.customer.model;

public class Order {

	private String id;
	private String number;
	private int amount;

	public Order() {

	}

	public Order(String id, String number, int amount) {
		this.id = id;
		this.number = number;
		this.amount = amount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", number=" + number + ", amount=" + amount + "]";
	}

}
