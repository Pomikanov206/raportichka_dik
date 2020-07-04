package com.example.pomik.studentraportichka.domain.usecase.model;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class ReportFileGenerator {
    public String createHTMLReport(Map<String, List<Student>> missingUsers) {
        final StringBuilder builder = new StringBuilder();
        builder.append(String.format("<p align=\"center\">Звіт по групам за %s</p>",
                Calendar.getInstance().get(Calendar.DATE)));
        builder.append("\n");
        builder.append("<table>\n");
        builder.append("<tr><th>Групи</th><th>Відсутні студенти</th></tr>\n");

        /*
        missingUsers.forEach((k,v) -> {builder.append("<td>").append(k).append("</td><td>");
        v.forEach(student -> builder.append(student.getName()).append(" "));});
        */

        for (Map.Entry<String,List<Student>> entry: missingUsers.entrySet()) {
            builder.append("<tr>");
            builder.append("<td>").append(entry.getKey()).append("</td>");

            builder.append("<td>");
            for (Student student: entry.getValue()) {
                builder.append(student.getName()).append(", ");
            }
            builder.append("</td>");
            builder.append("</tr>\n");
        }

        builder.append("</table>");

        return builder.toString();
    }

    public String createCSVReport(Map<String, List<Student>> missingUsers) {
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
