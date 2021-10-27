package com.example.task_8;

import java.util.Locale;

public class MethodsString {

    public static void pustEmptyLine() { System.out.println(); }
    public static void pustString(String pointName, String... pointsValue) {

        StringBuilder result = new StringBuilder(" * ")
                .append(pointName)
                .append(":");

        for (String pointValue : pointsValue) {

            result.append(" ").append(pointValue);

        }

        result.append(";");

        System.out.println(result.toString());

    }
    public static void pustString(String pointName, String pointValue) {

        System.out.println(
                new StringBuilder(" * ")
                        .append(pointName)
                        .append(": ")
                        .append(pointValue)
                        .append(";")
        );

    }
    public static void pustStringError(String string) {
        System.out.println(" ! ОШИБКА - " + string + ";");
    }
    public static void pustStringInfo(String string) { System.out.println(" $ ИНФОРМАЦИЯ - " + string + ";"); }
    public static void pustHeader(String headerName) {
        pustEmptyLine();
        System.out.println("< " + headerName.toUpperCase(Locale.ROOT) + " >");
    }
}
