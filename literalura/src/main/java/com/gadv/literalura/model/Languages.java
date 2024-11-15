package com.gadv.literalura.model;

public enum Languages {
    ESPANOL("es", "Español"),
    INGLES("en", "Inglés"),
    FRANCES("fr", "Francés"),
    PORTUGUES("pt", "Portugués");
    private String languageCode;
    private String languageEspanol;

    Languages(String languageCode, String languageEspanol) {
        this.languageCode = languageCode;
        this.languageEspanol = languageEspanol;
    }

    public static Languages fromString(String text) {
        for (Languages smCategory : Languages.values()) {
            if (smCategory.languageCode.equalsIgnoreCase(text)) {
                return smCategory;
            }
        }
        throw new IllegalArgumentException("Ninguna código encontrado: " + text);
    }

    public static Languages fromEspanol(String text) {
        for (Languages smCategory : Languages.values()) {
            if (smCategory.languageEspanol.equalsIgnoreCase(text)) {
                return smCategory;
            }
        }
        throw new IllegalArgumentException("Ninguna idioma encontrado: " + text);
    }
}
