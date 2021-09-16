package pl.andrzejkuczmierowski.nbpapihandler.model.table;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TableRate {

    private String currency;
    private String code;
    private double mid;
}
