package com.printcalc.test.db;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.printcalc.db.QueryMaker;
import com.printcalc.model.AFour;
import com.printcalc.model.GenericPaper;

/*
 * 
 * @author bhupendra
 * 
 * QueryMaker Test
 */
public class QueryMakerTest {

	private QueryMaker queryMaker;
	private GenericPaper genericPaper1;
	private GenericPaper genericPaper2;
	private static final String query1 = "SELECT * FROM pricingrules WHERE papertype='A4' AND printtype=true";
	private static final String query2 = "SELECT * FROM pricingrules WHERE papertype='A4' AND printtype=false";

	@Before
	public void setUp() {
		queryMaker = new QueryMaker();
	}

	@Test
	public void buildQueryTest() {
		genericPaper1 = new AFour(true, 10, 10, 20);
		genericPaper2 = new AFour(false, 0, 10, 10);

		Assert.assertEquals(query1, queryMaker.buildQuery(genericPaper1));
		Assert.assertEquals(query2, queryMaker.buildQuery(genericPaper2));
	}

	@Test(expected = RuntimeException.class)
	public void buildQueryNullTest() {
		genericPaper2 = null;
		Assert.assertEquals("", queryMaker.buildQuery(genericPaper2));
	}

}
