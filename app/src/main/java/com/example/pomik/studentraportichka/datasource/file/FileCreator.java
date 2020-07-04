package com.example.pomik.studentraportichka.datasource.file;

import android.content.Context;
import com.example.pomik.studentraportichka.domain.usecase.model.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

abstract public class FileCreator {
    private File file;

    public void templateMethod(Context context, Map<String, List<Student>> missingUsers) {
        String path = createPath();
        path = addFilenameExtension(path);
        file = createFile(context, path);
        String report = createReport(missingUsers);
        save(file, report);
    }
    public String createPath(){
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

        return builder.toString();
    }
    public abstract String addFilenameExtension(String path);

    public File createFile(Context context, String path) {
        return  new File(context.getCacheDir(), path);
    }

    public abstract String createReport(Map<String, List<Student>> missingUsers);

    public void save(File file, String data) {
        try (FileWriter writer = new FileWriter(file)){
            writer.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFile() {
        return file;
    }
}
