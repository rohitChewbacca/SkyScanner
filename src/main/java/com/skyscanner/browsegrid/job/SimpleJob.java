package com.skyscanner.browsegrid.job;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.skyscanner.browsegrid.service.ESLoadService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;

public class SimpleJob implements Job {

	public static final String TEST_API_KEY = "prtl6749387986743898559646983194";
	private static List<String> routesUrlList;

	private static String toRouteUrls(String route) {
		String Url = "http://partners.api.skyscanner.net/apiservices/browsegrid/v1.0/IN/INR/en-IN/<from>/<to>/<date>?apiKey=<testApiKey>";
		Url = Url.replaceAll("<from>", route.split("-")[0].trim());
		Url = Url.replaceAll("<to>", route.split("-")[1].trim());
		Url = Url.replaceAll("<date>", (Calendar.getInstance().get(Calendar.YEAR)) + "-"
				+ String.format("%02d", (Calendar.getInstance().get(Calendar.MONTH) + 1)));
		Url = Url.replaceAll("<testApiKey>", TEST_API_KEY);
		return Url;
	}

	static {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				SimpleJob.class.getClassLoader().getResourceAsStream("Top-Sectors-Cache - for version 7.txt")));
		routesUrlList = br.lines().map(route -> toRouteUrls(route)).collect(Collectors.toList());
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		routesUrlList.forEach(System.out::println);

		Long startTime = System.currentTimeMillis();
		List<String> result = routesUrlList.stream().parallel().map((baseUrl) -> {
			Client client = new Client();
			ClientResponse response = client.resource(baseUrl).accept(MediaType.APPLICATION_JSON_TYPE).get(ClientResponse.class);
			response.getStatus();
			if(response.getStatus() == Status.OK.getStatusCode()){
				return response.getEntity(String.class);
			}else{
				return "{\"Error\":\"".concat(baseUrl).concat(Status.getFamilyByStatusCode(response.getStatus()).name()).concat("\"}");
			}
		}).collect(Collectors.toList());
    	Long endTime = System.currentTimeMillis();
    	System.out.println(result);
    	System.out.println("Time taken to execute the JOB :: "+new Time(endTime-startTime).toLocalTime());
		
		
		ESLoadService service = new ESLoadService();
		service.load(result);
	}

}
