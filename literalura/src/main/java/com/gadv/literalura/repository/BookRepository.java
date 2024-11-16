package com.gadv.literalura.repository;

import com.gadv.literalura.model.Book;
import com.gadv.literalura.model.Languages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM books WHERE languages_list @> CAST(:language AS varchar[])", nativeQuery = true)
    List<Book> getBooksByLanguages(@Param("language") String language);

    Optional<Book> findByTitleAndLanguagesListAndDownloadCount(String title, List<Languages> languagesList, Double downloadCount);
}
