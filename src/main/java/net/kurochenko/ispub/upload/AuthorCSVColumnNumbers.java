package net.kurochenko.ispub.upload;

/**
 * User: kurochenko
 * Date: 7/9/11
 * Time: 8:52 PM
 */
public enum AuthorCSVColumnNumbers {

    UCO(1),
    NAME(2),
    SURNAME(3),
    DEPARTMENT(10),
    SOURCES(new int[]{11, 12, 13}),
    NOTE(14);

    private int [] columnNumbers;

    AuthorCSVColumnNumbers(int number) {
        columnNumbers = new int[1];
        columnNumbers[0] = number;
    }

    AuthorCSVColumnNumbers(int[] numbers) {
        columnNumbers = numbers;
    }

    public int[] getColumnNumbers() {
        return columnNumbers;
    }

    public int getColumnNumber() {
        return columnNumbers[0];
    }
}
