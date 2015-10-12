package com.printcalc.io;

import java.util.Map;

import com.printcalc.model.GenericPaper;

public interface GenericDisplay {

	public void display(Map<Integer, GenericPaper> formattedJobs);
}
