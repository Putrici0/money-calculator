package software.ulpgc.moneycalculator.service;

public interface ExchangeRateProvider {

    CurrencyRatesWithDate getExchangeRates();
}
