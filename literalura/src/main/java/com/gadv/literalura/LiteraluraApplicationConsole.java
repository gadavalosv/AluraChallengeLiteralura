package com.gadv.literalura;

import com.gadv.literalura.main.Main;
import com.gadv.literalura.repository.AuthorRepository;
import com.gadv.literalura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class LiteraluraApplicationConsole implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public static void main(String[] args) {
        SpringApplication.run(LiteraluraApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main(bookRepository, authorRepository);
        main.showMenu(scanner);
        scanner.close();
    }
}
