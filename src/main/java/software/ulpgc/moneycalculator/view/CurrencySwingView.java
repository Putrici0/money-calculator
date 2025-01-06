package software.ulpgc.moneycalculator.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Set;

public class CurrencySwingView extends JFrame {

    private final JComboBox<String> fromCurrency;
    private final JComboBox<String> toCurrency;
    private final JTextField amountField;
    private final JButton convertButton;
    private final JLabel resultLabel;
    private final JLabel lastUpdateLabel;

    public CurrencySwingView() {
        setTitle("Money Calculator");
        setSize(800, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6,2));

        add(new JLabel("    From Currency:"));
        fromCurrency = new JComboBox<>();
        add(fromCurrency);


        add(new JLabel("    ToCurrency:"));
        toCurrency = new JComboBox<>();
        add(toCurrency);

        add(new JLabel("    Amount:"));
        amountField = new JTextField();
        add(amountField);

        convertButton = new JButton("Convert");
        add(convertButton);

        resultLabel = new JLabel("    Result:");
        add(resultLabel);

        lastUpdateLabel = new JLabel("Last Updated on: ");
        add(lastUpdateLabel);
    }

    public JComboBox<String> getFromCurrency() {
        return fromCurrency;
    }

    public JComboBox<String> getToCurrency() {
        return toCurrency;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JButton getConvertButton() {
        return convertButton;
    }

    public JLabel getResultLabel() {
        return resultLabel;
    }

    public JLabel getLastUpdateLabel() {
        return lastUpdateLabel;
    }

    public void populateCurrencies(Set<String> currencies) {
        List<String> currenciesOrdered = currencies.stream().sorted().toList();
        for (String currency : currencies) {
            fromCurrency.addItem(currency);
            toCurrency.addItem(currency);
        }
    }
}
