package com.explore;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@SpringBootApplication
@Log4j2
public class H2Application implements CommandLineRunner {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    DataSource dataSource;

    @Value("${spring.datasource.hikari.leak-detection-threshold}")
    int leakDetectionThreshold;

    public static void main(String... args) {
        SpringApplication.run(H2Application.class, args);
    }

    @Override
    public void run(String... args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            IntStream.iterate(leakDetectionThreshold - 100, i -> i + 50).limit(4).forEach(i -> {
                Connection connection2 = null;
             try(Connection connection = dataSource.getConnection()) {
                 log.info("connection acquired : {}", connection);
                 connection2 = connection;
                 TimeUnit.MILLISECONDS.sleep(i);
             } catch (Throwable th) {
                 th.printStackTrace();
             } finally {
                 log.info("connection released : {}", connection2);
             }
            });
        });
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("Select * from countries");
        if(Objects.nonNull(maps))
            if(!maps.isEmpty())
                maps.stream().forEach(stringObjectMap -> log.info("stringObjectMap = {}", stringObjectMap));

    }
}