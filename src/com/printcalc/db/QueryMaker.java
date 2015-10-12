package com.printcalc.db;

import com.printcalc.constants.PrintCalcConstants;
import com.printcalc.model.GenericPaper;

public class QueryMaker {

	public String buildQuery(GenericPaper genericPaper)throws RuntimeException{
		if(genericPaper!=null)
			return "SELECT * FROM "+PrintCalcConstants.tableName+" WHERE papertype=\'"+genericPaper.getPaperType()+"' AND printtype="+genericPaper.getJobType();
		else
			throw new RuntimeException("GenericPaper Not Passed");
	}
}
