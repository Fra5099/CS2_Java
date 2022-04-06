package sieve;

/**
 * A class that implement the Sieve of Eratosthenes algorithm.
 * @author Faisal Alzahrany
 */
public class SieveOfEratosthenes {
    /**
     * a method that apply the Sieve of Eratosthenes algorithm on the number that entered.
     */
    public static int[] makeSieve(int upperBound) {
        int[] prime= new int[upperBound+1];
        for (int i=0; i<=upperBound; i++){
            if (i==0 || i==1){
                prime[i]=1;
            }
            else {
                prime[i] = 0;
            }
        }
        for (int p=2; p*p<=upperBound; p++){
            if (prime[p]==0){
                for (int i= p*p; i<=upperBound; i+=p){
                    prime[i]=1;
                }
            }
        }
        return prime;
    }

    /**
     * A main method use a while loop and prompt the user to enter a number which is going to be used in makeSieve method.
     */
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Please enter an upper bound: ");
        int number = scanner.nextInt();
        int[] prime = makeSieve(number);
        while (true) {
            System.out.println("Enter a number (0 to quit): ");
            int i = scanner.nextInt();
            if (i < 1) {
                break;
            }
            if (prime[i] == 0) {
                System.out.println(i + " is prime!");
            } else {
                System.out.println(i + " is not prime.");
            }
        }
        System.out.println("Goodbye!");
    }
}
