package pl.andrzejkuczmierowski.nbpapihandler.model.currency;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
public class CurrencyRate {
    private String no;
    private LocalDate effectiveDate;
    private double mid;
}
