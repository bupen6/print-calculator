package com.printcalc.test.rules;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.printcalc.model.AFour;
import com.printcalc.model.GenericPaper;
import com.printcalc.model.Price;
import com.printcalc.rules.PricingRulesCache;

public class PricingRulesCacheTest {

	private PricingRulesCache pricingRulesCache;
	private GenericPaper genericPaper;
	private GenericPaper genericPaper1;
	private Price price;

	@Before
	public void setUp() {
		pricingRulesCache = new PricingRulesCache();
		genericPaper = new AFour(true, 10, 40, 50);
		genericPaper1 = new AFour(false, 0, 10, 10);
	}

	@Test
	public void getPriceFromCacheTest() {
		price = pricingRulesCache.getPriceFromCache(genericPaper);
		Assert.assertEquals("Must be 10", 10, price.getBlackAndWhitePrice());
		Assert.assertEquals("Must be 20", 20, price.getColourPrice());
		price = pricingRulesCache.getPriceFromCache(genericPaper1);
		Assert.assertEquals("Must be 10", 15, price.getBlackAndWhitePrice());
		Assert.assertEquals("Must be 20", 25, price.getColourPrice());
	}
}
