package pl.andrzejkuczmierowski.nbpapihandler.model.currency;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Currency {

    private String table;
    private String currency;
    private String code;
    private List<CurrencyRate> rates;
}
