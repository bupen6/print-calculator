package com.printcalc.test.factory;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.printcalc.factory.PaperFactory;
import com.printcalc.model.AFour;
import com.printcalc.model.GenericPaper;
import com.printcalc.model.Job;
import com.printcalc.test.db.AFive;

public class PaperFactoryTest {

	private Job job;

	@Before
	public void setUp() {
		job = new Job();
		job.setColourPrint(20);
		job.setTotalPages(60);
		job.setJobType(true);
	}

	@Test
	public void getPaperTest() {
		GenericPaper paper = PaperFactory.getPaper("A4", job);
		Assert.assertEquals("Paper of A4 must be returned", true,
				paper instanceof AFour);
	}

	@Test(expected = RuntimeException.class)
	public void getPaperTest2() {
		GenericPaper paper = PaperFactory.getPaper("A5", job);
		Assert.assertEquals("", true, paper instanceof AFive);
	}

	@Test(expected = NullPointerException.class)
	public void getPaperTest3() {
		GenericPaper paper = PaperFactory.getPaper("A4", null);
		Assert.assertEquals("", true, paper instanceof AFive);
	}

}
