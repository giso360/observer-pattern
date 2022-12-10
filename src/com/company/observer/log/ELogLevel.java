package com.company.observer.log;

public enum ELogLevel {

    INFO("INFO"),
    ERROR("ERROR"),
    WARN("WARN");

    private final String abbr;

    ELogLevel(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }

}
