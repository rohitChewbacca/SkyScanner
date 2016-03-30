package com.skyscanner.browsegrid.job;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SimpleJob implements Job {

	public static final String TEST_API_KEY = "prtl6749387986743898559646983194"; 
	private static List<String> routesUrlList;
	private static String toRouteUrls(String route){
		String Url = "http://partners.api.skyscanner.net/apiservices/browsegrid/v1.0/IN/INR/en-IN/<from>/<to>/<date>?apiKey=<testApiKey>";
		Url = Url.replaceAll("<from>", route.split("-")[0].trim());
		Url = Url.replaceAll("<to>", route.split("-")[1].trim());
		Url = Url.replaceAll("<date>", (Calendar.getInstance().get(Calendar.YEAR))+"-"+(Calendar.getInstance().get(Calendar.MONTH)+1));
		Url = Url.replaceAll("<testApiKey>", TEST_API_KEY);
		return Url;
	}
	static {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				SimpleJob.class.getClassLoader().getResourceAsStream("Top-Sectors-Cache - for version 7.txt")));
		routesUrlList = br.lines().map(route ->toRouteUrls(route))
				.collect(Collectors.toList());
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
//		routesUrlList.forEach(System.out::println);
		
	}


}
