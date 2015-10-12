package com.printcalc.test.db;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.printcalc.db.DBService;
import com.printcalc.model.AFour;
import com.printcalc.model.GenericPaper;
import com.printcalc.model.Price;

/*
 * @author bhupendra
 * 
 * BDService Test
 * 
 */
public class DBServiceTest {

	private DBService dBService;
	private GenericPaper genericPaper1;
	private GenericPaper genericPaper2;
	private GenericPaper genericPaper3;

	private Price price;

	@Before
	public void setUp() {
		dBService = new DBService();
		genericPaper1 = new AFour(false, 10, 20, 30);
		genericPaper2 = new AFour(true, 0, 0, 0);
		genericPaper3 = new AFive(true, 10, 15, 25);
	}

	@Test
	public void getPriceFromDataBaseTest() throws RuntimeException,
			SQLException {
		price = dBService.getPriceFromDataBase(genericPaper1);
		Assert.assertEquals("BlackAndWhitePrice Must Be 15", 15,
				price.getBlackAndWhitePrice());
		Assert.assertEquals("ColourPrice Must Be 25", 25,
				price.getColourPrice());

		price = dBService.getPriceFromDataBase(genericPaper2);
		Assert.assertEquals("BlackAndWhitePrice Must Be 10", 10,
				price.getBlackAndWhitePrice());
		Assert.assertEquals("ColourPrice Must Be 20", 20,
				price.getColourPrice());

		price = dBService.getPriceFromDataBase(genericPaper3);
		Assert.assertEquals("BlackAndWhitePrice Must Be 0", 0,
				price.getBlackAndWhitePrice());
		Assert.assertEquals("ColourPrice Must Be 0", 0, price.getColourPrice());
	}
}
