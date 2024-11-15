package com.gadv.literalura.main;

import com.gadv.literalura.model.Book;
import com.gadv.literalura.model.BookData;
import com.gadv.literalura.model.Data;
import com.gadv.literalura.repository.BookRepository;
import com.gadv.literalura.service.ConsultAPI;
import com.gadv.literalura.service.ConvertData;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private ConsultAPI consultAPI = new ConsultAPI();
    private final String URL_BASE = "https://gutendex.com/books/?";
    private ConvertData convertData = new ConvertData();
    @Autowired
    private final BookRepository bookRepository;
    private List<Book> bookList;

    public Main(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void showMenu(Scanner scanner) {
        int optionMenu = -1;
        while (optionMenu != 0) {
            String menu = """
                    1 - Buscar Libro por Título
                    2 - Listar Libros Registrados
                    3 - Listar Autores Registrados
                    4 - Listar Autores Vivos en un Determinado Año
                    5 - Listar Libros por Idioma
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            optionMenu = scanner.nextInt();
            scanner.nextLine();
            switch (optionMenu) {
                case 1:
                    searchBookByTitle(scanner);
                    break;
                case 2:
                    showRegisteredBooks();
                    break;
                case 3:
                    showRegisteredAuthors();
                    break;
                case 4:
                    showAuthorsByYearLiving(scanner);
                    break;
                case 5:
                    showBooksByLanguage(scanner);
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private BookData getBooksData(Scanner scanner){
        System.out.println("Por favor escribe el nombre del Libro que deseas buscar:");
        String bookName = scanner.nextLine();
        var json = consultAPI.getData(URL_BASE + "search=" + URLEncoder.encode(bookName, StandardCharsets.UTF_8));
        Data data = convertData.getData(json, Data.class);
        return (!data.bookDataList().isEmpty()) ? data.bookDataList().get(0) : null;
    }

    private void showBooksByLanguage(Scanner scanner) {
        //
    }

    private void showAuthorsByYearLiving(Scanner scanner) {
        //
    }

    private void showRegisteredAuthors() {
        //
    }

    private void showRegisteredBooks() {
        bookList = bookRepository.findAll();
        bookList.stream()
                .sorted(Comparator.comparing(Book::getTitle)) //MY VERSION: .sorted(Comparator.comparing(serie -> serie.getGenre(0)))
                .forEach(System.out::println);
    }

    private void searchBookByTitle(Scanner scanner) {
        BookData booksData = getBooksData(scanner);
        if(booksData == null) {
            System.out.println("No book data found.");
            return;
        }
        Book book = new Book(booksData);
        bookRepository.save(book);
        System.out.println(book);
    }
}
