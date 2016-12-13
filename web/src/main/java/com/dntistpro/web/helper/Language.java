package com.dntistpro.web.helper;

/**
 * Created by vrudyk on 12.10.2016.
 */
public enum Language {
    EN("en"),
    UA("ua");

    private String languageCode;

    Language(String languageCode) {
        this.languageCode = languageCode;
    }

    public String code() {
        return languageCode;
    }

    public static Language from(String value) {
        for (Language lng : values()){
            if (lng.languageCode.equals(value)) {
                return lng;
            }
        }
        return EN;
    }
}
