package com.kevenreyes.screenmatch;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kevenreyes.model.DataSeason;
import com.kevenreyes.model.EspisodeData;
import com.kevenreyes.model.SeriesData;
import com.kevenreyes.services.ConsultAPI;
import com.kevenreyes.services.DataConverter;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String url = "https://www.omdbapi.com/?t=game+of+thrones&apikey=e2a21826&t";

		var consultationApi = new ConsultAPI();
		var json = consultationApi.dataObtain(url);

		System.out.println("----------------------------JSON----------------------------");
		// System.out.println(json);

		// Manage Series

		DataConverter dataConverter = new DataConverter();
		var data = dataConverter.obtainData(json, SeriesData.class);
		System.out.println(data);

		// Manage episodes

		String url1 = "https://www.omdbapi.com/?t=game+of+thrones&Season=1&episode=1&apikey=e2a21826&t";
		json = consultationApi.dataObtain(url1);

		EspisodeData espisodeData = dataConverter.obtainData(json, EspisodeData.class);
		System.out.println(espisodeData);

		// Manage list
		List<DataSeason> dataSeasons = new ArrayList<>();
		for (int i = 1; i <= data.totalTemp(); i++) {
			String url2 = "https://www.omdbapi.com/?t=game+of+thrones&Season=" + i + "&apikey=e2a21826&t";
			json = consultationApi.dataObtain(url2);
			var seasons = dataConverter.obtainData(json, DataSeason.class);
			dataSeasons.add(seasons);

		}

		System.out.println("-------------------EPISODE LIST-----------------------");
		dataSeasons.forEach(System.out::println);

	}

}
