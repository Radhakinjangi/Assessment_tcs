class Character_At_Odd_Position {
    public static void main(String[] args) {
        String inputString = "Hey there!";
        printOddPositionCharacters(inputString);
    }

    public static void printOddPositionCharacters(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            System.out.println("Input string is empty.");
            return;
        }

        System.out.print("Characters at odd positions: ");
        for (int i = 0; i < inputString.length(); i++) {
            if (i % 2 != 0) {
                char character = inputString.charAt(i);
                System.out.print(character);
            }
        }
        System.out.println();
    }
}