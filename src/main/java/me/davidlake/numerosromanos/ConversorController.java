package me.davidlake.numerosromanos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorController {
    @GetMapping("/{number}")
    public String convertToRoman(@PathVariable Integer number) {
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] romanLettersValues = {1000,900,500,400,100,90,50,40,10,9,5,4,1};

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < romanLetters.length; i++) {
            while(number >= romanLettersValues[i]) {
                number -= romanLettersValues[i];
                result.append(romanLetters[i]);
            }
        }

        return result.toString();
    }
}
