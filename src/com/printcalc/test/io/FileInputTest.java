package com.printcalc.test.io;

import org.junit.Test;
import org.mockito.Mockito;

import com.printcalc.io.FileInput;

/*
 * @author bhupendra
 * 
 * FileInput Test
 */
public class FileInputTest {

	private FileInput mock;

	@Test
	public void getPrintJobsTes1t() {
		mock = Mockito.mock(FileInput.class);
		mock.getPrintJobs();
		Mockito.verify(mock, Mockito.times(1)).getPrintJobs();
	}
}
