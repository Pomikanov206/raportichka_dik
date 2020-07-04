package com.example.pomik.studentraportichka.datasource.file;

import com.example.pomik.studentraportichka.domain.usecase.model.Student;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class CSVFileCreator extends FileCreator {
    @Override
    public String addFilenameExtension(String path) {
        return path + ".csv";
    }

    @Override
    public String createReport(Map<String, List<Student>> missingUsers) {
        final StringBuilder builder = new StringBuilder();
        builder.append(String.format("Звіт по групам за %s",
                Calendar.getInstance().get(Calendar.DATE)));
        builder.append("\n");
        builder.append("Групи,Відсутні студенти\n");

        /*
        missingUsers.forEach((k,v) -> {builder.append("<td>").append(k).append("</td><td>");
        v.forEach(student -> builder.append(student.getName()).append(" "));});
        */

        for (Map.Entry<String,List<Student>> entry: missingUsers.entrySet()) {
            builder.append(entry.getKey()).append(";");

            for (Student student: entry.getValue()) {
                builder.append(student.getName()).append(", ");
            }
            builder.append("\n");
        }

        return builder.toString();
    }
}
