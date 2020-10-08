package org.javatrap2020.lesson.main;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class MainClass {
    private static final String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/dollar_info?json";

//"https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode="+ name +"&date=20201005&json"
//"https://bank.gov.ua/NBUStatService/v1/statdirectory/dollar_info?json"
//"https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date=20201005&json"
//"https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=EUR&date=20201005&json"

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input exchange EUR or CAD and more: ");
        String name = sc.nextLine();
        String name2 = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?valcode=" + name + "&date=20201005&json";
        HttpClient client = HttpClient
                .newBuilder()
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .header("Accept", "application/json")
                .GET()
                .uri(URI.create(name2))
                .build();

        var response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
