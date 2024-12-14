package utilities;
@SuppressWarnings("unused")

public class Math {
    /**
     * Returns the result of the {@code float} division {@code a/b}
     * @param a the dividend
     * @param b the divisor
     * @return the {@code float} result of the division {@code a/b}
     */
    public static double ratio(int a, int b) {
        double a_float = a * 1.0;
        double b_float = b * 1.0;
        return a_float / b_float;
    }

    /**
     * Returns if {@code sample} is a prime number
     * @param sample the {@code int} to be verified
     * @return {@code true}&nbsp;&nbsp; if the number is prime<br/>
     *         {@code false}&nbsp;      if the number isn't prime
     */
    public static boolean isPrime(int sample){
        int numeroDivisori=0;

        for(int i = 2; i <= (sample / 2) && numeroDivisori==0; i++) {
            if(sample % i == 0){
                numeroDivisori++;
            }
        }
        return (numeroDivisori == 0);
        // TRUE  -> Il numero     è primo
        // FALSE -> Il numero NON è primo
    }

    /**
     * Prints primes up to and including N
     * @param n an {@code int} number
     */
    public static void printPrimesUntil(int n){
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                System.out.print(i + ", ");
            }
        }
    }

    /**
     * Print the first N prime numbers
     * @param n an {@code int} number
     */
    public static void printFirstNPrimes(int n){
        int cont = 0;
        for (int i = 2; cont < n; i++) {
            if (isPrime(i)) {
                System.out.print(i + ", ");
                cont++;
            }
        }
    }
}
