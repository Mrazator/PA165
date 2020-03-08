package cz.muni.fi.pa165;

import cz.muni.fi.pa165.currency.*;
import org.springframework.context.annotation.*;

import java.math.BigDecimal;
import java.util.Currency;

public class MainJavaConfig {

    public static void main(String[] param) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CurrencyConvertor currencyConvertor = context.getBean("Convertor", CurrencyConvertor.class);

        System.out.println(currencyConvertor.convert(Currency.getInstance("EUR"), Currency.getInstance("CZK"), BigDecimal.ONE));
    }
}

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
class AppConfig {
    @Bean(name = "Convertor")
    public CurrencyConvertor currencyConvertor() {
        return new CurrencyConvertorImpl(new ExchangeRateTableImpl());
    }

    @Bean
    public DurationAspect durationAspect() {
        return new DurationAspect();
    }
}

