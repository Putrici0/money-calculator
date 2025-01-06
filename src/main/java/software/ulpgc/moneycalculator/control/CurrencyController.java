package software.ulpgc.moneycalculator.control;

import software.ulpgc.moneycalculator.model.CurrencyModel;
import software.ulpgc.moneycalculator.service.CurrencyRatesWithDate;
import software.ulpgc.moneycalculator.service.CurrencyService;
import software.ulpgc.moneycalculator.view.CurrencySwingView;

import javax.swing.*;
import java.util.Objects;

public class CurrencyController {
    private final CurrencyModel model;
    private final CurrencySwingView view;

    public CurrencyController(CurrencyModel model, CurrencySwingView view, CurrencyService service) {
        this.model = model;
        this.view = view;

        CurrencyRatesWithDate ratesWithDate = service.getExchangeRates();
        model.updateExchangeRates(ratesWithDate);

        initialize();
    }

    private void initialize() {
        view.populateCurrencies(model.getExchangeRates().keySet());
        view.getConvertButton().addActionListener(e -> handleConversion());
        updateExchangeDate();
    }

    private void updateExchangeDate() {
        view.getLastUpdateLabel().setText("Last Updated on: " + model.getLastUpdateDate());
    }

    private void handleConversion() {
        try {
            String from = Objects.requireNonNull(view.getFromCurrency().getSelectedItem()).toString();
            String to = Objects.requireNonNull(view.getToCurrency().getSelectedItem()).toString();

            double amount = Double.parseDouble(view.getAmountField().getText());
            double result = model.convert(from, to, amount);

            view.getResultLabel().setText("    Result: " + result + " " + view.getToCurrency().getSelectedItem());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error: " + e.getMessage());
        }
    }
}
