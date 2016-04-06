package com.skyscanner.browsegrid.job;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.Calendar;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import javax.ws.rs.core.MediaType;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.google.gson.Gson;
import com.skyscanner.browsegrid.service.ESLoadService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.ClientResponse.Status;

public class SimpleJob implements Job {

	public static final String TEST_API_KEY = "prtl6749387986743898559646983194";
	private static ConcurrentMap<String, String> routesUrlMap;
	private ConcurrentMap<String, String> routesResponseMap;

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

		routesUrlMap = br.lines()
				.collect(Collectors.toConcurrentMap(route -> route.toString(), routeUrls -> toRouteUrls(routeUrls)));
	}

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		routesUrlMap.values().forEach(System.out::println);
		routesResponseMap = new ConcurrentHashMap<>(routesUrlMap);

		Long startTime = System.currentTimeMillis();

		Map<String, String> result = routesResponseMap.entrySet().stream().parallel().map(entry -> {

			Client client = new Client();
			System.out.println(entry.getValue());
			ClientResponse response = client.resource(entry.getValue()).accept(MediaType.APPLICATION_JSON_TYPE)
					.get(ClientResponse.class);
			if (response.getStatus() == Status.OK.getStatusCode()) {
				entry.setValue(response.getEntity(String.class));
			} else {
				entry.setValue(new Gson().toJson("{\"Error\":\"".concat(entry.getValue())
						.concat(Status.getFamilyByStatusCode(response.getStatus()).name()).concat("\"}")));
			}
			return entry;
		}).collect(Collectors.toMap(Entry<String, String>::getKey, Entry<String, String>::getValue));
		Long endTime = System.currentTimeMillis();
		// System.out.println(result);
		System.out
				.println("Time taken to execute the JOB :: " + new Time(endTime - startTime).getSeconds() + "seconds");

		ESLoadService service = new ESLoadService();
		service.load(result);
	}
}
