package software.ulpgc.moneycalculator.service;

import java.util.Map;

public record CurrencyRatesWithDate(Map<String, Double> rates, String date) {
}
