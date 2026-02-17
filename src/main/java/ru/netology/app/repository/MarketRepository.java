package ru.netology.app.repository;


import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class MarketRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public MarketRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getProductName(String name) {

        String sql = read("query_prodname.sql");
        Map params = Map.of("name", name);

        List<String> answer = jdbcTemplate.query(sql, params, (rs, rowNum) -> {
            String product = rs.getString("product_name");
            return product;
        });

        return answer.toString();
    }


    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
