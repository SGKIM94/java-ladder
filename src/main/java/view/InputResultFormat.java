package view;

import domain.Results;

public class InputResultFormat {
    public static void printInputResult(Results result, int resultIndex, String inputResult) {
        System.out.print(inputResult + " : ");
        System.out.println(result.getResult(resultIndex));
    }

}
