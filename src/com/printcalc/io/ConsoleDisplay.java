package com.printcalc.io;

import java.util.Map;

import com.printcalc.model.GenericPaper;

public class ConsoleDisplay implements GenericDisplay {

	@Override
	public void display(Map<Integer, GenericPaper> formattedJobs) {
		int allJobsPrice = 0;
		for (Map.Entry<Integer, GenericPaper> jobs : formattedJobs.entrySet()) {
			GenericPaper paper = jobs.getValue();
			allJobsPrice = allJobsPrice + paper.getPrice();
			System.out.println("Job Id: " + jobs.getKey() +" | Paper Size: "+paper.getPaperType()+ " | Job Type: "
					+ paper.getPrintType() + " | Black And White Pages: "
					+ paper.getBlackAndWhitePrint() + " | Coloured Pages: "
					+ paper.getColorPrint() + " | Total Pages: "
					+ paper.getTotalPages() + " | Price: "
					+ paper.getPrice());
			System.out.println("");
		}
		System.out.println("Total Jobs Price : "+allJobsPrice);
	}

}
