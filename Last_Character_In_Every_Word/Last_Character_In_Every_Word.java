package Last_Character_In_Every_Word;

import java.util.Arrays;

public class Last_Character_In_Every_Word {
    public static void main(String[] args) {
        String input = "Hey3 Java   Learners";

        printLastCharacterOfWords(input);
    }

    private static void printLastCharacterOfWords(String input) {
        Arrays.stream(input.split("\\s+")) 
                .filter(word -> !word.matches(".*\\d$")) 
                .map(word -> word.charAt(word.length() - 1)) 
                .forEach(System.out::print); 
    }
}