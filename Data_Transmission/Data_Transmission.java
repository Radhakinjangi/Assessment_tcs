package Data_Transmission;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Data_Transmission {
    public static void main(String[] args) {
        String input = "233 2435 1123 109 103 4434 2347 993 880 1117 1801 991";

        // Split the input into an array of integers
        int[] numbers = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        // Calculate the result using the described logic
        int result = calculateResult(numbers);

        // Print the final answer
        System.out.println(result);
    }

    private static int calculateResult(int[] numbers) {
        int primeCount = (int) Arrays.stream(numbers)
                .filter(Data_Transmission::isPrime)
                .count();

        int[] primes = Arrays.stream(numbers)
                .filter(Data_Transmission::isPrime)
                .sorted()
                .toArray();

        int secondLargestPrime = primes[primes.length - 2];

        return primeCount + secondLargestPrime;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        return IntStream.range(2, (int) Math.sqrt(number) + 1)
                .noneMatch(i -> number % i == 0);
    }
}
