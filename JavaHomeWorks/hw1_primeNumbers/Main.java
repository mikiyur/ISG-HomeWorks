package hw1_primeNumbers;

public class Main {
    public static void main(String[] args) {
        System.out.println("Print prime numbers 2-100: ");
        printPrimeNumbers(2,100);

        System.out.println("\n\nPrint prime mirror numbers 2-100: ");
        printPrimeMirrorNumbers(2,100);
    }

    static void printPrimeNumbers(int startNumber, int endNumber) {
        for (int i = startNumber; i <= endNumber; i++) {
            if (isPrime(i)) System.out.print(" " + i);
        }
    }

    static void printPrimeMirrorNumbers(int startNumber, int endNumber) {
        for (int i = startNumber; i <= endNumber; i++) {
            if (isPrime(i) && isPrime(reverse(i))) System.out.print(" " + i);
        }
    }

    private static boolean isPrime(int number) {
        for (int i = 2; i < Math.floor(Math.sqrt(number + 1)); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    private static int reverse(int number) {
       return Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
    }
}
