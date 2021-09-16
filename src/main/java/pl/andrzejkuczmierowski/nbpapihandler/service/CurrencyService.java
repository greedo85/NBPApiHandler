package pl.andrzejkuczmierowski.nbpapihandler.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.andrzejkuczmierowski.nbpapihandler.model.currency.Currency;
import pl.andrzejkuczmierowski.nbpapihandler.model.table.Table;
import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CurrencyService {
    @Autowired
    private final RestTemplate restTemplate;
    private static final long CACHE_TTL = 5L * 60 * 1000;

    public List<Table> getAll(String tableName) {
        Table[] table = restTemplate.getForObject(String.format("http://api.nbp.pl/api/exchangerates/tables/%s/", tableName), Table[].class);
        return  Arrays.asList(table);
    }

    @CacheEvict(allEntries = true, cacheNames = {"currency"})
    @Scheduled(fixedDelay = CACHE_TTL)
    public Currency getCurrency(String table, String code) {
        return restTemplate.getForObject(String.format("http://api.nbp.pl/api/exchangerates/rates/%s/%s/", table, code), Currency.class);
    }

}
