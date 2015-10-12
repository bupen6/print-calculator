package com.printcalc.model;

public interface GenericPaper {

	public boolean getJobType();

	public void setJobType(boolean jobType);

	public int getColorPrint();

	public void setColorPrint(int colorPrint);

	public int getBlackAndWhitePrint();

	public void setBlackAndWhitePrint(int blackAndWhitePrint);

	public int getTotalPages();

	public void setTotalPages(int totalPages);

	public int getPrice();

	public void setPrice(int price);

	public String getPrintType();

	public String getPaperType();

}
