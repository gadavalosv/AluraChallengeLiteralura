package com.gadv.literalura.repository;

import com.gadv.literalura.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
