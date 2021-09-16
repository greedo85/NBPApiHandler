package pl.andrzejkuczmierowski.nbpapihandler.model.table;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
public class Table {

    private String table;
    private String no;
    private LocalDate effectiveDate;
    private List<TableRate> rates;
}
