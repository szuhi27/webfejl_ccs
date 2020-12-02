package webfejl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.ApplicationContext;
import webfejl.dao.TransactionDao;
import webfejl.dao.TransactionRepository;
import webfejl.model.Transaction;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

@Slf4j
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

    }

}
