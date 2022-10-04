package br.com.fiap.riapi.services;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class apiVoiceService {

    private final String API_VOICE_URL = "http://192.168.15.20:5000";

    public Object healthDrive() throws IOException {
        String url = API_VOICE_URL + "/health/drive";
        return genericGetBasicApi(url);
    }

    public Object healthZamzar() throws IOException {
        String url = API_VOICE_URL + "/health/zamzar";
        return genericGetBasicApi(url);
    }

    public Object genericGetBasicApi(String url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            System.out.println("Erro " + conn.getResponseCode() + " ao obter dados da URL " + url);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        String output = "";
        String line;
        while ((line = br.readLine()) != null) {
            output += line;
        }

        conn.disconnect();

        Gson gson = new Gson();

        return gson.fromJson(new String(output.getBytes()), Object.class);
    }

}
