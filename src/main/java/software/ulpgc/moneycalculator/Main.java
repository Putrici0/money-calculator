package software.ulpgc.moneycalculator;

import software.ulpgc.moneycalculator.control.CurrencyController;
import software.ulpgc.moneycalculator.model.CurrencyModel;
import software.ulpgc.moneycalculator.service.CurrencyService;
import software.ulpgc.moneycalculator.view.CurrencySwingView;

public class Main {
    public static void main(String[] args) {
        CurrencyModel model = new CurrencyModel();
        CurrencySwingView view = new CurrencySwingView();
        CurrencyService service = new CurrencyService();
        new CurrencyController(model, view, service);
        view.setVisible(true);
    }
}
