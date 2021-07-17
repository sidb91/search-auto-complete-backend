package com.opolo.hsbctest.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opolo.hsbctest.model.CityGeoData;
import com.opolo.hsbctest.model.CityModel;

@Service
public class SearchService {

	private static final String dataURL = "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22";

	private List<CityModel> geoCityDataList = new ArrayList<CityModel>();

	public List<CityModel> getCitiesDataList() {

		// fetch external GEO city data from API...
		final HttpClient client = HttpClient.newHttpClient();
		final HttpRequest request = HttpRequest.newBuilder().uri(URI.create(dataURL)).build();

		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println("------Response API-----------" + response.body());
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true);
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			
			CityGeoData cityGeoData = mapper.readValue(response.body(), CityGeoData.class);
			geoCityDataList = cityGeoData.getList();
					
		} catch (IOException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		return geoCityDataList;

	}

}
