package hashing;

import java.util.ArrayList;
/**
 * A class that implement a "fairly" Good Hash Function
 * @author Faisal Alzahrany
 */
public class GoodHashFunc {

    /**
    this method compute the hash for the input that user enter
    and return the computed hash.
     */
    public static int computeHash(String input) {
        int size= input.length();
        int[] values= new int[size];
        for (int i=0; i<input.length();i++){
            int h=input.charAt(i)*(int)Math.pow(31,(size-1)-i);
            values[i]=h;
        }
        int all=0;
        int total=0;
        while (all<size){
            total=total+values[all];
            all++;
        }
        return total;
    }


    /**
    this method prompt the user to enter string and use it in computeHash function.
    In the end, it will print the computed hash.
     */
    public static void main(String[] args){
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Please enter a string: ");
        String word = scanner.nextLine();
        System.out.println("The computed hash for the specified string is: "+ computeHash(word));

    }
}
