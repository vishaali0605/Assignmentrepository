package com.src;

public class Book {
	private int bid;
	private String name;
	private String bauthor;
	private String bgenre;
	private int bcost;

	public Book() {
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBgenre() {
		return bgenre;
	}

	public void setBgenre(String bgenre) {
		this.bgenre = bgenre;
	}

	public int getBcost() {
		return bcost;
	}

	public void setBcost(int bcost) {
		this.bcost = bcost;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", name=" + name + ", bauthor=" + bauthor + ", bgenre=" + bgenre + ", bcost="
				+ bcost + "]";
	}

}
