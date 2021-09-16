package pl.andrzejkuczmierowski.nbpapihandler.controller;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.andrzejkuczmierowski.nbpapihandler.model.currency.Currency;
import pl.andrzejkuczmierowski.nbpapihandler.model.table.Table;
import pl.andrzejkuczmierowski.nbpapihandler.service.CurrencyService;


import javax.validation.constraints.Pattern;
import java.util.List;

@RestController
@Validated
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;
    private static final String PARAM_LENGTH_MSG = "Invalid param length (3)";
    private static final String PARAM_TABLE_MSG = "Invalid param (a-c,A-C)";
    private static final String PARAM_CURRENCY_CODE_MSG = "Invalid param (only letters)";

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/{table}")

    public List<Table> getAll(@PathVariable(value = "table")
                        @Pattern(regexp = "^[A-Ca-c]*$", message = PARAM_TABLE_MSG)
                                String table) {
        return currencyService.getAll(table);
    }

    @GetMapping("/{table}/{code}")
    public Currency getCurrency(@PathVariable(value = "table")
                                @Pattern(regexp = "^[A-Ca-c]*$", message = PARAM_TABLE_MSG)
                                        String table,
                                @PathVariable(value = "code")
                                @Length(min = 3, max = 3,message = PARAM_LENGTH_MSG)
                                @Pattern(regexp = "^[A-Za-z]*$", message = PARAM_CURRENCY_CODE_MSG)
                                        String code) {
        return currencyService.getCurrency(table, code);
    }
}
