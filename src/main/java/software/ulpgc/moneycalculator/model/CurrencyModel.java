package software.ulpgc.moneycalculator.model;

import software.ulpgc.moneycalculator.service.CurrencyRatesWithDate;

import java.util.HashMap;
import java.util.Map;

public class CurrencyModel {
    private Map<String, Double> exchangeRates;
    private String lastUpdateDate;

    public CurrencyModel() {
        exchangeRates = new HashMap<>();
        lastUpdateDate = "";
    }

    public Map<String, Double> getExchangeRates() {
        return this.exchangeRates;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void updateExchangeRates(CurrencyRatesWithDate ratesWithDate) {
        this.exchangeRates = ratesWithDate.rates();
        this.lastUpdateDate = ratesWithDate.date();
    }

    public double convert(String fromCurrency, String toCurrency, double amount) {
        if(!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw  new IllegalArgumentException("Currency Not Supported!");
        }
        double fromRate = exchangeRates.get(fromCurrency);
        double toRate = exchangeRates.get(toCurrency);

        return (amount / fromRate) * toRate;
    }
}
