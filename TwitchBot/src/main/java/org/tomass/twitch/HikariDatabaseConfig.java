package org.tomass.twitch;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class HikariDatabaseConfig {

    @Value("${hikari.db.pass}")
    private String pass;

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "hikari.db")
    public HikariConfig refConfig() {
        return new HikariConfig();
    }

    @Bean
    @Primary
    public DataSource dataSource() {
        HikariConfig config = refConfig();
        String password = getSwarmSecret(pass);
        if (password != null)
            config.setPassword(password);
        else
            config.setPassword(pass);

        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    public static String getSwarmSecret(String name) {
        Path file = Paths.get("/run/secrets", name);
        if (!Files.isReadable(file))
            return null;
        try (BufferedReader br = Files.newBufferedReader(file)) {
            List<String> list = br.lines().collect(Collectors.toList());
            return (list.isEmpty()) ? null : list.get(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
