package com.skyscanner.browsegrid.service;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;
import org.elasticsearch.search.SearchHit;

public class ESLoadService {

	private static final String INDEX = "skyScannerInfo";
	private static final String TYPE = "browseGrid";

	public void load(Map<String, String> result) {

		Client client = NodeBuilder
				.nodeBuilder()
				.settings(
						Settings.builder()
								.put("path.home",
										"C:\\Users\\402082\\Downloads\\elasticsearch-2.2.0\\elasticsearch-2.2.0"))
				.client(true).node().client();

		boolean indexExists = client.admin().indices().prepareExists(INDEX)
				.execute().actionGet().isExists();
		
		if (indexExists) {
//			client.admin().indices().prepareDelete(INDEX).execute().actionGet();
		}else{
			client.admin().indices().prepareCreate(INDEX).execute().actionGet();
		}
		

		SearchHit[] hits = client.prepareSearch("skyScannerInfo").execute().actionGet().getHits().getHits();
//		hits[0].
		Arrays.asList(hits).stream().map(searchHit ->{
			
			return searchHit;
			
		}).collect(Collectors.toList());
//		Index(INDEX,TYPE).execute().actionGet()get().getContext();
		
	}

}
