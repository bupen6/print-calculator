package com.printcalc.factory;

import com.printcalc.model.AFour;
import com.printcalc.model.GenericPaper;
import com.printcalc.model.Job;

public class PaperFactory {

	public static GenericPaper getPaper(String paperType, Job job)
			throws RuntimeException {
		GenericPaper genericPaper = null;
		switch (paperType) {
		case "A4":
			genericPaper = new AFour(job.getJobType(), job.getColourPrint(),
					(job.getTotalPages() - job.getColourPrint()),
					job.getTotalPages());
			break;
		default:
			throw new RuntimeException(paperType + " Size Paper Not Supported");
		}
		return genericPaper;
	}

}
