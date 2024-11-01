package com.principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.kevenreyes.model.DataSeason;
import com.kevenreyes.model.SeriesData;
import com.kevenreyes.services.ConsultAPI;
import com.kevenreyes.services.DataConverter;

public class Principal {

    private Scanner write = new Scanner(System.in);
    private ConsultAPI consultAPI = new ConsultAPI();
    private String URL_BASE = "https://www.omdbapi.com/?t=";
    private String ApiKey = "&apikey=e2a21826&t";
    // private String nameSerie = write.nextLine().replace(" ", "+");
    // private String url = URL_BASE + nameSerie + ApiKey;
    // Converter data

    private DataConverter dataConverter = new DataConverter();

    public void seeMenu() {

        System.out.println("Write to find your favorite series");
        String nameSerie = write.nextLine().replace(" ", "+");
        String url = URL_BASE + nameSerie + ApiKey;
        var json = consultAPI.dataObtain(url);
        var data = dataConverter.obtainData(json, SeriesData.class);
        System.out.println(json);

        List<DataSeason> dataSeasons = new ArrayList<>();
        for (int i = 1; i <= data.totalTemp(); i++) {
            // String url2 = "https://www.omdbapi.com/?t=game+of+thrones&Season=" + i +
            // "&apikey=e2a21826&t";
            String url2 = URL_BASE + nameSerie + "&Season=" + i + ApiKey;
            json = consultAPI.dataObtain(url2);
            var seasons = dataConverter.obtainData(json, DataSeason.class);
            dataSeasons.add(seasons);

        }

        System.out.println("-------------------EPISODE LIST-----------------------");
        dataSeasons.forEach(System.out::println);

    }

}
