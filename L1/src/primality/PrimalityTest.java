package primality;

/**
 * A class that indicate if the number is prime or not
 * @author Faisal Alzahrany
 */



public class PrimalityTest {


    /**
     * A method that implement algorithm to check if the number that entered is prime or not.
     */
    public static boolean isPrime(int number) {
        if (number<2){
            return false;
        }
        for (int i = 2; i<number; i++){
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
    /**
     * A main method use a loop and prompt the user to enter a number which is going to be used in isPrime method.
     */
    public static void main(String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        while (true){
            System.out.println("Enter a number (0 to quit): ");
            int number = scanner.nextInt();
            if (number<1){
                break;
            }
            if (isPrime(number)){
                System.out.println(number+ " is prime!");
            }
            else {
                System.out.println(number+ " is not prime.");
            }

        }
        System.out.println("Goodbye!");
    }

}
