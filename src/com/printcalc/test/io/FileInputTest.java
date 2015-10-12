package com.printcalc.test.io;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;
import org.mockito.Mockito;

import com.printcalc.io.FileInput;
import com.printcalc.model.Job;

public class FileInputTest {

	private FileInput fileInput;
	private FileInput mock;

	@Test
	public void getPrintJobsTest() {
		fileInput = new FileInput();
		Map<Integer, Job> input = fileInput.getPrintJobs();
		Assert.assertEquals("Must have 4 jobs", 4, input.size());
	}

	@Test
	public void getPrintJobsTes1t() {
		mock = Mockito.mock(FileInput.class);
		mock.getPrintJobs();
		Mockito.verify(mock, Mockito.times(1)).getPrintJobs();
	}
}
