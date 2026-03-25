package edu.co.eci.proxy;

import org.springframework.stereotype.Service;




//package co.edu.eci.proxy.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class Enlace {

    private static final String USER_AGENT = "Mozilla/5.0";

    private final String Url;


    public Enlace() {


        this.Url = "http://localhost:8080";

    }

    public String delegate(String path, String queryString) {
        String query = (queryString != null && !queryString.isBlank()) ? "?" + queryString : "";

        try {
            return callService(Url + path + query);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return "error api";
    }

    private String callService(String targetUrl) throws IOException {
        URL obj = new URL(targetUrl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        con.setConnectTimeout(3000);
        con.setReadTimeout(3000);

        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            System.out.println("GET DONE");
            return response.toString();
        } else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }

    public String getUrl()  { return Url; }

}
