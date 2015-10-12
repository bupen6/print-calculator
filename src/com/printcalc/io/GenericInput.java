package com.printcalc.io;

import java.util.Map;

import com.printcalc.model.Job;

/*
 * @author bhupendra
 * 
 * Interface fir input
 */
public interface GenericInput {

	public Map<Integer, Job> getPrintJobs();
}
