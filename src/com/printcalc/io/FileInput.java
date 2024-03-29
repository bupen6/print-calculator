package com.printcalc.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import com.printcalc.model.Job;

/*
 * author bhupendra
 * 
 * Reads jobs from file through resource folder and returns as Map
 */
public class FileInput implements GenericInput {

	private Map<Integer, Job> jobs;

	{
		jobs = new TreeMap<Integer, Job>();
	}

	@Override
	public Map<Integer, Job> getPrintJobs() {
		ClassLoader classloader = Thread.currentThread()
				.getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("printjobs.csv");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		String line = "";
		String cvsSplitBy = ",";

		try {

			while ((line = br.readLine()) != null) {
				Job job = new Job();
				String[] details = line.split(cvsSplitBy);
				job.setTotalPages(Integer.parseInt(details[0]));
				job.setColourPrint(Integer.parseInt(details[1]));
				job.setJobType(Boolean.parseBoolean(details[2]));

				jobs.put(new Random().nextInt(10000), job);
			}
		} catch (IOException e) {
			try {
				is.close();
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			try {
				is.close();
				br.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return jobs;
	}

}
