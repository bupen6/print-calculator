package com.printcalc.manager;

import java.util.Map;
import java.util.TreeMap;

import com.printcalc.factory.PaperFactory;
import com.printcalc.io.ConsoleDisplay;
import com.printcalc.io.FileInput;
import com.printcalc.io.GenericInput;
import com.printcalc.model.GenericPaper;
import com.printcalc.model.Job;
import com.printcalc.model.Price;
import com.printcalc.rules.PricingRules;

public class CalculationManager {

	private GenericInput input;
	private ConsoleDisplay output;
	private PricingRules pricingRules;

	public CalculationManager() {
		input = new FileInput();
		output = new ConsoleDisplay();
		pricingRules = new PricingRules();
	}

	public void calculatePrice() {
		Map<Integer, Job> printJobs = input.getPrintJobs();
		Map<Integer, GenericPaper> formattedJobs = this
				.formatPrintJobs(printJobs);
		output.display(formattedJobs);
	}

	private Map<Integer, GenericPaper> formatPrintJobs(
			Map<Integer, Job> printJobs) {
		Map<Integer, GenericPaper> formattedJobs = new TreeMap<Integer, GenericPaper>();
		for (Map.Entry<Integer, Job> printingJobs : printJobs.entrySet()) {
			Job job = printingJobs.getValue();

			int jobId = printingJobs.getKey();
			GenericPaper paper = PaperFactory.getPaper("A4", job);
			Price price = pricingRules.getPrice(paper);
			paper = this.applyPrice(paper, price);
			formattedJobs.put(jobId, paper);
		}
		return formattedJobs;
	}

	private GenericPaper applyPrice(GenericPaper genericPaper, Price price) {
		int blackAndWhitePrice = price.getBlackAndWhitePrice()
				* genericPaper.getBlackAndWhitePrint();
		int colouredPrice = price.getColourPrice()
				* genericPaper.getColorPrint();
		genericPaper.setPrice(blackAndWhitePrice + colouredPrice);
		return genericPaper;
	}
}
