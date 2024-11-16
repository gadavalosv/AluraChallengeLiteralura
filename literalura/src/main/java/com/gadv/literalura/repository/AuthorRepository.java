package com.gadv.literalura.repository;

import com.gadv.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    @Query("SELECT a FROM Author a WHERE (a.birthYear <= :year) AND (a.deathYear IS NULL OR a.deathYear >= :year)")
    List<Author> findAuthorsLiveInYear(@Param("year") int year);
}