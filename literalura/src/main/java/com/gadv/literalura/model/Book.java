package com.gadv.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="books", uniqueConstraints = { @UniqueConstraint(name = "UniqueBook", columnNames = { "title", "languagesList", "downloadCount" }) })
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private List<Languages> languagesList = new ArrayList<>();
    //@Transient Para ignorar el List<Author> mientras no se habia configurado
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "BOOK_ID"),
            inverseJoinColumns = @JoinColumn(name = "AUTHOR_ID")
    )
    private List<Author> authorList = new ArrayList<>();
    private Double downloadCount;
    public Book() {}
    public Book(BookData booksData) {
        booksData.languagesCodeList().forEach(languageCode -> this.languagesList.add(Languages.fromString(languageCode)));
        booksData.authorDataList().forEach(authorData -> {
            this.authorList.add(new Author(authorData));
        });
        this.authorList.forEach(author -> author.getBookList().add(this));
        this.downloadCount = booksData.downloadCount();
        this.title = booksData.title();
        this.authorList.forEach(author -> author.getBookList().add(this));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthorList() {
        return authorList;
    }

    public void setAuthorList(List<Author> authorList) {
        this.authorList = authorList;
    }

    public List<Languages> getLanguagesList() {
        return languagesList;
    }

    public void setLanguagesList(List<Languages> languagesList) {
        this.languagesList = languagesList;
    }

    public Double getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(Double downloadCount) {
        this.downloadCount = downloadCount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", languagesList=" + languagesList +
                ", authorList=" + authorList +
                ", downloadCount=" + downloadCount +
                '}';
    }
}
