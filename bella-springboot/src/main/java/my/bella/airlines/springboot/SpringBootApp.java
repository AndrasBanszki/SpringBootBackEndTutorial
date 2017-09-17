package my.bella.airlines.springboot;

import javax.sql.DataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author Bánszki András <andras.banszki@gmail.com>
 */
@ComponentScan(basePackages = "my.bella.airlines")
@SpringBootApplication
public class SpringBootApp {

    private static final String URL = "jdbc:mysql://localhost:3306/bella_airline?useSSL=false&serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "admin";

    public static void main(String args[]) {
        SpringApplication.run(SpringBootApp.class, args);
    }

    @Bean
    @Primary
    public NamedParameterJdbcTemplate getJdbcTemplate() {
        DataSource dataSource = new DriverManagerDataSource(URL, USERNAME, PASSWORD);
        return new NamedParameterJdbcTemplate(dataSource);
    }

}
