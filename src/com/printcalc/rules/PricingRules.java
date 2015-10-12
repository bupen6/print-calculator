package com.printcalc.rules;

import com.printcalc.model.GenericPaper;
import com.printcalc.model.Price;

public class PricingRules {

	private PricingRulesCache pricingRulesCache;

	{
		pricingRulesCache = new PricingRulesCache();
	}

	public Price getPrice(GenericPaper genericPaper) {
		return pricingRulesCache.getPriceFromCache(genericPaper);
	}

}
