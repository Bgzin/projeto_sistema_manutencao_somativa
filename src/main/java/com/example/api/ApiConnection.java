package com.example.api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;


public class ApiConnection {
    private static final String API_URL = "http://localhost:3000/"; //endereço da api


    public static String getData(String endpoint) {
        try {
            URL url = new URL(API_URL + endpoint);//aqui seria quando juntamos o endereço da api junto do endpoint que seria o maquinas por exemplo
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");


            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();


            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }


            in.close();
            connection.disconnect();
            return content.toString();


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //POST
    public static void postData(String endPoint, String inputData){
        try {
            URL url = new URL(API_URL + endPoint);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);

            try (BufferedWriter bw = new BufferedWriter(
                    new OutputStreamWriter(connection.getOutputStream(), "UTF-8"))) {
                bw.write(inputData);
                bw.flush();

                    }
                    //verificar status da resposta
                    int status = connection.getResponseCode();
                    if (status == HttpURLConnection.HTTP_CREATED) {
                        System.out.println("POST request created successfully");
                    } else {
                        System.out.println("POST request failed with status code " + status);
                    }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
