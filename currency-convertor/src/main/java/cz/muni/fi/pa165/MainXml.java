package cz.muni.fi.pa165;

import cz.muni.fi.pa165.currency.CurrencyConvertor;
import cz.muni.fi.pa165.currency.ExchangeRateTable;
import cz.muni.fi.pa165.currency.ExternalServiceFailureException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Currency;

public class MainXml {
    public static void main(String[] param) {
        ApplicationContext context = new FileSystemXmlApplicationContext("src/main/java/cz/muni/fi/pa165/beans.xml");

        ExchangeRateTable exchangeRateTable = context.getBean(ExchangeRateTable.class);
        CurrencyConvertor currencyConvertor = context.getBean(CurrencyConvertor.class);

        try {
            System.out.println(exchangeRateTable.getExchangeRate(Currency.getInstance("EUR"), Currency.getInstance("CZK")));
            System.out.println(currencyConvertor.convert(Currency.getInstance("EUR"), Currency.getInstance("CZK"), BigDecimal.ONE));

        } catch (ExternalServiceFailureException e) {
            e.printStackTrace();
        }
    }
}
