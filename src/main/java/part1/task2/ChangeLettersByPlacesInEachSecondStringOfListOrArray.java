package part1.task2;

import java.util.Arrays;
import java.util.List;

public class ChangeLettersByPlacesInEachSecondStringOfListOrArray {
    public static void main(String[] args) {
        // Creating Arrays of String type
        String[] testStringArray = new String[] {"0ab", "cdefty", "ab", "abcdefg"};
        // Getting the list view of Array
        List<String> testArrayList = Arrays.asList(testStringArray);
        changeLettersByPlacesInEachSecondStringOfList(testStringArray);
        changeLettersByPlacesInEachSecondStringOfArray(testArrayList);
    }

    private static void changeLettersByPlacesInEachSecondStringOfList(String[] stringArray) {
        System.out.println("The original string in string array is: " + stringArray[1]);
        StringBuilder testString1 = new StringBuilder(stringArray[1]);
        testString1.setCharAt(0, '1');
        testString1.setCharAt(stringArray[1].length()-1, '4');
        System.out.println("After the first and last letters are updated, the string is updated as: " + testString1);
    }

    private static void changeLettersByPlacesInEachSecondStringOfArray(List<String> list) {
        list.set(1,"newElement");
        System.out.println("The original string in string list is: " + list.get(1));
        StringBuilder testString1 = new StringBuilder(new String(list.get(1)));
        testString1.setCharAt(0, '1');
        testString1.setCharAt(list.get(1).length()-1, '4');
        System.out.println("After the first and last letters are updated, the string is updated as: " + testString1);
    }
}

