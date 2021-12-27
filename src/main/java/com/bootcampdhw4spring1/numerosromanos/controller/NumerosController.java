package com.bootcampdhw4spring1.numerosromanos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NumerosController {

    @GetMapping
    public String index() {
        return "Okay";
    }

    @GetMapping(path = "/converte/{decimal}")
    public String converteDecimal(@PathVariable int decimal) {

        String m[] = { "", "M", "MM", "MMM" };
        String c[] = { "",  "C",  "CC",  "CCC",  "CD",
                "D", "DC", "DCC", "DCCC", "CM" };
        String x[] = { "",  "X",  "XX",  "XXX",  "XL",
                "L", "LX", "LXX", "LXXX", "XC" };
        String i[] = { "",  "I",  "II",  "III",  "IV",
                "V", "VI", "VII", "VIII", "IX" };

        // Converting to roman
        String thousands = m[decimal / 1000];
        String hundreds = c[(decimal % 1000) / 100];
        String tens = x[(decimal % 100) / 10];
        String ones = i[decimal % 10];

        String ans = thousands + hundreds + tens + ones;

        return "Seu numero é: " + decimal +
                "\nO equivalente romano é: " + ans;
    }

}
