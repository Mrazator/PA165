package cz.muni.fi.pa165;

import cz.muni.fi.pa165.currency.CurrencyConvertor;
import cz.muni.fi.pa165.currency.CurrencyConvertorImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;
import java.util.Currency;

public class MainAnnotations {
    public static void main(String[] param) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        context.scan("cz.muni.fi.pa165.currency");
        context.refresh();

        CurrencyConvertor currencyConvertor = context.getBean(CurrencyConvertorImpl.class);

        System.out.println(currencyConvertor.convert(Currency.getInstance("EUR"), Currency.getInstance("CZK"), BigDecimal.ONE));
    }
}
