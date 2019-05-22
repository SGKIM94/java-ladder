package view;

import domain.Results;

public class ResultFormat {
    public static void printResults(Results results) {
        System.out.println(results.toString());
        System.out.println();
    }
}