package com.printcalc.test.rules;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.printcalc.model.AFour;
import com.printcalc.model.GenericPaper;
import com.printcalc.model.Price;
import com.printcalc.rules.PricingRules;

public class PricingRulesTest {

	private PricingRules pricingRules;
	private GenericPaper genericPaper;
	
	@Before
	public void setUp(){
		pricingRules = new PricingRules();
		genericPaper = new AFour(true, 10, 40, 50);
	}
	
	@Test
	public void getPriceTest(){
		Price price = pricingRules.getPrice(genericPaper);
		Assert.assertNotNull("Price must not be null", price);
		Assert.assertEquals("BlackAndWhite Price must be 10", 10, price.getBlackAndWhitePrice());
		Assert.assertEquals("Coloured Price must be 20", 20, price.getColourPrice());
	}
	
	@Test(expected = NullPointerException.class)
	public void getPriceTest2(){
		Price price = pricingRules.getPrice(null);
		Assert.assertNull(price);
	}

}
