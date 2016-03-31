package com.skyscanner.browsegrid.service;

import java.util.List;

import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;

public class ESLoadService {

	private static final String INDEX = "SkyScannerInfo";

	public void load(List<String> result) {

		Client client = NodeBuilder
				.nodeBuilder()
				.settings(
						Settings.builder()
								.put("path.home",
										"C:\\Users\\402082\\Downloads\\elasticsearch-2.2.0\\elasticsearch-2.2.0"))
				.client(true).node().client();

//		boolean indexExists = client.admin().indices().prepareExists(INDEX)
//				.execute().actionGet().isExists();
//		if (indexExists) {
//			client.admin().indices().prepareDelete(INDEX).execute().actionGet();
//		}
//		client.admin().indices().prepareCreate(INDEX).execute().actionGet();

	}

}
