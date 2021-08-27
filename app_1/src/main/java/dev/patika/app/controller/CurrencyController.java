package dev.patika.app.controller;

import dev.patika.app.model.dto.CurrencyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/curency")
public class CurrencyController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/try-to-usd")
    public CurrencyDto getTryToUsd(@RequestParam double tryValue){
        CurrencyDto currency = restTemplate.getForObject("http://localhost:4540/currency/converter/try-to-usd?value=" + tryValue, CurrencyDto.class);
        return currency;
    }

    @GetMapping("/usd-to-try")
    public CurrencyDto getUsdToTry(@RequestParam double usdValue){
        CurrencyDto currency = restTemplate.getForObject("http://localhost:4540/currency/converter/usd-to-try?value=" + usdValue, CurrencyDto.class);
        return currency;
    }
}
