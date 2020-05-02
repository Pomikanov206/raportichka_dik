package com.example.pomik.studentraportichka.model;

import android.content.Context;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class TempFileManager {
    private static TempFileManager instance = null;
    private String fileName = null;
    private File file;

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
        builder.append(".raport");
        fileName = builder.toString();

        // Проблема с получением Контекста для создания файла

    }

    public static TempFileManager getInstance() {
        if (instance == null)
            instance = new TempFileManager();
        return instance;
    }

    public void create(Context context) {
        file = new File(context.getCacheDir(),fileName);
        try {
            if(!file.isFile())
                file = File.createTempFile(fileName, null, context.getCacheDir());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(String text) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {

    }
}
