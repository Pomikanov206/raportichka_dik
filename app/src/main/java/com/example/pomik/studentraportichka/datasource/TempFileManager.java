package com.example.pomik.studentraportichka.datasource;

import android.content.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class TempFileManager {
    private static TempFileManager instance = null;
    private String fileNameCSV = null;
    private String fileNameHTML = null;

    private File fileCSV;
    private File fileHTML;

    private TempFileManager() {
        int day = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        int month = Calendar.getInstance().get(Calendar.MONTH);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        StringBuilder builder = new StringBuilder();
        builder.append("raportichka");
        builder.append("_");
        builder.append(day);
        builder.append("_");
        builder.append(month);
        builder.append("_");
        builder.append(year);
        builder.append(".csv");
        fileNameCSV = builder.toString();

        fileNameHTML = builder.toString().replaceFirst(".csv",".html");
        // Проблема с получением Контекста для создания файла

    }

    public static TempFileManager getInstance() {
        if (instance == null)
            instance = new TempFileManager();
        return instance;
    }

    public void create(Context context) {
        fileCSV = new File(context.getCacheDir(), fileNameCSV);
        fileHTML = new File(context.getCacheDir(), fileNameHTML);
//        try {
//            if(!file.isFile())
//                file = File.createTempFile(fileNameCSV, null, context.getCacheDir());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public void saveCSV(String text) {
        try {
            FileWriter writer = new FileWriter(fileCSV);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveHTML(String text) {
        try {
            FileWriter writer = new FileWriter(fileHTML);
            writer.write(text);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {

    }

    public File getCSVFile() {
        return fileCSV;
    }
    public File getHTMLFile() {
        return fileHTML;
    }
}
