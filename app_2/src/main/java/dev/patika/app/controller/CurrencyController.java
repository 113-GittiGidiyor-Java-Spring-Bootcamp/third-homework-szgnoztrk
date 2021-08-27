package dev.patika.app.controller;

import dev.patika.app.model.Currency;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("currency/converter")
public class CurrencyController {
    private static final double TRY_TO_USD = 0.12;
    private static final double USD_TO_TRY = 8.37;

    @GetMapping("/try-to-usd")
    public Currency getTryToUsd(@RequestParam double value){
        Currency currency = new Currency();
        currency.setTurkishLira(value);
        currency.setUsd(value * TRY_TO_USD);
        return currency;
    }

    @GetMapping("/usd-to-try")
    public Currency getUsdToTry(@RequestParam double value){
        Currency currency = new Currency();
        currency.setUsd(value);
        currency.setTurkishLira(value * USD_TO_TRY);
        return currency;
    }
}
