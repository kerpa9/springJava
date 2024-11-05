package com.principal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.kevenreyes.model.DataSeason;
import com.kevenreyes.model.Episode;
import com.kevenreyes.model.EspisodeData;
import com.kevenreyes.model.SeriesData;
import com.kevenreyes.services.ConsultAPI;
import com.kevenreyes.services.DataConverter;

public class Principal {

        private Scanner write = new Scanner(System.in);
        private ConsultAPI consultAPI = new ConsultAPI();
        private final String URL_BASE = "https://www.omdbapi.com/?t=";
        private final String ApiKey = "&apikey=e2a21826&t";
        private List<SeriesData> dataSeries = new ArrayList<>();
        // private String nameSerie = write.nextLine().replace(" ", "+");
        // private String url = URL_BASE + nameSerie + ApiKey;
        // Converter data

        private DataConverter dataConverter = new DataConverter();

        public void seeMenu() {

                var option = -1;
                while (option != 0) {

                        var menu = """
                                        1. Find Series
                                        2. Find Seasons
                                        3. Show searched series
                                        0. Exit

                                                """;

                        System.out.println(menu);
                        option = write.nextInt();
                        write.nextLine();

                        switch (option) {
                                case 1:

                                        findSerieWeb();

                                        break;
                                case 2:

                                        findSeasonToSerie();

                                        break;
                                case 3:
                                        showsearchedseries();

                                        break;

                                default:
                                        break;
                        }

                }

        }

        private SeriesData getDataSerie() {

                System.out.println("Please Write to find your favorite series");
                String nameSerie = write.nextLine().replace(" ", "+");
                String url = URL_BASE + nameSerie + ApiKey;
                var json = consultAPI.dataObtain(url);
                // System.out.println(json);
                var data = dataConverter.obtainData(json, SeriesData.class);
                return data;
        }

        private void findSeasonToSerie() {

                SeriesData seriesData = getDataSerie();
                List<DataSeason> dataSeasons = new ArrayList<>();

                for (int i = 1; i <= seriesData.totalTemp(); i++) {
                        // String url2 = "https://www.omdbapi.com/?t=game+of+thrones&Season=" + i +
                        // "&apikey=e2a21826&t";
                        String url2 = URL_BASE + seriesData.title() + "&Season=" + i + ApiKey;
                        var json = consultAPI.dataObtain(url2);
                        var seasons = dataConverter.obtainData(json, DataSeason.class);
                        dataSeasons.add(seasons);

                }

                dataSeasons.forEach(System.out::println);

        }

        private void findSerieWeb() {

                SeriesData data = getDataSerie();
                dataSeries.add(data);
                System.out.println(data);

        }

        private void showsearchedseries() {
                dataSeries.forEach(System.out::println);
        }
}
