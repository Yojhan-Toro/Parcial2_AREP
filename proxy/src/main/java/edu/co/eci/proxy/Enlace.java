package edu.co.eci.proxy;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class Enlace {

    private static final String USER_AGENT = "Mozilla/5.0";

    private final String[] urls;

    public Enlace() {
        this.urls = new String[]{
                "http://ec2-54-152-108-98.compute-1.amazonaws.com:8080",
                "http://ec2-44-203-198-211.compute-1.amazonaws.com:8080"
        };
    }

    public String delegate(String path, String queryString) {
        String query = (queryString != null && !queryString.isBlank()) ? "?" + queryString : "";

        for (String url : urls) {
            try {
                System.out.println("Intentando con: " + url);
                return callService(url + path + query);
            } catch (IOException e) {
                System.out.println("Fallo en: " + url + " -> " + e.getMessage());
            }
        }

        return "Todas las instancias fallaron";
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
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream())
            );

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            return response.toString();

        } else {
            throw new IOException("HTTP error code: " + responseCode);
        }
    }

    public String[] getUrls() {
        return urls;
    }
}