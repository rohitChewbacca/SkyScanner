package com.skyscanner.browsegrid.service;

import java.util.Map;

import org.elasticsearch.ElasticsearchException;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.NodeBuilder;

import com.google.gson.Gson;

public class ESLoadService {

	private static Client client;
	private static final String INDEX = "skyscannerinfo";
	private static final String TYPE = "browsegrid";
private static final String DATA_FIELD = "data";

	public void load(Map<String, String> result) {

		client = NodeBuilder.nodeBuilder()
				.settings(Settings.builder().put("path.home",
						"C:\\Users\\402082\\Downloads\\elasticsearch-2.2.0\\elasticsearch-2.2.0"))
				.client(true).node().client();

		boolean indexExists = client.admin().indices().prepareExists(INDEX).execute().actionGet().isExists();

		if (indexExists) {
			result.entrySet().forEach(entry -> {
				
				GetResponse getResponse = client.prepareGet(INDEX, INDEX, entry.getKey()).setFields(DATA_FIELD).get();
//				GetField field = client.get(request).actionGet().getField("data");
//				System.out.println(":::Class:::"+field.getName()+":::Values:::"+field.getValues());
				
				String oldCache = new Gson().toJson(getResponse.getField("data"));
				System.out.println("OldCache::::::::"+oldCache);
				UpdateRequest updateDoc = new UpdateRequest();
				updateDoc.index(INDEX);
				updateDoc.type(TYPE);
				updateDoc.id(entry.getKey());
				System.out.println("OldCache::::::::"+"{\"data\":[".concat(entry.getValue()).concat(",").concat(oldCache).concat("]}"));
				updateDoc.doc("{\"data\":[".concat(entry.getValue()).concat(",").concat(oldCache).concat("]}"));
				
				UpdateResponse response = client.update(updateDoc).actionGet();
			});

		} else {
			try {
				client.admin().indices().prepareCreate(INDEX).execute().actionGet();
				result.entrySet().forEach(entry -> client.prepareIndex(INDEX, TYPE, entry.getKey())
						.setSource("{\"data\":["+entry.getValue()+"]}").execute().actionGet());

			} catch (ElasticsearchException ex) {
				client.admin().indices().prepareDelete(INDEX).execute().actionGet();
				ex.printStackTrace();
			}
		}

	}
}
