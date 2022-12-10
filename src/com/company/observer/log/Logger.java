package com.company.observer.log;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {

    private Class clazz;

    private final LogFileHandler LOG_FILE_HANDLER = LogFileHandler.getInstance();

    private Logger(Class clazz) {
        this.clazz = clazz;
    }

    public static Logger getLogger(Class clazz){
        return new Logger(clazz);
    }

    public static String getEventTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy @ HH:mm:ss.SSS");
        return  "[" + LocalDateTime.now().format(dateTimeFormatter) + "] ->";
    }

    private String getClazz() {
        return clazz.getCanonicalName();
    }

    public String getLineNumber() {
        StackTraceElement[] stackTraceElements = new Throwable().getStackTrace();
        int firstCallerIndex = stackTraceElements.length;
        return new Throwable().getStackTrace()[firstCallerIndex - 1].getLineNumber() + "";
    }

    public synchronized void INFO (String message) throws IOException {
        System.out.println(getEventTime() + "   " + ELogLevel.INFO.getAbbr() + "   {" + getClazz() + ":" +
                getLineNumber() + " - " + message + "}");
        LOG_FILE_HANDLER.getBufferedWriter().write(getEventTime() + "   " + ELogLevel.INFO.getAbbr() + "   {" + getClazz() + ":" +
                getLineNumber() + " - " + message + "}\n");
    }

    public synchronized void WARN (String message) {
        System.out.println(getEventTime() + "   " + ELogLevel.WARN.getAbbr() + "   {" + getClazz() + ":" +
                getLineNumber() + " - " + message + "}");
    }

    public synchronized void ERROR (String message) {
        System.out.println(getEventTime() + "   " + ELogLevel.ERROR.getAbbr() + "  {" + getClazz() + ":" +
                getLineNumber() + " - " + message + "}");
    }

}
