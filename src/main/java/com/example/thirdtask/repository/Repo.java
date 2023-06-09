package com.example.thirdtask.repository;

import com.example.thirdtask.config.DataSourceConfig;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class Repo {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final String scriptFileName = "product.sql";
    private final String requestLine = read(scriptFileName);

    public Repo(DataSourceConfig cfg) {
        DataSource source=cfg.getDataSource();
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(source);

    }


    public List<String> getProductName(String name){
        MapSqlParameterSource parameters = new MapSqlParameterSource("name",name);
        List<String> res = namedParameterJdbcTemplate.queryForList(requestLine,parameters,String.class);
        return res;
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
