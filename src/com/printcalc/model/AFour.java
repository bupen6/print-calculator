package com.printcalc.model;

public class AFour implements GenericPaper {

	private boolean jobType;
	private int colorPrint;
	private int blackAndWhitePrint;
	private int totalPages;
	private int price;
	private String printType;
	private static final String paperType = "A4";

	public AFour(boolean jobType, int colorPrint, int blackAndWhitePrint,
			int totalPages) {
		super();
		this.jobType = jobType;
		this.colorPrint = colorPrint;
		this.blackAndWhitePrint = blackAndWhitePrint;
		this.totalPages = totalPages;
	}

	public boolean getJobType() {
		return jobType;
	}

	public void setJobType(boolean jobType) {
		this.jobType = jobType;
	}

	public int getColorPrint() {
		return colorPrint;
	}

	public void setColorPrint(int colorPrint) {
		this.colorPrint = colorPrint;
	}

	public int getBlackAndWhitePrint() {
		return blackAndWhitePrint;
	}

	public void setBlackAndWhitePrint(int blackAndWhitePrint) {
		this.blackAndWhitePrint = blackAndWhitePrint;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPrintType() {
		if (printType == null) {
			if (this.getJobType() == true)
				return "Double Sided";
			else
				return "Single Sided";
		} else
			return printType;
	}
	
	public String getPaperType(){
		return paperType;
	}
}
