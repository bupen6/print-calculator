package com.printcalc.model;

public class Price {

	private int blackAndWhitePrice;
	private int colourPrice;

	public Price(int blackAndWhitePrice, int colourPrice) {
		super();
		this.blackAndWhitePrice = blackAndWhitePrice;
		this.colourPrice = colourPrice;
	}

	public int getBlackAndWhitePrice() {
		return blackAndWhitePrice;
	}

	public int getColourPrice() {
		return colourPrice;
	}

}
