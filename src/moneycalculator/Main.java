package moneycalculator;

import moneycalculator.persistance.CurrencyListLoader;
import moneycalculator.control.CalculatedCommand;
import moneycalculator.persistance.ExchangeRateLoader;
import moneycalculator.persistance.files.FileCurrencyListLoader;
import moneycalculator.persistance.rest.RestExchangeRateLoader;

public class Main {

    public static void main(String[] args) {
        CurrencyListLoader currencyLoader = new FileCurrencyListLoader("currencies");
        ExchangeRateLoader exchangeRateLoader = new RestExchangeRateLoader();
        MainFrame mainFrame = new MainFrame(currencyLoader.currencies());
        mainFrame.add(new CalculatedCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay(), exchangeRateLoader));
    }
    
}
