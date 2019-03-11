package com.company.MP09.UF3.A2;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SendRequest {

    public static String executePost(String targetURL, String urlParameters) {
        URL url;
        HttpURLConnection connection = null;

        try {
            //Create connection
            URL web = new URL(targetURL);
            connection = (HttpURLConnection) web.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type",
                    "application/x-www-form-urlencoded");

            //connection.setRequestProperty("Content-Length",
            //        Integer.toString(urlParameters.getBytes().length));
            //connection.setRequestProperty("Content-Language", "en-US");

            //connection.setUseCaches(false);
            //connection.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    connection.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.close();

            //Get Response
            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder(); // or StringBuffer if Java version 5+
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            rd.close();
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
