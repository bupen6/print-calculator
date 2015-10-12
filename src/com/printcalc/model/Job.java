package com.printcalc.model;

public class Job {

	private boolean jobType;
	private int colourPrint;
	private int totalPages;

	public boolean getJobType() {
		return jobType;
	}

	public void setJobType(boolean jobType) {
		this.jobType = jobType;
	}

	public int getColourPrint() {
		return colourPrint;
	}

	public void setColourPrint(int colourPrint) {
		this.colourPrint = colourPrint;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

}
