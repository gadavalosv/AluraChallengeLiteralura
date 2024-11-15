package com.gadv.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(
        @JsonAlias("title") String title,
        @JsonAlias("authors") List<AuthorData> authorDataList,
        @JsonAlias("languages")List<String> languagesCodeList,
        @JsonAlias("download_count") Double downloadCount
        ) {
}
