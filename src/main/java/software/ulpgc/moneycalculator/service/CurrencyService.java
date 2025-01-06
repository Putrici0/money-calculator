package software.ulpgc.moneycalculator.service;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


public class CurrencyService implements ExchangeRateProvider {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";

    @Override
    public CurrencyRatesWithDate getExchangeRates() {
        Map<String, Double> rates = new HashMap<>();
        String date = "";

        try {
            JSONObject jsonResponse = getJsonObject();
            JSONObject jsonRates = jsonResponse.getJSONObject("rates");
            date = jsonResponse.getString("date");
            for (String key : jsonRates.keySet()) {
                rates.put(key, jsonRates.getDouble(key));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new CurrencyRatesWithDate(rates, date);
    }

    private JSONObject getJsonObject()  throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return new JSONObject(response.toString());
    }
}
