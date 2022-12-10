package com.company.observer.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogFileHandler {

    private static LogFileHandler LOG_FILE_HANDLER_INSTANCE;

    private static final File LOG_FILE = new File("C:\\Users\\McCoy\\Projects\\pet_proj\\store.log");

    private FileWriter writer;

    private BufferedWriter bufferedWriter;

    private SystemShutdownListener systemShutdownListener = new SystemShutdownListener();


    private LogFileHandler() throws IOException {
        this.writer = new FileWriter(LOG_FILE);
        this.bufferedWriter = new BufferedWriter(writer);
        Runtime.getRuntime().addShutdownHook(systemShutdownListener);
    }

    public static LogFileHandler getInstance() {
        if (LOG_FILE_HANDLER_INSTANCE == null) {
            try {
                LOG_FILE_HANDLER_INSTANCE = new LogFileHandler();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return LOG_FILE_HANDLER_INSTANCE;
    }


    public FileWriter getWriter() {
        return writer;
    }

    public void setWriter(FileWriter writer) {
        this.writer = writer;
    }

    public BufferedWriter getBufferedWriter() {
        return bufferedWriter;
    }

    public void setBufferedWriter(BufferedWriter bufferedWriter) {
        this.bufferedWriter = bufferedWriter;
    }

    private class SystemShutdownListener extends Thread {


        public void run() {
            try {
                LogFileHandler.this.bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
